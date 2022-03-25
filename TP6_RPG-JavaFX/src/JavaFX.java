import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFX {
    Game game;

    public JavaFX(Game game) {
        this.game = game;
    }

    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        Button btn = CustomButtonFactory.createButton("Pick me", game.getHeroes()[0].toString());
        gridPane.add(btn, 10, 10);
        Scene scene = new Scene(gridPane, 600, 400);
        stage.setTitle("RPG_Lite_3000");
        stage.setScene(scene);
        stage.show();
    }
}
