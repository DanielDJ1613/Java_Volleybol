package com.game.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.game.objects.PlayerBlue;
import com.game.objects.PlayerRed;

public class Movement {
    private PlayerBlue playerBlue;
    private PlayerRed playerRed;
    private boolean blueJumping;
    private boolean redJumping;
    private static final float JUMP_VELOCITY = 10; // Velocidade inicial do pulo
    private static final float GRAVITY = -0.5f; // Ajuste conforme necessário

    public Movement(PlayerBlue playerBlue, PlayerRed playerRed) {
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
        this.blueJumping = false;
        this.redJumping = false;
    }

    public void handleInput() {
        // Movimento do PlayerBlue
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            playerBlue.setVelocity(-4, playerBlue.getVelocityY());
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            playerBlue.setVelocity(4, playerBlue.getVelocityY());
        } else {
            playerBlue.setVelocity(0, playerBlue.getVelocityY());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W) && playerBlue.getY() <= 0 && !blueJumping) {
            playerBlue.setVelocity(playerBlue.getVelocityX(), JUMP_VELOCITY);
            blueJumping = true;
        }

        // Movimento do PlayerRed
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            playerRed.setVelocity(-4, playerRed.getVelocityY());
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            playerRed.setVelocity(4, playerRed.getVelocityY());
        } else {
            playerRed.setVelocity(0, playerRed.getVelocityY());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP) && playerRed.getY() <= 0 && !redJumping) {
            playerRed.setVelocity(playerRed.getVelocityX(), JUMP_VELOCITY);
            redJumping = true;
        }
    }

    // Método para atualizar o estado do salto dos jogadores
    public void updateJumpState() {
        // Atualiza o estado de pulo do jogador azul
        if (playerBlue.getY() <= 0) {
            blueJumping = false;
            playerBlue.setY(0); // Garante que o jogador azul não afunde abaixo da tela
        }

        // Atualiza o estado de pulo do jogador vermelho
        if (playerRed.getY() <= 0) {
            redJumping = false;
            playerRed.setY(0); // Garante que o jogador vermelho não afunde abaixo da tela
        }
    }
}
