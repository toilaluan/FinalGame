package object;

import controller.PlayerController;
import entity.Player;
import main.GamePanel;

import java.util.ArrayList;
import java.util.Random;

public class ObjInteraction {
	public void ObjInteraction(GamePanel gp, int i) {
		if (i != 999) {
			String objectName = gp.obj.get(i).name;
			switch (objectName) {
				case "Key":
					PlayerController.hasKey = true;
					gp.obj.remove(gp.obj.get(i));
					break;
				case "Door":
					if (PlayerController.hasKey) {
						gp.obj.remove(gp.obj.get(i));
						gp.checkmap=false;
						gp.tileM.updateMap("map/ice2layer.xml");
						gp.obj=new ArrayList<>();
						gp.aSetter.setObject(gp.obj);
					}
					break;
				case "HpPotion":
					gp.player.life++;
					gp.obj.remove(gp.obj.get(i));
					break;
				case "SpeedPotion":
                    OBJ_SpeedPotion.speedBonus+=1;
					gp.obj.remove(gp.obj.get(i));
					break;
				case "ManaPot":
					gp.player.mana++;
					gp.obj.remove(gp.obj.get(i));
					break;
				case "Shield":
					gp.player.defend++;
					gp.obj.remove(gp.obj.get(i));
					break;
				case "Chest":
					Random rand = new Random();
					int random = rand.nextInt(100)+1;
					switch (random%3){
						case 0:
							gp.player.life++;
						case 1:
							gp.player.mana++;
						case 2:
							gp.player.attack++;
					}
					gp.obj.remove(gp.obj.get(i));
					break;
			}
		}
	}
}