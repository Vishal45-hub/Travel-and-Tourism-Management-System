import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, password;
    JTextField tfusername;
    JPasswordField tfpassword; 

    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,70,200,200);
        p1.add(image);

        // Right Panel for form inputs
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel blusername = new JLabel("Username");
        blusername.setBounds(60,20,100,25);
        blusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(blusername);

        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        p2.add(tfusername);
        tfusername.setBorder(BorderFactory.createEmptyBorder());

        JLabel blpassword = new JLabel("Password");
        blpassword.setBounds(60,110,100,25);
        blpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(blpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        p2.add(login);
        login.addActionListener(this);

        signup = new JButton("Signup");
        signup.setBounds(200,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        p2.add(signup);
        signup.addActionListener(this);

        password = new JButton("Forgot Password");
        password.setBounds(130,250,130,30);
        password.setBackground(new Color(133,193,233));
        password.setForeground(Color.WHITE);
        p2.add(password);
        password.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = new String(tfpassword.getPassword()); 

                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == password) {
            setVisible(false);
            new ForgotPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}