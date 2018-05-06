package uls;
import java.util.*;

/**
 * Bu Class UKY bilen Kono yeziqni birbirige aylandurush uchun ishlitilidu
 */

public class Aylandurghuch {
  final static int U_6 = 0;
  final static int U_YALGHUZ = 1;
  final static int U_BASH = 2;
  final static int U_OTTURA = 3;
  final static int U_AYAQ = 4;

  final static int UYGIN_A = 0;
  final static int UYGIN_E = 1;
  final static int UYGIN_B = 2;
  final static int UYGIN_P = 3;
  final static int UYGIN_T = 4;
  final static int UYGIN_J = 5;
  final static int UYGIN_CH = 6;
  final static int UYGIN_X = 7;
  final static int UYGIN_D = 8;
  final static int UYGIN_R = 9;
  final static int UYGIN_Z = 10;
  final static int UYGIN_ZZ = 11;
  final static int UYGIN_S = 12;
  final static int UYGIN_SH = 13;
  final static int UYGIN_GH = 14;
  final static int UYGIN_F = 15;
  final static int UYGIN_Q = 16;
  final static int UYGIN_K = 17;
  final static int UYGIN_G = 18;
  final static int UYGIN_NG = 19;
  final static int UYGIN_L = 20;
  final static int UYGIN_M = 21;
  final static int UYGIN_N = 22;
  final static int UYGIN_H = 23;
  final static int UYGIN_O = 24;
  final static int UYGIN_U = 25;
  final static int UYGIN_OO = 26;
  final static int UYGIN_UU = 27;
  final static int UYGIN_W = 28;
  final static int UYGIN_EE = 29;
  final static int UYGIN_I = 30;
  final static int UYGIN_Y = 31;
  final static int UYGIN_LA = 32;
  final static int UYGIN_HM = 33;

  char[][] UYG_Unicode = new char[34][5];
  boolean[] UYG_Ulinish = new boolean[34]; //Buning keynidin kelgen heripler ulinalamdu

  char[][] UKY_Unicode = new char[34][2];
  int KICHIK = 0;
  int CHONG = 1;

// Uyghurce Unicode (kona yeziq heriplerning Unicodesi)
//A
  final static char UYG_UN_A_6 = 0x0627; //Yalghuz
  final static char UYG_UN_A_Y = 0xFE8D; //Yalghuz
  final static char UYG_UN_A_A = 0xFE8E; //Ayaq
  // E Heripi
  final static char UYG_UN_E_6 = 0x06D5; //Yalghuz;
  final static char UYG_UN_E_Y = 0xFEE9; //Yalghuz;
  final static char UYG_UN_E_A = 0xFEEA; //Ayaq;
  // B
  final static char UYG_UN_B_6 = 0x0628; //Yalghuz;
  final static char UYG_UN_B_Y = 0xFE8F; //Yalghuz;
  final static char UYG_UN_B_A = 0xFE90; //Ayaq;
  final static char UYG_UN_B_B = 0xFE91; //Bax;
  final static char UYG_UN_B_O = 0xFE92; //Ottura;
  //P
  final static char UYG_UN_P_6 = 0x067E; //Yalghuz;
  final static char UYG_UN_P_Y = 0xFB56; //Yalghuz;
  final static char UYG_UN_P_A = 0xFB57; //Ayaq;
  final static char UYG_UN_P_B = 0xFB58; //Bax;
  final static char UYG_UN_P_O = 0xFB59; //Ottura;
  //T
  final static char UYG_UN_T_6 = 0x062A; //Yalghuz;
  final static char UYG_UN_T_Y = 0xFE95; //Yalghuz;
  final static char UYG_UN_T_A = 0xFE96; //Ayaq;
  final static char UYG_UN_T_B = 0xFE97; //Bax;
  final static char UYG_UN_T_O = 0xFE98; //Ottura;
  //J
  final static char UYG_UN_J_6 = 0x062C; //Yalghuz;
  final static char UYG_UN_J_Y = 0xFE9D; //Yalghuz;
  final static char UYG_UN_J_A = 0xFE9E; //Ayaq;
  final static char UYG_UN_J_B = 0xFE9F; //Bax;
  final static char UYG_UN_J_O = 0xFEA0; //Ottura;
  //Ch
  final static char UYG_UN_CH_6 = 0x0686; //Yalghuz;
  final static char UYG_UN_CH_Y = 0xFB7A; //Yalghuz;
  final static char UYG_UN_CH_A = 0xFB7B; //Ayaq;
  final static char UYG_UN_CH_B = 0xFB7C; //Bax;
  final static char UYG_UN_CH_O = 0xFB7D; //Ottura;
  //X
  final static char UYG_UN_X_6 = 0x062E; //Yalghuz;
  final static char UYG_UN_X_Y = 0xFEA5; //Yalghuz;
  final static char UYG_UN_X_A = 0xFEA6; //Ayaq;
  final static char UYG_UN_X_B = 0xFEA7; //Bax;
  final static char UYG_UN_X_O = 0xFEA8; //Ottura;
  //D
  final static char UYG_UN_D_6 = 0x062F; //Yalghuz;
  final static char UYG_UN_D_Y = 0xFEA9; //Yalghuz;
  final static char UYG_UN_D_A = 0xFEAA; //Ayaq;
  //R
  final static char UYG_UN_R_6 = 0x0631; //Yalghuz;
  final static char UYG_UN_R_Y = 0xFEAD; //Yalghuz;
  final static char UYG_UN_R_A = 0xFEAE; //Ayaq;
  //Z
  final static char UYG_UN_Z_6 = 0x0632; //Yalghuz;
  final static char UYG_UN_Z_Y = 0xFEAF; //Yalghuz;
  final static char UYG_UN_Z_A = 0xFEB0; //Ayaq;
  //Z..
  final static char UYG_UN_ZZ_6 = 0x0698; //Yalghuz;
  final static char UYG_UN_ZZ_Y = 0xFB8A; //Yalghuz;
  final static char UYG_UN_ZZ_A = 0xFB8B; //Ayaq;
  //S
  final static char UYG_UN_S_6 = 0x0633; //Yalghuz;
  final static char UYG_UN_S_Y = 0xFEB1; //Yalghuz;
  final static char UYG_UN_S_A = 0xFEB2; //Ayaq;
  final static char UYG_UN_S_B = 0xFEB3; //Bax;
  final static char UYG_UN_S_O = 0xFEB4; //Ottura;
  //SH
  final static char UYG_UN_SH_6 = 0x0634; //Yalghuz;
  final static char UYG_UN_SH_Y = 0xFEB5; //Yalghuz;
  final static char UYG_UN_SH_A = 0xFEB6; //Ayaq;
  final static char UYG_UN_SH_B = 0xFEB7; //Bax;
  final static char UYG_UN_SH_O = 0xFEB8; //Ottura;
  //GH
  final static char UYG_UN_GH_6 = 0x063A; //Yalghuz;
  final static char UYG_UN_GH_Y = 0xFECD; //Yalghuz;
  final static char UYG_UN_GH_A = 0xFECE; //Ayaq;
  final static char UYG_UN_GH_B = 0xFECF; //Bax;
  final static char UYG_UN_GH_O = 0xFED0; //Ottura;
  //F
  final static char UYG_UN_F_6 = 0x0641; //Yalghuz;
  final static char UYG_UN_F_Y = 0xFED1; //Yalghuz;
  final static char UYG_UN_F_A = 0xFED2; //Ayaq;
  final static char UYG_UN_F_B = 0xFED3; //Bax;
  final static char UYG_UN_F_O = 0xFED4; //Ottura;
  //Q;
  final static char UYG_UN_Q_6 = 0x0642; //Yalghuz;
  final static char UYG_UN_Q_Y = 0xFED5; //Yalghuz;
  final static char UYG_UN_Q_A = 0xFED6; //Ayaq;
  final static char UYG_UN_Q_B = 0xFED7; //Bax;
  final static char UYG_UN_Q_O = 0xFED8; //Ottura;
  //K
  final static char UYG_UN_K_6 = 0x0643; //Yalghuz;
  final static char UYG_UN_K_Y = 0xFED9; //Yalghuz;
  final static char UYG_UN_K_A = 0xFEDA; //Ayaq;
  final static char UYG_UN_K_B = 0xFEDB; //Bax;
  final static char UYG_UN_K_O = 0xFEDC; //Ottura;
  //G
  final static char UYG_UN_G_6 = 0x06AF; //Yalghuz;
  final static char UYG_UN_G_Y = 0xFB92; //Yalghuz;
  final static char UYG_UN_G_A = 0xFB93; //Ayaq;
  final static char UYG_UN_G_B = 0xFB94; //Bax;
  final static char UYG_UN_G_O = 0xFB95; //Ottura;
  //NG
  final static char UYG_UN_NG_6 = 0x06AD; //Yalghuz;
  final static char UYG_UN_NG_Y = 0xFBD3; //Yalghuz;
  final static char UYG_UN_NG_A = 0xFBD4; //Ayaq;
  final static char UYG_UN_NG_B = 0xFBD5; //Bax;
  final static char UYG_UN_NG_O = 0xFBD6; //Ottura;
  //L
  final static char UYG_UN_L_6 = 0x0644; //Yalghuz;
  final static char UYG_UN_L_Y = 0xFEDD; //Yalghuz;
  final static char UYG_UN_L_A = 0xFEDE; //Ayaq;
  final static char UYG_UN_L_B = 0xFEDF; //Bax;
  final static char UYG_UN_L_O = 0xFEE0; //Ottura;
  //M
  final static char UYG_UN_M_6 = 0x0645; //Yalghuz;
  final static char UYG_UN_M_Y = 0xFEE1; //Yalghuz;
  final static char UYG_UN_M_A = 0xFEE2; //Ayaq;
  final static char UYG_UN_M_B = 0xFEE3; //Bax;
  final static char UYG_UN_M_O = 0xFEE4; //Ottura;
  //N
  final static char UYG_UN_N_6 = 0x0646; //Yalghuz;
  final static char UYG_UN_N_Y = 0xFEE5; //Yalghuz;
  final static char UYG_UN_N_A = 0xFEE6; //Ayaq;
  final static char UYG_UN_N_B = 0xFEE7; //Bax;
  final static char UYG_UN_N_O = 0xFEE8; //Ottura;
  //H..
  final static char UYG_UN_H_6 = 0x06BE; //Yalghuz;
  final static char UYG_UN_H_Y = 0xFBAA; //Yalghuz;
  final static char UYG_UN_H_A = 0xFBAB; //Ayaq;
  final static char UYG_UN_H_B = 0xFBAC; //Bax;
  final static char UYG_UN_H_O = 0xFBAD; //Ottura;

  //O
  final static char UYG_UN_O_6 = 0x0648; //Yalghuz;
  final static char UYG_UN_O_Y = 0xFEED; //Yalghuz;
  final static char UYG_UN_O_A = 0xFEEE; //Ayaq;
  //U
  final static char UYG_UN_U_6 = 0x06C7; //Yalghuz;
  final static char UYG_UN_U_Y = 0xFBD7; //Yalghuz;
  final static char UYG_UN_U_A = 0xFBD8; //Ayaq;
  //O..
  final static char UYG_UN_OO_6 = 0x06C6; //Yalghuz;
  final static char UYG_UN_OO_Y = 0xFBD9; //Yalghuz;
  final static char UYG_UN_OO_A = 0xFBDA; //Ayaq;
  //U..
  final static char UYG_UN_UU_6 = 0x06C8; //Yalghuz;
  final static char UYG_UN_UU_Y = 0xFBDB; //Yalghuz;
  final static char UYG_UN_UU_A = 0xFBDC; //Ayaq;
  //W
  final static char UYG_UN_W_6 = 0x06CB; //Yalghuz;
  final static char UYG_UN_W_Y = 0xFBDE; //Yalghuz;
  final static char UYG_UN_W_A = 0xFBDF; //Ayaq;
  //E..
  final static char UYG_UN_EE_6 = 0x06D0; //Yalghuz;
  final static char UYG_UN_EE_Y = 0xFBE4; //Yalghuz;
  final static char UYG_UN_EE_A = 0xFBE5; //Ayaq;
  final static char UYG_UN_EE_B = 0xFBE6; //Bax;
  final static char UYG_UN_EE_O = 0xFBE7; //Ottura;
  //I
  final static char UYG_UN_I_6 = 0x0649; //Yalghuz;
  final static char UYG_UN_I_Y = 0xFEEF; //Yalghuz;
  final static char UYG_UN_I_A = 0xFEF0; //Ayaq;
  final static char UYG_UN_I_B = 0xFBE8; //Bax;
  final static char UYG_UN_I_O = 0xFBE9; //Ottura;
  //Y
  final static char UYG_UN_Y_6 = 0x064A; //Yalghuz;
  final static char UYG_UN_Y_Y = 0xFEF1; //Yalghuz;
  final static char UYG_UN_Y_A = 0xFEF2; //Ayaq;
  final static char UYG_UN_Y_B = 0xFEF3; //Bax;
  final static char UYG_UN_Y_O = 0xFEF4; //Ottura;

//La
  final static char UYG_UN_LA_6 = 0xFEFB; //Yalghuz;
  final static char UYG_UN_LA_Y = 0xFEFB; //Yalghuz;
  final static char UYG_UN_LA_A = 0xFEFC; //Ayaq;
//Amza
  final static char UYG_UN_HM_6 = 0x0626; //Yalghuz;
  final static char UYG_UN_HM_Y = 0xFE8B; //Yalghuz;
  final static char UYG_UN_HM_O = 0xFE8C; //Ottura;

// Towendikiler Uyghurche Heripler
// Biraq ular KeyBord Arqiliq kirguzgende ishlitilmidi

// hemze bilen A
  final static char UYGE_UN_HA_Y = 0xFBEA; //Yalghuz;
  final static char UYGE_UN_HA_A = 0xFBEB; //Ayaq;

//hemze bilen E
  final static char UYGE_UN_HE_Y = 0xFBEC; //Yalghuz;
  final static char UYGE_UN_HE_A = 0xFBED; //Ayaq;

//hemze bilen O
  final static char UYGE_UN_HO_Y = 0xFBEE; //Yalghuz;
  final static char UYGE_UN_HO_A = 0xFBEF; //Ayaq;

//hemze bilen U
  final static char UYGE_UN_HU_Y = 0xFBF0; //Yalghuz;
  final static char UYGE_UN_HU_A = 0xFBF1; //Ayaq;

//hemze bilen OO
  final static char UYGE_UN_HOO_Y = 0xFBF2; //Yalghuz;
  final static char UYGE_UN_HOO_A = 0xFBF3; //Ayaq;

//hemze bilen UU
  final static char UYGE_UN_HUU_Y = 0xFBF4; //Yalghuz;
  final static char UYGE_UN_HUU_A = 0xFBF5; //Ayaq;

//hemze bilen EE
  final static char UYGE_UN_HEE_Y = 0xFBF6; //Yalghuz;
  final static char UYGE_UN_HEE_A = 0xFBF7; //Ayaq;
  final static char UYGE_UN_HEE_B = 0xFBF8; //Ayaq;

//hemze bilen I
  final static char UYGE_UN_HI_Y = 0xFBF9; //Yalghuz;
  final static char UYGE_UN_HI_A = 0xFBFA; //Ayaq;
  final static char UYGE_UN_HI_B = 0xFBFB; //Ayaq;

// Bu Artuq Ishlitilgen H heripi(Hemze emes)
  final static char UYGE_UN_H_Y = 0xFEEB; //Yalghuz;
  final static char UYGE_UN_H_A = 0xFEEC; //Ayaq;

  final static char UYG_UN_BOSH = 0x0020; //Boshluq Belgisi
  final static char UYG_UN_UNDESH = 0x0021; //Undesh Belgisi
  final static char UYG_UN_QOSHPESH = 0x0022; //Qosh Pesh
  final static char UYG_UN_REQEM = 0x0023; //Reqem Belgisi #
  final static char UYG_UN_DOLLAR = 0x0024; //Dollar Belgisi
  final static char UYG_UN_PIRSENT = 0x066A; //Pirsent Belgisi
  final static char UYG_UN_WE = 0x0026; //& belgisi
  final static char UYG_UN_TIKPESH = 0x0027; //yalang pesh '(yaki Tik Pesh)
  final static char UYG_UN_SOL_K_TIRNAQ = 0x0028; //Sol Tirnaq(
  final static char UYG_UN_ONG_K_TIRNAQ = 0x0029; //Ong tirnaq)
  final static char UYG_UN_YULTUZ = 0x066D; //Yultuz belgisi
  final static char UYG_UN_QOSHUSH = 0x002B; //Qoshush Belgisi
  final static char UYG_UN_PESH = 0x060C; //Pesh
  final static char UYG_UN_BOGHUM = 0x0640; //Boghum ayrish Belgisi
  final static char UYG_UN_CHEKIT = 0x002E; //Chekit
  final static char UYG_UN_0 = 0x0030; // Nol
  final static char UYG_UN_1 = 0x0031; // Bir
  final static char UYG_UN_2 = 0x0032; // Ikki
  final static char UYG_UN_3 = 0x0033; // Uch
  final static char UYG_UN_4 = 0x0034; // Tort
  final static char UYG_UN_5 = 0x0035; // Besh
  final static char UYG_UN_6 = 0x0036; // Alte
  final static char UYG_UN_7 = 0x0037; // Yette
  final static char UYG_UN_8 = 0x0038; // Sekkiz
  final static char UYG_UN_9 = 0x0039; // Toqquz
  final static char UYG_UN_QOSHCHEKIT = 0x003A; // Qosh Chekit
  final static char UYG_UN_CHEKITPESH = 0x061B; // Chekitlik Pesh
  final static char UYG_UN_CHONG = 0x003C; // ChongBelgisi
  final static char UYG_UN_TENG = 0x003D; // Tenglik Belgisi
  final static char UYG_UN_KICHIK = 0x003E; // Kichik Belgisi
  final static char UYG_UN_SOAL = 0x061F; // Soal Belgisi
  final static char UYG_UN_MEKTUP = 0x0040; // E-mail Adres Belgisi@
  final static char UYG_UN_SOL_O_TIRNAQ = 0x005B; // Sol Ottura Tirnaq
  final static char UYG_UN_SOL_YANTO = 0x005C; // Sol Yantu siziq(ong yantu Siziq hemzige teqsimlengen)
  final static char UYG_UN_ONG_O_TIRNAQ = 0x005D; // Sol Ottura Tirnaq
  final static char UYG_UN_DERIJE = 0x005E; // Sol Ottura Tirnaq
  final static char UYG_UN_PESSIZIQ = 0x005F; // Sol Ottura Tirnaq
  final static char UYG_UN_QIYPESH = 0x0060; // Qiypash Pesh
  final static char UYG_UN_SOL_CH_TIRNAQ = 0x007B; // Chong Sol Tirnaq
  final static char UYG_UN_TIKSIZIQ = 0x007C; // Tik Siziq
  final static char UYG_UN_ONG_CH_TIRNAQ = 0x007D; // Chong Ong Tirnaq
  final static char UYG_UN_DOLQUN = 0x007E; // Dolqun belgisi~
  final static char UYG_UN_SOL_QOSH_TIRNAQ = 0x00AB; // Qosh Tirnaq<<
  final static char UYG_UN_ONG_QOSH_TIRNAQ = 0x00BB; // Qosh Tirnaq>>

// UYGHUR KOMPUTER YEZIQI
//A
  final static char UYG_UKY_A_KICHIK = 'a'; //Kichik yezilishi
  final static char UYG_UKY_A_CHONG = 'A'; //Chong Yezilishi
  // E Heripi
  final static char UYG_UKY_E_KICHIK = 'e'; //Kichik yezilishi;
  final static char UYG_UKY_E_CHONG = 'E'; //Chong Yezilishi;
  // B
  final static char UYG_UKY_B_KICHIK = 'b'; //Kichik yezilishi
  final static char UYG_UKY_B_CHONG = 'B'; //Chong Yezilishi;
  //P
  final static char UYG_UKY_P_KICHIK = 'p'; //Kichik yezilishi
  final static char UYG_UKY_P_CHONG = 'P'; //Chong Yezilishi;
  //T
  final static char UYG_UKY_T_KICHIK = 't'; //Kichik yezilishi
  final static char UYG_UKY_T_CHONG = 'T'; //Chong Yezilishi;
  //J
  final static char UYG_UKY_J_KICHIK = 'j'; //Kichik yezilishi
  final static char UYG_UKY_J_CHONG = 'J'; //Chong Yezilishi;
  //Ch
//static char  UYG_UKY_CH_KICHIK 'ch'	//Kichik yezilishi
//static char  UYG_UKY_CH_CHONG  'CH'	//Chong Yezilishi;
  //X
  final static char UYG_UKY_X_KICHIK = 'x'; //Kichik yezilishi
  final static char UYG_UKY_X_CHONG = 'X'; //Chong Yezilishi;
  //D
  final static char UYG_UKY_D_KICHIK = 'd'; //Kichik yezilishi;
  final static char UYG_UKY_D_CHONG = 'D'; //Chong Yezilishi;
  //R
  final static char UYG_UKY_R_KICHIK = 'r'; //Kichik yezilishi;
  final static char UYG_UKY_R_CHONG = 'R'; //Chong Yezilishi;
  //Z
  final static char UYG_UKY_Z_KICHIK = 'z'; //Kichik yezilishi;
  final static char UYG_UKY_Z_CHONG = 'Z'; //Chong Yezilishi;

//Z..
  final static char UYG_UKY_ZZ_KICHIK = 'j'; //Kichik yezilishi;
  final static char UYG_UKY_ZZ_CHONG = 'J'; //Chong Yezilishi;
  //S
  final static char UYG_UKY_S_KICHIK = 's'; //Kichik yezilishi;
  final static char UYG_UKY_S_CHONG = 'S'; //Chong Yezilishi;
  //F
  final static char UYG_UKY_F_KICHIK = 'f'; //Kichik yezilishi;
  final static char UYG_UKY_F_CHONG = 'F'; //Chong Yezilishi;
  //Q
  final static char UYG_UKY_Q_KICHIK = 'q'; //Kichik yezilishi;
  final static char UYG_UKY_Q_CHONG = 'Q'; //Chong Yezilishi;
  //K
  final static char UYG_UKY_K_KICHIK = 'k'; //Kichik yezilishi;
  final static char UYG_UKY_K_CHONG = 'K'; //Chong Yezilishi;
  //G
  final static char UYG_UKY_G_KICHIK = 'g'; //Kichik yezilishi;
  final static char UYG_UKY_G_CHONG = 'G'; //Chong Yezilishi;
  //L
  final static char UYG_UKY_L_KICHIK = 'l'; //Kichik yezilishi;
  final static char UYG_UKY_L_CHONG = 'L'; //Chong Yezilishi;
  //M
  final static char UYG_UKY_M_KICHIK = 'm'; //Kichik yezilishi;
  final static char UYG_UKY_M_CHONG = 'M'; //Chong Yezilishi;
  //N
  final static char UYG_UKY_N_KICHIK = 'n'; //Kichik yezilishi;
  final static char UYG_UKY_N_CHONG = 'N'; //Chong Yezilishi;
  //H..
  final static char UYG_UKY_H_KICHIK = 'h'; //Kichik yezilishi;
  final static char UYG_UKY_H_CHONG = 'H'; //Chong Yezilishi;
  //O
  final static char UYG_UKY_O_KICHIK = 'o'; //Kichik yezilishi;
  final static char UYG_UKY_O_CHONG = 'O'; //Chong Yezilishi;
  //U
  final static char UYG_UKY_U_KICHIK = 'u'; //Kichik yezilishi;
  final static char UYG_UKY_U_CHONG = 'U'; //Chong Yezilishi;
  //O..
  final static char UYG_UKY_OO_KICHIK = 0xf6; //Kichik yezilishi;
  final static char UYG_UKY_OO_CHONG = 0xd6; //Chong Yezilishi;
  //U..
  final static char UYG_UKY_UU_KICHIK = 0xfc; //Kichik yezilishi;
  final static char UYG_UKY_UU_CHONG = 0xdc; //Chong Yezilishi;
  //W
  final static char UYG_UKY_W_KICHIK = 'w'; //Kichik yezilishi;
  final static char UYG_UKY_W_CHONG = 'W'; //Chong Yezilishi;

  // Bunimu W dep bir terep qildim
  final static char UYG_UKY_V_KICHIK = 'v'; //Kichik yezilishi;
  final static char UYG_UKY_V_CHONG = 'V'; //Chong Yezilishi;

  //E..
  final static char UYG_UKY_EE_KICHIK = 0xe9; //Kichik yezilishi;
  final static char UYG_UKY_EE_CHONG = 0xc9; //Chong Yezilishi;
  //I
  final static char UYG_UKY_I_KICHIK = 'i'; //Kichik yezilishi;
  final static char UYG_UKY_I_CHONG = 'I'; //Chong Yezilishi;
  //Y
  final static char UYG_UKY_Y_KICHIK = 'y'; //Kichik yezilishi;
  final static char UYG_UKY_Y_CHONG = 'Y'; //Chong Yezilishi;

//Amza
  final static char UYG_UKY_HM = 0x2019; //Kichik yezilishi;

  final static char UYG_UKY_BOSH = 0x0020; //Boshluq Belgisi
  final static char UYG_UKY_UNDESH = 0x0021; //Undesh Belgisi
  final static char UYG_UKY_QOSHPESH = 0x0022; //Qosh Pesh
  final static char UYG_UKY_REQEM = 0x0023; //Reqem Belgisi #
  final static char UYG_UKY_DOLLAR = 0x0024; //Dollar Belgisi
  final static char UYG_UKY_PIRSENT = '%'; //Pirsent Belgisi
  final static char UYG_UKY_WE = 0x0026; //& belgisi
  final static char UYG_UKY_TIKPESH = 0x2019; //yalang pesh '(yaki Tik Pesh)
  final static char UYG_UKY_SOL_K_TIRNAQ = 0x0028; //Sol Tirnaq(
  final static char UYG_UKY_ONG_K_TIRNAQ = 0x0029; //Ong tirnaq)
  final static char UYG_UKY_YULTUZ = '*'; //Yultuz belgisi
  final static char UYG_UKY_QOSHUSH = 0x002B; //Qoshush Belgisi
  final static char UYG_UKY_PESH = ','; //Pesh
  final static char UYG_UKY_BOGHUM = '-'; //Boghum ayrish Belgisi
  final static char UYG_UKY_CHEKIT = 0x002E; //Chekit
  final static char UYG_UKY_0 = 0x0030; // Nol
  final static char UYG_UKY_1 = 0x0031; // Bir
  final static char UYG_UKY_2 = 0x0032; // Ikki
  final static char UYG_UKY_3 = 0x0033; // Uch
  final static char UYG_UKY_4 = 0x0034; // Tort
  final static char UYG_UKY_5 = 0x0035; // Besh
  final static char UYG_UKY_6 = 0x0036; // Alte
  final static char UYG_UKY_7 = 0x0037; // Yette
  final static char UYG_UKY_8 = 0x0038; // Sekkiz
  final static char UYG_UKY_9 = 0x0039; // Toqquz
  final static char UYG_UKY_QOSHCHEKIT = 0x003A; // Qosh Chekit
  final static char UYG_UKY_CHEKITPESH = ';'; // Chekitlik Pesh
  final static char UYG_UKY_CHONG = 0x003C; // ChongBelgisi
  final static char UYG_UKY_TENG = 0x003D; // Tenglik Belgisi
  final static char UYG_UKY_KICHIK = 0x003E; // Kichik Belgisi
  final static char UYG_UKY_SOAL = '?'; // Soal Belgisi
  final static char UYG_UKY_MEKTUP = 0x0040; // E-mail Adres Belgisi@
  final static char UYG_UKY_SOL_O_TIRNAQ = 0x005B; // Sol Ottura Tirnaq
  final static char UYG_UKY_SOL_YANTO = 0x005C; // Sol Yantu siziq(ong yantu Siziq hemzige teqsimlengen)
  final static char UYG_UKY_ONG_O_TIRNAQ = 0x005D; // Sol Ottura Tirnaq
  final static char UYG_UKY_DERIJE = 0x005E; // Sol Ottura Tirnaq
  final static char UYG_UKY_PESSIZIQ = 0x005F; // Sol Ottura Tirnaq
  final static char UYG_UKY_QIYPESH = 0x0060; // Qiypash Pesh
  final static char UYG_UKY_SOL_CH_TIRNAQ = 0x007B; // Chong Sol Tirnaq
  final static char UYG_UKY_TIKSIZIQ = 0x007C; // Tik Siziq
  final static char UYG_UKY_ONG_CH_TIRNAQ = 0x007D; // Chong Ong Tirnaq
  final static char UYG_UKY_DOLQUN = 0x007E; // Dolqun belgisi~
  final static char UYG_UKY_YTIKPESH=0x0092;

  private HashSet MuqimSozler;

  private int UGetUnicodeIndex(char Herp) {
    int ret = -1;
    switch (Herp) {
      case UYG_UN_A_6:
      case UYG_UN_A_Y:
      case UYG_UN_A_A:
      case UYGE_UN_HA_Y:
      case UYGE_UN_HA_A:
        ret = UYGIN_A;
        break;
      case UYG_UN_E_6:
      case UYG_UN_E_Y:
      case UYG_UN_E_A:
      case UYGE_UN_HE_Y:
      case UYGE_UN_HE_A:
        ret = UYGIN_E;
        break;
      case UYG_UN_B_6:
      case UYG_UN_B_Y:
      case UYG_UN_B_B:
      case UYG_UN_B_O:
      case UYG_UN_B_A:
        ret = UYGIN_B;
        break;
      case UYG_UN_P_6:
      case UYG_UN_P_Y:
      case UYG_UN_P_B:
      case UYG_UN_P_O:
      case UYG_UN_P_A:
        ret = UYGIN_P;
        break;
      case UYG_UN_T_6:
      case UYG_UN_T_Y:
      case UYG_UN_T_B:
      case UYG_UN_T_O:
      case UYG_UN_T_A:
        ret = UYGIN_T;
        break;
      case UYG_UN_J_6:
      case UYG_UN_J_Y:
      case UYG_UN_J_B:
      case UYG_UN_J_O:
      case UYG_UN_J_A:
        ret = UYGIN_J;
        break;
      case UYG_UN_CH_6:
      case UYG_UN_CH_Y:
      case UYG_UN_CH_B:
      case UYG_UN_CH_O:
      case UYG_UN_CH_A:
        ret = UYGIN_CH;
        break;
      case UYG_UN_X_6:
      case UYG_UN_X_Y:
      case UYG_UN_X_B:
      case UYG_UN_X_O:
      case UYG_UN_X_A:
        ret = UYGIN_X;
        break;
      case UYG_UN_D_6:
      case UYG_UN_D_Y:
      case UYG_UN_D_A:
        ret = UYGIN_D;
        break;
      case UYG_UN_R_6:
      case UYG_UN_R_Y:
      case UYG_UN_R_A:
        ret = UYGIN_R;
        break;
      case UYG_UN_Z_6:
      case UYG_UN_Z_Y:
      case UYG_UN_Z_A:
        ret = UYGIN_Z;
        break;
      case UYG_UN_ZZ_6:
      case UYG_UN_ZZ_Y:
      case UYG_UN_ZZ_A:
        ret = UYGIN_ZZ;
        break;
      case UYG_UN_S_6:
      case UYG_UN_S_Y:
      case UYG_UN_S_B:
      case UYG_UN_S_O:
      case UYG_UN_S_A:
        ret = UYGIN_S;
        break;
      case UYG_UN_SH_6:
      case UYG_UN_SH_Y:
      case UYG_UN_SH_B:
      case UYG_UN_SH_O:
      case UYG_UN_SH_A:
        ret = UYGIN_SH;
        break;
      case UYG_UN_GH_6:
      case UYG_UN_GH_Y:
      case UYG_UN_GH_B:
      case UYG_UN_GH_O:
      case UYG_UN_GH_A:
        ret = UYGIN_GH;
        break;
      case UYG_UN_F_6:
      case UYG_UN_F_Y:
      case UYG_UN_F_B:
      case UYG_UN_F_O:
      case UYG_UN_F_A:
        ret = UYGIN_F;
        break;
      case UYG_UN_Q_6:
      case UYG_UN_Q_Y:
      case UYG_UN_Q_B:
      case UYG_UN_Q_O:
      case UYG_UN_Q_A:
        ret = UYGIN_Q;
        break;
      case UYG_UN_K_6:
      case UYG_UN_K_Y:
      case UYG_UN_K_B:
      case UYG_UN_K_O:
      case UYG_UN_K_A:
        ret = UYGIN_K;
        break;
      case UYG_UN_G_6:
      case UYG_UN_G_Y:
      case UYG_UN_G_B:
      case UYG_UN_G_O:
      case UYG_UN_G_A:
        ret = UYGIN_G;
        break;
      case UYG_UN_NG_6:
      case UYG_UN_NG_Y:
      case UYG_UN_NG_B:
      case UYG_UN_NG_O:
      case UYG_UN_NG_A:
        ret = UYGIN_NG;
        break;
      case UYG_UN_L_6:
      case UYG_UN_L_Y:
      case UYG_UN_L_B:
      case UYG_UN_L_O:
      case UYG_UN_L_A:
        ret = UYGIN_L;
        break;
      case UYG_UN_M_6:
      case UYG_UN_M_Y:
      case UYG_UN_M_B:
      case UYG_UN_M_O:
      case UYG_UN_M_A:
        ret = UYGIN_M;
        break;
      case UYG_UN_N_6:
      case UYG_UN_N_Y:
      case UYG_UN_N_B:
      case UYG_UN_N_O:
      case UYG_UN_N_A:
        ret = UYGIN_N;
        break;
      case UYG_UN_H_6:
      case UYG_UN_H_Y:
      case UYG_UN_H_A:
      case UYG_UN_H_B:
      case UYG_UN_H_O:
      case UYGE_UN_H_Y:
      case UYGE_UN_H_A:
        ret = UYGIN_H;
        break;
      case UYG_UN_O_6:
      case UYG_UN_O_Y:
      case UYG_UN_O_A:
      case UYGE_UN_HO_Y:
      case UYGE_UN_HO_A:
        ret = UYGIN_O;
        break;
      case UYG_UN_U_6:
      case UYG_UN_U_Y:
      case UYG_UN_U_A:
      case UYGE_UN_HU_Y:
      case UYGE_UN_HU_A:
        ret = UYGIN_U;
        break;
      case UYG_UN_OO_6:
      case UYG_UN_OO_Y:
      case UYG_UN_OO_A:
      case UYGE_UN_HOO_Y:
      case UYGE_UN_HOO_A:
        ret = UYGIN_OO;
        break;
      case UYG_UN_UU_6:
      case UYG_UN_UU_Y:
      case UYG_UN_UU_A:
      case UYGE_UN_HUU_Y:
      case UYGE_UN_HUU_A:
        ret = UYGIN_UU;
        break;
      case UYG_UN_W_6:
      case UYG_UN_W_Y:
      case UYG_UN_W_A:
        ret = UYGIN_W;
        break;
      case UYG_UN_EE_6:
      case UYG_UN_EE_Y:
      case UYG_UN_EE_B:
      case UYG_UN_EE_O:
      case UYG_UN_EE_A:
      case UYGE_UN_HEE_Y:
      case UYGE_UN_HEE_A:
      case UYGE_UN_HEE_B:
        ret = UYGIN_EE;
        break;
      case UYG_UN_I_6:
      case UYG_UN_I_Y:
      case UYG_UN_I_B:
      case UYG_UN_I_O:
      case UYG_UN_I_A:
      case UYGE_UN_HI_Y:
      case UYGE_UN_HI_A:
      case UYGE_UN_HI_B:
        ret = UYGIN_I;
        break;
      case UYG_UN_Y_6:
      case UYG_UN_Y_Y:
      case UYG_UN_Y_B:
      case UYG_UN_Y_O:
      case UYG_UN_Y_A:
        ret = UYGIN_Y;
        break;
//			case  UYG_UN_LA_6 :
      case UYG_UN_LA_Y:
      case UYG_UN_LA_A:
        ret = UYGIN_LA;
        break;
      case UYG_UN_HM_6:
      case UYG_UN_HM_Y:
      case UYG_UN_HM_O:
        ret = UYGIN_HM;
        break;
      default:
        break;

    }
    return ret;
  }

// Bu Herip ning Uyghurche herip kodimu Hokum qilidu
// Eger Uyghgurche bolsa Uyghurche Fontni Ishlitidu
// Bolmisa Bashqa FOntni ishlitidu

  private boolean UIsUyghur(char Herip) {
    boolean ret;
    switch (Herip) {
      case UYG_UN_A_6:
      case UYG_UN_A_Y:
      case UYG_UN_A_A:
      case UYG_UN_E_6:
      case UYG_UN_E_Y:
      case UYG_UN_E_A:
      case UYG_UN_B_6:
      case UYG_UN_B_Y:
      case UYG_UN_B_B:
      case UYG_UN_B_O:
      case UYG_UN_B_A:
      case UYG_UN_P_6:
      case UYG_UN_P_Y:
      case UYG_UN_P_B:
      case UYG_UN_P_O:
      case UYG_UN_P_A:
      case UYG_UN_T_6:
      case UYG_UN_T_Y:
      case UYG_UN_T_B:
      case UYG_UN_T_O:
      case UYG_UN_T_A:
      case UYG_UN_J_6:
      case UYG_UN_J_Y:
      case UYG_UN_J_B:
      case UYG_UN_J_O:
      case UYG_UN_J_A:
      case UYG_UN_CH_6:
      case UYG_UN_CH_Y:
      case UYG_UN_CH_B:
      case UYG_UN_CH_O:
      case UYG_UN_CH_A:
      case UYG_UN_X_6:
      case UYG_UN_X_Y:
      case UYG_UN_X_B:
      case UYG_UN_X_O:
      case UYG_UN_X_A:
      case UYG_UN_D_6:
      case UYG_UN_D_Y:
      case UYG_UN_D_A:
      case UYG_UN_R_6:
      case UYG_UN_R_Y:
      case UYG_UN_R_A:
      case UYG_UN_Z_6:
      case UYG_UN_Z_Y:
      case UYG_UN_Z_A:
      case UYG_UN_ZZ_6:
      case UYG_UN_ZZ_Y:
      case UYG_UN_ZZ_A:
      case UYG_UN_S_6:
      case UYG_UN_S_Y:
      case UYG_UN_S_B:
      case UYG_UN_S_O:
      case UYG_UN_S_A:
      case UYG_UN_SH_6:
      case UYG_UN_SH_Y:
      case UYG_UN_SH_B:
      case UYG_UN_SH_O:
      case UYG_UN_SH_A:
      case UYG_UN_GH_6:
      case UYG_UN_GH_Y:
      case UYG_UN_GH_B:
      case UYG_UN_GH_O:
      case UYG_UN_GH_A:
      case UYG_UN_F_6:
      case UYG_UN_F_Y:
      case UYG_UN_F_B:
      case UYG_UN_F_O:
      case UYG_UN_F_A:
      case UYG_UN_Q_6:
      case UYG_UN_Q_Y:
      case UYG_UN_Q_B:
      case UYG_UN_Q_O:
      case UYG_UN_Q_A:
      case UYG_UN_K_6:
      case UYG_UN_K_Y:
      case UYG_UN_K_B:
      case UYG_UN_K_O:
      case UYG_UN_K_A:
      case UYG_UN_G_6:
      case UYG_UN_G_Y:
      case UYG_UN_G_B:
      case UYG_UN_G_O:
      case UYG_UN_G_A:
      case UYG_UN_NG_6:
      case UYG_UN_NG_Y:
      case UYG_UN_NG_B:
      case UYG_UN_NG_O:
      case UYG_UN_NG_A:
      case UYG_UN_L_6:
      case UYG_UN_L_Y:
      case UYG_UN_L_B:
      case UYG_UN_L_O:
      case UYG_UN_L_A:
      case UYG_UN_M_6:
      case UYG_UN_M_Y:
      case UYG_UN_M_B:
      case UYG_UN_M_O:
      case UYG_UN_M_A:
      case UYG_UN_N_6:
      case UYG_UN_N_Y:
      case UYG_UN_N_B:
      case UYG_UN_N_O:
      case UYG_UN_N_A:
      case UYG_UN_H_6:
      case UYG_UN_H_Y:
      case UYG_UN_H_A:
      case UYG_UN_H_B:
      case UYG_UN_H_O:
      case UYG_UN_O_6:
      case UYG_UN_O_Y:
      case UYG_UN_O_A:
      case UYG_UN_U_6:
      case UYG_UN_U_Y:
      case UYG_UN_U_A:
      case UYG_UN_OO_6:
      case UYG_UN_OO_Y:
      case UYG_UN_OO_A:
      case UYG_UN_UU_6:
      case UYG_UN_UU_Y:
      case UYG_UN_UU_A:
      case UYG_UN_W_6:
      case UYG_UN_W_Y:
      case UYG_UN_W_A:
      case UYG_UN_EE_6:
      case UYG_UN_EE_Y:
      case UYG_UN_EE_B:
      case UYG_UN_EE_O:
      case UYG_UN_EE_A:
      case UYG_UN_I_6:
      case UYG_UN_I_Y:
      case UYG_UN_I_B:
      case UYG_UN_I_O:
      case UYG_UN_I_A:
      case UYG_UN_Y_6:
      case UYG_UN_Y_Y:
      case UYG_UN_Y_B:
      case UYG_UN_Y_O:
      case UYG_UN_Y_A:
      case UYG_UN_LA_Y:
      case UYG_UN_LA_A:
      case UYG_UN_HM_6:
      case UYG_UN_HM_Y:
      case UYG_UN_HM_O:

        // Qoshumche Heripler
      case UYGE_UN_HA_Y:
      case UYGE_UN_HA_A:
      case UYGE_UN_HE_Y:
      case UYGE_UN_HE_A:
        //hemze bilen O
      case UYGE_UN_HO_Y:
      case UYGE_UN_HO_A:
        //hemze bilen U
      case UYGE_UN_HU_Y:
      case UYGE_UN_HU_A:
        //hemze bilen OO
      case UYGE_UN_HOO_Y:
      case UYGE_UN_HOO_A:
        //hemze bilen UU
      case UYGE_UN_HUU_Y:
      case UYGE_UN_HUU_A:
        //hemze bilen EE
      case UYGE_UN_HEE_Y:
      case UYGE_UN_HEE_A:
      case UYGE_UN_HEE_B:
        //hemze bilen I
      case UYGE_UN_HI_Y:
      case UYGE_UN_HI_A:
      case UYGE_UN_HI_B:
        // Bu Artuq Ishlitilgen H heripi(Hemze emes)
      case UYGE_UN_H_Y: //Yalghuz;
      case UYGE_UN_H_A: //Ayaq;

        // Belgiler
      case UYG_UN_PIRSENT:
      case UYG_UN_YULTUZ:
      case UYG_UN_PESH:
      case UYG_UN_BOGHUM:
      case UYG_UN_CHEKITPESH:
      case UYG_UN_SOAL:
        ret = true;
        break;
      default:
        ret = false;
        break;
    }
    return ret;
  }

  private boolean UIsSozuqTawushUKY(char ukyHerip) {
    boolean ret;
    switch (ukyHerip) {
      case UYG_UKY_A_KICHIK:
      case UYG_UKY_A_CHONG:
      case UYG_UKY_E_KICHIK:
      case UYG_UKY_E_CHONG:
      case UYG_UKY_O_KICHIK:
      case UYG_UKY_O_CHONG:
      case UYG_UKY_U_KICHIK:
      case UYG_UKY_U_CHONG:
      case UYG_UKY_OO_KICHIK:
      case UYG_UKY_OO_CHONG:
      case UYG_UKY_UU_KICHIK:
      case UYG_UKY_UU_CHONG:
      case UYG_UKY_EE_KICHIK:
      case UYG_UKY_EE_CHONG:
      case UYG_UKY_I_KICHIK:
      case UYG_UKY_I_CHONG:
        ret=true;
        break;
      default:
        ret=false;
        break;
    }
    return ret;
  }


// Bu Herip ning Uyghurche sozuq tawush heripimu Hokum Qilidu
  private boolean UIsSozuqTawushUN(char Herip) {
    boolean ret;
    switch (Herip) {
      case UYG_UN_A_6:
      case UYG_UN_A_Y:
      case UYG_UN_A_A:
      case UYG_UN_E_6:
      case UYG_UN_E_Y:
      case UYG_UN_E_A:
      case UYG_UN_O_6:
      case UYG_UN_O_Y:
      case UYG_UN_O_A:
      case UYG_UN_U_6:
      case UYG_UN_U_Y:
      case UYG_UN_U_A:
      case UYG_UN_OO_6:
      case UYG_UN_OO_Y:
      case UYG_UN_OO_A:
      case UYG_UN_UU_6:
      case UYG_UN_UU_Y:
      case UYG_UN_UU_A:
      case UYG_UN_EE_6:
      case UYG_UN_EE_Y:
      case UYG_UN_EE_B:
      case UYG_UN_EE_O:
      case UYG_UN_EE_A:
      case UYG_UN_I_6:
      case UYG_UN_I_Y:
      case UYG_UN_I_B:
      case UYG_UN_I_O:
      case UYG_UN_I_A:
      case UYG_UN_LA_Y:
      case UYG_UN_LA_A:
        // Qoshumche Heripler
      case UYGE_UN_HA_Y:
      case UYGE_UN_HA_A:
      case UYGE_UN_HE_Y:
      case UYGE_UN_HE_A:
        //hemze bilen O
      case UYGE_UN_HO_Y:
      case UYGE_UN_HO_A:
        //hemze bilen U
      case UYGE_UN_HU_Y:
      case UYGE_UN_HU_A:
        //hemze bilen OO
      case UYGE_UN_HOO_Y:
      case UYGE_UN_HOO_A:
        //hemze bilen UU
      case UYGE_UN_HUU_Y:
      case UYGE_UN_HUU_A:
        //hemze bilen EE
      case UYGE_UN_HEE_Y:
      case UYGE_UN_HEE_A:
      case UYGE_UN_HEE_B:
        //hemze bilen I
      case UYGE_UN_HI_Y:
      case UYGE_UN_HI_A:
      case UYGE_UN_HI_B:
        ret = true;
        break;
      default:
        ret = false;
        break;
    }
    return ret;
  }

  private int UGetUKYIndex(char ukyHerip) {
    int ret;
    switch (ukyHerip) {
      case UYG_UKY_A_KICHIK:
      case UYG_UKY_A_CHONG:
        ret = UYGIN_A;
        break;
      case UYG_UKY_E_KICHIK:
      case UYG_UKY_E_CHONG:
        ret = UYGIN_E;
        break;
      case UYG_UKY_B_KICHIK:
      case UYG_UKY_B_CHONG:
        ret = UYGIN_B;
        break;
      case UYG_UKY_P_KICHIK:
      case UYG_UKY_P_CHONG:
        ret = UYGIN_P;
        break;
      case UYG_UKY_T_KICHIK:
      case UYG_UKY_T_CHONG:
        ret = UYGIN_T;
        break;
      case UYG_UKY_J_KICHIK:
      case UYG_UKY_J_CHONG:
        ret = UYGIN_J;
        break;
      case UYG_UKY_X_KICHIK:
      case UYG_UKY_X_CHONG:
        ret = UYGIN_X;
        break;
      case UYG_UKY_D_KICHIK:
      case UYG_UKY_D_CHONG:
        ret = UYGIN_D;
        break;
      case UYG_UKY_R_KICHIK:
      case UYG_UKY_R_CHONG:
        ret = UYGIN_R;
        break;
      case UYG_UKY_Z_KICHIK:
      case UYG_UKY_Z_CHONG:
        ret = UYGIN_Z;
        break;
      case UYG_UKY_S_KICHIK:
      case UYG_UKY_S_CHONG:
        ret = UYGIN_S;
        break;
      case UYG_UKY_F_KICHIK:
      case UYG_UKY_F_CHONG:
        ret = UYGIN_F;
        break;
      case UYG_UKY_Q_KICHIK:
      case UYG_UKY_Q_CHONG:
        ret = UYGIN_Q;
        break;
      case UYG_UKY_K_KICHIK:
      case UYG_UKY_K_CHONG:
        ret = UYGIN_K;
        break;
      case UYG_UKY_G_KICHIK:
      case UYG_UKY_G_CHONG:
        ret = UYGIN_G;
        break;
      case UYG_UKY_L_KICHIK:
      case UYG_UKY_L_CHONG:
        ret = UYGIN_L;
        break;
      case UYG_UKY_M_KICHIK:
      case UYG_UKY_M_CHONG:
        ret = UYGIN_M;
        break;
      case UYG_UKY_N_KICHIK:
      case UYG_UKY_N_CHONG:
        ret = UYGIN_N;
        break;
      case UYG_UKY_H_KICHIK:
      case UYG_UKY_H_CHONG:
        ret = UYGIN_H;
        break;
      case UYG_UKY_O_KICHIK:
      case UYG_UKY_O_CHONG:
        ret = UYGIN_O;
        break;
      case UYG_UKY_U_KICHIK:
      case UYG_UKY_U_CHONG:
        ret = UYGIN_U;
        break;
      case UYG_UKY_OO_KICHIK:
      case UYG_UKY_OO_CHONG:
        ret = UYGIN_OO;
        break;
      case UYG_UKY_UU_KICHIK:
      case UYG_UKY_UU_CHONG:
        ret = UYGIN_UU;
        break;
      case UYG_UKY_W_KICHIK:
      case UYG_UKY_W_CHONG:
      case UYG_UKY_V_KICHIK:
      case UYG_UKY_V_CHONG:
        ret = UYGIN_W;
        break;
      case UYG_UKY_EE_KICHIK:
      case UYG_UKY_EE_CHONG:
        ret = UYGIN_EE;
        break;
      case UYG_UKY_I_KICHIK:
      case UYG_UKY_I_CHONG:
        ret = UYGIN_I;
        break;
      case UYG_UKY_Y_KICHIK:
      case UYG_UKY_Y_CHONG:
        ret = UYGIN_Y;
        break;
      default:
        ret = -1;
        break;
    }
    return ret;
  }

  public Aylandurghuch() {
    UInitKonaYeziq();
    UInitUky();
  }

  public void setMuqimSozler(HashSet muqim)
  {
    this.MuqimSozler=muqim;
  }

  private void UInitKonaYeziq() {
    UYG_Unicode[UYGIN_A][U_6] = UYG_UN_A_6;
    UYG_Unicode[UYGIN_A][U_YALGHUZ] = UYG_UN_A_Y;
    UYG_Unicode[UYGIN_A][U_BASH] = UYG_UN_A_Y;
    UYG_Unicode[UYGIN_A][U_OTTURA] = UYG_UN_A_A;
    UYG_Unicode[UYGIN_A][U_AYAQ] = UYG_UN_A_A;
    UYG_Ulinish[UYGIN_A] = false;

    UYG_Unicode[UYGIN_E][U_6] = UYG_UN_E_6;
    UYG_Unicode[UYGIN_E][U_YALGHUZ] = UYG_UN_E_Y;
    UYG_Unicode[UYGIN_E][U_BASH] = UYG_UN_E_Y;
    UYG_Unicode[UYGIN_E][U_OTTURA] = UYG_UN_E_A;
    UYG_Unicode[UYGIN_E][U_AYAQ] = UYG_UN_E_A;
    UYG_Ulinish[UYGIN_E] = false;

    UYG_Unicode[UYGIN_B][U_6] = UYG_UN_B_6;
    UYG_Unicode[UYGIN_B][U_YALGHUZ] = UYG_UN_B_Y;
    UYG_Unicode[UYGIN_B][U_BASH] = UYG_UN_B_B;
    UYG_Unicode[UYGIN_B][U_OTTURA] = UYG_UN_B_O;
    UYG_Unicode[UYGIN_B][U_AYAQ] = UYG_UN_B_A;
    UYG_Ulinish[UYGIN_B] = true;

    UYG_Unicode[UYGIN_P][U_6] = UYG_UN_P_6;
    UYG_Unicode[UYGIN_P][U_YALGHUZ] = UYG_UN_P_Y;
    UYG_Unicode[UYGIN_P][U_BASH] = UYG_UN_P_B;
    UYG_Unicode[UYGIN_P][U_OTTURA] = UYG_UN_P_O;
    UYG_Unicode[UYGIN_P][U_AYAQ] = UYG_UN_P_A;
    UYG_Ulinish[UYGIN_P] = true;

    UYG_Unicode[UYGIN_T][U_6] = UYG_UN_T_6;
    UYG_Unicode[UYGIN_T][U_YALGHUZ] = UYG_UN_T_Y;
    UYG_Unicode[UYGIN_T][U_BASH] = UYG_UN_T_B;
    UYG_Unicode[UYGIN_T][U_OTTURA] = UYG_UN_T_O;
    UYG_Unicode[UYGIN_T][U_AYAQ] = UYG_UN_T_A;
    UYG_Ulinish[UYGIN_T] = true;

    UYG_Unicode[UYGIN_J][U_6] = UYG_UN_J_6;
    UYG_Unicode[UYGIN_J][U_YALGHUZ] = UYG_UN_J_Y;
    UYG_Unicode[UYGIN_J][U_BASH] = UYG_UN_J_B;
    UYG_Unicode[UYGIN_J][U_OTTURA] = UYG_UN_J_O;
    UYG_Unicode[UYGIN_J][U_AYAQ] = UYG_UN_J_A;
    UYG_Ulinish[UYGIN_J] = true;

    UYG_Unicode[UYGIN_CH][U_6] = UYG_UN_CH_6;
    UYG_Unicode[UYGIN_CH][U_YALGHUZ] = UYG_UN_CH_Y;
    UYG_Unicode[UYGIN_CH][U_BASH] = UYG_UN_CH_B;
    UYG_Unicode[UYGIN_CH][U_OTTURA] = UYG_UN_CH_O;
    UYG_Unicode[UYGIN_CH][U_AYAQ] = UYG_UN_CH_A;
    UYG_Ulinish[UYGIN_CH] = true;

    UYG_Unicode[UYGIN_X][U_6] = UYG_UN_X_6;
    UYG_Unicode[UYGIN_X][U_YALGHUZ] = UYG_UN_X_Y;
    UYG_Unicode[UYGIN_X][U_BASH] = UYG_UN_X_B;
    UYG_Unicode[UYGIN_X][U_OTTURA] = UYG_UN_X_O;
    UYG_Unicode[UYGIN_X][U_AYAQ] = UYG_UN_X_A;
    UYG_Ulinish[UYGIN_X] = true;

    UYG_Unicode[UYGIN_D][U_6] = UYG_UN_D_6;
    UYG_Unicode[UYGIN_D][U_YALGHUZ] = UYG_UN_D_Y;
    UYG_Unicode[UYGIN_D][U_BASH] = UYG_UN_D_Y;
    UYG_Unicode[UYGIN_D][U_OTTURA] = UYG_UN_D_A;
    UYG_Unicode[UYGIN_D][U_AYAQ] = UYG_UN_D_A;
    UYG_Ulinish[UYGIN_D] = false;

    UYG_Unicode[UYGIN_R][U_6] = UYG_UN_R_6;
    UYG_Unicode[UYGIN_R][U_YALGHUZ] = UYG_UN_R_Y;
    UYG_Unicode[UYGIN_R][U_BASH] = UYG_UN_R_Y;
    UYG_Unicode[UYGIN_R][U_OTTURA] = UYG_UN_R_A;
    UYG_Unicode[UYGIN_R][U_AYAQ] = UYG_UN_R_A;
    UYG_Ulinish[UYGIN_R] = false;

    UYG_Unicode[UYGIN_Z][U_6] = UYG_UN_Z_6;
    UYG_Unicode[UYGIN_Z][U_YALGHUZ] = UYG_UN_Z_Y;
    UYG_Unicode[UYGIN_Z][U_BASH] = UYG_UN_Z_Y;
    UYG_Unicode[UYGIN_Z][U_OTTURA] = UYG_UN_Z_A;
    UYG_Unicode[UYGIN_Z][U_AYAQ] = UYG_UN_Z_A;
    UYG_Ulinish[UYGIN_Z] = false;

    UYG_Unicode[UYGIN_ZZ][U_6] = UYG_UN_ZZ_6;
    UYG_Unicode[UYGIN_ZZ][U_YALGHUZ] = UYG_UN_ZZ_Y;
    UYG_Unicode[UYGIN_ZZ][U_BASH] = UYG_UN_ZZ_Y;
    UYG_Unicode[UYGIN_ZZ][U_OTTURA] = UYG_UN_ZZ_A;
    UYG_Unicode[UYGIN_ZZ][U_AYAQ] = UYG_UN_ZZ_A;
    UYG_Ulinish[UYGIN_ZZ] = false;

    UYG_Unicode[UYGIN_S][U_6] = UYG_UN_S_6;
    UYG_Unicode[UYGIN_S][U_YALGHUZ] = UYG_UN_S_Y;
    UYG_Unicode[UYGIN_S][U_BASH] = UYG_UN_S_B;
    UYG_Unicode[UYGIN_S][U_OTTURA] = UYG_UN_S_O;
    UYG_Unicode[UYGIN_S][U_AYAQ] = UYG_UN_S_A;
    UYG_Ulinish[UYGIN_S] = true;

    UYG_Unicode[UYGIN_SH][U_6] = UYG_UN_SH_6;
    UYG_Unicode[UYGIN_SH][U_YALGHUZ] = UYG_UN_SH_Y;
    UYG_Unicode[UYGIN_SH][U_BASH] = UYG_UN_SH_B;
    UYG_Unicode[UYGIN_SH][U_OTTURA] = UYG_UN_SH_O;
    UYG_Unicode[UYGIN_SH][U_AYAQ] = UYG_UN_SH_A;
    UYG_Ulinish[UYGIN_SH] = true;

    UYG_Unicode[UYGIN_GH][U_6] = UYG_UN_GH_6;
    UYG_Unicode[UYGIN_GH][U_YALGHUZ] = UYG_UN_GH_Y;
    UYG_Unicode[UYGIN_GH][U_BASH] = UYG_UN_GH_B;
    UYG_Unicode[UYGIN_GH][U_OTTURA] = UYG_UN_GH_O;
    UYG_Unicode[UYGIN_GH][U_AYAQ] = UYG_UN_GH_A;
    UYG_Ulinish[UYGIN_GH] = true;

    UYG_Unicode[UYGIN_F][U_6] = UYG_UN_F_6;
    UYG_Unicode[UYGIN_F][U_YALGHUZ] = UYG_UN_F_Y;
    UYG_Unicode[UYGIN_F][U_BASH] = UYG_UN_F_B;
    UYG_Unicode[UYGIN_F][U_OTTURA] = UYG_UN_F_O;
    UYG_Unicode[UYGIN_F][U_AYAQ] = UYG_UN_F_A;
    UYG_Ulinish[UYGIN_F] = true;

    UYG_Unicode[UYGIN_Q][U_6] = UYG_UN_Q_6;
    UYG_Unicode[UYGIN_Q][U_YALGHUZ] = UYG_UN_Q_Y;
    UYG_Unicode[UYGIN_Q][U_BASH] = UYG_UN_Q_B;
    UYG_Unicode[UYGIN_Q][U_OTTURA] = UYG_UN_Q_O;
    UYG_Unicode[UYGIN_Q][U_AYAQ] = UYG_UN_Q_A;
    UYG_Ulinish[UYGIN_Q] = true;

    UYG_Unicode[UYGIN_K][U_6] = UYG_UN_K_6;
    UYG_Unicode[UYGIN_K][U_YALGHUZ] = UYG_UN_K_Y;
    UYG_Unicode[UYGIN_K][U_BASH] = UYG_UN_K_B;
    UYG_Unicode[UYGIN_K][U_OTTURA] = UYG_UN_K_O;
    UYG_Unicode[UYGIN_K][U_AYAQ] = UYG_UN_K_A;
    UYG_Ulinish[UYGIN_K] = true;

    UYG_Unicode[UYGIN_G][U_6] = UYG_UN_G_6;
    UYG_Unicode[UYGIN_G][U_YALGHUZ] = UYG_UN_G_Y;
    UYG_Unicode[UYGIN_G][U_BASH] = UYG_UN_G_B;
    UYG_Unicode[UYGIN_G][U_OTTURA] = UYG_UN_G_O;
    UYG_Unicode[UYGIN_G][U_AYAQ] = UYG_UN_G_A;
    UYG_Ulinish[UYGIN_G] = true;

    UYG_Unicode[UYGIN_NG][U_6] = UYG_UN_NG_6;
    UYG_Unicode[UYGIN_NG][U_YALGHUZ] = UYG_UN_NG_Y;
    UYG_Unicode[UYGIN_NG][U_BASH] = UYG_UN_NG_B;
    UYG_Unicode[UYGIN_NG][U_OTTURA] = UYG_UN_NG_O;
    UYG_Unicode[UYGIN_NG][U_AYAQ] = UYG_UN_NG_A;
    UYG_Ulinish[UYGIN_NG] = true;

    UYG_Unicode[UYGIN_L][U_6] = UYG_UN_L_6;
    UYG_Unicode[UYGIN_L][U_YALGHUZ] = UYG_UN_L_Y;
    UYG_Unicode[UYGIN_L][U_BASH] = UYG_UN_L_B;
    UYG_Unicode[UYGIN_L][U_OTTURA] = UYG_UN_L_O;
    UYG_Unicode[UYGIN_L][U_AYAQ] = UYG_UN_L_A;
    UYG_Ulinish[UYGIN_L] = true;

    UYG_Unicode[UYGIN_M][U_6] = UYG_UN_M_6;
    UYG_Unicode[UYGIN_M][U_YALGHUZ] = UYG_UN_M_Y;
    UYG_Unicode[UYGIN_M][U_BASH] = UYG_UN_M_B;
    UYG_Unicode[UYGIN_M][U_OTTURA] = UYG_UN_M_O;
    UYG_Unicode[UYGIN_M][U_AYAQ] = UYG_UN_M_A;
    UYG_Ulinish[UYGIN_M] = true;

    UYG_Unicode[UYGIN_N][U_6] = UYG_UN_N_6;
    UYG_Unicode[UYGIN_N][U_YALGHUZ] = UYG_UN_N_Y;
    UYG_Unicode[UYGIN_N][U_BASH] = UYG_UN_N_B;
    UYG_Unicode[UYGIN_N][U_OTTURA] = UYG_UN_N_O;
    UYG_Unicode[UYGIN_N][U_AYAQ] = UYG_UN_N_A;
    UYG_Ulinish[UYGIN_N] = true;

    UYG_Unicode[UYGIN_H][U_6] = UYG_UN_H_6;
    UYG_Unicode[UYGIN_H][U_YALGHUZ] = UYG_UN_H_Y;
    UYG_Unicode[UYGIN_H][U_BASH] = UYG_UN_H_B;
    UYG_Unicode[UYGIN_H][U_OTTURA] = UYG_UN_H_O;
    UYG_Unicode[UYGIN_H][U_AYAQ] = UYG_UN_H_A;
    UYG_Ulinish[UYGIN_H] = true;

    UYG_Unicode[UYGIN_O][U_6] = UYG_UN_O_6;
    UYG_Unicode[UYGIN_O][U_YALGHUZ] = UYG_UN_O_Y;
    UYG_Unicode[UYGIN_O][U_BASH] = UYG_UN_O_Y;
    UYG_Unicode[UYGIN_O][U_OTTURA] = UYG_UN_O_A;
    UYG_Unicode[UYGIN_O][U_AYAQ] = UYG_UN_O_A;
    UYG_Ulinish[UYGIN_O] = false;

    UYG_Unicode[UYGIN_U][U_6] = UYG_UN_U_6;
    UYG_Unicode[UYGIN_U][U_YALGHUZ] = UYG_UN_U_Y;
    UYG_Unicode[UYGIN_U][U_BASH] = UYG_UN_U_Y;
    UYG_Unicode[UYGIN_U][U_OTTURA] = UYG_UN_U_A;
    UYG_Unicode[UYGIN_U][U_AYAQ] = UYG_UN_U_A;
    UYG_Ulinish[UYGIN_U] = false;

    UYG_Unicode[UYGIN_OO][U_6] = UYG_UN_OO_6;
    UYG_Unicode[UYGIN_OO][U_YALGHUZ] = UYG_UN_OO_Y;
    UYG_Unicode[UYGIN_OO][U_BASH] = UYG_UN_OO_Y;
    UYG_Unicode[UYGIN_OO][U_OTTURA] = UYG_UN_OO_A;
    UYG_Unicode[UYGIN_OO][U_AYAQ] = UYG_UN_OO_A;
    UYG_Ulinish[UYGIN_OO] = false;

    UYG_Unicode[UYGIN_UU][U_6] = UYG_UN_UU_6;
    UYG_Unicode[UYGIN_UU][U_YALGHUZ] = UYG_UN_UU_Y;
    UYG_Unicode[UYGIN_UU][U_BASH] = UYG_UN_UU_Y;
    UYG_Unicode[UYGIN_UU][U_OTTURA] = UYG_UN_UU_A;
    UYG_Unicode[UYGIN_UU][U_AYAQ] = UYG_UN_UU_A;
    UYG_Ulinish[UYGIN_UU] = false;

    UYG_Unicode[UYGIN_W][U_6] = UYG_UN_W_6;
    UYG_Unicode[UYGIN_W][U_YALGHUZ] = UYG_UN_W_Y;
    UYG_Unicode[UYGIN_W][U_BASH] = UYG_UN_W_Y;
    UYG_Unicode[UYGIN_W][U_OTTURA] = UYG_UN_W_A;
    UYG_Unicode[UYGIN_W][U_AYAQ] = UYG_UN_W_A;
    UYG_Ulinish[UYGIN_W] = false;

    UYG_Unicode[UYGIN_EE][U_6] = UYG_UN_EE_6;
    UYG_Unicode[UYGIN_EE][U_YALGHUZ] = UYG_UN_EE_Y;
    UYG_Unicode[UYGIN_EE][U_BASH] = UYG_UN_EE_B;
    UYG_Unicode[UYGIN_EE][U_OTTURA] = UYG_UN_EE_O;
    UYG_Unicode[UYGIN_EE][U_AYAQ] = UYG_UN_EE_A;
    UYG_Ulinish[UYGIN_EE] = true;

    UYG_Unicode[UYGIN_I][U_6] = UYG_UN_I_6;
    UYG_Unicode[UYGIN_I][U_YALGHUZ] = UYG_UN_I_Y;
    UYG_Unicode[UYGIN_I][U_BASH] = UYG_UN_I_B;
    UYG_Unicode[UYGIN_I][U_OTTURA] = UYG_UN_I_O;
    UYG_Unicode[UYGIN_I][U_AYAQ] = UYG_UN_I_A;
    UYG_Ulinish[UYGIN_I] = true;

    UYG_Unicode[UYGIN_Y][U_6] = UYG_UN_Y_6;
    UYG_Unicode[UYGIN_Y][U_YALGHUZ] = UYG_UN_Y_Y;
    UYG_Unicode[UYGIN_Y][U_BASH] = UYG_UN_Y_B;
    UYG_Unicode[UYGIN_Y][U_OTTURA] = UYG_UN_Y_O;
    UYG_Unicode[UYGIN_Y][U_AYAQ] = UYG_UN_Y_A;
    UYG_Ulinish[UYGIN_Y] = true;

    UYG_Unicode[UYGIN_LA][U_6] = UYG_UN_LA_6;
    UYG_Unicode[UYGIN_LA][U_YALGHUZ] = UYG_UN_LA_Y;
    UYG_Unicode[UYGIN_LA][U_BASH] = UYG_UN_LA_Y;
    UYG_Unicode[UYGIN_LA][U_OTTURA] = UYG_UN_LA_A;
    UYG_Unicode[UYGIN_LA][U_AYAQ] = UYG_UN_LA_A;
    UYG_Ulinish[UYGIN_LA] = false;

    UYG_Unicode[UYGIN_HM][U_6] = UYG_UN_HM_6;
    UYG_Unicode[UYGIN_HM][U_YALGHUZ] = UYG_UN_HM_Y;
    UYG_Unicode[UYGIN_HM][U_BASH] = UYG_UN_HM_Y;
    UYG_Unicode[UYGIN_HM][U_OTTURA] = UYG_UN_HM_O;
    UYG_Unicode[UYGIN_HM][U_AYAQ] = UYG_UN_HM_O;
    UYG_Ulinish[UYGIN_HM] = true;
  }

  private void UInitUky() {
    UKY_Unicode[UYGIN_A][KICHIK] = UYG_UKY_A_KICHIK;
    UKY_Unicode[UYGIN_A][CHONG] = UYG_UKY_A_CHONG;

    UKY_Unicode[UYGIN_E][KICHIK] = UYG_UKY_E_KICHIK;
    UKY_Unicode[UYGIN_E][CHONG] = UYG_UKY_E_CHONG;

    UKY_Unicode[UYGIN_B][KICHIK] = UYG_UKY_B_KICHIK;
    UKY_Unicode[UYGIN_B][CHONG] = UYG_UKY_B_CHONG;

    UKY_Unicode[UYGIN_P][KICHIK] = UYG_UKY_P_KICHIK;
    UKY_Unicode[UYGIN_P][CHONG] = UYG_UKY_P_CHONG;

    UKY_Unicode[UYGIN_T][KICHIK] = UYG_UKY_T_KICHIK;
    UKY_Unicode[UYGIN_T][CHONG] = UYG_UKY_T_CHONG;

    UKY_Unicode[UYGIN_J][KICHIK] = UYG_UKY_J_KICHIK;
    UKY_Unicode[UYGIN_J][CHONG] = UYG_UKY_J_CHONG;

    //		UKY_Unicode[UYGIN_CH][KICHIK] =  UYG_UKY_CH_KICHIK;
    //		UKY_Unicode[UYGIN_CH][CHONG] =     UYG_UKY_CH_CHONG;

    UKY_Unicode[UYGIN_X][KICHIK] = UYG_UKY_X_KICHIK;
    UKY_Unicode[UYGIN_X][CHONG] = UYG_UKY_X_CHONG;

    UKY_Unicode[UYGIN_D][KICHIK] = UYG_UKY_D_KICHIK;
    UKY_Unicode[UYGIN_D][CHONG] = UYG_UKY_D_CHONG;

    UKY_Unicode[UYGIN_R][KICHIK] = UYG_UKY_R_KICHIK;
    UKY_Unicode[UYGIN_R][CHONG] = UYG_UKY_R_CHONG;

    UKY_Unicode[UYGIN_Z][KICHIK] = UYG_UKY_Z_KICHIK;
    UKY_Unicode[UYGIN_Z][CHONG] = UYG_UKY_Z_CHONG;

    //		UKY_Unicode[UYGIN_ZZ][KICHIK] =  UYG_UKY_ZZ_KICHIK;
    //		UKY_Unicode[UYGIN_ZZ][CHONG] =     UYG_UKY_ZZ_CHONG;

    UKY_Unicode[UYGIN_S][KICHIK] = UYG_UKY_S_KICHIK;
    UKY_Unicode[UYGIN_S][CHONG] = UYG_UKY_S_CHONG;

    //		UKY_Unicode[UYGIN_SH][KICHIK] =  UYG_UKY_SH_KICHIK;
    //		UKY_Unicode[UYGIN_SH][CHONG] =     UYG_UKY_SH_CHONG;

    //		UKY_Unicode[UYGIN_GH][KICHIK] =  UYG_UKY_GH_KICHIK;
    //		UKY_Unicode[UYGIN_GH][CHONG] =     UYG_UKY_GH_CHONG;

    UKY_Unicode[UYGIN_F][KICHIK] = UYG_UKY_F_KICHIK;
    UKY_Unicode[UYGIN_F][CHONG] = UYG_UKY_F_CHONG;

    UKY_Unicode[UYGIN_Q][KICHIK] = UYG_UKY_Q_KICHIK;
    UKY_Unicode[UYGIN_Q][CHONG] = UYG_UKY_Q_CHONG;

    UKY_Unicode[UYGIN_K][KICHIK] = UYG_UKY_K_KICHIK;
    UKY_Unicode[UYGIN_K][CHONG] = UYG_UKY_K_CHONG;

    UKY_Unicode[UYGIN_G][KICHIK] = UYG_UKY_G_KICHIK;
    UKY_Unicode[UYGIN_G][CHONG] = UYG_UKY_G_CHONG;

    //		UKY_Unicode[UYGIN_NG][KICHIK] =  UYG_UKY_NG_KICHIK;
    //		UKY_Unicode[UYGIN_NG][CHONG] =     UYG_UKY_NG_CHONG;

    UKY_Unicode[UYGIN_L][KICHIK] = UYG_UKY_L_KICHIK;
    UKY_Unicode[UYGIN_L][CHONG] = UYG_UKY_L_CHONG;

    UKY_Unicode[UYGIN_M][KICHIK] = UYG_UKY_M_KICHIK;
    UKY_Unicode[UYGIN_M][CHONG] = UYG_UKY_M_CHONG;

    UKY_Unicode[UYGIN_N][KICHIK] = UYG_UKY_N_KICHIK;
    UKY_Unicode[UYGIN_N][CHONG] = UYG_UKY_N_CHONG;

    UKY_Unicode[UYGIN_H][KICHIK] = UYG_UKY_H_KICHIK;
    UKY_Unicode[UYGIN_H][CHONG] = UYG_UKY_H_CHONG;

    UKY_Unicode[UYGIN_O][KICHIK] = UYG_UKY_O_KICHIK;
    UKY_Unicode[UYGIN_O][CHONG] = UYG_UKY_O_CHONG;

    UKY_Unicode[UYGIN_U][KICHIK] = UYG_UKY_U_KICHIK;
    UKY_Unicode[UYGIN_U][CHONG] = UYG_UKY_U_CHONG;

    UKY_Unicode[UYGIN_OO][KICHIK] = UYG_UKY_OO_KICHIK;
    UKY_Unicode[UYGIN_OO][CHONG] = UYG_UKY_OO_CHONG;

    UKY_Unicode[UYGIN_UU][KICHIK] = UYG_UKY_UU_KICHIK;
    UKY_Unicode[UYGIN_UU][CHONG] = UYG_UKY_UU_CHONG;

    UKY_Unicode[UYGIN_W][KICHIK] = UYG_UKY_W_KICHIK;
    UKY_Unicode[UYGIN_W][CHONG] = UYG_UKY_W_CHONG;

    UKY_Unicode[UYGIN_EE][KICHIK] = UYG_UKY_EE_KICHIK;
    UKY_Unicode[UYGIN_EE][CHONG] = UYG_UKY_EE_CHONG;

    UKY_Unicode[UYGIN_I][KICHIK] = UYG_UKY_I_KICHIK;
    UKY_Unicode[UYGIN_I][CHONG] = UYG_UKY_I_CHONG;

    UKY_Unicode[UYGIN_Y][KICHIK] = UYG_UKY_Y_KICHIK;
    UKY_Unicode[UYGIN_Y][CHONG] = UYG_UKY_Y_CHONG;

    UKY_Unicode[UYGIN_HM][KICHIK] = UYG_UKY_HM;
    UKY_Unicode[UYGIN_HM][CHONG] = UYG_UKY_HM;
  }

  // Bu putkul tekstni UKYgha  aylanduridu
  // yeni tekistni sozge aylandurmayla
  String StrUyghurToLatin(String strKonaYeziq)
  {
    StringBuffer bufUKY=new StringBuffer();
    char Herp;
    boolean bashHerp=true;   // bu Belge true bolghanda heripning chong yezilishi yezilidu
                                // Bolmisa kichik yezilishi yezilidu
    boolean sozAyrish=false; // Bu kona yeziqta yezilghan Textlerning ichide Ugen'gen degndek tekstler
                                // Kelgen chaghda kona yeziqta chataq yoq biraq yengi yezqta ng kelse ng bolghachqa
                                // chtaq chiqidu shunag arisigah ' belgisini qisturush kerek.
                                // mushuni hel qilish uchun ishlitilidu
     int index;
     for(int i=0;i<strKonaYeziq.length();i++)
     {
       Herp=strKonaYeziq.charAt(i);
       index=UGetUnicodeIndex(Herp);
       switch(index)
       {
         case -1:
           sozAyrish=false;
           if(Herp==UYG_UN_SOAL)
           {
             Herp=UYG_UKY_SOAL;
             bashHerp=true;
           }
           else if(Herp==UYG_UN_PESH)
           {
             Herp=UYG_UKY_PESH;
           }
           else if(Herp==UYG_UN_PIRSENT)
           {
             Herp=UYG_UKY_PIRSENT;
           }
           else if(Herp==UYG_UN_CHEKITPESH)
           {
             Herp=UYG_UKY_CHEKITPESH;
             bashHerp=true;
           }
           else if(Herp==UYG_UN_YULTUZ)
           {
             Herp=UYG_UKY_YULTUZ;
           }
           else if(Herp==UYG_UN_BOGHUM)
           {
             Herp=UYG_UKY_BOGHUM;
           }
           else if(Herp==UYG_UN_CHEKIT)
           {
             bashHerp=true;
           }
           else if(Herp==0x000d)
           {
             bashHerp=true;
           }
           bufUKY=bufUKY.append( Herp);
           break;
         case UYGIN_LA:
           if(bashHerp)
           {
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_L][CHONG]);
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_A][KICHIK]);
             bashHerp=false;
           }
           else
           {
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_L][KICHIK]);
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_A][KICHIK]);
           }
           break;
         case UYGIN_CH:
           if(bashHerp)
           {
             bufUKY=bufUKY.append('C');
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_H][KICHIK]);
             bashHerp=false;
           }
           else
           {
             bufUKY=bufUKY.append('c');
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_H][KICHIK]);
           }
           break;
         case UYGIN_SH:
           if(bashHerp)
           {
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_S][CHONG]) ;
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_H][KICHIK]) ;
             bashHerp=false;
           }
           else
           {
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_S][KICHIK]);
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_H][KICHIK]);
           }
           break;
         case UYGIN_GH:
           if(sozAyrish)
           {
             bufUKY=bufUKY.append(UYG_UKY_TIKPESH);
             sozAyrish=false;
           }
           if(bashHerp)
           {
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_G][CHONG]);
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_H][KICHIK]);
             bashHerp=false;
           }
           else
           {
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_G][KICHIK]);
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_H][KICHIK]);
           }
           break;
         case UYGIN_NG:
           if(bashHerp)
           {
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_N][CHONG]);
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_G][KICHIK]);
             bashHerp=false;
           }
           else
           {
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_N][KICHIK]);
             bufUKY=bufUKY.append(UKY_Unicode[UYGIN_G][KICHIK]);
           }
           break;
         case UYGIN_HM:
           break;
         case UYGIN_G:
           if(sozAyrish==true)
           {
             bufUKY=bufUKY.append(UYG_UKY_TIKPESH);
             sozAyrish=false;
           }
         default:
           if(index==UYGIN_N)
           {
             sozAyrish=true;
           }
           else
           {
             sozAyrish=false;
           }
           if(bashHerp)
           {
             bufUKY=bufUKY.append(UKY_Unicode[index][CHONG]);
             bashHerp=false;
           }
           else
           {
             bufUKY=bufUKY.append(UKY_Unicode[index][KICHIK]);
           }
           break;
       }
     }
     return bufUKY.toString();
   }

   public String StrUyghurToSlawiyan(String unicode)
   {
     char Herp,Herp1;
     char nextHerp;
     StringBuffer slBuf=new StringBuffer();
     boolean   sozAyrish=true;
     int i=0;
     if(unicode.length()>0)
     {
       i=0;
       while(i<unicode.length())
       {
         Herp=unicode.charAt(i);
         if(UIsUyghur(Herp))
         {
           Herp=CharUyghur2Slawiyan(Herp);
/*           if(Herp==0x0439){ //'й'
             i++;
             if(i<unicode.length())
             {
               nextHerp = unicode.charAt(i);
               nextHerp = CharUyghur2Slawiyan(nextHerp);
               if (nextHerp == 0x0430 //'а') {
                 Herp = 0x044f //'я';
               }
               else if (nextHerp == 0x0443 //У) {
                 Herp = 0x044E //'ю';
               }
               else {
                 slBuf.append(Herp);
                 Herp = nextHerp;
               }
             }
           }*/
           if(Herp==0xFEfC||Herp==0xFEFB){
             slBuf.append('л');
             Herp='а';
           }
         }
         if(Herp!=UYG_UN_HM_6)
         {
           slBuf.append(Herp);
         }
         i++;
       }

       sozAyrish=true;
       i=0;
       while(i<slBuf.length())
       {
         Herp=slBuf.charAt(i);
         if(sozAyrish)
         {
           Herp1=SlawiyanToUpper(Herp);
           if(Herp1!=' ')
           {
             sozAyrish=false;
           }
           Herp=Herp1;
           slBuf.setCharAt(i,Herp);
         }
         if(Herp=='?'||Herp==';'||Herp=='.')
         {
           sozAyrish=true;
         }
         i++;
       }
     }
     return slBuf.toString();
   }

   private char CharUyghur2Slawiyan(char Herp) {
     char ret = Herp;
     switch (Herp) {
       case UYG_UN_A_6:
       case UYG_UN_A_Y:
       case UYG_UN_A_A:
         ret = 0x0430 /*а*/;
         break;
       case UYG_UN_E_6:
       case UYG_UN_E_Y:
       case UYG_UN_E_A:
         ret = 0x04d9 /*ә*/;
         break;
       case UYG_UN_B_6:
       case UYG_UN_B_Y:
       case UYG_UN_B_B:
       case UYG_UN_B_O:
       case UYG_UN_B_A:
         ret = 0x0431 /*б*/;
         break;
       case UYG_UN_P_6:
       case UYG_UN_P_Y:
       case UYG_UN_P_B:
       case UYG_UN_P_O:
       case UYG_UN_P_A:
         ret = 0x043f /*п*/;
         break;
       case UYG_UN_T_6:
       case UYG_UN_T_Y:
       case UYG_UN_T_B:
       case UYG_UN_T_O:
       case UYG_UN_T_A:
         ret = 0x0442 /*т*/;
         break;
       case UYG_UN_J_6:
       case UYG_UN_J_Y:
       case UYG_UN_J_B:
       case UYG_UN_J_O:
       case UYG_UN_J_A:
         ret = 0x0497 /*җ*/;
         break;
       case UYG_UN_CH_6:
       case UYG_UN_CH_Y:
       case UYG_UN_CH_B:
       case UYG_UN_CH_O:
       case UYG_UN_CH_A:
         ret = 0x0447 /*ч*/;
         break;
       case UYG_UN_X_6:
       case UYG_UN_X_Y:
       case UYG_UN_X_B:
       case UYG_UN_X_O:
       case UYG_UN_X_A:
         ret = 0x0445 /*х*/;
         break;
       case UYG_UN_D_6:
       case UYG_UN_D_Y:
       case UYG_UN_D_A:
         ret = 0x0434 /*д*/;
         break;
       case UYG_UN_R_6:
       case UYG_UN_R_Y:
       case UYG_UN_R_A:
         ret = 0x0440 /*р*/;
         break;
       case UYG_UN_Z_6:
       case UYG_UN_Z_Y:
       case UYG_UN_Z_A:
         ret = 0x0437 /*з*/;
         break;
       case UYG_UN_ZZ_6:
       case UYG_UN_ZZ_Y:
       case UYG_UN_ZZ_A:
         ret = 0x0436 /*ж*/;
         break;
       case UYG_UN_S_6:
       case UYG_UN_S_Y:
       case UYG_UN_S_B:
       case UYG_UN_S_O:
       case UYG_UN_S_A:
         ret = 0x0441 /*с*/;
         break;
       case UYG_UN_SH_6:
       case UYG_UN_SH_Y:
       case UYG_UN_SH_B:
       case UYG_UN_SH_O:
       case UYG_UN_SH_A:
         ret = 0x0448 /*ш*/;
         break;
       case UYG_UN_GH_6:
       case UYG_UN_GH_Y:
       case UYG_UN_GH_B:
       case UYG_UN_GH_O:
       case UYG_UN_GH_A:
         ret = 0x0493 /*ғ*/;
         break;
       case UYG_UN_F_6:
       case UYG_UN_F_Y:
       case UYG_UN_F_B:
       case UYG_UN_F_O:
       case UYG_UN_F_A:
         ret = 0x0444 /*ф*/;
         break;
       case UYG_UN_Q_6:
       case UYG_UN_Q_Y:
       case UYG_UN_Q_B:
       case UYG_UN_Q_O:
       case UYG_UN_Q_A:
         ret = 0x049b /*қ*/;
         break;
       case UYG_UN_K_6:
       case UYG_UN_K_Y:
       case UYG_UN_K_B:
       case UYG_UN_K_O:
       case UYG_UN_K_A:
         ret = 0x043a /*к*/;
         break;
       case UYG_UN_G_6:
       case UYG_UN_G_Y:
       case UYG_UN_G_B:
       case UYG_UN_G_O:
       case UYG_UN_G_A:
         ret = 0x0433 /*г*/;
         break;
       case UYG_UN_NG_6:
       case UYG_UN_NG_Y:
       case UYG_UN_NG_B:
       case UYG_UN_NG_O:
       case UYG_UN_NG_A:
         ret = 0x04a3 /*ң*/;
         break;
       case UYG_UN_L_6:
       case UYG_UN_L_Y:
       case UYG_UN_L_B:
       case UYG_UN_L_O:
       case UYG_UN_L_A:
         ret = 0x043b /*л*/;
         break;
       case UYG_UN_M_6:
       case UYG_UN_M_Y:
       case UYG_UN_M_B:
       case UYG_UN_M_O:
       case UYG_UN_M_A:
         ret = 0x043c /*м*/;
         break;
       case UYG_UN_N_6:
       case UYG_UN_N_Y:
       case UYG_UN_N_B:
       case UYG_UN_N_O:
       case UYG_UN_N_A:
         ret = 0x043d /*н*/;
         break;
       case UYG_UN_H_6:
       case UYG_UN_H_Y:
       case UYG_UN_H_A:
       case UYG_UN_H_B:
       case UYG_UN_H_O:
       case UYGE_UN_H_Y: // Yulghunda Ishlitilgen
       case UYGE_UN_H_A: // Yulghunda ishlitilgen
         ret = 0x04bb /*һ*/;
         break;
       case UYG_UN_O_6:
       case UYG_UN_O_Y:
       case UYG_UN_O_A:
         ret = 0x043e /*о*/;
         break;
       case UYG_UN_U_6:
       case UYG_UN_U_Y:
       case UYG_UN_U_A:
         ret = 0x0443 /*у*/;
         break;
       case UYG_UN_OO_6:
       case UYG_UN_OO_Y:
       case UYG_UN_OO_A:
         ret = 0x04e9 /*ө*/;
         break;
       case UYG_UN_UU_6:
       case UYG_UN_UU_Y:
       case UYG_UN_UU_A:
         ret = 0x04af /*ү*/;
         break;
       case UYG_UN_W_6:
       case UYG_UN_W_Y:
       case UYG_UN_W_A:
         ret = 0x0432 /*в*/;
         break;
       case UYG_UN_EE_6:
       case UYG_UN_EE_Y:
       case UYG_UN_EE_B:
       case UYG_UN_EE_O:
       case UYG_UN_EE_A:
         ret = 0x0435 /*е*/;
         break;
       case UYG_UN_I_6:
       case UYG_UN_I_Y:
       case UYG_UN_I_B:
       case UYG_UN_I_O:
       case UYG_UN_I_A:
         ret = 0x0438 /*и*/;
         break;
       case UYG_UN_Y_6:
       case UYG_UN_Y_Y:
       case UYG_UN_Y_B:
       case UYG_UN_Y_O:
       case UYG_UN_Y_A:
         ret = 0x0439 /*й*/;
         break;
       case UYG_UN_HM_6:
       case UYG_UN_HM_Y:
       case UYG_UN_HM_O:
         ret = UYG_UN_HM_6;
         break;
       case UYG_UN_SOAL:
         ret = UYG_UKY_SOAL;
         break;
       case UYG_UN_PESH:
         ret = UYG_UKY_PESH;
         break;
       case UYG_UN_PIRSENT:
         ret = UYG_UKY_PIRSENT;
         break;
       case UYG_UN_CHEKITPESH:
         ret = UYG_UKY_CHEKITPESH;
         break;
       case UYG_UN_YULTUZ:
         ret = UYG_UKY_YULTUZ;
         break;
       default:
         break;
     }
     return ret;
   }

   private char SlawiyanToUpper(char Herp)
   {
     char UHerp=Herp;
     switch(Herp)
     {
       case  0x0430:	/*а*/
       case  0x0410  : /*А*/
         UHerp=0x0410;
         break;
       case  0x04d9:	/*ә*/
       case  0x04d8:   /*Ә*/
         UHerp=0x04d8;
         break;
       case  0x0435:	/*е*/
       case  0x0415:   /*Е*/
         UHerp=0x0415;
         break;
       case  0x0438:	/*и*/
       case  0x0418:   /*И*/
         UHerp=0x0418;
         break;
       case  0x043e:	/*о*/
       case  0x041e:   /*О*/
         UHerp=0x041e;
         break;
       case  0x0443:	/*у*/
       case  0x0423:   /*У*/
         UHerp=0x0423;
         break;
       case  0x04e9:	/*ө*/
       case  0x04e8:   /*Ө*/
         UHerp=0x04e8;
         break;
       case  0x04af:	/*ү*/
       case  0x04AE:   /*Ү*/
         UHerp=0x04AE;
         break;
       case  0x0431:	/*б*/;
       case  0x0411  : /*Б*/
         UHerp=0x0411;
         break;
       case  0x043f :	/*п*/
       case  0x041F :  /*П*/
         UHerp=0x041F;
         break;
       case  0x0442  :	/*т*/
       case  0x0422  : /*Т*/
         UHerp=0x0422;
         break;
       case  0x0497:	/*җ*/
       case  0x0496:   /*Җ*/
         UHerp=0x0496;
         break;
       case  0x0447:	/*ч*/
       case  0x0427 :  /*Ч*/
         UHerp=0x0427;
         break;
       case  0x0445:	/*х*/
       case  0x0425:   /*Х*/
         UHerp=0x0425;
         break;
       case  0x0434:	/*д*/
       case  0x0414:   /*Д*/
         UHerp=0x0414;
         break;
       case  0x0440:	/*р*/
       case  0x0420:   /*Р*/
         UHerp=0x0420;
         break;
       case  0x0437:	/*з*/
       case  0x0417:   /*З*/
         UHerp=0x0417;
         break;
       case  0x0436:	/*ж*/
       case  0x0416:   /*Ж*/
         UHerp=0x0416;
         break;
       case  0x0441:	/*с*/
       case  0x0421:   /*С*/
         UHerp=0x0421;
         break;
       case  0x0448:	/*ш*/
       case  0x0428:   /*Ш*/
         UHerp=0x0428;
         break;
       case  0x0493:	/*ғ*/
       case  0x0492:   /*Ғ*/
         UHerp=0x0492;
         break;
       case  0x0444:	/*ф*/
       case  0x0424:   /*Ф*/
         UHerp=0x0424;
         break;
       case  0x049b:	/*қ*/
       case  0x049A:   /*Қ*/
         UHerp=0x049A;
         break;
       case  0x043a:	/*к*/
       case  0x041a:   /*К*/
         UHerp=0x041a;
         break;
       case  0x0433:	/*г*/
       case  0x0413:   /*Г*/
         UHerp=0x0413;
         break;
       case  0x04a3:	/*ң*/
       case  0x04a2:   /*Ң*/
         UHerp=0x04a2;
         break;
       case  0x043b:	/*л*/
       case  0x041B:   /*Л*/
         UHerp=0x041B;
         break;
       case  0x043c:	/*м*/
       case  0x041c:   /*М*/
         UHerp=0x041c;
         break;
       case  0x043d:	/*н*/
       case  0x041D:   /*Н*/
         UHerp=0x041D;
         break;
       case  0x04bb:	/*һ*/
       case  0x04ba:   /*Һ*/
         UHerp=0x04ba;
         break;
       case  0x0432:	/*в*/
       case  0x0412:   /*В*/
         UHerp=0x0412;
         break;
       case  0x0439:	/*й*/
       case  0x0419:   /*Й*/
         UHerp=0x0419;
         break;
       case  0x044f:   /*'я'*/
       case  0x042F:   /*Я*/
         UHerp=0x042F;
         break;
       case  0x044E: /*'ю'*/
       case  0x042E: /*Ю*/
         UHerp=0x042E;
         break;
       default:
         UHerp=Herp;
         break;
     }
     return UHerp;
   }

   String StrLatinToUyghur(String uky)
   {
     StringBuffer bufKonaYeziq=new StringBuffer();
     StringBuffer stTok=new StringBuffer();
     String       tok;
     char Herp;
     for(int i=0;i<uky.length();i++)
     {
       Herp=uky.charAt(i);
       if(Herp==0x20||Herp=='('|| Herp==')'){
         tok=stTok.toString();
         if(Aylandurmamdu(tok)){
            bufKonaYeziq=bufKonaYeziq.append(tok);
            bufKonaYeziq=bufKonaYeziq.append(GetUyghurFromLatin(""+Herp));
         }
         else{
           bufKonaYeziq = bufKonaYeziq.append(GetUyghurFromLatin(tok+Herp));
         }
         stTok=stTok.delete(0,stTok.length());
       }
       else{
         stTok=stTok.append(Herp);
       }
     }
     if(stTok.length()>0){
       tok=stTok.toString();
       if(Aylandurmamdu(tok)){
          bufKonaYeziq=bufKonaYeziq.append(tok);
       }
       else{
         bufKonaYeziq = bufKonaYeziq.append(GetUyghurFromLatin(tok));
       }
     }
     // Her bir jumlining beshi we axiridiki boshluqni chiqirwetkenlihi uchun
     // bu yerde axirighan bir boshluq qoqshimiz
     bufKonaYeziq.append(' ');
     String tmp=bufKonaYeziq.toString();
     return tmp;
   }


   String StrLatinToSlawiyan(String uky)
   {
     StringBuffer bufslYeziq=new StringBuffer();
     StringBuffer stTok=new StringBuffer();
     String       tok;
     char Herp;
     for(int i=0;i<uky.length();i++)
     {
       Herp=uky.charAt(i);
       if(Herp==0x20||Herp=='('|| Herp==')'){
         tok=stTok.toString();
         if(Aylandurmamdu(tok)){
            bufslYeziq.append(tok);
            bufslYeziq.append(Herp);
         }
         else{
           bufslYeziq.append(GetSlawiyanFromLatin(tok+Herp));
         }
         stTok=stTok.delete(0,stTok.length());
       }
       else{
         stTok=stTok.append(Herp);
       }
     }
     if(stTok.length()>0){
       tok=stTok.toString();
       if(Aylandurmamdu(tok)){
          bufslYeziq.append(tok);
       }
       else{
         bufslYeziq.append(GetSlawiyanFromLatin(tok));
       }
     }
     // Her bir jumlining beshi we axiridiki boshluqni chiqirwetkenlihi uchun
     // bu yerde axirighan bir boshluq qoqshimiz
     bufslYeziq.append(' ');
     return bufslYeziq.toString();
   }

   private boolean UIsAllUzukTawush(String soz)
   {
     boolean ret=true;
     char Herp;
     for(int i=0;i<soz.length();i++)
     {
       Herp=soz.charAt(i);
       if(UIsSozuqTawushUKY(Herp)){
         ret=false;
         break;
       }
     }
     return ret;
   }

   private boolean Aylandurmamdu(String soz)
   {
     boolean ret=false;
     if(MuqimSozler==null){
       return ret;
     }
     String tok=soz.toUpperCase();
     if(this.MuqimSozler.contains(tok)){
       ret=true;
     }
     else if(tok.indexOf("@")>=0 ||
             tok.indexOf("\\")>=0||tok.indexOf("#")>=0||
             tok.indexOf("WWW")>=0||tok.indexOf("HTTP")>=0||
             tok.indexOf(".MSI")>=0||tok.indexOf(".TXT")>=0||
             tok.indexOf(".ZIP")>=0||tok.indexOf(".MP3")>=0||
             tok.indexOf(".LZH")>=0||tok.indexOf(".RAR")>=0||
             tok.indexOf(".EXE")>=0||tok.indexOf(".UUT")>=0||
             tok.indexOf(".COM")>=0||tok.indexOf(".BAS")>=0||
             tok.indexOf("FTP")>=0||tok.indexOf(".RAM")>=0||
             tok.indexOf(".PHP")>=0||tok.indexOf(".CGI")>=0||
             tok.indexOf(".CLASS")>=0||tok.indexOf(".JAVA")>=0||
             tok.indexOf("+")>=0||tok.indexOf("/")>=0)
     {
       ret=true;
     }
     return ret;
   }

  //Bu bir Sozni kona yeziqqa aylanduridu
  private String GetUyghurFromLatin(String uky)
  {
    StringBuffer bufKonaYeziq=new StringBuffer();
    char Herp;
    int index;
    int aldinqiindex=-1;
    int Pos=0;
    String tmp;
    for(int i=0;i<uky.length();i++)
    {
      Herp=uky.charAt(i);
      if(Herp=='&'){
        Pos=uky.indexOf(';',i);
        if(Pos!=-1){
          tmp=uky.substring(i,Pos+1);
          bufKonaYeziq.append(tmp);
          i=Pos;
          aldinqiindex=-1;
          continue;
        }
      }
      index=UGetUKYIndex(Herp);
      switch(index)
      {
        case -1:
          if(Herp==UYG_UKY_SOAL)
          {
            Herp=UYG_UN_SOAL;
          }
          else if(Herp==UYG_UKY_PESH)
          {
            Herp=UYG_UN_PESH;
          }
          else if(Herp==UYG_UKY_PIRSENT)
          {
            Herp=UYG_UN_PIRSENT;
          }
          else if(Herp==UYG_UKY_CHEKITPESH)
          {
            Herp=UYG_UN_CHEKITPESH;
          }
          else if(Herp==UYG_UKY_YULTUZ)
          {
            Herp=UYG_UN_YULTUZ;
          }
          else if(Herp==0x201c || Herp==0x0093||Herp==0x201d|| Herp==0x0094){
            Herp='"';
          }
          if(aldinqiindex!=-1)
          {
            bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[aldinqiindex][U_6]);
            aldinqiindex=-1;
          }
          if(Herp=='C' ||Herp=='c')
          {
            aldinqiindex=UYGIN_CH;
          }
          // Bularni UKY diki herp ayrighuchi yeni mesh'el degendek sozlerde ishlitilish ehtimalliqi bar belge
          else if(Herp==UYG_UKY_TIKPESH || Herp=='\''||Herp=='\u0092')
          {
            bufKonaYeziq.append(UYG_UN_HM_6);
          }
          else{
            if(Herp=='\u0093'||Herp=='\u0094'){
                Herp='"';
            }
            bufKonaYeziq.append(Herp);
          }
          break;
          // Qosh Heriplerning bash heripimu hokum qilidu
        case UYGIN_G:
        case UYGIN_S:
        case UYGIN_N:
          if(aldinqiindex==-1)
          {
            aldinqiindex=index;
          }
          else
          {
            if(aldinqiindex==UYGIN_N && index==UYGIN_G)
            {
              bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[UYGIN_NG][U_6]);
              aldinqiindex=-1;
            }
            else
            {
              bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[aldinqiindex][U_6]);
              aldinqiindex=index;
            }
          }
          break;
        default:
          if(aldinqiindex!=-1)
          {
            if(aldinqiindex==UYGIN_CH && index==UYGIN_H)
            {
              bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[UYGIN_CH][U_6]);
            }
            else if(aldinqiindex==UYGIN_G && index==UYGIN_H)
            {
              bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[UYGIN_GH][U_6]);
            }
            else if(aldinqiindex==UYGIN_S && index==UYGIN_H)
            {
              bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[UYGIN_SH][U_6]);
            }
            else if(aldinqiindex==UYGIN_N && index==UYGIN_G)
            {
              bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[UYGIN_NG][U_6]);
            }
            else
            {
              bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[aldinqiindex][U_6]);
              bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[index][U_6]);
            }
            aldinqiindex=-1;
          }
          else
          {
            bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[index][U_6]);
          }
          break;
      }
    }
    if(aldinqiindex!=-1)
    {
      bufKonaYeziq=bufKonaYeziq.append(UYG_Unicode[aldinqiindex][U_6]);
    }

    tmp=bufKonaYeziq.toString();
    tmp= HemzeQosh(tmp);
    return tmp;
  }

  //Bu bir Sozni kona yeziqqa aylanduridu
  private String GetSlawiyanFromLatin(String uky)
  {
    StringBuffer bufKonaYeziq=new StringBuffer();
    char Herp;
    char alHerp=0;
    int index;
    int Pos;
    String tmp;
    for(int i=0;i<uky.length();i++)
    {
      Herp=uky.charAt(i);
      if(Herp=='&'){
        Pos=uky.indexOf(';',i);
        if(Pos!=-1){
          tmp=uky.substring(i,Pos+1);
          bufKonaYeziq.append(tmp);
          i=Pos;
          alHerp=0;
          continue;
        }
      }

      if(alHerp!=0)
      {
        if((alHerp=='C'||alHerp=='c') && (Herp=='H'||Herp=='h'))
        {
          if(alHerp=='C')
          {
            bufKonaYeziq.append('Ч');
          }
          else
          {
            bufKonaYeziq.append('ч');
          }
          alHerp = 0;
        }
        else if((alHerp== 'g' || alHerp == 'G') && (Herp=='H'||Herp=='h'))
        {
          if(alHerp=='G'){
            bufKonaYeziq.append('Ғ');
          }else{
            bufKonaYeziq.append('ғ');
          }
          alHerp = 0;
        }
        else if((alHerp=='S'|| alHerp=='s') && (Herp=='H'||Herp=='h'))
        {
          if(alHerp=='S')
          {
            bufKonaYeziq.append('Ш');
          }
          else
          {
            bufKonaYeziq.append('ш');
          }
          alHerp = 0;
        }
        else if((alHerp == 'N' || alHerp == 'n') && (Herp == 'g' || Herp == 'G'))
        {
          if(alHerp=='N')
          {
            bufKonaYeziq.append('Ң');
          }
          else
          {
            bufKonaYeziq.append('ң');
          }
          alHerp = 0;
        }
        else if(alHerp=='Y' ||alHerp=='y')
        {
          if(Herp=='A')
          {
            bufKonaYeziq.append('Я');
            alHerp = 0;
          }
          else if(Herp=='a'){
            bufKonaYeziq.append('я');
            alHerp = 0;
          }
          else if(Herp=='U')
          {
            bufKonaYeziq.append('Ю');
            alHerp = 0;
          }
          else if(Herp=='u'){
            bufKonaYeziq.append('ю');
            alHerp = 0;
          }
          else{
            bufKonaYeziq.append(CharLatin2Slawiyan(alHerp));
            alHerp = Herp;
          }
        }
        else
        {
          bufKonaYeziq.append(CharLatin2Slawiyan(alHerp));
          switch (Herp) {
            case 'Y':
            case 'y':
            case 'C':
            case 'c':
            case 'G':
            case 'g':
            case 'S':
            case 's':
            case 'N':
            case 'n':
                alHerp = Herp;
                break;
            default:
              bufKonaYeziq.append(CharLatin2Slawiyan(Herp));
              alHerp=0;
              break;
          }
        }
      }
      else
      {
        switch (Herp) {
          case 'Y':
          case 'y':
          case 'C':
          case 'c':
          case 'G':
          case 'g':
          case 'S':
          case 's':
          case 'N':
          case 'n':
            if (alHerp == 0) {
              alHerp = Herp;
            }
            else
            {
              if ((alHerp == 'N' || alHerp == 'n') && (Herp == 'g' || Herp == 'G')) {
                if(alHerp=='N')
                {
                  bufKonaYeziq.append('Ң');
                }
                else
                {
                  bufKonaYeziq.append('ң');
                }
                alHerp = 0;
              }
              else {
                bufKonaYeziq.append(CharLatin2Slawiyan(alHerp));
                alHerp = Herp;
              }
            }
            break;
          default:
            bufKonaYeziq.append(CharLatin2Slawiyan(Herp));
            break;
        }
      }
    }
    if(alHerp!=0)
    {
      bufKonaYeziq=bufKonaYeziq.append(CharLatin2Slawiyan(alHerp));
    }
    tmp=bufKonaYeziq.toString();
    return tmp;
  }

  // Bu Bash yezilishi arliqi ipadilengen Unicode herip tizmisini
  // Nolmal ulanghan Textke aylanduurp beridu
  private String  HemzeQosh(String esliBuf)
  {
    StringBuffer desBuf=new StringBuffer();
    char Herp;
    int Index=-1;
    boolean bashtin=true;
    boolean aldinqisiSozuq=false;
    int i=0;
    for(i=0;i<esliBuf.length();i++)
    {
      Herp=esliBuf.charAt(i);
      Index=UGetUnicodeIndex(Herp);
      if(Index==-1)
      {
        bashtin=true;
      }
      else
      {
        if (bashtin||aldinqisiSozuq)
        {
            bashtin=false;
            aldinqisiSozuq=false;
            // A,E,EE,I,O,OO,U,UU
            // qatarliq heripler qurning beshida kelse aldigha hemzini qoshudu
            if(Index==UYGIN_A || Index==UYGIN_E ||Index==UYGIN_I ||Index==UYGIN_EE ||Index==UYGIN_O ||Index==UYGIN_OO ||Index==UYGIN_U ||Index==UYGIN_UU )
            {
               desBuf=desBuf.append(UYG_Unicode[UYGIN_HM][U_6]);
            }
        }
        else if(Index==UYGIN_A || Index==UYGIN_E ||Index==UYGIN_I ||Index==UYGIN_EE ||Index==UYGIN_O ||Index==UYGIN_OO ||Index==UYGIN_U ||Index==UYGIN_UU )
        {
          aldinqisiSozuq=true;
        }
        else
        {
            aldinqisiSozuq=false;
        }
      }
      if(Index==UYGIN_HM)
      {
        if((i+1)<esliBuf.length() && UIsSozuqTawushUN(esliBuf.charAt(i+1))==false)
        {
           continue;
        }
        desBuf=desBuf.append(Herp);
      }
      else
      {
        desBuf=desBuf.append(Herp);
      }
    }
    return desBuf.toString();
  }


  // Bu Bash yezilishi arliqi ipadilengen Unicode herip tizmisini
  // Nolmal ulanghan Textke aylanduurp beridu
  private String  UUlash_ORG(String esliBuf)
  {
    StringBuffer desBuf=new StringBuffer();
    char Herp;
    int Index=-1,aldinqiIndex=-1;
    int aldinqiyezilishi=0;          // Yalghuz yaki Ayaq yezilishi hatirlindu
    boolean bashtin=true;
    int i=0;
    int len=0;
    for(i=0;i<esliBuf.length();i++)
    {
      Herp=esliBuf.charAt(i);
      Index=UGetUnicodeIndex(Herp);
      if(Index==-1)
      {
        bashtin=true;
        desBuf=desBuf.append(Herp);
        len++;
      }
      else
      {
        if (bashtin)
        {
            aldinqiIndex=Index;
            bashtin=false;
            // A,E,EE,I,O,OO,U,UU
            // qatarliq heripler qurning beshida kelse aldigha hemzini qoshudu
            if(Index==UYGIN_A || Index==UYGIN_E ||Index==UYGIN_I ||Index==UYGIN_EE ||Index==UYGIN_O ||Index==UYGIN_OO ||Index==UYGIN_U ||Index==UYGIN_UU )
            {
               desBuf=desBuf.append(UYG_Unicode[UYGIN_HM][U_BASH]);
               desBuf=desBuf.append(UYG_Unicode[Index][U_AYAQ]);
               aldinqiyezilishi=U_AYAQ;
               len++;
               len++;
            }
            else
            {
               desBuf=desBuf.append(UYG_Unicode[Index][U_YALGHUZ]);
               aldinqiyezilishi=U_YALGHUZ;
               len++;
            }
          }
          else
          {
            // Aldinqi herpke qoshup yazghili bolamdu tekshuridu
            // Qoshup yazghili bolsa
            if (UYG_Ulinish[aldinqiIndex])
            {
              // Aldinqi heripning yezilishini ozgertidu yeni
              // aldinqi heripni ozgertidu
              if(aldinqiyezilishi==U_YALGHUZ)
              {
                 desBuf.setCharAt(len-1,UYG_Unicode[aldinqiIndex][U_BASH]);
              }
              else
              {
                 desBuf.setCharAt(len-1,UYG_Unicode[aldinqiIndex][U_OTTURA]);
              }
              // Hazirqi Herp ayaq yezilishi bolishi kerek
              desBuf=desBuf.append(UYG_Unicode[Index][U_AYAQ]);
              len++;
              aldinqiyezilishi=U_AYAQ;
          }
          else
          {
              desBuf=desBuf.append(UYG_Unicode[Index][U_YALGHUZ]);
              len++;
              aldinqiyezilishi=U_YALGHUZ;             // Keyinki Haripning Bash yezilishi kerek
          }
          aldinqiIndex=Index;
        }
      }
    }
    return desBuf.toString();
  }

   // Bu berilgen Jumlini sozlerge aylandurup beridu
   // Hazirche ishlitilmidi
  String[] getSozler(String uky) {
    Vector sozVec = new Vector();
    StringBuffer bufKonaYeziq = new StringBuffer();
    StringBuffer stTok = new StringBuffer();
    String tok;
    char Herp;
    for (int i = 0; i < uky.length(); i++) {
      Herp = uky.charAt(i);
      if (Herp == 0x20) {
        stTok.append(Herp);
        continue;
      }
      if (Herp == '&') {
        if (stTok.length() > 0) {
          sozVec.addElement(stTok.toString());
          stTok = stTok.delete(0, stTok.length());
        }
        stTok.append(Herp);
        continue;
      }
      if (Herp == ';') {
        if (stTok.charAt(0) == '&') {
          stTok.append(Herp);
          sozVec.addElement(stTok.toString());
          stTok = stTok.delete(0, stTok.length());
        }
        else {
          sozVec.addElement(stTok.toString());
          stTok = stTok.delete(0, stTok.length());
          stTok.append(Herp);
        }
        continue;
      }
      if (Herp == '(' || Herp == ')' || Herp == '"' || Herp == '?' ||
          Herp == ',' || Herp == '-') {
        if (stTok.length() > 0) {
          sozVec.addElement(stTok.toString());
          stTok = stTok.delete(0, stTok.length());
        }
        else {
          stTok.append(Herp);
        }
        continue;
      }
      stTok = stTok.append(Herp);
    }
    if (stTok.length() > 0) {
    }
    return (String[]) sozVec.toArray();
  }

  public char CharLatin2Slawiyan(char Herp)
  {
      char ret=Herp;
      switch(Herp)
      {
        case  'A':
          ret='А';
          break;
        case  'a':
          ret='а';
          break;
        case  'E':
          ret='Ә';
          break;
        case  'e':
          ret='ә';
          break;
        case  'B':
          ret='Б';
          break;
        case  'b':
          ret='б';
          break;
        case  'P' :
          ret='П';
          break;
        case  'p' :
          ret='п';
          break;
        case  'T' :
          ret='Т';
        case  't' :
          ret='т';
          break;
        case  'J'  :
          ret='Җ';
          break;
        case  'j'  :
          ret='җ';
          break;
        case  'X' :
          ret='Х';
          break;
        case  'x' :
          ret='х';
          break;
        case  'D'  :
          ret='Д';
        case  'd'  :
          ret='д';
          break;
        case  'R' :
          ret='Р';
        case  'r' :
          ret='р';
          break;
        case  'Z' :
          ret='З';
          break;
        case  'z' :
          ret='з';
          break;
        case  'S':
          ret='С';
          break;
        case  's':
          ret='с';
          break;
        case  'F':
          ret='Ф';
        case  'f':
          ret='ф';
          break;
        case  'Q':
          ret='Қ';
          break;
        case  'q' :
          ret='қ';
          break;
        case  'K':
          ret='К';
          break;
        case  'k':
          ret='к';
          break;
        case  'G':
          ret='Г';
          break;
        case  'g' :
          ret='г';
          break;
        case  'L':
          ret='Л';
          break;
        case  'l':
          ret='л';
          break;
        case  'M':
          ret='М';
          break;
        case  'm':
          ret='м';
          break;
        case  'N':
          ret='Н';
          break;
        case  'n':
          ret='н';
          break;
        case  'H':
          ret='Һ';
          break;
        case  'h':
          ret='һ';
          break;
        case  'O':
          ret='О';
          break;
        case  'o':
          ret='о';
          break;
        case  'U':
          ret='У';
          break;
        case  'u':
          ret='у';
          break;
        case  'Ö':
          ret='Ө';
          break;
        case  'ö':
          ret='ө';
          break;
        case  'Ü':
          ret='Ү';
          break;
        case  'ü':
          ret='ү';
          break;
        case  'V':
        case  'W':
          ret='В';
          break;
        case  'v':
        case  'w':
          ret='в';
          break;
        case  'É':
          ret='Ә';
          break;
        case  'é':
          ret='е';
          break;
        case  'I':
          ret='И';
          break;
        case  'i':
          ret='и';
          break;
        case  'Y':
          ret='Й';
          break;
        case  'y':
          ret='й';
          break;
        default:
          break;
      }
      return ret;
    }
}
