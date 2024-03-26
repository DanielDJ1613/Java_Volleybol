package com.game.rules;

import com.game.objects.PlayerRed;
import com.game.objects.PlayerBlue;

public class GameLimits {
    private int fieldWidth;
    private int fieldHeight;
    private PlayerBlue playerBlue;
    private PlayerRed playerRed;
    private int midX; // Posição x do meio do campo
    private int borderThickness = 10; // Espessura da borda

    public GameLimits(int fieldWidth, int fieldHeight, PlayerBlue playerBlue, PlayerRed playerRed) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
        this.midX = fieldWidth / 2;
    }

    public void checkBoundaries() {
        // Limites para o jogador azul (PlayerBlue)
        if (playerBlue.getY() < borderThickness) { // Limite superior
            playerBlue.setY(borderThickness);
            playerBlue.setVelocity(playerBlue.getVelocityX(), 0);
        } else if (playerBlue.getY() > fieldHeight - borderThickness) { // Limite inferior
            playerBlue.setY(fieldHeight - borderThickness);
            playerBlue.setVelocity(playerBlue.getVelocityX(), 0);
        }
        if (playerBlue.getX() > midX - 50) { // Não permitir que o jogador azul ultrapasse o meio campo
            playerBlue.setX(midX - 50);
            playerBlue.setVelocity(0, playerBlue.getVelocityY());
        }

        // Limites para o jogador vermelho (PlayerRed)
        if (playerRed.getY() < borderThickness) { // Limite superior
            playerRed.setY(borderThickness);
            playerRed.setVelocity(playerRed.getVelocityX(), 0);
        } else if (playerRed.getY() > fieldHeight - borderThickness) { // Limite inferior
            playerRed.setY(fieldHeight - borderThickness);
            playerRed.setVelocity(playerRed.getVelocityX(), 0);
        }

        if (playerRed.getX() < midX + 50) { // Não permitir que o jogador vermelho ultrapasse o meio campo
            playerRed.setX(midX + 50);
            playerRed.setVelocity(0, playerRed.getVelocityY());
        }
    }
}
