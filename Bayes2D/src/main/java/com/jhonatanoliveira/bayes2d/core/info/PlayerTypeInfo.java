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
public class PlayerTypeInfo {
    int id;
    double playerSpeedMax, staminaIncMax, playerDecay, inertiaMoment, dashPowerRate, playerSize, kickableMargin, kickRand, extraStamina, effortMax, effortMin;

    public PlayerTypeInfo(int id, double playerSpeedMax, double staminaIncMax, double playerDecay, double inertiaMoment, double dashPowerRate, double playerSize, double kickableMargin, double kickRand, double extraStamina, double effortMax, double effortMin) {
        this.id = id;
        this.playerSpeedMax = playerSpeedMax;
        this.staminaIncMax = staminaIncMax;
        this.playerDecay = playerDecay;
        this.inertiaMoment = inertiaMoment;
        this.dashPowerRate = dashPowerRate;
        this.playerSize = playerSize;
        this.kickableMargin = kickableMargin;
        this.kickRand = kickRand;
        this.extraStamina = extraStamina;
        this.effortMax = effortMax;
        this.effortMin = effortMin;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPlayerSpeedMax() {
        return playerSpeedMax;
    }

    public void setPlayerSpeedMax(double playerSpeedMax) {
        this.playerSpeedMax = playerSpeedMax;
    }

    public double getStaminaIncMax() {
        return staminaIncMax;
    }

    public void setStaminaIncMax(double staminaIncMax) {
        this.staminaIncMax = staminaIncMax;
    }

    public double getPlayerDecay() {
        return playerDecay;
    }

    public void setPlayerDecay(double playerDecay) {
        this.playerDecay = playerDecay;
    }

    public double getInertiaMoment() {
        return inertiaMoment;
    }

    public void setInertiaMoment(double inertiaMoment) {
        this.inertiaMoment = inertiaMoment;
    }

    public double getDashPowerRate() {
        return dashPowerRate;
    }

    public void setDashPowerRate(double dashPowerRate) {
        this.dashPowerRate = dashPowerRate;
    }

    public double getPlayerSize() {
        return playerSize;
    }

    public void setPlayerSize(double playerSize) {
        this.playerSize = playerSize;
    }

    public double getKickableMargin() {
        return kickableMargin;
    }

    public void setKickableMargin(double kickableMargin) {
        this.kickableMargin = kickableMargin;
    }

    public double getKickRand() {
        return kickRand;
    }

    public void setKickRand(double kickRand) {
        this.kickRand = kickRand;
    }

    public double getExtraStamina() {
        return extraStamina;
    }

    public void setExtraStamina(double extraStamina) {
        this.extraStamina = extraStamina;
    }

    public double getEffortMax() {
        return effortMax;
    }

    public void setEffortMax(double effortMax) {
        this.effortMax = effortMax;
    }

    public double getEffortMin() {
        return effortMin;
    }

    public void setEffortMin(double effortMin) {
        this.effortMin = effortMin;
    }
    
}
