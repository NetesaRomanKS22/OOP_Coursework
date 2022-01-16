package dev.mygame.main.states;
import dev.mygame.main.Game;
import dev.mygame.main.Handler;

import java.awt.Graphics;

import dev.mygame.main.gfx.Assets;
import dev.mygame.main.tiles.Tile;
import dev.mygame.main.ui.ClickListener;
import dev.mygame.main.ui.UIImageButton;
import dev.mygame.main.ui.UIManager;
import dev.mygame.main.utils.LoadSave;

public class MenuState extends State {

    private UIManager uiManager;
    private GameState newGame;
    public MenuState(Handler handler) {
        super(handler);

        Assets.init();
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButton(650, 500, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT, Assets.btn_start, new ClickListener() {

            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
                handler.getWorld().loadWorld(LoadSave.readFromFile());

            }}));


        uiManager.addObject(new UIImageButton(650, 600, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT , Assets.btn_exit, new ClickListener() {

            @Override
            public void onClick() {

                handler.getGame().getDisplay().getFrame().dispose();
                handler.getGame().stop();
            }}));

        uiManager.addObject(new UIImageButton(650, 400, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT , Assets.btn_new, new ClickListener() {

            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);

                handler.getGame().newGame();

            }}));
    }


    @Override
    public void tick() {
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);

        g.drawImage(Assets.block,950, 300,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.block,400, 300,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,950, 364,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,400, 364,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,950, 428,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,400, 428,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,950, 492,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,400, 492,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,950, 556,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,400, 556,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,950, 620,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,400, 620,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,950, 684,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,400, 684,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,950, 748,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.verticalTile,400, 748,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.block,950, 812,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.block,400, 812,Tile.TILEWIDTH,Tile.TILEHEIGHT,null);
        g.drawImage(Assets.Logo,450, 50, 512, 256, null);
    }


}