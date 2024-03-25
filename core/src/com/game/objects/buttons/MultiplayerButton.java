package com.game.objects.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class MultiplayerButton {
    private static final int DEFAULT_X = 600;
    private static final int DEFAULT_Y = 500;
    private static final String DEFAULT_TEXTURE_PATH = "multiplayer-button.png";

    private Texture texture;
    private Rectangle bounds;

    public MultiplayerButton() {
        texture = new Texture(DEFAULT_TEXTURE_PATH);
        bounds = new Rectangle(DEFAULT_X, DEFAULT_Y, 200, 50); // Define a posição e o tamanho do botão
    }

    public Texture getTexture() {
        return texture;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
