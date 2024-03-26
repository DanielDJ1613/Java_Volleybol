package com.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class BolaVolei {
    private Sprite sprite;
    private Texture texture;
    private float x, y;
    private float velocityX, velocityY;
    private float gravity;

    public BolaVolei(float x, float y) {
        this.texture = new Texture("bola_volei.png");
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
        this.x = x;
        this.y = y;
        this.velocityX = 0;
        this.velocityY = 0;
        this.gravity = -0.5f;
    }

    public void update() {
        velocityY += gravity;
        x += velocityX;
        y += velocityY;
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

    // Método para obter os limites retangulares da bola
    public Rectangle getBounds() {
        return new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }

    // Método para obter o raio da bola
    public float getRadius() {
        return sprite.getWidth() / 2;
    }
}
