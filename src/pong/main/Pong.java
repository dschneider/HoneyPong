package pong.main;

import com.jme3.renderer.RenderManager;
import com.jme3.audio.AudioNode;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;

import pong.entities.Player;
import pong.entities.Ball;
import pong.entities.World;
import pong.ui.PlayerInformation;

/**
 * @author dennisschneider
 */
public class Pong extends GameTemplate {

    Ball ball;
    
    Player player1;
    Player player2;
    
    PlayerInformation player1Information;
    PlayerInformation player2Information;
    
    World world;
    
    private AudioNode gameMusic;
    
    Float ballPosition = 0.0f;
    Float player1PositionUp = 0.0f;
    Float player2PositionUp = 0.0f;
    
    Float timer;
    
    public static void main(String[] args) {
        Pong app = new Pong();
        app.start();
    }

    public AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float value, float tpf) {
            if (name.equals("MoveUp_Player1")) {
                player1PositionUp = player1PositionUp + 0.3f;
            }
            else if (name.equals("MoveDown_Player1"))
            {
                player1PositionUp = player1PositionUp - 0.3f;
            }
            else if (name.equals("MoveUp_Player2")) {
                player2PositionUp = player2PositionUp + 0.3f;
            }
            else if (name.equals("MoveDown_Player2"))
            {
                player2PositionUp = player2PositionUp - 0.3f;
            }
        }
    };    
    
    @Override
    public void simpleInitApp() {
        player1 = new Player(rootNode, assetManager, "left");
        player2 = new Player(rootNode, assetManager, "right");
        
        player1Information = new PlayerInformation(guiNode, assetManager, "left");
        player2Information = new PlayerInformation(guiNode, assetManager, "right");
        
        ball = new Ball(rootNode, assetManager);
        ball.resetVelocity();

        cam.getLocation().set(0, 0, 40f);
        cam.update();
        
        world = new World(rootNode, assetManager);
        
        initAudio();
        initInput();
    }
    
    private void initInput() {
        inputManager.addMapping("MoveUp_Player1", new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("MoveDown_Player1", new KeyTrigger(KeyInput.KEY_DOWN));

        inputManager.addMapping("MoveUp_Player2", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("MoveDown_Player2", new KeyTrigger(KeyInput.KEY_S));        
        
        inputManager.addListener(analogListener, "MoveUp_Player1");        
        inputManager.addListener(analogListener, "MoveDown_Player1");
        
        inputManager.addListener(analogListener, "MoveUp_Player2");        
        inputManager.addListener(analogListener, "MoveDown_Player2");
    }
    
    private void initAudio() {
        gameMusic = new AudioNode(assetManager, "Sounds/Music/Music.ogg");
        gameMusic.setLooping(true);
        gameMusic.setPositional(true);
        //gameMusic.setLocalTranslation(Vector3f.ZERO.clone());
        gameMusic.setVolume(3);
        audioRenderer.playSource(gameMusic); // play continuously!
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        
        ball.move(ball.getVelocity().getX(), ball.getVelocity().getY(), ball.getVelocity().getZ());
        
        if (!(player1.collidesWith(world.getTopWall().getWorldBound()) || player1.collidesWith(world.getBottomWall().getWorldBound())))
        {
            player1.changePosition(player1.getCurrentPosition().x, player1PositionUp, 0);
        }
        
        if (!(player2.collidesWith(world.getTopWall().getWorldBound()) || player2.collidesWith(world.getBottomWall().getWorldBound())))
        {
            player2.changePosition(player2.getCurrentPosition().x, player2PositionUp, 0);
        }
        
        if ((ball.collidesWith(world.getTopWall().getWorldBound())) || (ball.collidesWith(world.getBottomWall().getWorldBound())))
        {
            ball.getVelocity().y *= -1f;
        }
        
        if ((ball.collidesWith(player1.getGeometry().getWorldBound())) || (ball.collidesWith(player2.getGeometry().getWorldBound())))
        {
            ball.getVelocity().x *= -1.5f;
        }
        
        if (ball.collidesWith(world.getLeftWall().getWorldBound()))
        {            
            ball.setPosition(new Vector3f(0f, 0f, 0f));
            ball.resetVelocity();
            player2Information.incrementScore();
        }

        if (ball.collidesWith(world.getRightWall().getWorldBound()))
        {
            ball.setPosition(new Vector3f(0f, 0f, 0f));
            ball.resetVelocity();
            player1Information.incrementScore();
        }        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}