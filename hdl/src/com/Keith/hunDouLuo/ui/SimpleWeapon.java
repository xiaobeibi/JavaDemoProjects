 package com.Keith.hunDouLuo.ui;
 
 import java.util.ArrayList;
 import java.util.List;
 
 public class SimpleWeapon extends Weapon
 {
   private int type;
 
   public SimpleWeapon(int type)
   {
     super(type);
     this.type = type;
   }
 
   public List<Bullet> shot(FloatPoint position, int direction, int num) {
     List list = new ArrayList(1);
     switch (direction) {
     case 0:
       list.add(new SimpleBullet(new FloatPoint(position.x, position.y - 16.666666F), direction, this.type, 0.0F, -2.0F));
       break;
     case 1:
       list.add(new SimpleBullet(new FloatPoint(position.x + 10.0F, position.y - 30.0F), direction, this.type, 1.413333F, -1.413333F));
       break;
     case 7:
       list.add(new SimpleBullet(new FloatPoint(position.x - 10.0F, position.y - 30.0F), direction, this.type, -1.413333F, -1.413333F));
       break;
     case 2:
       list.add(new SimpleBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, 2.0F, 0.0F));
       break;
     case 3:
       list.add(new SimpleBullet(new FloatPoint(position.x + 11.333333F, position.y - 12.0F), direction, this.type, 1.413333F, 1.413333F));
       break;
     case 5:
       list.add(new SimpleBullet(new FloatPoint(position.x - 11.333333F, position.y - 12.0F), direction, this.type, -1.413333F, 1.413333F));
       break;
     case 6:
       list.add(new SimpleBullet(new FloatPoint(position.x - 11.333333F, position.y - 19.666666F), direction, this.type, -2.0F, 0.0F));
       break;
     case 4:
       list.add(new SimpleBullet(new FloatPoint(position.x, position.y), direction, this.type, 0.0F, 2.0F));
     }
 
     return list;
   }
 
   public List<Bullet> shot(FloatPoint position, FloatPoint target, int direction, int num) {
     List list = new ArrayList(1);
     if ((target.x > position.x) && (target.y < position.y)) {
       float speedX = (float)((target.x - position.x) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
       float speedY = (float)((target.y - position.y) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
       if (direction == 1) {
         list.add(new SimpleBullet(new FloatPoint(position.x + 10.0F, position.y - 30.0F), direction, this.type, speedX, speedY));
       }
       else if (direction == 2) {
         list.add(new SimpleBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, speedX, speedY));
       }
     }
     else if ((target.x > position.x) && (target.y > position.y)) {
       float speedX = (float)((target.x - position.x) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
       float speedY = (float)((target.y - position.y) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
       if (direction == 3) {
         list.add(new SimpleBullet(new FloatPoint(position.x + 11.333333F, position.y - 12.0F), direction, this.type, speedX, speedY));
       }
       else if (direction == 2) {
         list.add(new SimpleBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, speedX, speedY));
       }
     }
     else if ((target.x < position.x) && (target.y < position.y)) {
       float speedX = (float)((target.x - position.x) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
       float speedY = (float)((target.y - position.y) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
       if (direction == 6) {
         list.add(new SimpleBullet(new FloatPoint(position.x - 4.666667F, position.y - 19.666666F), direction, this.type, speedX, speedY));
       }
       else if (direction == 7) {
         list.add(new SimpleBullet(new FloatPoint(position.x - 10.0F, position.y - 30.0F), direction, this.type, speedX, speedY));
       }
     }
     else if ((target.x < position.x) && (target.y > position.y)) {
       float speedX = (float)((target.x - position.x) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
       float speedY = (float)((target.y - position.y) * 2.0F / Math.sqrt((target.x - position.x) * (target.x - position.x) + (target.y - position.y) * (target.y - position.y)));
       if (direction == 6) {
         list.add(new SimpleBullet(new FloatPoint(position.x - 4.666667F, position.y - 19.666666F), direction, this.type, speedX, speedY));
       }
       else if (direction == 5) {
         list.add(new SimpleBullet(new FloatPoint(position.x - 11.333333F, position.y - 12.0F), direction, this.type, speedX, speedY));
       }
     }
     return list;
   }
 }

