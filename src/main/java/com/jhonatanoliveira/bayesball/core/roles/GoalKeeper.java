/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.core.roles;

import com.jhonatanoliveira.bayesball.core.Player;
import com.jhonatanoliveira.bayesball.core.Posture;
import com.jhonatanoliveira.bayesball.core.World;

/**
 *
 * @author jhonatanoliveira
 */
public class GoalKeeper extends PlayerRole{
    
    private float radius = 450;
    
    @Override
    public void doWhenForceStart(World world) {
        
        Posture posture = PlayerRoleCommonUtilities
            .intersectionOfACircleAndLine(
                world.getFieldSide()*world.getGeometry().getFieldLength()/2,
                0,
                world.getBall().getX(),
                world.getBall().getY(),
                this.radius,
                world.getFieldSide());
        
        for (Player player : this.getPlayers()) {
            player.setXd(posture.getX());
            player.setYd(posture.getY());
            player.setOrientationd(posture.getZ());
        }
    }
    
}
