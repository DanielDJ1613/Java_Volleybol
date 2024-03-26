package com.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();


		config.setWindowedMode(1000, 800); // Largura x Altura

		config.setForegroundFPS(60);
		config.setTitle("Volei Game [Demo]");
		new Lwjgl3Application(new Initializer(), config);
	}
}
