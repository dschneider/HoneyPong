package pong.main;

import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;

import pong.entities.Player;
import pong.entities.Ball;
import pong.entities.World;

/**
 * test
 * @author normenhansen
 */
public class Pong extends GameTemplate {

    Ball ball;
    Player player1;
    Player player2;
    Geometry playerGeometry;
    Geometry ballGeometry;
    Float ballPosition = 0.0f;
    Float player1PositionUp = 0.0f;
    Float player2PositionUp = 0.0f;
    
    public static void main(String[] args) {
        Pong app = new Pong();
        app.start();
    }

    public AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float value, float tpf) {
            if (name.equals("MoveUp_Player1")) {
                player1PositionUp = player1PositionUp + 0.1f;
            }
            else if (name.equals("MoveDown_Player1"))
            {
                player1PositionUp = player1PositionUp - 0.1f;
            }
            else if (name.equals("MoveUp_Player2")) {
                player2PositionUp = player2PositionUp + 0.1f;
            }
            else if (name.equals("MoveDown_Player2"))
            {
                player2PositionUp = player2PositionUp - 0.1f;
            }
        }
    };    
    
    @Override
    public void simpleInitApp() {
        player1 = new Player(rootNode, assetManager, "left");
        player2 = new Player(rootNode, assetManager, "right");
        
        ball = new Ball(rootNode, assetManager);
        
        World world = new World(rootNode);
        
        inputManager.addMapping("MoveUp_Player1", new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("MoveDown_Player1", new KeyTrigger(KeyInput.KEY_DOWN));

        inputManager.addMapping("MoveUp_Player2", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("MoveDown_Player2", new KeyTrigger(KeyInput.KEY_S));        
        
        inputManager.addListener(analogListener, "MoveUp_Player1");        
        inputManager.addListener(analogListener, "MoveDown_Player1");
        
        inputManager.addListener(analogListener, "MoveUp_Player2");        
        inputManager.addListener(analogListener, "MoveDown_Player2");        
    }

    @Override
    public void simpleUpdate(float tpf) {
        
        ballPosition = ballPosition - 0.001f;
        ball.changePosition(ballPosition, 0, 0); 
        
        player1.changePosition(player1.getCurrentPosition().x, player1PositionUp, 0);
        
        player2.changePosition(player2.getCurrentPosition().x, player2PositionUp, 0);
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}