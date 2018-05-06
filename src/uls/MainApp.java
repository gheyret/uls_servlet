package uls;

import javax.swing.*;

/**
 * <p>Title:Uyghur Komputer Yeziqi-Kona Yeziq Tor Bet Aylandurghuch </p>
 * <p>Description:Bu progiramma Uyghur Kona yeziqi da yaki UKY yeziqida Yezilghan Tor Betini Uning Ekside yezilghan tor betige Aylandurup chiqirip beridu </p>
 * @author Gheyret Tohti Kenji
 * @version 1.0
 */

 /**
  * <p> Bu Application Qilip ishletkendiki progirammining kirish eghizi</p>
  * main din bashlap ijra bolidu
  */

public class MainApp
{
  public static void main(String[] args) {
      byte[] Buf=null;
      String src=null;
      try {
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch(Exception e) {
	e.printStackTrace();
      }
      FileFrame frm=new FileFrame();
      frm.setResizable(true);
      frm.setSize(371,150);
      frm.setResizable(false);
      frm.setVisible(true);
  }
}
