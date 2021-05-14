 package com.Keith.hunDouLuo.ui;
 
 import java.io.FileInputStream;
 import sun.audio.AudioPlayer;
 import sun.audio.AudioStream;
 
 public class BossBackgroundSoundThread
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
         this.as = new AudioStream(new FileInputStream("hdl/audios/Bossbg.mid"));
         AudioPlayer.player.start(this.as);
         Thread.sleep(152000L);
       } catch (Exception e) {
         e.printStackTrace();
       }
   }
 }
