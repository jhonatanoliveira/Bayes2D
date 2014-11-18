/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.main;

import com.jhonatanoliveira.bayesball.core.TeamsColor;
import com.jhonatanoliveira.bayesball.core.World;

/**
 *
 * @author jhonatanoliveira
 */
public class StartBlueWorld implements Runnable {

    private World world;
    private boolean isOn;
    
    public StartBlueWorld() {
        this.isOn = true;
    }

    @Override
    public void run() {
        this.world = new World(TeamsColor.BLUE, World.FIELD_LEFT_SIDE, "224.5.23.2", 10020, "127.0.0.1", 20011);
        while(this.isOn) {
            world.update();
            world.think();
            world.run();
            }
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public boolean isIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }
}
