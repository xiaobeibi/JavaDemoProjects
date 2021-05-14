 package com.Keith.hunDouLuo.ui;
 
 import java.awt.Graphics2D;
 
 abstract class Bullet
 {
   public FloatPoint position;
   public boolean isAlive = true;
   public float size;
   public int energy;
 
   public Bullet(FloatPoint position, boolean isAlive, int energy)
   {
     this.position = position;
     this.isAlive = isAlive;
     this.energy = energy;
   }
 
   public abstract void drawBubblet(Graphics2D paramGraphics2D, float paramFloat);
 }

