package pong.entities;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.Node;

/**
 *
 * @author dennisschneider
 */
public class Player {
    
    private Geometry geometry;
    
    public Player(Node rootNode, AssetManager assetManager, String position) {
        Box playerBox = new Box(Vector3f.ZERO, 0.3f, 1.5f, 1);
        
        geometry = new Geometry("Box", playerBox);
        geometry.updateModelBound();

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        mat.setColor("m_Color", ColorRGBA.Blue);
        geometry.setMaterial(mat);

        if (position == "left") 
        {
            geometry.setLocalTranslation(-4.5f, 0, 0);
        }
        else
        {
            geometry.setLocalTranslation(4.5f, 0, 0);
        }
        
        rootNode.attachChild(geometry);
    }
    
    public void changePosition(float x, float y, float z) {
        geometry.setLocalTranslation(x, y, z);
    }    
    
    public Geometry getGeometry() {
        return geometry;
    }
    
    public Vector3f getCurrentPosition() {
        return geometry.getLocalTranslation();
    }
}
