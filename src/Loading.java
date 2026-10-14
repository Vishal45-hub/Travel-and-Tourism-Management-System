import java.awt.*;
import javax.swing.*;
public class Loading extends JFrame implements Runnable {

    Thread t;
    JProgressBar bar;
    String username;

    public void run(){
        try {
            for(int i = 1; i<=101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();

                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread(this);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Management");
        text.setBounds(50,20,600,50);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD, 35));
        add(text);

        JLabel text1 = new JLabel("Swachhand Paryattan");
        text1.setBounds(140,70,600,50);
        text1.setForeground(Color.RED);
        text1.setFont(new Font("Raleway",Font.BOLD, 30));
        add(text1);

        bar = new JProgressBar();
        bar.setBounds(150,120,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, Please Wait ...");
        loading.setBounds(230,160, 250,30);
        loading.setForeground(Color.BLUE);
        loading.setFont(new Font("Raleway",Font.BOLD, 16));
        add(loading);

        JLabel b1username = new JLabel("Welcome " + username);
        b1username.setBounds(20,310,400,40);
        b1username.setForeground(Color.BLUE);
        b1username.setFont(new Font("Raleway",Font.BOLD, 16));
        add(b1username);

        t.start();

        setVisible(true);

    }
    public static void main(String[] args) {
        new Loading("");
    }
    
}