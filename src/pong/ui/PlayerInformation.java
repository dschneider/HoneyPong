package pong.ui;

import com.jme3.scene.Node;
import com.jme3.font.BitmapText;
import com.jme3.font.BitmapFont;
import com.jme3.asset.AssetManager;

/**
 *
 * @author dennisschneider
 */
public class PlayerInformation {
    
    BitmapFont guiFont;
    
    BitmapText playerText;
    int playerScore = 0;
    
    public PlayerInformation(Node guiNode, AssetManager assetManager, String position) {
        /** Write text on the screen (HUD) */
        //guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        
        playerText = new BitmapText(guiFont, false);
        playerText.setSize(guiFont.getCharSet().getRenderedSize());
        playerText.setText("Player Score: " + playerScore);
        
        if (position == "left")
        {
            playerText.setLocalTranslation(10, playerText.getLineHeight() + 10, 0);
        }
        else if (position == "right")
        {
            playerText.setLocalTranslation(675, playerText.getLineHeight() + 10, 0);
        }
        guiNode.attachChild(playerText);        
    }
    
    public void incrementScore() {
        playerScore++;
        playerText.setText("Player Score: " + playerScore);
    }
}
