package appcode.player_ui_scenes;

import appcode.ui.title.CreditsButton;
import appcode.ui.title.GregTitle;
import appcode.ui.title.OptionsButton;
import appcode.ui.title.PlayButton;
import appcode.ui.title.QuitButton;
import appcode.ui.title.TitleBanner;

import com.rsc_games.velocity.util.*;
import com.rsc_games.velocity.*;
import com.rsc_games.velocity.audio.AudioClip;
import com.rsc_games.velocity.sprite.Camera;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;

/**
 * Player UI Title scene. Brings the connection to the other code/parts of the game online
 * and then does title screen things.
 */
public class PlayerUITitleScene extends Scene {
    public PlayerUITitleScene(String name, int uuid) {
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
        sprites.add(new TitleBanner(AnchorPoint.TOP_MID));
        sprites.add(new GregTitle(AnchorPoint.CENTER, new Transform(Vector2.zero, 0, Vector2.one, -100), 
                    "bg", "./resources/title/big_greg.png"));

        AudioClip uiHover = new AudioClip("./resources/title/menu-hover.wav");
        AudioClip uiSelectStart = new AudioClip("./resources/title/menu-select.wav");
        AudioClip uiSelect = new AudioClip("./resources/title/menu-select-nonfinal.wav");

        sprites.add(new PlayButton(AnchorPoint.LOWER_LEFT, new Transform(new Vector2(215, -360)), 
                    "./resources/title/play_btn.png", "./resources/title/play_btn_hover.png", uiSelectStart, uiHover));
        sprites.add(new OptionsButton(AnchorPoint.LOWER_LEFT, new Transform(new Vector2(215, -260)), 
                    "./resources/title/options_btn.png", "./resources/title/options_btn_hover.png", uiHover));
        sprites.add(new CreditsButton(AnchorPoint.LOWER_LEFT, new Transform(new Vector2(215, -160)), 
                    "./resources/title/credits_btn.png", "./resources/title/credits_btn_hover.png", uiSelect, uiHover));
        sprites.add(new QuitButton(AnchorPoint.LOWER_LEFT, new Transform(new Vector2(215, -60)), 
                    "./resources/title/quit_btn.png", "./resources/title/quit_btn_hover.png", uiSelect, uiHover));

        // TODO: state transition manager for obtaining connections and then playing.
        /* End UI Panel */

        // Camera required for rendering. DO NOT FORGET!
        sprites.add(new Camera(Vector2.zero));
    }
}
