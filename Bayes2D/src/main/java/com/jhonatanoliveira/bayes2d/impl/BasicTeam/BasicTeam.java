/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.impl.BasicTeam;

import com.github.robocup_atan.atan.model.AbstractTeam;
import com.github.robocup_atan.atan.model.ControllerCoach;
import com.github.robocup_atan.atan.model.ControllerPlayer;
import com.jhonatanoliveira.bayes2d.core.Bayes2dCoach;

/**
 *
 * @author jhonatanoliveira
 */
public class BasicTeam extends AbstractTeam {
   
    
    public BasicTeam(String teamName) {
        super(teamName);
    }

    public BasicTeam(String teamName, int port, String host, boolean hasCoach) {
        super(teamName, port, host, hasCoach);
    }

    @Override
    public ControllerPlayer getNewControllerPlayer(int i) {
        return new BasicControllerPlayer();
    }

    @Override
    public ControllerCoach getNewControllerCoach() {
        return new Bayes2dCoach();
    }
    
}
