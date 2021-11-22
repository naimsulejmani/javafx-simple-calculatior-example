package ict.kosovo.growth.calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    private double result = 0;
    private boolean isNewNumber = true;
    private String lastOperator = "";


    @FXML
    TextField txtResult;

    @FXML
    Button btnPlusMinus;

    @FXML
    Button btnPlus;

    @FXML
    Button btnMinus;

    @FXML
    Button btnDivide;

    @FXML
    Button btnMultiply;

    @FXML
    Button btnDot;

    @FXML
    Button btnAC;

    @FXML
    Button btnModulus;

    @FXML
    Button btnEqual;
    //+,-,*,/,%
    EventHandler<ActionEvent> onOperationButtonClicked = (event) -> {
        Button button = (Button) event.getSource(); //Buttonin i cili ka shtyp +,-,...
        String operator = button.getText();
        double currentValue = Double.parseDouble(txtResult.getText());

        result = calculate(lastOperator, currentValue, result);
        isNewNumber = true;
//        switch (operator) {
//            case "+":
//                result += currentValue;
//                System.out.println("++++++++++++++++");
//                break;
//            case "-":
//                System.out.println("-------------------");
//                break;
//            case "x":
//                System.out.println("******************");
//                break;
//            case "/":
//                System.out.println("/////////////////////");
//                break;
//            case "%":
//                System.out.println("%%%%%%%%%%%%%%%%%%%%");
//                break;
//            default:
//                System.out.println("NOt correct type of operator!!!!");
//                return;
//        }
        if (!operator.equals("="))
            lastOperator = operator;
        txtResult.setText(String.valueOf(result));
        //txtResult.setText(""+result);
    };


    private double calculate(String operator, double number, double result) {

        switch (operator) {
            case "+":
                result += number;
                System.out.println("++++++++++++++++");
                break;
            case "-":
                result -= number;
                System.out.println("-------------------");
                break;
            case "x":
                result *= number;
                System.out.println("******************");
                break;
            case "/":
                result /= number;
                System.out.println("/////////////////////");
                break;
            case "%":
                result %= number;
                System.out.println("%%%%%%%%%%%%%%%%%%%%");
                break;
            default:
                System.out.println("NOt correct type of operator!!!!");
                return number;
        }
        return result;
    }

    //@FXML
//    public void button7_clicked(){
//        txtResult.setText("7");
//        System.out.println("Button 7 clicked");
//    }
//
//    @FXML
//    public void button5_clicked(){
//        txtResult.setText("5");
//        System.out.println("Button 5 clicked");
//    }


    @FXML
    public void onNumericButtonClicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        System.out.println(button.getText());


        if (isNewNumber || txtResult.getText().equals("0"))
            txtResult.setText(button.getText());
        else
            txtResult.setText(txtResult.getText() + button.getText());

        isNewNumber = false;
    }

    @FXML
    public void onDotButtonClicked(ActionEvent event) {
        //Button button = (Button) event.getSource();
        if (!txtResult.getText().contains(".")) {
            txtResult.setText(txtResult.getText() + ".");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Kjo thirret ne fillim! Si konstruktore");
        //i kemi than Anonymos Class
        btnAC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtResult.setText("0");
                //metode reset();
            }
        });
//implementimi me lambda expression
        btnModulus.setOnAction((event) -> {
            System.out.println("Implemento modulues -> " + event);
        });

        btnPlusMinus.setOnAction((e) -> {
            if (txtResult.getText().contains("-")) {
                txtResult.setText(txtResult.getText().replace("-", ""));
            } else {
                txtResult.setText("-" + txtResult.getText());
            }
        });

        //btnPlus.setOnAction(onOperationButtonClicked);
        //btnMinus.setOnAction(onOperationButtonClicked);
        setActionForButton(onOperationButtonClicked, btnPlus, btnMinus, btnMultiply, btnModulus, btnDivide, btnEqual);
        //setActionForButton(onNumericClicked, btn1, btn2....);
    }

    private void setActionForButton(EventHandler<ActionEvent> event, Button... buttons) {
        for (Button btn : buttons) {
            btn.setOnAction(event);
        }
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.getText());
    }
}
