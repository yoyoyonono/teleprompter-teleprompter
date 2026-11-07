package appcode.scenes;

import appcode.*;
import com.rsc_games.velocity.util.*;
import com.rsc_games.velocity.*;
import com.rsc_games.velocity.sprite.Camera;

public class ForkScene extends Scene {
    /**
     * Scene description:
     * 
     * This scene allows using the same binary for two separate tasks depending on
     * command line arguments (java thank you for making this tricky).
     * 
     * The first usage is the player facing window (which can receive user input) and
     * is the brain of the entire game.
     * The secondary usage is the audience facing window (which shows the player's face
     * along with some of the game information shown to the player).
     * 
     * @param name
     * @param uuid
     */
    public ForkScene(String name, int uuid) {
        super(name, uuid);
        sprites.clear();

        /* Add sprites here that need to be added in multiple areas.
         * Keep in mind that these sprites will still need to be added to the scene list.
         */
        /* End of reusable sprite section. */

        /* Add sprites here (in sort order from 0 - array.length) */
        sprites.add(new Dispatcher());
        /* Stop adding sprites here. */

        /* Baked collision data here (written in by hand by developer) */
        /* End baked collision data. */

        /* UI Panel here */
        /* End UI Panel */

        // Camera required for rendering. DO NOT FORGET!
        sprites.add(new Camera(Vector2.zero));
    }
}
