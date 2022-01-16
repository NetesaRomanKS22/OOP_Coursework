package dev.mygame.main.tiles;
import dev.mygame.main.gfx.Assets;
public class BlockTile extends Tile{


    public BlockTile(int id) {
        super(Assets.block, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
