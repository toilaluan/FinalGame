package object;

import controller.PlayerController;
import entity.Player;
import main.GamePanel;

import java.util.ArrayList;

public class ObjInteraction {
	public void ObjInteraction(GamePanel gp, int i) {
		if (i != 999) {
			String objectName = gp.obj.get(i).name;
			switch (objectName) {
				case "Key":
					gp.playerController.hasKey = true;
					gp.obj.remove(gp.obj.get(i));
					break;
				case "Door":
					if (gp.playerController.hasKey) {
						gp.obj.remove(gp.obj.get(i));
						gp.checkmap=false;
						gp.tileM.updateMap("map/ice2layer.xml");
						gp.playerController.hasKey = false;
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
			}
		}
	}
}