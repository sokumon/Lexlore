import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.lang.Object;
public class mainmenu{
    final JFrame f=new JFrame("LEXLORE");
    //function(int a)
    //func(2)
    //function_do_to_some_thing(Jframe f)
    f.getContentPane().setBackground(Color.white);
    f.setUndecorated(true); // <-- the title bar is removed her
    f.setLayout(null);  
    f.setVisible(true); 

    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    JPanel panel=new JPanel();
    panel.setBounds(500,200,500,650);
    // panel.setAlignmentX(Component.CENTER_ALIGNMENT);
    // panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
    panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
    panel.setBackground(Color.white);
    JButton exit=new JButton("Exit");  
    JButton create=new JButton("Create"); 
    JButton play=new JButton("Play"); 
    f.setVisible(true);
    // exit.setBounds(0,0,95,30);  
    exit.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    // play.setBounds(50,125,95,30);
    // create.setBounds(50,175,95,30); 
    exit.setFont(new Font("Dialog", Font.PLAIN, 35));
    play.setFont(new Font("Dialog", Font.PLAIN, 35));
    create.setFont(new Font("Dialog", Font.PLAIN, 35));
    exit.setFocusPainted(false);
    play.setFocusPainted(false); 
    create.setFocusPainted(false);
    JLabel label = new JLabel("Lexlore",SwingConstants.CENTER);
    label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    label.setVisible(true);
    label.setBounds(500,75,500,100);
    label.setFont(new Font("Dialog", Font.PLAIN, 100));
    panel.add(label,BorderLayout.PAGE_START);
    panel.add(Box.createRigidArea(new Dimension(50,60)));
    panel.add(create);
    panel.add(Box.createRigidArea(new Dimension(0,30)));
    panel.add(Box.createRigidArea(new Dimension(8,60)));
    panel.add(play);
    panel.add(Box.createRigidArea(new Dimension(0,30)));
    panel.add(Box.createRigidArea(new Dimension(150,60)));
    create.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    play.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    exit.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    panel.add(exit);
    f.add(panel);
    exit.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            System.out.print("BYE MAN");
            System.exit(0);
        }
    });
    create.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            
            panel.setVisible(false);
            create_page(f);
        }
    });
}