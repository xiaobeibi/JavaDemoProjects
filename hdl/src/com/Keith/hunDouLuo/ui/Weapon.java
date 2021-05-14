 package com.Keith.hunDouLuo.ui;
 
 import java.util.List;
 
 abstract class Weapon
 {
   public int type;
 
   public Weapon(int type)
   {
     this.type = type;
   }
 
   public abstract List<Bullet> shot(FloatPoint paramFloatPoint, int paramInt1, int paramInt2);
 
   public abstract List<Bullet> shot(FloatPoint paramFloatPoint1, FloatPoint paramFloatPoint2, int paramInt1, int paramInt2);
 }
