package com.game.rules;

import com.badlogic.gdx.math.Rectangle;
import com.game.objects.PlayerBlue;
import com.game.objects.PlayerRed;
import com.game.objects.BolaVolei;

public class BallCollision {
    private int fieldWidth;
    private int fieldHeight;
    private PlayerBlue playerBlue;
    private PlayerRed playerRed;
    private BolaVolei ball;
    private int borderThickness = 10; // Espessura da borda

    public BallCollision(int fieldWidth, int fieldHeight, PlayerBlue playerBlue, PlayerRed playerRed, BolaVolei ball) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
        this.ball = ball;
    }

    public void checkCollisions() {
        // Limites da bola
        if (ball.getY() < borderThickness) { // Limite superior
            ball.setVelocityY(-ball.getVelocityY()); // Inverte a direção vertical (faz a bola saltar)
            ball.setY(borderThickness);
        } else if (ball.getY() > fieldHeight - borderThickness - ball.getHeight()) { // Limite inferior (chão)
            ball.setVelocityY(-ball.getVelocityY()); // Inverte a direção vertical (faz a bola saltar)
            ball.setY(fieldHeight - borderThickness - ball.getHeight());
        }
        if (ball.getX() < borderThickness) { // Limite esquerdo
            ball.setVelocityX(-ball.getVelocityX()); // Inverte a direção horizontal
            ball.setX(borderThickness);
        } else if (ball.getX() > fieldWidth - borderThickness - ball.getWidth()) { // Limite direito
            ball.setVelocityX(-ball.getVelocityX()); // Inverte a direção horizontal
            ball.setX(fieldWidth - borderThickness - ball.getWidth());
        }

        // Colisão entre jogadores e bola
        Rectangle ballBounds = ball.getSprite().getBoundingRectangle();
        Rectangle playerBlueBounds = playerBlue.getSprite().getBoundingRectangle();
        Rectangle playerRedBounds = playerRed.getSprite().getBoundingRectangle();

        if (playerBlueBounds.overlaps(ballBounds)) {
            // Lógica de colisão entre jogador azul e bola
            float hitDirection = (ball.getX() - playerBlue.getX()) / playerBlue.getX(); // Calcula a direção do chute baseada na posição do jogador
            float hitStrength = (ball.getY() - playerBlue.getY()) / playerBlue.getY(); // Calcula a força do chute baseada na posição do jogador
            // Aplica uma força horizontal e vertical com base na direção e força do chute
            ball.setVelocity(hitDirection * 5, hitStrength * 5 - 10); // Desconta a gravidade
        }

        if (playerRedBounds.overlaps(ballBounds)) {
            // Lógica de colisão entre jogador vermelho e bola
            float hitDirection = (ball.getX() - playerRed.getX()) / playerRed.getX(); // Calcula a direção do chute baseada na posição do jogador
            float hitStrength = (ball.getY() - playerRed.getY()) / playerRed.getY(); // Calcula a força do chute baseada na posição do jogador
            // Aplica uma força horizontal e vertical com base na direção e força do chute
            ball.setVelocity(hitDirection * 5, hitStrength * 5 - 10); // Desconta a gravidade
        }
    }

}
