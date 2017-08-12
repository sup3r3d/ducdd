package touhou.enemies;

import bases.GameObject;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject{
    private static final int BULLETSPEED = 5;
    public EnemyBullet() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
    }

    public void run() {
        position.addUp(0, BULLETSPEED);
    }
}
