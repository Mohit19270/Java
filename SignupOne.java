package BankManagementSystem;

import java.awt.*;
import java.util.*;
//import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameText, fnameText, dobText, emailText, addText, cityText, stateText, pinText;
    JButton next;
    JRadioButton male, female, trans, married, unmarried, Other;

    SignupOne(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("Application Form No. "+ random);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20, 600, 40);
        add(formNo);

        JLabel personalDetail = new JLabel("Page 1 : personal Detail");
        personalDetail.setFont(new Font("Raleway",Font.BOLD,20));
        personalDetail.setBounds(290,80, 400, 30);
        add(personalDetail);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140, 100, 30);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD,14));
        nameText.setBounds(300,140,400,30);
        add(nameText);

        JLabel fname = new JLabel("Father Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190, 200, 30);
        add(fname);

        fnameText = new JTextField();
        fnameText.setFont(new Font("Raleway",Font.BOLD,14));
        fnameText.setBounds(300,190,400,30);
        add(fnameText);

        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240, 200, 30);
        add(dob);

        dobText = new JTextField();
        dobText.setFont(new Font("Raleway",Font.BOLD,14));
        dobText.setBounds(300,240,400,30);
        add(dobText);
        //JDateChooser date = new JDateChooser();
        //date.setBounds(300,240,200,30);
        //add(date);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);

        trans = new JRadioButton("Transgender");
        trans.setBounds(600,290,180,30);
        trans.setBackground(Color.white);
        add(trans);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);
        gendeGroup.add(trans);

        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340, 200, 30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,14));
        emailText.setBounds(300,340,400,30);
        add(emailText);

        JLabel mStatus = new JLabel("Marital Status: ");
        mStatus.setFont(new Font("Raleway",Font.BOLD,20));
        mStatus.setBounds(100,390, 200, 30);
        add(mStatus);

        married = new JRadioButton("Married");
        married.setBounds(300,390,75,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,150,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        Other = new JRadioButton("Other");
        Other.setBounds(600,390,225,30);
        Other.setBackground(Color.white);
        add(Other);

        ButtonGroup mGroup = new ButtonGroup();
        mGroup.add(married);
        mGroup.add(unmarried);
        mGroup.add(Other);

        JLabel add = new JLabel("Address : ");
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.setBounds(100,440, 200, 30);
        add(add);

        addText = new JTextField();
        addText.setFont(new Font("Raleway",Font.BOLD,14));
        addText.setBounds(300,440,400,30);
        add(addText);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490, 200, 30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,14));
        cityText.setBounds(300,490,400,30);
        add(cityText);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540, 200, 30);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,14));
        stateText.setBounds(300,540,400,30);
        add(stateText);

        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590, 200, 30);
        add(pincode);

        pinText = new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,14));
        pinText.setBounds(300,590,400,30);
        add(pinText);
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno = ""+ random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = dobText.getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        }
        else if(female.isSelected())
        {
            gender = "Female";
        }
        else 
        {
            gender = "Trans";
        }
        String email = emailText.getText();
        String marital = null;
        if(married.isSelected())
        {
            marital = "Married";
        }
        else if(unmarried.isSelected())
        {
            marital = "Unmarried";
        }
        else{
            marital = "Other";
        }
        String add = addText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinText.getText();
        try{
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is requried");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup value('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+add+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch(Exception e)
        {
            System.out.println(e);
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
        new SignupOne();
    }
    
}
