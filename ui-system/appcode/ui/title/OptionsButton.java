package appcode.ui.title;

import com.rsc_games.velocity.audio.AudioClip;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIButton;
import com.rsc_games.velocity.util.GlobalRandom;
import com.rsc_games.velocity.util.Transform;

public class OptionsButton extends UIButton {
    AudioClip hover;

    public OptionsButton(AnchorPoint anchor, Transform transform, String image, String hoverImage, AudioClip hover) {
        super(anchor, transform, "options btn", image, hoverImage);
        this.transform.setZOrder(10);
        this.hover = hover;
    }

    // btw this doesnt do anything
    // what if we easter egged it

    public AudioClip selectRandomNoise() {
        String[] noises = {
            "cat-laugh-meme-1.wav",
            "chicken-on-tree-screaming.wav",
            "dry-fart.wav",
            "fahhh.wav",
            "sackbut.wav"
        };

        return new AudioClip("./resources/title/meme-audio/" + noises[GlobalRandom.randint(0, noises.length)]);
    }

    @Override
    public void clicked() {
        AudioClip noise = selectRandomNoise();
        noise.play();
    }

    @Override
    public void onHover() {
        this.hover.play();
    }

    @Override
    public void onMouseLeave() {
        
    }
    
}
