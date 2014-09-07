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
public class HearPlayerInfo {
    
    double direction;
    String message;

    public HearPlayerInfo(double direction, String message) {
        this.direction = direction;
        this.message = message;
    }
    
    public double getDirection() {
        return direction;
    }

    public String getMessage() {
        return message;
    }
    
    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
