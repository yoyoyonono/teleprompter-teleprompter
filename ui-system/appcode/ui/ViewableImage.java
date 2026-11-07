package appcode.ui;

import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIImage;
import com.rsc_games.velocity.util.Transform;

public class ViewableImage extends UIImage {
    public ViewableImage(AnchorPoint anchor, Transform transform, String name, String imagename) {
        super(anchor, transform, name, imagename);
    }
}