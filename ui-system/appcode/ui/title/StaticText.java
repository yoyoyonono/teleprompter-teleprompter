package appcode.ui.title;

import java.awt.Color;

import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIText;
import com.rsc_games.velocity.util.Transform;

public class StaticText extends UIText {

    public StaticText(AnchorPoint anchor, Transform transform, String text) {
        super(anchor, transform, "text", "serif", Color.white);
        this.setSize(40);
        this.text = text;
    }
    
}
