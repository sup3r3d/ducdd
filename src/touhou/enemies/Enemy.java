package touhou.enemies;

import bases.GameObject;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;

import java.awt.*;

/**
 * Created by huynq on 8/9/17.
 */
public class Enemy extends GameObject {
    private static final float SPEED = 3;

    public Enemy() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
    }

    // Controller
    public void run() {
        super.run();
        fly();
        shoot();
    }

    private void shoot() {
        // TODO: create enemy bullet and shoot
    }

    private void fly() {
        position.addUp(0, SPEED);
    }
}
