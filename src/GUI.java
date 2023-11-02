import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    private JTextField[] inputField = new JTextField[3];
    private JLabel[] x = new JLabel[3];
    private JButton submit;
    private JLabel answer;

    public Calculate calculate = new Calculate();

    public GUI() {
        frame = new JFrame();
        label = new JLabel();

        label.setText("Insert 3 values:");
        label.setHorizontalAlignment(JLabel.CENTER);

        // input fields
        for (int i = 0; i < 3; i++) {
            inputField[i] = new JTextField();
            x[i] = new JLabel();
            inputField[i].setPreferredSize(new Dimension(0, 25));
            inputField[i].setColumns(3);
            inputField[i].setHorizontalAlignment(JTextField.CENTER);
        }
        x[0].setText("<html>x<sup>2</sup></html>");
        x[1].setText("<html>x</html>");
        x[2].setText("<html>constant</html>");

        submit = new JButton("Submit");
        submit.addActionListener(this);

        answer = new JLabel();

        // panel
        panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        int panelSizeX = 25;
        int panelSizeY = 5;

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setPreferredSize(new Dimension(225, 25));
        labelPanel.add(label);
        panel.add(labelPanel);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, panelSizeY, panelSizeX));
        inputPanel.add(inputField[0]);
        inputPanel.add(x[0]);
        inputPanel.add(inputField[1]);
        inputPanel.add(x[1]);
        inputPanel.add(inputField[2]);
        inputPanel.add(x[2]);
        inputPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        panel.add(inputPanel);

        JPanel answerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        answerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, panelSizeY, panelSizeX));
        answerPanel.add(answer);
        panel.add(answerPanel);

        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, panelSizeY, panelSizeX));
        submitPanel.add(submit);
        panel.add(submitPanel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("quad calc");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
        System.out.println("Program executed successfully :3");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] s = new String[3];
        double[] num = new double[3];
        try {
            for (int i = 0; i < 3; i++) {
                s[i] = inputField[i].getText();

                if (s[i].equals("")) {
                    num[i] = 0;
                } else {
                    num[i] = Double.parseDouble(s[i]);
                }

            }
        } catch (NumberFormatException exception) {
            answer.setText("please enter numbers :3");

        }
        // setting vars to calculate
        double a, b, c;
        a = num[0];
        b = num[1];
        c = num[2];

        if (a == 0 && b == 0 && c == 0) {
            answer.setText("please enter numbers :3");
        } else if (a == 0 && b == 0) {
            answer.setText("cannot calculate with just a constant :3");
        } else if (a == 0) {
            answer.setText(calculate.linear(b, c));
        } else if (b == 0) {
            answer.setText(calculate.squared(a, c));
        } else {
            answer.setText(calculate.quadratics(a, b, c));
        }

    }
}