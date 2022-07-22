package object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;

public class OBJ_Bom extends OBJ{
    public OBJ_Bom(){
        name = "Bom";
        colission = false;
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SpecialSkill/bom.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
