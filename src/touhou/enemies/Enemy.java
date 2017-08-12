package touhou.enemies;

import bases.FrameCounter;
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
    private boolean bulletLock;
    private FrameCounter coolDownCounter;

    public Enemy() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
        bulletLock = false;
        coolDownCounter = new FrameCounter(80);
    }

    // Controller
    public void run() {
        super.run();
        fly();
        shoot();
    }

    private void shoot() {
        if (!bulletLock) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.getPosition().set(this.position.add(0, 30));
            GameObject.add(enemyBullet);
            bulletLock = true;
            coolDownCounter.reset();
        }
        unlockBullet();
    }

    private void unlockBullet() {
        if (bulletLock){
            if (coolDownCounter.run()){
                bulletLock = false;
            }
        }
    }


    private void fly() {
        position.addUp(0, SPEED);
    }
}
