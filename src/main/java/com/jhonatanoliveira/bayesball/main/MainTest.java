/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonatanoliveira.bayesball.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jhonatanoliveira
 */
public class MainTest {
    // SDP constants
    public static final String MULTICAST_ADDRESS = "224.5.23.2";
    public static final int MULTICAST_PORT = 10020;

    // args: each arg is the name of an interface.
    public void doMain(Set<String> args)
            throws Exception
    {
        InetSocketAddress socketAddress =
                new InetSocketAddress(MULTICAST_ADDRESS, MULTICAST_PORT);
        MulticastSocket socket = new MulticastSocket(MULTICAST_PORT);
        Enumeration<NetworkInterface> ifs =
                NetworkInterface.getNetworkInterfaces();

        while (ifs.hasMoreElements()) {
            NetworkInterface xface = ifs.nextElement();
            Enumeration<InetAddress> addrs = xface.getInetAddresses();
            String name = xface.getName();

            while (addrs.hasMoreElements()) {
                InetAddress addr = addrs.nextElement();

                System.out.println(name + " ... has addr " + addr);
            }

            if (args.contains(name)) {
                System.out.println("Adding " + name + " to our interface set");
                socket.joinGroup(socketAddress, xface);
            }
        }

        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (true) {
            try {
                packet.setData(buffer, 0, buffer.length);
                socket.receive(packet);
                System.out.println("Received pkt from " + packet.getAddress() +
                                   " of length " + packet.getLength());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
            throws Exception
    {
        Set<String> argSet = new HashSet<String>();
        MainTest multi = new MainTest();

        for (String arg : args) {
            argSet.add(arg);
        }

        multi.doMain(argSet);
    }
}
