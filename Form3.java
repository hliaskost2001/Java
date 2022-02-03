package com.hlias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form3 extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panel1;
    private JTextField textField3;
    private JButton button2;
    private JButton button1;

    public Form3(String text) {

            setTitle("Αναζήτηση");
            setPreferredSize(new Dimension(800, 400));
            setContentPane(panel1);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
            setLocationRelativeTo(null);//για να εμφανίζεται πάντα στο κέντρο της οθόνης
            setVisible(true);

    }

}

