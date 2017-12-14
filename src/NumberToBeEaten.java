import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class NumberToBeEaten {

    int x2 = 0;
    int y2 = 0;

    boolean randomed = false;

    Random rand = new Random();


    public void numberEntityMaker(GraphicsContext gc) {
        if (randomed == false) {
            x2 = rand.nextInt(900) + 50;
            y2 = rand.nextInt(800) + 50;
            randomed = true;
        }
            gc.setFill(Color.RED);
            gc.fillRect(x2, y2, 20, 20);
    }
}
