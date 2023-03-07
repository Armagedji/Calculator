import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Calculator {
    private static final int WIDTH=350, HEIGHT=500;
    private static final int BTN_WIDTH=80, BTN_HEIGHT=35;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnEq,btnAdd,btnSub,btnMult,btnDiv;
    private JTextField text;
    private JFrame main_frame;
    private boolean continueWrite = true, go = true;
    private char op = ' ';
    private double val = 0;

    public Calculator() {
        main_frame = new JFrame("Calculator");
        main_frame.setSize(WIDTH, HEIGHT);
        main_frame.setLocationRelativeTo(null);

        text = new JTextField("0");
        text.setBounds(5, 5, 325,40);
        text.setEditable(false);
        text.setBackground(Color.WHITE);
        text.setFont(new Font("Arial", Font.PLAIN, 30));
        text.setHorizontalAlignment(JTextField.RIGHT);
        main_frame.add(text);

        btn0=addButton("0",5, 50, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("0");
                } else {
                    text.setText(text.getText()+"0");
                }
            } else {text.setText("0"); continueWrite=true;}
            go = true;
        });

        btn1=addButton("1",95, 50, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("1");
                } else {
                    text.setText(text.getText()+"1");
                }
            } else {text.setText("1"); continueWrite=true;}
            go = true;
        });

        btn2=addButton("2",185, 50, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("2");
                } else {
                    text.setText(text.getText()+"2");
                }
            } else {text.setText("2"); continueWrite=true;}
            go = true;
        });

        btn3=addButton("3",5, 95, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("3");
                } else {
                    text.setText(text.getText()+"3");
                }
            } else {text.setText("3"); continueWrite=true;}
            go = true;
        });

        btn4=addButton("4",95, 95, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("4");
                } else {
                    text.setText(text.getText()+"4");
                }
            } else {text.setText("4"); continueWrite=true;}
            go = true;
        });

        btn5=addButton("5",185, 95, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("5");
                } else {
                    text.setText(text.getText()+"5");
                }
            } else {text.setText("5"); continueWrite=true;}
            go = true;
        });

        btn6=addButton("6",5, 140, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("6");
                } else {
                    text.setText(text.getText()+"6");
                }
            } else {text.setText("6"); continueWrite=true;}
            go = true;
        });

        btn7=addButton("7",95, 140, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("7");
                } else {
                    text.setText(text.getText()+"7");
                }
            } else {text.setText("7"); continueWrite=true;}
            go = true;
        });

        btn8=addButton("8",185, 140, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("8");
                } else {
                    text.setText(text.getText()+"8");
                }
            } else {
                text.setText("8"); continueWrite=true;}
            go = true;
        });

        btn9=addButton("9",5, 185, event->{
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("9");
                } else {
                    text.setText(text.getText()+"9");
                }
            } else {text.setText("9"); continueWrite=true;}
            go = true;
        });

        btnAdd=addButton("+", 5, 250,event->{
            if (go) {
                val = calc(val, text.getText(),op);
                if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                    text.setText(String.valueOf((int) val));
                } else {
                    text.setText(String.valueOf(val));
                }
                go = false;
                continueWrite = false;
                op = '+';
            } else {
                op = '+';
            }
        });

        main_frame.setLayout(null);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setResizable(false);
        main_frame.setVisible(true);

    }
    private JButton addButton(String name, int x, int y, ActionListener event) {
        JButton btn = new JButton(name);
        btn.setBounds(x, y, BTN_WIDTH, BTN_HEIGHT);
        btn.addActionListener(event);
        btn.setFocusable(false);
        btn.setFont(new Font("Arial", Font.PLAIN, 25));
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
