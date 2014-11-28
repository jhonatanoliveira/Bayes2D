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
public class KIController {
    
    /*
    Controller gain.
    */
    private static float beta = (float)0.004;
    
    /*
    Raio of the robot.
    */
    private static float raio = (float)0.18;
    
    public static float velocityX(float xd, float x, float yd, float y, float psi) {
        return (float) (beta*Math.cos(psi)*(xd-x) + beta*Math.sin(psi)*(yd - y));
    }
    
    public static float velocityY(float xd, float x, float yd, float y, float psi, float psid) {
        return (float) (-beta*Math.sin(psi)*(xd - x) + beta*((1/Math.cos(psi)) - (Math.sin(psi)*Math.sin(psi))/Math.cos(psi))*(yd-y) - beta*raio*(psid-psi));
    }
    
    public static float velocityZ(float psi, float psid) {
        return (float) (600*beta*(psid - psi));
    }    
}
