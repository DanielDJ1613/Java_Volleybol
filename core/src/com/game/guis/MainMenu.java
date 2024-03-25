package com.game.guis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.game.settings.ButtonInterative;

public class MainMenu extends ScreenAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private ButtonInterative buttonInterative;

    public MainMenu() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        // Desenhe aqui os elementos do menu, como texturas, etc.
        batch.end();

        // Adicione aqui a lógica de interação do menu, se necessário
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
