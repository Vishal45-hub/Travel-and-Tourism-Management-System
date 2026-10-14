import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class calculators implements ActionListener {
    JFrame frame;
    JTextField tf;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton, divButton, mulButton;
    JButton decButton, equalsButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD,20);
    double num1=0, num2=0, result=0;
    char operator;

    calculators(){
             frame = new JFrame("Calculator");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(420,550);
             frame.setLayout(null);
             frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

             tf = new JTextField();
             tf.setBounds(50,25,300,50);
             tf.setFont(myFont);
             tf.setEditable(false);


             addButton = new JButton("+");
             subButton = new JButton("-");
             divButton = new JButton("/");
             mulButton = new JButton("*");
             decButton = new JButton(".");
             equalsButton = new JButton("=");
             delButton = new JButton("DELETE");
             clrButton = new JButton("CLR");
             negButton = new JButton("(-)");

             functionButtons[0] = addButton;
             functionButtons[1] = subButton;
             functionButtons[2] = divButton;
             functionButtons[3] = mulButton;
             functionButtons[4] = decButton;
             functionButtons[5] = equalsButton;
             functionButtons[6] = delButton;
             functionButtons[7] = clrButton;
             functionButtons[8] = negButton;

             for(int i=0;i<9;i++){
                functionButtons[i].addActionListener(this);
                functionButtons[i].setFont(myFont);
                functionButtons[i].setFocusable(false);

             }

             for(int i=0;i<10;i++){
               numberButtons[i] = new JButton(String.valueOf(i));
               numberButtons[i].addActionListener(this);
               numberButtons[i].setFont(myFont);
                numberButtons[i].setFocusable(false);
             }
            
             delButton.setBounds(50,430,145,50);
             clrButton.setBounds(200,430,145,50);
             

             panel = new JPanel();
             panel.setBounds(50,100,300,300);
             panel.setLayout(new GridLayout(4,4,10,10));

             panel.add(numberButtons[1]);
             panel.add(numberButtons[2]);
             panel.add(numberButtons[3]);
             panel.add(addButton);
             panel.add(numberButtons[4]);
             panel.add(numberButtons[5]);
             panel.add(numberButtons[6]);
             panel.add(subButton);
             panel.add(numberButtons[7]);
             panel.add(numberButtons[8]);
             panel.add(numberButtons[9]);
             panel.add(mulButton);
             panel.add(decButton);
             panel.add(numberButtons[0]);
             panel.add(equalsButton);
             panel.add(divButton);



             frame.add(panel);
             frame.add(delButton);
             frame.add(clrButton);
             frame.add(tf);
             

             
             frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
        if(e.getSource() == numberButtons[i]){
        tf.setText(tf.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            tf.setText(tf.getText().concat("."));
            
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(tf.getText());
           operator = '+';
           tf.setText("");
            
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(tf.getText());
           operator = '-';
           tf.setText("");
            
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(tf.getText());
           operator = '*';
           tf.setText("");
            
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(tf.getText());
           operator = '/';
           tf.setText("");
            
        }
        if(e.getSource() == equalsButton){
            num2 = Double.parseDouble(tf.getText());
            switch(operator){
                case '+':
                result = num1+num2;
                break;
                case '-':
                result = num1-num2;
                break;
                case '*':
                result = num1*num2;
                break;
                case '/':
                result = num1/num2;
                break;
            }
            tf.setText(String.valueOf(result));
            num1= result;
        }
        if (e.getSource() == clrButton){
            tf.setText("");
    }
    if (e.getSource() == delButton){
      String string = tf.getText();
      tf.setText("");
      for(int i=0; i<string.length()-1;i++){
     tf.setText(tf.getText() +string.charAt(i));
      }
}

    }
public static void main(String[] args) {
    new calculators();
}
    }