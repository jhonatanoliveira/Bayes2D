/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.core.info;

import com.github.robocup_atan.atan.model.enums.ViewAngle;
import com.github.robocup_atan.atan.model.enums.ViewQuality;

/**
 *
 * @author jhonatanoliveira
 */
public class SenseBodyInfo {
    
    ViewQuality viewQuality;
    ViewAngle viewAngle;
    double stamina, unknown, effort, speedAmount, speedDirection, headAngle;
    int kickCount, dashCount, turnCount, sayCount, turnNeckCount, catchCount, moveCount, changeViewCount;

    public SenseBodyInfo(ViewQuality viewQuality, ViewAngle viewAngle, double stamina, double unknown, double effort, double speedAmount, double speedDirection, double headAngle, int kickCount, int dashCount, int turnCount, int sayCount, int turnNeckCount, int catchCount, int moveCount, int changeViewCount) {
        this.viewQuality = viewQuality;
        this.viewAngle = viewAngle;
        this.stamina = stamina;
        this.unknown = unknown;
        this.effort = effort;
        this.speedAmount = speedAmount;
        this.speedDirection = speedDirection;
        this.headAngle = headAngle;
        this.kickCount = kickCount;
        this.dashCount = dashCount;
        this.turnCount = turnCount;
        this.sayCount = sayCount;
        this.turnNeckCount = turnNeckCount;
        this.catchCount = catchCount;
        this.moveCount = moveCount;
        this.changeViewCount = changeViewCount;
    }
    
    public ViewQuality getViewQuality() {
        return viewQuality;
    }

    public void setViewQuality(ViewQuality viewQuality) {
        this.viewQuality = viewQuality;
    }

    public ViewAngle getViewAngle() {
        return viewAngle;
    }

    public void setViewAngle(ViewAngle viewAngle) {
        this.viewAngle = viewAngle;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getUnknown() {
        return unknown;
    }

    public void setUnknown(double unknown) {
        this.unknown = unknown;
    }

    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    public double getSpeedAmount() {
        return speedAmount;
    }

    public void setSpeedAmount(double speedAmount) {
        this.speedAmount = speedAmount;
    }

    public double getSpeedDirection() {
        return speedDirection;
    }

    public void setSpeedDirection(double speedDirection) {
        this.speedDirection = speedDirection;
    }

    public double getHeadAngle() {
        return headAngle;
    }

    public void setHeadAngle(double headAngle) {
        this.headAngle = headAngle;
    }

    public int getKickCount() {
        return kickCount;
    }

    public void setKickCount(int kickCount) {
        this.kickCount = kickCount;
    }

    public int getDashCount() {
        return dashCount;
    }

    public void setDashCount(int dashCount) {
        this.dashCount = dashCount;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public int getSayCount() {
        return sayCount;
    }

    public void setSayCount(int sayCount) {
        this.sayCount = sayCount;
    }

    public int getTurnNeckCount() {
        return turnNeckCount;
    }

    public void setTurnNeckCount(int turnNeckCount) {
        this.turnNeckCount = turnNeckCount;
    }

    public int getCatchCount() {
        return catchCount;
    }

    public void setCatchCount(int catchCount) {
        this.catchCount = catchCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getChangeViewCount() {
        return changeViewCount;
    }

    public void setChangeViewCount(int changeViewCount) {
        this.changeViewCount = changeViewCount;
    }
    
    
}
