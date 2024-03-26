package com.game.objects;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerBlue {
    private Texture texture;
    private Sprite sprite;
    private float x, y;
    private float velocityX, velocityY, initialY;
    private float gravity;

    public PlayerBlue(float x, float y) {
        // Carregar a imagem do jogador diretamente aqui
        this.texture = new Texture("player.png"); // Inicializar a variável de instância
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
        this.x = x;
        this.y = y;
        this.velocityX = 0;
        this.velocityY = 0;
        this.gravity = -0.5f; // ajuste conforme necessário
        this.initialY = y;
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

    public float getInitialY() {return initialY;}
    public void setY(float y) {
        this.y = y;
        sprite.setY(y);
    }
    public void setX(float x) {
        this.x = x;
        sprite.setX(x);
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
    public void render(SpriteBatch batch) {
        if (texture != null) {
            batch.draw(texture, x, y);
        }
        else {
            System.out.println("Textura não carregada - Player Blue");
        }
    }


    public void dispose() {
        texture.dispose();
    }

}
