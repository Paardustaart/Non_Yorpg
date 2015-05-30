package nl.max.non_yorpg;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Test";
		cfg.width = 800;
		cfg.height = 600;
		new LwjglApplication(new Game(), cfg);
	}
	
}
