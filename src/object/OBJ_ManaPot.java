package object;
import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_ManaPot extends OBJ{
    public OBJ_ManaPot(){
        name = "ManaPot";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Items/Potion/WaterPot.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



