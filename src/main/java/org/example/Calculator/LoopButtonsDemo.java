package org.example.Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoopButtonsDemo extends JFrame implements ActionListener {
    // Declare an array of JButtons
    private JButton[] buttons;
    private JPanel panel;
    private JLabel label;

    public LoopButtonsDemo() {
        super("Loop Buttons Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        panel = new JPanel(new GridLayout(1, 0)); // Use a layout that fits buttons
        buttons = new JButton[5]; // Create an array for 5 buttons
        
        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton("Button " + (i + 1));
            btn.addActionListener(this);
            btn.setActionCommand("Command" + i); 
            buttons[i] = btn;
            panel.add(btn);
        }
        
        label = new JLabel("Click a button!", SwingConstants.CENTER);
        
        add(panel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the action command of the button that was clicked
        String command = e.getActionCommand();

        // Use if-else if statements or a switch statement (Java 7+) to determine the source
        if (command.equals("Command0")) {
            label.setText("You clicked the first button!");
        } else if (command.equals("Command1")) {
            label.setText("You clicked the second button!");
        } else if (command.equals("Command2")) {
            label.setText("You clicked the third button!");
        } else {
            // A generic message for other buttons
            label.setText("You clicked a different button with command: " + command);
        }
        
        // Alternatively, use e.getSource() to get the object reference
        // if (e.getSource() == buttons[0]) { ... }
    }

    public static void main(String[] args) {
        // Ensure GUI creation is done on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(LoopButtonsDemo::new);
    }
}
