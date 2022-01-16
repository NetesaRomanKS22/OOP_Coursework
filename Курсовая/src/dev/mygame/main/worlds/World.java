package dev.mygame.main.worlds;
import dev.mygame.main.tiles.*;
import dev.mygame.main.utils.LoadSave;
import dev.mygame.main.utils.Util;
import dev.mygame.main.*;
import dev.mygame.main.enteties.EntityManager;
import dev.mygame.main.enteties.creatures.Player;
import dev.mygame.main.enteties.statics.Coin;
import dev.mygame.main.gfx.Assets;
import dev.mygame.main.gfx.Text;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class World  {
    private Handler handler;
    private int width, height;
    private int spawnx, spawny;
    private int[][] tiles;
    private String file;
    private EntityManager entityManager;
    private int worldID, score;
    private Text winText;


    public World(Handler handler, int worldId) {
        this.handler = handler;
        this.worldID = worldId;

        entityManager = new EntityManager(handler, new Player(handler, 100, 100));

        LoadSave.createFile();
        loadWorld(1);




    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void tick() {
        entityManager.tick();
        if(entityManager.getPlayer().getPointsLeft() == 0) {//Надо очистить entity manager от кристаллов
            worldID ++;
            LoadSave.writeToFile(worldID);
            loadWorld(worldID);

        }

    }

    public void render(Graphics g) {

        for(int y = 0;y < height; y++) {
            for(int x = 0; x < width; x++) {
                getTile(x,y).render(g,(int)(x * Tile.TILEWIDTH - handler.getGameCamera().getXoffset()),(int)(y * Tile.TILEHEIGHT- handler.getGameCamera().getYoffset()));
            }
        }

        entityManager.render(g);

        if(worldID == 5 ) {
            winText.drawString(g,"YOU WIN!" ,(int)(700) , (int) (440), Color.BLACK, Assets.font28);
        }

    }

    public Tile getTile(int x, int y) {
        if(x < 0 || y < 0 || x>= width || y >= height) {
            return Tile.bgTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null) {
            return Tile.bgTile;
        }
        return t;
    }

    public void loadWorld(int ID) {
        worldID = ID;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));

        switch(ID) {
            case 1:
                file = Util.loadFileAsString("res//worlds//world1.txt");
                score = 15;//15
                break;
            case 2:
                file = Util.loadFileAsString("res//worlds//world2.txt");
                score = 57;//57
                break;
            case 3:
                file = Util.loadFileAsString("res//worlds//world3.txt");
                score = 24;//24
                break;
            case 4:
                file = Util.loadFileAsString("res//worlds//world4.txt");
                score = 42;//42
                break;
            case 5:
                file = Util.loadFileAsString("res//worlds//world5.txt");
                score = 666;//666
                break;
        }


        String[] tokens = file.split("\\s+");

        width = Util.parseInt(tokens[0]);
        height = Util.parseInt(tokens[1]);
        spawnx = Util.parseInt(tokens[2]);
        spawny = Util.parseInt(tokens[3]);

        entityManager.getPlayer().setPointsLeft(score);

        entityManager.getPlayer().setX(spawnx);
        entityManager.getPlayer().setY(spawny);

        tiles = new int[width][height];
        for(int y = 0;y < height; y++) {
            for(int x = 0; x < width; x++) {
                tiles[x][y] = Util.parseInt(tokens[(x + y * width) + 4]);
                if(tiles[x][y] == 4) {
                    entityManager.addEntity(new Coin(handler,(int)(x * Tile.TILEWIDTH ),(int)(y * Tile.TILEHEIGHT)));
                }else {
                    continue;
                }
            }
        }




    }
}
