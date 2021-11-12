package calculator;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JLabel display;
    private int fontsize = 70;
    private String text;
    public Display(String text){
        this.text = text;
        display = new JLabel(this.text,SwingConstants.CENTER);
        display.setBackground(Color.DARK_GRAY);
        display.setEnabled(false);
//        display.setFont(display.getFont().deriveFont(100f));
        display.setFont(new Font("Arial",Font.PLAIN,fontsize));
        display.setOpaque(true);
        display.setBackground(new Color(22, 54, 32));
        display.setPreferredSize(new Dimension(350, 50));
    }

    public JLabel getDisplay() {
        return display;
    }
    public void setText(String text){
        this.text = text;
        display.setText(text);
    }
    public void setFontSize(int fontsize){
        this.fontsize = fontsize;
        display.setFont(new Font("Arial",Font.PLAIN,fontsize));
    }
    public String getText(){
        return display.getText();
    }
}
