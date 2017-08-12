package bases;

import bases.renderers.ImageRenderer;
import touhou.players.PlayerSpell;

import java.awt.*;
import java.util.Vector;

/**
 * Created by huynq on 8/9/17.
 */
public class GameObject {
    protected Vector2D position;
    protected ImageRenderer renderer;

    private static Vector<GameObject> gameObjects = new Vector<>();
    private static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll() {
        // instanceof
        for (GameObject gameObject : gameObjects) {
            gameObject.run();
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics2D g2d) {
        for (GameObject gameObject : gameObjects) {
            gameObject.render(g2d);
        }
    }

    public static void add(GameObject gameObject) {
        newGameObjects.add(gameObject);
    }

    public GameObject() {
        position = new Vector2D();
    }

    public void run() {

    }

    public void render(Graphics2D g2d) {
        if (renderer != null) {
            renderer.render(g2d, position); // null.render() => NullPointerException
        }
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        if (position != null)
            this.position = position;
    }

    public ImageRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(ImageRenderer renderer) {
        if (renderer != null)
            this.renderer = renderer;
    }
}
