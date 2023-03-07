import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Calculator {
    private static final int WIDTH = 375, HEIGHT = 308;
    private static final int BTN_WIDTH = 80, BTN_HEIGHT = 35;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6,
            btn7, btn8, btn9, btn0, btnEq, btnAdd,
            btnSub, btnMult, btnDiv, btnMod, btnClear, btnDelete, btnFloat;
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
        text.setBounds(5, 5, 350, 40);
        text.setEditable(false);
        text.setBackground(Color.WHITE);
        text.setFont(new Font("Arial", Font.PLAIN, 30));
        text.setHorizontalAlignment(JTextField.RIGHT);
        main_frame.add(text);

        btn0 = addButton("0", 95, 230, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("0");
                } else {
                    text.setText(text.getText() + "0");
                }
            } else {
                text.setText("0");
                continueWrite = true;
            }
            go = true;
        });

        btn1 = addButton("1", 5, 185, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("1");
                } else {
                    text.setText(text.getText() + "1");
                }
            } else {
                text.setText("1");
                continueWrite = true;
            }
            go = true;
        });

        btn2 = addButton("2", 95, 185, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("2");
                } else {
                    text.setText(text.getText() + "2");
                }
            } else {
                text.setText("2");
                continueWrite = true;
            }
            go = true;
        });

        btn3 = addButton("3", 185, 185, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("3");
                } else {
                    text.setText(text.getText() + "3");
                }
            } else {
                text.setText("3");
                continueWrite = true;
            }
            go = true;
        });

        btn4 = addButton("4", 5, 140, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("4");
                } else {
                    text.setText(text.getText() + "4");
                }
            } else {
                text.setText("4");
                continueWrite = true;
            }
            go = true;
        });

        btn5 = addButton("5", 95, 140, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("5");
                } else {
                    text.setText(text.getText() + "5");
                }
            } else {
                text.setText("5");
                continueWrite = true;
            }
            go = true;
        });

        btn6 = addButton("6", 185, 140, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("6");
                } else {
                    text.setText(text.getText() + "6");
                }
            } else {
                text.setText("6");
                continueWrite = true;
            }
            go = true;
        });

        btn7 = addButton("7", 5, 95, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("7");
                } else {
                    text.setText(text.getText() + "7");
                }
            } else {
                text.setText("7");
                continueWrite = true;
            }
            go = true;
        });

        btn8 = addButton("8", 95, 95, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("8");
                } else {
                    text.setText(text.getText() + "8");
                }
            } else {
                text.setText("8");
                continueWrite = true;
            }
            go = true;
        });

        btn9 = addButton("9", 185, 95, event -> {
            if (continueWrite) {
                if (Pattern.matches("[0]*", text.getText())) {
                    text.setText("9");
                } else {
                    text.setText(text.getText() + "9");
                }
            } else {
                text.setText("9");
                continueWrite = true;
            }
            go = true;
        });

        btnAdd = addButton("+", 275, 230, event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d)|(\\d+)", text.getText())) {
                if (go) {
                    val = calc(val, text.getText(), op);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        text.setText(String.valueOf((int) val));
                    } else {
                        text.setText(String.valueOf(val));
                    }
                    go = false;
                    continueWrite = false;
                }
                op = '+';
            }
        });

        btnSub = addButton("-", 275, 185, event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d)|(\\d+)", text.getText())) {
                if (go) {
                    val = calc(val, text.getText(), op);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        text.setText(String.valueOf((int) val));
                    } else {
                        text.setText(String.valueOf(val));
                    }
                    go = false;
                    continueWrite = false;
                }
                op = '-';
            }
        });

        btnMult = addButton("*", 275, 140, event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d)|(\\d+)", text.getText())) {
                if (go) {
                    val = calc(val, text.getText(), op);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        text.setText(String.valueOf((int) val));
                    } else {
                        text.setText(String.valueOf(val));
                    }
                    go = false;
                    continueWrite = false;
                }
                op = '*';
            }
        });

        btnDiv = addButton("/", 275, 95, event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d)|(\\d+)", text.getText())) {
                if (go) {
                    val = calc(val, text.getText(), op);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        text.setText(String.valueOf((int) val));
                    } else {
                        text.setText(String.valueOf(val));
                    }
                    go = false;
                    continueWrite = false;
                }
                op = '/';
            }
        });

        btnMod = addButton("%", 5, 50, event-> {
            if (Pattern.matches("([-]?\\d+[.]\\d)|(\\d+)", text.getText())) {
                if (go) {
                    val = calc(val, text.getText(), op);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        text.setText(String.valueOf((int) val));
                    } else {
                        text.setText(String.valueOf(val));
                    }
                    go = false;
                    continueWrite = false;
                    op = '%';
                }
            }
        });

        btnEq = addButton("=", 275, 50, event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d)|(\\d+)", text.getText())) {
                if (go) {
                    val = calc(val, text.getText(), op);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        text.setText(String.valueOf((int) val));
                    } else {
                        text.setText(String.valueOf(val));
                    }
                    op = '=';
                    continueWrite = false;
                }
            }
        });

        btnClear = addButton("C", 95, 50, event->{
            text.setText("0");
            val = 0; op = ' ';
        });

        btnDelete = addButton("<-", 185, 50, event->{
            String line = text.getText();
            StringBuilder line2 = new StringBuilder();
            for (int i = 0; i < line.length()-1; i++) {
                line2.append(line.charAt(i));
            }
            if (line2.equals("")) {
                text.setText("0");
            } else {
                text.setText(line2.toString());
            }
        });

        btnFloat = addButton(".", 185, 230, event->{
            if (continueWrite) {
                if(!text.getText().contains(".")) {
                    text.setText(text.getText()+".");
                }
            } else {
                text.setText("0.");
                continueWrite = true;
            }
            go = true;
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
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '%':
                return x % y;
            default:
                return y;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
