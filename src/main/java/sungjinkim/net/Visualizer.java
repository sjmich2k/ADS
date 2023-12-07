package sungjinkim.net;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Visualizer extends Application {

    public static int pHeight = 1080;
    private Rectangle rect;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ADS Visualizer");

        Pane root = new Pane();
        Scene scene = new Scene(root, (int) (1.6 * pHeight), pHeight);
        primaryStage.setScene(scene);

        rect = new Rectangle(50, 50, Color.BLUE);
        root.getChildren().add(rect);

        rect.setX(500);
        rect.setY(500);

        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));
    }

    private void handleKeyPress(KeyCode code) {
        switch (code) {
            case UP:
                moveRectangle(0, -10);
                break;
            case DOWN:
                moveRectangle(0, 10);
                break;
            case LEFT:
                moveRectangle(-10, 0);
                break;
            case RIGHT:
                moveRectangle(10, 0);
                break;
        }
    }

    private void moveRectangle(double deltaX, double deltaY) {
        double newX = rect.getX() + deltaX;
        double newY = rect.getY() + deltaY;

        rect.setX(newX);
        rect.setY(newY);
    }
}