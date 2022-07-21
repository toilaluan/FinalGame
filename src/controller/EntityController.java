package controller;

import entity.Player;
import main.CollisionChecker;
import main.GamePanel;

import java.awt.*;

public abstract class EntityController {
    public int heroCounter;

    public int screenX;
    public int screenY;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public static boolean colissionOnCol;
    public static boolean colissionOnRoW;
    public int heroNum;
    public abstract void update();
    public abstract void attacking();

}
