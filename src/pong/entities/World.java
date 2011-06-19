package pong.entities;

import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.light.AmbientLight;
import com.jme3.scene.shape.Box;
import com.jme3.math.Vector3f;
import com.jme3.bounding.BoundingBox;
import com.jme3.scene.Geometry;
import com.jme3.material.Material;
import com.jme3.asset.AssetManager;

/**
 *
 * @author dennisschneider
 */
public class World {
    
    Geometry topWall;
    Geometry bottomWall;
    Geometry leftWall;
    Geometry rightWall;
    Geometry middleLine;
    
    public World(Node rootNode, AssetManager assetManager) {
        
        /** A white ambient light source. */ 
        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White);
        rootNode.addLight(ambient);
        
        Box topWallBox = new Box(new Vector3f(), 100f, 1f, 1f);
        
        topWall = new Geometry("Ball", topWallBox);
        topWall.setModelBound(new BoundingBox());
        topWall.updateModelBound();        
        topWall.getLocalTranslation().set(0, 16, 0);
        
        Material topMat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        topMat.setColor("m_Color", ColorRGBA.Blue);
        topWall.setMaterial(topMat);
        
        rootNode.attachChild(topWall);
        
        Box bottomWallBox = new Box(new Vector3f(), 100f, 1f, 1f);
        
        bottomWall = new Geometry("Ball", bottomWallBox);
        bottomWall.setModelBound(new BoundingBox());
        bottomWall.updateModelBound();        
        bottomWall.getLocalTranslation().set(0, -16, 0);
        
        Material bottomMat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        bottomMat.setColor("m_Color", ColorRGBA.Blue);
        bottomWall.setMaterial(bottomMat);        
        
        rootNode.attachChild(bottomWall);
        
        Box rightWallBox = new Box(new Vector3f(), 2f, 100f, 1f);
        
        rightWall = new Geometry("Ball", rightWallBox);
        rightWall.setModelBound(new BoundingBox());
        rightWall.updateModelBound();        
        rightWall.getLocalTranslation().set(25f, 0, 0);
        
        Material rightWallMat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        rightWallMat.setColor("m_Color", ColorRGBA.Blue);
        rightWall.setMaterial(rightWallMat);        
        
        rootNode.attachChild(rightWall);
        
        Box leftWallBox = new Box(new Vector3f(), 2f, 100f, 1f);
        
        leftWall = new Geometry("Ball", leftWallBox);
        leftWall.setModelBound(new BoundingBox());
        leftWall.updateModelBound();        
        leftWall.getLocalTranslation().set(-25f, 0, 0);
        
        Material leftWallMat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        leftWallMat.setColor("m_Color", ColorRGBA.Blue);
        leftWall.setMaterial(leftWallMat);        
        
        rootNode.attachChild(leftWall);        
        
        Box middleBox = new Box(new Vector3f(), 0.1f, 100f, 0.1f);
        
        middleLine = new Geometry("Ball", middleBox);
        middleLine.setModelBound(new BoundingBox());
        middleLine.updateModelBound();        
        middleLine.getLocalTranslation().set(0, 0, -1f);
        
        Material middleLineMat = new Material(assetManager, "Common/MatDefs/Misc/SolidColor.j3md");
        middleLineMat.setColor("m_Color", ColorRGBA.White);
        middleLine.setMaterial(middleLineMat);        
        
        rootNode.attachChild(middleLine);        
    }
    
    public Geometry getTopWall() {
        return topWall;
    }

    public Geometry getBottomWall() {
        return bottomWall;
    }
    
    public Geometry getLeftWall() {
        return leftWall;
    }
    
    public Geometry getRightWall() {
        return rightWall;
    }
}
