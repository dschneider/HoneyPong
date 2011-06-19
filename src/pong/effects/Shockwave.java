package pong.effects;

import com.jme3.app.SimpleApplication;
import com.jme3.effect.EmitterSphereShape;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh.Type;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.asset.AssetManager;

/**
 *
 * @author dennisschneider
 */
public class Shockwave {
    
    private Node explosionEffect = new Node("shockwaveFX");
    private ParticleEmitter shockWave;
    
    private static final int COUNT_FACTOR = 1;
    private static final float COUNT_FACTOR_F = 1f;
    
    public Shockwave(Node rootNode, AssetManager assetManager) {
        shockWave = new ParticleEmitter("Shockwave", Type.Triangle, 1 * COUNT_FACTOR);

        shockWave.setFaceNormal(Vector3f.UNIT_Z);
        shockWave.setStartColor(new ColorRGBA(.48f, 0.17f, 0.01f, (float) (.8f / COUNT_FACTOR_F)));
        shockWave.setEndColor(new ColorRGBA(.48f, 0.17f, 0.01f, 0f));

        shockWave.setStartSize(0f);
        shockWave.setEndSize(4f);

        shockWave.setParticlesPerSec(0);
        shockWave.setGravity(0);
        shockWave.setLowLife(0.5f);
        shockWave.setHighLife(0.5f);
        shockWave.setInitialVelocity(new Vector3f(0, 0, 0));
        shockWave.setVelocityVariation(0f);
        shockWave.setImagesX(1);
        shockWave.setImagesY(1);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Particle.j3md");
        mat.setTexture("m_Texture", assetManager.loadTexture("Textures/Effects/shockwave.png"));
        shockWave.setMaterial(mat);
        
        rootNode.attachChild(shockWave);
    }
    
    public void explode(float x, float y, float z) {
        shockWave.killAllParticles();
        shockWave.setLocalTranslation(x, y, z);
        shockWave.emitAllParticles();
    }
    
}
