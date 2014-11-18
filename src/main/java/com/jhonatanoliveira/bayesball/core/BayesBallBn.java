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
public class BayesBallBn {
    
    private World world;
    private Player player;

    public BayesBallBn() {
    }
    
    public void setUp(World world, Player player) {
        this.world = world;
        this.player = player;
    }
    
    public boolean distanceRobotBall() {
        
        boolean isCurrentRobotMostCloseToBall = true;
        
        double distanceCurrentRobotToBall = Math.sqrt(
                Math.pow(player.getX()-this.world.getBall().getX(), 2)
                + Math.pow(player.getY()-this.world.getBall().getY(), 2));
        double distanceOtherRobotToBall;
        if (isCurrentRobotMostCloseToBall) {
            for (Player bluePlayer : this.world.getBlueTeam().getPlayers()) {
                distanceOtherRobotToBall = Math.sqrt(
                    Math.pow(bluePlayer.getX()-this.world.getBall().getX(), 2)
                    + Math.pow(bluePlayer.getY()-this.world.getBall().getY(), 2));
                if (distanceOtherRobotToBall < distanceCurrentRobotToBall) {
                    isCurrentRobotMostCloseToBall = false;
                    break;
                }
            }
        }
        if (isCurrentRobotMostCloseToBall) {
            for (Player yellowPlayer : this.world.getYellowTeam().getPlayers()) {
                distanceOtherRobotToBall = Math.sqrt(
                    Math.pow(yellowPlayer.getX()-this.world.getBall().getX(), 2)
                    + Math.pow(yellowPlayer.getY()-this.world.getBall().getY(), 2));
                if (distanceOtherRobotToBall < distanceCurrentRobotToBall) {
                    isCurrentRobotMostCloseToBall = false;
                    break;
                }
            }
        }
        
        return isCurrentRobotMostCloseToBall;
    }
    
    public boolean velocityDirection() {
        boolean isCurrentRobotInDirectionOfBall = false;
        float velX = this.player.getX() - this.player.getLastX();
        float velY = this.player.getY() - this.player.getLastY();
        if ((
                (velX > 0 && this.world.getBall().getX() > this.player.getX()) &&
                (velY > 0 && this.world.getBall().getY() > this.player.getY())
                )||(
                (velX < 0 && this.world.getBall().getX() < this.player.getX()) &&
                (velY < 0 && this.world.getBall().getY() < this.player.getY())
                )) {
            isCurrentRobotInDirectionOfBall = true;
        }
        return isCurrentRobotInDirectionOfBall;
    }
    
    public boolean playerQuantityCloseToBall() {
        double distanceOtherRobotToBall;
        int robotCloseToBall = 0;
        for (Player bluePlayer : this.world.getBlueTeam().getPlayers()) {
            distanceOtherRobotToBall = Math.sqrt(
                Math.pow(bluePlayer.getX()-this.world.getBall().getX(), 2)
                + Math.pow(bluePlayer.getY()-this.world.getBall().getY(), 2));
            if (distanceOtherRobotToBall < 600) {
                robotCloseToBall++;
            }
        }
        System.out.println(robotCloseToBall);
        return robotCloseToBall > 0;
    }
    
    public void decidePlayerRole() {
        
    }
    
}
