package dev.mygame.main.tiles;
import dev.mygame.main.gfx.Assets;
public class BackgroundTile extends Tile{
    public BackgroundTile(int id) {
        super(Assets.bgTile, id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
