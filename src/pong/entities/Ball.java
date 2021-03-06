package pong.entities;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.Node;
import com.jme3.bounding.BoundingSphere;
import com.jme3.math.Vector3f;
import com.jme3.bounding.BoundingVolume;

import java.util.Random;

/**
 *
 * @author dennisschneider
 */
public class Ball {
    
    private Geometry ball;
    private Vector3f ballVelocity;
    
    public Ball(Node rootNode, AssetManager assetManager) {
        Sphere ballSphere = new Sphere(63, 50, 0.4f);
        
        ball = new Geometry("Ball", ballSphere);
        ball.setModelBound(new BoundingSphere());
        ball.updateModelBound();
        
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        mat.setColor("m_Color", ColorRGBA.Blue);
        ball.setMaterial(mat);
        
        rootNode.attachChild(ball);        
    }
    
    public Vector3f getLocalTranslation() {
        return ball.getLocalTranslation();
    }
    
    public void move(float x, float y, float z) {
        ball.move(x, y, z);
    }
    
    public boolean collidesWith(BoundingVolume bv) {
        return ball.getWorldBound().intersects(bv);
    }
    
    public void setPosition(Vector3f position) {
        ball.setLocalTranslation(position);
    }
    
    public Vector3f getVelocity() {
        return ballVelocity;
    }
    
    public void setVelocity(Vector3f velocity) {
        ballVelocity = velocity;
    }
    
    public void resetVelocity() {
        Random r = new Random();
        float x = r.nextFloat();
        float y = r.nextFloat();
        float k = r.nextFloat();
 
        if (k > 0.5)
        {
            x *= -1;
            y *= -1;
        }
        
        x = 0.1f;

        setVelocity(new Vector3f(x, y, 0));
    }
}
