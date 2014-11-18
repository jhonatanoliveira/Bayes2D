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
public class Posture {
    
    private float x;
    private float y;
    private float z;
    private int side;

    public Posture() {
        this(0,0,0,World.FIELD_RIGHT_SIDE);
    }
    
    public Posture(float x, float y, float z, int side) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.side = side;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
    
}
