package appcode.player_ui_scenes;

import appcode.ui.GregTeleprompter;
import appcode.ui.title.TitleBanner;

import com.rsc_games.velocity.util.*;
import com.rsc_games.velocity.*;
import com.rsc_games.velocity.sprite.Camera;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;

/**
 * Big Greg yo
 * 
 * // TODO: before this scene we need to do system testing (in a separate scene)
 */
public class GregScene extends Scene {
    public GregScene(String name, int uuid) {
        super(name, uuid);
        sprites.clear();

        /* Add sprites here that need to be added in multiple areas.
         * Keep in mind that these sprites will still need to be added to the scene list.
         */
        /* End of reusable sprite section. */

        /* Add sprites here (in sort order from 0 - array.length) */
        //sprites.add(new LitBGTile(Point.zero, 0f, "Background Tile", "./res/bgtile.png"));
        //sprites.add(new AreaLight(0.25f));
        /* Stop adding sprites here. */

        /* Baked collision data here (written in by hand by developer) */
        /* End baked collision data. */

        /* UI Panel here */
        sprites.add(new TitleBanner(AnchorPoint.CENTER));
        sprites.add(new GregTeleprompter());
        //sprites.add();

        // TODO: state transition manager for obtaining connections and then playing.
        /* End UI Panel */

        // Camera required for rendering. DO NOT FORGET!
        sprites.add(new Camera(Vector2.zero));
    }
}
