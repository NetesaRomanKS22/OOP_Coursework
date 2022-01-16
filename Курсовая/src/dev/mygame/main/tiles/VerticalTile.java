package dev.mygame.main.tiles;
import dev.mygame.main.gfx.Assets;
public class VerticalTile extends Tile{
    public VerticalTile(int id) {
        super(Assets.verticalTile, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}