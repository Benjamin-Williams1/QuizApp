import com.sun.org.apache.bcel.internal.generic.RETURN;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

import java.util.ArrayList;
import java.util.Random;

public class Movement extends Application{

    Random rand = new Random();

    int vx = 8;
    int vy = 0;

    int x2 = 0;
    int y2 = 0;

    boolean cleared = false;
    boolean ONLYONCEPLEASE = false;
    boolean eaten = false;
    boolean randomed = false;
    boolean yummy = false;

    int EatenNumber = 0;

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 900);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        ArrayList<Player> P = new ArrayList<>();
        P.add(new Player());

        AnimationTimer renderingTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0,0,1000,900);

                for(int i = P.size() - 1; i > 0; i--){
                    P.get(i).x = P.get(i-1).x;
                    P.get(i).y = P.get(i-1).y;
                }

                for(int i = 0; i < P.size(); i++) {
                    P.get(i).drawToScreen(gc);
                }

                P.get(0).x += vx;
                P.get(0).y += vy;

                scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                    if(key.getCode() == KeyCode.W) {
                        if(vx == 8 || vx == -8){
                            vx = 0;
                        }if(vy != 8){
                            vy = -8;
                        }
                    }else if(key.getCode() == KeyCode.A){
                        if(vy == 8 || vy == -8) {
                            vy = 0;
                        }if(vx != 8){
                            vx = -8;
                        }
                    }else if(key.getCode() == KeyCode.S){
                        if(vx == 8 || vx == -8){
                            vx = 0;
                        }if(vy != -8){
                            vy = 8;
                        }
                    }else if(key.getCode() == KeyCode.D){
                        if(vy == 8 || vy == -8) {
                            vy = 0;
                        }if(vx != -8){
                            vx = 8;
                        }
                    }
                });


                if(randomed == false) {
                    x2 = rand.nextInt(900) + 50;
                    y2 = rand.nextInt(800) + 50;
                    randomed = true;
                }

                P.get(0).loopScreen();


                if(cleared == false){
                    gc.setFill(Color.RED);
                    gc.fillRect(x2, y2, 20, 20);
                    System.out.println("This maybe worked");
                }

                if((P.get(0).x >= x2 - 40 && P.get(0).x <= x2 + 40) && (P.get(0).y >= y2 - 40 && P.get(0).y <= y2 + 40)){
                    System.out.println("This works");
                    cleared = true;
                    ONLYONCEPLEASE = true;
                    for(int ii = 0; ii < 2; ii++) {
                        P.add(new Player());
                    }
                }

                for(Player p1 : P)
                    if(p1 != P.get(0)) {
                    {
                    if ((Math.abs(P.get(0).x-p1.x)<=7) && (Math.abs(P.get(0).y-p1.y)<=7)){
                        System.out.println("You Lose");
                        System.exit(0);
                    }
                }
                }

                System.out.println(P.size());

                if(cleared == true && ONLYONCEPLEASE == true){
                    gc.clearRect(x2, y2, 40,40);
                    gc.setFill(Color.GREEN);
                    eaten = true;
                    EatenNumber ++;
                }

                if(eaten == true && cleared == true){
                    yummy = true;
                    cleared = false;
                    ONLYONCEPLEASE = false;
                    randomed = false;
                    System.out.println("WHY ARE YOU FIRING");
                }

                /*for(int i = 0; i <= EatenNumber; i++) {
                    if (yummy == true) {
                        gc.setFill(Color.GREEN);
                        gc.fillRect(x + (EatenNumber * 25), y, 20, 20);
                    }
                }*/


                /*scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
                    if(key.getCode() == KeyCode.W || key.getCode() == KeyCode.S){
                        vy = 0;
                    }else if(key.getCode() == KeyCode.A || key.getCode() == KeyCode.D){
                        vx = 0;
                    }
                });*/
            }
        };renderingTimer.start();
    }
}
