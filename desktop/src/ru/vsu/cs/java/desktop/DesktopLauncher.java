package ru.vsu.cs.java.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.vsu.cs.java.Strategy;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1366;
        config.height = 768;
        config.resizable = false;
        config.fullscreen = true;
		new LwjglApplication(new Strategy(), config);


	}
}
