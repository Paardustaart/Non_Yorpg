package nl.max.non_yorpg;

import java.io.IOException;

import nl.max.non_yorpg.actors.Player;
import nl.max.non_yorpg.network.GameServer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Game implements ApplicationListener {

	private Stage stage;
	private Skin skin;
	private Player actor;
	private GameServer server;
	
	@Override
	public void create() {
		
		try {
			server = new GameServer(7777, 7778);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		skin = new Skin(Gdx.files.internal("assets/uiskin.json"));

		stage = new Stage(new ScreenViewport());
		actor = new Player();
		
		stage.addActor(actor);
		stage.setKeyboardFocus(actor);
		
		Gdx.input.setInputProcessor(stage);
		
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
