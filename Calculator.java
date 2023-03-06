import javax.swing.*;
import java.awt.event.ActionListener;

public class Calculator {
    private static final int WIDTH=350, HEIGHT=500;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnEq,btnAdd,btnSub,btnMult,btnDiv;
    private JTextField text;
    private JFrame main_frame;

    public Calculator() {
        main_frame = new JFrame("Calculator");
        main_frame.setSize(WIDTH, HEIGHT);
        main_frame.setLocationRelativeTo(null);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setVisible(true);


    }
    private JButton addButton(String name, int x, int y, ActionListener event) {
        JButton btn = new JButton(name);
        btn.setBounds(x, y, WIDTH, HEIGHT);
        btn.addActionListener(event);
        btn.setFocusable(false);
        main_frame.add(btn);

        return btn;
    }
    public double calc(double x, String input, char op) {
        double y = Double.parseDouble(input);
        switch (op) {
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '*':
                return x*y;
            case '/':
                return x/y;
            case '%':
                return x%y;
            case '^':
                return Math.pow(x, y);
            default:
                return y;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
