package uls;

import java.io.*;
import java.text.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AsasiRamka extends JFrame {
  JLabel jLabel1 = new JLabel();
  JTextField txtURL = new JTextField();
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder2;
  JRadioButton rdKonaYeziq = new JRadioButton();
  JRadioButton rdUky = new JRadioButton();
  TitledBorder titledBorder4;
  JButton butStart = new JButton();
  JButton butExit = new JButton();
  ButtonGroup groupYeziq = new ButtonGroup();

  ULSAylandur g_Uky_Kona= new ULSAylandur("");
  String           tempFile;
  public AsasiRamka(){
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception ee) {
      ShowMessage("Xataliq Koruldi.\nXataliq Uchuri:\n"+ee.getMessage());
    }
  }

  public void ShowMessage(String Message){
    JOptionPane.showMessageDialog(this, Message,"Hataliq Uchuri", JOptionPane.ERROR_MESSAGE);
  }
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  private void jbInit() throws Exception {
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Encode");
    titledBorder4 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Esli Betning Yeziqi");
    jLabel1.setText("Url");
    jLabel1.setBounds(new Rectangle(6, 9, 27, 15));
    this.getContentPane().setLayout(null);
//    txtURL.setText("http://www.misran.com/");
//    txtURL.setText("file:/D:/gheyret/biliwal.html");
    txtURL.setText("http://www.biliwal.com/");
//    txtURL.setText("file:///E:/hayrat/Unicode/download.html");
//    txtURL.setText("http://uyghuredit.oyghan.com/uyghuredit/ukyindex.html");
//    txtURL.setText("http://www.misiran.com/uyghurlar/til_yeziq/yeziq_tarixi.htm");
    txtURL.setBounds(new Rectangle(27, 8, 333, 21));
    jPanel1.setBorder(titledBorder4);
    jPanel1.setBounds(new Rectangle(23, 33, 339, 45));
    jPanel1.setLayout(null);
    rdKonaYeziq.setEnabled(false);
    rdKonaYeziq.setText("Kona Yeziq");
    rdKonaYeziq.setBounds(new Rectangle(233, 17, 91, 20));
    rdUky.setBounds(new Rectangle(9, 17, 166, 20));
    rdUky.setSelected(true);
    rdUky.setText("Uyghur Kompyuter Yeziqi");
    butStart.setBounds(new Rectangle(157, 88, 94, 25));
    butStart.setText("Bashla");
    butStart.addActionListener(new GuiTest_butStart_actionAdapter(this));
    butExit.setBounds(new Rectangle(267, 88, 94, 25));
    butExit.setText("Axirlashtur");
    butExit.addActionListener(new AsasiRamka_butExit_actionAdapter(this));
    this.setResizable(false);
    this.setState(Frame.NORMAL);
    this.setTitle("UKY yeziqi bilen Kona yeziqta Yezilghan Tor Betlirini Oz-Ara Aylandurush");
    jPanel1.add(rdUky, null);
    jPanel1.add(rdKonaYeziq, null);
    this.getContentPane().add(butStart, null);
    this.getContentPane().add(butExit, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(txtURL, null);
    this.getContentPane().add(jPanel1, null);
    groupYeziq.add(rdKonaYeziq);
    groupYeziq.add(rdUky);
  }

  void butStart_actionPerformed(ActionEvent e) {
    String dir="C:/tmp/";
    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    String file=dir+sdf.format(new Date());
    String conType;
    String path=this.txtURL.getText();
    try{
      byte[] newBuf;
      conType=g_Uky_Kona.read(path);
      if(conType.toLowerCase().indexOf("text/html")!=-1)
      {
        String newHtml = g_Uky_Kona.GetAylanResult(ULSAylandur.U_LS);
        newBuf=newHtml.getBytes("UnicodeLittle");
        file+=".html";
      }
      else
      {
        newBuf=g_Uky_Kona.getContent();
        int pos=path.lastIndexOf(".");
        if(pos!=-1)
        {
          file+=path.substring(pos);
        }
      }
      // Hojjetke yazidu
      File fl=new File(dir);
      fl.mkdirs();
      FileOutputStream of=new FileOutputStream(file);
      of.write(newBuf);
      of.close();
    }catch(Exception ee){
      ShowMessage("Aylandurup Deskigha Saqlashta Xataliq Koruldi.\nXataliq Uchuri:\n"+ee.getMessage());
      ee.printStackTrace();
      return;
    }
    Runtime rt=Runtime.getRuntime();
    try{
      Process pr = rt.exec("rundll32 url.dll,FileProtocolHandler "+file);
    }catch(Exception ee){
      ShowMessage("Browserde Korsitishte Xataliq Koruldi.\nXataliq Uchuri:\n"+ee.getMessage());
    }
  }

  void butExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}

class GuiTest_butStart_actionAdapter implements java.awt.event.ActionListener {
  AsasiRamka adaptee;
  GuiTest_butStart_actionAdapter(AsasiRamka adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.butStart_actionPerformed(e);
  }
}

class AsasiRamka_butExit_actionAdapter implements java.awt.event.ActionListener {
  AsasiRamka adaptee;

  AsasiRamka_butExit_actionAdapter(AsasiRamka adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.butExit_actionPerformed(e);
  }
}
