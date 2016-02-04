package com.zilabr.particlecollisionsimulation.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zilabr.particlecollisionsimulation.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Particle collision simulation";
		config.width = 1280;
		config.height = 720;
		config.samples = 4;
		new LwjglApplication(new Main(), config);
	}
}
