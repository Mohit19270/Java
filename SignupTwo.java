package BankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField addh, occField, panNo;
    JButton next;
    JRadioButton senCyes, senCno, exitsYes, exitsNo;
    JComboBox<String> religion, cat, in, eq;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;

        setLayout(null);
        setTitle("New Account Application Form - Page 2");

        JLabel addDetail = new JLabel("Page 2 : Additional Details");
        addDetail.setFont(new Font("Raleway", Font.BOLD, 20));
        addDetail.setBounds(290, 80, 400, 30);
        add(addDetail);

        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 100, 30);
        add(religionLabel);

        String[] religionOptions = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(religionOptions);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel catLabel = new JLabel("Category:");
        catLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        catLabel.setBounds(100, 190, 200, 30);
        add(catLabel);

        String[] catOptions = {"General", "OBC", "SC", "ST"};
        cat = new JComboBox<>(catOptions);
        cat.setBounds(300, 190, 400, 30);
        cat.setBackground(Color.WHITE);
        add(cat);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String[] incomeOptions = {"Null", "Below 150000", "150000 - 300000", "300000 - 400000", "400000 - 500000", "Above 500000"};
        in = new JComboBox<>(incomeOptions);
        in.setBounds(300, 240, 400, 30);
        in.setBackground(Color.WHITE);
        add(in);

        JLabel eduLabel = new JLabel("Education:");
        eduLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        eduLabel.setBounds(100, 290, 200, 30);
        add(eduLabel);

        JLabel qualLabel = new JLabel("Qualification:");
        qualLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        qualLabel.setBounds(100, 315, 200, 30);
        add(qualLabel);

        String[] eqOptions = {"Upto 10th", "Upto 12th", "Graduation", "Post-Graduation"};
        eq = new JComboBox<>(eqOptions);
        eq.setBounds(300, 315, 400, 30);
        eq.setBackground(Color.WHITE);
        add(eq);

        JLabel occLabel = new JLabel("Occupation:");
        occLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occLabel.setBounds(100, 390, 200, 30);
        add(occLabel);

        occField = new JTextField();
        occField.setFont(new Font("Raleway", Font.PLAIN, 16));
        occField.setBounds(300, 390, 400, 30);
        add(occField);

        JLabel panLabel = new JLabel("PAN No:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 440, 200, 30);
        add(panLabel);

        panNo = new JTextField();
        panNo.setFont(new Font("Raleway", Font.PLAIN, 16));
        panNo.setBounds(300, 440, 400, 30);
        add(panNo);

        JLabel aadharLabel = new JLabel("Aadhar No:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 490, 200, 30);
        add(aadharLabel);

        addh = new JTextField();
        addh.setFont(new Font("Raleway", Font.PLAIN, 16));
        addh.setBounds(300, 490, 400, 30);
        add(addh);

        JLabel seniorLabel = new JLabel("Senior Citizen:");
        seniorLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorLabel.setBounds(100, 540, 200, 30);
        add(seniorLabel);

        senCyes = new JRadioButton("Yes");
        senCyes.setBounds(300, 540, 100, 30);
        senCyes.setBackground(Color.WHITE);
        add(senCyes);

        senCno = new JRadioButton("No");
        senCno.setBounds(450, 540, 100, 30);
        senCno.setBackground(Color.WHITE);
        add(senCno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(senCyes);
        seniorGroup.add(senCno);

        JLabel existsLabel = new JLabel("Existing Account:");
        existsLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existsLabel.setBounds(100, 590, 200, 30);
        add(existsLabel);

        exitsYes = new JRadioButton("Yes");
        exitsYes.setBounds(300, 590, 100, 30);
        exitsYes.setBackground(Color.WHITE);
        add(exitsYes);

        exitsNo = new JRadioButton("No");
        exitsNo.setBounds(450, 590, 100, 30);
        exitsNo.setBackground(Color.WHITE);
        add(exitsNo);

        ButtonGroup existsGroup = new ButtonGroup();
        existsGroup.add(exitsYes);
        existsGroup.add(exitsNo);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String religionVal = (String) religion.getSelectedItem();
        String catVal = (String) cat.getSelectedItem();
        String inVal = (String) in.getSelectedItem();
        String eqVal = (String) eq.getSelectedItem();
        String occVal = occField.getText();
        String panVal = panNo.getText();
        String aadharVal = addh.getText();
        String senior = senCyes.isSelected() ? "Yes" : "No";
        String existingAcc = exitsYes.isSelected() ? "Yes" : "No";

        try {
            if (occVal.equals("") || panVal.equals("") || aadharVal.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signupTwo VALUES('" + formno + "','" + religionVal + "','" + catVal + "','" + inVal + "','" + eqVal + "','" + occVal + "','" + panVal + "','" + aadharVal + "','" + senior + "','" + existingAcc + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Submitted Successfully!");
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("1234");  // Replace with actual form number from SignupOne
    }
}
