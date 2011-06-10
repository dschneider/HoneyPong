package pong.entities;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.Node;

/**
 *
 * @author dennisschneider
 */
public class Ball {
    
    private Geometry geometry;
    
    public Ball(Node rootNode, AssetManager assetManager) {
        Sphere ballSphere = new Sphere(63, 50, 0.2f);
        
        geometry = new Geometry("Ball", ballSphere);
        geometry.updateModelBound();

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        mat.setColor("m_Color", ColorRGBA.Green);
        geometry.setMaterial(mat);

        rootNode.attachChild(geometry);        
    }
    
    public void changePosition(float x, float y, float z) {
        geometry.setLocalTranslation(x, y, z);
    }
    
    public Geometry getGeometry() {
        return geometry;
    }
}
