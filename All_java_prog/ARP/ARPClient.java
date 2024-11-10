import java.io.*;
import java.net.*;
import java.util.*;
class ARPClient{
    public static void main(String args[]){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Socket clsct = new Socket("127.0.0.1", 3636);
            DataInputStream din = new DataInputStream(clsct.getInputStream());
            DataOutputStream dout = new DataOutputStream(clsct.getOutputStream());
            System.out.println("Enter the Logical address (IP):");
            String str1 = in.readLine();
            dout.writeBytes(str1 + '\n');
            dout.flush();
            String str = din.readLine();
            System.out.println("The physical address (MAC) is:" + str);
            clsct.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}


