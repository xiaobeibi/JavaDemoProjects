 package com.Keith.hunDouLuo.ui;
 
 import java.io.FileInputStream;
 import sun.audio.AudioStream;
 
 public class Audios
 {
   public static AudioStream getAudio(String str)
     throws Exception
   {
     AudioStream as = new AudioStream(new FileInputStream(str));
     return as;
   }
 }
