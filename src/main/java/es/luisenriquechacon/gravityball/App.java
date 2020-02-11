package es.luisenriquechacon.gravityball;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.print.Paper.C;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    
    final short SCENE_HEIGHT = 480;
    final short SCENE_WIDTH = 640;
    final short TEXT_SIZE = 24; 
    
    short ballRadius = 15;
           
    short ballCenterX = 800;
    byte ballCurrentSpeedX = 3;
    byte ballDirectionX = 1;
   
    short ballCenterY = 200;
    byte ballCurrentSpeedY = 3;
    byte ballDirectionY = 1;
    
    short imageHeight = 50;        
    short imagePosY = (short)((SCENE_HEIGHT-imageHeight)/2);
    byte imageCurrentSpeed = 4;
    byte imageDirection = 0;
   

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, 800, 470);
        stage.setScene(scene);
        stage.show();
        //Creacion del fondo
        Image image1 = new Image(getClass().getResourceAsStream("/imagenes/fondo.png"));
        ImageView imageView1 = new ImageView(image1);
        root.getChildren().add(imageView1);
        //Creacion de la Bola
        Image image2 = new Image(getClass().getResourceAsStream("/imagenes/bola.gif"));
        ImageView imageView2 = new ImageView(image2);
        root.getChildren().add(imageView2);
        
    //Creación del primer enemigo (figura de bola)
        // new Circle() => Crear un objeto de la clase Circle
        Circle circleBall = new Circle();
        // Llamando a métodos del objeto circleBall
        circleBall.setCenterX(ballCenterX);
        circleBall.setCenterY(ballCenterY);
        circleBall.setRadius(ballRadius);  
        circleBall.setFill(Color.BLACK);
              
        root.getChildren().add(circleBall);
       
        //Creación del segundo enemigo (figura de bola)
        // new Circle() => Crear un objeto de la clase Circle
        Circle circleBall2 = new Circle();
        // Llamando a métodos del objeto circleBall
        circleBall2.setCenterX(ballCenterX);
        circleBall2.setCenterY(ballCenterY);
        circleBall2.setRadius(ballRadius);  
        circleBall2.setFill(Color.BLACK);
            
        root.getChildren().add(circleBall2);
       
        //Creación del tercer enemigo (figura de bola)
        // new Circle() => Crear un objeto de la clase Circle
        Circle circleBall3 = new Circle();
        // Llamando a métodos del objeto circleBall
        circleBall3.setCenterX(ballCenterX);
        circleBall3.setCenterY(ballCenterY);
        circleBall3.setRadius(ballRadius);  
        circleBall3.setFill(Color.BLACK);
             
        root.getChildren().add(circleBall3);
        
        // CONTROL DEL TECLADO
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(final KeyEvent keyEvent) {
                switch(keyEvent.getCode()) {
                    case UP:
                        imageDirection = -1;
                        break;
                    case DOWN:
                        imageDirection = 1;
                        break;
                }                
            }
            
            
        });
       
        Timeline timeline = new Timeline (
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    circleBall.setCenterX(ballCenterX);
                    circleBall.setCenterY(ballCenterY);
                    circleBall2.setCenterX(ballCenterX);
                    circleBall2.setCenterY(50);
                    circleBall3.setCenterX(ballCenterX);
                    circleBall3.setCenterY(400);
                    ballCenterX += ballCurrentSpeedX * ballDirectionX;
                    ballCenterY += ballCurrentSpeedY * ballDirectionY;
                    // Control de rebote horizontal
                    if(ballCenterX >= 870) {
                        ballDirectionX = -1;
                    } else if(ballCenterX <= 0){
                        ballDirectionX = 1;
                    }
                    // Control de rebote vertical
                    if(ballCenterY >= 580) {
                        ballDirectionY = -1;
                    } else if(ballCenterY <= 0){
                        ballDirectionY = 1;
                    }
                   
                }
            }
            )
        );
                
            //Animacion de la Bola   
            imageView2.setY(imagePosY);
                    imagePosY += imageCurrentSpeed * imageDirection;
                    if(imagePosY <= 0 || imagePosY >= SCENE_HEIGHT-imageHeight) {
                        imageDirection = 0;
                    }
                    if(imagePosY <= 0) {
                        imageDirection = 0;
                        imagePosY = 0;
                    } else if (imagePosY >= SCENE_HEIGHT-imageHeight) {
                        imageDirection = 0;
                        imagePosY = (short)(SCENE_HEIGHT-imageHeight);
                    }
                
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
       
        
    };
       


    public static void main(String[] args) {
        launch();
    }

}
