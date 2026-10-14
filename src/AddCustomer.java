import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelusername, labelname, labelgender, lblid;
    JComboBox<String> comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail;
    JRadioButton rmale, rfemale;
    JButton btnAdd, btnBack;

    AddCustomer(String username) {
        setBounds(450, 200, 900, 600);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 50, 200, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 200, 25);
        add(labelusername);

        lblid = new JLabel("ID");
        lblid.setBounds(20, 90, 130, 25);
        add(lblid);

        comboid = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboid.setBounds(220, 90, 130, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(20, 130, 200, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20, 170, 200, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 200, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(20, 210, 200, 25);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        add(rmale);
        rmale.setBackground(Color.WHITE);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        add(rfemale);
        rfemale.setBackground(Color.WHITE);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(20, 250, 200, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(20, 290, 200, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone No");
        lblphone.setBounds(20, 330, 200, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(20, 370, 200, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(70, 430, 100, 25);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        add(btnAdd);
        btnAdd.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(220, 430, 100, 25);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
        btnBack.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AddInfo.png"));
        Image i2 = i1.getImage().getScaledInstance(325, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from account where username = '" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdd) {
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (rmale.isSelected()) {
                gender = "Male";
            } else if (rfemale.isSelected()) {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO customer VALUES('" + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + address + "', '" + phone + "', '" + email + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}