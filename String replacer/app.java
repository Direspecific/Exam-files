import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

import javax.sound.sampled.Line;
public class App {
    public static void main(String[] args) throws Exception {
    try {
        FileWriter writer = new FileWriter("D:\\Java\\Myfile.txt", true );
        writer.write("Hello World");
        writer.write("\r\n");
        writer.write("Goodbye");
        writer.close();
        writer.close();
    } catch (IOException e){
        e.printStackTrace();
    }
    }
}
