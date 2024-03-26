package com.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BolaVolei {
    private Sprite sprite;
    private Texture texture;
    private float x, y;
    private float velocityX, velocityY;
    private float gravity;

    public BolaVolei(float x, float y) {
        // Carregar a imagem da bola de vôlei diretamente aqui
        this.texture = new Texture("bola_volei.png"); // Inicializar a variável de instância
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
        this.x = x;
        this.y = y;
        this.velocityX = 0;
        this.velocityY = 0;
        this.gravity = -0.5f; // Ajuste conforme necessário
    }

    public void update() {
        // Aplicar gravidade
        velocityY += gravity;

        // Atualizar posição da bola de vôlei
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

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setX(float x) {
        this.x = x;
        sprite.setX(x);
    }

    public void setY(float y) {
        this.y = y;
        sprite.setY(y);
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocity(float velocityX, float velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void dispose() {
        texture.dispose();
    }
}
