package controller;

import entity.Monster;
import entity.Player;
import main.CollisionChecker;
import main.GamePanel;
import object.OBJ_SpeedPotion;

import java.awt.*;

public class PlayerController extends EntityController{
    GamePanel gp;
    Player player;
    Monster monster;

    public static boolean hasKey = false;
    public int heroCounter;
    private int timeLife = 30;
    private int timeMana = 0;
    public static boolean checkUp;
    public static boolean checkDown;
    public static boolean checkLeft;
    public static boolean checkRight;
    public PlayerController(GamePanel gp, Player player, Monster monster){
        this.gp = gp;
        this.player = player;
        this.monster = monster;
        setDefaultValue();
    }
    private void setDefaultValue(){
        hasKey = false;
        screenX = gp.screenWidth/2-gp.tileSize/2;
        screenY = gp.screenHeight/2-gp.tileSize/2;
        player.worldX = gp.tileSize * 5;
        player.worldY = gp.tileSize * 5;
        heroCounter = 0;
        heroNum = 0;
        player.solidArea = new Rectangle();
        player.solidArea.x = 8;
        player.solidArea.y = 16;
        player.solidArea.width = 32;
        player.solidArea.height = 32;
        dyingCounter =0;
    }

    @Override
    public void update() {
        timeMana += 1;
        if(timeMana >=2000){
            player.mana -= 1;
            timeMana = 0;
        }
        if(Math.abs(player.worldX - monster.worldX) <= gp.tileSize/2 && Math.abs(player.worldY - monster.worldY) <= gp.tileSize/2){
            timeLife += 1;

            if(timeLife >=50 && player.life >=0){
                player.life -=1;
                timeLife = 0;
            }

        }
        else{
            timeLife = 30;
        }

        if(player.attacking){
            attacking();
        }
        else if (gp.keyH.upPressed || gp.keyH.downPressed || gp.keyH.rightPressed || gp.keyH.leftPressed || gp.keyH.spacePressed){
            player.attacking = gp.keyH.spacePressed;
            if (gp.keyH.upPressed) {
                player.direction = "up";
                checkUp=true;
            }
            else checkUp = false;
            if (gp.keyH.downPressed) {
                player.direction = "down";
                checkDown=true;
            }
            else checkDown=false;
            if (gp.keyH.rightPressed) {
                player.direction = "right";
                checkRight=true;
            }
            else checkRight = false;
            if (gp.keyH.leftPressed) {
                player.direction = "left";
                checkLeft=true;
            }
            else checkLeft=false;
            heroCounter += 1;
            if (heroCounter > 10) {
                heroNum+=1;
                heroNum = heroNum%4;
//			System.out.println(heroNum);
                heroCounter = 0;
            }
        }
        colissionOnRoW = false;
        colissionOnCol = false;
        gp.cChecker.checkTile(player, this);
        int objIndex = gp.cChecker.checkObject(player, true, this);
        CollisionChecker.interactor.ObjInteraction(gp,objIndex);
        if (!colissionOnCol||!colissionOnRoW){
            if (gp.keyH.upPressed || gp.keyH.downPressed || gp.keyH.rightPressed || gp.keyH.leftPressed){
                if (gp.keyH.upPressed) {
                    player.worldY -= player.speed+ OBJ_SpeedPotion.speedBonus;
                }
                if (gp.keyH.downPressed) {
                    player.worldY += player.speed+OBJ_SpeedPotion.speedBonus;
                }
                if (gp.keyH.rightPressed) {
                    player.worldX += player.speed+OBJ_SpeedPotion.speedBonus;
                }
                if (gp.keyH.leftPressed) {
                    player.worldX -= player.speed+OBJ_SpeedPotion.speedBonus;
                }
                gp.cChecker.checkTile(player, this);
                heroCounter += 1;
                if (heroCounter > 10) {
                    if (heroNum == 1) {
                        heroNum = 2;
                    } else if (heroNum == 2) {
                        heroNum = 1;
                    }
                    heroCounter = 0;
                }
            }
        }
    }

    @Override
    public void attacking() {
        heroCounter++;
        if(heroCounter <= 5){
            heroNum = 1;
        }
        if(heroCounter > 5 && heroCounter < 10){
            heroNum = 2;
            //luu worldX,Y, solidArea
            int currentWorldX = player.worldX;
            int currentWorldY = player.worldY;
            int solidAreaWidth = player.solidArea.width;
            int solidAreaHeight = player.solidArea.height;

            switch (player.direction){
                case "up": player.worldY -= player.attackArea.height;
                case "down": player.worldY += player.attackArea.height;
                case "left": player.worldX -= player.attackArea.width;
                case "right": player.worldX += player.attackArea.width;
            }

            player.solidArea.width = player.attackArea.width;
            player.solidArea.height = player.attackArea.height;

//			int monIndex = gp.cChecker.checkEntity(this, gp.monster);
//			damageMonster(monIndex, atk);
            player.worldX = currentWorldX;
            player.worldY = currentWorldY;
            player.solidArea.width = solidAreaWidth;
            player.solidArea.height = solidAreaHeight;
        }
        if(heroCounter >= 10){
            heroNum = 1;
            heroCounter = 0;
            player.attacking = false;
        }
    }
}
