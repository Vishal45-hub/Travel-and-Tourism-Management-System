import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {
    About() {
        setBounds(500, 200, 500, 550 );
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(l1);
        String s = "The project aims to provide an interactive and user-friendly platform for travelers to explore and book various tourist destinations. Key features include destination search, itinerary planning, booking options for hotels and tours, and a personalized account system for managing trips. Java’s object-oriented programming (OOP) features were crucial in organizing the system's different components, while the Swing library was used to create a graphical user interface (GUI). The project also focuses on enhancing data handling through file storage and retrieval techniques, ensuring a smooth and efficient user experience.";
        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
                back.addActionListener(this);
                add(back);
                
        setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
                setVisible(false);
    }
        public static void main(String[] args) {
          new About();
        }    
}