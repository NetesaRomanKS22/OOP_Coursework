package dev.mygame.main.tiles;
import dev.mygame.main.gfx.Assets;
public class HorizontalTile extends Tile{
    public HorizontalTile(int id) {
        super(Assets.horizontaltile, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
