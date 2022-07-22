package main;

import object.*;

import java.util.ArrayList;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(ArrayList<OBJ> obj){
        if(gp.checkmap) {
            OBJ key_1 = new OBJ_key();
            key_1.worldX = gp.tileSize * 15;
            key_1.worldY = gp.tileSize * 15;
            obj.add(key_1);
            OBJ door_1 = new OBJ_Door();
            door_1.worldX = gp.tileSize * 30;
            door_1.worldY = gp.tileSize * 10;
            obj.add(door_1);
            OBJ SpeedPot1 = new OBJ_SpeedPotion();
            SpeedPot1.worldX = gp.tileSize * 15;
            SpeedPot1.worldY = gp.tileSize * 3;
            obj.add(SpeedPot1);
            OBJ SpeedPot2 = new OBJ_SpeedPotion();
            SpeedPot2.worldX = gp.tileSize * 24;
            SpeedPot2.worldY = gp.tileSize * 13;
            obj.add(SpeedPot2);
            OBJ SpeedPot3 = new OBJ_SpeedPotion();
            SpeedPot3.worldX = gp.tileSize * 15;
            SpeedPot3.worldY = gp.tileSize * 6;
            obj.add(SpeedPot3);
            OBJ SpeedPot4 = new OBJ_SpeedPotion();
            SpeedPot4.worldX = gp.tileSize * 12;
            SpeedPot4.worldY = gp.tileSize * 11;
            obj.add(SpeedPot4);
            OBJ HpPot1 = new OBJ_HpPotion();
            HpPot1.worldX = gp.tileSize * 11;
            HpPot1.worldY = gp.tileSize * 2;
            obj.add(HpPot1);
            OBJ HpPot2 = new OBJ_HpPotion();
            HpPot2.worldX = gp.tileSize * 18;
            HpPot2.worldY = gp.tileSize * 13;
            obj.add(HpPot2);
            OBJ HpPot3 = new OBJ_HpPotion();
            HpPot3.worldX = gp.tileSize * 15;
            HpPot3.worldY = gp.tileSize * 8;
            obj.add(HpPot3);
            OBJ HpPot4 = new OBJ_HpPotion();
            HpPot4.worldX = gp.tileSize * 8;
            HpPot4.worldY = gp.tileSize * 9;
            obj.add(HpPot4);
            OBJ ManaPot1 = new OBJ_ManaPot();
            ManaPot1.worldX = gp.tileSize * 32;
            ManaPot1.worldY = gp.tileSize * 6;
            obj.add(ManaPot1);
            OBJ ManaPot2 = new OBJ_ManaPot();
            ManaPot2.worldX = gp.tileSize * 15;
            ManaPot2.worldY = gp.tileSize * 13;
            obj.add(ManaPot2);
            OBJ ManaPot3 = new OBJ_ManaPot();
            ManaPot3.worldX = gp.tileSize * 9;
            ManaPot3.worldY = gp.tileSize * 2;
            obj.add(ManaPot3);
            OBJ ManaPot4 = new OBJ_ManaPot();
            ManaPot4.worldX = gp.tileSize * 4;
            ManaPot4.worldY = gp.tileSize * 9;
            obj.add(ManaPot4);
            OBJ ManaPot6 = new OBJ_ManaPot();
            ManaPot6.worldX = gp.tileSize * 29;
            ManaPot6.worldY = gp.tileSize * 25;
            obj.add(ManaPot6);
            OBJ ManaPot5 = new OBJ_ManaPot();
            ManaPot5.worldX = gp.tileSize * 25;
            ManaPot5.worldY = gp.tileSize * 35;
            obj.add(ManaPot5);
            OBJ Shield6 = new OBJ_Shield();
            Shield6.worldX = gp.tileSize * 25;
            Shield6.worldY = gp.tileSize * 29;
            obj.add(Shield6);
            OBJ Shield5 = new OBJ_Shield();
            Shield5.worldX = gp.tileSize * 27;
            Shield5.worldY = gp.tileSize * 32;
            obj.add(Shield5);
        }
        else {
            OBJ key_1 = new OBJ_key();
            key_1.worldX = gp.tileSize * 1;
            key_1.worldY = gp.tileSize * 15;
            obj.add(key_1);
            OBJ door_1 = new OBJ_Door();
            door_1.worldX = gp.tileSize * 23;
            door_1.worldY = gp.tileSize * 3;
            obj.add(door_1);
            OBJ SpeedPot1 = new OBJ_SpeedPotion();
            SpeedPot1.worldX = gp.tileSize * 15;
            SpeedPot1.worldY = gp.tileSize * 3;
            obj.add(SpeedPot1);
            OBJ SpeedPot2 = new OBJ_SpeedPotion();
            SpeedPot2.worldX = gp.tileSize * 24;
            SpeedPot2.worldY = gp.tileSize * 13;
            obj.add(SpeedPot2);
            OBJ SpeedPot3 = new OBJ_SpeedPotion();
            SpeedPot3.worldX = gp.tileSize * 19;
            SpeedPot3.worldY = gp.tileSize * 15;
            obj.add(SpeedPot3);
            OBJ SpeedPot4 = new OBJ_SpeedPotion();
            SpeedPot4.worldX = gp.tileSize * 12;
            SpeedPot4.worldY = gp.tileSize * 17;
            obj.add(SpeedPot4);
            OBJ HpPot1 = new OBJ_HpPotion();
            HpPot1.worldX = gp.tileSize * 11;
            HpPot1.worldY = gp.tileSize * 7;
            obj.add(HpPot1);
            OBJ HpPot2 = new OBJ_HpPotion();
            HpPot2.worldX = gp.tileSize * 16;
            HpPot2.worldY = gp.tileSize * 13;
            obj.add(HpPot2);
            OBJ HpPot3 = new OBJ_HpPotion();
            HpPot3.worldX = gp.tileSize * 10;
            HpPot3.worldY = gp.tileSize * 8;
            obj.add(HpPot3);
            OBJ HpPot4 = new OBJ_HpPotion();
            HpPot4.worldX = gp.tileSize * 8;
            HpPot4.worldY = gp.tileSize * 2;
            obj.add(HpPot4);
        }
    }
    public void setSingleOBJ(ArrayList<OBJ> obj, OBJ singleOBJ, int x, int y){
        singleOBJ.worldY = y;
        singleOBJ.worldX = x;
        obj.add(singleOBJ);
    }
}
