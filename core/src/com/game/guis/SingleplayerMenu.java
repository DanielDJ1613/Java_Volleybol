package com.game.guis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class SingleplayerMenu extends ScreenAdapter {
    private static final float BUTTON_WIDTH = 200f;
    private static final float BUTTON_HEIGHT = 50f;

    private SpriteBatch batch;
    private Texture vsBotButtonTexture;
    private Texture oneVsOneButtonTexture;
    private Rectangle vsBotButtonBounds;
    private Rectangle oneVsOneButtonBounds;
    private OrthographicCamera camera;

    public SingleplayerMenu() {
        batch = new SpriteBatch();
        vsBotButtonTexture = new Texture("vsbot_button.png");
        oneVsOneButtonTexture = new Texture("1vs1_button.png");

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);

        // Posicionamento dos botões no centro da tela
        float buttonX = screenWidth / 2 - BUTTON_WIDTH / 2;
        float vsBotButtonY = screenHeight / 2 + 50;
        float oneVsOneButtonY = screenHeight / 2 - 50 - BUTTON_HEIGHT;

        vsBotButtonBounds = new Rectangle(buttonX, vsBotButtonY, BUTTON_WIDTH, BUTTON_HEIGHT);
        oneVsOneButtonBounds = new Rectangle(buttonX, oneVsOneButtonY, BUTTON_WIDTH, BUTTON_HEIGHT);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(vsBotButtonTexture, vsBotButtonBounds.x, vsBotButtonBounds.y, BUTTON_WIDTH, BUTTON_HEIGHT);
        batch.draw(oneVsOneButtonTexture, oneVsOneButtonBounds.x, oneVsOneButtonBounds.y, BUTTON_WIDTH, BUTTON_HEIGHT);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        vsBotButtonTexture.dispose();
        oneVsOneButtonTexture.dispose();
    }


    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 touchPos = new Vector3(screenX, screenY, 0);
        camera.unproject(touchPos);

        if (vsBotButtonBounds.contains(touchPos.x, touchPos.y)) {
            // Ação ao clicar no botão Vs Bot
            System.out.println("Botão Vs Bot pressionado!");
            return true;
        } else if (oneVsOneButtonBounds.contains(touchPos.x, touchPos.y)) {
            // Ação ao clicar no botão 1 Vs 1
            System.out.println("Botão 1 Vs 1 pressionado!");
            return true;
        }

        return false;
    }
}
