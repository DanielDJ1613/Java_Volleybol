package com.game.guis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.game.MyGame;
import com.game.objects.buttons.SingleplayerButton;
import com.game.objects.buttons.MultiplayerButton;

public class MainMenu extends ScreenAdapter {
    private MyGame game;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private SingleplayerButton singleplayerButton;
    private MultiplayerButton multiplayerButton;

    public MainMenu() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Create buttons
        singleplayerButton = new SingleplayerButton();
        multiplayerButton = new MultiplayerButton();
    }

    public void setGame(MyGame game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        // Draw buttons
        batch.draw(singleplayerButton.getTexture(), singleplayerButton.getBounds().x, singleplayerButton.getBounds().y);
        batch.draw(multiplayerButton.getTexture(), multiplayerButton.getBounds().x, multiplayerButton.getBounds().y);

        batch.end();

        // Handle button clicks
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (singleplayerButton.getBounds().contains(touchPos.x, touchPos.y)) {
                game.changeScreen(MyGame.ScreenEnum.GAMESCREEN);
            } else if (multiplayerButton.getBounds().contains(touchPos.x, touchPos.y)) {
                // Add your logic for multiplayer button click here
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        // Não é necessário chamar dispose() nos botões
    }
}
