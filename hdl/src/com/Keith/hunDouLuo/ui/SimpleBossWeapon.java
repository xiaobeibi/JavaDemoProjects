 package com.Keith.hunDouLuo.ui;
 
 import java.util.ArrayList;
 import java.util.List;
 
 public class SimpleBossWeapon extends Weapon
 {
   private int type;
 
   public SimpleBossWeapon(int type)
   {
     super(type);
     this.type = type;
   }
 
   public List<Bullet> shot(FloatPoint position, FloatPoint target, int direction, int num) {
     List list = new ArrayList(1);
     float speedX = (float)((target.x - position.x) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
     float speedY = (float)((target.y - position.y) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
     list.add(new SimpleBullet(new FloatPoint(position.x, position.y), direction, this.type, speedX, speedY));
     return list;
   }
 
   public List<Bullet> shot(FloatPoint position, int direction, int num)
   {
     return null;
   }
 }
