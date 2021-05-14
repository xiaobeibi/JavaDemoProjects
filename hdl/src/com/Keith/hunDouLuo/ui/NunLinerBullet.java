 package com.Keith.hunDouLuo.ui;
 
 import java.awt.Graphics2D;
 
 public class NunLinerBullet extends Bullet
 {
   public FloatPoint position;
   public FloatPoint absolutePosition;
   public static boolean isAlive = true;
   private int direction = 2;
   public int type;
   public float size = 10.0F;
   private float speedX = 6.0F;
   private float speedY = 6.0F;
   public static int energy = 80;
 
   int temp = 0;
   int theta = 0;
   int R = 13;
 
   public NunLinerBullet(FloatPoint position, int direction, int type, float speedX, float speedY)
   {
     super(position, isAlive, energy);
     this.speedX = speedX;
     this.speedY = speedY;
     this.type = type;
     this.position = position;
     this.absolutePosition = new FloatPoint(position.x, position.y);
     this.direction = direction;
   }
 
   public void drawBubblet(Graphics2D g, float mapPosition)
   {
     if (isAlive) {
       if (this.temp++ % 2 == 0) {
         this.absolutePosition.x += this.speedX;
         this.absolutePosition.y += this.speedY;
         this.position.x = (float)(this.absolutePosition.x + this.R * Math.cos(this.theta));
         this.position.y = (float)(this.absolutePosition.y + this.R * Math.sin(this.theta));
         this.theta += 1;
       }
       g.drawImage(Imgs.NUNLINERBULLET, (int)(this.position.x - mapPosition) * 3 - (int)this.size, (int)this.position.y * 3 - (int)this.size, (int)this.size * 2, (int)this.size * 2, null);
     }
   }
 }
