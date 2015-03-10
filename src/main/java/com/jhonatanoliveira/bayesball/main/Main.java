/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.main;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonatanoliveira
 */
public class Main {
    
    /**
     *  Initial function.
     * @param args Terminal arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando...");
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        StartBlueWorld startBlueWorld = new StartBlueWorld();
        Thread t1 = new Thread(startBlueWorld);
        t1.setDaemon(true);
        t1.start();
        
        StartBnYellowWorld startYellowWorld = new StartBnYellowWorld();
        Thread t2 = new Thread(startYellowWorld);
        t2.setDaemon(true);
        t2.start();
       
        Scanner userInput = new Scanner(System.in);
        String userAnswer;
        do {
            // as if user wants more
            System.out.println("Quit? (q => Quit): ");
            userAnswer = userInput.nextLine();
        } while(!"q".equals(userAnswer));
        
        System.out.println("Turn off thread");
        startBlueWorld.setIsOn(false);
        System.out.println("Turn off the World");
        startBlueWorld.getWorld().turnOff();
        System.out.println("Bye");
    }
    
}
