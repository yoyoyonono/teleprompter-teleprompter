package appcode;

import com.rsc_games.velocity.util.Transform;
import com.rsc_games.velocity.lighting.SunLight;
import com.rsc_games.velocity.sprite.Sprite;

public class AreaLight extends Sprite {
    SunLight light;

    public AreaLight(float intensity) {
        super(new Transform(), "AreaLight");
        this.light = new SunLight(intensity);
    }

    public void setIntensity(float intensity) {
        this.light.setIntensity(intensity);
    } 
}
