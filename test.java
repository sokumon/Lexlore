import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.lang.Object;

public class test{
	public static void main(String[] args){
	JFrame f=new JFrame("LEXLORE");
    f.getContentPane().setBackground(Color.white);
    f.setUndecorated(true); // <-- the title bar is removed her
    f.setLayout(null); 
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    JPanel panel=new JPanel();
    panel.setBounds(500,220,500,500);
   // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(Color.white);
    JTextField text=new JTextField();  
    text.setBounds(50,50,150,20);  
	JButton create_word=new JButton("Add word");
    create_word.setBounds(50,100,150,20);
    for(int i=0;i<11;i++){
    create_word.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Entered word is "+text.getText());
            
        }
    });};
    f.add(create_word);
    f.add(text);
    f.setVisible(true);
}
}
