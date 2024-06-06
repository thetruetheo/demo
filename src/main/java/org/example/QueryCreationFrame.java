package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryCreationFrame extends JFrame implements ActionListener {

    JTextField testfield;

    QueryCreationFrame(){



        this.setTitle("Новая заявка");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());



        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
