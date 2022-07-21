package object;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Shield extends OBJ{

    public OBJ_Shield(){
        name = "Shield";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/shield_blue.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
