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
public class Caja {
    private static final int DIAMETER = 140;

    private int x = 0;
    private int y = 0;
    
    private final int t=2;
    
    FondoPanel fp;
    
    public Caja(FondoPanel fp){
        this.fp=fp;
        x=fp.getWidth()-160;
        y=fp.getHeight()-190;
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
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/com/monkey/img/cardboard-box-296818_960_720.png"));
        g.drawImage(imagenFondo.getImage(), getX(), getY(),DIAMETER,DIAMETER,null);
    }
    private boolean collision() {
		return fp.m.getBounds().intersects(getBounds());
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
