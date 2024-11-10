import java.util.*;
import java.io.*;
import java.net.*;

class ARPServer{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(3636);
            
            while(true){
                Socket s = ss.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                String str = din.readLine();
                String ip[] = {"165.165.80.80", "165.165.79.1"};
                String mac[] = {"6A:08:AA:3C", "3B:BC:8O:AS"};
                for(int i=0; i<ip.length; i++){
                    if(str.equals(ip[i])){
                        dout.writeBytes(mac[i]+'\n');
                        break;
                    }
                }
                ss.close();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
