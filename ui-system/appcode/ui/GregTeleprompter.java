package appcode.ui;

import com.rsc_games.velocity.Scene;
import com.rsc_games.velocity.audio.AudioClip;
import com.rsc_games.velocity.lighting.SunLight;
import com.rsc_games.velocity.sprite.LitSprite;
import com.rsc_games.velocity.util.Timer;
import com.rsc_games.velocity.util.Transform;
import com.rsc_games.velocity.util.Vector2;

public class GregTeleprompter extends LitSprite {
    AudioClip teleprompter;
    AudioClip vineBoom;
    SunLight light;
    Timer fadeWaitTimer;
    Timer sceneSwitchTimer;

    float fadePerFrame = 0.075f;
    float intensity = 0;
    boolean vineBoomFlag = false;

    public GregTeleprompter() {
        super(new Transform(Vector2.zero, 0, Vector2.one.clone().mult(1.45f), -100), "greg", "./resources/intro/big_greg_fullbright.png");
        teleprompter = new AudioClip("./resources/intro/teleprompter.wav", false);
        vineBoom = new AudioClip("./resources/intro/vine-boom.wav", false, 1.5f);
        light = new SunLight(0);
        fadeWaitTimer = new Timer(4250, false);
    }

    @Override 
    protected void onInit() {
        teleprompter.play();
    }

    @Override 
    protected void onTick() {
        if (!fadeWaitTimer.tick())
            return;

        intensity += fadePerFrame;
        light.setIntensity(intensity);

        if (!vineBoomFlag) {
            if (intensity > 0.45f) {
                vineBoomFlag = true;
                sceneSwitchTimer = new Timer(1000, false);
                vineBoom.play();
            }
        }
        else {
            if (!sceneSwitchTimer.tick())
                return;

            Scene.scheduleSceneLoad("PlayerUITitleScene");
        }
    }
}
