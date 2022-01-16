package dev.mygame.main.gfx;

import java.awt.image.*;

public class Animation {

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] array;

    public Animation(int speed, BufferedImage[] array) {
        this.speed = speed;
        this.array = array;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void tick()
    {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer>speed) {
            index++;
            timer = 0;
            if(index == array.length) {
                index = 0;
            }
        }

    }
    public	BufferedImage getCurrentFrame() {
        return array[index];
    }
}
