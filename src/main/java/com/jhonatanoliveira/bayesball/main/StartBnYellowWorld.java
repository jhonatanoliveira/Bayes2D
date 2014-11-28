/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.main;

import COM.hugin.HAPI.ExceptionHugin;
import com.jhonatanoliveira.bayesball.core.BayesBallWorld;
import com.jhonatanoliveira.bayesball.core.TeamsColor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonatanoliveira
 */
public class StartBnYellowWorld implements Runnable {

    private BayesBallWorld bayesBallWorld;
    private boolean isOn;
    
    public StartBnYellowWorld() {
        this.isOn = true;
    }

    @Override
    public void run() {
        try {
            this.bayesBallWorld = new BayesBallWorld(TeamsColor.YELLOW, bayesBallWorld.FIELD_RIGHT_SIDE, "224.5.23.2", 10020, "127.0.0.1", 20011);
        } catch (ExceptionHugin ex) {
            Logger.getLogger(StartBnYellowWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(this.isOn) {
            bayesBallWorld.update();
            bayesBallWorld.think();
            bayesBallWorld.run();
            }
    }

    public BayesBallWorld getWorld() {
        return bayesBallWorld;
    }

    public void setWorld(BayesBallWorld world) {
        this.bayesBallWorld = world;
    }

    public boolean isIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }
}
