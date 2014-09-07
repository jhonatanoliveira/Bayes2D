/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.core;

/**
 *
 * @author jhonatanoliveira
 */
public interface Bayes2dPlayerRole {
    
    public void doWhenBeforeKickOff(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenTimeOver(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenPlayOn(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenKickOffOwn(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenKickOffOther(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenKickInOwn(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenKickInOther(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenFreeKickOwn(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenFreeKickOther(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenFreeKickFaultOwn(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenFreeKickFaultOther(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenCornerKickOwn(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenCornerKickOther(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenGoalKickOwn(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenGoalKickOther(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenGoalOwn(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenGoalOther(Bayes2dControllerPlayer bayes2dPlayer);
    
    public void doWhenPrepareDefense(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenDefense(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenPrepareAttack(Bayes2dControllerPlayer bayes2dPlayer);
    public void doWhenAttack(Bayes2dControllerPlayer bayes2dPlayer);
    
}
