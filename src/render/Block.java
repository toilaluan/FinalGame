package render;

import graphic.SpriteSheet;

import java.awt.image.BufferedImage;

public class Block {
    public int row, col, spriteRow, spriteCol;
    BufferedImage image;
    public Block(int spriteRow, int spriteCol, int row, int col, BufferedImage image){
        this.row = row;
        this.col = col;
        this.spriteCol = spriteCol;
        this.spriteRow = spriteRow;
        this.image = image;

    }
}
