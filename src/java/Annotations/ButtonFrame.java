package java.Annotations;

import javax.swing.*;
import java.awt.*;


public class ButtonFrame extends JFrame {
    private static final int DEFAULT_WIDTH =600;
    private static final int DEFAULT_HEGHT=600;
    private JPanel panel;
    private JButton redbutton;
    private JButton bluebutton;
    private JButton yellowbutton;
    private JButton printbutton;
    private JLabel label;
    public ButtonFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEGHT);
        panel = new JPanel();
        add(panel);
        redbutton = new JButton("red");
        bluebutton = new JButton("blue");
        yellowbutton = new JButton("yellow");
        printbutton = new JButton("print");
        label = new JLabel("HELLO");
        panel.add(redbutton);
        panel.add(bluebutton);
        panel.add(yellowbutton);
        panel.add(printbutton);
        //label.setText("hello");
        setVisible(true);
        ActionListenerInstaller.processAnnotations(this);
    }
    @ActionListenerFor(source = "yellowbutton")
    public void yellowbackgroud(){
        panel.setBackground(Color.YELLOW);
    }
    @ActionListenerFor(source = "redbutton")
    public void redbackgroud(){
        panel.setBackground(Color.RED);
    }
    @ActionListenerFor(source = "bluebutton")
    public void bluebackgroud(){
        panel.setBackground(Color.BLUE);
    }
    @PrinlnAnno(print = "printbutton")
    public void print(){
        panel.add(label);
        //panel.setBackground(Color.BLACK);
    }
}
