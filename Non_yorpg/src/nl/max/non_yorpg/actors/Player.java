package nl.max.non_yorpg.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class Player extends Actor {

	private Texture tex;
	private MoveByAction moving;

	public Player() {
		tex = new Texture(Gdx.files.internal("assets/img/sprite.bmp"));

		setWidth(32);
		setHeight(32);

		setBounds(0, 0, getWidth(), getHeight());
	}

	@Override
	public void act(float arg0) {
		handleInput();
		super.act(arg0);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(tex, getX(), getY());
	}

	private void handleInput() {
			moving = new MoveByAction();
			moving.setDuration(0.5f);

			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && getActions().size == 0) {

				moving.setAmount(32f, 0f);
				addAction(moving);

			}
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && getActions().size == 0) {

				moving.setAmount(-32f, 0f);
				addAction(moving);

			}

			if (Gdx.input.isKeyPressed(Input.Keys.UP) && getActions().size == 0) {

				moving.setAmount(0f, 32f);
				addAction(moving);

			}

			if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && getActions().size == 0) {

				moving.setAmount(0f, -32f);
				addAction(moving);

			}
	}

}
