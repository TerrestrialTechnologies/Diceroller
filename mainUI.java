import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*; 
import javafx.scene.layout.*;
import javafx.stage.Stage; 

public class mainUI extends Application{ 
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("DieCup");

        //layout for UI 
        VBox root = new VBox(10); //vertical layout, spacing

        //dropdown for dice type
        ComboBox<String> diceType = new ComboBox<>(); 
        diceType.getItems().addAll("d4", "d6", "d8", "d10", "d12", "d20", "d100");
        diceType.setValue("d6"); 

        //dropdown for number of dice 
        ComboBox<Integer> numDice = new ComboBox<>();
        for(int i = 1; i <=10; i++){ 
            numDice.getItems().add(i);
        }
        numDice.setValue(1);

        //modifier input field
        TextField modInput = new TextField();
        modInput.setPromptText("Modifier(e.g., +2, -1)");

        //Roll button
        Button roll = new Button("Roll");

        //result display
        Label result = new Label("Roll Result: ");

        //roll history area 
        TextArea history = new TextArea();
        history.setEditable(false);
        history.setPrefHeight(150); 

        //reset button 
        Button reset = new Button("Reset"); 

        //add to layout
        root.getChildren().addAll(diceType,numDice,modInput,roll, result, history, reset);

        //create scene
        Scene sc1 = new Scene(root, 400, 300);
        primaryStage.setScene(sc1);
        primaryStage.show();
    }
    public static void main(String[] args){ 
        launch(args);
    }
}