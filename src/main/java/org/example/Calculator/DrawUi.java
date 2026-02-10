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

    private JLabel numberLabel = new JLabel("", SwingConstants.CENTER);
    private String z, zt;
    private Double result;

    private double num1 = 0, num2 = 0;
    private int op = 0;

    public DrawUi(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 550);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        
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

        String[] buttonsLabel = {
            "CE", "back", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "=",
        };

        for (int i = 0; i <= 19; i++) {
            JButton btn = new JButton(buttonsLabel[i]);
            btn.addActionListener(this);
            btn.setActionCommand("Command" + buttonsLabel[i]);
            buttonsPanel.add(btn);
        }


        this.add(contentPanel);
        topPanel.add(numberLabel, BorderLayout.CENTER);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(midPanel, BorderLayout.CENTER);
        midPanel.add(buttonsPanel, BorderLayout.CENTER);
        this.setVisible(true);

    }

    // funcao para adicionar digitos ao numero exp: 1 + 1 = 11
    public void addNumber(String n){
        zt = numberLabel.getText();
            z = zt + n;
            numberLabel.setText(z);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // numero 1, numero 2 e Operacao exp: -, +, *

        if (command.equals("CommandCE")) {
            z = "";
            numberLabel.setText(z);
            num1 = 0;
            num2 = 0;
            result = 0.0;
        }
        if (command.equals("Commandback")) {
            if (z != null && z.length() > 0){
                z = z.substring(0, z.length() - 1);
                numberLabel.setText(z);
            }
        }
        if (command.equals("Command%")) {
            System.out.println("CE");
        }
        if (command.equals("Command9")) {
           addNumber("9");
        }
        if (command.equals("Command8")) {
            addNumber("8");
        }
        if (command.equals("Command7")) {
           addNumber("7");
        }
        if (command.equals("Command6")) {
            addNumber("6");
        }
        if (command.equals("Command5")) {
            addNumber("5");
        }
        if (command.equals("Command4")) {
            addNumber("4");
        }
        if (command.equals("Command3")) {
            addNumber("3");
        }
        if (command.equals("Command2")) {
            addNumber("2");
        }
        if (command.equals("Command1")) {
            addNumber("1");
        }
        if (command.equals("Command+")) {
            num1 = Double.parseDouble(numberLabel.getText());
            z = "";
            numberLabel.setText(z);
            op = 1;
            System.out.println(op);
        }

         if (command.equals("Command-")) {
            num1 = Double.parseDouble(numberLabel.getText());
            z = "";
            numberLabel.setText(z);
            op = 2;
            System.out.println(op);
        }
          if (command.equals("Command/")) {
            num1 = Double.parseDouble(numberLabel.getText());
            z = "";
            numberLabel.setText(z);
            op = 3;
            System.out.println(op);
        }
          if (command.equals("Command*")) {
            try{
                num1 = Double.parseDouble(numberLabel.getText());
            }catch(NumberFormatException f){
                numberLabel.setText("Invalid Format");
                return;
            }
            z = "";
            numberLabel.setText(z);
            op = 4;
        }

        if (command.equals("Command0")) {
            System.out.println("CE");
        }

        if (command.equals("Command+/-")) {
            System.out.println("CE");
        }
        
       
        if (command.equals("Command.")) {
            // se nao tiver . no numero adiciona o .
            if (z != null && z != ""){
                if (z.indexOf(".") == -1){
                z = z + ".";
                }
            }
            
            numberLabel.setText(z);
        }
        if (command.equals("Command=")) {

            num2 = Double.parseDouble(numberLabel.getText());
            System.out.println(op);

            if(op == 1){
                result = num1 + num2;
                System.out.println(result);
            }
            if(op == 2){
                result = num1 - num2;
                System.out.println(result);
            }
            if(op == 3){
                result = num1 / num2;
                System.out.println(result);
            }
            if(op == 4){
                result = num1 * num2;
                System.out.println(result);
            }
            numberLabel.setText(String.valueOf(result));
        }
    
    }
}
