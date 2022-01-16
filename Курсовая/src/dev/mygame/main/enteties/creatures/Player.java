package dev.mygame.main.enteties.creatures;


import java.awt.*;
import java.awt.Color;
import dev.mygame.main.gfx.*;
import dev.mygame.main.states.MenuState;
import dev.mygame.main.states.State;
import dev.mygame.main.ui.UIManager;

import dev.mygame.main.*;
import dev.mygame.main.enteties.Entity;

public class Player extends Creature {

    private Animation animRight, animLeft;
    private boolean facesRight = true;
    private int pointsLeft;
    private Text text;


    public Player(Handler handler,float x, float y) {

        super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);


        bounds.x = 3;
        bounds.y = 3;
        bounds.width = this.width - 12;
        bounds.height = this.height - 12;

        animLeft = new Animation(50, Assets.moovingLeft);//Каждую милисекунду смена кадра
        animRight = new Animation(50, Assets.moovingRight);

    }

    @Override
    public void tick() {

        animLeft.tick();
        animRight.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        checkAttacks();


    }

    private void checkAttacks(){


        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;

        }else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;

        }else if(handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            facesRight = false;
        }else if(handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            facesRight = true;
        }else{
            return;

        }



        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0, 0).intersects(ar)){
                e.hurt();
                return;
            }
        }

    }

    @Override
    public void die() {

    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if(handler.getKeyManager().escape)
            State.setState(new MenuState(handler));
        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left) {
            facesRight = false;
            xMove = -speed;
        }
        if(handler.getKeyManager().right) {
            facesRight = true;
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        text.drawString(g,"Points     " + pointsLeft ,(int)(x - handler.getGameCamera().getXoffset() - 700) , (int) (y- handler.getGameCamera().getYoffset() - 440), Color.BLACK, Assets.font28);

        if(facesRight)
            g.drawImage(animRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getXoffset()), (int) (y- handler.getGameCamera().getYoffset()), width, height, null);
        else
            g.drawImage(animLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getXoffset()), (int) (y- handler.getGameCamera().getYoffset()), width, height, null);
        if (handler.getKeyManager().aUp) {
            Rectangle cb = getCollisionBounds(0, 0);
            int arSize = 20;
            g.drawImage(Assets.upHit, (int) ((cb.x + cb.width/2 - arSize/2) - handler.getGameCamera().getXoffset()-20),(int) ((cb.y - arSize) - handler.getGameCamera().getYoffset()-25 ), 64, 64, null);
        }else if (handler.getKeyManager().aDown) {
            Rectangle cb = getCollisionBounds(0, 0);
            int arSize = 20;
            g.drawImage(Assets.downHit, (int) ((cb.x + cb.width/2 - arSize/2) - handler.getGameCamera().getXoffset())-17,(int) ((cb.y + cb.height) - handler.getGameCamera().getYoffset() - 10), 64, 54, null);

        }else if (handler.getKeyManager().aLeft) {
            Rectangle cb = getCollisionBounds(0, 0);
            int arSize = 20;
            g.drawImage(Assets.leftHit, (int) ((cb.x - arSize) - handler.getGameCamera().getXoffset()- 25),(int) ((cb.y + cb.height/2 - arSize/2) - handler.getGameCamera().getYoffset()- 20), 64, 64, null);

        }else if (handler.getKeyManager().aRight) {
            Rectangle cb = getCollisionBounds(0, 0);
            int arSize = 20;
            g.drawImage(Assets.rightHit, (int) ((cb.x + cb.width) - handler.getGameCamera().getXoffset()- 30 ),(int) ((cb.y + cb.height/2 - arSize/2) - handler.getGameCamera().getYoffset()-20), 64, 64, null);

        }


    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    public void setPointsLeft(int pointsLeft) {
        this.pointsLeft = pointsLeft;
    }

}
