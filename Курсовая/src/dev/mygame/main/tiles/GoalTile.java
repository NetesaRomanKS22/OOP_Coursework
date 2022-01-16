package dev.mygame.main.tiles;
import dev.mygame.main.gfx.Assets;
public class GoalTile extends Tile{
    public GoalTile(int id) {
        super(Assets.tileEnabled, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
