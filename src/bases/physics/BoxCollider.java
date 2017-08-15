package bases.physics;

import bases.GameObject;

public class BoxCollider extends GameObject {
    private float width;
    private float height;

    public BoxCollider(float x, float y, float width, float height) {
        super();
        this.position.set(x, y);
        this.width = width;
        this.height = height;
    }

    public BoxCollider(float width, float height) {
        this(0,0, width, height);
    }

    public boolean intersects(BoxCollider other) {
        return this.left() <= other.right() &&
                this.right() >= other.left() &&
                this.bottom() >= other.top() &&
                this.top() <= other.bottom();
    }

    private float top() {
        return this.screenPosition.y - this.height / 2;
    }

    private float bottom() {
        return this.screenPosition.y + this.height / 2;
    }

    private float right() {
        return this.screenPosition.x + this.width / 2;
    }

    private float left() {
        return this.screenPosition.x - this.width / 2;
    }
}
