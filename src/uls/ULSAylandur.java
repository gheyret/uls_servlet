package uls;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class ULSAylandur
{
  public static String U_UL="UL";
  public static String U_US="US";
  public static String U_LU="LU";
  public static String U_LS="LS";

  private String    U_Ish="";
  private char      U_tagStart='<';
  private char      U_tagEnd='>';

  private Vector    U_spVec=new Vector();
  private           Aylandurghuch U_Aylan;

  private String     U_Urlname="";

  private String     U_UrlPath="";

  private String     U_Terjiman="";
//  private String     U_Fonts="\"UKIJ Tuz Tom, UKIJ Tor, Boghda Tuz,Arial Unicode MS,Tahoma\"";
//  private String     U_Style="<style type=\"text/css\">\n<!--\nBODY,TABLE,P,DIV,INPUT, TEXTAREA,SELECT,FORM,SPAN{ font-family: \"Boghda Tuz\";}\n-->\n</style>";
//  private String     U_Style="\n<style type=\"text/css\">\n<!--\n.uyg\n{\n\tfont-family: " + U_Fonts +";\n\tfont-size: medium;\n}\n"+"body, th, td {\n\tfont-family: "+U_Fonts+";\n\tfont-size: medium;\n}\n-->\n</style>\n";
//  private String     UKONASpan_BASH="<SPAN DIR=RTL class=\"uyg\">";
  private String     UKONASpan_BASH="<SPAN DIR=RTL style=\"font-family: UKIJ Tuz Tom, UKIJ Tor, Boghda Tuz;\">";
  private String     UKONASpan_AXIRI="</SPAN>";

  private SimpleDateFormat m_Sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

  private byte[] U_Buffer=null;
  private String U_Encode="";

  public ULSAylandur(String terjiman)
  {
    U_Terjiman=terjiman;
    U_Aylan=new Aylandurghuch();
    setMuqimSozler();
  }
  
  public void setNishan(String ish){
      if(U_UL.equals(ish)||U_US.equals(ish)||U_LU.equals(ish)||U_LS.equals(ish)){
          U_Ish=ish;
      }
      else{
          U_Ish="";
      }
  }
  
  public byte[] getContent(){
    return U_Buffer;
  }

  public String read(String URL) throws Exception
  {
    String strUrl;
    URL srcURL;
    URLConnection con;
    U_Urlname=URL;
    strUrl=URL;
    try{
      srcURL=new URL(strUrl);
      U_UrlPath=srcURL.getProtocol()+"://"+srcURL.getHost();
      String tmp=srcURL.getFile();
      U_UrlPath+=getPath(tmp);
      int len;
      con = srcURL.openConnection();
      con.connect();
      BufferedInputStream in = new BufferedInputStream(con.getInputStream());
      ByteArrayOutputStream bos=new ByteArrayOutputStream();
      byte[] tmpBuf=new byte[4096];
      int sum=0;
      while(true){
	len=in.read(tmpBuf);
	if(len==-1) break;
	bos.write(tmpBuf,0,len);
      }
      in.close();
      U_Buffer=bos.toByteArray();
      return con.getContentType();
    }catch(Exception ee){
      throw ee;
    }
  }

  public String GetAylanResult(String ish) throws Exception
  {
      setNishan(ish);
      return GetAylanResult();
  }
  
  public String GetAylanResult() throws Exception
  {
    int len=0;
    String srcHtml="";
    try{
      if(U_Buffer[0]==-17 && U_Buffer[1]==-69&& U_Buffer[2]==-65){
	U_Encode="UTF-8";
	len=3;
      }
      else if(U_Buffer[0]==-1 && U_Buffer[1]==-2){
	U_Encode="UTF-16LE";
	len=2;
      }
      else if(U_Buffer[0]==-2 && U_Buffer[1]==-1){
	U_Encode="UTF-16BE";
	len=2;
      }
      else{
	U_Encode=getEncode(U_Buffer);
      }
      if(U_Encode==null){
	U_Encode="UTF-8";
      }

      System.err.println("Hazirqi Bet : " + U_Urlname + "  Char Set = "+U_Encode + " ULS = " + U_Ish);

      srcHtml=new String(U_Buffer,len,U_Buffer.length-len,U_Encode);
      return Aylandur(srcHtml, U_Ish);
    }catch(Exception ee){
      throw ee;
    }
  }


  private String getEncode(byte[] buffer)
  {
    String encode=null;
    String src=new String(buffer).toLowerCase();
    String metaStr="";
    int posS=0;
    int posE=0;
    boolean err=true;
    while(true){
      posS=src.indexOf("<meta ",posE);
      if(posS==-1) break;
      posE=src.indexOf(">",posS);
      if(posE==-1) break;
      metaStr=src.substring(posS,posE+1);
      posS=metaStr.indexOf("charset");
      if(posS!=-1)
      {
	err=false;
	break;
      }
    }
    if(err==false)
    {
      posS+=7;
      char Herp;
      try{
	while (true)
	{
	  Herp=metaStr.charAt(posS++);
	  if(Herp=='=') break;
	}
	posE=posS;
	while(true){
	  Herp=metaStr.charAt(posE);
	  if(Herp=='"'||Herp=='>') break;
	  posE++;
	}
	if(posE>posS){
	  encode=metaStr.substring(posS,posE);
	}
      }catch(Exception ee){
	encode=null;
      }
    }
    return encode;
  }

  private String getPath(String path)
  {
    String ret="";
    int len=path.length();
    if(len==0) return ret;
    if(path.charAt(len-1)=='/')
    {
      path=path.substring(0,len-1);
    }
    int pos=path.lastIndexOf('/');
    String file;
    if(pos>=0)
    {
      file=path.substring(pos);
      if(file.indexOf('.')>0)
      {
	ret=path.substring(0,pos);
      }
      else
      {
	ret=path;
      }
    }
    return ret;
  }


  private String Aylandur(String htmltxt, String ish)
  {
    String ret;
    SplitHtml(htmltxt);
    if (ish.equals(U_UL)) {
       ret = UyghurToLatin();
    }
    else if (ish.equals(U_LU)) {
       ret = LatinToUyghur();
    }
    else if (ish.equals(U_LS)) {
       ret = LatinToSlawiyan();
    }else if(ish.equals(U_US)){
       ret = UyghurToSlawiyan();
    }
    else{
      ret=htmltxt;
    }
    return ret;
  }

  private String LatinToUyghur()
  {
    StringBuffer html=new StringBuffer();
    HtmlDataBean data;
    String text;
    boolean preTitle=false;
    for(int i=0;i<this.U_spVec.size();i++)
    {
      data=(HtmlDataBean)U_spVec.elementAt(i);
      if(data.isHtmlTag()){
        if(data.isTag("TITLE")){
            preTitle=true;
        }else{
            preTitle=false;
        }

	if(data.isTag("/HEAD")){
	  data.append("\n");
	}
        else if(data.isTag("HTML")||data.isTag("BODY")||data.isTag("P") || data.isTag("DIV") || data.isTag("SPAN")||data.isTag("TD")||data.isTag("UL")||data.isTag("DL"))
        {
          data.replaceAttribute("align","left","right");
          data.setAttribute("DIR","RTL");
        }
        UpdateSrc(data);

	html.append(data.getText().toString());
	if(data.isEndTag()){
	   html.append("\n");
	}
      }
      else{
        if(preTitle)
        {
           html.append(data.toString());
        }
        else
        {
            text= U_Aylan.StrLatinToUyghur(data.toString());
            html.append(UKONASpan_BASH + text + UKONASpan_AXIRI);
        }
      }
    }
    return html.toString();
  }

  private String UyghurToLatin()
  {
    String id;
    StringBuffer html=new StringBuffer();
    HtmlDataBean data;
    for(int i=0;i<this.U_spVec.size();i++)
    {
      data=(HtmlDataBean)U_spVec.elementAt(i);
      if(data.isHtmlTag()){
        data.delAttribute("DIR");
        if(data.isTag("HTML") || data.isTag("BODY")||data.isTag("P") || data.isTag("DIV") || data.isTag("SPAN")||data.isTag("TD")||data.isTag("UL"))
        {
          data.replaceAttribute("align","right","left");
          data.setAttribute("DIR","LTR");
        }
	UpdateSrc(data);
	html=html.append(data.getText().toString());
	if(data.isEndTag()){
	   html = html.append("\n");
	}
      }
      else{
	html=html.append(U_Aylan.StrUyghurToLatin(data.toString())+" ");
      }
    }
    return html.toString();
  }

  private String UyghurToSlawiyan()
  {
    String id;
    StringBuffer html=new StringBuffer();
    HtmlDataBean data;
    for(int i=0;i<this.U_spVec.size();i++)
    {
      data=(HtmlDataBean)U_spVec.elementAt(i);
      if(data.isHtmlTag()){
        data.delAttribute("DIR");
        if(data.isTag("HTML") || data.isTag("BODY")||data.isTag("P") || data.isTag("DIV") || data.isTag("SPAN")||data.isTag("TD")||data.isTag("UL"))
        {
          data.replaceAttribute("align","right","left");
          data.setAttribute("DIR","LTR");
        }
        UpdateSrc(data);
        html=html.append(data.getText().toString());
        if(data.isEndTag()){
           html = html.append("\n");
        }
      }
      else{
        html=html.append(U_Aylan.StrUyghurToSlawiyan(data.toString())+" ");
      }
    }
    return html.toString();
  }

  private String LatinToSlawiyan()
  {
    String id;
    StringBuffer html=new StringBuffer();
    HtmlDataBean data;
    for(int i=0;i<this.U_spVec.size();i++)
    {
      data=(HtmlDataBean)U_spVec.elementAt(i);
      if(data.isHtmlTag()){
        UpdateSrc(data);
        html.append(data.getText().toString());
        if(data.isEndTag()){
           html.append("\n");
        }
      }
      else{
        html.append(U_Aylan.StrLatinToSlawiyan(data.toString()));
      }
    }
    return html.toString();
  }

  private void UpdateSrc(HtmlDataBean data)
  {
    if(data.isTag("IMG")){
      data.updateAttribute("SRC",U_UrlPath);
    }else if(data.isTag("LINK")){
      data.updateAttribute("HREF",U_UrlPath);
    }else if(data.isTag("BODY") || data.isTag("TD")|| data.isTag("TABLE")){
      data.updateAttribute("BACKGROUND",U_UrlPath);
    }else if(data.isTag("A")){
      data.updateAttribute("HREF",U_UrlPath,this.U_Terjiman);
    }else if(data.isTag("FRAME")){
      data.updateAttribute("SRC",U_UrlPath,this.U_Terjiman);
    }else if(data.isTag("FORM")){
      data.updateAttribute("ACTION",U_UrlPath,this.U_Terjiman);
    }else if(data.isTag("EMBED")){
      data.updateAttribute("SRC",U_UrlPath);
    }else if(data.isTag("SCRIPT")){
      data.updateAttribute("SRC",U_UrlPath);
    }else if(data.isTag("STYLE")){
      data.updateStyle(U_UrlPath);
    }
    return;
  }


  private void SplitHtml(String srcHtml)
  {
    char Herp;
    HtmlDataBean data=null;
    U_spVec.clear();
    int endPos;
    String tmp;
    StringBuffer tagBuf=new StringBuffer();
    String tmpStr=srcHtml.toLowerCase();
    int lenStr=srcHtml.length();
    int i=0;
    while(i<lenStr)
    {
      Herp=srcHtml.charAt(i++);
      if(Herp=='\u0000') continue;
      if(Herp==U_tagStart){
	if(data!=null){
	  if(data.toString().trim().length()>0)
	  {
	    U_spVec.add(data);
	  }
	  data=new HtmlDataBean();
	  data.setHtml(true);
	}
	else{
	  data=new HtmlDataBean();
	  data.setHtml(true);
	}
	data.append(Herp);
	if(tmpStr.startsWith("script",i)){
	  endPos = tmpStr.indexOf("</script>", i);
	  if (endPos != -1) {
	    tmp = srcHtml.substring(i, endPos + 9);
	    data.append(tmp);
	    i = endPos + 9;
	    continue;
	  }
	}

	if(tmpStr.startsWith("style",i)){
	  endPos = tmpStr.indexOf("</style>", i);
	  if (endPos != -1) {
	    tmp = srcHtml.substring(i, endPos + 8);
	    data.append(tmp);
	    i = endPos + 8;
	    continue;
	  }
	}

	if(srcHtml.startsWith("!--",i))
	{
	  endPos = srcHtml.indexOf("-->", i);
	  if (endPos != -1) {
	    tmp = srcHtml.substring(i, endPos + 3);
	    data.append(tmp);
	    i = endPos + 3;
	    continue;
	  }
	}
      }
      else if(Herp==U_tagEnd){
	if(data==null){
	  data=new HtmlDataBean();
	}
	data.append(Herp);
	U_spVec.add(data);
	data=null;
      }
      else{
	if (data == null) {
	  data = new HtmlDataBean();
	  data.setHtml(false);
	}
	data.append(Herp);
      }
    }
  }



  private void setMuqimSozler()
  {
    HashSet MuqimSozler=new HashSet();
    MuqimSozler.add("UKY");
    MuqimSozler.add("UKIJ");
    MuqimSozler.add("WINDOWS");
    MuqimSozler.add("WINDOWS95");
    MuqimSozler.add("WINDOWS98");
    MuqimSozler.add("WINDOWSME");
    MuqimSozler.add("WINDOWSXP");
    MuqimSozler.add("WINDOWS2000");
    MuqimSozler.add("WINDOWSNT");
    MuqimSozler.add("MSDOS");
    MuqimSozler.add("DOS");
    MuqimSozler.add("UYGHUREDIT");
    MuqimSozler.add("UNICODE");
    MuqimSozler.add("FONT");
    MuqimSozler.add("WIN2000");
    MuqimSozler.add("WIN95");
    MuqimSozler.add("WIN98");
    MuqimSozler.add("WINME");
    MuqimSozler.add("WINXP");
    MuqimSozler.add("FAQ");
    MuqimSozler.add("AM");
    MuqimSozler.add("PM");
    MuqimSozler.add("SUN");
    MuqimSozler.add("MICROSOFT");
    MuqimSozler.add("ORACLE");
    MuqimSozler.add("JAVA");
    MuqimSozler.add("SERVLET");
    MuqimSozler.add("ASP");
    MuqimSozler.add("NET");
    MuqimSozler.add("PERL");
    MuqimSozler.add("PHP");
    MuqimSozler.add("CGI");
    MuqimSozler.add("BASIC");
    MuqimSozler.add("C++");
    MuqimSozler.add("APPLICATION");
    MuqimSozler.add("INTERNETEXPLORER");
    MuqimSozler.add("EXPLORER");
    MuqimSozler.add("INSTALLER");
    MuqimSozler.add("WELCOME");
    MuqimSozler.add("TO");
    MuqimSozler.add("FROM");
    MuqimSozler.add("PHP-NUKE");
    MuqimSozler.add("MONDAY");
    MuqimSozler.add("TUESDAY");
    MuqimSozler.add("WEDNESDAY");
    MuqimSozler.add("THURSDAY");
    MuqimSozler.add("FRIDAY");
    MuqimSozler.add("SUNDAY");
    MuqimSozler.add("SATURDAY");
    MuqimSozler.add("WEB");
    MuqimSozler.add("SITE");
    MuqimSozler.add("ENGINE");
    MuqimSozler.add("ENGINES");
    MuqimSozler.add("CODE");
    MuqimSozler.add("COPYRIGHT");
    MuqimSozler.add("ALL");
    MuqimSozler.add("RIGHTS");
    MuqimSozler.add("RESERVED");
    MuqimSozler.add("FREE");
    MuqimSozler.add("SOFTWARE");
    MuqimSozler.add("UNDER");
    MuqimSozler.add("THE");
    MuqimSozler.add("RELEASED");
    MuqimSozler.add("LICENSE");
    MuqimSozler.add("THEME");
    MuqimSozler.add("STYLE");
    MuqimSozler.add("PHPBB2");
    MuqimSozler.add("PHPIB2");
    MuqimSozler.add("IS");
    MuqimSozler.add("AN");
    MuqimSozler.add("BY");
    MuqimSozler.add("CREATE");
    MuqimSozler.add("ACCOUNT");
    MuqimSozler.add("LOGOS");
    MuqimSozler.add("OR");
    MuqimSozler.add("MTV");
    MuqimSozler.add("BBC");
    MuqimSozler.add("BBS");
    MuqimSozler.add("RFA");
    String line;
    try{
      InputStream in=this.getClass().getResourceAsStream("sozler.txt");
      InputStreamReader rd=new InputStreamReader(in,"iso-8859-1");
      BufferedReader brd=new BufferedReader(rd);
      while((line=brd.readLine())!=null){
	MuqimSozler.add(line.toUpperCase());
      }
    }
    catch(Exception ee){
      System.err.println("Turaqliq Sozlerni Oqushta Xataliq Koruldi, "+ee.getLocalizedMessage());
    }
    this.U_Aylan.setMuqimSozler(MuqimSozler);
  }
}
