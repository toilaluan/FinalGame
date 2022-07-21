package graphic;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class SpriteSheet {

    public BufferedImage image; // creating another Buffered Image
    GamePanel gp;

    public SpriteSheet(GamePanel gp, String spritePath) {
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(spritePath)));
        }catch(Exception e){
            e.printStackTrace();
        }
        this.gp = gp;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {

        return image.getSubimage(col, row, width, height);
        //Selecting the rows and columns of the spritesheet in folder res. 
        //This determines what image from the sprite sheet to display, in this case the player.
    }

    public ArrayList<BufferedImage> getSpriteImage(int numCol, int numRow){
        ArrayList<BufferedImage> images = new ArrayList<>();
        int w = this.image.getWidth()/numCol;
        int h = this.image.getHeight()/numRow;
        for (int i=0; i < numCol; i++){
            for (int j = 0; j < numRow; j++){
                BufferedImage image = this.grabImage(i*w, j*h, w, h);
                images.add(image);
            }
        }
        return images;
    }
}