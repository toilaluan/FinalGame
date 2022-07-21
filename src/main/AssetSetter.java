package main;

import object.OBJ;
import object.OBJ_Door;
import object.OBJ_key;

import java.util.ArrayList;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(ArrayList<OBJ> obj){
        OBJ key_1 = new OBJ_key();
        key_1.worldX = gp.tileSize * 15;
        key_1.worldY = gp.tileSize * 15;
        obj.add(key_1);
        OBJ door_1 = new OBJ_Door();
        door_1.worldX = gp.tileSize * 27;
        door_1.worldY = gp.tileSize * 3;
        obj.add(door_1);
    }
}
