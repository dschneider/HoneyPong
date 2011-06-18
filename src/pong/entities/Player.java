package pong.entities;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.Node;
import com.jme3.bounding.BoundingVolume;

/**
 *
 * @author dennisschneider
 */
public class Player {
    
    private Geometry player;
    
    public Player(Node rootNode, AssetManager assetManager, String position) {
        Box playerBox = new Box(Vector3f.ZERO, 0.3f, 1.5f, 0.5f);
        
        player = new Geometry("Box", playerBox);
        player.updateModelBound();

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        mat.setColor("m_Color", ColorRGBA.Blue);
        player.setMaterial(mat);

        if (position == "left") 
        {
            player.setLocalTranslation(-20.5f, 0, 0);
        }
        else
        {
            player.setLocalTranslation(20.5f, 0, 0);
        }
        
        rootNode.attachChild(player);
    }
    
    public void changePosition(float x, float y, float z) {
        player.setLocalTranslation(x, y, z);
    }    
    
    public Geometry getGeometry() {
        return player;
    }
    
    public Vector3f getCurrentPosition() {
        return player.getLocalTranslation();
    }
    
    public boolean collidesWith(BoundingVolume bv) {
        return player.getWorldBound().intersects(bv);
    }    
}
