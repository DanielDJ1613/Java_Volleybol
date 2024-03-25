package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.game.guis.MainMenu;
import com.game.guis.SingleplayerMenu;

public class MyGame extends Game {
    private MainMenu mainMenu;
    private SingleplayerMenu singleplayerMenu;

    private  GameScreen gamescreen;
    // Declare outras telas aqui

    @Override
    public void create() {
        // Instancia e configura o MainMenu
        setupMainMenu();

        singleplayerMenu = new SingleplayerMenu();
        gamescreen = new GameScreen();
        // Instancie outras telas

        // Defina a tela inicial como o menu principal
        setScreen(mainMenu);
    }

    // Método para instanciar e configurar o MainMenu
    private void setupMainMenu() {
        mainMenu = new MainMenu();
        mainMenu.setGame(this); // Configura a referência ao MyGame dentro do MainMenu
    }

    // Método para mudar de tela
    public void changeScreen(ScreenEnum screenEnum) {
        Screen newScreen = null;
        switch (screenEnum) {
            case MAIN_MENU:
                newScreen = mainMenu;
                break;
            case SINGLEPLAYER_MENU:
                newScreen = singleplayerMenu;
                break;
            case GAMESCREEN:
                newScreen = gamescreen;
                break;
            // Adicione outros casos para outras telas aqui conforme necessário
        }
        setScreen(newScreen);
    }

    // Enumeração para representar as telas
    public enum ScreenEnum {
        MAIN_MENU,
        SINGLEPLAYER_MENU,
        GAMESCREEN
        // Adicione outros tipos de tela aqui conforme necessário
    }
}
