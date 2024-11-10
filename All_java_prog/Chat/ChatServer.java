import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            String senddata = "";
            String receivedata = "";
            while(!receivedata.equals("stop")){
                receivedata = din.readUTF();
                System.out.println("CLIENT SAYS:" + receivedata);
                System.out.println("TO CLIENT:");
                senddata = input.nextLine();
                dout.writeUTF(senddata);
            }
            din.close();
            dout.close();
            s.close();
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}