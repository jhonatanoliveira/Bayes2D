/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.core;

import com.jhonatanoliveira.bayesball.core.roles.BallFollower;
import com.jhonatanoliveira.bayesball.core.roles.Defender;
import com.jhonatanoliveira.bayesball.core.roles.GoalKeeper;
import com.jhonatanoliveira.bayesball.main.Main;
import com.jhonatanoliveira.bayesball.protobuf.MessagesRobocupSslDetection;
import com.jhonatanoliveira.bayesball.protobuf.MessagesRobocupSslGeometry;
import com.jhonatanoliveira.bayesball.protobuf.MessagesRobocupSslWrapper;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonatanoliveira
 */
public class World {
    
    protected Ball ball;
    protected Team blueTeam;
    protected Team yellowTeam;
    protected TeamsColor teamsColor;
    protected SslVisionClient sslVisionclient;
    protected GrSimClient grSimClient;
    protected Geometry geometry;
    protected GameSituations gameSituation;
    protected GoalKeeper goalKeepers;
    protected Defender defenders;
    protected BallFollower ballFollowers;
    protected int fieldSide;
    
    // Constantes
    public static int FIELD_RIGHT_SIDE = 1;
    public static int FIELD_LEFT_SIDE = -1;
    
    public World() {
        this(TeamsColor.BLUE, World.FIELD_LEFT_SIDE, "224.5.23.2",10002,"127.0.0.1",20011);
    }

    public World(TeamsColor teamsColor, int fieldSide, String sslAddress, int sslPort, String grSimAddress, int grSimPort) {
        
        this.ball = new Ball();
        
        this.geometry = new Geometry();
        
        this.blueTeam = new Team(TeamsColor.BLUE);
        for (int i = 0; i < 6; i++) {
            this.blueTeam.addPlayer(new Player(i));
        }
        
        this.yellowTeam = new Team(TeamsColor.YELLOW);
        for (int i = 0; i < 6; i++) {
            this.yellowTeam.addPlayer(new Player(i));
        }
        
        this.teamsColor = teamsColor;
        
        this.sslVisionclient = new SslVisionClient(sslAddress,sslPort);
        try {
            sslVisionclient.connect();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.grSimClient = new GrSimClient(grSimAddress, grSimPort);
        
        this.goalKeepers = new GoalKeeper();
        this.defenders = new Defender();
        this.ballFollowers = new BallFollower();
        
        this.setFieldSide(fieldSide);
    }
    
    public MessagesRobocupSslWrapper.SSL_WrapperPacket receiveInformationsFromExternamWorld() {
        MessagesRobocupSslWrapper.SSL_WrapperPacket wrapperPacket = null;
        try {
            wrapperPacket = this.sslVisionclient.receive();
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wrapperPacket;
    }
    
    /*
    Update the World
    */
    public void update() {
        MessagesRobocupSslWrapper.SSL_WrapperPacket wrapperPacket = this.receiveInformationsFromExternamWorld();
        
        // Detection Frame
        if (wrapperPacket.hasDetection()) {
            MessagesRobocupSslDetection.SSL_DetectionFrame detectionFrame = wrapperPacket.getDetection();
            // Balls -- Take the most confident one
            MessagesRobocupSslDetection.SSL_DetectionBall mostConfidentBall = null;
            float bestConfidence = -1;
            for (MessagesRobocupSslDetection.SSL_DetectionBall ball: detectionFrame.getBallsList()) {
                if (ball.getConfidence() > bestConfidence) {
                    mostConfidentBall = ball;
                }
            }
            ball.setX(mostConfidentBall.getX());
            ball.setY(mostConfidentBall.getY());
            ball.setZ(mostConfidentBall.getZ());
            // Robots Blue
            for (MessagesRobocupSslDetection.SSL_DetectionRobot detectionRobotBlue : detectionFrame.getRobotsBlueList()) {
                for (Player player : this.blueTeam.getPlayers()) {
                    if (player.getId() == detectionRobotBlue.getRobotId()) {
                        player.setOrientation(detectionRobotBlue.getOrientation());
                        player.setX(detectionRobotBlue.getX());
                        player.setY(detectionRobotBlue.getY());
                        player.setHeight(detectionRobotBlue.getHeight());
                    }
                }
            }
            // Robots Yellow
            for (MessagesRobocupSslDetection.SSL_DetectionRobot detectionRobotYellow : detectionFrame.getRobotsYellowList()) {
                for (Player player : this.yellowTeam.getPlayers()) {
                    if (player.getId() == detectionRobotYellow.getRobotId()) {
                        player.setOrientation(detectionRobotYellow.getOrientation());
                        player.setX(detectionRobotYellow.getX());
                        player.setY(detectionRobotYellow.getY());
                        player.setHeight(detectionRobotYellow.getHeight());
                    }
                }
            }
        }
        
        // Geometry
        if (wrapperPacket.hasGeometry()) {
            MessagesRobocupSslGeometry.SSL_GeometryData geometryData = wrapperPacket.getGeometry();
            MessagesRobocupSslGeometry.SSL_GeometryFieldSize fieldSize = geometryData.getField();
            this.geometry.setBoundaryWidth(fieldSize.getBoundaryWidth());
            this.geometry.setCenterCircleRadius(fieldSize.getCenterCircleRadius());
            this.geometry.setDefenseStretch(fieldSize.getDefenseRadius());
            this.geometry.setFieldLength(fieldSize.getFieldLength());
            this.geometry.setFieldWidth(fieldSize.getFieldWidth());
            this.geometry.setFreeKickFromDefenseDist(fieldSize.getFreeKickFromDefenseDist());
            this.geometry.setGoalDepth(fieldSize.getGoalDepth());
            this.geometry.setGoalWallWidth(fieldSize.getGoalWallWidth());
            this.geometry.setGoalWidth(fieldSize.getGoalWidth());
            this.geometry.setLineWidth(fieldSize.getLineWidth());
            this.geometry.setPenaltyLineFromSpotDist(fieldSize.getPenaltyLineFromSpotDist());
            this.geometry.setPenaltySpotFromFieldLineDist(fieldSize.getPenaltySpotFromFieldLineDist());
            this.geometry.setRefereeWidth(fieldSize.getRefereeWidth());
        }
    }
    
    /*
    Run the World
    */
    public void run() {
        if (this.teamsColor == TeamsColor.YELLOW) {
            this.grSimClient.sendTeamCommand(true);
        }
        else if (this.teamsColor == TeamsColor.BLUE) {
            this.grSimClient.sendTeamCommand(false);
        }
    }
    
    /*
    Turn off the World
    */
    public void turnOff() {
        try {
            this.sslVisionclient.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.grSimClient.closeConnection();
    }
    
    /*
    Think about the World
    */
    public void thinkAboutGameSituation() {
        this.gameSituation = GameSituations.FORCE_START;
    }
    
    public void thinkAboutPlayersRoles() {
        Team team = null;
        if (this.teamsColor == TeamsColor.BLUE) {team = this.blueTeam;}
        else if (this.teamsColor == TeamsColor.YELLOW) {team = this.yellowTeam;}
        
        for (Player p : team.getPlayers()) {
            if (p.getId() == 5) {
                this.goalKeepers.addPlayer(p);
            } else if (p.getId() == 1) {
                this.defenders.addPlayer(p);
            } else if (p.getId() == 0) {
                this.defenders.addPlayer(p);
            } else if (p.getId() == 4) {
                this.defenders.addPlayer(p);
            } else if (p.getId() == 3) {
                this.defenders.addPlayer(p);
            } else if (p.getId() == 2) {
                this.ballFollowers.addPlayer(p);
            }
        }
    }
    
    public void executePlayersRole() {
        if (this.gameSituation == GameSituations.FORCE_START) {
            this.goalKeepers.doWhenForceStart(this);
            this.defenders.doWhenForceStart(this);
            this.ballFollowers.doWhenForceStart(this);
        }
    }
    
    public void planHowToDoIt() {
        GrSimPlayerCommand command = null;
        // TODO a FOR-LOOP for each player Role
        for (Player player : this.goalKeepers.getPlayers()) {
            player.setVelx(KIController.velocityX(player.getXd(), player.getX(), player.getYd(), player.getY(), player.getOrientation()));
            player.setVely(KIController.velocityY(player.getXd(), player.getX(), player.getYd(), player.getY(), player.getOrientation(),player.getOrientationd()));
            player.setVelz(KIController.velocityZ(player.getOrientation(),player.getOrientationd()));
            // add command
            command = new GrSimPlayerCommand();
            command.setId(player.getId());
            command.setVelx(player.getVelx());
            command.setVely(player.getVely());
            command.setVelz(player.getVelz());
            command.setTeamYellow(this.teamsColor == TeamsColor.YELLOW);
            command.setWheelSpeed(false);
            this.getGrSimClient().addTeamCommand(command);
        }
        this.goalKeepers.clear();
        
        for (Player player : this.defenders.getPlayers()) {
            player.setVelx(KIController.velocityX(player.getXd(), player.getX(), player.getYd(), player.getY(), player.getOrientation()));
            player.setVely(KIController.velocityY(player.getXd(), player.getX(), player.getYd(), player.getY(), player.getOrientation(),player.getOrientationd()));
            player.setVelz(KIController.velocityZ(player.getOrientation(),player.getOrientationd()));
            // add command
            command = new GrSimPlayerCommand();
            command.setId(player.getId());
            command.setVelx(player.getVelx());
            command.setVely(player.getVely());
            command.setVelz(player.getVelz());
            command.setTeamYellow(this.teamsColor == TeamsColor.YELLOW);
            command.setWheelSpeed(false);
            this.getGrSimClient().addTeamCommand(command);
        }
        this.defenders.clear();
        
        for (Player player : this.ballFollowers.getPlayers()) {
            player.setVelx(KIController.velocityX(player.getXd(), player.getX(), player.getYd(), player.getY(), player.getOrientation()));
            player.setVely(KIController.velocityY(player.getXd(), player.getX(), player.getYd(), player.getY(), player.getOrientation(),player.getOrientationd()));
            player.setVelz(KIController.velocityZ(player.getOrientation(),player.getOrientationd()));
            // add command
            command = new GrSimPlayerCommand();
            command.setId(player.getId());
            command.setVelx(player.getVelx());
            command.setVely(player.getVely());
            command.setVelz(player.getVelz());
            command.setTeamYellow(this.teamsColor == TeamsColor.YELLOW);
            command.setWheelSpeed(false);
            this.getGrSimClient().addTeamCommand(command);
        }
        this.ballFollowers.clear();
    }
    
    public void think() {
        this.thinkAboutGameSituation();
        this.thinkAboutPlayersRoles();
        this.executePlayersRole();
        this.planHowToDoIt();
    }
    
    /*
    Getters and Setters
    */

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Team getBlueTeam() {
        return blueTeam;
    }

    public void setBlueTeam(Team blueTeam) {
        this.blueTeam = blueTeam;
    }

    public Team getYellowTeam() {
        return yellowTeam;
    }

    public void setYellowTeam(Team yellowTeam) {
        this.yellowTeam = yellowTeam;
    }

    public SslVisionClient getClient() {
        return sslVisionclient;
    }

    public void setClient(SslVisionClient client) {
        this.sslVisionclient = client;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public SslVisionClient getSslVisionclient() {
        return sslVisionclient;
    }

    public void setSslVisionclient(SslVisionClient sslVisionclient) {
        this.sslVisionclient = sslVisionclient;
    }

    public GrSimClient getGrSimClient() {
        return grSimClient;
    }

    public void setGrSimClient(GrSimClient grSimClient) {
        this.grSimClient = grSimClient;
    }

    public TeamsColor getTeamsColor() {
        return teamsColor;
    }

    public void setTeamsColor(TeamsColor teamsColor) {
        this.teamsColor = teamsColor;
    }

    public GameSituations getGameSituation() {
        return gameSituation;
    }

    public void setGameSituation(GameSituations gameSituation) {
        this.gameSituation = gameSituation;
    }

    public GoalKeeper getGoalKeepers() {
        return goalKeepers;
    }

    public void setGoalKeepers(GoalKeeper goalKeepers) {
        this.goalKeepers = goalKeepers;
    }

    public int getFieldSide() {
        return fieldSide;
    }

    public void setFieldSide(int fieldSide) {
        this.fieldSide = fieldSide;
    }
    
    
    
}
