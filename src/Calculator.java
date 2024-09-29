import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private String displayText;
    private boolean showingResult;
    private JPanel panelBody;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a0Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton dotBtn;
    private JTextPane displayUnit;
    private JButton divBtn;
    private JButton mulBtn;
    private JButton minusBtn;
    private JButton plusBtn;
    private JButton calcButton;
    private JButton ACButton;

    public Calculator() {
        //setting initial values
        showingResult = false;
        displayText = "";
        displayUnit.setText("");

        //window setup
        setTitle("Calculator");
        setMinimumSize(new Dimension(250, 350));
        setMaximumSize(new Dimension(400, 500));
        setContentPane(panelBody);
        pack();
        setVisible(true);

        ActionListener listener = this::handleButtonPressOnDisplay;

        ACButton.addActionListener(listener);
        divBtn.addActionListener(listener);
        a7Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a1Button.addActionListener(listener);
        a0Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        dotBtn.addActionListener(listener);
        mulBtn.addActionListener(listener);
        minusBtn.addActionListener(listener);
        plusBtn.addActionListener(listener);
        calcButton.addActionListener(listener);
    }

    private void handleButtonPressOnDisplay(ActionEvent e) {
        if (e.getSource() == divBtn) {
            displayAppend('/');
        }
        if (e.getSource() == mulBtn) {
            displayAppend('*');
        }
        if (e.getSource() == plusBtn) {
            displayAppend('+');
        }
        if (e.getSource() == minusBtn) {
            displayAppend('-');
        }
        if (e.getSource() == a8Button) {
            displayAppend('8');
        }
        if (e.getSource() == a9Button) {
            displayAppend('9');
        }
        if (e.getSource() == a7Button) {
            displayAppend('7');
        }
        if (e.getSource() == a6Button) {
            displayAppend('6');
        }
        if (e.getSource() == a5Button) {
            displayAppend('5');
        }
        if (e.getSource() == a4Button) {
            displayAppend('4');
        }
        if (e.getSource() == a3Button) {
            displayAppend('3');
        }
        if (e.getSource() == a2Button) {
            displayAppend('2');
        }
        if (e.getSource() == a1Button) {
            displayAppend('1');
        }
        if (e.getSource() == a0Button) {
            displayAppend('0');
        }
        if (e.getSource() == dotBtn) {
            displayAppend('.');
        }
        if (e.getSource() == calcButton) {
            calculateEquation();
        }
        if (e.getSource() == ACButton) {
            displayText = "";
            updateDisplay();
        }
    }

    private void calculateEquation() {
        try {
            showingResult = true;
            System.out.println(displayText);
            String[] matcher = displayText.split("[+\\-*/]");
            double num1 = Double.parseDouble(matcher[0]);
            double num2 = Double.parseDouble(matcher[1]);

            String op = displayText.indexOf('+') != -1 ? "+" : displayText.indexOf('-') != -1 ? "-" : displayText.indexOf('*') != -1 ? "*" : displayText.indexOf('/') != -1 ? "/" : "";

            switch (op) {
                case "+" -> displayText = String.valueOf((num1 + num2));
                case "-" -> displayText = String.valueOf((num1 - num2));
                case "/" -> displayText = String.valueOf((num2 / num1));
                case "*" -> displayText = String.valueOf((num1 * num2));
                default -> displayText = "Syntax Error";
            }
            updateDisplay();
        } catch (Exception e) {
            displayText = "Something Went Wrong!";
            showingResult = true;
            updateDisplay();
        }

    }

    private void displayAppend(char ch) {
        if (showingResult) displayText = "";
        showingResult = false;
        displayText = displayText + ch;
        updateDisplay();
    }

    private void updateDisplay() {
        displayUnit.setText(displayText);
    }

}
