package entity;

import main.GamePanel;
import object.OBJ;
import object.OBJ_SpeedPotion;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity {
	public int worldX;
	public int worldY;
	public int speed;
	public int maxlife;
	public int attack;
	public boolean attacking;
	public int life;
	public int maxMana;
	public int mana;
	public int defend;

	public String direction;
	public ArrayList<OBJ> item;
	public Rectangle solidArea;
}