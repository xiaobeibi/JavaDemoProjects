 package com.Keith.hunDouLuo.ui;
 
 import java.util.ArrayList;
 import java.util.List;
 
 public class NunLinerWeapon extends Weapon
 {
   private int type;
 
   public NunLinerWeapon(int type)
   {
     super(type);
     this.type = type;
   }
 
   public List<Bullet> shot(FloatPoint position, int direction, int num) {
     List list = new ArrayList(1);
     switch (direction) {
     case 0:
       list.add(new NunLinerBullet(new FloatPoint(position.x, position.y - 16.666666F), direction, this.type, 0.0F, -3.0F));
       break;
     case 1:
       list.add(new NunLinerBullet(new FloatPoint(position.x + 10.0F, position.y - 30.0F), direction, this.type, 2.12F, -2.12F));
       break;
     case 7:
       list.add(new NunLinerBullet(new FloatPoint(position.x - 10.0F, position.y - 30.0F), direction, this.type, -2.12F, -2.12F));
       break;
     case 2:
       list.add(new NunLinerBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, 3.0F, 0.0F));
       break;
     case 3:
       list.add(new NunLinerBullet(new FloatPoint(position.x + 11.333333F, position.y - 12.0F), direction, this.type, 2.12F, 2.12F));
       break;
     case 5:
       list.add(new NunLinerBullet(new FloatPoint(position.x - 11.333333F, position.y - 12.0F), direction, this.type, -2.12F, 2.12F));
       break;
     case 6:
       list.add(new NunLinerBullet(new FloatPoint(position.x - 11.333333F, position.y - 19.666666F), direction, this.type, -3.0F, 0.0F));
       break;
     case 4:
       list.add(new NunLinerBullet(new FloatPoint(position.x, position.y), direction, this.type, 0.0F, 3.0F));
     }
 
     SoundUtils.playSound("hdl/audios/f_gun.wav");
     return list;
   }
 
   public List<Bullet> shot(FloatPoint position, FloatPoint target, int direction, int num)
   {
     return null;
   }
 }

