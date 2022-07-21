package object;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_mana extends OBJ {
    public OBJ_mana() {
        name = "Mana";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/manacrystal_blank.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/manacrystal_half.png")));
            image3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/manacrystal_full.png")));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
