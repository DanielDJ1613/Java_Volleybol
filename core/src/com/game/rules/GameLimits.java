package com.game.rules;

import com.game.objects.PlayerRed;
import com.game.objects.PlayerBlue;

public class GameLimits {
    private int screenWidth;
    private int screenHeight;
    private PlayerBlue playerBlue;
    private PlayerRed playerRed;

    public GameLimits(int screenWidth, int screenHeight, PlayerBlue playerBlue, PlayerRed playerRed) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
    }

    public void checkBoundaries() {
        // Limites para o jogador azul (PlayerBlue)
        if (playerBlue.getX() < 0) {
            playerBlue.setVelocity(0, playerBlue.getVelocityY());
        } else if (playerBlue.getX() > screenWidth / 2) {
            playerBlue.setVelocity(0, playerBlue.getVelocityY());
        }

        // Limites para o jogador vermelho (PlayerRed)
        if (playerRed.getX() < screenWidth / 2) {
            playerRed.setVelocity(0, playerRed.getVelocityY());
        } else if (playerRed.getX() > screenWidth) {
            playerRed.setVelocity(0, playerRed.getVelocityY());
        }
    }
}
