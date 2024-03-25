package com.game.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.game.objects.PlayerBlue;
import com.game.objects.PlayerRed;

public class Movement {
    private PlayerBlue playerBlue;
    private PlayerRed playerRed;

    public Movement(PlayerBlue playerBlue, PlayerRed playerRed) {
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
    }

    public void handleInput() {
        // Movimento do PlayerBlue
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            playerBlue.setVelocity(-1, playerBlue.getVelocityY());
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            playerBlue.setVelocity(1, playerBlue.getVelocityY());
        } else {
            playerBlue.setVelocity(0, playerBlue.getVelocityY());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            // Logica do salto
        }

        // Movimento do PlayerRed
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            playerRed.setVelocity(-1, playerRed.getVelocityY());
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            playerRed.setVelocity(1, playerRed.getVelocityY());
        } else {
            playerRed.setVelocity(0, playerRed.getVelocityY());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            // Logica do salto
        }
    }
}
