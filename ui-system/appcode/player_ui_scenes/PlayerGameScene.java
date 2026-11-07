package appcode.player_ui_scenes;


import com.rsc_games.velocity.Scene;
import com.rsc_games.velocity.sprite.Camera;
import com.rsc_games.velocity.util.Vector2;

/**
 * Edit a random tile. Random tiles are a special kind of rule tile that place a random
 * tile id when selected. Based on the animator tile editor.
 */
public class PlayerGameScene extends Scene {
    public PlayerGameScene(String name, int uuid) {
        super(name, uuid);
        sprites.clear();

        /* Add sprites here that need to be added in multiple areas.
         * Keep in mind that these sprites will still need to be added to the scene list.
         */
        /* End of reusable sprite section. */

        /* Add sprites here (in sort order from 0 - array.length) */
        /* Stop adding sprites here. */

        /* Baked collision data here (written in by hand by developer) */
        /* End baked collision data. */

        /* UI Panel here */
        /* End UI Panel */

        // Camera required for rendering. DO NOT FORGET!
        sprites.add(new Camera(Vector2.zero));
    }
}
