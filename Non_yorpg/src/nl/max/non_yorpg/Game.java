package nl.max.non_yorpg;

import nl.max.non_yorpg.actors.Player;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Game implements ApplicationListener {

	private Stage stage;
	
	private Skin skin;
	
	@Override
	public void create() {
		
		skin = new Skin(Gdx.files.internal("assets/uiskin.json"));
		
		final TextButton button = new TextButton("Lekker spelen!", skin, "default");
		
		button.setWidth(200f);
        button.setHeight(20f);
        button.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 10f);

		stage = new Stage(new ScreenViewport());
		Player actor = new Player();
		actor.setVisible(false);
		stage.addActor(actor);
		stage.setKeyboardFocus(actor);
		stage.addActor(button);
		Gdx.input.setInputProcessor(stage);
		
        button.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
                button.setVisible(false);
                actor.setVisible(true);
            }
        });
	}

	@Override
	public void dispose() {
		stage.dispose();
	}


	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    stage.act();
	    stage.draw();
	}
	
	@Override
	public void pause() {
		
	}

	@Override
	public void resize(int w, int h) {
		
	}

	@Override
	public void resume() {
		
	}

}
