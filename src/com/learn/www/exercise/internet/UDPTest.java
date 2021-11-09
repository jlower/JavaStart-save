package com.learn.www.exercise.internet;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author lowo
 * 2021/10/24->4:15
 */

//UDPd协议的网络编程

public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str = "UDP send 中文!";
        byte[] bytes = str.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");//getLocalHost();
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, inet, 9090);
        socket.send(packet);
        socket.close();
    }
    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);
        String str = new String(packet.getData(), 0, packet.getLength());
        System.out.println("str = " + str);
        socket.close();
    }
}
