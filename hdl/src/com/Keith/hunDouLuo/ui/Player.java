package com.Keith.hunDouLuo.ui;

import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Player
{
  public Point position;
  public int direction;
  public int state;
  public Weapon weapon;

  public abstract void drawPlayer(Graphics2D paramGraphics2D, float paramFloat);
}
