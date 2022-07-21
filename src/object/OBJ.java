package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OBJ {
    public String name;
    public BufferedImage image, image2, image3;
    public int worldX;
    public int worldY;
    public boolean colission = true;

    public Rectangle solidArea = new Rectangle(0,0,48,48);

    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - (gp.player.worldX - gp.playerController.screenX);
        int screenY = worldY - (gp.player.worldY - gp.playerController.screenY);
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
