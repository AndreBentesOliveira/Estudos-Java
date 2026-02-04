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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrawUi extends JFrame implements ActionListener{
    public DrawUi(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        JPanel contentPanel = new JPanel();
        Border mainBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        contentPanel.setBorder(mainBorder);
        contentPanel.setPreferredSize(new Dimension(300, 400));
        contentPanel.setBackground(Color.gray);
        contentPanel.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.lightGray);
        topPanel.setPreferredSize(new Dimension(100, 50));
        topPanel.setLayout(new BorderLayout());
        JLabel numberLabel = new JLabel("1000", SwingConstants.CENTER);

        JPanel midPanel = new JPanel();
        midPanel.setBackground(Color.blue); 
        midPanel.setLayout(new BorderLayout());
        midPanel.setBounds(0, 100, 100, 400);
        midPanel.setBorder(mainBorder);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.red);
        buttonsPanel.setLayout(new GridLayout(3, 3, 5, 5));
        //buttonsPanel.setBounds(0, 0, 50, 50);
        buttonsPanel.setBorder(mainBorder);

        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton();
            button.setText(String.valueOf(i));
            button.setPreferredSize(new Dimension(1, 1));
            buttonsPanel.add(button);
            //buttonsPanel.add(new JButton(String.valueOf(i)));
        }

        topPanel.add(numberLabel, BorderLayout.CENTER);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(midPanel);
        midPanel.add(buttonsPanel);
        /*panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));*/

        this.add(contentPanel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
