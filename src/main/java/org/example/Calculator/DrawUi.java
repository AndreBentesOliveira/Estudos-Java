package org.example.Calculator;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrawUi extends JFrame implements ActionListener{

    private JButton[] buttonsArray;

    public DrawUi(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 550);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        buttonsArray = new JButton[20];
        
        Border mainBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        GridLayout mainGrid = new GridLayout(3, 3, 5, 5);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(mainBorder);
        contentPanel.setPreferredSize(new Dimension(400, 500));
        contentPanel.setBackground(Color.gray);
        contentPanel.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.lightGray);
        topPanel.setPreferredSize(new Dimension(100, 50));
        topPanel.setLayout(new BorderLayout());
        JLabel numberLabel = new JLabel("1000", SwingConstants.CENTER);

        JPanel midPanel = new JPanel();
        midPanel.setBackground(Color.blue); 
        midPanel.setLayout(new BorderLayout(10,10));
        midPanel.setBounds(0, 100, 100, 400);
        midPanel.setBorder(mainBorder);
        
        JPanel buttonsPanel = new JPanel();
        //buttonsPanel.setBackground(Color.red);
        buttonsPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonsPanel.setBounds(0, 0, 50, 100);
        buttonsPanel.setBorder(mainBorder);

        JPanel operatorsPanel = new JPanel();
        operatorsPanel.setBackground(Color.MAGENTA);
        operatorsPanel.setLayout(new GridLayout(4, 1, 5, 30));
        operatorsPanel.setBounds(100, 100, 100, 100);
        operatorsPanel.setBorder(mainBorder);

        JPanel topButtonsPanel = new JPanel();
        topButtonsPanel.setBackground(Color.cyan);
        topButtonsPanel.setLayout(new GridLayout(1, 4, 10, 5));
        topButtonsPanel.setBounds(0, 0, 100, 100);
        topButtonsPanel.setBorder(mainBorder);

        String[] buttonsLabel = {
            "CE", "back", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "=",
        };

        for (int i = 0; i <= 19; i++) {
            /*JButton button = new JButton();
            button.setFocusable(false);
            button.setText(buttonsLabel[i]);
            System.out.println("Command" + buttonsLabel[i]);
            button.setActionCommand("Command" + buttonsLabel[i]);
            button.setPreferredSize(new Dimension(50, 50));
            buttonsPanel.add(button);*/

            JButton btn = new JButton("Button " + (i + 1));
            btn.addActionListener(this);
            btn.setActionCommand("Command" + buttonsLabel[i]);
            buttonsArray[i] = btn;
            buttonsPanel.add(btn);
            //buttonsPanel.add(new JButton(String.valueOf(i)));
        }

        

        this.add(contentPanel);
        topPanel.add(numberLabel, BorderLayout.CENTER);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(midPanel, BorderLayout.CENTER);
        midPanel.add(buttonsPanel, BorderLayout.CENTER);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("CommandCE")) {
            System.out.println(e.getSource() + e.getActionCommand());
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    
    }
}
