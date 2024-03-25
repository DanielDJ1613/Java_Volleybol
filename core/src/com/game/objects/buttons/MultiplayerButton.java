package com.game.objects.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class MultiplayerButton {
    private Texture texture;
    private Rectangle bounds;

    public MultiplayerButton(float x, float y) {
        texture = new Texture("multiplayer-button.png");
        bounds = new Rectangle(x, y, 200, 50); // Define a posição e o tamanho do botão
    }

    public Texture getTexture() {
        return texture;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
