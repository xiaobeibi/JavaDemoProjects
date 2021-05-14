 package com.Keith.hunDouLuo.ui;
 
 import java.awt.Graphics2D;
 
 public class GrassLand
 {
   public FloatPoint position;
   private FloatPoint absolutePosition;
   public int length;
   public int movingDirection = 0;
 
   public boolean beTouched = false;
 
   public GrassLand(FloatPoint position, int length)
   {
     this.position = position;
     this.length = length;
     this.absolutePosition = new FloatPoint(this.position.x, this.position.y);
   }
 
   public void drawMovingGrassLand(Hero player, float left, float right, float mapPosition, int backgroundSizeOfWidth, MainFrame frame, Graphics2D g)
   {
     if ((mapPosition > this.absolutePosition.x * 32.0F - backgroundSizeOfWidth / 3) && (mapPosition < (this.absolutePosition.x + 4.0F) * 32.0F + backgroundSizeOfWidth / 3))
     {
       if (onTheGrassLand(player, player.position.x, player.position.y + 1.0F, this)) {
         this.beTouched = true;
       }
       if (!this.beTouched) {
         if ((this.movingDirection == 3) && 
           (this.position.x > left))
         {
           FloatPoint tmp108_105 = this.position; tmp108_105.x = (float)(tmp108_105.x - 0.02D);
         }
         else if (this.position.x <= left) {
           this.movingDirection = 1;
           FloatPoint tmp145_142 = this.position; tmp145_142.x = (float)(tmp145_142.x + 0.02D);
         }
         if ((this.movingDirection == 1) && 
           (this.position.x < right))
         {
           FloatPoint tmp182_179 = this.position; tmp182_179.x = (float)(tmp182_179.x + 0.02D);
         }
         else if (this.position.x >= right) {
           this.movingDirection = 3;
           FloatPoint tmp219_216 = this.position; tmp219_216.x = (float)(tmp219_216.x - 0.02D);
         }
       }
       else {
         this.position.y += 0.2F;
         if (onTheGrassLand(player, player.position.x, player.position.y + 1.0F, this)) {
           player.position.y += 0.2F;
         }
 
       }
 
       if (this.position.y > 180.0F) {
         this.position.y = 110.0F;
         this.beTouched = false;
       }
       g.drawImage(Imgs.GRASS, (int)(this.position.x * 32.0F - mapPosition) * 3 - 6, 
         (int)(this.position.y * 3.0F) - 18, 108, 60, null);
     }
   }
 
   private boolean onTheGrassLand(Hero hero, float x, float y, GrassLand gl)
   {
     if (hero.towardsRight) {
       if ((x > gl.position.x * 32.0F - 7.0F) && (x < (gl.position.x + gl.length) * 32.0F) && 
         (y > gl.position.y) && (y < gl.position.y + 3.0F)) {
         return true;
       }
     }
     else if (hero.towardsLeft) {
       if ((x > gl.position.x * 32.0F - 7.0F) && (x < (gl.position.x + gl.length) * 32.0F) && 
         (y > gl.position.y) && (y < gl.position.y + 3.0F))
         return true;
     }
     else if ((!hero.towardsLeft) && (!hero.towardsRight) && 
       (x > gl.position.x * 32.0F) && (x < (gl.position.x + gl.length) * 32.0F) && 
       (y > gl.position.y) && (y < gl.position.y + 3.0F)) {
       return true;
     }
     return false;
   }
 
   private float getPositionOnGrassLand(float x) {
     return x - this.position.x * 32.0F;
   }
 }

