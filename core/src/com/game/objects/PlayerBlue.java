package com.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerBlue {
    private Sprite sprite;
    private float x, y;
    private float velocityX, velocityY;
    private float gravity;

    public PlayerBlue(float x, float y) {
        // Carregar a imagem do jogador diretamente aqui
        Texture texture = new Texture(Gdx.files.internal("player.png"));
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
        this.x = x;
        this.y = y;
        this.velocityX = 0;
        this.velocityY = 0;
        this.gravity = -0.5f; // ajuste conforme necessário
    }

    public void update() {
        // Aplicar gravidade
        velocityY += gravity;

        // Atualizar posição do jogador
        x += velocityX;
        y += velocityY;

        // Atualizar posição do sprite
        sprite.setPosition(x, y);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocity(float velocityX, float velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }


}
