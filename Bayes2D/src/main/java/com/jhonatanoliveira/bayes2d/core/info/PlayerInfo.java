/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.core.info;

/**
 *
 * @author jhonatanoliveira
 */
public class PlayerInfo {
    int number;
    boolean goalie;
    double distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection;

    public PlayerInfo(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        this.number = number;
        this.goalie = goalie;
        this.distance = distance;
        this.direction = direction;
        this.distChange = distChange;
        this.dirChange = dirChange;
        this.bodyFacingDirection = bodyFacingDirection;
        this.headFacingDirection = headFacingDirection;
    }

    public int getNumber() {
        return number;
    }

    public boolean isGoalie() {
        return goalie;
    }

    public double getDistance() {
        return distance;
    }

    public double getDirection() {
        return direction;
    }

    public double getDistChange() {
        return distChange;
    }

    public double getDirChange() {
        return dirChange;
    }

    public double getBodyFacingDirection() {
        return bodyFacingDirection;
    }

    public double getHeadFacingDirection() {
        return headFacingDirection;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGoalie(boolean goalie) {
        this.goalie = goalie;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void setDistChange(double distChange) {
        this.distChange = distChange;
    }

    public void setDirChange(double dirChange) {
        this.dirChange = dirChange;
    }

    public void setBodyFacingDirection(double bodyFacingDirection) {
        this.bodyFacingDirection = bodyFacingDirection;
    }

    public void setHeadFacingDirection(double headFacingDirection) {
        this.headFacingDirection = headFacingDirection;
    }
    
}
