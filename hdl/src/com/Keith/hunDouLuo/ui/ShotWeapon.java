 package com.Keith.hunDouLuo.ui;
 
 import java.util.ArrayList;
 import java.util.List;
 
 public class ShotWeapon extends Weapon
 {
   private int type;
 
   public ShotWeapon(int type)
   {
     super(type);
     this.type = type;
   }
 
   public List<Bullet> shot(FloatPoint position, int direction, int num) {
     List list = new ArrayList(1);
     switch (direction) {
     case 0:
       if (num < 2) {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F), direction, this.type, 0.0F, -2.366667F));
       }
       else if (num < 3) {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 2.666667F), direction, this.type, -0.3333333F, -2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F), direction, this.type, 0.0F, -2.366667F));
       }
       else if (num < 4) {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 2.666667F), direction, this.type, -0.3333333F, -2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F), direction, this.type, 0.0F, -2.366667F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 2.666667F), direction, this.type, 0.3333333F, -2.333333F));
       }
       else if (num < 5) {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 5.333334F), direction, this.type, -0.6666667F, -2.2F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 2.666667F), direction, this.type, -0.3333333F, -2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F), direction, this.type, 0.0F, -2.366667F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 2.666667F), direction, this.type, 0.3333333F, -2.333333F));
       }
       else {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 5.333334F), direction, this.type, -0.6666667F, -2.2F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 2.666667F), direction, this.type, -0.3333333F, -2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F), direction, this.type, 0.0F, -2.366667F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 2.666667F), direction, this.type, 0.3333333F, -2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 16.666666F + 5.333334F), direction, this.type, 0.6666667F, -2.2F));
       }
       break;
     case 1:
       if (num < 2) {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 30.0F), direction, this.type, 1.7F, -1.7F));
       }
       else if (num < 3) {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 1.885333F, position.y - 30.0F - 1.885333F), direction, this.type, 1.453333F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 30.0F), direction, this.type, 1.7F, -1.7F));
       }
       else if (num < 4) {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 1.885333F, position.y - 30.0F - 1.885333F), direction, this.type, 1.453333F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 30.0F), direction, this.type, 1.7F, -1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F + 2.552F, position.y - 30.0F + 2.666667F), direction, this.type, 1.75F, -1.5F));
       }
       else if (num < 5) {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 3.770667F, position.y - 30.0F - 3.770667F), direction, this.type, 1.166667F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 1.885333F, position.y - 30.0F - 1.885333F), direction, this.type, 1.453333F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 30.0F), direction, this.type, 1.7F, -1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F + 2.552F, position.y - 30.0F + 2.666667F), direction, this.type, 1.75F, -1.5F));
       }
       else {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 3.770667F, position.y - 30.0F - 3.770667F), direction, this.type, 1.166667F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 1.885333F, position.y - 30.0F - 1.885333F), direction, this.type, 1.453333F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 30.0F), direction, this.type, 1.7F, -1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F + 2.552F, position.y - 30.0F + 2.666667F), direction, this.type, 1.75F, -1.5F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F + 5.104F, position.y - 30.0F + 5.333334F), direction, this.type, 1.766667F, -1.266667F));
       }
       break;
     case 7:
       if (num < 2) {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 30.0F), direction, this.type, -1.7F, -1.7F));
       }
       else if (num < 3) {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 1.885333F, position.y - 30.0F - 1.885333F), direction, this.type, -1.453333F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 30.0F), direction, this.type, -1.7F, -1.7F));
       }
       else if (num < 4) {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 1.885333F, position.y - 30.0F - 1.885333F), direction, this.type, -1.453333F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 30.0F), direction, this.type, -1.7F, -1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F - 2.552F, position.y - 30.0F + 2.666667F), direction, this.type, -1.75F, -1.5F));
       }
       else if (num < 5) {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 3.770667F, position.y - 30.0F - 3.770667F), direction, this.type, -1.166667F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 1.885333F, position.y - 30.0F - 1.885333F), direction, this.type, -1.453333F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 30.0F), direction, this.type, -1.7F, -1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F - 2.552F, position.y - 30.0F + 2.666667F), direction, this.type, -1.75F, -1.5F));
       }
       else {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 3.770667F, position.y - 30.0F - 3.770667F), direction, this.type, -1.166667F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 1.885333F, position.y - 30.0F - 1.885333F), direction, this.type, -1.453333F, -1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 30.0F), direction, this.type, -1.7F, -1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F - 2.552F, position.y - 30.0F + 2.666667F), direction, this.type, -1.75F, -1.5F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F - 5.104F, position.y - 30.0F + 5.333334F), direction, this.type, -1.766667F, -1.266667F));
       }
       break;
     case 2:
       if (num < 2) {
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, 2.366667F, 0.0F));
       }
       else if (num < 3) {
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 2.666667F, position.y - 19.666666F - 3.333333F), direction, this.type, 2.333333F, -0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, 2.366667F, 0.0F));
       }
       else if (num < 4) {
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 2.666667F, position.y - 19.666666F - 3.333333F), direction, this.type, 2.333333F, -0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, 2.366667F, 0.0F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 2.666667F, position.y - 19.666666F + 3.333333F), direction, this.type, 2.333333F, 0.3333333F));
       }
       else if (num < 5) {
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 5.333334F, position.y - 19.666666F - 6.666667F), direction, this.type, 2.2F, -0.6666667F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 2.666667F, position.y - 19.666666F - 3.333333F), direction, this.type, 2.333333F, -0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, 2.366667F, 0.0F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 2.666667F, position.y - 19.666666F + 3.333333F), direction, this.type, 2.333333F, 0.3333333F));
       }
       else {
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 5.333334F, position.y - 19.666666F - 6.666667F), direction, this.type, 2.2F, -0.6666667F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 2.666667F, position.y - 19.666666F - 3.333333F), direction, this.type, 2.333333F, -0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F, position.y - 19.666666F), direction, this.type, 2.366667F, 0.0F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 2.666667F, position.y - 19.666666F + 3.333333F), direction, this.type, 2.333333F, 0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x + 11.333333F - 5.333334F, position.y - 19.666666F + 6.666667F), direction, this.type, 2.2F, 0.6666667F));
       }
       break;
     case 3:
       if (num < 2) {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 15.0F), direction, this.type, 1.7F, 1.7F));
       }
       else if (num < 3) {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 1.885333F, position.y - 15.0F + 1.885333F), direction, this.type, 1.453333F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 15.0F), direction, this.type, 1.7F, 1.7F));
       }
       else if (num < 4) {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 1.885333F, position.y - 15.0F + 1.885333F), direction, this.type, 1.453333F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 15.0F), direction, this.type, 1.7F, 1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F + 2.552F, position.y - 15.0F - 2.666667F), direction, this.type, 1.75F, 1.5F));
       }
       else if (num < 5) {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 3.770667F, position.y - 15.0F + 3.770667F), direction, this.type, 1.166667F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 1.885333F, position.y - 15.0F + 1.885333F), direction, this.type, 1.453333F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 5.0F), direction, this.type, 1.7F, 1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F + 2.552F, position.y - 15.0F - 2.666667F), direction, this.type, 1.75F, 1.5F));
       }
       else {
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 3.770667F, position.y - 15.0F + 3.770667F), direction, this.type, 1.166667F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F - 1.885333F, position.y - 15.0F + 1.885333F), direction, this.type, 1.453333F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F, position.y - 15.0F), direction, this.type, 1.7F, 1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F + 2.552F, position.y - 15.0F - 2.666667F), direction, this.type, 1.75F, 1.5F));
         list.add(new ShotBullet(new FloatPoint(position.x + 10.0F + 5.104F, position.y - 15.0F - 5.333334F), direction, this.type, 1.766667F, 1.266667F));
       }
       break;
     case 5:
       if (num < 2) {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 15.0F), direction, this.type, -1.7F, 1.7F));
       }
       else if (num < 3) {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 1.885333F, position.y - 15.0F + 1.885333F), direction, this.type, -1.453333F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 15.0F), direction, this.type, -1.7F, 1.7F));
       }
       else if (num < 4) {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 1.885333F, position.y - 15.0F + 1.885333F), direction, this.type, -1.453333F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 15.0F), direction, this.type, -1.7F, 1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F - 2.552F, position.y - 45.0F - 2.666667F), direction, this.type, -1.75F, 1.5F));
       }
       else if (num < 5) {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 3.770667F, position.y - 15.0F + 3.770667F), direction, this.type, -1.166667F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 1.885333F, position.y - 15.0F + 1.885333F), direction, this.type, -1.453333F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 15.0F), direction, this.type, -1.7F, 1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F - 2.552F, position.y - 15.0F - 2.666667F), direction, this.type, -1.75F, 1.5F));
       }
       else {
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 3.770667F, position.y - 15.0F + 3.770667F), direction, this.type, -1.166667F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F + 1.885333F, position.y - 15.0F + 1.885333F), direction, this.type, -1.453333F, 1.8F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F, position.y - 15.0F), direction, this.type, -1.7F, 1.7F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F - 2.552F, position.y - 15.0F - 2.666667F), direction, this.type, -1.75F, 1.5F));
         list.add(new ShotBullet(new FloatPoint(position.x - 10.0F - 5.104F, position.y - 15.0F - 5.333334F), direction, this.type, -1.766667F, 1.266667F));
       }
       break;
     case 6:
       if (num < 2) {
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F, position.y - 19.666666F), direction, this.type, -2.366667F, 0.0F));
       }
       else if (num < 3) {
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 2.666667F, position.y - 19.666666F - 3.333333F), direction, this.type, -2.333333F, -0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F, position.y - 19.666666F), direction, this.type, -2.366667F, 0.0F));
       }
       else if (num < 4) {
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 2.666667F, position.y - 19.666666F - 3.333333F), direction, this.type, -2.333333F, -0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F, position.y - 19.666666F), direction, this.type, -2.366667F, 0.0F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 2.666667F, position.y - 19.666666F + 3.333333F), direction, this.type, -2.333333F, 0.3333333F));
       }
       else if (num < 5) {
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 5.333334F, position.y - 19.666666F - 6.666667F), direction, this.type, -2.2F, -0.6666667F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 2.666667F, position.y - 19.666666F - 3.333333F), direction, this.type, -2.333333F, -0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F, position.y - 19.666666F), direction, this.type, -2.366667F, 0.0F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 2.666667F, position.y - 19.666666F + 3.333333F), direction, this.type, -2.333333F, 0.3333333F));
       }
       else {
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 5.333334F, position.y - 19.666666F - 6.666667F), direction, this.type, -2.2F, -0.6666667F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 2.666667F, position.y - 19.666666F - 3.333333F), direction, this.type, -2.333333F, -0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F, position.y - 19.666666F), direction, this.type, -2.366667F, 0.0F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 2.666667F, position.y - 19.666666F + 3.333333F), direction, this.type, -2.333333F, 0.3333333F));
         list.add(new ShotBullet(new FloatPoint(position.x - 11.333333F + 5.333334F, position.y - 19.666666F + 6.666667F), direction, this.type, -2.2F, 0.6666667F));
       }
       break;
     case 4:
       if (num < 2) {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y), direction, this.type, 0.0F, 2.366667F));
       }
       else if (num < 3) {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 2.666667F), direction, this.type, -0.3333333F, 2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y), direction, this.type, 0.0F, 2.366667F));
       }
       else if (num < 4) {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 2.666667F), direction, this.type, -0.3333333F, 2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y), direction, this.type, 0.0F, 2.366667F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 2.666667F), direction, this.type, 0.3333333F, 2.333333F));
       }
       else if (num < 5) {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 5.333334F), direction, this.type, -0.6666667F, 2.2F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 2.666667F), direction, this.type, -0.3333333F, 2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y), direction, this.type, 0.0F, 2.366667F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 2.666667F), direction, this.type, 0.3333333F, 2.333333F));
       }
       else {
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 5.333334F), direction, this.type, -0.6666667F, 2.2F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 2.666667F), direction, this.type, -0.3333333F, 2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y), direction, this.type, 0.0F, 2.366667F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 2.666667F), direction, this.type, 0.3333333F, 2.333333F));
         list.add(new ShotBullet(new FloatPoint(position.x, position.y - 5.333334F), direction, this.type, 0.6666667F, 2.2F));
       }
       break;
     }
     SoundUtils.playSound("hdl/audios/s_gun.wav");
     return list;
   }
 
   public List<Bullet> shot(FloatPoint position, FloatPoint target, int direction, int num)
   {
     return null;
   }
 }

