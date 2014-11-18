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
public class Player {
    
    private int id;
    private float x;
    private float y;
    private float orientation;
    private float lastX;
    private float lastY;
    private float lastOrientation;
    private float height;
    private float xd;
    private float yd;
    private float orientationd;
    private float lastXd;
    private float lastYd;
    private float lastOrientationd;
    private float kickspeedx;
    private float kickspeedz;
    private float velx;
    private float vely;
    private float velz;

    public Player() {
        this(0);
        
    }

    public Player(int id) {
        this.id = id;
        this.x = 0;
        this.y = 0;
        this.orientation = 0;
        this.height = 0;
        this.xd = 0;
        this.yd = 0;
        this.orientationd = 0;
        this.lastXd = 0;
        this.lastYd = 0;
        this.lastOrientationd = 0;
        this.kickspeedx = 0;
        this.kickspeedz = 0;
        this.velx = 0;
        this.vely = 0;
        this.velz = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.lastX = this.getX();
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.lastY = this.y;
        this.y = y;
    }

    public float getOrientation() {
        return orientation;
    }

    public void setOrientation(float orientation) {
        this.lastOrientation = this.orientation;
        this.orientation = orientation;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getXd() {
        return xd;
    }

    public void setXd(float xd) {
        this.setLastXd(xd);
        this.xd = xd;
    }

    public float getYd() {
        return yd;
    }

    public void setYd(float yd) {
        this.setLastYd(yd);
        this.yd = yd;
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

    public float getOrientationd() {
        return orientationd;
    }

    public void setOrientationd(float orientationd) {
        this.setLastOrientationd(orientationd);
        this.orientationd = orientationd;
    }

    public float getLastXd() {
        return lastXd;
    }

    public void setLastXd(float lastXd) {
        this.lastXd = lastXd;
    }

    public float getLastYd() {
        return lastYd;
    }

    public void setLastYd(float lastYd) {
        this.lastYd = lastYd;
    }

    public float getLastOrientationd() {
        return lastOrientationd;
    }

    public void setLastOrientationd(float lastOrientationd) {
        this.lastOrientationd = lastOrientationd;
    }

    public float getLastX() {
        return lastX;
    }

    public void setLastX(float lastX) {
        this.lastX = lastX;
    }

    public float getLastY() {
        return lastY;
    }

    public void setLastY(float lastY) {
        this.lastY = lastY;
    }

    public float getLastOrientation() {
        return lastOrientation;
    }

    public void setLastOrientation(float lastOrientation) {
        this.lastOrientation = lastOrientation;
    }
    
    
}
