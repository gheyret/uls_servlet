package uls;

import java.io.*;
import java.text.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.datatransfer.*;

public class FileFrame extends JFrame implements ActionListener{
  JLabel jLabel1 = new JLabel();
  JTextField txtURL = new JTextField();
  TitledBorder titledBorder2;
  TitledBorder titledBorder4;
  JButton butStart = new JButton();
  JButton butExit = new JButton();
  ButtonGroup groupYeziq = new ButtonGroup();

  ULSAylandur      g_Uky_Kona= new ULSAylandur("");
  String           tempFile;
  JLabel jLabel2 = new JLabel();
  JTextField txtURL1 = new JTextField();
  JButton butText = new JButton();
  public FileFrame(){
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

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource().equals(this.butStart)){
      butStart_actionPerformed(e);
    }
    else if(e.getSource().equals(this.butStart)){
      this.butExit_actionPerformed(e);
    }
  }


  private void jbInit() throws Exception {
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Encode");
    titledBorder4 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Esli Betning Yeziqi");
    jLabel1.setText("File Name");
    jLabel1.setBounds(new Rectangle(6, 9, 55, 15));
    this.getContentPane().setLayout(null);
    txtURL.setText("http://www.wetinim.org/");
    txtURL.setBounds(new Rectangle(77, 8, 283, 21));
    txtURL.addActionListener(this);
    butStart.setBounds(new Rectangle(18, 66, 94, 25));
    butStart.setText("Bashla");
    butStart.addActionListener(this);
    butExit.setBounds(new Rectangle(263, 65, 94, 25));
    butExit.setText("Axirlashtur");
    butExit.addActionListener(this);
    this.setResizable(false);
    this.setState(Frame.NORMAL);
    this.setTitle("UKY yeziqi bilen Kona yeziqta Yezilghan Tor Betlirini Oz-Ara Aylandurush");
    jLabel2.setBounds(new Rectangle(6, 37, 68, 15));
    jLabel2.setText("Save Folder");
    txtURL1.addActionListener(this);
    txtURL1.setBounds(new Rectangle(77, 35, 283, 21));
    txtURL1.setText("D:\\uky");
    butText.addActionListener(this);
    butText.setText("Bashla");
    butText.addActionListener(new FileFrame_butText_actionAdapter(this));
    butText.setBounds(new Rectangle(148, 67, 94, 25));
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(txtURL1, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(txtURL, null);
    this.getContentPane().add(butStart, null);
    this.getContentPane().add(butExit, null);
    this.getContentPane().add(butText, null);
  }

  void butStart_actionPerformed(ActionEvent e) {
    String saveDir=txtURL1.getText();
    if(saveDir.endsWith("\\")==false){
      saveDir+="\\";
    }
    File sdir=new File(saveDir);
    sdir.mkdirs();
    String htmlFile=txtURL.getText();
    String saveFile=saveDir+htmlFile.substring(htmlFile.lastIndexOf("\\")+1);
    try{
      byte[] newBuf;
      String url;
      if(htmlFile.startsWith("http://")==false)
      {
        File tmp = new File(htmlFile);
        url = tmp.toURL().toString();
      }else{
        url=htmlFile;
      }

      System.setProperty("http.proxyHost", "126.100.100.12");
      System.setProperty("http.proxyPort", "8080");

      String conType=g_Uky_Kona.read(url);

      if(conType.toLowerCase().indexOf("text/html")!=-1)
      {
	String newHtml = g_Uky_Kona.GetAylanResult(ULSAylandur.U_US);
	newBuf=newHtml.getBytes("UnicodeLittle");
      }
      else
      {
	newBuf=g_Uky_Kona.getContent();
      }
      // Hojjetke yazidu
      FileOutputStream of=new FileOutputStream("D:/gheyret/wetinim.html");
      of.write(newBuf);
      of.close();
      Runtime rt=Runtime.getRuntime();
      try{
        Process pr = rt.exec("rundll32 url.dll,FileProtocolHandler "+"D:/gheyret/wetinim.html");
      }catch(Exception ee){
        ShowMessage("Browserde Korsitishte Xataliq Koruldi.\nXataliq Uchuri:\n"+ee.getMessage());
      }
    }catch(Exception ee){
      ShowMessage("Aylandurup Deskigha Saqlashta Xataliq Koruldi.\nXataliq Uchuri:\n"+ee.getMessage());
      ee.printStackTrace();
      return;
    }
  }

  void butExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }

  void butText_actionPerformed(ActionEvent e) {
    String uyg="Xelq'araliq Axbarat Wasitiliride Türkchining Ishlitishlishi";
    Aylandurghuch ay=new Aylandurghuch();
    String str=ay.StrLatinToUyghur(uyg);
    System.out.println(str);
    SaveToCLipBoard(str);
  }

  public static void SaveToCLipBoard(String buf)
  {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection contents = new StringSelection( buf.toString() );
    clipboard.setContents(contents, null );
  }


}

class FileFrame_butText_actionAdapter implements java.awt.event.ActionListener {
  FileFrame adaptee;

  FileFrame_butText_actionAdapter(FileFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.butText_actionPerformed(e);
  }
}
