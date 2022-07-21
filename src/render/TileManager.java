package render;

import graphic.SpriteSheet;
import main.GamePanel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class TileManager {
    public ArrayList<FloorMap>  tileMaps;
    private int width;
    private int height;
    private int columns;
    private String file;
    public GamePanel gp;
    public TileManager(GamePanel gp){
        tileMaps = new ArrayList<>();
        this.gp = gp;
        addTileMap("map/Map2.xml");
    }
    public void updateMap(String path){
        tileMaps = new ArrayList<>();
        addTileMap(path);
    }
//    public static void main(String[] args) {
//        GamePanel gp = new GamePanel();
//        TileManager tm = new TileManager(gp);
//        tm.addTileMap("map/Map1.xml");
//    }
    private void addTileMap(String path){
        int tileWidth;
        int tileHeight;
        int tileColumns;
        String imagePath;
        ArrayList<SpriteSheet> sprites = new ArrayList<>();
        String[] data = new String[10];
//        System.out.println(path);
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("tileset");
            Node node1 = list.item(0);
            Element eElement1 = (Element) node1;

            imagePath = eElement1.getAttribute("name");
            tileWidth = Integer.parseInt(eElement1.getAttribute("tilewidth"));
            tileColumns = Integer.parseInt(eElement1.getAttribute("columns"));
            int tileCount = 0;
            ArrayList<Integer> tileCounts = new ArrayList<>();
            this.columns = tileColumns;
            this.file = imagePath;
            NodeList list2 = doc.getElementsByTagName("layer");
            Node node2;
            int layers = list2.getLength();
            Element eElement2;
            for (int i = 0; i < layers; i++){
                node1 = list.item(i);
                eElement1 = (Element) node1;
                imagePath = eElement1.getAttribute("name");
                sprites.add(new SpriteSheet(this.gp, "/map/" + imagePath + ".png"));
                System.out.println(imagePath);
            }
            for (int i = 0; i < layers; i++){
                node1 = list.item(i);
                eElement1 = (Element) node1;
                node2 = list2.item(i);
                eElement2 = (Element) node2;
                width = Integer.parseInt(eElement2.getAttribute("width"));
                height = Integer.parseInt(eElement2.getAttribute("height"));
                data[i] = eElement2.getElementsByTagName("data").item(0).getTextContent();
                tileColumns = Integer.parseInt(eElement1.getAttribute("columns"));
                if (i == 0){
                    tileMaps.add(new FloorMap(sprites.get(i), data[i], width, height, tileColumns, tileCount, false));
                }
                else if (i == 1){
                    tileMaps.add(new FloorMap(sprites.get(i), data[i], width, height, tileColumns, tileCount, true));
                }
                tileCount += Integer.parseInt(eElement1.getAttribute("tilecount"));
            }

        } catch (Exception e){
            System.out.println("ERROR - TILEMANAGER: can not read tilemap:");
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void draw(Graphics2D g2){
        this.tileMaps.get(0).draw(g2, gp);
        this.tileMaps.get(1).draw(g2, gp);
    }
}
