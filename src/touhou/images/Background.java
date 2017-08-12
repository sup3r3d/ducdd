package touhou.images;

import bases.GameObject;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

public class Background extends GameObject {
    private static final int BGSPEED = 1;

    public Background() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/background/0.png"));
    }

    public void run() {
        super.run();
        move();
    }

    private void move() {
        position.addUp(0, BGSPEED);
        if (position.y > 2341-810)
            position.y = 2341-810;
    }
}
