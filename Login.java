package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JButton login, signup, clear;
    JTextField cardText;
    JPasswordField pinText;
    Login()
    {
        setTitle("ATM"); 
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel CardNo = new JLabel("Card No :");
        CardNo.setFont(new Font("Raleway",Font.BOLD,28));
        CardNo.setBounds(120,150,150,30);
        add(CardNo);

        cardText = new JTextField();
        cardText.setBounds(300,150,230,30);
        add(cardText);

        JLabel pin = new JLabel("Password : ");
        pin.setFont(new Font("Raleway",Font.BOLD,24));
        pin.setBounds(120,220,230,30);
        add(pin);


        pinText = new JPasswordField();
        pinText.setBounds(300,220,230,30);
        add(pinText);

        login = new JButton("SIGN IN");
        login.setBounds(300,280,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

       

        clear = new JButton("Clear");
        clear.setBounds(430,280,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,330,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.BLUE);

        setSize(800,480);
        setVisible(true);
        setLocation(355, 210);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)
        {
            cardText.setText("");
            pinText.setText("");
        }
        else if(ae.getSource() == login)
        {

        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }
    public static void main(String args[])
    {
        try 
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        new Login();
    }
    
}
