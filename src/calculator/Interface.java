package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class Interface extends JPanel {
    private boolean status;
    private Display display;
    private BigDecimal result;
    private String lastCommand;
    private KeyBoard keyBoard;
    private Display historyDisplay;
    public Interface() {

        setLayout( new BorderLayout()); //Расположение

        //Обработчики
        ActionListener insert = new Insert();
        ActionListener command = new Command();

        keyBoard = new KeyBoard(4,5); // Клавиатура

        //Заполняем клавиатуру
        keyBoard.placeKeyBoardButton("C", command,new Color(28, 28, 28));
        keyBoard.placeKeyBoardButton("7", insert,Color.black);
        keyBoard.placeKeyBoardButton("8", insert,Color.black);
        keyBoard.placeKeyBoardButton("9", insert,Color.black);
        keyBoard.placeKeyBoardButton("÷", command,new Color(28, 28, 28));
        keyBoard.placeKeyBoardButton("²√", command,new Color(28, 28, 28));
        keyBoard.placeKeyBoardButton("4", insert,Color.black);
        keyBoard.placeKeyBoardButton("5", insert,Color.black);
        keyBoard.placeKeyBoardButton("6", insert,Color.black);
        keyBoard.placeKeyBoardButton("*", command,new Color(28, 28, 28));
        keyBoard.placeKeyBoardButton("x²", command,new Color(28, 28, 28));
        keyBoard.placeKeyBoardButton("1", insert,Color.black);
        keyBoard.placeKeyBoardButton("2", insert,Color.black);
        keyBoard.placeKeyBoardButton("3", insert,Color.black);
        keyBoard.placeKeyBoardButton("–", command,new Color(28, 28, 28));
        keyBoard.placeKeyBoardButton("|x|", command,new Color(28, 28, 28));
        keyBoard.placeKeyBoardButton("0", insert,Color.black);
        keyBoard.placeKeyBoardButton(".", insert,Color.black);
        keyBoard.placeKeyBoardButton("=", command,new Color(22, 54, 32));
        keyBoard.placeKeyBoardButton("+", command,new Color(28, 28, 28));
        historyDisplay = new Display("");
        display = new Display("0"); // Дисплей
        add(historyDisplay.getDisplay(), BorderLayout.NORTH);
        add(display.getDisplay(),BorderLayout.CENTER);

        add(keyBoard.getKeyboard(),BorderLayout.SOUTH);
        historyDisplay.setFontSize(15);


        setDefaultCondition();
    }

    private class Insert implements ActionListener {
        //Обрабатываем действия (action)
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (status) {
                display.setText("");
                status = false;
            }
            display.setText(display.getText() + input);
        }
    }

    private class Command implements ActionListener {
        //Обрабатываем команды
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (command.equals("C")){
                setDefaultCondition();
            }
//            else if (command.equals("x²")) {
//                lastCommand = command;
//                calculate(new BigDecimal(display.getText()));
//            }
            else if (command.equals("²√")) {
                lastCommand = command;
                calculate(new BigDecimal(display.getText()));
            } else if (command.equals("|x|")) {
                lastCommand = command;
                calculate(new BigDecimal(display.getText()));
            } else if (status) {
                lastCommand = command;

            } else {
                calculate(new BigDecimal(display.getText()));
                lastCommand = command;
                status = true;
            }
        }
    }
    public void calculate(BigDecimal x) {
        // Обработчик команд
        if (!lastCommand.equals("="))
            historyDisplay.setText((!lastCommand.equals("²√") && !lastCommand.equals("x²") && !lastCommand.equals("|x|")?result.toString():"")+" "+lastCommand+" "+x.toString()+" =");
        if (lastCommand.equals("+"))
            result = result.add(x);
        else if (lastCommand.equals("–"))
            result = result.subtract(x);
        else if (lastCommand.equals("÷"))
            result = result.divide(x, 5, RoundingMode.HALF_EVEN);
        else if (lastCommand.equals("=")) {
//            historyDisplay.setText("");
            result = x;
        }else if (lastCommand.equals("²√")){
            result = x.sqrt(new MathContext(2));
        }
        else if (lastCommand.equals("*"))
            result = result.multiply(x);
        else if (lastCommand.equals("|x|")){
            result = x.abs();
        }
        else if (lastCommand.equals("x²")) {
//                result = x;
            if (x.intValue() == 0){
                result = new BigDecimal(1);
            }else{
                BigDecimal val = new BigDecimal(result.intValue());
                for (int count = 1; count < x.intValue(); count = count + 1) {
                    result = result.multiply(val);
                    System.out.println(result.toString());
                }
            }
//            System.out.println(result.toString());
        }
        if (result.compareTo(BigDecimal.ZERO) == 0)
            result = BigDecimal.ZERO;
        display.setText(result.toString());
    }
    public void setDefaultCondition(){
        //Ставим стандартные значения калькулятора
        result = BigDecimal.ZERO;
        lastCommand = "=";
        status = true;
        display.setText("0");
        historyDisplay.setText("");
    }
}