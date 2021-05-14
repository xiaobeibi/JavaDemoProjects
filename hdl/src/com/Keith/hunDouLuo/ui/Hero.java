 package com.Keith.hunDouLuo.ui;
 
 import java.awt.Graphics2D;
 import java.util.List;
 
 public class Hero extends Player
 {
   public FloatPoint position;
   public int direction;
   private static int ANIMATION_TEMP = 0;
   private static float JUMP_HEIGHT = 0.0F;
   public boolean jumping = false;
   public boolean jumpFinished = true;
   public boolean canShot = true;
   public boolean canDrop = true;
   public boolean towardsLeft = false;
   public boolean towardsRight = true;
   public boolean visible = false;
   public int state = 0;
   public Weapon weapon;
   public int deathEventType;
   public int width;
   public int height;
   int visibleTemp = 0;
 
   int temp = 0;
 
   public Hero()
   {
     this.direction = 2;
     this.position = new FloatPoint(0.0F, 0.0F);
     this.weapon = new SimpleWeapon(1);
   }
 
   public Hero(FloatPoint position) {
     this.direction = 2;
     this.position = position;
     this.weapon = new SimpleWeapon(1);
   }
 
   public Hero(FloatPoint position, int direction) {
     this.state = 0;
     this.position = position;
     this.direction = direction;
     this.weapon = new SimpleWeapon(1);
   }
 
   public void drawPlayer(Graphics2D g, float mapPosition)
   {
     if (this.visibleTemp++ > 180)
       this.visible = true;
     if (this.state == 0) {
       this.width = 50;
       this.height = 90;
       standAnimation(g, mapPosition);
     }
     else if (this.state == 1) {
       this.width = 60;
       this.height = 90;
       walkAnimation(g, mapPosition);
     }
     else if (this.state == 2) {
       this.width = 66;
       this.height = 66;
       jumpAnimation(g, mapPosition);
     }
     else if (this.state == 3) {
       this.width = 100;
       this.height = 30;
       crawlAnimation(g, mapPosition);
     }
     else if (this.state == 4) {
       dieingAnimation(g, mapPosition);
     } else if (this.state == 6) {
       this.width = 60;
       this.height = 90;
       droppingAnimation(g, mapPosition);
     }
   }
 
   private void droppingAnimation(Graphics2D g, float mapPosition)
   {
     if ((this.direction == 0) && (this.towardsRight)) {
       g.drawImage(Imgs.STAND02, (int)((this.position.x - mapPosition) * 3.0F) - 27, (int)(this.position.y * 3.0F) - 126, null);
     }
     else if ((this.direction == 0) && (this.towardsLeft)) {
       g.drawImage(Imgs.STAND06, (int)((this.position.x - mapPosition) * 3.0F) - 27, (int)(this.position.y * 3.0F) - 126, null);
     }
     else if (this.direction == 1) {
       g.drawImage(Imgs.WALKANDSHOT1, (int)((this.position.x - mapPosition) * 3.0F) - 45, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 45, (int)(this.position.y * 3.0F), 90, 0, 180, 100, null);
     }
     else if (this.direction == 2) {
       g.drawImage(Imgs.STAND2, (int)((this.position.x - mapPosition) * 3.0F) - 20, (int)(this.position.y * 3.0F) - 90, null);
     }
     else if (this.direction == 3) {
       g.drawImage(Imgs.WALKANDSHOT3, (int)((this.position.x - mapPosition) * 3.0F) - 40, (int)(this.position.y * 3.0F) - 90, (int)((this.position.x - mapPosition) * 3.0F) + 40, (int)(this.position.y * 3.0F), 80, 0, 160, 90, null);
     }
     else if (this.direction == 5) {
       g.drawImage(Imgs.WALKANDSHOT5, (int)((this.position.x - mapPosition) * 3.0F) - 40, (int)(this.position.y * 3.0F) - 90, (int)((this.position.x - mapPosition) * 3.0F) + 40, (int)(this.position.y * 3.0F), 80, 0, 160, 90, null);
     }
     else if (this.direction == 6) {
       g.drawImage(Imgs.STAND6, (int)((this.position.x - mapPosition) * 3.0F) - 40, (int)(this.position.y * 3.0F) - 90, null);
     }
     else if (this.direction == 7)
       g.drawImage(Imgs.WALKANDSHOT7, (int)((this.position.x - mapPosition) * 3.0F) - 45, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 45, (int)(this.position.y * 3.0F), 90, 0, 180, 100, null);
   }
 
   private void dieingAnimation(Graphics2D g, float mapPosition)
   {
     this.jumpFinished = false;
     if ((this.direction == 0) || (this.direction == 1) || (this.direction == 2) || (this.direction == 3)) {
       this.towardsRight = true;
       this.towardsLeft = false;
     }
     else if ((this.direction == 4) || (this.direction == 5) || (this.direction == 6) || (this.direction == 7)) {
       this.towardsRight = false;
       this.towardsLeft = true;
     }
     if (this.temp++ < 16) {
       if (this.towardsRight) {
         this.position.x -= 1.666667F;
         this.position.y -= 1.666667F;
         g.drawImage(Imgs.HERODIEING, (int)(this.position.x - mapPosition) * 3 - 58, (int)(this.position.y * 3.0F) - 45, (int)(this.position.x - mapPosition) * 3 + 58, (int)(this.position.y * 3.0F), 0, 0, 90, 35, null);
       }
       else if (this.towardsLeft) {
         this.position.x += 1.666667F;
         this.position.y -= 1.666667F;
         g.drawImage(Imgs.HERODIEING, (int)(this.position.x - mapPosition) * 3 - 58, (int)(this.position.y * 3.0F) - 45, (int)(this.position.x - mapPosition) * 3 + 58, (int)(this.position.y * 3.0F), 0, 0, 90, 35, null);
       }
     }
     else if (this.temp++ < 32) {
       if (this.towardsRight) {
         this.position.x -= 1.666667F;
         this.position.y += 1.666667F;
         g.drawImage(Imgs.HERODIEING, (int)(this.position.x - mapPosition) * 3 - 58, (int)(this.position.y * 3.0F) - 45, (int)(this.position.x - mapPosition) * 3 + 58, (int)(this.position.y * 3.0F), 0, 0, 90, 35, null);
       }
       else if (this.towardsLeft) {
         this.position.x += 1.666667F;
         this.position.y += 1.666667F;
         g.drawImage(Imgs.SIMPLEENEMYDIEING6, (int)(this.position.x - mapPosition) * 3 - 58, (int)(this.position.y * 3.0F) - 45, (int)(this.position.x - mapPosition) * 3 + 58, (int)(this.position.y * 3.0F), 0, 0, 90, 35, null);
       }
     }
     else if (this.temp < 70) {
       g.drawImage(Imgs.HERODIEING, (int)(this.position.x - mapPosition) * 3 - 58, (int)(this.position.y * 3.0F), (int)(this.position.x - mapPosition) * 3 + 58, (int)(this.position.y * 3.0F) + 40, 90, 0, 180, 35, null);
     }
     else
       this.state = 5;
   }
 
   public void standAnimation(Graphics2D g, float mapPosition)
   {
     ANIMATION_TEMP = 0;
     this.jumping = false;
     this.jumpFinished = true;
     if (this.direction == 2) {
       g.drawImage(Imgs.STAND2, (int)((this.position.x - mapPosition) * 3.0F) - 20, (int)(this.position.y * 3.0F) - 90, null);
     }
     else if (this.direction == 6) {
       g.drawImage(Imgs.STAND6, (int)((this.position.x - mapPosition) * 3.0F) - 40, (int)(this.position.y * 3.0F) - 90, null);
     }
     else if ((this.direction == 0) && (this.towardsRight)) {
       g.drawImage(Imgs.STAND02, (int)((this.position.x - mapPosition) * 3.0F) - 27, (int)(this.position.y * 3.0F) - 126, null);
     }
     else if ((this.direction == 0) && (this.towardsLeft))
       g.drawImage(Imgs.STAND06, (int)((this.position.x - mapPosition) * 3.0F) - 27, (int)(this.position.y * 3.0F) - 126, null);
   }
 
   public void walkAnimation(Graphics2D g, float mapPosition)
   {
     this.jumping = false;
     this.jumpFinished = true;
     int temp = ANIMATION_TEMP / 10;
     if (this.direction == 2) {
       g.drawImage(Imgs.WALKANDSHOT2, (int)((this.position.x - mapPosition) * 3.0F) - 45, (int)(this.position.y * 3.0F) - 90, (int)((this.position.x - mapPosition) * 3.0F) + 45, (int)(this.position.y * 3.0F), temp * 90, 0, temp * 90 + 90, 90, null);
     }
     else if (this.direction == 6) {
       g.drawImage(Imgs.WALKANDSHOT6, (int)((this.position.x - mapPosition) * 3.0F) - 45, (int)(this.position.y * 3.0F) - 90, (int)((this.position.x - mapPosition) * 3.0F) + 45, (int)(this.position.y * 3.0F), (3 - temp) * 90, 0, (3 - temp) * 90 + 90, 90, null);
     }
     else if (this.direction == 3) {
       g.drawImage(Imgs.WALKANDSHOT3, (int)((this.position.x - mapPosition) * 3.0F) - 40, (int)(this.position.y * 3.0F) - 90, (int)((this.position.x - mapPosition) * 3.0F) + 40, (int)(this.position.y * 3.0F), temp * 80, 0, temp * 80 + 80, 90, null);
     }
     else if (this.direction == 5) {
       g.drawImage(Imgs.WALKANDSHOT5, (int)((this.position.x - mapPosition) * 3.0F) - 40, (int)(this.position.y * 3.0F) - 90, (int)((this.position.x - mapPosition) * 3.0F) + 40, (int)(this.position.y * 3.0F), (3 - temp) * 80, 0, (3 - temp) * 80 + 80, 90, null);
     }
     else if (this.direction == 1) {
       g.drawImage(Imgs.WALKANDSHOT1, (int)((this.position.x - mapPosition) * 3.0F) - 45, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 45, (int)(this.position.y * 3.0F), temp * 90, 0, temp * 90 + 90, 100, null);
     }
     else if (this.direction == 7) {
       g.drawImage(Imgs.WALKANDSHOT7, (int)((this.position.x - mapPosition) * 3.0F) - 45, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 45, (int)(this.position.y * 3.0F), (3 - temp) * 90, 0, (3 - temp) * 90 + 90, 100, null);
     }
     if (++ANIMATION_TEMP > 30)
       ANIMATION_TEMP = 0;
   }
 
   public void jumpAnimation(Graphics2D g, float mapPosition)
   {
     int temp = ANIMATION_TEMP / 3;
     if ((this.direction == 0) || (this.direction == 1) || (this.direction == 2) || (this.direction == 3)) {
       g.drawImage(Imgs.JUMP2, (int)((this.position.x - mapPosition) * 3.0F) - 33, (int)(this.position.y * 3.0F) - 66, (int)((this.position.x - mapPosition) * 3.0F) + 33, (int)(this.position.y * 3.0F), temp * 66, 0, temp * 66 + 66, 66, null);
     }
     else if ((this.direction == 4) || (this.direction == 5) || (this.direction == 6) || (this.direction == 7)) {
       g.drawImage(Imgs.JUMP6, (int)((this.position.x - mapPosition) * 3.0F) - 33, (int)(this.position.y * 3.0F) - 66, (int)((this.position.x - mapPosition) * 3.0F) + 33, (int)(this.position.y * 3.0F), (7 - temp) * 66, 0, (7 - temp) * 66 + 66, 66, null);
     }
     if (++ANIMATION_TEMP > 21) {
       ANIMATION_TEMP = 0;
     }
     if ((JUMP_HEIGHT < 30.0F) && (!this.jumpFinished)) {
       JUMP_HEIGHT += 1.0F;
       this.position.y -= 2.0F;
     }
     else {
       this.jumpFinished = true;
       JUMP_HEIGHT = 0.0F;
       this.position.y += 2.0F;
     }
   }
 
   private void crawlAnimation(Graphics2D g, float mapPosition) {
     ANIMATION_TEMP = 0;
     this.jumping = false;
     this.jumpFinished = false;
     if (this.direction == 6) {
       g.drawImage(Imgs.CRAWL6, (int)((this.position.x - mapPosition) * 3.0F) - 55, (int)(this.position.y * 3.0F) - 42, null);
     }
     else if (this.direction == 2)
       g.drawImage(Imgs.CRAWL2, (int)((this.position.x - mapPosition) * 3.0F) - 55, (int)(this.position.y * 3.0F) - 42, null);
   }
 
   public List<Bullet> shot(int num)
   {
     if (this.canShot) {
       if (this.state == 3) {
         if (this.towardsRight) {
           return this.weapon.shot(new FloatPoint(this.position.x + 3.333333F, this.position.y + 12.333333F), this.direction, num);
         }
 
         return this.weapon.shot(new FloatPoint(this.position.x - 3.333333F, this.position.y + 12.333333F), this.direction, num);
       }
 
       if (this.state == 0) {
         if (this.direction == 0) {
           if (this.towardsRight) {
             return this.weapon.shot(new FloatPoint(this.position.x + 4.333334F, this.position.y - 22.333334F), this.direction, num);
           }
 
           return this.weapon.shot(new FloatPoint(this.position.x - 4.333334F, this.position.y - 22.333334F), this.direction, num);
         }
 
         if (this.towardsRight) {
           return this.weapon.shot(new FloatPoint(this.position.x + 5.0F, this.position.y), this.direction, num);
         }
 
         return this.weapon.shot(new FloatPoint(this.position.x - 5.0F, this.position.y), this.direction, num);
       }
 
       if (this.state == 2) {
         return this.weapon.shot(new FloatPoint(this.position.x, this.position.y - 10.0F), this.direction, num);
       }
 
       return this.weapon.shot(new FloatPoint(this.position.x, this.position.y), this.direction, num);
     }
 
     return null;
   }
 }
