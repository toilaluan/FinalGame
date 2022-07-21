package object;
import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_HpPotion extends OBJ{
    public OBJ_HpPotion(){
        name = "HpPotion";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/potion_red.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static int HpBonus = 1;
}



