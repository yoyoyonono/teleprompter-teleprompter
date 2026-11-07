package appcode.ui.title;

import com.rsc_games.velocity.audio.MusicClip;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIImage;
import com.rsc_games.velocity.util.Transform;
import com.rsc_games.velocity.util.Vector2;

public class GregTitle extends UIImage {
    MusicClip song;
    int ticks = 0;

    // TODO: add better loop point support for music (for the new title track)
    public GregTitle(AnchorPoint anchor, Transform transform, String name, String imagename) {
        super(anchor, transform, name, imagename);
        song = new MusicClip("./resources/title/tele-menu-new-reduced.wav", true);
        this.transform.setZOrder(-10);
    }

    @Override 
    protected void onInit() {
        song.play();
    }

    float cyclicA(float t) {
        return (float)Math.sin(0.05f * t);
    }

    float cyclicB(float t) {
        return (float)Math.cos(0.03f * t);
    }

    @Override 
    protected void onTick() {
        ticks++;

        this.transform.setScale(new Vector2(cyclicA(ticks), cyclicB(ticks)));
    }
}