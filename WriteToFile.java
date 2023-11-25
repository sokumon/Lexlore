import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;
import java.io.File;  
// import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class WriteToFile {
  public void put_in_file(String word,String filename) {
    File theDir = new File("Games/");
    if (!theDir.exists()){
        theDir.mkdirs();
        System.out.println("Dir made");
    }
    try {
      FileWriter myWriter = new FileWriter((theDir+"/"+filename),true);
      // myWriter.write(System.getProperty( "line.separator" ));
      myWriter.write(word+System.getProperty( "line.separator" ));
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    }catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}