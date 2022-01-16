package dev.mygame.main.states;
import dev.mygame.main.Game;
import dev.mygame.main.Handler;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class State{


    private static State currentState = null;



    //class

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }


    public static void setState(State state) {
        currentState = state;
    }
    public static State getState() {
        return currentState;
    }

    public abstract void tick();



    public abstract void render(Graphics g);



}
