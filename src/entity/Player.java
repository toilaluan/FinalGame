package entity;

import java.awt.*;

public class Player extends Entity {
	public Rectangle attackArea = new Rectangle(0,0,0,0);
	public Player(int attack,
				  int defense,
				  int speed,
				  int maxLife,
				  int maxMana,
				  String direction) {
		this.attack = attack;
		this.defend = defense;
		this.speed = speed;
		this.maxlife = maxLife;
		this.maxMana = maxMana;
		this.direction = direction;
		this.life = maxLife;
		this.mana = maxMana;
	}
}