import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel labelusername, labelname, labelgender, lblid;
    JComboBox<String> comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail, tfid, tfgender;
    JRadioButton rmale, rfemale;
    JButton btnUpdate, btnBack;

    UpdateCustomer(String username) {   
        setBounds(450, 200, 900, 600);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(118, 11, 300, 53);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(35, 70, 200, 14);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(271, 70, 150, 20);
        add(labelusername);

        lblid = new JLabel("ID");
        lblid.setBounds(35, 110, 200, 14);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(271, 110, 150, 20);
        add(tfid);

        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(35, 150, 200, 14);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(271, 150, 150, 20);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 190, 200, 14);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(271, 190, 150, 20);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 230, 200, 14);
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(271, 230, 150, 20);
        add(tfgender);
   
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 270, 200, 14);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(271, 270, 150, 20);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(35, 310, 200, 14);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(271, 310, 150, 20);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone No");
        lblphone.setBounds(35, 350, 200, 14);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(271, 350, 150, 20);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(35, 390, 200, 14);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(271, 390, 150, 20);
        add(tfemail);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100, 430, 120, 30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        add(btnUpdate);
        btnUpdate.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(260, 430, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
        btnBack.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/UpdateInfo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(325, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 200, 400);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where username = '" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnUpdate) {
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "Update customer set username = '" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone ='" + phone + "', email = '" + email + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}