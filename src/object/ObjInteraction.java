package object;

import controller.PlayerController;
import entity.Player;
import main.GamePanel;

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
//						gp.tileM.getMap("/maps/Rung.txt");
						System.out.println("Move to next map!");
						gp.tileM.updateMap("map/Map1.xml");
					}
					break;
				case "HpPotion":
					gp.obj.remove(gp.obj.get(i));
					break;
			}
		}
	}
}