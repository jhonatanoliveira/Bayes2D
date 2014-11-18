/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonatanoliveira.bayesball.core.roles;

import com.jhonatanoliveira.bayesball.core.Posture;
import com.jhonatanoliveira.bayesball.core.World;

/**
 *
 * @author jhonatanoliveira
 */
public class PlayerRoleCommonUtilities {
    
    public static Posture intersectionOfACircleAndLine(float xc, float yc, float xr, float yr, float radius, int side) {
        
        Posture[] postures = new Posture[2];
        postures[0] = new Posture();
        postures[1] = new Posture();
        Posture chosenPosture = new Posture();
        
        float m = ((yc/xc) - ((yr*xc - yc*xr)/(xc*xc - xr*xc)));
        float b = (yr*xc - yc*xr)/(xc - xr);
        float A = 1 + m*m;
        float B = -2*xc+2*m*b-2*yc*m;
        float C = xc*xc+b*b+yc*yc-2*yc*b-radius*radius;
        float delta = B*B-4*A*C;
        if(delta >= 0){
            postures[0].setX( (float) (-B+Math.sqrt(delta))/(2*A) );
            postures[0].setY((float) m * postures[0].getX() + b);
            postures[1].setX( (float) (-B-Math.sqrt(delta))/(2*A) );
            postures[1].setY((float) m * postures[1].getX() + b);
        }
        
        if (side == World.FIELD_LEFT_SIDE) {
            if (postures[0].getX() > postures[1].getX()) {
                chosenPosture.setX(postures[0].getX());
                chosenPosture.setY(postures[0].getY());
            } else {
                chosenPosture.setX(postures[1].getX());
                chosenPosture.setY(postures[1].getY());
            }
            chosenPosture.setZ((float) Math.atan(m));
        } else {
            if (postures[0].getX() < postures[1].getX()) {
                chosenPosture.setX(postures[0].getX());
                chosenPosture.setY(postures[0].getY());
            } else {
                chosenPosture.setX(postures[1].getX());
                chosenPosture.setY(postures[1].getY());
            }
            if (m > 0) {
                chosenPosture.setZ((float) (Math.atan(m) - Math.PI));
            } else {
                chosenPosture.setZ((float) (Math.atan(m) + Math.PI));
            }
        }
        
        return chosenPosture;
    }
    
    public static float lineAngle(float xA, float yA, float xB, float yB) {
        float possibleAngle = (float) Math.atan((yB-yA)/(xB-xA));
        return possibleAngle;
    }
    
}
