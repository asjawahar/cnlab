import java.io.*;
import java.net.*;
import java.util.*;
class DNSServer{
    public static void main(String args[]){
        try{
            DatagramSocket server = new DatagramSocket(1309);
            while(true){
                byte[] sendbyte = new byte[1024];
                byte[] recievebyte = new byte[1024];
                DatagramPacket reciever = new DatagramPacket(recievebyte, recievebyte.length);
                server.receive(reciever);
                String str = new String(reciever.getData());
                String s = str.trim();
                InetAddress addr = reciever.getAddress();
                int port = reciever.getPort();
                String ip[] = {"165.165.80.80", "165.165.79.1"};
                String name[] = {"www.aptitude.com", "www.download.com"};
                for(int i=0; i<ip.length; i++){
                    if(s.equals(ip[i])){
                        sendbyte = name[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
                        server.send(sender);
                        break;
                    }
                    else if(s.equals(name[i])){
                        sendbyte = ip[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
                        server.send(sender);
                        break;
                    }
                }
                break;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}