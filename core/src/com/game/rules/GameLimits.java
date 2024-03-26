package com.game.rules;

import com.game.objects.PlayerRed;
import com.game.objects.PlayerBlue;
import com.game.objects.Floor; // Import adicionado

public class GameLimits {
    private int fieldWidth;
    private int fieldHeight;
    private PlayerBlue playerBlue;
    private PlayerRed playerRed;
    private Floor floor; // Objeto do chão adicionado
    private int midX; // Posição x do meio do campo
    private int borderThickness = 10; // Espessura da borda

    public GameLimits(int fieldWidth, int fieldHeight, PlayerBlue playerBlue, PlayerRed playerRed, Floor floor) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
        this.floor = floor; // Atribuição do objeto do chão
        this.midX = fieldWidth / 2;
    }

    public void checkBoundaries() {
        // Limites para o jogador azul (PlayerBlue)
        if (playerBlue.getY() < floor.getHeight()) { // Limite superior
            playerBlue.setY(floor.getHeight());
            playerBlue.setVelocity(playerBlue.getVelocityX(), 0);
        } else if (playerBlue.getY() > fieldHeight) { // Limite inferior
            playerBlue.setY(fieldHeight);
            playerBlue.setVelocity(playerBlue.getVelocityX(), 0);
        }
        if (playerBlue.getX() > midX - 50) { // Não permitir que o jogador azul ultrapasse o meio campo
            playerBlue.setX(midX - 50);
            playerBlue.setVelocity(0, playerBlue.getVelocityY());
        }

        // Limites para o jogador vermelho (PlayerRed)
        if (playerRed.getY() < floor.getHeight()) { // Limite superior
            playerRed.setY(floor.getHeight());
            playerRed.setVelocity(playerRed.getVelocityX(), 0);
        } else if (playerRed.getY() > fieldHeight) { // Limite inferior
            playerRed.setY(fieldHeight);
            playerRed.setVelocity(playerRed.getVelocityX(), 0);
        }

        if (playerRed.getX() < midX + 50) { // Não permitir que o jogador vermelho ultrapasse o meio campo
            playerRed.setX(midX + 50);
            playerRed.setVelocity(0, playerRed.getVelocityY());
        }
    }
}

