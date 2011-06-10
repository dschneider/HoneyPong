package pong.entities;

import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.light.AmbientLight;

/**
 *
 * @author dennisschneider
 */
public class World {
    
    public World(Node rootNode) {
        
        /** A white ambient light source. */ 
        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White);
        rootNode.addLight(ambient); 
        
    }
    
}
