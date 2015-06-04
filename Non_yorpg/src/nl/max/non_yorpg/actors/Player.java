package nl.max.non_yorpg.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class Player extends Actor {

	private Texture texture;
	private MoveByAction left, right, up, down;

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
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && getActions().size == 0) {
			addAction(right);
			right.restart();
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && getActions().size == 0) {
			addAction(left);
			left.restart();
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.UP) && getActions().size == 0) {
			addAction(up);
			up.restart();
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && getActions().size == 0) {
			addAction(down);
			down.restart();
		}
	}

}
