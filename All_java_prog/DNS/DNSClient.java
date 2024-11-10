import java.io.*;
import java.net.*;
import java.util.*;
class DNSServer{
    public static void main(String args[]){
        try{
                DatagramSocket client = new DatagramSocket();
                InetAddress addr = InetAddress.getByName("127.0.0.1");
                byte[] sendbyte = new byte[1024];
                byte[] recievebyte = new byte[1024];
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter the SERVER name:" + '\n');
                String str = in.readLine();
                sendbyte = str.getBytes();
                DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, 1309);
                client.send(sender);
                DatagramPacket reciever = new DatagramPacket(recievebyte, recievebyte.length);
                client.receive(reciever);
                String s = new String(reciever.getData());
                System.out.println("IP address is:" + s.trim());
                client.close();
                
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}