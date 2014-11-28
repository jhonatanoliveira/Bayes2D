/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonatanoliveira.bayesball.core;

import COM.hugin.HAPI.*;
import com.jhonatanoliveira.bayesball.core.roles.PlayerRoleEnum;

/**
 *
 * @author jhonatanoliveira
 */
public class BayesBallBn {
    
    private World world;
    private Player player;
    private Domain domain;

    public BayesBallBn(String netLocation) throws ExceptionHugin {
        ParseListener parseListener = new DefaultClassParseListener();
        this.domain = new Domain (netLocation, parseListener);
        this.domain.openLogFile(netLocation + ".log");
        this.domain.triangulate(Domain.H_TM_BEST_GREEDY);
        this.domain.compile();
        this.domain.closeLogFile();
    }
    
    public void setUp(World world, Player player) {
        this.world = world;
        this.player = player;
    }
    
    public boolean distanceRobotBall() {
        
        boolean isCurrentRobotMostCloseToBall = true;
        
        double distanceCurrentRobotToBall = Math.sqrt(
                Math.pow(this.player.getX()-this.world.getBall().getX(), 2)
                + Math.pow(this.player.getY()-this.world.getBall().getY(), 2));
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
        return robotCloseToBall > 0;
    }
    
    public boolean fieldArea() {
        return this.player.getX() < 0;
    }
    
    public PlayerRoleEnum decidePlayerRole() throws ExceptionHugin{
        this.domain.retractFindings();
        
        LabelledDCNode direcaoVetorVelocidadeNode = (LabelledDCNode) this.domain.getNodeByName("Direcao_Vetor_Velocidade");
        if(this.velocityDirection()) { direcaoVetorVelocidadeNode.selectState(0); } else { direcaoVetorVelocidadeNode.selectState(1); }
        
        LabelledDCNode distanciaRoboBolaNode = (LabelledDCNode) this.domain.getNodeByName("Distancia_Robos_Bola");
        if(this.distanceRobotBall()) { distanciaRoboBolaNode.selectState(1); } else { distanciaRoboBolaNode.selectState(0); }
        
        LabelledDCNode quantidadeAdversarioNode = (LabelledDCNode) this.domain.getNodeByName("Quantidade_Adversario");
        if(this.playerQuantityCloseToBall()) { quantidadeAdversarioNode.selectState(1); } else { quantidadeAdversarioNode.selectState(0); }
        
        LabelledDCNode areaCampoNode = (LabelledDCNode) this.domain.getNodeByName("Area_No_Campo");
        if(this.fieldArea()) { areaCampoNode.selectState(1); } else { areaCampoNode.selectState(0); }
        
        this.domain.propagate (Domain.H_EQUILIBRIUM_SUM,Domain.H_EVIDENCE_MODE_NORMAL);
        
        LabelledDCNode papelJogadorNode = (LabelledDCNode) this.domain.getNodeByName("Papel_Jogador");
        
        double currentBelief = 0;
        double bestBelief = 0;
        PlayerRoleEnum selectedPlayerRoleEnum = PlayerRoleEnum.Defender;
        for (int i=0; i<3; i++) {
            currentBelief = papelJogadorNode.getBelief(i);
            if (currentBelief > bestBelief) {
                bestBelief = currentBelief;
                switch (i) {
                    case 0:
                        selectedPlayerRoleEnum = PlayerRoleEnum.GoalKeeper;
                        break;
                    case 1:
                        selectedPlayerRoleEnum = PlayerRoleEnum.Defender;
                        break;
                    case 2:
                        selectedPlayerRoleEnum = PlayerRoleEnum.BallFollower;
                        break;
                }
            }
        }
        
        return selectedPlayerRoleEnum;
    }
    
    /**
     * Are there utility nodes in the list?
     */
    public static boolean containsUtilities (NodeList list) {
        java.util.ListIterator it = list.listIterator();

        while (it.hasNext())
            if (it.next() instanceof UtilityNode)
                return true;

        return false;
    }
    
}
