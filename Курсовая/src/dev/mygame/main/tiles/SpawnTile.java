package dev.mygame.main.tiles;
import dev.mygame.main.gfx.Assets;
public class SpawnTile extends Tile{
    public SpawnTile(int id) {
        super(Assets.bgTile, id);
    }
    @Override
    public boolean isSolid() {
        return false;
    }
}
