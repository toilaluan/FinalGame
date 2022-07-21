package entity;

import main.GamePanel;

import java.awt.*;

public class Monster extends Entity{
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public int defaultWorldX, defaultWorldY;
    public Monster(int attack,
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
    }

}
