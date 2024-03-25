package com.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.game.MyGame.ScreenEnum;

public class Initializer extends ApplicationAdapter {
    private MyGame game;

    @Override
    public void create() {
        game = new MyGame();
        game.create();
        game.changeScreen(ScreenEnum.MAIN_MENU);
    }

    @Override
    public void render() {
        // Limpar a tela
        ScreenUtils.clear(0, 0, 0, 1);

        // Atualizar e renderizar o jogo
        game.render();
    }

    @Override
    public void dispose() {
        // Descartar recursos quando o jogo for encerrado
        game.dispose();
    }
}
