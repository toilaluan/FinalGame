package object;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_key extends OBJ{
    public OBJ_key(){
        name = "Key";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/key.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
