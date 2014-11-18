/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.core;

import com.jhonatanoliveira.bayesball.protobuf.MessagesRobocupSslWrapper;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/**
 *
 * @author jhonatanoliveira
 */
public class SslVisionClient {
    
    private final int serverPort;
    private final String serverAddress;
    private MulticastSocket socket;
    private InetAddress dtAddress;
    private DatagramPacket packet;
    private byte[] buffer;
    
    public SslVisionClient() {
        this("224.5.23.2",10020);
    }

    public SslVisionClient(String serverAddress,int serverPort) {
        this.serverPort = serverPort;
        this.serverAddress = serverAddress;
    }
    
    public void connect() throws UnknownHostException, IOException {
        this.dtAddress = InetAddress.getByName(this.serverAddress);
        this.buffer = new byte[1000];
        this.packet = new DatagramPacket(this.buffer, this.buffer.length);
        this.socket = new MulticastSocket(this.serverPort);
        this.socket.joinGroup(new InetSocketAddress(this.serverAddress, this.serverPort), NetworkInterface.getByName("en0"));
    }
    
    public void disconnect() throws IOException {
        this.socket.leaveGroup(this.dtAddress);
    }
    
    public MessagesRobocupSslWrapper.SSL_WrapperPacket receive() throws IOException {
        this.socket.receive(this.packet);
        byte[] tmp = new byte[this.packet.getLength()];
        System.arraycopy(this.buffer, 0, tmp, 0, this.packet.getLength());
        return MessagesRobocupSslWrapper.SSL_WrapperPacket.parseFrom(tmp);
    }
    
    public MulticastSocket getSocket() {
        return socket;
    }

    public void setSocket(MulticastSocket socket) {
        this.socket = socket;
    }

    public InetAddress getDtAddress() {
        return dtAddress;
    }

    public void setDtAddress(InetAddress dtAddress) {
        this.dtAddress = dtAddress;
    }

    public DatagramPacket getPacket() {
        return packet;
    }

    public void setPacket(DatagramPacket packet) {
        this.packet = packet;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }
}
