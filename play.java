import java.io.File; // Import the File class.
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.function.ObjDoubleConsumer;
import java.lang.Math;

import javax.lang.model.util.ElementScanner14;
import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.plaf.PanelUI;
import javax.swing.text.Style;

import java.awt.event.*;
import java.awt.*;
import java.lang.Object;
import java.lang.reflect.Field;

public class play {
  public static String string="";
  public static int counter;
  public static JFrame f=new JFrame("PLay???");
  public static char [][] grid= new char [10][10];//
  public static String[] words = new String[10];
  public static int row,col;
  public static int i = 0;
  public static void main(String args[]) {
    JButton[][] button = new JButton[10][10];
    JButton exit_play=new JButton("Exit Game");
    JLabel[] labels=new JLabel[10];
    JPanel panel1=new JPanel();
    File file = new File("Games/Fruits.txt");
    try {
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()){
        // System.out.println(sc.nextLine());
        words[i] = sc.nextLine();
        i++;
      }
      sc.close();
    } catch (FileNotFoundException ex) {
      // insert code to run when exception occurs
    }
    // for(int i=0;i<words.length-1;i++){
    //   System.out.printf("%s %d\n",words[i],words[i].length());
    // }
    // for (int i = 0; i < 10; i++) {
    //   if (i == 0) {
    //     if (words[0].length() > words[1].length()) {
    //       highest = words[0].length();
    //     } else {
    //       highest = words[1].length();
    //     }
    //   }
    //   else{
    //     if(highest<words[i].length()){
    //        highest=words[i].length();
    //     }
    //   }
    // }
  // row=col=highest;
  counter=0;
  ArrayList<String> arrli
  = new ArrayList<String>(10);
  
  JPanel panel=new JPanel();
  ActionListener listener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton alphabet=(JButton) e.getSource();
            arrli.add(alphabet.getName());
            System.out.println(arrli);
            alphabet.setBackground(Color.orange);
            String text = ((JButton) e.getSource()).getText();
            alphabet.setEnabled(false);
            string=string+text;
            
            for (int i = 0; i < words.length; i++) {
              if(string.equals(words[i])){
                labels[i].setForeground(Color.GREEN);
                string="";
                counter++;
              }
              }
            }
            System.out.println("String after loop is:"+string);
            if(counter==10){
              panel.setVisible(false);
              panel1.setVisible(false);
              JLabel mess=new JLabel("Congrats U completed it");
              mess.setBounds(500,500,500,500);
              mess.setFont(new Font("Dialog", Font.PLAIN,35));
              exit_play.setBounds(250,750,200,50);
              f.add(mess);
            }
    }
};

for(int a=0;a<10;a++){
  for(int b=0;b<10;b++){
    grid[a][b]='0';
  }
}
int temp_row=-1;
int temp_col=-1;
Random random = new Random();  
int temp=-1;
for(int a=0;a<10;a++){
  int row=random.nextInt(9);
  int column=random.nextInt(9);
  System.out.printf("%d,%d\n",row,column);
  // int word_len=words[0].length();
  put_into_grid(words[a],row,column,words[a].length());
  // put_into_grid(words[1],row,column,words[1].length());
}
for(int a=0;a<10;a++){
  for(int b=0;b<10;b++){
    Random r = new Random();
    char c = (char)(r.nextInt(26) + 'a');
    if(grid[a][b]=='0'){
      grid[a][b]=c;
    }
  }
}
// display();
for(int i=0;i<10;i++)
  {
       for(int j=0;j<10;j++)
       {
        String s=Character.toString(grid[i][j]);  
        button[i][j] = new JButton(s.toUpperCase());
        button[i][j].addActionListener(listener);
        button[i][j].setFocusPainted(false);
        button[i][j].setBackground(Color.WHITE);
        button[i][j].setName(s.toUpperCase());
        button[i][j].setFont(new Font("Arial", Font.PLAIN,25));
          //button[i][j].setPreferredSize(new Dimension(5,5));
        panel.add(button[i][j]);
       }
  }
  
  exit_play.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
  });
  exit_play.setFont(new Font("Dialog", Font.PLAIN,25));
  exit_play.setBounds(1000,800,200,50);
  exit_play.setFocusPainted(false);
  f.add(exit_play);
  panel.setBounds(100,100,650,650);
  panel.setVisible(true);
  panel.setLayout(new GridLayout(10,10));

  f.add(panel);
  giveframe(f);
  panel1.setBackground(Color.white);
  
  panel1.add(Box.createRigidArea(new Dimension(50,0)));
  for (int i=0;i<10;i++){
      // System.out.println(words[i]);
      labels[i]=new JLabel(words[i]);
      labels[i].setFont(new Font("Dialog", Font.PLAIN,35));
      panel1.add(labels[i]);
      panel1.add(Box.createRigidArea(new Dimension(50,20)));
  }
  panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
  panel1.setBounds(950,100,400,650);
  panel1.setVisible(true);
  f.add(panel1);
  f.getContentPane().setBackground(Color.white);
  f.setUndecorated(true); // <-- the title bar is removed her
  f.setLayout(null);  
  f.setVisible(true); 
  f.setExtendedState(JFrame.MAXIMIZED_BOTH);
  f.setLayout(null);
  // System.out.println(file);
  // System.out.printf("%d %d\n",row,col);
  }
  public JFrame giveframe() {
    return f;
  }
  // public static void add_to_array(String word) {
  //   words[i] = word;
  //   i++;
  // }
public static void display(){
  for(int a=0;a<10;a++){
    for(int b=0;b<10;b++){
      System.out.printf("%c\t",grid[a][b]);
    }
    System.out.printf("\n");
  }
}
public static void put_into_grid(String word,int row,int col,int wlen){
if(grid[row][col]!='0'){
  Random random = new Random();
  row=random.nextInt(10);
  col=random.nextInt(10);
  put_into_grid(word, row, col, wlen);
}
else{
  int down,across;
  across=down=1;
  System.out.println(row+wlen);
  System.out.println(col+wlen);
  if(row+wlen<10){
    for(int b=0;b<wlen;b++){
      if(grid[row+b][col]!='0'){
        down--;
        break;
      }
    }
  }else{
    down--;
  }
  if(col+wlen<10){
    for(int b=0;b<wlen;b++){
      if(grid[row][col+b]!='0'){
        System.out.println("Someones in the way");
        across--;
        break;
      }
    }
  }else{
    across--;
  }
  System.out.println("Down:"+down);
  System.out.println("Across:"+across);
  if(down==0&&across==0){
    Random random = new Random();
    row=random.nextInt(10);
    col=random.nextInt(10);
    System.out.println("going in again");
    put_into_grid(word, row, col, wlen);
  }else if(down==1&&across==1){
    Random random = new Random();
    int config=random.nextInt(2);
    System.out.println("Config:"+config);
    if(config==0){
      for(int b=0;b<wlen;b++){
        grid[row][col+b]=word.charAt(b);
      }
    }else{
      for(int b=0;b<wlen;b++){
        grid[row+b][col]=word.charAt(b);
      }
    }
  }else if(down==1&&across==0){
    for(int b=0;b<wlen;b++){
      grid[row+b][col]=word.charAt(b);
    }
  }else if(down==0&&across==1){
    for(int b=0;b<wlen;b++){
      grid[row][col+b]=word.charAt(b);
    }
  }
}
}
}