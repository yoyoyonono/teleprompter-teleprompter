package appcode.ui.title;

import com.rsc_games.velocity.audio.AudioClip;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIButton;
import com.rsc_games.velocity.util.Transform;

public class QuitButton extends UIButton {
    AudioClip select;
    AudioClip hover;

    public QuitButton(AnchorPoint anchor, Transform transform, String image, String hoverImage, AudioClip select, AudioClip hover) {
        super(anchor, transform, "quit btn", image, hoverImage);
        this.transform.setZOrder(10);
        this.select = select;
        this.hover = hover;
    }

    @Override
    public void clicked() {
        // TODO: system.exit
        this.select.play();
    }

    @Override
    public void onHover() {
        this.hover.play();
    }

    @Override
    public void onMouseLeave() {
        
    }
    
}
