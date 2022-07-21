package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTile;
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[100];
        this.mapTile = new int[gp.maxWorldRow][gp.maxWorldCol];
        setImage();
        getMap("/maps/Samac.txt");
    }


    public void setImage(){
        try {
            tile[0] = new Tile();
            tile[1] = new Tile();
            tile[2] = new Tile();
            tile[3] = new Tile();
            tile[4] = new Tile();
            tile[5] = new Tile();
            tile[6] = new Tile();
            tile[7] = new Tile();
            tile[8] = new Tile();
            tile[9] = new Tile();
            tile[10] = new Tile();
            tile[11] = new Tile();
            tile[12] = new Tile();
            tile[14] = new Tile();
            tile[15] = new Tile();
            tile[16] = new Tile();
            tile[17] = new Tile();
            tile[18] = new Tile();
            tile[19] = new Tile();
            tile[20] = new Tile();
            tile[21] = new Tile();
            tile[22] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road00.png")));
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water00.png")));
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass00.png")));
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/floor01.png")));
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/cau16.png")));
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/da16.png")));
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/xrong16.png")));
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/nuoc16.png")));
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/dua16.png")));
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/cat16.png")));
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass_12.png")));
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/botwatergrass_14.png")));
            tile[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/nuoc_15.png")));
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/cay1_16.png")));
            tile[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/cay2_17.png")));
            tile[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/topBtree_18.png")));
            tile[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/botBtree_19.png")));
            tile[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall_20.png")));
            tile[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/sand.png")));
            tile[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/topwatergrass_22.png")));



            tile[4].collision = true;
            tile[7].collision = true;
            tile[8].collision = true;
            tile[9].collision = true;
            tile[10].collision = true;
            tile[15].collision = true;
            tile[17].collision = true;
            tile[18].collision = true;
            tile[19].collision = true;
            tile[20].collision = true;
            tile[16].collision = true;

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getMap(String path){
        try{

//            File f = new File(path);
//            BufferedReader br = new BufferedReader(new FileReader(f));
//            int row = 0, col = 0;
//            for (row=0; row <gp.maxWorldRow; row++){
//                String line = br.readLine();
//                String[] numbers = line.split(" ");
//                for (col = 0; col<gp.maxWorldCol; col++){
//                    int num = Integer.parseInt(numbers[col]);
//                    mapTile[row][col] = num;
//                }
//            }
            InputStream is = getClass().getResourceAsStream(path);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            int col = 0;
            while (row < gp.maxWorldRow && col < gp.maxWorldCol){
                String line = br.readLine();
                String[] numbers = line.split("\\s+");
                while (col < gp.maxWorldCol){
                    int num = Integer.parseInt(numbers[col]);
                    mapTile[row][col] = num;
                    col++;
                }
                if (col == gp.maxWorldCol){
                    col = 0;
                    row += 1;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int col = 0, row = 0;
        while (col < gp.maxWorldCol && row < gp.maxWorldRow){
            int tileNum = mapTile[row][col];
//            System.out.println(tileNum);
            int worldX = col*gp.tileSize;
            int worldY = row*gp.tileSize;
            int screenX = worldX - (gp.player.worldX - gp.player.screenX);
            int screenY = worldY - (gp.player.worldY - gp.player.screenY);
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            col += 1;
            if (col == gp.maxWorldCol){
                col = 0;
                row += 1;
            }
        }

    }
}
