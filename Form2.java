
package com.hlias;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
public class Form2 extends JFrame {
    private JPanel panel1;
    private JLabel label1;
    private JTextField textfield1;
    private JLabel label2;
    private JTextField textfield2;
    private JTextField textfield3;
    private JTextField textfield4;
    private JTextField textfield5;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label7;
    private JLabel label8;
    private JTextField textfield6;

    List<Zoo> zoo = new ArrayList<>();
    public Form2(String text) {
        setTitle("Προσθήκη και επεξεργασία ή διαγραφή ζώου");
        setPreferredSize(new Dimension(800, 400));
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);//για να εμφανίζεται πάντα στο κέντρο της οθόνης
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoo.add(new Zoo(5,"cat","Θηλαστικό",1000,12));
                mySerialize(zoo,"zoo.ser");

            }
        });
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<Zoo> tempList = myDeserialize();
                StringBuilder builder = new StringBuilder();
                for (Zoo s :
                        tempList) {
                    builder.append("Zoo:").append(s.name).append(",").append(s.age).append("\n");
                }
                JOptionPane.showMessageDialog(Form2.this,builder.toString());
            }
        });

    }


    static void mySerialize(List<Zoo> studentList, String s){
        try {
            FileOutputStream f = new FileOutputStream("zoo.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(studentList);
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final Object readObject() {
        return null;
    }

    static List<Zoo> myDeserialize(){
        List<Zoo> zoo = new ArrayList<>();
        try {
            FileInputStream f = new FileInputStream("Zoo.ser");
            ObjectInputStream o = new ObjectInputStream(f);
            zoo = (List<Zoo>) o.readObject();
            o.close();
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return zoo;
    }
}

class Zoo implements Serializable {
    int age;
    String name;
    String category;
    int code;
    int weight;
    public Zoo(int age, String name,String category,int code,int weight) {
        this.age = age;
        this.name = name;
        this.category=category;
        this.code=code;
        this.weight=weight;

    }
}