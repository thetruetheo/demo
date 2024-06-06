package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientQueriesFrame extends JFrame implements ActionListener {

    JButton newQueryButton;
    int userID;
    String fio;
    String phone;

    ClientQueriesFrame(int userID, String fio, String phone){

        this.userID=userID;
        this.fio=fio;
        this.phone=phone;



        JLabel userType=new JLabel();
        userType.setText("Клиент");
        setBackground(Color.RED);
        userType.setBounds(0,0,100,100);
        userType.setOpaque(false);

        JLabel userName=new JLabel();
        userType.setText(this.fio);
        setBackground(Color.RED);
        userType.setBounds(0,0,100,100);
        userType.setOpaque(false);

        JLabel userPhone=new JLabel();
        userType.setText(this.phone.toString());
        setBackground(Color.RED);
        userType.setBounds(0,0,100,100);


        newQueryButton=new JButton();
        newQueryButton.setText("Новый запрос");
        newQueryButton.setBounds(0,500,300,100);
        newQueryButton.addActionListener(this);

        this.setTitle("Заявки на ремонт компьютерной техники");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1500,1500);
        this.setLayout(null);
        this.add(userType);
        this.add(userName);
        this.add(userPhone);
        this.add(newQueryButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newQueryButton){

        }

    }
}
