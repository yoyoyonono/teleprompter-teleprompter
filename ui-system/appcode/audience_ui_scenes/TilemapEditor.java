package appcode.scenes;

import java.awt.Color;

import appcode.*;
import appcode.ui.CenterPoint;
import appcode.ui.TilemapControlsImage;
import appcode.ui.MemTracer;
import appcode.ui.PointerLoc;
import appcode.ui.SavedTracker;
import appcode.ui.TileInfoPrint;
import appcode.ui.TilemapCursor;
import appcode.ui.ViewableImage;

import com.rsc_games.velocity.util.*;
import com.rsc_games.velocity.*;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.FPSCounter;

/**
 * Encapsulates the main tilemap editor system.
 */
public class TilemapEditor extends Scene {
    public TilemapEditor(String name, int uuid) {
        super(name, uuid);
        sprites.clear();

        /* Add sprites here that need to be added in multiple areas.
         * Keep in mind that these sprites will still need to be added to the scene list.
         */
        /* End of reusable sprite section. */

        /* Add sprites here (in sort order from 0 - array.length) */
        sprites.add(new CenterPoint(new Transform()));
        sprites.add(new AreaLight(0.45f));
        /* Stop adding sprites here. */

        /* Baked collision data here (written in by hand by developer) */
        /* End baked collision data. */

        /* UI Panel here */
        sprites.add(new TilemapCreationManager());
        sprites.add(new TilemapCursor());
        sprites.add(new ViewableImage(AnchorPoint.LOWER_LEFT, new Transform(new Vector2(300, -120)), "SelectedTile", "./res/no_tile.png"));
        sprites.add(new ViewableImage(AnchorPoint.LOWER_LEFT, new Transform(new Vector2(155, -115)), "Controls", "./res/Controls.png"));
        sprites.add(new TilemapControlsImage(AnchorPoint.LOWER_RIGHT, new Transform(new Vector2(-155, -95)), "Controls2", "./res/Controls2.png", "./res/Controls2_edit.png"));
        sprites.add(new SavedTracker(AnchorPoint.TOP_RIGHT, new Transform(new Vector2(-75, 25))));
        sprites.add(new FPSCounter(AnchorPoint.TOP_LEFT, new Transform(new Vector2(3, 12)), "FPS", Color.green));
        sprites.add(new MemTracer(AnchorPoint.TOP_LEFT, new Transform(new Vector2(3, 26)), "MemTracker", Color.green));
        sprites.add(new PointerLoc(AnchorPoint.TOP_LEFT, new Transform(new Vector2(3, 42)), "Cursor Loc", Color.yellow));
        sprites.add(new TileInfoPrint(AnchorPoint.TOP_LEFT, new Transform(new Vector2(3, 58)), "Tile Info Printout", Color.white));
        //sprites.add(new TestUIElement(Point.zero, 0, "Thing", "./images/tutorial_knight.png"));
        /* End UI Panel */

        // Camera required for rendering. DO NOT FORGET!
        sprites.add(new UserCamera(new Transform()));
    }
}
