package main;


import object.OBJ;
import object.OBJ_Heart;
import object.OBJ_mana;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    BufferedImage heart_full, heart_half, heart_blank, mana_full,mana_half, mana_blank;
    Font arial_40;
    Font arial_80B;
    int subState = 0;
    public int commandNum = 0;
    public int titleScreenState;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        //CREATE HUB  OBJECT
        OBJ heart = new OBJ_Heart();
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;

        OBJ mana = new OBJ_mana();
        mana_blank = mana.image;
        mana_half = mana.image2;
        mana_full = mana.image3;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
            drawPlayerMana();
        } else if (gp.gameState == gp.pauseState) {
            drawPlayerLife();
            drawPlayerMana();
            drawPauseScreen();
        }
    }
    public void drawPlayerLife(){
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        while(i < gp.player.maxlife/2){
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }
        //RESET
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;
        //DRAW CURRENT LIFE
        while(i< gp.player.life){
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawPlayerMana(){
        int x = gp.tileSize/2;
        int y = gp.tileSize;
        int i = 0;
        while(i < gp.player.maxMana/2){
            g2.drawImage(mana_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }
        x = gp.tileSize/2;
        y = gp.tileSize;
        i = 0;
        while(i< gp.player.mana){
            g2.drawImage(mana_half, x, y, null);
            i++;
            if(i<gp.player.mana){
                g2.drawImage(mana_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }
    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void drawPauseScreen() {
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;
        final int frameX = gp.screenWidth / 2 - 120;
        final int frameY = gp.screenHeight / 2 - 60;
        final int frameWidth = gp.tileSize * 5;
        final int frameHeight = gp.tileSize * 2;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        g2.drawString(text, x, y);
    }

    public void drawTitleScreen() {
        if(titleScreenState==0) {
            g2.setColor(new Color(34, 73, 204));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 70F));
            String text = "Blue ninja Adventure";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 3;
            //Shadow
            g2.setColor(Color.black);
            g2.drawString(text, x + 5, y + 5);
            //Main Color
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
            //Menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
            text = "New Game";
            x = getXforCenteredText(text);
            y += gp.tileSize * 6;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Load Game";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Quit";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        }
        else if(titleScreenState==1){
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));

            String text = "Select your class";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;
            g2.drawString(text,x,y);

            text = "Fighter";
            x = getXforCenteredText(text);
            y += gp.tileSize*5;
            g2.drawString(text,x,y);
            if(commandNum == 0){
                g2.drawString(">", x -gp.tileSize,y);
            }

            text = "Thief";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text,x,y);
            if(commandNum == 1){
                g2.drawString(">", x -gp.tileSize,y);
            }

            text = "Sorcerer";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text,x,y);
            if(commandNum == 2){
                g2.drawString(">", x -gp.tileSize,y);
            }

            text = "Back";
            x = getXforCenteredText(text);
            y += gp.tileSize*2;
            g2.drawString(text,x,y);
            if(commandNum == 3){
                g2.drawString(">", x -gp.tileSize,y);
            }
        }
    }

}
