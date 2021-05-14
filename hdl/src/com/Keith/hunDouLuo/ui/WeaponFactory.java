 package com.Keith.hunDouLuo.ui;
 
 public class WeaponFactory
 {
   static Weapon weapon;
 
   public static Weapon getWeapon(int type)
   {
     switch (type) {
     case 1:
       weapon = new SimpleWeapon(1);
       break;
     case 2:
       weapon = new StrongWeapon(1);
       break;
     case 3:
       weapon = new ShotWeapon(1);
       break;
     case 4:
       weapon = new NunLinerWeapon(1);
       break;
     default:
       weapon = new SimpleWeapon(1);
     }
 
     return weapon;
   }
 }
