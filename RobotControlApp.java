import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RobotControlApp extends Application {

    private Stage primaryStage;
    private Robot robot;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.robot = new Robot();

        // Crear la GUI
        VBox root = new VBox(10);
        root.GetChildren().add(new Button("Mover"));
        root.GetChildren().add(new Button("Girar"));
        root.GetChildren().add(new TextField("Introducir el valor del movimiento"));
        root.GetChildren().add(new TextField("Introducir el valor del giro"));

        //Configurar los controladoresde eventos
        Button moveButton = (Button) root.GetChildren().get(0);
        moveButton.setOnAction(e -> {
            int x = Integer.parseInt(((TextField) root.getChildren().get(2)).getText());
            int y = Integer.parseInt(((TextField) root.getChildren().get(3)).getText());
            robot.mover(x, y);
        });


    }
