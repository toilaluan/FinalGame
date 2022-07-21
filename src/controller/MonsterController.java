package controller;

import entity.Monster;
import main.GamePanel;

import java.awt.*;
import java.util.Stack;

public class MonsterController extends EntityController{
    GamePanel gp;
    Monster monster;
    public MonsterController(GamePanel gp, Monster monster){
        this.gp = gp;
        this.monster = monster;
        setDefaultValue();
    }
    private void setDefaultValue(){
        monster.worldX = gp.tileSize * 8;
        monster.worldY = gp.tileSize * 8;
        monster.defaultWorldX = monster.worldX;
        monster.defaultWorldY = monster.worldY;
        heroCounter = 0;
        heroNum = 0;
        monster.solidArea = new Rectangle();
        monster.solidArea.x = 8;
        monster.solidArea.y = 16;
        monster.solidArea.width = 32;
        monster.solidArea.height = 32;
    }
    @Override
    public void update() {
        screenX = monster.worldX - (gp.player.worldX - gp.playerController.screenX);
        screenY = monster.worldY - (gp.player.worldY - gp.playerController.screenY);
        if(checkArea()){
            chasing(gp.player.worldX, gp.player.worldY);
        }
        else{
            chasing(monster.defaultWorldX, monster.defaultWorldY);
        }
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

    @Override
    public void attacking() {
        System.out.println("Monster attacking");
        heroCounter++;
        if(heroCounter <= 5){
            heroNum = 1;
        }
        if(heroCounter > 5 && heroCounter < 10){
            heroNum = 2;
            //luu worldX,Y, solidArea
            int currentWorldX = monster.worldX;
            int currentWorldY = monster.worldY;
            int solidAreaWidth = monster.solidArea.width;
            int solidAreaHeight = monster.solidArea.height;

            switch (monster.direction){
                case "up":
                    monster.worldY -= monster.attackArea.height;
                    break;
                case "down":
                    monster.worldY += monster.attackArea.height;
                    break;
                case "left":
                    monster.worldX -= monster.attackArea.width;
                    break;
                case "right":
                    monster.worldX += monster.attackArea.width;
                    break;
            }

            monster.solidArea.width = monster.attackArea.width;
            monster.solidArea.height = monster.attackArea.height;

//			int monIndex = gp.cChecker.checkEntity(this, gp.monster);
//			damageMonster(monIndex, atk);
            monster.worldX = currentWorldX;
            monster.worldY = currentWorldY;
            monster.solidArea.width = solidAreaWidth;
            monster.solidArea.height = solidAreaHeight;
        }
        if(heroCounter >= 10){
            heroNum = 1;
            heroCounter = 0;
            monster.attacking = false;
        }
    }
    public void chasing(int targetX, int targetY){
        int dx = monster.worldX - targetX;
        int dy = monster.worldY - targetY;
        int col = Math.abs(dx/gp.tileSize);
        int row = Math.abs(dy/gp.tileSize);
        double distance = Math.sqrt(dx*dx + dy*dy);
        Stack<String> stackMove = new Stack<>();
        for (int i = 0; i < col; i++){
            if (dx > 0){
                stackMove.add("right");
            }
            else {
                stackMove.add("left");
            }
        }
        for (int i = 0; i < row; i++){
            if (dy > 0){
                stackMove.add("up");
            }
            else {
                stackMove.add("down");
            }
        }
        while (!stackMove.empty()){
            String move = stackMove.pop();
            System.out.println(move);
            switch (move){
                case "up":
                    monster.direction = "up";
                    monster.worldY -= monster.speed;
                    break;
                case "down":
                    monster.direction = "down";
                    monster.worldY += monster.speed;
                    break;
                case "left":
                    monster.direction = "right";
                    monster.worldX += monster.speed;
                    break;
                case "right":
                    monster.direction = "left";
                    monster.worldX -= monster.speed;
                    break;
            }
            monster.attacking = true;
            attacking();
//            monster.attacking = false;
        }

    }
    public boolean checkArea(){
        double distance = Math.sqrt(Math.pow(gp.playerController.screenX - screenX,2) + Math.pow(gp.playerController.screenY - screenY, 2));
        if (distance < gp.tileSize * 3){
            return true;
        }
        return false;
    }
}
