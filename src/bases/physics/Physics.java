package bases.physics;

import touhou.enemies.Enemy;
import touhou.players.Player;

import java.util.Vector;

public class Physics {
    private static Vector<PhysicsBody> bodies = new Vector<>();

    public static Enemy collideWithEnemy(BoxCollider hitbox) {
        for (PhysicsBody body: bodies) {
            if (body.isActive()) {
                if (body instanceof Enemy && body.getBoxCollider().intersects(hitbox)) {
                    return (Enemy) body;
                }
            }
        }
        return null;
    }

    public static Player collideWithPlayer(BoxCollider hitbox) {
        for (PhysicsBody body: bodies) {
            if (body.isActive()) {
                if (body instanceof Player && body.getBoxCollider().intersects(hitbox)) {
                    return (Player) body;
                }
            }
        }
        return null;
    }

    public static void add(PhysicsBody body) {
        bodies.add(body);
    }
}
