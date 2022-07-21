package object;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Chest extends OBJ{

    public OBJ_Chest(){
        name = "Chest";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/chest.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
