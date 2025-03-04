package UI
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*; 
import javafx.scene.layout.*;
import javafx.stage.Stage; 
import javafx.geometry.Insets;

public class mainUI extends Application{ 
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("DieCup");

        //layout for UI. VBox with spacing 
        VBox root = new VBox(15); //increased spacing for a better layout 
        root.setPadding(new Insets(10,10,10,10)); //adds padding 

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

        ComboBox <String> rollType = new ComboBox<>();
        rollType.getItems().addAll("Normal", "Advantage", "Disadvantage");
        rollType.setValue("Normal"); 

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
        history.setPrefHeight(100); 

        //reset button 
        Button reset = new Button("Reset"); 

        //Row 1: dice type, dice number, roll type
        HBox row1 = new HBox(10,diceType, numDice, rollType);

        //Row 2, modifier 
        HBox row2 = new HBox(10, new Label("Modifier: "), modInput);

        //Row 3, roll button, reset button 
        HBox row3 = new HBox(15, roll, reset);

        row3.setAlignment(javafx.geometry.Pos.CENTER);

        //add to layout
        root.getChildren().addAll(row1, row2, row3, result, history);

        //create scene
        Scene sc1 = new Scene(root, 400, 300);
        primaryStage.setScene(sc1);
        primaryStage.show();
    }
    public static void main(String[] args){ 
        launch(args);
    }
}