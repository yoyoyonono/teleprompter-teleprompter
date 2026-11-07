package appcode.ui;

import com.rsc_games.velocity.sprite.ImageSprite;
import com.rsc_games.velocity.util.Transform;

public class CenterPoint extends ImageSprite {
    public CenterPoint(Transform transform) {
        super(transform, "Center Point", "./res/center.png");
        this.transform.setZOrder(5000);
    }
}
