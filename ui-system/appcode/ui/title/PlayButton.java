package appcode.ui.title;

import com.rsc_games.velocity.Scene;
import com.rsc_games.velocity.audio.AudioClip;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIButton;
import com.rsc_games.velocity.util.Transform;

public class PlayButton extends UIButton {
    AudioClip select;
    AudioClip hover;

    public PlayButton(AnchorPoint anchor, Transform transform, String image, String hoverImage, AudioClip select, AudioClip hover) {
        super(anchor, transform, "play btn", image, hoverImage);
        this.transform.setZOrder(10);
        this.select = select;
        this.hover = hover;
    }

    // TODO: implement
    @Override
    public void clicked() {
        this.select.play();
        Scene.scheduleSceneLoad("PlayerGameScene");
    }

    @Override
    public void onHover() {
        this.hover.play();
    }

    @Override
    public void onMouseLeave() {

    }
    
}
