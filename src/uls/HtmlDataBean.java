package uls;

public class HtmlDataBean {
  private StringBuffer Text;
  private boolean      html;
  public HtmlDataBean() {
    Text=new StringBuffer();
    html=false;
  }
  public void setHtml(boolean newV)
  {
    html=newV;
  }
  public boolean isHtmlTag(){
    return html;
  }
  public void append(char a)
  {
    if(a==0x0a|| a==0x0d)
    {
      a=' ';
    }
    Text=Text.append(a);
  }

  public void append(String str)
  {
    Text=Text.append(str);
  }


  public void insert(int index,String str)
  {
    Text=Text.insert(index,str);
  }

  public StringBuffer getText()
  {
    return Text;
  }

  public void updateAttribute(String atrName,String parPath)
  {
    if(html==false) return;
    int stPos;
    String atrval=getAttributeVal(atrName);
    if(atrval!=null)
    {
      atrval=this.getMutleqyol(parPath,atrval);
      if(atrval==null) return;
      atrval=" " +atrName+"="+"\""+atrval+"\"";
      stPos = delAttribute(atrName);
      Text.insert(stPos,atrval);
      atrval=toString();
    }
    return ;
  }

  public void updateStyle(String url)
  {
      if(html==false) return;
      String str=Text.toString().toLowerCase();
      int pos=str.indexOf("@import");
      if(pos==-1) return;
      pos=pos+7;
      pos=str.indexOf("url(",pos);
      if(pos==-1) return;
      pos=pos+4;
      while(str.charAt(pos)==0x0020){
          pos++;
      }
      if(str.startsWith("http://",pos)==false)
      {
        Text.insert(pos,url+"/");
      }
  }

  public void updateAttribute(String atrName,String parPath,String terjiman)
  {
    if(html==false) return;
    int stPos;
    String atrval=getAttributeVal(atrName);
    if(atrval!=null)
    {
      atrval=getMutleqyol(parPath,atrval);
      if(atrval==null) return;
//      atrval = "\"" + atrval + "\"";
//      atrval = "%22" + atrval + "%22";
//      atrval=" " +atrName+"="+"\""+atrval+"\"";
      atrval=" " +atrName+"=\""+terjiman+atrval+"\"";
      stPos = delAttribute(atrName);
      Text.insert(stPos,atrval);
      atrval=toString();
    }
    return ;
  }

  private String getMutleqyol(String parPath,String nispiYol)
  {
      int stPos;
      nispiYol=nispiYol.replaceAll("\""," ").trim();
      nispiYol=nispiYol.replaceAll("'"," ").trim();
      if(nispiYol.startsWith("http://")) return nispiYol;
      if(nispiYol.startsWith("rtsp://")) return null;
      if(nispiYol.startsWith("mailto:")) return null;
      if(nispiYol.equals(""))return null;
      while((nispiYol.length()>0) && (nispiYol.charAt(0)=='.'))
      {
        if (nispiYol.startsWith("./")) {
          nispiYol=nispiYol.substring(2);
        }
        if(nispiYol.startsWith("../")){
           nispiYol=nispiYol.substring(3);
           stPos=parPath.lastIndexOf("/");
           if(stPos>8){
             parPath=parPath.substring(0,stPos);
           }
        }
      }
      if(nispiYol.length()==0) return null;
      if(nispiYol.charAt(0)=='/')
      {
         stPos=parPath.indexOf("/",9);
         if(stPos!=-1){
           parPath=parPath.substring(0,stPos);
         }
        nispiYol = parPath + nispiYol;
      }
      else
      {
        nispiYol =parPath +"/"+ nispiYol;
      }
      return nispiYol;
  }

  public boolean isEndTag()
  {
    boolean ret=false;
    if(Text.length()>1 && Text.charAt(0)=='<' && Text.charAt(1)=='/'){
      ret=true;
    }
    return ret;
  }

  public boolean isTag(String tagName)
  {
    boolean ret=false;
    if(html)
    {
      if(tagName.trim().equals("DIV")){
        ret=false;
      }
      tagName=tagName.toUpperCase();
      if (Text.charAt(0) == '<') {
        while (Text.length()>1 && Text.charAt(1) == 0x20) {
          Text = Text.deleteCharAt(1);
        }
        ret=Text.toString().toUpperCase().startsWith("<"+tagName);
      }
    }
    return ret;
  }

  public void setAttribute(String name,String value)
  {
    int pos;
    if(html)
    {
      pos=delAttribute(name);
      pos = 0;
      while (pos<Text.length() && Text.charAt(pos) != '>') {
        pos++;
      }
      Text.insert(pos, " " + name + "=\"" + value + "\"");
    }
  }

  public void replaceAttribute(String name,String value,String newValue)
  {
    int pos;
    if(html)
    {
      String val=getAttributeVal(name);
      if(val==null) return;
      if(val.toUpperCase().indexOf(value.toUpperCase())!=-1){
        pos=delAttribute(name);
      }else{
        return;
      }
      pos = 0;
      while (pos<Text.length() && Text.charAt(pos) != '>') {
        pos++;
      }
      Text.insert(pos, " " + name + "=\"" + newValue + "\"");
    }
  }

  public int delAttribute(String name)
  {
    int st,end,tmp;
    st=-1;
    if(html==false) return st;
    String tag=Text.toString().toUpperCase();
    name=name.toUpperCase();
    st=tag.indexOf(" "+name);
    if(st!=-1)
    {
      end=st+name.length()+1;
      tmp=tag.indexOf('=',end);
      if(tmp!=-1)
      {
        end=tmp+1;
        if(Text.charAt(end)==0x20)
        {
          while (Text.charAt(end) == 0x20) {
            end++;
          }
        }
        if(Text.charAt(end)=='"'){
          end++;
          while (Text.charAt(end) !='"')end++;
          end++;
        }
        else {
          while (Text.charAt(end) != 0x20 && Text.charAt(end) != '>')end++;
        }
      }
      Text.delete(st,end);
    }
    return st;
  }

  public String getAttributeVal(String name)
  {
    String val=null;
    if(html==false) return val;
    String tag=Text.toString().toUpperCase();
    int st,end,tmp,stPos;
    st=tag.indexOf(" "+name.toUpperCase());
    if(st!=-1)
    {
      end=st+name.length()+1;
      tmp=tag.indexOf('=',end);
      if(tmp!=-1)
      {
        end=tmp+1;
        stPos=end;
        if(Text.charAt(end)==0x20)
        {
          while (Text.charAt(end) == 0x20) {
            end++;
          }
        }
        if(Text.charAt(end)=='"'){
          end++;
          end=Text.indexOf("\"",end);
          if(end>0){
            end++;
            val = Text.substring(stPos, end);
          }else{
            val=null;
          }
        }
        else {
          while (Text.charAt(end) != 0x20 && Text.charAt(end) != '>')end++;
          val=Text.substring(stPos,end);
        }
      }
    }
    return val;
  }




  public String toString(){
    if(html==false)
    {
      char Herp;
      int Pos;
      String uky=Text.toString();
      uky=uky.replaceAll("&uuml;",""+Aylandurghuch.UYG_UKY_UU_KICHIK);
      uky=uky.replaceAll("&Uuml;",""+Aylandurghuch.UYG_UKY_UU_CHONG);
      uky=uky.replaceAll("&Ouml;",""+Aylandurghuch.UYG_UKY_UU_CHONG);
      uky=uky.replaceAll("&ouml;",""+Aylandurghuch.UYG_UKY_UU_KICHIK);
      uky=uky.replaceAll("&eacute;",""+Aylandurghuch.UYG_UKY_UU_KICHIK);
      uky=uky.replaceAll("&Eacute;",""+Aylandurghuch.UYG_UKY_UU_CHONG);
      uky=uky.replaceAll("&rsquo;", ""+Aylandurghuch.UYG_UKY_TIKPESH);
      uky=uky.replaceAll("&nbsp;"," ").trim();

      StringBuffer newBuf=new StringBuffer();
      String tmp;
      int len=uky.length();
      for(int i=0;i<len;i++)
      {
        Herp=uky.charAt(i);
        if(Herp=='&'&&(i+1)<len && uky.charAt(i+1)=='#'){
          Pos=uky.indexOf(';',i);
          if(Pos!=-1 && Pos>(i+2)){
            tmp=uky.substring(i+2,Pos);
            try{
              Herp = (char) Integer.parseInt(tmp);
              newBuf.append(Herp);
              i = Pos;
              continue;
            }catch(Exception ee){
            }
          }
        }
        newBuf.append(Herp);
      }
      return newBuf.toString();
    }
    else
    {
      return Text.toString();
    }
  }
}
