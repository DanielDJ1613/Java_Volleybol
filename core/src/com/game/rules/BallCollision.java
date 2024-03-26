package com.game.rules;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
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
        Rectangle ballBounds = new Rectangle(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), ball.getRadius() * 2, ball.getRadius() * 2);
        Rectangle playerBlueBounds = playerBlue.getBounds();
        Rectangle playerRedBounds = playerRed.getBounds();

        if (Intersector.overlaps(ballBounds, playerBlueBounds)) {
            // Calcula o vetor de deslocamento entre o centro da bola e o centro do jogador
            Vector2 displacement = new Vector2(playerBlue.getX() - ball.getX(), playerBlue.getY() - ball.getY());

            // Calcula o vetor de reflexão
            Vector2 reflection = new Vector2(-displacement.x, -displacement.y).nor();

            // Atualiza a velocidade da bola com base na reflexão, com uma velocidade ainda mais lenta
            ball.setVelocity(reflection.x * 15, reflection.y * 15);
        }

        if (Intersector.overlaps(ballBounds, playerRedBounds)) {
            // Calcula o vetor de deslocamento entre o centro da bola e o centro do jogador
            Vector2 displacement = new Vector2(playerRed.getX() - ball.getX(), playerRed.getY() - ball.getY());

            // Calcula o vetor de reflexão
            Vector2 reflection = new Vector2(-displacement.x, -displacement.y).nor();

            // Atualiza a velocidade da bola com base na reflexão, com uma velocidade ainda mais lenta
            ball.setVelocity(reflection.x * 15, reflection.y * 15);
        }
    }


}

