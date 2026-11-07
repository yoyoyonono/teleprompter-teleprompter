package appcode.ui.title;

import java.awt.Color;

import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIText;
import com.rsc_games.velocity.util.Transform;
import com.rsc_games.velocity.util.Vector2;

public class TitleBanner extends UIText {
    public TitleBanner(AnchorPoint anchor) {
        super(anchor, new Transform(new Vector2(-515, 100)), "title", "Sans", Color.WHITE);
        this.setSize(85);
        this.text = "Teleprompter Teleprompter";
    }
    
}
