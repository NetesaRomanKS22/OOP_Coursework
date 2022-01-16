package dev.mygame.main.gfx;

import java.awt.image.*;
import java.io.Serializable;
import java.awt.Font;

public class Assets {//В этом классе будут содержаться все ассеты

    private static final int width = 64, height = 64;

    public static Font font28;

    public static BufferedImage verticalTile, horizontaltile, block, tileEnabled, tileDisabled, bgTile, upHit, downHit, leftHit, rightHit;
    public static BufferedImage[] btn_start;
    public static BufferedImage[] btn_new;
    public static BufferedImage[] btn_exit;
    public static BufferedImage[] player;
    public static BufferedImage[] coin;
    public static BufferedImage[] first;
    public static BufferedImage[] second;
    public static BufferedImage[] third;
    public static BufferedImage[] fourth;
    public static BufferedImage Logo;
    public static BufferedImage[] moovingRight;
    public static BufferedImage[] moovingLeft;
    public static void init() {
        font28 = FontLoader.loadFont("res\\fonts\\ka1.ttf", 28);

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res\\sprites\\SpriteSheet.png"));
        player  = new BufferedImage[2];
        player[0] = sheet.crop(0, 0, width - 1, height);
        player[1] = sheet.crop(width * 4, height, width - 3, height);

        Logo = ImageLoader.loadImage("res\\sprites\\logo.png");

        moovingRight = new BufferedImage[6];
        moovingRight[0] = sheet.crop(0, height*4, width, height);
        moovingRight[1] = sheet.crop(width, height*4, width, height);
        moovingRight[2] = sheet.crop(width*2, height*4, width, height);
        moovingRight[3] = sheet.crop(width*3, height*4, width, height);
        moovingRight[4] = sheet.crop(width*4, height*4, width, height);
        moovingRight[5] = sheet.crop(width*5, height*4, width, height);

        moovingLeft = new BufferedImage[6];
        moovingLeft[0] = sheet.crop(0, height*5, width, height);
        moovingLeft[4] = sheet.crop(width, height*5, width, height);
        moovingLeft[3] = sheet.crop(width*2, height*5, width, height);
        moovingLeft[2] = sheet.crop(width*3, height*5, width, height);
        moovingLeft[1] = sheet.crop(width*4, height*5, width, height);
        moovingLeft[5] = sheet.crop(width*5, height*5, width, height);

        block = sheet.crop(width, 0, width, height);
        verticalTile = sheet.crop(width * 2, 0, width, height);
        horizontaltile = sheet.crop(width * 3, 0, width - 1, height);

        coin = new BufferedImage[4];
        coin[0] = sheet.crop(width*4, 0, width, height);
        coin[1] = sheet.crop(width * 5, 0, width, height);
        coin[2] = sheet.crop(width*4, height*2, width, height);
        coin[3] = sheet.crop(width *4, height*3, width, height);

        tileEnabled = sheet.crop(width * 5, 0, width, height);
        bgTile = sheet.crop(width * 6-1, 0, width, height);

        upHit = sheet.crop(width * 5 - 2, height, width, height);
        downHit = sheet.crop(width * 6 - 1, height, width, height);
        leftHit = sheet.crop(width * 5, height * 2, width, height);
        rightHit = sheet.crop(width * 6-1, height * 2, width, height);

        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(0,height,width*2,height);
        btn_start[1] = sheet.crop(width*2 ,height,width*2-1,height);

        btn_new = new BufferedImage[2];
        btn_new[0] = sheet.crop(0,height + 128,width*2,height);
        btn_new[1] = sheet.crop(width*2 ,height + 128,width*2-1,height);

        btn_exit = new BufferedImage[2];
        btn_exit[0] = sheet.crop(0,height + 64,width*2,height);
        btn_exit[1] = sheet.crop(width*2,height+ 64 ,width*2-1,height );

        first = new BufferedImage[2];
        second = new BufferedImage[2];
        third = new BufferedImage[2];
        fourth = new BufferedImage[2];

        first[0] = sheet.crop(0, height*6, width,height);
        first[1] = sheet.crop(0, height*7, width,height);

        second[0] = sheet.crop(width, height*6, width,height);
        second[1] = sheet.crop(width, height*7, width,height);

        third[0] = sheet.crop(width*2, height*6, width,height);
        third[1] = sheet.crop(width*2, height*7, width,height);

        fourth[0] = sheet.crop(width*3, height*6, width,height);
        fourth[1] = sheet.crop(width*3, height*7, width,height);

    }
}
