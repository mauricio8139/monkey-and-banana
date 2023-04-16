/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monkey.main;

/**
 *
 * @author MS 02
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FondoPanel extends JPanel implements Runnable {
    Mono m;
    Caja c;
    Bananas b;
    Vara v;
    int[] movim = new int[5];
    Thread an;
    public FondoPanel(){
        setSize(800,522);
        m = new Mono(this);
        c = new Caja(this);
        b = new Bananas(this);
        v = new Vara(this);
        movim[0]=200;
        movim[1]=this.getWidth();
        movim[2]=200;
        movim[3]=125;
        an=new Thread(this);
        an.start();
    }
    
    @Override
    public void run() {
        try{
           int cont=0;
           boolean seq=false;
           int tmpM1=0;
           int tmpM2=0;
           int tmpM3=0;
           int tmpM4=0;
           while(!seq){
               Random r = new Random();
               int valorDado = r.nextInt(4);
               switch(valorDado){
                   case 1:
                      if(tmpM1==0 && tmpM2==0 && tmpM3 == 0 && tmpM4 == 0){
                        for(int mov = 0 ; mov < movim[0] ; mov++){
                            an.sleep(50);
                            m.move(mov, m.getY());
                            repaint();
                            if(m.collision()){
                                break;
                            }
                        }
                        cont++;
                      }else{
                          seq=true;
                      }
                        tmpM1=valorDado;
                   break;
                   case 2:
                       if(tmpM1==1 && tmpM2==0 && tmpM3 == 0 && tmpM4 == 0){
                           for(int mov = 0 ; mov < movim[1] ; mov++){
                                int tmp=v.getX();
                                if(!v.collPared()){
                                    tmp+=mov;
                                    v.move(tmp,v.getY());
                                    an.sleep(100);
                                    repaint();
                                }
                                tmp=m.getX();
                                tmp+=mov;
                                m.move(tmp, m.getY());
                                an.sleep(100);
                                repaint();
                                if(v.collPared()){
                                    break;
                                }
                            }
                           cont++;
                       }else{
                         seq=true;
                       }
                       tmpM2=valorDado;
                   break;
                   case 3:
                       if(tmpM1==1 && tmpM2==2 && tmpM3 == 0 && tmpM4 == 0){
                           int tm=0;
                            while(tm!=movim[2]){
                                tm=m.getX();
                                tm=tm-1;
                                m.retroceder(tm);
                                an.sleep(10);
                                repaint();
                                c.retroceder(tm);
                                an.sleep(10);
                                repaint();
                                int tm2=v.getX();
                                tm2-=1;
                                v.retroceder(tm2);
                                an.sleep(10);
                                repaint();
                            }
                            cont++;
                       }else{
                           seq=true;
                       }
                       tmpM2=valorDado;
                   break;
                   case 4:
                       if(tmpM1==1 && tmpM2==2 && tmpM3 == 3 && tmpM4 == 0){
                         m.brincar(m.getY()-movim[3]);
                         v.setY(v.getY()-movim[3]);
                         repaint();
                         cont++;
                       }else{
                           seq=true;
                       }
                       tmpM2=valorDado;
                   break;
                   
               }
           }
           if(tmpM1==1 && tmpM2==2 && tmpM3 == 3 && tmpM4 == 4){
               if(b.collision()){
                JOptionPane.showMessageDialog(null, "*****Ganaste*****");
               }
           }else{
               JOptionPane.showMessageDialog(null, "*****Mono no tiene la banana*****\n sus movimientos fueron "+cont,"Se realizaron los 5 movimientos",JOptionPane.INFORMATION_MESSAGE);
               
           }
            
            
            
            
        }catch(InterruptedException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/com/monkey/img/elCuartoWeb_800.jpg"));
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
        setOpaque(false);
        m.paint(g);
        c.paint(g);
        b.paint(g);
        v.paint(g);
    }
}