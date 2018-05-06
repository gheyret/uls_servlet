package uls;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * <p>Title:Uyghur Komputer Yeziqi-Kona Yeziq Tor Bet Aylandurghuch </p>
 * <p>Description:Bu progiramma Uyghur Kona yeziqi da yaki UKY yeziqida Yezilghan Tor Betini Uning Ekside yezilghan tor betige Aylandurup chiqirip beridu </p>
 * @author Gheyret Tohti Kenji
 * @version 1.0
 */

/**
 * <p> Bu progirammining kirish eghizi</p>
 * Servlet qilip ishletkende deslepte init bir qetimla ijra boldu
 * andin her bir qetim yollash kunupkisi besilgahnda
 * service degendin bashlap ijra bolidu
 */

public class MainServlet extends HttpServlet {
  String errorHtml;
  ULSAylandur Aylandur;
  public void init(ServletConfig con) {
    Aylandur = new ULSAylandur("http://www.kenjisoft.com/uls/ishle?URL_NAME=");
//    System.err.println("http://www.kenjisoft.com/uls/ishle?URL_NAME=");    
//    Aylandur = new ULSAylandur("http://localhost:8080/uls/ishle?URL_NAME=");
  }

  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String url, ish,query;
    HttpSession sess = request.getSession(true);
    query=request.getQueryString();
    if(query==null){
      url=request.getParameter("URL_NAME");
    }
    else{
      int pos=query.indexOf("URL_NAME=");
      if(pos==-1){
        throw new IOException("Parameterning Terkiwide URL_NAME Degen Ozgerguchi Yoq");
      }
      else{
        url=query.substring(pos+9);
      }
    }

    if (url.charAt(0) == '"') {
      url = url.substring(1);
    }
    if(url.charAt(url.length()-1)=='"'){
      url=url.substring(0,url.length()-1);
    }
    if (url.startsWith("%22")) {
      url = url.substring(3);
    }
    if(url.endsWith("%22")){
      url=url.substring(0,url.length()-3);
    }
    ish = request.getParameter("ULS");
    if(ish!=null){
        Aylandur.setNishan(ish);
    }
    ServletOutputStream out = response.getOutputStream();
    String ret;
    try {
      if(url.indexOf("wetinim.com")!=-1){
          if(url.indexOf("mobile=")==-1){
            if(url.indexOf("?")==-1){
                url = url+"?mobile=no";
            }
            else{
                url = url+"&mobile=no";
            }
          }
      }
      ret= Aylandur.read(url);
      if(ret.toLowerCase().indexOf("text/html")!=-1)
      {
        response.setContentType("text/html; charset=UTF-8");
        ret=Aylandur.GetAylanResult();
        out.write(ret.getBytes("UTF-8"));
      }
      else
      {
        response.setContentType(ret);
        out.write(Aylandur.getContent());
        System.err.println(url);
      }
      out.flush();
      out.close();
    }
    catch (Exception ee) {
      StackTraceElement[] el = ee.getStackTrace();
      ret = ee.toString()+ee.getMessage()+"\n";
      for (int i = 0; i < el.length; i++) {
        ret += el[i].toString() + "<br>\n";
      }
      sess.setAttribute("XATALIQ", ret);
      response.sendRedirect("./xataliq.jsp");
    }
  }

  /**
   * Aylandurush netijisini deskigha saqlap qoyuish uchun ishlitilidu
   * hazirche ishlitilmidi
   */
  void SaveToFile(String newHtml) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhssmm");
    String file = "G:/work/" + sdf.format(new Date()) + ".html";
    byte[] newBuf;
    FileOutputStream of = new FileOutputStream(file);
    newBuf = newHtml.getBytes("UnicodeLittle");
    of.write(newBuf);
    of.close();
  }
}
