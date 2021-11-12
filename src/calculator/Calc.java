package calculator;

import javax.swing.*;
import java.awt.*;
public class Calc {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frame frame = new Frame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Закрыл окно - закрыл программу
                frame.setBackground(Color.GRAY);
                frame.setVisible(true);
            }
        });
    }
}