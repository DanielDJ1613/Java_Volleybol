package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.game.guis.MainMenu;

public class MyGame extends Game {

    @Override
    public void create() {
        setScreen(new MainMenu());
    }

    // Método para mudar de tela
    public void changeScreen(ScreenEnum screenEnum) {
        Screen newScreen = null;
        switch (screenEnum) {
            case MAIN_MENU:
                newScreen = new MainMenu();
                break;
            // Adicione mais cases para outras telas aqui, conforme necessário
        }
        setScreen(newScreen);
    }

    // Enumeração para representar as telas
    public enum ScreenEnum {
        MAIN_MENU
        // Adicione mais tipos de tela aqui conforme necessário
    }
}
