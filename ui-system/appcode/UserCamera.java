package appcode;

import java.awt.event.MouseEvent;

import com.rsc_games.velocity.InputSystem;
import com.rsc_games.velocity.sprite.camera.Base2DCamera;
import com.rsc_games.velocity.util.Transform;
import com.rsc_games.velocity.util.Vector2;

public class UserCamera extends Base2DCamera {
    int speed = -1;
    Vector2 lastFrameMousePos = Vector2.zero.clone();
    Vector2 tilemapCameraLoc = Vector2.zero.clone();
    Vector2 paletteCameraLoc = Vector2.zero.clone();

    public UserCamera(Transform transform) {
        super(transform.getPosition());
    }
    
    @Override
    public void onTick() {
        super.onTick();

        // Update mouse relative.
        Vector2 mouseCoords = InputSystem.getMousePos();
        Vector2 relative = mouseCoords.sub(lastFrameMousePos);

        // Allow camera panning if the middle mouse button is pressed.
        if (InputSystem.clicked(MouseEvent.BUTTON2)) {
            Vector2 moveCameraVec = relative;
            this.transform.translate(moveCameraVec.mult(speed));
        }

        lastFrameMousePos = mouseCoords;
    }

    // Save camera state for tilemap editor mode.
    public void enterPaletteMode() {
        tilemapCameraLoc = this.transform.getPosition();
        this.transform.setPosition(paletteCameraLoc);
    }

    // Save camera state for palette mode.
    public void enterTilemapMode() {
        paletteCameraLoc = this.transform.getPosition();
        this.transform.setPosition(tilemapCameraLoc);
    }
}
