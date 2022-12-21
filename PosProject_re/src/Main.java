
import java.sql.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
        Connection conn = null;
        conn = DBconnection.getConnection();
        }catch(Exception e){}
    }
    
    public static void capCharProcess(){
        ImageGenerator initiateProgram = new ImageGenerator();
        try {
            initiateProgram.Generate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
