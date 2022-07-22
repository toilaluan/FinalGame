package controller;

import entity.Monster;
import entity.Player;
import main.CollisionChecker;
import main.GamePanel;
import object.OBJ;
import object.OBJ_Bom;
import object.OBJ_SpeedPotion;

import java.awt.*;

public class PlayerController extends EntityController{
    GamePanel gp;
    Player player;
    Monster monster;

    public boolean hasKey = false;
    public int heroCounter;
    private int timeLife = 30;
    private int timeMana = 0;
    public static boolean checkUp;
    public static boolean checkDown;
    public static boolean checkLeft;
    public static boolean checkRight;
    int attackLatency = 0;
    int skillLatency = 0;
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
        player.worldX = gp.tileSize * 8;
        player.worldY = gp.tileSize * 8;
        heroCounter = 0;
        heroNum = 0;
        player.solidArea = new Rectangle();
        player.solidArea.x = 8;
        player.solidArea.y = 16;
        player.solidArea.width = 32;
        player.solidArea.height = 32;
    }
    public void checkCollision(){

        colissionOnRoW = false;
        colissionOnCol = false;
        gp.cChecker.checkTile(player, this);
        int objIndex = gp.cChecker.checkObject(player, true, this);
        CollisionChecker.interactor.ObjInteraction(gp,objIndex);
        if (!colissionOnCol||!colissionOnRoW){
            if (gp.keyH.upPressed || gp.keyH.downPressed || gp.keyH.rightPressed || gp.keyH.leftPressed){
                if (gp.keyH.upPressed) {
                    player.worldY -= player.speed;
                }
                if (gp.keyH.downPressed) {
                    player.worldY += player.speed;
                }
                if (gp.keyH.rightPressed) {
                    player.worldX += player.speed;
                }
                if (gp.keyH.leftPressed) {
                    player.worldX -= player.speed;
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
    public void update() {
        timeMana += 1;
        if(timeMana >=1000 && player.mana < player.maxMana){
            player.mana += 1;
            timeMana = 0;
        }
        if(Math.abs(player.worldX - monster.worldX) <= gp.tileSize/2 && Math.abs(player.worldY - monster.worldY) <= gp.tileSize){
            timeLife += 1;

            if(timeLife >=50 && player.life >=0){
                player.life -= gp.monster1.attack;
                timeLife = 0;
            }
        }
        else{
            timeLife = 30;
        }
        attackLatency += 1;
        if(player.attacking && attackLatency > 10){
            attacking();
            player.attacking = false;
            attackLatency = 0;
        }else if (gp.keyH.upPressed || gp.keyH.downPressed || gp.keyH.rightPressed || gp.keyH.leftPressed || gp.keyH.spacePressed || gp.keyH.rPressed){
            player.attacking = gp.keyH.spacePressed;
            player.skillCasting = gp.keyH.rPressed;
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
        skillLatency += 1;
        if (player.skillCasting && skillLatency > 100 && player.mana >= 1){
            OBJ bom = new OBJ_Bom();
            gp.aSetter.setSingleOBJ(gp.dameOBJ, bom, player.worldX, player.worldY);
            player.mana -= 1;
            System.out.println("addd");
            skillLatency = 0;
        }
        checkCollision();
    }

    @Override
    public void attacking() {
        if (gp.monster1.solidArea.intersects(player.solidArea)){
            gp.monster1.life -= 1;
        }

    }
    public void specialSkill(){

    }
}
