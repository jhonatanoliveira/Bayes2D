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
public class Geometry {
    int lineWidth;
    int fieldLength;
    int fieldWidth;
    int boundaryWidth;
    int refereeWidth;
    int goalWidth;
    int goalDepth;
    int goalWallWidth;
    int centerCircleRadius;
    int defenseStretch;
    int freeKickFromDefenseDist;
    int penaltySpotFromFieldLineDist;
    int penaltyLineFromSpotDist;

    public Geometry() {
        this.lineWidth = 0;
        this.fieldLength = 6050;
        this.fieldWidth = 0;
        this.boundaryWidth = 0;
        this.refereeWidth = 0;
        this.goalWidth = 0;
        this.goalDepth = 0;
        this.goalWallWidth = 0;
        this.centerCircleRadius = 0;
        this.defenseStretch = 0;
        this.freeKickFromDefenseDist = 0;
        this.penaltySpotFromFieldLineDist = 0;
        this.penaltyLineFromSpotDist = 0;
    }

    public Geometry(int lineWidth, int fieldLength, int fieldWidth, int boundaryWidth, int refereeWidth, int goalWidth, int goalDepth, int goalWallWidth, int centerCircleRadius, int defenseStretch, int freeKickFromDefenseDist, int penaltySpotFromFieldLineDist, int penaltyLineFromSpotDist) {
        this.lineWidth = lineWidth;
        this.fieldLength = fieldLength;
        this.fieldWidth = fieldWidth;
        this.boundaryWidth = boundaryWidth;
        this.refereeWidth = refereeWidth;
        this.goalWidth = goalWidth;
        this.goalDepth = goalDepth;
        this.goalWallWidth = goalWallWidth;
        this.centerCircleRadius = centerCircleRadius;
        this.defenseStretch = defenseStretch;
        this.freeKickFromDefenseDist = freeKickFromDefenseDist;
        this.penaltySpotFromFieldLineDist = penaltySpotFromFieldLineDist;
        this.penaltyLineFromSpotDist = penaltyLineFromSpotDist;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(int fieldLength) {
        this.fieldLength = fieldLength;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth(int fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    public int getBoundaryWidth() {
        return boundaryWidth;
    }

    public void setBoundaryWidth(int boundaryWidth) {
        this.boundaryWidth = boundaryWidth;
    }

    public int getRefereeWidth() {
        return refereeWidth;
    }

    public void setRefereeWidth(int refereeWidth) {
        this.refereeWidth = refereeWidth;
    }

    public int getGoalWidth() {
        return goalWidth;
    }

    public void setGoalWidth(int goalWidth) {
        this.goalWidth = goalWidth;
    }

    public int getGoalDepth() {
        return goalDepth;
    }

    public void setGoalDepth(int goalDepth) {
        this.goalDepth = goalDepth;
    }

    public int getGoalWallWidth() {
        return goalWallWidth;
    }

    public void setGoalWallWidth(int goalWallWidth) {
        this.goalWallWidth = goalWallWidth;
    }

    public int getCenterCircleRadius() {
        return centerCircleRadius;
    }

    public void setCenterCircleRadius(int centerCircleRadius) {
        this.centerCircleRadius = centerCircleRadius;
    }

    public int getDefenseStretch() {
        return defenseStretch;
    }

    public void setDefenseStretch(int defenseStretch) {
        this.defenseStretch = defenseStretch;
    }

    public int getFreeKickFromDefenseDist() {
        return freeKickFromDefenseDist;
    }

    public void setFreeKickFromDefenseDist(int freeKickFromDefenseDist) {
        this.freeKickFromDefenseDist = freeKickFromDefenseDist;
    }

    public int getPenaltySpotFromFieldLineDist() {
        return penaltySpotFromFieldLineDist;
    }

    public void setPenaltySpotFromFieldLineDist(int penaltySpotFromFieldLineDist) {
        this.penaltySpotFromFieldLineDist = penaltySpotFromFieldLineDist;
    }

    public int getPenaltyLineFromSpotDist() {
        return penaltyLineFromSpotDist;
    }

    public void setPenaltyLineFromSpotDist(int penaltyLineFromSpotDist) {
        this.penaltyLineFromSpotDist = penaltyLineFromSpotDist;
    }
    
    
}
