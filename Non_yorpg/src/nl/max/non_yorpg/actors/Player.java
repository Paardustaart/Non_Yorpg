package nl.max.non_yorpg.actors;

import java.io.IOException;

import nl.max.non_yorpg.network.GameClient;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class Player extends Actor {

	public enum Direction { UP, DOWN, LEFT, RIGHT }
	
	private Texture texture;
	private MoveByAction left, right, up, down;
	private GameClient client;

	public Player() {
		left = new MoveByAction();
		left.setDuration(0.5f);
		left.setAmount(-32f, 0f);
		
		right = new MoveByAction();
		right.setDuration(0.5f);
		right.setAmount(32f, 0f);
		
		up = new MoveByAction();
		up.setDuration(0.5f);
		up.setAmount(0f, 32f);
		
		down = new MoveByAction();
		down.setDuration(0.5f);
		down.setAmount(0f, -32f);
		
		texture = new Texture(Gdx.files.internal("assets/img/sprite.bmp"));

		setWidth(32);
		setHeight(32);

		setBounds(0, 0, getWidth(), getHeight());
		
		try {
			client = new GameClient("localhost", 7777, 7778, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void act(float delta) {
		handleInput();
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(texture, getX(), getY());
	}

	private void handleInput() {
		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && getActions().size == 0) {
			client.sendMoveRequest((int) this.getX(), (int) this.getY(), Direction.LEFT);
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && getActions().size == 0) {
			client.sendMoveRequest((int) this.getX(), (int) this.getY(), Direction.RIGHT);
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.UP) && getActions().size == 0) {
			client.sendMoveRequest((int) this.getX(), (int) this.getY(), Direction.UP);
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && getActions().size == 0) {
			client.sendMoveRequest((int) this.getX(), (int) this.getY(), Direction.DOWN);
		}
	}
	
	public void move(Direction direction) {
		
		if(direction == Direction.LEFT) {
			addAction(left);
			left.restart();
		}
		
		else if(direction == Direction.RIGHT) {
			addAction(right);
			right.restart();
		}
		
		else if(direction == Direction.UP) {
			addAction(up);
			up.restart();
		}
		
		else if(direction == Direction.DOWN) {
			addAction(down);
			down.restart();
		}
	}

}
