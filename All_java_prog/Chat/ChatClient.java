import java.io.*;
import java.net.*;
import java.util.*;
public class ChatClient{
    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost", 6666);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            String senddata = "";
            String receivedata = "";
            while(!senddata.equals("stop")){
                System.out.println("SERVER SAYS:");
                senddata = input.nextLine();
                dout.writeUTF(senddata);
                receivedata = din.readUTF();                
                System.out.println("TO CLIENT:" + receivedata);
                
            }
            din.close();
            dout.close();
            s.close();
            // ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}