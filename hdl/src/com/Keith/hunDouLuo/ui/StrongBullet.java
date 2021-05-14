 package com.Keith.hunDouLuo.ui;
 
 import java.awt.Graphics2D;
 
 public class StrongBullet extends Bullet
 {
   public FloatPoint position;
   public static boolean isAlive = true;
   private int direction = 2;
   private int type;
   public float size = 8.0F;
   private float speedX = 6.0F;
   private float speedY = 6.0F;
   public static int energy = 80;
 
   public StrongBullet(FloatPoint position, int direction, int type, float speedX, float speedY) { super(position, isAlive, energy);
     this.speedX = speedX;
     this.speedY = speedY;
     this.type = type;
     this.position = position;
     this.direction = direction; }
 
   public void drawBubblet(Graphics2D g, float mapPosition)
   {
     if (isAlive) {
       this.position.x += this.speedX;
       this.position.y += this.speedY;
       g.drawImage(Imgs.STRONGBULLET, (int)(this.position.x - mapPosition) * 3 - (int)this.size, (int)this.position.y * 3 - (int)this.size, (int)this.size * 2, (int)this.size * 2, null);
     }
   }
 }

