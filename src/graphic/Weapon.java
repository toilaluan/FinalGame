package graphic;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Weapon {
    String weapon_path = "/Items/Weapons/Lance/SpriteInHand.png";
    SpriteSheet weapon_SS;
    GamePanel gp;
    static int w = 6;
    static int h = 16;
    ArrayList<BufferedImage> weapon_images;

    BufferedImage image;
    public Weapon(GamePanel gp){
        this.gp = gp;
        weapon_SS = new SpriteSheet(gp, weapon_path);
        weapon_images = weapon_SS.getSpriteImage(1, 1);
        image = resize(weapon_images.get(0), w, h);
    }
    public void draw(Graphics2D g2){
        BufferedImage r_img;
        switch (gp.player.direction){
            case "down":
                r_img = rotateImageByDegrees(image, 0);
                g2.drawImage(r_img,
                        gp.playerController.screenX,
                        gp.playerController.screenY+gp.tileSize,
                        r_img.getWidth()*gp.scale,
                        r_img.getHeight()*gp.scale,
                        null);
                break;
            case "up":
                r_img = rotateImageByDegrees(image, 180);
                g2.drawImage(
                        r_img,
                        gp.playerController.screenX + gp.tileSize/2,
                        gp.playerController.screenY-gp.tileSize/2,
                        r_img.getWidth()*gp.scale,
                        r_img.getHeight()*gp.scale,
                        null);
                break;
            case "left":
                r_img = rotateImageByDegrees(image, 90);
                g2.drawImage(
                        r_img,
                        gp.playerController.screenX - gp.tileSize,
                        gp.playerController.screenY + gp.tileSize/2,
                        r_img.getWidth()*gp.scale,
                        r_img.getHeight()*gp.scale,
                        null);
                break;
            case "right":
                r_img = rotateImageByDegrees(image, 270);
                g2.drawImage(
                        r_img,
                        gp.playerController.screenX + gp.tileSize,
                        gp.playerController.screenY + gp.tileSize/2,
                        r_img.getWidth()*gp.scale,
                        r_img.getHeight()*gp.scale,
                        null);
                break;
        }

    }

    public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, null, 0, 0);
        g2d.dispose();

        return rotated;
    }
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
