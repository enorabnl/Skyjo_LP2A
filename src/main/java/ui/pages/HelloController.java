package ui.pages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;

    private Button startBtn;
    @FXML
    private TextField playerBlueInput;
    @FXML
    private TextField playerRedInput;

    @FXML
    private TextField playerYellowInput;

    @FXML
    private TextField playerGreenInput;

    @FXML
    public void initialize() {
        System.out.println("init");
        addListenerInput(playerBlueInput);
        addListenerInput(playerRedInput);
        addListenerInput(playerYellowInput);
        addListenerInput(playerGreenInput);

    }

    private void addListenerInput(TextField newInput){
        System.out.println(newInput);
        if (newInput != null){
            newInput.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
                if (! isNowFocused) {
                    if (!Objects.equals(newInput.getText(), "")){
                        welcomeText.setText("Welcome " + newInput.getText());
                    }
                }
            });
        }

    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome " + playerBlueInput.getText() + " to JavaFX Application!");
        playerBlueInput.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (! isNowFocused) {
                // text field has lost focus...
                welcomeText.setText("out focus");
            }else{
                welcomeText.setText("in focus");
            }
        });
    }

    @FXML
    protected void onNameEnter(){ welcomeText.setText("new player added"); }
    @FXML
    protected void onInputEnter(){ welcomeText.setText(""); }
}