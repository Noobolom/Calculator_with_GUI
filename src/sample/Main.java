package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Reader {

    static List<Character> readSigns(String Example, int Begin, int End) {
        List<Character> Signs = new ArrayList<>();
        String SubExample = Example.substring(Begin, End);
        Pattern pattern = Pattern.compile(".[+*\\-/]");
        Matcher matcher = pattern.matcher(SubExample);
        while (matcher.find()) {
            String Sign = matcher.group();
            if (Character.isDigit(Sign.charAt(0))) {
                Signs.add(Sign.charAt(1));
            }
        }
        return Signs;
    }

    static List<Double> readNumbers(String Example, int Begin, int End){
        List <Double> Numbers = new ArrayList<>();
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',','.');
        Pattern pattern = Pattern.compile("(([(+\\-*/^]\\-)?)[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?"); // Symbols at 0 and 1 indexes may be [+-*/]
        Matcher matcher = pattern.matcher(SubExample);
        while(matcher.find()){
            String Number = matcher.group();
            if (Number.length() == 1) {
                Numbers.add(Double.parseDouble(Number));
            }
            else if (Character.isDigit(Number.charAt(1)) || Number.charAt(1) == '.') {
                Numbers.add(Double.parseDouble(Number));
            } else {
                char[] str = Number.toCharArray();
                str[0] = ' ';
                Number = new String(str);
                Numbers.add(Double.parseDouble(Number));
            }
        }
        return Numbers;
    }
}

class QuoteAnalyser {

    static boolean CheckQuotes (String Example){
        if((QuoteAnalyser.getNumberOfQuotes(Example) & 1) != 0){
            return false;
        }
        int count_left_quotes = 0;
        int count_right_quotes = 0;
        for (int i = 0 ; i< Example.length(); i++){
            if (Example.charAt(i) == '('){
                count_left_quotes++;
            }
            if (Example.charAt(i) == ')'){
                count_right_quotes++;
            }
        }
        return count_left_quotes == count_right_quotes;
    }

    static int getNumberOfLeftQuotes (String Example){
        int count_left_quotes = 0;
        for (int i = 0 ; i< Example.length(); i++){
            if (Example.charAt(i) == '('){
                count_left_quotes++;
            }
        }
        return count_left_quotes;
    }

    static int getNumberOfRightQuotes (String Example){
        int count_right_quotes = 0;
        for (int i = 0 ; i< Example.length(); i++){
            if (Example.charAt(i) == ')'){
                count_right_quotes++;
            }
        }
        return count_right_quotes;
    }

    static int getNumberOfQuotes(String Example){
        int count_left_quotes = 0;
        int count_right_quotes = 0;
        for (int i = 0 ; i< Example.length(); i++){
            if (Example.charAt(i) == '('){
                count_left_quotes++;
            }
            if (Example.charAt(i) == ')'){
                count_right_quotes++;
            }
        }
        return count_left_quotes + count_right_quotes;                                            // Return general count of quotes
    }

    static int[] getCouplesOfQuotes(String Example){
        Pattern pattern = Pattern.compile("\\([0-9a-zA-Z\\-+*/![^()]]*\\)");
        Matcher matcher = pattern.matcher(Example);
        int BeginOfExpression;
        int EndOfExpression;
        int[] Quotes = new int[2];
        if(matcher.find()){
            String Expression = matcher.group(0);
            BeginOfExpression = Example.indexOf(Expression);
            EndOfExpression = BeginOfExpression + Expression.length() - 1;
        } else return null;
        Quotes[0] = BeginOfExpression;
        Quotes[1] = EndOfExpression;
        return Quotes;
    }
}

class Operations {

    private static String calculateSin (String Example, int Begin, int End) {
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',', '.');
        SubExample = SubExample.toLowerCase();
        Pattern pattern = Pattern.compile("sin\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?");
        Matcher matcher= pattern.matcher(SubExample);
        while (matcher.find()) {
            String Result = matcher.group();
            int BeginToInsert = Example.indexOf(Result);
            int EndToInsert = BeginToInsert + Result.length() - 1;
            char[] str = Result.toCharArray();
            str[0] = ' ';
            str[1] = ' ';
            str[2] = ' ';
            Result = new String(str);
            double DResult = Math.sin(Double.parseDouble(Result));
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

    private static String calculateCos (String Example, int Begin, int End) {
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',', '.');
        SubExample = SubExample.toLowerCase();
        Pattern pattern = Pattern.compile("cos\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?");
        Matcher matcher= pattern.matcher(SubExample);
        while (matcher.find()) {
            String Result = matcher.group();
            int BeginToInsert = Example.indexOf(Result);
            int EndToInsert = BeginToInsert + Result.length() - 1;
            char[] str = Result.toCharArray();
            str[0] = ' ';
            str[1] = ' ';
            str[2] = ' ';
            Result = new String(str);
            double DResult = Math.cos(Double.parseDouble(Result));
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

    private static String calculateTan (String Example, int Begin, int End) {
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',', '.');
        SubExample = SubExample.toLowerCase();
        Pattern pattern = Pattern.compile("tan\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?");
        Matcher matcher = pattern.matcher(SubExample);
        while (matcher.find()) {
            String Result = matcher.group();
            int BeginToInsert = Example.indexOf(Result);
            int EndToInsert = BeginToInsert + Result.length() - 1;
            char[] str = Result.toCharArray();
            str[0] = ' ';
            str[1] = ' ';
            str[2] = ' ';
            Result = new String(str);
            double DResult = Math.tan(Double.parseDouble(Result));
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

    private static double Factorial(int n){
        double result = 1;
        if (n == 0) return 0;
        else {
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        }
        return result;
    }

    static String calculateFactorials (String Example, int Begin, int End) {
        String SubExample = Example.substring(Begin, End);
        Pattern pattern = Pattern.compile("[0-9]+(\\.([0-9])*)?!");
        Matcher matcher= pattern.matcher(SubExample);
        while (matcher.find()) {
            String Result = matcher.group();
            int BeginToInsert = Example.indexOf(Result);
            int EndToInsert = BeginToInsert + Result.length() - 1;
            int Length = Result.length();
            char[] str = Result.toCharArray();
            str[Length - 1] = ' ';
            Result = new String(str);
            double DResult = Factorial((int)Double.parseDouble(Result));
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

    static String calculateTrigonometry(String Example){
        int[] Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
        Example = calculateSin(Example, Quotes[0], Quotes[1]);
        Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
        Example = calculateCos(Example, Quotes[0], Quotes[1]);
        Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
        Example = calculateTan(Example, Quotes[0], Quotes[1]);
        return Example;
    }

    static String calculateSquare (String Example, int Begin, int End) {
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',', '.');
        Pattern patternAll = Pattern.compile("\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?\\^\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?");
        Pattern patternLeft = Pattern.compile("\\-?([0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?)\\^");
        Pattern patternRight = Pattern.compile("\\^\\-?([0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?)");
        Matcher matcherAll = patternAll.matcher(SubExample);
        Matcher matcherLeft = patternLeft.matcher(SubExample);
        Matcher matcherRight = patternRight.matcher(SubExample);
        while (matcherLeft.find() && matcherRight.find() && matcherAll.find()) {
            String Number = matcherLeft.group();
            String Power = matcherRight.group();
            String AllExpression = matcherAll.group();
            int BeginToInsert = Example.indexOf(AllExpression);
            int EndToInsert = BeginToInsert + AllExpression.length() - 1;
            char[] strN = Number.toCharArray();
            strN[strN.length - 1] = ' ';
            Number = new String(strN);
            char[] strP = Power.toCharArray();
            strP[0] = ' ';
            Power = new String(strP);
            double DResult = Math.pow(Double.parseDouble(Number), Double.parseDouble(Power));
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

    static String calculateSquareRoot (String Example, int Begin, int End) {
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',', '.');
        SubExample = SubExample.toLowerCase();
        Pattern pattern = Pattern.compile("sqrt\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?");
        Matcher matcher= pattern.matcher(SubExample);
        while (matcher.find()) {
            String Result = matcher.group();
            int BeginToInsert = Example.indexOf(Result);
            int EndToInsert = BeginToInsert + Result.length() - 1;
            char[] str = Result.toCharArray();
            str[0] = ' ';
            str[1] = ' ';
            str[2] = ' ';
            str[3] = ' ';
            Result = new String(str);
            double DResult = 0;
            if (Double.parseDouble(Result) >= 0) {
                DResult = Math.sqrt(Double.parseDouble(Result));
            }
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

    static String calculateNaturalLogarithm (String Example, int Begin, int End) {
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',', '.');
        SubExample = SubExample.toLowerCase();
        Pattern pattern = Pattern.compile("ln\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?");
        Matcher matcher= pattern.matcher(SubExample);
        while (matcher.find()) {
            String Result = matcher.group();
            int BeginToInsert = Example.indexOf(Result);
            int EndToInsert = BeginToInsert + Result.length() - 1;
            char[] str = Result.toCharArray();
            str[0] = ' ';
            str[1] = ' ';
            Result = new String(str);
            double DResult = Math.log(Double.parseDouble(Result));
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

    static String calculateDecimalLogarithm (String Example, int Begin, int End){
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',', '.');
        SubExample = SubExample.toLowerCase();
        Pattern pattern = Pattern.compile("log\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?");
        Matcher matcher= pattern.matcher(SubExample);
        while (matcher.find()) {
            String Result = matcher.group();
            int BeginToInsert = Example.indexOf(Result);
            int EndToInsert = BeginToInsert + Result.length() - 1;
            char[] str = Result.toCharArray();
            str[0] = ' ';
            str[1] = ' ';
            str[2] = ' ';
            Result = new String(str);
            double DResult = 0;
            if (Double.parseDouble(Result) > 0){
                DResult = Math.log10(Double.parseDouble(Result));
            }
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

    static String calculateExp (String Example, int Begin, int End) {
        String SubExample = Example.substring(Begin, End);
        SubExample = SubExample.replace(',', '.');
        Pattern pattern = Pattern.compile("exp\\-?[0-9]+(\\.([0-9])*)?(E[+\\-]?[0-9]+)?");
        Matcher matcher= pattern.matcher(SubExample);
        while (matcher.find()) {
            String Result = matcher.group();
            int BeginToInsert = Example.indexOf(Result);
            int EndToInsert = BeginToInsert + Result.length() - 1;
            char[] str = Result.toCharArray();
            str[0] = ' ';
            str[1] = ' ';
            str[2] = ' ';
            Result = new String(str);
            double DResult = Math.exp(Double.parseDouble(Result));
            Example = BasicCalculator.substituteString(Example, BeginToInsert, EndToInsert, String.valueOf(DResult));
        }
        return Example;
    }

}

class BasicCalculator {

    private static String prepareExample (String Example){
        char[] PreparedExample = new char[Example.length() + 2];
        PreparedExample[0] = '(';
        PreparedExample[PreparedExample.length - 1] = ')';
        for (int i = 1; i < PreparedExample.length - 1; i++){
            PreparedExample[i] = Example.charAt(i - 1);
        }
        Example = new String(PreparedExample);
        return Example;
    }

    static String substituteString(String Example, int Begin, int End, String Result) {     // Ready
        int LengthOfNewString = Example.length();
        int ChangeOfLenght = (End - Begin) + 1;
        LengthOfNewString -= ChangeOfLenght;
        int count = 0;
        String StringOfDouble = Result;
        ChangeOfLenght = StringOfDouble.length();
        LengthOfNewString += ChangeOfLenght;
        int j = 0;
        char[] NewExample = new char[LengthOfNewString];
        for (int i = 0; i < Example.length(); i++) {
            if (i == Begin) {
                while (count != StringOfDouble.length()) {
                    NewExample[i] = StringOfDouble.charAt(count);
                    count++;
                    i++;
                }
                j = i;
                i = End;
            } else if (i > End) {
                NewExample[j] = Example.charAt(i);
                j++;
            } else NewExample[i] = Example.charAt(i);
        }
        return new String(NewExample);
    }

    static String Calculate(String Example){
        double ResultOfOperation = 0.0;
        Example = prepareExample(Example);
        int[] Quotes;
        List<Double> Numbers;
        List<Character> Signs;
        int i = 0;
        int NumberOfCycles = QuoteAnalyser.getNumberOfQuotes(Example) / 2;
        while(NumberOfCycles != 0) {
            Example = Example.replaceAll("\\-\\-", "+");
            Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
            Example = Operations.calculateSquare(Example, Quotes[i], Quotes[i + 1]);
            Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
            Example = Operations.calculateSquareRoot(Example, Quotes[i], Quotes[i + 1]);
            Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
            Example = Operations.calculateFactorials(Example, Quotes[i], Quotes[i + 1]);
            Example = Operations.calculateTrigonometry(Example);
            Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
            Example = Operations.calculateExp(Example, Quotes[i], Quotes[i + 1]);
            Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
            Example = Operations.calculateNaturalLogarithm(Example, Quotes[i], Quotes[i + 1]);
            Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
            Example = Operations.calculateDecimalLogarithm(Example, Quotes[i], Quotes[i + 1]);
            Quotes = QuoteAnalyser.getCouplesOfQuotes(Example);
            Signs = Reader.readSigns(Example, Quotes[i], Quotes[i + 1]);
            Numbers = Reader.readNumbers(Example, Quotes[i], Quotes[i + 1]);
            if (!Signs.isEmpty()) {
                for (int j = 0; j < Signs.size(); j++) {
                    if (Signs.get(j) == '*') {
                        ResultOfOperation = Numbers.get(j) * Numbers.get(j + 1);
                        Numbers.remove(j);
                        Numbers.remove(j);
                        Numbers.add(j, ResultOfOperation);
                        Signs.remove(j);
                        j--;
                    } else if (Signs.get(j) == '/') {
                        ResultOfOperation = Numbers.get(j) / Numbers.get(j + 1);
                        Numbers.remove(j);
                        Numbers.remove(j);
                        Numbers.add(j, ResultOfOperation);
                        Signs.remove(j);
                        j--;
                    }
                }
                for (int j = 0; j < Signs.size(); j++) {
                    if (Signs.get(j) == '+') {
                        ResultOfOperation = Numbers.get(j) + Numbers.get(j + 1);
                        Numbers.remove(j);
                        Numbers.remove(j);
                        Numbers.add(j, ResultOfOperation);
                        Signs.remove(j);
                        j--;
                    } else if (Signs.get(j) == '-') {
                        ResultOfOperation = Numbers.get(j) - Numbers.get(j + 1);
                        Numbers.remove(j);
                        Numbers.remove(j);
                        Numbers.add(j, ResultOfOperation);
                        Signs.remove(j);
                        j--;
                    }
                }
                Example = substituteString(Example, Quotes[i], Quotes[i + 1], String.valueOf(ResultOfOperation));
                NumberOfCycles--;
            }
            else {
                Example = substituteString(Example, Quotes[i], Quotes[i + 1], String.valueOf(Numbers.get(0)));
                NumberOfCycles--;
            }
        }

        return Example;
    }
}

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Калькулятор");
            primaryStage.setScene(new Scene(root, 377, 386));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e){

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
