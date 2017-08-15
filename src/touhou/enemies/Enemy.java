package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import touhou.players.Player;

import java.awt.*;

/**
 * Created by huynq on 8/9/17.
 */
public class Enemy extends GameObject implements PhysicsBody {
    private static final float SPEED = 3;
    private boolean bulletLock;
    private FrameCounter coolDownCounter;
    private BoxCollider hitbox;

    public Enemy() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
        bulletLock = false;
        coolDownCounter = new FrameCounter(80);
        hitbox = new BoxCollider(20,20);
        this.children.add(hitbox);
    }

    // Controller
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        fly();
        shoot();
        hitPlayer();
    }

    private void hitPlayer() {
        Player player = Physics.collideWithPlayer(this.hitbox);
        if (player != null) {
            this.isActive = false;
            player.setActive(false);
        }
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

    @Override
    public BoxCollider getBoxCollider() {
        return this.hitbox;
    }
}
