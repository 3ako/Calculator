package calculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class Frame extends JFrame {
    public Frame() {
        MouseAdapter m = new MouseAdapter() {
            int y;
            int x;

            public void mousePressed(MouseEvent e) {
                // запоминаем координаты клика
                x = e.getX();
                y = e.getY();
            }

            public void mouseDragged(MouseEvent e) {
                // двигаем окно
                setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        };
        Interface keyBoard = new Interface();
        setUndecorated(true);
        addMouseMotionListener(m);
        addMouseListener(m);
        setVisible(true);
        add(keyBoard);pack();
        int width = 350;
        int height = 530;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth(); // Ширина монитора
        int screenHeight = gd.getDisplayMode().getHeight(); // Высота монитора
        setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);

    }
}