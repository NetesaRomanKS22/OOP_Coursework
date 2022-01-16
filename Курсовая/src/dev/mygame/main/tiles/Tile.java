package dev.mygame.main.tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.awt.Graphics;

public class Tile{

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public static Tile[] tiles = new Tile[256];

    public static Tile spawnTile = new SpawnTile(4);
    public static Tile blockTile = new BlockTile(1);
    public static Tile horizontalTile = new HorizontalTile(2);
    public static Tile verticalTile = new VerticalTile(3);
    public static Tile bgTile = new BackgroundTile(0);


    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;

    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y ){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }

}
