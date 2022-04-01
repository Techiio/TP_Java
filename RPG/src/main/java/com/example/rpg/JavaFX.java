package com.example.rpg;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFX {
    Game game;

    public JavaFX(Game game) {
        this.game = game;
    }

    public void start(Stage stage) throws IOException {
        int heroAleatoire = 0 + (int)(Math.random() * ((4 - 0) + 1));
        int enemyAleatoire = 0 + (int)(Math.random() * ((2 - 0) + 1));

        GridPane gridPane = new GridPane();
        Text
        Button btn = CustomButtonFactory.createButton("Pick random hero", game.getHeroes()[heroAleatoire].toString());
        Button btn2 = CustomButtonFactory.createButton("Pick random enemy", game.getEnemies()[enemyAleatoire].toString());
        gridPane.add(btn, 10, 10);
        gridPane.add(btn2, 10, 20);
        Scene scene = new Scene(gridPane, 600, 400);
        stage.setTitle("Elden Ring II (enkor + dur)");
        stage.setScene(scene);
        stage.show();
    }
}
