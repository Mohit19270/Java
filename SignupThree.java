package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private final JRadioButton r1, r2, r3, r4;
    private final JCheckBox c1, c2, c3, c4, c5, c6, c7;
    private final JButton submitBtn, cancelBtn;
    private final String formNo;

    private final SecureRandom secureRandom = new SecureRandom();

    public SignupThree(String formNo) {
        this.formNo = formNo;
        setTitle("Account Signup - Page 3");
        setLayout(null);

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("FD Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("RD Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup buttonAccount = new ButtonGroup();
        buttonAccount.add(r1);
        buttonAccount.add(r2);
        buttonAccount.add(r3);
        buttonAccount.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel no = new JLabel("XXXX XXXX XXXX XXXX");
        no.setFont(new Font("Raleway", Font.BOLD, 22));
        no.setBounds(300, 300, 300, 30);
        add(no);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pinNO = new JLabel("XXXX");
        pinNO.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNO.setBounds(300, 370, 300, 30);
        add(pinNO);

        JLabel service = new JLabel("Services required");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 430, 250, 30);
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I declare that the above details are correct.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.PLAIN, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submitBtn = new JButton("Submit");
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        submitBtn.setBounds(250, 720, 100, 30);
        submitBtn.addActionListener(this);
        add(submitBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        cancelBtn.setBounds(420, 720, 100, 30);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitBtn) {
            handleSubmit();
        } else if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

    private void handleSubmit() {
        String accountType = getSelectedAccountType();
        if (accountType == null) {
            JOptionPane.showMessageDialog(this, "Please select an account type.");
            return;
        }
        if (!c7.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please confirm the declaration.");
            return;
        }

        String cardNo = generateCardNumber();
        String pinNo = generatePin();
        String facilities = collectFacilities();

        JOptionPane.showMessageDialog(this,
                "Account Created!\nCard Number: " + formatCardPretty(cardNo) + "\nPIN: " + pinNo + "\nFacilities: " + facilities);
    }

    private String getSelectedAccountType() {
        if (r1.isSelected()) return "Saving Account";
        if (r2.isSelected()) return "Current Account";
        if (r3.isSelected()) return "FD Account";
        if (r4.isSelected()) return "RD Account";
        return null;
    }

    private String collectFacilities() {
        List<String> list = new ArrayList<>();
        if (c1.isSelected()) list.add("ATM Card");
        if (c2.isSelected()) list.add("Internet Banking");
        if (c3.isSelected()) list.add("Mobile Banking");
        if (c4.isSelected()) list.add("Email & SMS Alert");
        if (c5.isSelected()) list.add("Cheque Book");
        if (c6.isSelected()) list.add("E-Statement");
        return String.join(", ", list);
    }

    private String generateCardNumber() {
        String prefix = "504093";
        long body = secureRandom.nextLong() & 0xFFFFFFFFFFL;  // 10 digits
        return prefix + String.format("%010d", body);
    }

    private String generatePin() {
        int x = secureRandom.nextInt(10000);
        return String.format("%04d", x);
    }

    private String formatCardPretty(String cardNo) {
        return cardNo.replaceAll("....", "$0 ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignupThree("1234"));
    }
}
