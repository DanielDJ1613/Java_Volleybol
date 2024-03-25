package com.game.settings;

import java.util.function.Consumer;

public class ButtonInterative {
    private Consumer<Void> singleplayerCallback;
    private Consumer<Void> multiplayerCallback;

    public ButtonInterative(Consumer<Void> singleplayerCallback, Consumer<Void> multiplayerCallback) {
        this.singleplayerCallback = singleplayerCallback;
        this.multiplayerCallback = multiplayerCallback;
    }

    public void onSingleplayerButtonClick() {
        if (singleplayerCallback != null) {
            singleplayerCallback.accept(null);
        }
    }

    public void onMultiplayerButtonClick() {
        if (multiplayerCallback != null) {
            multiplayerCallback.accept(null);
        }
    }
}
