package com.example.RPG;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Game game = new Game();
        game.playGame();
        JavaFX javaFx = new JavaFX(game);
        javaFx.start(stage);
    }
}
