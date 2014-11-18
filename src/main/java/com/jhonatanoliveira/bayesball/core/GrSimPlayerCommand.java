/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.core;

/**
 *
 * @author jhonatanoliveira
 */
public class GrSimPlayerCommand {
    
    int port, id;
    byte [] buffer2;
    int envio = 1;
    float timeStamp, wheel1, wheel2, wheel3, wheel4, kickspeedx, kickspeedz, velx, vely, velz;
    boolean spinner, wheelSpeed, teamYellow;

    public GrSimPlayerCommand() {
        timeStamp=0;
        wheel1=0;
        wheel2=0;
        wheel3=0;
        wheel4=0;
        kickspeedx=0;
        kickspeedz=0;
        velx=0;
        vely=0;
        velz=0;
        id=0;
        spinner=false;
        wheelSpeed=false;
        teamYellow=false;
    }

    public GrSimPlayerCommand(int port, int id, byte[] buffer2, float timeStamp, float wheel1, float wheel2, float wheel3, float wheel4, float kickspeedx, float kickspeedz, float velx, float vely, float velz, boolean spinner, boolean wheelSpeed, boolean teamYellow) {
        this.port = port;
        this.id = id;
        this.buffer2 = buffer2;
        this.timeStamp = timeStamp;
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
        this.wheel4 = wheel4;
        this.kickspeedx = kickspeedx;
        this.kickspeedz = kickspeedz;
        this.velx = velx;
        this.vely = vely;
        this.velz = velz;
        this.spinner = spinner;
        this.wheelSpeed = wheelSpeed;
        this.teamYellow = teamYellow;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getBuffer2() {
        return buffer2;
    }

    public void setBuffer2(byte[] buffer2) {
        this.buffer2 = buffer2;
    }

    public int getEnvio() {
        return envio;
    }

    public void setEnvio(int envio) {
        this.envio = envio;
    }

    public float getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(float timeStamp) {
        this.timeStamp = timeStamp;
    }

    public float getWheel1() {
        return wheel1;
    }

    public void setWheel1(float wheel1) {
        this.wheel1 = wheel1;
    }

    public float getWheel2() {
        return wheel2;
    }

    public void setWheel2(float wheel2) {
        this.wheel2 = wheel2;
    }

    public float getWheel3() {
        return wheel3;
    }

    public void setWheel3(float wheel3) {
        this.wheel3 = wheel3;
    }

    public float getWheel4() {
        return wheel4;
    }

    public void setWheel4(float wheel4) {
        this.wheel4 = wheel4;
    }

    public float getKickspeedx() {
        return kickspeedx;
    }

    public void setKickspeedx(float kickspeedx) {
        this.kickspeedx = kickspeedx;
    }

    public float getKickspeedz() {
        return kickspeedz;
    }

    public void setKickspeedz(float kickspeedz) {
        this.kickspeedz = kickspeedz;
    }

    public float getVelx() {
        return velx;
    }

    public void setVelx(float velx) {
        this.velx = velx;
    }

    public float getVely() {
        return vely;
    }

    public void setVely(float vely) {
        this.vely = vely;
    }

    public float getVelz() {
        return velz;
    }

    public void setVelz(float velz) {
        this.velz = velz;
    }

    public boolean isSpinner() {
        return spinner;
    }

    public void setSpinner(boolean spinner) {
        this.spinner = spinner;
    }

    public boolean isWheelSpeed() {
        return wheelSpeed;
    }

    public void setWheelSpeed(boolean wheelSpeed) {
        this.wheelSpeed = wheelSpeed;
    }

    public boolean isTeamYellow() {
        return teamYellow;
    }

    public void setTeamYellow(boolean teamYellow) {
        this.teamYellow = teamYellow;
    }
    
    
}
