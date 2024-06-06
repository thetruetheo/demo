package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AuthorizationFrame extends JFrame implements ActionListener {

    JTextField userNameTextField;
    JTextField passwordTextField;
    JButton button;


    AuthorizationFrame(){
        userNameTextField=new JTextField();
        //userNameTextField.setPreferredSize(new Dimension(250,40));
        //userNameTextField.setFont(new Font("Consolas", Font.PLAIN,35));
        userNameTextField.setText("логин");
        userNameTextField.setBounds(0,0,300,50);

        passwordTextField=new JTextField();
        //passwordTextField.setPreferredSize(new Dimension(250,40));
        //passwordTextField.setFont(new Font("Consolas", Font.PLAIN,35));
        passwordTextField.setText("пароль");
        passwordTextField.setBounds(0,0,300,50);

        button=new JButton();
        button.setBounds(0,0,100,100);
        button.addActionListener(this);
        button.setText("Войти");
        button.setFocusable(false);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(100,50,300,50);
        loginPanel.setBackground(Color.BLACK);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(null);
        passwordPanel.setBounds(100,150,300,50);
        passwordPanel.setBackground(Color.RED);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(100,250,300,100);


        this.setTitle("Авторизация");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setLayout(null);
        loginPanel.add(userNameTextField,BorderLayout.NORTH);
        this.add(loginPanel);
        passwordPanel.add(passwordTextField,BorderLayout.NORTH);
        this.add(passwordPanel);
        buttonsPanel.add(button);
        this.add(buttonsPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){

            String userName=userNameTextField.getText();
            //System.out.println(userName);
            String password=passwordTextField.getText();
            //System.out.println(password);

            DbFunctionsActual dbFunctionsActual=new DbFunctionsActual();
            Connection conn = dbFunctionsActual.connectToDB("postgres","toor");
            //dbFunctionsActual.readDataFromUsersTable(conn,"users");
            if(dbFunctionsActual.userLogin(conn,"users", userName, password)){
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Неправильный логин или пароль",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);

            }



        }

    }
}
