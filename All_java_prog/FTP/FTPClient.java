import java.io.*;
import java.net.*;
import java.util.*;
public class FTPClient{
    public static void main(String args[]) throws Exception{
        InetAddress ia = InetAddress.getLocalHost();
        Socket s = new Socket(ia, 1024);
        String fname, str;
        System.out.println("Enter the another file name:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fname = br.readLine();
        File f1 = new File(fname);
        PrintWriter p = new PrintWriter(new FileWriter(fname));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        while((str=br1.readLine())!=null)
        p.println(str);
        
        p.close();
        s.close();
    }
}