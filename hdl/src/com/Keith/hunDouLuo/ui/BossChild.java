 package com.Keith.hunDouLuo.ui;
 
 import java.awt.Graphics2D;
 import java.util.ArrayList;
 import java.util.List;
 
 public class BossChild
 {
   public FloatPoint position;
   public int direction;
   public int life = 300;
   public boolean isAlive = true;
   public int state = 0;
   public Weapon[] weapons = new Weapon[4];
 
   int temp = 0;
   FloatPoint diePosition;
   int bombTemp = 0;
   float flyingTemp = 0.0F;
 
   int shotFPSTemp = 0;
 
   public BossChild(FloatPoint position)
   {
     this.state = 0;
     this.direction = 6;
     this.position = position;
     this.weapons[0] = new SimpleBossWeapon(0);
     this.weapons[1] = new SimpleBossWeapon(0);
     this.weapons[2] = new SimpleBossWeapon(0);
     this.weapons[3] = new SimpleBossWeapon(0);
   }
 
   public void drawBossChild(Graphics2D g, float mapPosition) {
     if (this.state == 0) {
       flyingAnimation(g, mapPosition);
     }
     else if (this.state == 4)
       dieingAnimation(g, mapPosition);
   }
 
   private void flyingAnimation(Graphics2D g, float mapPosition)
   {
     g.drawImage(Imgs.BOSSCHILD, (int)(this.position.x - mapPosition) * 3 - 45, (int)this.position.y * 3 - 51, null);
   }
 
   private void dieingAnimation(Graphics2D g, float mapPosition)
   {
     g.drawImage(Imgs.BOSSCHILD, (int)(this.position.x - mapPosition) * 3 - 45, (int)this.position.y * 3 - 51, null);
     if (this.temp++ < 110) {
       this.bombTemp = (this.temp / 10);
       g.drawImage(Imgs.BOSSBOMBBING, (int)(this.position.x - mapPosition) * 3 - 33, (int)this.position.y * 3 - 55, 
         (int)(this.position.x - mapPosition) * 3 + 33, (int)this.position.y * 3 + 5, 
         (int)(this.bombTemp * 66.637001F), 0, (int)(this.bombTemp + 1 * 66.637D), 60, null);
 
       if (this.temp == 1)
         SoundUtils.playSound("hdl/audios/bossBomb.wav");
     }
     else {
       this.state = 5;
       this.isAlive = false;
     }
   }
 
   public void beShotted(int damage) {
     SoundUtils.playSound("hdl/audios/beshotted.wav");
     this.life -= damage;
     if (this.life <= 0)
       this.state = 4;
   }
 
   public boolean touchHeroBulletCheck(Bullet b)
   {
     if (this.isAlive) {
       if ((b.position.x > this.position.x - 15.0F - b.size / 3.0F) && (b.position.x < this.position.x + 15.0F + b.size / 3.0F) && 
         (b.position.y > this.position.y - 6.666667F - b.size / 3.0F) && (b.position.y < this.position.y + b.size / 3.0F)) {
         return true;
       }
       if ((b.position.x > this.position.x - 3.333333F - b.size / 3.0F) && (b.position.x < this.position.x + 3.333333F + b.size / 3.0F) && 
         (b.position.y > this.position.y - 16.666666F - b.size / 3.0F) && (b.position.y < this.position.y - 6.666667F + b.size / 3.0F))
         return true;
     }
     return false;
   }
 
   public List<Bullet> simpleShot(FloatPoint target, int num)
   {
     List list = new ArrayList();
     if ((this.life > 0) && 
       (this.shotFPSTemp++ % 60 == 0)) {
       list.addAll(this.weapons[0].shot(new FloatPoint(this.position.x - 7.0F, this.position.y), new FloatPoint(this.position.x - 7.0F, 224.0F), 
         this.direction, num));
       list.addAll(this.weapons[1].shot(new FloatPoint(this.position.x - 2.0F, this.position.y), new FloatPoint(this.position.x - 2.0F, 224.0F), 
         this.direction, num));
       list.addAll(this.weapons[2].shot(new FloatPoint(this.position.x + 2.0F, this.position.y), new FloatPoint(this.position.x + 2.0F, 224.0F), 
         this.direction, num));
       list.addAll(this.weapons[3].shot(new FloatPoint(this.position.x + 7.0F, this.position.y), new FloatPoint(this.position.x + 7.0F, 224.0F), 
         this.direction, num));
     }
     return list;
   }
 }
