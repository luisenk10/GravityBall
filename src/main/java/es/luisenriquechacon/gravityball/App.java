package es.luisenriquechacon.gravityball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, 800, 470);
        stage.setScene(scene);
        stage.show();
        
        Image image1 = new Image(getClass().getResourceAsStream("/imagenes/fondo.png"));
        ImageView imageView1 = new ImageView(image1);
        root.getChildren().add(imageView1);
        Image image2 = new Image(getClass().getResourceAsStream("/imagenes/bola.gif"));
        ImageView imageView2 = new ImageView(image2);
        root.getChildren().add(imageView2);
        
    // Movimiento Bola
        
    }

    public static void main(String[] args) {
        launch();
    }

}