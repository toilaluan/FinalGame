package object;
import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_SpeedPotion extends OBJ{
    public OBJ_SpeedPotion(){
        name = "SpeedPotion";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/potion_yellow.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static int speedBonus = 1;
}



