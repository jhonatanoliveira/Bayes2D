/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.core;

import com.jhonatanoliveira.bayesball.protobuf.GrSimCommands;
import com.jhonatanoliveira.bayesball.protobuf.GrSimPacket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonatanoliveira
 */
public class GrSimClient {
    
    private final String address;
    private final int port;
    private HashSet<GrSimPlayerCommand> grSimTeamPlayerCommands;
    private DatagramSocket socket;

    public GrSimClient() {
        this("127.0.0.1", 20011);
    }

    public GrSimClient(String address, int port) {
        this.address = address;
        this.port = port;
        this.grSimTeamPlayerCommands = new HashSet<>();
        try {
            this.socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(GrSimClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addTeamCommand(GrSimPlayerCommand grSimPlayerCommand) {
        return this.grSimTeamPlayerCommands.add(grSimPlayerCommand);
    }
    
    public void sendTeamCommand(boolean isTeamYellow) {
        GrSimCommands.grSim_Commands.Builder commandBuilder = GrSimCommands.grSim_Commands.newBuilder()
                .setTimestamp(0)
                .setIsteamyellow(isTeamYellow);
        
        for (GrSimPlayerCommand grSimCommand : this.grSimTeamPlayerCommands) {
            GrSimCommands.grSim_Robot_Command command = GrSimCommands.grSim_Robot_Command.newBuilder()
                .setId(grSimCommand.id)
                .setWheel2(grSimCommand.wheel2)
                .setWheel1(grSimCommand.wheel1)
                .setWheel3(grSimCommand.wheel3)
                .setWheel4(grSimCommand.wheel4)
                .setKickspeedx(grSimCommand.kickspeedx)
                .setKickspeedz(grSimCommand.kickspeedz)
                .setVeltangent(grSimCommand.velx)
                .setVelnormal(grSimCommand.vely)
                .setVelangular(grSimCommand.velz)
                .setSpinner(grSimCommand.spinner)
                .setWheelsspeed(grSimCommand.wheelSpeed)
                .build();
                commandBuilder.addRobotCommands(command);
        }
        GrSimCommands.grSim_Commands teamCommands = commandBuilder.build();
        GrSimPacket.grSim_Packet packet = GrSimPacket.grSim_Packet.newBuilder().setCommands(teamCommands).build();
        byte [] buffer = packet.toByteArray();
        DatagramPacket dp = null;
        try {
            dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(this.address),this.port);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GrSimClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.socket.send(dp);
            this.grSimTeamPlayerCommands.clear();
        } catch (IOException ex) {
            Logger.getLogger(GrSimClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeConnection() {
        this.socket.close();
    }
    
}
