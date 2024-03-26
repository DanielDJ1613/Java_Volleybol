package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.objects.BolaVolei;
import com.game.objects.PlayerBlue;
import com.game.objects.PlayerRed;
import com.game.rules.GameLimits;
import com.game.settings.Movement;

public class GameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private PlayerBlue playerBlue;
    private PlayerRed playerRed;
    private  BolaVolei ball;
    private GameLimits gameLimits;
    private Movement movement;
    private int fieldWidth;
    private int fieldHeight;

    public GameScreen() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Defina a largura e altura do campo
        fieldWidth = 1000; // Defina o valor desejado para a largura do campo
        fieldHeight = 800; // Defina o valor desejado para a altura do campo

        // Posicione os jogadores como desejar
        playerBlue = new PlayerBlue(100, 100);
        playerRed = new PlayerRed(500, 100);
        ball = new BolaVolei(500, 400);

        // Inicialize as regras de limites e movimento
        gameLimits = new GameLimits(fieldWidth, fieldHeight, playerBlue, playerRed);
        movement = new Movement(playerBlue, playerRed);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Verifique a entrada de movimento dos jogadores
        movement.handleInput();

        // Atualize a posição dos jogadores
        playerBlue.update();
        playerRed.update();
        ball.update();

        // Aplique limites do jogo
        gameLimits.checkBoundaries();

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Renderize os jogadores
        playerBlue.render(batch);
        playerRed.render(batch);
        ball.render(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        playerBlue.dispose();
        playerRed.dispose();
    }
}
