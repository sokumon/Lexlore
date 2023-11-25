import javax.lang.model.type.WildcardType;
import javax.swing.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.function.ObjDoubleConsumer;
import java.awt.event.*;
import java.awt.*;
import java.lang.Object;
import java.nio.file.FileAlreadyExistsException;


public class lexlore{
public static int count=0;
public static String filename;
public static void main(String[] args) {  
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
    play.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            
            panel.setVisible(false);
            ArrayList<String> ar = new ArrayList<String>();
            JPanel panel2=new JPanel();
            JLabel play_game= new JLabel("Choose a puzzle title:");
            File curDir = new File("./Games");
            for (int i = 0; i < curDir.list().length; i++) {
              ar.add(curDir.list()[i].replace(".txt",""));
            }
            JComboBox box=new JComboBox(ar.toArray());
            box.setFont(new Font("Dialog", Font.PLAIN,35));
            box.setMaximumSize(new Dimension(350,50));
            play_game.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            play_game.setVisible(true);
            play_game.setMaximumSize(new Dimension(500,100));
            play_game.setFont(new Font("Dialog", Font.PLAIN,50));
            panel2.add(play_game);
            panel2.add(box);
            panel2.setLayout(new BoxLayout(panel2,BoxLayout.PAGE_AXIS));
            panel2.setBounds(450,350,700,500);
            panel2.setBackground(Color.white);
            f.add(panel2);
            box.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                // if(e.getStateChange()==ItemEvent.SELECTED){
                //   System.out.println(ar.get(box.getSelectedIndex()));
                //   String game=ar.get(box.getSelectedIndex());
                //   panel2.setVisible(false);
                //   play_page p=new play_page();
                //   p.game_time(f, game);
                // }
                JComboBox cb = (JComboBox)e.getSource();
                String game = (String)cb.getSelectedItem();
                  panel2.setVisible(false);
                  play_page p=new play_page();
                  p.game_time(f, game);
              }
            });

            // play_page p=new play_page();
            // p.play_the_puzzle(f);
            
        }
    });
    
}
public static void create_page(JFrame f){
   JPanel panel1=new JPanel();
   panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
   panel1.setBounds(250,220,1000,750);
   panel1.setBackground(Color.white);
   JTextField text_1=new JTextField();
   text_1.setMaximumSize(new Dimension(750,50));
   text_1.setFont(new Font("Arial", Font.PLAIN,25));
   JLabel label= new JLabel("Enter Title",SwingConstants.CENTER);
   JButton next=new JButton("Next");
//    label.setBounds(0,0,200,100);
   label.setFont(new Font("Dialog", Font.PLAIN,75));
   next.setBounds(500, 5, 150, 100);
   next.setFocusPainted(false);
   next.setMaximumSize(new Dimension(200,50));
   label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
   panel1.add(Box.createRigidArea(new Dimension(0,0)));
   panel1.add(label);
   panel1.add(text_1);
   panel1.add(Box.createRigidArea(new Dimension(0,0)));
   panel1.add(Box.createRigidArea(new Dimension(250,50)));
   next.setAlignmentX(JButton.CENTER_ALIGNMENT);
   panel1.add(next);
   next.setFont(new Font("Dialog", Font.PLAIN, 35));
   f.add(panel1);
   WriteToFile writer=new WriteToFile();
   ArrayList<String>user_words= new ArrayList<String>(11);
   next.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
      if(user_words.size()!=11){
        user_words.add(text_1.getText());
        text_1.setText("");
        if(user_words.size()==1){

          label.setText("Enter the "+Integer.toString(user_words.size())+"st word");
        }
        else if(user_words.size()==2){
          label.setText("Enter the "+Integer.toString(user_words.size())+"nd word");
        }
        else if(user_words.size()==3){
          label.setText("Enter the "+Integer.toString(user_words.size())+"rd word");
        }else{
          if(user_words.size()!=11) label.setText("Enter the "+Integer.toString(user_words.size())+"th word");
          else{
            for (int index = 0; index < user_words.size(); index++) {
              if(index==0){
                filename=user_words.get(index)+".txt";
                System.out.println(filename);
              }else{
                writer.put_in_file(user_words.get(index).toUpperCase(), filename);
              }
            }
            text_1.setVisible(false);
            label.setText("Puzzle is almost created");
            next.setText("Play Now");
            next.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  panel1.setVisible(false);
                  ArrayList<String> ar = new ArrayList<String>();
                  JPanel panel2=new JPanel();
                  JLabel play_game= new JLabel("Choose a puzzle title:");
                  File curDir = new File("./Games");
                  for (int i = 0; i < curDir.list().length; i++) {
                    ar.add(curDir.list()[i].replace(".txt",""));
                  }
                  JComboBox box=new JComboBox(ar.toArray());
                  
                  box.setFont(new Font("Dialog", Font.PLAIN,35));
                  box.setMaximumSize(new Dimension(350,50));
                  play_game.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                  play_game.setVisible(true);
                  play_game.setMaximumSize(new Dimension(500,100));
                  play_game.setFont(new Font("Dialog", Font.PLAIN,50));
                  panel2.add(play_game);
                  panel2.add(box);
                  panel2.setLayout(new BoxLayout(panel2,BoxLayout.PAGE_AXIS));
                  panel2.setBounds(450,350,700,500);
                  panel2.setBackground(Color.white);
                  f.add(panel2);
                  box.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                      // if(e.getStateChange()==ItemEvent.SELECTED){
                      //   System.out.println(ar.get(box.getSelectedIndex()));
                      //   String game=ar.get(box.getSelectedIndex());
                      //   panel2.setVisible(false);
                      //   play_page p=new play_page();
                      //   p.game_time(f, game);
                      // }
                      JComboBox cb = (JComboBox)e.getSource();
                      String game = (String)cb.getSelectedItem();
                        panel2.setVisible(false);
                        play_page p=new play_page();
                        p.game_time(f, game);
                    }
                  });
              }
            });
            JButton play_later=new JButton("Play Later");
            play_later.setMaximumSize(new Dimension(200,50));
            play_later.setAlignmentX(JButton.CENTER_ALIGNMENT);
            panel1.add(Box.createRigidArea(new Dimension(250,50)));
            play_later.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });
            play_later.setFont(new Font("Dialog", Font.PLAIN, 35));
            panel1.add(play_later);
          }
        }
    }
    }
});
}
}
class play_page{
  public static String string="";
  public static int counter;
  public static char [][] grid= new char [10][10];//
  public static String[] words = new String[10];
  public static int row,col;
  public static int i = 0;
  public void game_time(JFrame f,String game) {
    JButton[][] button = new JButton[10][10];
    JButton exit_play=new JButton("Exit Game");
    JLabel[] labels=new JLabel[10];
    JPanel panel1=new JPanel();
    File file = new File("Games/"+game+".txt");
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
  // JFrame f=new JFrame("PLay???");
  JPanel panel=new JPanel();
  ActionListener listener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton alphabet=(JButton) e.getSource();
            arrli.add(alphabet.getName());
            System.out.println(arrli);
            alphabet.setBackground(Color.cyan);
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
            // System.out.println("String after loop is:"+string);
            if(counter==10){
              panel.setVisible(false);
              panel1.setVisible(false);
              JLabel mess=new JLabel("Congrats U completed it");
              mess.setBounds(500,250,1000,500);
              mess.setFont(new Font("Dialog", Font.PLAIN,75));
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
  // f.setUndecorated(true); // <-- the title bar is removed her
  f.setLayout(null);  
  f.setVisible(true); 
  // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
  f.setLayout(null);
  
  // System.out.println(file);
  // System.out.printf("%d %d\n",row,col);
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