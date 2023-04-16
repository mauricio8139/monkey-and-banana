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
public class Mono {

   
    private static final int DIAMETER = 130;

    private int x = 20;
    private int y = 0;
    private boolean rot=false;
    
    private int t=2;
    
    FondoPanel fp;
    
    public Mono(FondoPanel fp){
        this.fp=fp;
        y = fp.getHeight()-200;
    }
    
    public void move(int x,int y){
        if(collision()){
            fp.v.setY(fp.getHeight()-250);
        }else{
            this.setX(x);
            this.setY(y);
        }
    }
    public void retroceder(int x){
        this.setX(x);
    }
    public void brincar(int y){
        this.setY(y);
    }
    public int retardo (){ //retardo de la bola 
          return t; 
    } 
    public void paint(Graphics g) {
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/com/monkey/img/mono-md.png"));
        g.drawImage(imagenFondo.getImage(), getX(), getY(),DIAMETER,DIAMETER,null);
    }
    public boolean collision2(){
        return fp.c.getBounds().intersects(getBounds());
    }
    public boolean collision() {
		return fp.v.getBounds().intersects(getBounds());
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
