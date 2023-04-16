/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monkey.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author MS 02
 */
public class Vara {
    private static final int DIAMETER = 100;

    private int x = 0;
    private int y = 0;
    
    private int t=2;
    
    FondoPanel fp;
    
    public Vara(FondoPanel fp){
        this.fp=fp;
        y = fp.getHeight() - 150;
        x = 150;
    }
    
    public void move(int x,int y){
           this.setX(x);
           this.setY(y);
    }
    public void retroceder(int x){
        this.setX(x);
    }

    public int retardo (){ //retardo de la bola 
          return t; 
    } 
    public void paint(Graphics g) {
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/com/monkey/img/Palo_de_Madera_(Arma).png"));
        g.drawImage(imagenFondo.getImage(), getX(), getY(),DIAMETER,DIAMETER,null);
    }
    public boolean collPared(){
        boolean pared=false;
        if(getX()>(fp.getWidth() - DIAMETER)){
            pared=true;
        }
        return pared;
    }
    public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), DIAMETER, DIAMETER);
    }
    
     /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
