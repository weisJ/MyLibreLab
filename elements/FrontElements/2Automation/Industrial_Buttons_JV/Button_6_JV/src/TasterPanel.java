//*****************************************************************************
//* Element of MyOpenLab Library                                              *
//*                                                                           *
//* Copyright (C) 2004  Carmelo Salafia (cswi@gmx.de)                         *
//* Copyright (C) 2018  Javier Velasquez (javiervelasquez125@gmail.com)                                                                          *
//* This library is free software; you can redistribute it and/or modify      *
//* it under the terms of the GNU Lesser General Public License as published  *
//* by the Free Software Foundation; either version 2.1 of the License,       *
//* or (at your option) any later version.                                    *
//* http://www.gnu.org/licenses/lgpl.html                                     *
//*                                                                           *
//* This library is distributed in the hope that it will be useful,           *
//* but WITHOUTANY WARRANTY; without even the implied warranty of             *
//* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                      *
//* See the GNU Lesser General Public License for more details.               *
//*                                                                           *
//* You should have received a copy of the GNU Lesser General Public License  *
//* along with this library; if not, write to the Free Software Foundation,   *
//* Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110, USA                  *
//*****************************************************************************


import VisualLogic.*;
import VisualLogic.variables.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import tools.*;
import java.awt.geom.Rectangle2D;
import javax.swing.event.MouseInputAdapter;



public class TasterPanel extends JVSMain
{
  
  private int sizeW=150;
  private int sizeH=150;
  
  private boolean value=false;
  private VSBoolean down=new VSBoolean(false);
  private ExternalIF circuitElement;
  private VSInteger strokeValue = new VSInteger(2);
  private BasicStroke stroke = new BasicStroke(1);
  private BasicStroke strokeLine = new BasicStroke(1);
  private boolean mouseOver=false; 
  private boolean running=false; 
  
  
  private VSBoolean initValue=new VSBoolean(false);
  private VSBoolean asSwitch = new VSBoolean(true);
  private VSBoolean textVisible = new VSBoolean(true);
  private VSString captionON = new VSString("ON");
  private VSString captionOFF = new VSString("OFF");
  private VSBoolean baseVisible = new VSBoolean(true);
  private VSColorAdvanced baseColor = new VSColorAdvanced();
  private VSColorAdvanced strokeBaseColor = new VSColorAdvanced();
  private VSColorAdvanced shadowLigthColor = new VSColorAdvanced();
  private VSColorAdvanced shadowDarkColor = new VSColorAdvanced();
  
  private VSFont font=new VSFont(new Font("Dialog",1,15));
  private VSColor fontColor = new VSColor(Color.WHITE);
  private VSFont overfont=new VSFont(new Font("Dialog",1,18));
  private VSColor overfontColor = new VSColor(new Color(255,255,0));
  private VSColorAdvanced buttonLigthColor = new VSColorAdvanced();
  private VSColorAdvanced buttonDarkColor = new VSColorAdvanced();
  private VSColorAdvanced buttonDarkerColor = new VSColorAdvanced();
  private VSColor edgeColor = new VSColor(Color.BLACK);
  private VSColorAdvanced focusColor = new VSColorAdvanced();
    

  
  
 
  

  public void onDispose()
  {
    JPanel panel=element.getFrontPanel();
    panel.removeAll();
  }

   public void paint(java.awt.Graphics g)
   {
      if (element!=null)
      {
         Graphics2D g2=(Graphics2D)g;
         Rectangle r=element.jGetBounds();
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
         stroke = new BasicStroke(strokeValue.getValue());
         
         int X0=0;
         int Y0=0;
         int tWidth=0;
         int tHeight=0;
         
         //----------------------------------------------------------------------------DRAW BUTTON BASE
         if(baseVisible.getValue()){
         tWidth =  (int) ((r.width*0.95)-strokeValue.getValue());
         tHeight = (int) ((r.height*0.95)-strokeValue.getValue());
         X0=(int) ((r.width * 0.05)+(strokeValue.getValue()/2));
         Y0=(int) ((r.height * 0.05)+ (strokeValue.getValue()/2));
         
         g2.setStroke(strokeLine);
         baseColor.setFillColor(g2);
         g2.fillOval(X0, Y0, tWidth, tHeight);
         
         strokeBaseColor.setFillColor(g2);
         g2.setStroke(stroke);
         g2.drawOval(X0, Y0, tWidth, tHeight);
         }
               
         //----------------------------------------------------------------------------DRAW BUTTON BASE SHADOW
         if(down.getValue()){
         //tWidth =  (int) ((r.width*0.85));
         //tHeight = (int) ((r.height*0.85));
         //X0=(int) ((r.width * 0.1));
         //Y0=(int) ((r.height * 0.1));
         shadowLigthColor.setFillColor(g2);
         
         }else{
         shadowDarkColor.setFillColor(g2);
         }
         
         tWidth =  (int) ((r.width*0.8));
         tHeight = (int) ((r.height*0.8));
         X0=(int) ((r.width * 0.1));
         Y0=(int) ((r.height * 0.1)); 
         //shadowDarkColor.setFillColor(g2);
         //}
         
         g2.setStroke(strokeLine);
         
         g2.fillOval(X0, Y0, tWidth, tHeight);
         
         g2.setColor(edgeColor.getValue());
         //g2.setStroke(strokeLine);
         //g2.drawOval(X0, Y0, tWidth, tHeight);
         
         //----------------------------------------------------------------------------DRAW BUTTON SHADOW
         
         tWidth =  (int) ((r.width*0.8));
         tHeight = (int) ((r.height*0.8));
         X0=(int) ((r.width * 0.05));
         Y0=(int) ((r.height * 0.05));
         
         g2.setStroke(strokeLine);
         buttonDarkerColor.setFillColor(g2);
         g2.fillOval(X0, Y0, tWidth, tHeight);
         
         g2.setColor(edgeColor.getValue());
         g2.setStroke(strokeLine);
         g2.drawOval(X0, Y0, tWidth, tHeight);
         
         
         //----------------------------------------------------------------------------DRAW BUTTON FRONT
         tWidth =  (int) ((r.width*0.8)-2-(strokeValue.getValue()));
         tHeight = (int) ((r.height*0.8)-2-(strokeValue.getValue()));
         //if(down.getValue()){
         //buttonDarkColor.setFillColor(g2);    
         //X0=(int) (1+(r.width * 0.125)+(strokeValue.getValue()/2));
         //Y0=(int) (1+(r.height * 0.125)+(strokeValue.getValue()/2));    
         //}else{
         X0=1+(strokeValue.getValue()/2);
         Y0=1+(strokeValue.getValue()/2); 
         buttonDarkerColor.setFillColor(g2);
         //}
         g2.setStroke(strokeLine);
         g2.fillOval(X0, Y0, tWidth, tHeight);
         
         
         int TempStroke = (int) ((element.jGetWidth()*0.04));
         g2.setStroke(new BasicStroke(TempStroke));
         buttonLigthColor.setFillColor(g2);
         g2.drawOval(X0+(TempStroke/2), Y0+(TempStroke/2), tWidth-TempStroke, tHeight-TempStroke);
         
         g2.setStroke(strokeLine);
         if(mouseOver){
             g2.setStroke(stroke);
             focusColor.setFillColor(g2);
         }else{
             g2.setColor(edgeColor.getValue());
         }
         g2.drawOval(X0, Y0, tWidth, tHeight);
         
         
         //----------------------------------------------------------------------------DRAW RECTANGLES FRONT
         
         int tWidthShadow =  (int) ((r.width*0.05));
         int tHeigthShadow =  (int) ((r.height*0.05));
         //
         if(down.getValue() == false){
            tHeight =  (int) ((r.height*0.2));
            
            tWidth = (int) ((r.width*0.91));   
            Y0=(int) ((r.height * 0.3));
            X0=(int) ((r.height * 0.05));
            g2.setStroke(strokeLine);
            shadowDarkColor.setFillColor(g2); 
            g2.fillRect(X0, Y0, tWidth+6, tHeight);
            buttonDarkColor.setFillColor(g2);
            g2.fillRect(X0, Y0, tWidth, tHeight);
            
            g2.setColor(Color.WHITE);
            //g2.fillRect(X0+(3*tWidth/4), (Y0+tHeight/2)-(tHeigthShadow/2), tWidth/4, tHeigthShadow);
            g2.fillRect(X0, (Y0+tHeight/2)-(tHeigthShadow/2), tWidth/4, tHeigthShadow);
         }else{
            tWidth =  (int) ((r.width*0.2));
            
            tHeight = (int) ((r.height*0.91));    
            X0=(int) (1+(r.width * 0.3));
            Y0=(int) ((r.height * 0.05));  
            g2.setStroke(strokeLine);
            buttonDarkColor.setFillColor(g2);
            g2.fillRect(X0, Y0, tWidth, tHeight);
            shadowDarkColor.setFillColor(g2); 
            g2.fillRect(X0+tWidth, Y0, tWidthShadow, tHeight);
            g2.setColor(Color.WHITE);
            g2.fillRect((X0+(tWidth/2))-(tWidthShadow/2), Y0 , tWidthShadow, tHeight/4);
         }
         
         
         if(mouseOver){
             g2.setStroke(stroke);
             focusColor.setFillColor(g2);
         }else{
             g2.setColor(edgeColor.getValue());
         }
         
         g2.drawRect(X0, Y0, tWidth, tHeight);
         
         
         
         //-----------------------------------------------------------------------------DRAW BOOLEN TEXT
         if(textVisible.getValue()){
            
            if(mouseOver) g2.setColor(overfontColor.getValue()); else g2.setColor(fontColor.getValue());
            if(mouseOver) g2.setFont(overfont.getValue()); else g2.setFont(font.getValue());
            FontMetrics fm = g2.getFontMetrics();

            String txtTemp = "";
            if(down.getValue()){
                txtTemp=captionON.getValue();
            }else{
                txtTemp=captionOFF.getValue();  
            }


            Rectangle2D rFont = fm.getStringBounds(txtTemp,g2);
            if(down.getValue()){
            X0=(int) ((r.width * 0.4) - (rFont.getWidth())/2);
            Y0=(int) ((r.height * 0.4)+ (rFont.getHeight())/4);
            }else{
            X0=(int) ((r.width * 0.4) - (rFont.getWidth())/2);
            Y0=(int) ((r.height * 0.4)+ (rFont.getHeight())/4);    
            }

            g2.drawString(txtTemp, X0, Y0);
         }
         
      }
   }
   
   private void drawButtonBase(java.awt.Graphics2D g2){
       
   }

  public void init()
  {
    initPins(0,0,0,0);
    setSize(sizeW,sizeH);
    initPinVisibility(false,false,false,false);

    element.jSetResizable(true);
    element.jSetResizeSynchron(true);
    element.jSetInnerBorderVisibility(false);
    setName("Button_6_JV");
    asSwitch.setValue(true);
    
    
   
    baseColor.color1=new Color(255,204,0);
    strokeBaseColor.color1=new Color(102,102,102);
    shadowLigthColor.color1=new Color(153,153,153);
    shadowLigthColor.color1Transparency=128;
    shadowDarkColor.color1=new Color(90,90,90);
    shadowDarkColor.color1Transparency=128;
    
    buttonLigthColor.color1 =new Color(102,102,102);
    buttonLigthColor.color2 = Color.WHITE;
    buttonLigthColor.p1= new Point(40,15);    
    buttonLigthColor.p2= new Point(40,65);    
    buttonLigthColor.modus=1;
    buttonDarkColor.color1 =new Color(51,51,51);
    buttonDarkerColor.color1 =new Color(0,0,0);
    
    focusColor.color1 = new Color(255,243,181);
   
   
    mouseOver=false;
    
    MouseInputAdapter mouseHandler = new MouseInputAdapter() {

          @Override
          public void mouseEntered(final MouseEvent e) {
            if(running){
            mouseOver=true;  
            //edgeColor.setValue(Color.YELLOW);
            element.jRepaint();
            }
          }

          @Override
          public void mouseExited(final MouseEvent e) {
          if(running){
          mouseOver=false;
          //edgeColor.setValue(Color.black);
          element.jRepaint();
          }
          }
      };
      JPanel panel = element.getFrontPanel();
      panel.addMouseListener(mouseHandler);
      
     }

  public void initInputPins()
  {
  }

  public void initOutputPins()
  {
  }
  
  
  public void start()
  { 
    mouseOver=false;
    running=true;
    down.setValue(initValue.getValue());
    element.jRepaint();
    
    circuitElement=element.getCircuitElement();
    circuitElement.Change(0,down);
  }
  
  public void stop(){
      super.stop();
      running=false;
      
  }




  public void setPropertyEditor()
  {
    element.jAddPEItem("Anfangs-Wert",initValue, 0,0);
    element.jAddPEItem("Schalter",asSwitch, 0,0);
    element.jAddPEItem("Beschriftung ON",captionON, 0,0);
    element.jAddPEItem("Beschriftung OFF",captionOFF, 0,0);
    element.jAddPEItem("Base Visible",baseVisible, 0,0);
    element.jAddPEItem("Base Farbe",baseColor, 0,0);
    element.jAddPEItem("Base Border Farbe",strokeBaseColor, 0,0);
    element.jAddPEItem("Shadow Light Farbe",shadowLigthColor, 0,0);
    element.jAddPEItem("Shadow Dark Farbe",shadowDarkColor, 0,0);
    element.jAddPEItem("Text Visible",textVisible, 0,0);
    element.jAddPEItem("Schriftart ON-OFF",font, 0,0);
    element.jAddPEItem("Schriftart ON-OFF Color",fontColor, 0,0);
    element.jAddPEItem("Schriftart Focus",overfont, 0,0);
    element.jAddPEItem("Schriftart Focus Farbe",overfontColor, 0,0);
    element.jAddPEItem("Button Ligth Farbe",buttonLigthColor, 0,0);
    element.jAddPEItem("Button Dark Farbe",buttonDarkColor, 0,0);
    element.jAddPEItem("Button Darker Farbe",buttonDarkerColor, 0,0);
    element.jAddPEItem("Button Edge Farbe",edgeColor, 0,0);
    element.jAddPEItem("Button Focus Farbe",focusColor, 0,0);
    

    localize();
  }


  private void localize()
  {
    int d=6;
    int i=0;
    String language;

    language="en_US";
    
    element.jSetPEItemLocale(d+ i++,language,"Init State");
    element.jSetPEItemLocale(d+ i++,language,"Switch");
    element.jSetPEItemLocale(d+ i++,language,"ON Caption");
    element.jSetPEItemLocale(d+ i++,language,"OFF Caption");
    element.jSetPEItemLocale(d+ i++,language,"Base Visible");
    element.jSetPEItemLocale(d+ i++,language,"Base Color");
    element.jSetPEItemLocale(d+ i++,language,"Base Stroke Color");
    element.jSetPEItemLocale(d+ i++,language,"Shadow Ligth Color");
    element.jSetPEItemLocale(d+ i++,language,"Shadow Dark Color");
    element.jSetPEItemLocale(d+ i++,language,"Text Visible");
    element.jSetPEItemLocale(d+ i++,language,"ON-OFF Caption Font");
    element.jSetPEItemLocale(d+ i++,language,"ON-OFF Font Color");
    element.jSetPEItemLocale(d+ i++,language,"Mouse Over Font");
    element.jSetPEItemLocale(d+ i++,language,"Mouse Over Font Color");
    element.jSetPEItemLocale(d+ i++,language,"Button Ligth Color");
    element.jSetPEItemLocale(d+ i++,language,"Button Dark Color");
    element.jSetPEItemLocale(d+ i++,language,"Button Darker Color");
    element.jSetPEItemLocale(d+ i++,language,"Button Edge Color");
    element.jSetPEItemLocale(d+ i++,language,"Button Focus Color");
    

    language="es_ES";
    i=0;

    element.jSetPEItemLocale(d+ i++,language,"Estado Inicial");
    element.jSetPEItemLocale(d+ i++,language,"Interruptor");
    element.jSetPEItemLocale(d+ i++,language,"Texto Activado");
    element.jSetPEItemLocale(d+ i++,language,"Texto Desactivado");
    element.jSetPEItemLocale(d+ i++,language,"Base Visible");
    element.jSetPEItemLocale(d+ i++,language,"Color de Base");
    element.jSetPEItemLocale(d+ i++,language,"Color Borde Base");
    element.jSetPEItemLocale(d+ i++,language,"Color Sombra Desactivado");
    element.jSetPEItemLocale(d+ i++,language,"Color Sombra Activado");
    element.jSetPEItemLocale(d+ i++,language,"Texto Visible");
    element.jSetPEItemLocale(d+ i++,language,"Fuente Texto ON-OFF");
    element.jSetPEItemLocale(d+ i++,language,"Color Fuente ON-OFF");
    element.jSetPEItemLocale(d+ i++,language,"Fuente Aumentada");
    element.jSetPEItemLocale(d+ i++,language,"Color Fuente Aumentada");
    element.jSetPEItemLocale(d+ i++,language,"Color Claro del Boton");
    element.jSetPEItemLocale(d+ i++,language,"Color Obscuro del Boton");
    element.jSetPEItemLocale(d+ i++,language,"Color Mas Obscuro del Boton");
    element.jSetPEItemLocale(d+ i++,language,"Color Bordes");
    element.jSetPEItemLocale(d+ i++,language,"Color Resaltado del Boton");
  }

  public void propertyChanged(Object o)
  {
    down.setValue(initValue.getValue());
    element.jRepaint();
  }


  public void mouseReleased(MouseEvent e)
  {

    if (asSwitch.getValue())
    {
      if (down.getValue()) down.setValue(false); else down.setValue(true);
      circuitElement.Change(0,down);
    } else
    {
      down.setValue(false);
      circuitElement.Change(0,down);
    }

    element.jRepaint();
  }




  public void mousePressed(MouseEvent e)
  {
    if (asSwitch.getValue())
    {
    } else
    {
      down.setValue(true);
      circuitElement.Change(0,down);
      element.jRepaint();
    }
  }
  public void mouseMoved(MouseEvent e){
     
      if(e!=null){
      super.mouseMoved(e); 
      
      if(e.getPoint().x+10<(element.jGetBounds().x+element.jGetBounds().width-10) && e.getPoint().y+10<element.jGetBounds().y+element.jGetBounds().height-10){
      mouseOver=true;
      }
      
      element.jRepaint();

      }
      
      
      
      
      
  }


  public void loadFromStream(java.io.FileInputStream fis)
  {
      
    initValue.loadFromStream(fis);
    asSwitch.loadFromStream(fis);
    captionON.loadFromStream(fis);
    captionOFF.loadFromStream(fis);
    baseVisible.loadFromStream(fis);
    baseColor.loadFromStream(fis);
    strokeBaseColor.loadFromStream(fis);
    shadowLigthColor.loadFromStream(fis);
    shadowDarkColor.loadFromStream(fis);
    font.loadFromStream(fis);
    fontColor.loadFromStream(fis);
    overfont.loadFromStream(fis);
    overfontColor.loadFromStream(fis);
    buttonLigthColor.loadFromStream(fis);
    buttonDarkColor.loadFromStream(fis);
    buttonDarkerColor.loadFromStream(fis);
    edgeColor.loadFromStream(fis);
    focusColor.loadFromStream(fis);
    textVisible.loadFromStream(fis);
      
      
      down.setValue(initValue.getValue());
      element.jRepaint();

  }

  public void saveToStream(java.io.FileOutputStream fos)
  {
      
    initValue.saveToStream(fos);
    asSwitch.saveToStream(fos);
    captionON.saveToStream(fos);
    captionOFF.saveToStream(fos);
    baseVisible.saveToStream(fos);
    baseColor.saveToStream(fos);
    strokeBaseColor.saveToStream(fos);
    shadowLigthColor.saveToStream(fos);
    shadowDarkColor.saveToStream(fos);
    font.saveToStream(fos);
    fontColor.saveToStream(fos);
    overfont.saveToStream(fos);
    overfontColor.saveToStream(fos);
    buttonLigthColor.saveToStream(fos);
    buttonDarkColor.saveToStream(fos);
    buttonDarkerColor.saveToStream(fos);
    edgeColor.saveToStream(fos);
    focusColor.saveToStream(fos);
    textVisible.saveToStream(fos);
      
      
  }
}

