
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public class Movement extends Application{

    private int vx = 8;
    private int vy = 0;

    private boolean ONLYONCEPLEASE = false;
    private boolean eaten = false;
    private boolean cleared = false;

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

        ArrayList<NumberToBeEaten> EatMe = new ArrayList<>();
        EatMe.add(new NumberToBeEaten());

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

                for(int i = 0; i < EatMe.size(); i++) {
                    EatMe.get(i).numberEntityMaker(gc);
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

                P.get(0).loopScreen();

                if((P.get(0).x >= EatMe.get(0).x2 - 20 && P.get(0).x <= EatMe.get(0).x2 + 20) && (P.get(0).y >= EatMe.get(0).y2 - 20 && P.get(0).y <= EatMe.get(0).y2 + 20)){
                    cleared = true;
                    ONLYONCEPLEASE = true;
                    for(int ii = 0; ii < 2; ii++) {
                        P.add(new Player());
                    }

                    EatMe.removeAll(EatMe);

                    for(int ii = 0; ii < 4; ii++) {
                        EatMe.add(new NumberToBeEaten());
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

                if(cleared && ONLYONCEPLEASE){
                    for(int e = 0; e < 4; e++) {
                        gc.clearRect(EatMe.get(0).x2, EatMe.get(0).y2, 20, 20);
                        EatMe.get(0).randomed = false;
                    }
                    gc.setFill(Color.GREEN);
                    eaten = true;
                }

                if(eaten && cleared){
                    cleared = false;
                    ONLYONCEPLEASE = false;
                    EatMe.get(0).randomed = false;
                }
            }
        };renderingTimer.start();
    }
}
