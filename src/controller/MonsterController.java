package controller;

import entity.Monster;
import main.GamePanel;

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
    }

    @Override
    public void attacking() {

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
                    monster.worldY -= monster.speed;
                    break;
                case "down":
                    monster.worldY += monster.speed;
                    break;
                case "left":
                    monster.worldX += monster.speed;
                    break;
                case "right":
                    monster.worldX -= monster.speed;
                    break;
            }
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
