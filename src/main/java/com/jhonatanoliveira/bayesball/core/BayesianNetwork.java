/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonatanoliveira.bayesball.core;

import COM.hugin.HAPI.Domain;
import COM.hugin.HAPI.ExceptionHugin;
import COM.hugin.HAPI.NumberedDCNode;
import java.awt.geom.Point2D;

/**
 *
 * @author jhonatanoliveira
 */
public class BayesianNetwork {
    
    public BayesianNetwork() throws ExceptionHugin {
        
        Domain domain = new Domain();
        domain.setNodeSize (new Point2D.Double (50, 30));
        
        NumberedDCNode nodeVelocityDirection = new NumberedDCNode (domain);
        nodeVelocityDirection.setNumberOfStates(2);
        nodeVelocityDirection.setStateLabel(0, "Ball_Direction");
        nodeVelocityDirection.setStateLabel(1, "Not_Ball_Direction");
        nodeVelocityDirection.setStateValue(0, 0.5);
        nodeVelocityDirection.setStateValue(1, 0.5);
        nodeVelocityDirection.setLabel("In_Ball_Direction");
        nodeVelocityDirection.setName("ball_direction");
        
        NumberedDCNode nodePossibilityOfTakingBall = new NumberedDCNode (domain);
        nodePossibilityOfTakingBall.setNumberOfStates(3);
        nodePossibilityOfTakingBall.setStateLabel(0, "low");
        nodePossibilityOfTakingBall.setStateLabel(1, "medium");
        nodePossibilityOfTakingBall.setStateLabel(2, "high_possibility");
        nodePossibilityOfTakingBall.setLabel("Possibility_Of_Taking_The_Ball");
        nodePossibilityOfTakingBall.setName("possibility_of_taking_the_ball");
    }
    
}
