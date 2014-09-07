/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.impl.BasicTeam;

/**
 *
 * @author jhonatanoliveira
 */
public class Main {

    public static void main(String args[]) {
        BasicTeam bayes2dTeam = new BasicTeam("Bayes2d", 6000, "localhost", false);
        bayes2dTeam.connectAll();
    }
}
