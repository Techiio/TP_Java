package com.example.RPG;

import javafx.scene.control.Button;

public class CustomButtonFactory {
    private Button button;

    private CustomButtonFactory(String old, String nouv) {
        this.button = new Button(old);
        this.button.setOnMouseClicked((event) ->
                button.setText(nouv));
    }

    public static Button createButton(String old, String nouv) {
        return new CustomButtonFactory(old, nouv).button;
    }
}