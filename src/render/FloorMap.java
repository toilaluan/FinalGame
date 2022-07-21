package render;

import graphic.SpriteSheet;
import main.GamePanel;

import java.awt.*;

public class FloorMap extends TileMap{
    public Block[] blocks;
    public int mapWidth, mapHeight, columns;
    SpriteSheet sprite;
    boolean collision;
    public FloorMap(SpriteSheet sprite, String data, int mapWidth, int mapHeight, int columns, int tileCount, boolean collision){
        this.sprite = sprite;
        this.collision = collision;
        blocks = new Block[mapWidth * mapHeight];
        this.mapHeight = mapHeight; //20
        this.mapWidth = mapWidth; //40
        this.columns = columns; //22
        String [] block_id = data.split(",");
        for (int i = 0; i < (mapWidth * mapHeight); i++){
            int temp = Integer.parseInt(block_id[i].replaceAll("\\s+", "")) - tileCount;
            if (temp > 0){
                int spriteRow = (temp-1)/columns;
                int spriteCol = (temp-1)%(columns);
                blocks[i] = new Block(temp/columns, temp % columns, i / mapWidth, i % mapWidth, sprite.grabImage(spriteCol * 16, spriteRow * 16, 16, 16));
            }
        }
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        for (int i = 0; i < mapHeight * mapWidth; i++){
            if (blocks[i] != null){
//                System.out.println(i);
                int col = blocks[i].col;
                int row = blocks[i].row;
                int worldX = col*gp.tileSize;
                int worldY = row*gp.tileSize;
                int screenX = worldX - (gp.player.worldX - gp.playerController.screenX);
                int screenY = worldY - (gp.player.worldY - gp.playerController.screenY);
//                System.out.println(i);
                g2.drawImage(blocks[i].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
        }

    }
}
