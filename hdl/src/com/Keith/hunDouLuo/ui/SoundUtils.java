 package com.Keith.hunDouLuo.ui;
 
 import sun.audio.AudioPlayer;
 import sun.audio.AudioStream;
 
 public class SoundUtils
 {
   public static void playSound(String str)
   {
     try
     {
       AudioStream as = Audios.getAudio(str);
       AudioPlayer.player.start(as);
     } catch (Exception e1) {
       e1.printStackTrace();
     }
   }
 }
