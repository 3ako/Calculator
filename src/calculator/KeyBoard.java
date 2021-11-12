package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class KeyBoard{
    private JPanel keyboard;
    private JPanel container;
    public KeyBoard(int rows,int cols){
        keyboard = new JPanel();
        container = new JPanel();
        container.setPreferredSize(new Dimension(350, 380));
        keyboard.setPreferredSize(new Dimension(350, 380));
        container.add(keyboard);
        keyboard.setLayout(new GridLayout(rows, cols));
    }

    public JPanel getKeyboard(){
        return container;
    }
    public void placeKeyBoardButton(String label, ActionListener listener, Color color) {
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        button.setBackground(color);
        button.setForeground(Color.lightGray);
        button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(28, 28, 28)));
        keyboard.add(button);
    }
}
