 package com.Keith.hunDouLuo.ui;
 
 import java.io.FileInputStream;
 import sun.audio.AudioPlayer;
 import sun.audio.AudioStream;
 
 public class PreBossBackgroundSoundThread
   implements Runnable
 {
   public AudioStream as;
   public boolean playSound = true;
 
   public void run() {
     playBackgroundSound();
   }
 
   private void playBackgroundSound() {
     while (this.playSound)
       try {
         this.as = new AudioStream(new FileInputStream("hdl/audios/stone_landing.wav"));
         AudioPlayer.player.start(this.as);
         Thread.sleep(200L);
       } catch (Exception e) {
         e.printStackTrace();
       }
   }
 }

