package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.objects.PlayerBlue;
import com.game.objects.PlayerRed;
import com.game.rules.GameLimits;

public class GameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private PlayerBlue playerBlue;
    private PlayerRed playerRed;
    private GameLimits gameLimits;

    public GameScreen() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Posicione os jogadores como desejar
        playerBlue = new PlayerBlue(100, 100);
        playerRed = new PlayerRed(500, 100);

        // Inicializa os limites do jogo
        gameLimits = new GameLimits(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), playerBlue, playerRed);
    }

    @Override
    public void render(float delta) {
        // Verifica os limites do jogo antes de renderizar
        gameLimits.checkBoundaries();

        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Renderize os jogadores
        playerBlue.render(batch);
        playerRed.render(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        playerBlue.dispose();
        playerRed.dispose();
    }
}
