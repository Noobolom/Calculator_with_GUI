package sample;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.awt.event.KeyEvent;

public class Controller {
    @FXML
    private Button Number_four;

    @FXML
    private Button Number_five;

    @FXML
    private Button Number_three;

    @FXML
    private Button Number_one;

    @FXML
    private Button Number_two;

    @FXML
    private Button Number_six;

    @FXML
    private Button Number_seven;

    @FXML
    private Button Number_eight;

    @FXML
    private Button Number_nine;

    @FXML
    private Button Number_zero;

    @FXML
    private Button button_point;

    @FXML
    private Button button_right_quote;

    @FXML
    private Button button_left_quote;

    @FXML
    private Button button_equal;

    @FXML
    private Button button_divide;

    @FXML
    private Button button_minus;

    @FXML
    private Button button_multiply;

    @FXML
    private Button button_plus;

    @FXML
    private Button button_sin;

    @FXML
    private Button button_cos;

    @FXML
    private Button button_tan;

    @FXML
    private Label field_for_typing;

    @FXML
    private Button Button_ln;

    @FXML
    private Button button_exp;

    @FXML
    private Button button_erase_all;

    @FXML
    private Button button_erase_symbol;

    @FXML
    private Button button_factorial;

    @FXML
    private Button button_power;

    @FXML
    private Label field_for_result;

    @FXML
    private Button Button_log;

    @FXML
    private Label field_for_error;

    @FXML
    private Button Build_Graphic;

    @FXML
    void initialize() {

        Build_Graphic.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Graph_Function.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1, 780, 589));
                stage1.setResizable(false);
                stage1.show();
            } catch (Exception e) {
                //e.printStackTrace();
            }
        });

        Number_one.setOnAction(event ->{
            String temp = field_for_typing.getText();
            temp = temp + "1";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });


        Number_two.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "2";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        Number_three.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "3";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        Number_four.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "4";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        Number_five.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "5";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        Number_six.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "6";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        Number_seven.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "7";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        Number_eight.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "8";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        Number_nine.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "9";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        Number_zero.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "0";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        button_plus.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if (temp.charAt(temp.length() - 1) == '-' || temp.charAt(temp.length() - 1) == '*' || temp.charAt(temp.length() - 1) == '+' || temp.charAt(temp.length() - 1) == '/') {
                temp = BasicCalculator.substituteString(temp, temp.length() - 1, temp.length() - 1 , "+");
                field_for_typing.setText(temp);
            } else {
                temp = temp + "+";
                if (temp.length() == 17){
                    field_for_typing.setFont(new Font("Bold",25));
                } else if (temp.length() == 28){
                    field_for_typing.setFont(new Font("Bold",15));
                }
                field_for_typing.setText(temp);
            }
        });

        button_minus.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if (temp.length() == 0){
                temp = temp + "-";
                if (temp.length() == 17){
                    field_for_typing.setFont(new Font("Bold",25));
                } else if (temp.length() == 28){
                    field_for_typing.setFont(new Font("Bold",15));
                }
                field_for_typing.setText(temp);
            } else if (temp.charAt(temp.length() - 1) == '-' || temp.charAt(temp.length() - 1) == '*' || temp.charAt(temp.length() - 1) == '+' || temp.charAt(temp.length() - 1) == '/') {
                temp = BasicCalculator.substituteString(temp, temp.length() - 1, temp.length() - 1, "-");
                field_for_typing.setText(temp);
            } else {
                temp = temp + "-";
                if (temp.length() == 17){
                    field_for_typing.setFont(new Font("Bold",25));
                } else if (temp.length() == 28){
                    field_for_typing.setFont(new Font("Bold",15));
                }
                field_for_typing.setText(temp);

            }
        });

        button_multiply.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if (temp.charAt(temp.length() - 1) == '-' || temp.charAt(temp.length() - 1) == '*' || temp.charAt(temp.length() - 1) == '+' || temp.charAt(temp.length() - 1) == '/'){
                temp = BasicCalculator.substituteString(temp, temp.length() - 1, temp.length() - 1 , "*");
                field_for_typing.setText(temp);
            } else {
                temp = temp + "*";
                if (temp.length() == 17){
                    field_for_typing.setFont(new Font("Bold",25));
                } else if (temp.length() == 28){
                    field_for_typing.setFont(new Font("Bold",15));
                }
                field_for_typing.setText(temp);
            }
        });

        button_divide.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if (temp.charAt(temp.length() - 1) == '-' || temp.charAt(temp.length() - 1) == '*' || temp.charAt(temp.length() - 1) == '+' || temp.charAt(temp.length() - 1) == '/'){
                temp = BasicCalculator.substituteString(temp, temp.length() - 1, temp.length() - 1 , "/");
                field_for_typing.setText(temp);
            } else {
                temp = temp + "/";
                if (temp.length() == 17){
                    field_for_typing.setFont(new Font("Bold",25));
                } else if (temp.length() == 28){
                    field_for_typing.setFont(new Font("Bold",15));
                }
                field_for_typing.setText(temp);
            }
        });

        button_left_quote.setOnAction(event -> {
            String temp = field_for_typing.getText();
            temp = temp + "(";
            if (temp.length() == 17){
                field_for_typing.setFont(new Font("Bold",25));
            } else if (temp.length() == 28){
                field_for_typing.setFont(new Font("Bold",15));
            }
            field_for_typing.setText(temp);
        });

        button_right_quote.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if ((QuoteAnalyser.getNumberOfLeftQuotes(temp) - QuoteAnalyser.getNumberOfRightQuotes(temp) > 0) && (Character.isDigit(temp.charAt(temp.length() - 1)) || temp.charAt(temp.length() - 1) == ')')) {
                temp = temp + ")";
                if (temp.length() == 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                } else if (temp.length() == 28) {
                    field_for_typing.setFont(new Font("Bold", 15));
                }
                field_for_typing.setText(temp);
            }
        });

        button_power.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if(Character.isDigit(temp.charAt(temp.length() - 1)) || temp.charAt(temp.length() - 1) == ')') {
                temp = temp + "^";
                if (temp.length() == 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                } else if (temp.length() == 28) {
                    field_for_typing.setFont(new Font("Bold", 15));
                }
                field_for_typing.setText(temp);
            }
        });

        button_point.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if (Character.isDigit(temp.charAt(temp.length() - 1))) {
                boolean isNumberWithoutPoint = true;
                for (int i = temp.length() - 1; i >= 0; i--){
                    if (temp.charAt(i) == '+' || temp.charAt(i) == '-' || temp.charAt(i) == '*' || temp.charAt(i) == '/' || temp.charAt(i) == '(' || temp.charAt(i) == '^'){
                        break;
                    } else if (temp.charAt(i) == '.'){
                        isNumberWithoutPoint = false;
                        break;
                    }
                }
                if (isNumberWithoutPoint) {
                    temp = temp + ".";
                    if (temp.length() == 17) {
                        field_for_typing.setFont(new Font("Bold", 25));
                    } else if (temp.length() == 28) {
                        field_for_typing.setFont(new Font("Bold", 15));
                    }
                    field_for_typing.setText(temp);
                }
            }
        });

        button_sin.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if (temp.length() == 0 || !Character.isDigit(temp.charAt(temp.length() - 1)) && temp.charAt(temp.length() - 1) != '.') {
                temp = temp + "sin(";
                if (temp.length() >= 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                    if (temp.length() >= 28) {
                        field_for_typing.setFont(new Font("Bold", 15));
                    }
                }
                field_for_typing.setText(temp);
            }
        });

        button_cos.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if(temp.length() == 0 || !Character.isDigit(temp.charAt(temp.length() - 1)) && (temp.charAt(temp.length() - 1) != '.')) {
                temp = temp + "cos(";
                if (temp.length() >= 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                    if (temp.length() >= 28) {
                        field_for_typing.setFont(new Font("Bold", 15));
                    }
                }
                field_for_typing.setText(temp);
            }
        });

        button_tan.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if(temp.length() == 0 || !Character.isDigit(temp.charAt(temp.length() - 1)) && (temp.charAt(temp.length() - 1) != '.')) {
                temp = temp + "tan(";
                if (temp.length() >= 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                    if (temp.length() >= 28) {
                        field_for_typing.setFont(new Font("Bold", 15));
                    }
                }
                field_for_typing.setText(temp);
            }
        });

        button_factorial.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if (Character.isDigit(temp.charAt(temp.length() - 1))) {
                temp = temp + "!";
                if (temp.length() == 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                } else if (temp.length() == 28) {
                    field_for_typing.setFont(new Font("Bold", 15));
                }
                field_for_typing.setText(temp);
            }
        });

        button_exp.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if(temp.length() == 0 || !Character.isDigit(temp.charAt(temp.length() - 1)) && (temp.charAt(temp.length() - 1) != '.')) {
                temp = temp + "exp(";
                if (temp.length() >= 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                    if (temp.length() >= 28) {
                        field_for_typing.setFont(new Font("Bold", 15));
                    }
                }
                field_for_typing.setText(temp);
            }
        });

        Button_ln.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if(temp.length() == 0 || !Character.isDigit(temp.charAt(temp.length() - 1)) && (temp.charAt(temp.length() - 1) != '.')) {
                temp = temp + "ln(";
                if (temp.length() >= 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                    if (temp.length() >= 28) {
                        field_for_typing.setFont(new Font("Bold", 15));
                    }
                }
                field_for_typing.setText(temp);
            }
        });

        Button_log.setOnAction(event -> {
            String temp = field_for_typing.getText();
            if(temp.length() == 0 || !Character.isDigit(temp.charAt(temp.length() - 1)) && (temp.charAt(temp.length() - 1) != '.')) {
                temp = temp + "log(";
                if (temp.length() >= 17) {
                    field_for_typing.setFont(new Font("Bold", 25));
                    if (temp.length() >= 28) {
                        field_for_typing.setFont(new Font("Bold", 15));
                    }
                }
                field_for_typing.setText(temp);
            }
        });

        button_erase_symbol.setOnAction(event -> {
            String temp = field_for_typing.getText();
            String temp2 = "";
            if (temp.length() == 0 || temp.length() == 1){
                field_for_typing.setText("");
                field_for_result.setText("");
            } else if (Character.isDigit(temp.charAt(temp.length() - 1)) && (temp.charAt(temp.length() - 2)) == '.'){
                for (int i = 0; i < temp.length() - 2; i++){
                    temp2 = temp2 + temp.charAt(i);
                }
                field_for_typing.setText(temp2);
            } else if (Character.isAlphabetic(temp.charAt(temp.length() - 2)) && (temp.charAt(temp.length() - 1)) == '('){
                int StepsToErase = 1;
                for (int i = temp.length() - 2; i >= 0; i--){
                    if (Character.isAlphabetic(temp.charAt(i))){
                        ++StepsToErase;
                    } else break;
                }
                for (int i = 0; i < temp.length() - StepsToErase; i++){
                    temp2 = temp2 + temp.charAt(i);
                }
                field_for_typing.setText(temp2);
            } else {
                for (int i = 0; i < temp.length() - 1; i++) {
                    temp2 = temp2 + temp.charAt(i);
                }
                field_for_typing.setText(temp2);
            }
            if (temp2.length() <= 17){
                field_for_typing.setFont(new Font(37));
            }
            if ((temp2.length() >= 18) && (temp2.length() <= 28)) {
                field_for_typing.setFont(new Font(25));
            }
            if (temp2.length() >= 29) {
                field_for_typing.setFont(new Font(15));
            }
            field_for_error.setText("");
        });

        button_erase_all.setOnAction(event -> {
            field_for_typing.setText("");
            field_for_result.setText("");
            field_for_error.setText("");
            field_for_typing.setFont(new Font(37));
        });

        button_equal.setOnAction(event -> {
            String Example = field_for_typing.getText();
            if (QuoteAnalyser.CheckQuotes(Example) && !Example.equals("")) {
                field_for_result.setText(Example + " =");
                String Result = "";
                try {
                    Result = BasicCalculator.Calculate(Example);
                    field_for_typing.setText(Result);
                } catch (IndexOutOfBoundsException e){
                    field_for_error.setText("Error");
                    field_for_typing.setText("");
                }
                    if (Result.length() <= 17) {
                        field_for_typing.setFont(new Font(37));
                    }
                    if ((Result.length() >= 18) && (Result.length() <= 28)) {
                        field_for_typing.setFont(new Font(25));
                    }
                    if (Result.length() >= 29) {
                        field_for_typing.setFont(new Font(15));
                    }
            } else {
                field_for_typing.setText("");
                field_for_error.setText("Error");
            }
        });
    }
}

