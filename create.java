import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Object;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class create {
    JTextField text_1, text_2, text_3, text_4, text_5,text_6,text_7,text_8,text_9,text_10, title;
    JButton click_title, create_word;
    public static String filename;
    public void make_window(JFrame f) {
        // f = new JFrame("Play");
        // f.getContentPane().setBackground(Color.white);
        // // f.setUndecorated(true); // <-- the title bar is removed her
        // f.setLayout(null);
        // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(500, 220, 500, 500);
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel_1.setBackground(Color.white);
        // the 4 lines below this make me a title
        title = new JTextField();
        title.setBounds(750, 50, 150, 20);
        click_title = new JButton("Enter title");
        click_title.setBounds(750, 100, 150, 20);
        System.out.println(filename);
        click_title.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Entered word is "+text.getText());
                // System.out.println("Entered word is "+title.getText());
                // System.out.println(filename);
                // WriteToFile writer=new WriteToFile();
                // writer.make_file(title.getText());
                System.exit(0);
            }
        });
        // these 4 lines below help me a word
        panel_1.add(text_1);
        panel_1.setBounds(150, 200,150, 250);
        panel_1.setVisible(true);
        int y_cord = 50;
        text_1 = new JTextField();
        text_2 = new JTextField();
        text_3 = new JTextField();
        text_4 = new JTextField();
        text_5 = new JTextField();
        text_6 = new JTextField();
        text_7 = new JTextField();
        text_8 = new JTextField();
        text_9 = new JTextField();
        text_10 = new JTextField();
        text_1.setBounds(50, 50, 150, 20);
        text_2.setBounds(50, 100, 150, 20);
        text_3.setBounds(50, 150, 150, 20);
        text_4.setBounds(50, 200, 150, 20);
        text_5.setBounds(50, 250, 150, 20);
        text_6.setBounds(50, 300, 150, 20);
        text_7.setBounds(50, 350, 150, 20);
        text_8.setBounds(50, 400, 150, 20);
        text_9.setBounds(50, 450, 150, 20);
        text_10.setBounds(50,500, 150, 20);
        for (int i = 0; i < 10; i++) {
            int j = i + 1;
            create_word = new JButton("Add " + j + "th" + " word");
            create_word.setBounds(250, y_cord, 150, 20);
            y_cord = y_cord + 50;
            f.add(create_word);
            f.add(click_title);
        }
        // text_1.setVisible(true);
        panel_1.add(text_1);
        f.add(title);
        f.add(text_1);
        f.add(text_2);
        f.add(text_3);
        f.add(text_4);
        f.add(text_5);
        f.add(text_6);
        f.add(text_7);
        f.add(text_8);
        f.add(text_9);
        f.add(text_10);
        f.add(panel_1);
        create_word.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Entered word is "+text.getText());
                
                filename = title.getText() + ".txt";
                WriteToFile writer = new WriteToFile();
                System.out.println(filename);
                System.out.println(text_1.getText());
                writer.put_in_file(text_1.getText(), filename);
                System.out.println(text_2.getText());
                writer.put_in_file(text_2.getText(), filename);
                System.out.println(text_3.getText());
                writer.put_in_file(text_3.getText(), filename);
                System.out.println(text_4.getText());
                writer.put_in_file(text_4.getText(), filename);
                System.out.println(text_5.getText());
                writer.put_in_file(text_6.getText(), filename);
                writer.put_in_file(text_7.getText(), filename);
                writer.put_in_file(text_8.getText(), filename);
                writer.put_in_file(text_9.getText(), filename);
                writer.put_in_file(text_10.getText(), filename);
                // System.exit(0);
            }
        });
        // f.add(create_word);
        // f.add(text);
        // f.add(click_title);
        // f.add(title);
        // f.setVisible(true);
    }
}