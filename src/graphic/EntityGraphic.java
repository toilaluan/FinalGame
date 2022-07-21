package graphic;

import controller.EntityController;
import entity.Entity;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class EntityGraphic extends Entity {
    Entity player;
    GamePanel gp;
	KeyHandler keyH;
	String walk_SS_path;
	String attack_SS_path;
	String attack_item_SS_path;
	SpriteSheet walkSS;
	SpriteSheet attackSS;
    ArrayList<BufferedImage> walk_images;
	ArrayList<BufferedImage> attack_images;
	EntityController entityController;
	Weapon wp;
    public EntityGraphic(Entity p, GamePanel gp, String playerType, String attackType, EntityController entityController){
		this.walk_SS_path = "/Actor/Characters/" + playerType + "/SeparateAnim/Walk.png";
		this.attack_SS_path = "/Actor/Characters/" + playerType + "/SeparateAnim/Attack.png";
		this.attack_item_SS_path = "/Items/Weapons/" + attackType + "SpriteInHand.png";
		this.player = p;
		this.keyH = gp.keyH;
        this.gp = gp;
		this.walkSS = new SpriteSheet(gp, walk_SS_path);
		this.attackSS = new SpriteSheet(gp, attack_SS_path);
		walk_images = walkSS.getSpriteImage(4, 4);
		attack_images = attackSS.getSpriteImage(4, 1);
		wp = new Weapon(gp);
		this.entityController = entityController;
    }
	public EntityGraphic(Entity p, GamePanel gp, String monsterType, EntityController entityController){
		this.walk_SS_path = "/Actor/Monsters/" + monsterType + "/" + monsterType + ".png";
		this.attack_SS_path = "/Actor/Characters/" + "BlueNinja" + "/SeparateAnim/Attack.png";
		this.attack_item_SS_path = "/Items/Weapons/" + "Lance" + "SpriteInHand.png";
		this.player = p;
		this.keyH = gp.keyH;
		this.gp = gp;
		this.walkSS = new SpriteSheet(gp, walk_SS_path);
		this.attackSS = new SpriteSheet(gp, attack_SS_path);
		walk_images = walkSS.getSpriteImage(4, 4);
		attack_images = attackSS.getSpriteImage(4, 1);
		wp = new Weapon(gp);
		this.entityController = entityController;
	}
    public BufferedImage getImage(String path){
		BufferedImage bImage = null;
        try{
			bImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        }catch(Exception e){
            e.printStackTrace();
        }
		return bImage;
    }


	public void draw(Graphics2D g2) {
		BufferedImage image = null;
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		switch(player.direction) {
		case "right":
			if (player.attacking){
				image = attack_images.get(3);
			}
			else{
				image = imageSelector(walk_images.get(12), walk_images.get(13), walk_images.get(14), walk_images.get(15));
			}
			break;
		case "down":
			if (player.attacking){
				image = attack_images.get(0);
			}
			else{
				image = imageSelector(walk_images.get(0), walk_images.get(1), walk_images.get(2), walk_images.get(3));
			}
			break;
		case "left":
			if (player.attacking){
				image = attack_images.get(2);
			}
			else{
				image = imageSelector(walk_images.get(8), walk_images.get(9), walk_images.get(10), walk_images.get(11));
			}
			break;
		case "up":
			if (player.attacking){
				image = attack_images.get(1);
			}
			else{
				image = imageSelector(walk_images.get(4), walk_images.get(5), walk_images.get(6), walk_images.get(7));
			}
			break;
		}
		if (player.attacking){
			wp.draw(g2);
		}
		g2.drawImage(image, entityController.screenX, entityController.screenY, gp.tileSize, gp.tileSize, null);
	}

	public BufferedImage imageSelector(BufferedImage run0, BufferedImage run1, BufferedImage run2, BufferedImage run3) {
		BufferedImage image = null;
		switch (entityController.heroNum){
			case 0: image = run0; break;
			case 1: image = run1; break;
			case 2: image = run2; break;
			case 3: image = run3; break;
		}
		return image;
	}
	public void drawItemAnimation(){

	}
}
