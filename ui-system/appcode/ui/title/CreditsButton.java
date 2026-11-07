package appcode.ui.title;

import com.rsc_games.velocity.Scene;
import com.rsc_games.velocity.audio.AudioClip;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIButton;
import com.rsc_games.velocity.util.Transform;
import com.rsc_games.velocity.util.Vector2;

public class CreditsButton extends UIButton {
    AudioClip select;
    AudioClip hover;
    boolean creditsShown;

    public CreditsButton(AnchorPoint anchor, Transform transform, String image, String hoverImage, AudioClip select, AudioClip hover) {
        super(anchor, transform, "credits btn", image, hoverImage);
        this.transform.setZOrder(10);
        this.select = select;
        this.hover = hover;
    }

    // TODO: implement
    @Override
    public void clicked() {
        this.select.play();

        if (creditsShown)
            return;

        Scene.currentScene.addSprite(new StaticText(AnchorPoint.LOWER_RIGHT, new Transform(new Vector2(-225, -210)), "Presented by:"));
        Scene.currentScene.addSprite(new StaticText(AnchorPoint.LOWER_RIGHT, new Transform(new Vector2(-200, -160)), "aaabbbccc"));
        Scene.currentScene.addSprite(new StaticText(AnchorPoint.LOWER_RIGHT, new Transform(new Vector2(-200 , -110)), "dddeeefff"));

        Scene.currentScene.addSprite(new StaticText(AnchorPoint.LOWER_RIGHT, new Transform(new Vector2(-310, -60)), "App Version 1.0.0"));
        Scene.currentScene.addSprite(new StaticText(AnchorPoint.LOWER_RIGHT, new Transform(new Vector2(-590, -10)), "Available under the Driver's License"));

        creditsShown = true;
    }

    @Override
    public void onHover() {
        this.hover.play();
    }

    @Override
    public void onMouseLeave() {
        
    }
    
}
