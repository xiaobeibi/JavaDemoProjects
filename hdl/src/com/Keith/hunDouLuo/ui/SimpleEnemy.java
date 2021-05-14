 package com.Keith.hunDouLuo.ui;
 
 import java.awt.Graphics2D;
 import java.util.ArrayList;
 import java.util.List;
 
 public class SimpleEnemy extends Player
 {
   public FloatPoint position;
   public int direction;
   private int life = 50;
   private static int JUMP_HEIGHT = 0;
   public boolean jumping = false;
   public boolean jumpFinished = false;
   public boolean canShot = true;
   public boolean canDrop = true;
   public boolean towardsLeft = false;
   public boolean towardsRight = true;
   public boolean visible = false;
   public int state = 0;
   public Weapon weapon;
   public int type = 0;
 
   int temp = 0;
 
   private static int ANIMATION_TEMP = 0;
 
   int shotTemp = 0;
 
   public SimpleEnemy()
   {
     this.type = 0;
     this.state = 1;
     this.direction = 6;
     this.position = new FloatPoint(0.0F, 0.0F);
     this.weapon = new SimpleWeapon(1);
   }
 
   public SimpleEnemy(FloatPoint position) {
     this.type = 0;
     this.state = 1;
     this.direction = 6;
     this.position = position;
     this.weapon = new SimpleWeapon(1);
   }
 
   public SimpleEnemy(FloatPoint position, int direction, int type) {
     this.state = 1;
     this.position = position;
     if (type == 0) {
       this.state = 1;
     }
     else if (type == 1) {
       this.state = 1;
     }
     else if (type == 2) {
       this.state = 1;
     }
     else if (type == 3) {
       this.state = 1;
     }
     else if (type == 4) {
       this.state = 0;
       this.direction = 6;
     }
     this.type = type;
     this.weapon = new SimpleWeapon(1);
     this.direction = direction;
   }
 
   public void drawPlayer(Graphics2D g, float mapPosition)
   {
     if (this.visible)
       if (this.state == 0) {
         standAnimation(g, mapPosition);
       }
       else if (this.state == 1) {
         walkAnimation(g, mapPosition);
       }
       else if (this.state == 2) {
         jumppingAnimation(g, mapPosition);
       }
       else if (this.state == 4)
         drawDieingAnimation(g, mapPosition);
   }
 
   private void jumppingAnimation(Graphics2D g, float mapPosition) {
     this.jumping = true;
     if (this.direction == 2) {
       g.drawImage(Imgs.ENEMYJUMP2, (int)((this.position.x - mapPosition) * 3.0F) - 33, (int)(this.position.y * 3.0F) - 81, null);
     }
     else if (this.direction == 6) {
       g.drawImage(Imgs.ENEMYJUMP6, (int)((this.position.x - mapPosition) * 3.0F) - 33, (int)(this.position.y * 3.0F) - 81, null);
     }
     if ((JUMP_HEIGHT < 20) && (!this.jumpFinished)) {
       JUMP_HEIGHT += 1;
       this.position.y -= 2.0F;
     }
     else {
       this.jumpFinished = true;
       JUMP_HEIGHT = 0;
       this.position.y += 2.0F;
     }
   }
 
   private void standAnimation(Graphics2D g, float mapPosition) {
     this.jumpFinished = false;
     if (this.direction == 1) {
       g.drawImage(Imgs.ENEMYSHOT1, (int)((this.position.x - mapPosition) * 3.0F) - 43, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 43, (int)(this.position.y * 3.0F), 172, 0, 258, 100, null);
     }
     else if (this.direction == 2) {
       g.drawImage(Imgs.ENEMYSHOT1, (int)((this.position.x - mapPosition) * 3.0F) - 43, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 43, (int)(this.position.y * 3.0F), 86, 0, 172, 100, null);
     }
     else if (this.direction == 3) {
       g.drawImage(Imgs.ENEMYSHOT1, (int)((this.position.x - mapPosition) * 3.0F) - 43, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 43, (int)(this.position.y * 3.0F), 0, 0, 86, 100, null);
     }
     else if (this.direction == 5) {
       g.drawImage(Imgs.ENEMYSHOT3, (int)((this.position.x - mapPosition) * 3.0F) - 43, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 43, (int)(this.position.y * 3.0F), 172, 0, 258, 100, null);
     }
     else if (this.direction == 6) {
       g.drawImage(Imgs.ENEMYSHOT3, (int)((this.position.x - mapPosition) * 3.0F) - 43, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 43, (int)(this.position.y * 3.0F), 86, 0, 172, 100, null);
     }
     else if (this.direction == 7)
       g.drawImage(Imgs.ENEMYSHOT3, (int)((this.position.x - mapPosition) * 3.0F) - 43, (int)(this.position.y * 3.0F) - 100, (int)((this.position.x - mapPosition) * 3.0F) + 43, (int)(this.position.y * 3.0F), 0, 0, 86, 100, null);
   }
 
   private void drawDieingAnimation(Graphics2D g, float mapPosition)
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
         this.position.x -= 0.3333333F;
         this.position.y -= 1.666667F;
         g.drawImage(Imgs.SIMPLEENEMYDIEING2, (int)(this.position.x - mapPosition) * 3 - 33, (int)(this.position.y * 3.0F) - 90, null);
       }
       else if (this.towardsLeft) {
         this.position.x += 0.3333333F;
         this.position.y -= 1.666667F;
         g.drawImage(Imgs.SIMPLEENEMYDIEING6, (int)(this.position.x - mapPosition) * 3 - 33, (int)(this.position.y * 3.0F) - 90, null);
       }
     }
     else if (this.temp < 24) {
       g.drawImage(Imgs.ENEMYBOMBING, (int)(this.position.x - mapPosition) * 3 - 45, (int)(this.position.y * 3.0F) - 90, (int)(this.position.x - mapPosition) * 3 + 45, (int)(this.position.y * 3.0F), 0, 0, 90, 90, null);
     }
     else if (this.temp < 28) {
       g.drawImage(Imgs.ENEMYBOMBING, (int)(this.position.x - mapPosition) * 3 - 45, (int)(this.position.y * 3.0F) - 90, (int)(this.position.x - mapPosition) * 3 + 45, (int)(this.position.y * 3.0F), 90, 0, 180, 90, null);
     }
     else if (this.temp < 36) {
       g.drawImage(Imgs.ENEMYBOMBING, (int)(this.position.x - mapPosition) * 3 - 45, (int)(this.position.y * 3.0F) - 90, (int)(this.position.x - mapPosition) * 3 + 45, (int)(this.position.y * 3.0F), 180, 0, 270, 90, null);
     }
     else
       this.state = 5;
   }
 
   private void walkAnimation(Graphics2D g, float mapPosition)
   {
     this.jumpFinished = false;
     int temp = ANIMATION_TEMP / 10;
     if (this.direction == 2) {
       g.drawImage(Imgs.ENEMYWALK2, (int)(this.position.x - mapPosition) * 3 - 31, (int)(this.position.y * 3.0F) - 90, (int)(this.position.x - mapPosition) * 3 + 32, (int)(this.position.y * 3.0F), temp * 63, 0, temp * 63 + 63, 90, null);
     }
     else if (this.direction == 6) {
       g.drawImage(Imgs.ENEMYWALK6, (int)(this.position.x - mapPosition) * 3 - 31, (int)(this.position.y * 3.0F) - 90, (int)(this.position.x - mapPosition) * 3 + 32, (int)(this.position.y * 3.0F), temp * 63, 0, temp * 63 + 63, 90, null);
     }
     if (++ANIMATION_TEMP > 40)
       ANIMATION_TEMP = 0;
   }
 
   public void beShotted(int damage)
   {
     this.life -= damage;
     if (this.life <= 0)
       this.state = 4;
   }
 
   public boolean touchHeroBulletCheck(Bullet b)
   {
     if ((this.visible) && 
       (b.position.x > this.position.x - 10.333333F - b.size / 3.0F) && (b.position.x < this.position.x + 10.666667F + b.size / 3.0F) && 
       (b.position.y > this.position.y - 30.0F - b.size / 3.0F) && (b.position.y < this.position.y + b.size / 3.0F)) {
       return true;
     }
     return false;
   }
 
   public List<Bullet> shot(FloatPoint target, int num)
   {
     if ((this.canShot) && (this.shotTemp++ % 120 == 0)) {
       return this.weapon.shot(new FloatPoint(this.position.x, this.position.y), new FloatPoint(target.x, target.y), 
         this.direction, num);
     }
     return new ArrayList();
   }
 }
