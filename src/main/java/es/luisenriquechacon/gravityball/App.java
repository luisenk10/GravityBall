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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    
    final short SCENE_HEIGHT = 480;
    final short SCENE_WIDTH = 640;
    final short TEXT_SIZE = 24; 
    
    short ballRadius = 20;
           
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
    
    short freeHeight = 4;
    short freeWidth = 100;
    short freeHeight2 = 90;
    short freeWidth2 = 4;
      
    //BOLA
    short freePosY = (short)((SCENE_HEIGHT)/2);
    byte freeCurrentSpeed = 4;
    byte freeDirectionY = 0;
    byte freeDirectionX = 0;
    short freePosX = (short)(SCENE_WIDTH - SCENE_WIDTH);
    
    
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
        Image image2 = new Image(getClass().getResourceAsStream("/imagenes/craft.png"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setX(freePosX);
        imageView2.setY(freePosY);
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
        scene.setOnKeyPressed((final KeyEvent keyEvent) -> {
            switch(keyEvent.getCode()) {
                case UP:
                    freeDirectionY = -1;
                    break;
                case DOWN:
                    freeDirectionY = 1;
                    break;  
                    
                case RIGHT:
                    freeDirectionX = 1;
                    break;  
                    
                case LEFT:
                    freeDirectionX = -1;
                    break;  
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
             
        //rectangulo ATRAS freezer colision
        Rectangle rectangle1 = new Rectangle(freeHeight,freeWidth);
        root.getChildren().add(rectangle1);
        rectangle1.setFill(Color.YELLOW);
        rectangle1.setX(freePosX);
        rectangle1.setY(freePosY); 
        
        //rectangulo ADELANTE freezer colision
        Rectangle rectangle2 = new Rectangle(freeHeight,freeWidth);
        root.getChildren().add(rectangle2);
        rectangle2.setFill(Color.RED);
        rectangle2.setX(freePosX + 90);
        rectangle2.setY(freePosY); 
        
        
        
        //rectangulo ARRIBA freezer colision
        Rectangle rectangle3 = new Rectangle(freeHeight2,freeWidth2);
        root.getChildren().add(rectangle3);
        rectangle3.setFill(Color.GREEN);
        rectangle3.setX(freePosX);
        rectangle3.setY(freePosY + 100); 
        
        //rectangulo ABAJO freezer colision
        Rectangle rectangle4 = new Rectangle(freeHeight2,freeWidth2);
        root.getChildren().add(rectangle4);
        rectangle4.setFill(Color.BLUE);
        rectangle4.setX(freePosX);
        rectangle4.setY(freePosY); 
        
        
            //Animacion de la Bola   
            // ANIMACIÓN DE Free
                rectangle1.setY(freePosY);
                rectangle1.setX(freePosX); 
                rectangle2.setX(freePosX + 90);
                rectangle2.setY(freePosY);
                rectangle3.setY(freePosY + 100);
                rectangle3.setX(freePosX); 
                rectangle4.setX(freePosX);
                rectangle4.setY(freePosY);
                imageView2.setY(freePosY);
                imageView2.setX(freePosX);
                freePosY += freeCurrentSpeed * freeDirectionY;
                freePosX += freeCurrentSpeed * freeDirectionX;
                if(freePosY <= 0 || freePosY >= SCENE_HEIGHT) {
                    freeDirectionY = 0;
                }
                if(freePosX <= 0 || freePosX >= SCENE_WIDTH) {
                    freeDirectionX = 0;
                }
                if(freePosY <= 0) {
                    freeDirectionY = 0;
                    freePosY = 0;
                } else if (freePosY >= SCENE_HEIGHT) {
                    freeDirectionY = 0;
                    freePosY = (short)(SCENE_HEIGHT);
                }
                
                
                if(freePosX <= 0) {
                    freeDirectionX = 0;
                    freePosX = 0;
                } else if (freePosX >= SCENE_WIDTH) {
                    freeDirectionX = 0;
                    freePosX = (short)(SCENE_WIDTH);
                }
                
                
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
       
        
    };
       


    public static void main(String[] args) {
        launch();
    }

}
