package appcode;

import com.rsc_games.velocity.Scene;
import com.rsc_games.velocity.sprite.Sprite;
import com.rsc_games.velocity.util.Transform;

/**
 * Dispatcher: Responsible for loading the 
 */
public class Dispatcher extends Sprite {
    public Dispatcher() {
        super(new Transform(), "Dispatcher");
    }
    
    @Override
    protected void onInit() {
        //Scene.scheduleSceneLoad("PlayerUITitleScene");
        //Scene.scheduleSceneLoad("AudienceUITitleScene");
    }
}
