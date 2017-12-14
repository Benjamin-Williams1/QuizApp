import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {

    int x = 1;
    int y = 1;

    public void drawToScreen(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(x,y,20,20);
    }


    public void loopScreen() {
        if (x >= 1000) {
            x = 0;
        } else if (y >= 900) {
            y = 0;
        } else if (x <= 0) {
            x = 1000;
        } else if (y <= 0) {
            y = 900;
        }
    }
}
