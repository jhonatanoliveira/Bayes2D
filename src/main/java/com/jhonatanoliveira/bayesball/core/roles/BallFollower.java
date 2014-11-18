/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonatanoliveira.bayesball.core.roles;

import com.jhonatanoliveira.bayesball.core.Player;
import com.jhonatanoliveira.bayesball.core.World;

/**
 *
 * @author jhonatanoliveira
 */
public class BallFollower extends PlayerRole {
    
    private static final float DISTANCE_FROM_BALL = 150;
    private static final float ERROR_TOLERANCE = 50;
    
    @Override
    public void doWhenForceStart(World world) {
        for (Player player : this.getPlayers()) {
            float lineAngle = PlayerRoleCommonUtilities.lineAngle(
                        player.getX(), player.getY(),
                        world.getGeometry().getFieldLength()/2, 0);
            float playerDesiredX = world.getBall().getX() - (-1) * world.getFieldSide() * DISTANCE_FROM_BALL * (float)Math.cos(lineAngle);
            float playerDesiredY = world.getBall().getY() - (-1) * DISTANCE_FROM_BALL * (float)Math.sin(lineAngle);
            
            if (Math.abs(player.getX() - playerDesiredX) <= ERROR_TOLERANCE && Math.abs(player.getY() - playerDesiredY) <= ERROR_TOLERANCE) {
                player.setXd((-1) *world.getFieldSide() * world.getGeometry().getFieldLength()/2);
                player.setYd(0);
            } else {
                player.setXd(playerDesiredX);
                player.setYd(playerDesiredY);
                if (world.getFieldSide() == World.FIELD_LEFT_SIDE) {
                    player.setOrientationd((float) lineAngle);
                } else {
                    if (lineAngle > 0) {
                        player.setOrientationd((float) (lineAngle - Math.PI));
                    } else {
                        player.setOrientationd((float) (lineAngle + Math.PI));
                    }
                }
            }
        }
    }
}
