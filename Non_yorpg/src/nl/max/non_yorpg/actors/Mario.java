package nl.max.non_yorpg.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Mario extends Actor {
	
    private Texture tex;
    
    private int speed = 2;
    
    private int x, y = 0;
    

    public Mario () {
        tex = new Texture(Gdx.files.internal("assets/img/sprite.bmp"));
        
        setWidth(32);
        setHeight(32);
        
        setBounds(0, 0, getWidth(), getHeight());
    }
    
    @Override
    public void act(float delta) {
    	handleInput();
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
    	batch.draw(tex, x, y);
    }
    
    private void handleInput() {
    	if(Gdx.input.isKeyPressed(Input.Keys.W)) {
    		y += speed;
    	} else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
    		y -= speed;
    	} else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
    		x -= speed;
    	} else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
    		x += speed;
    	}
    }
	
}
