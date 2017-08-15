package touhou.enemies;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;
import touhou.players.Player;

public class EnemyBullet extends GameObject implements PhysicsBody {
    private static final int BULLETSPEED = 5;
    private BoxCollider hitbox;

    public EnemyBullet() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
        hitbox = new BoxCollider(20,20);
        this.children.add(hitbox);
    }


    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        position.addUp(0, BULLETSPEED);
        hitPlayer();
    }

    private void hitPlayer() {
        Player player = Physics.collideWithPlayer(this.hitbox);
        if (player != null) {
            this.isActive = false;
            player.setActive(false);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.hitbox;
    }
}
