package object;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Heart extends OBJ {
    public OBJ_Heart() {
        name = "Heart";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/heart_full.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/heart_half.png")));
            image3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/heart_blank.png")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}