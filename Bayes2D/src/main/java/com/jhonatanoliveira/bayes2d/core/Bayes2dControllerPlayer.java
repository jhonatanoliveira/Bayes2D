/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.core;

import com.github.robocup_atan.atan.model.ActionsPlayer;
import com.github.robocup_atan.atan.model.ControllerPlayer;
import com.github.robocup_atan.atan.model.enums.Errors;
import com.github.robocup_atan.atan.model.enums.Flag;
import com.github.robocup_atan.atan.model.enums.Line;
import com.github.robocup_atan.atan.model.enums.Ok;
import com.github.robocup_atan.atan.model.enums.PlayMode;
import com.github.robocup_atan.atan.model.enums.RefereeMessage;
import com.github.robocup_atan.atan.model.enums.ServerParams;
import com.github.robocup_atan.atan.model.enums.ViewAngle;
import com.github.robocup_atan.atan.model.enums.ViewQuality;
import com.github.robocup_atan.atan.model.enums.Warning;
import com.jhonatanoliveira.bayes2d.core.info.BallInfo;
import com.jhonatanoliveira.bayes2d.core.info.CPTInfo;
import com.jhonatanoliveira.bayes2d.core.info.FlagInfo;
import com.jhonatanoliveira.bayes2d.core.info.HearPlayerInfo;
import com.jhonatanoliveira.bayes2d.core.info.LineInfo;
import com.jhonatanoliveira.bayes2d.core.info.PlayerInfo;
import com.jhonatanoliveira.bayes2d.core.info.PlayerParamInfo;
import com.jhonatanoliveira.bayes2d.core.info.PlayerTypeInfo;
import com.jhonatanoliveira.bayes2d.core.info.SenseBodyInfo;
import java.util.HashMap;

/**
 *
 * @author jhonatanoliveira
 */
public abstract class Bayes2dControllerPlayer implements ControllerPlayer {
    
    private ActionsPlayer player;
    private Bayes2dGameSituations gameSituation;
    private Bayes2dPlayerRole playerRole;
    private FlagInfo flagRight = null, flagLeft = null, flagOwn = null, flagOther = null, flagCenter = null, flagCornerOwn = null, flagCornerOther = null, flagPenaltyOwn = null, flagPenaltyOther = null, flagGoalOwn = null, flagGoalOther = null;
    private LineInfo lineInfo = null;
    private PlayerInfo playerOtherInfo = null, playerOwnInfo = null;
    private BallInfo ballInfo = null;
    private RefereeMessage refereeMessage = null;
    private PlayMode playMode = null;
    private HearPlayerInfo hearPlayerInfo = null;
    private Errors hearErrorInfo = null;
    private Ok hearOkInfo = null;
    private Warning hearWarningInfo = null;
    private SenseBodyInfo senseBodyInfo = null;
    private CPTInfo cptOwnInfo = null, cptOtherInfo = null;
    private PlayerTypeInfo playerTypeInfo = null;
    private PlayerParamInfo playerParamInfo = null;
    private HashMap<ServerParams, Object> serverParam;
    
    public abstract void decidePlayerRole();
    public abstract void decideGameSituation();
    public abstract void play();
    
    @Override
    public void preInfo() {
    }

    @Override
    public void postInfo() {
        this.decidePlayerRole();
        this.play();
//        this.decideGameSituation();
//        this.decidePlayerRole();
//        this.play();
    }

    @Override
    public ActionsPlayer getPlayer() {
       return this.player;
    }

    @Override
    public void setPlayer(ActionsPlayer c) {
        this.player = c;
    }

    @Override
    public String getType() {
        return this.toString();
    }

    @Override
    public void setType(String newType) {
        
    }

    @Override
    public void infoSeeFlagRight(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagRight == null) {
            this.flagRight = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagRight, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagLeft(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagLeft == null) {
            this.flagLeft = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagLeft, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagOwn == null) {
            this.flagOwn = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagOwn, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagOther == null) {
            this.flagOther = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagOther, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagCenter(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagCenter == null) {
            this.flagCenter = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagCenter, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagCornerOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagCornerOwn == null) {
            this.flagCornerOwn = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagCornerOwn, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagCornerOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagCornerOther == null) {
            this.flagCornerOther = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagCornerOther, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagPenaltyOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagPenaltyOwn == null) {
            this.flagPenaltyOwn = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagPenaltyOwn, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagPenaltyOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagPenaltyOther == null) {
            this.flagPenaltyOther = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagPenaltyOther, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagGoalOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagGoalOwn == null) {
            this.flagGoalOwn = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagGoalOwn, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeFlagGoalOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.flagGoalOther == null) {
            this.flagGoalOther = new FlagInfo(flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setFlagInfo(this.flagGoalOther, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeLine(Line line, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.lineInfo == null) {
            this.lineInfo = new LineInfo(line, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setLineInfo(this.lineInfo, line, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeePlayerOther(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.playerOtherInfo == null) {
            this.playerOtherInfo = new PlayerInfo(number, goalie, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setPlayerInfo(this.playerOtherInfo, number, goalie, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeePlayerOwn(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.playerOwnInfo == null) {
            this.playerOwnInfo = new PlayerInfo(number, goalie, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setPlayerInfo(this.playerOwnInfo, number, goalie, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoSeeBall(double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        if (this.ballInfo == null) {
            this.ballInfo = new BallInfo(distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        } else {
            this.setBallInfo(this.ballInfo, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        }
    }

    @Override
    public void infoHearReferee(RefereeMessage refereeMessage) {
        this.refereeMessage = refereeMessage;
    }

    @Override
    public void infoHearPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    @Override
    public void infoHearPlayer(double direction, String message) {
        if (this.hearPlayerInfo == null) {
            this.hearPlayerInfo = new HearPlayerInfo(direction, message);
        } else {
            this.setHearPlayerInfo(this.hearPlayerInfo, direction, message);
        }
    }

    @Override
    public void infoHearError(Errors error) {
        this.hearErrorInfo = error;
    }

    @Override
    public void infoHearOk(Ok ok) {
        this.hearOkInfo = ok;
    }

    @Override
    public void infoHearWarning(Warning warning) {
        this.hearWarningInfo = warning;
    }

    @Override
    public void infoSenseBody(ViewQuality viewQuality, ViewAngle viewAngle, double stamina, double unknown, double effort, double speedAmount, double speedDirection, double headAngle, int kickCount, int dashCount, int turnCount, int sayCount, int turnNeckCount, int catchCount, int moveCount, int changeViewCount) {
        if (this.senseBodyInfo == null) {
            this.senseBodyInfo = new SenseBodyInfo(viewQuality, viewAngle, stamina, unknown, effort, speedAmount, speedDirection, headAngle, kickCount, dashCount, turnCount, sayCount, turnNeckCount, catchCount, moveCount, changeViewCount);
        } else {
            this.setSenseBodyInfo(this.senseBodyInfo, viewQuality, viewAngle, stamina, unknown, effort, speedAmount, speedDirection, headAngle, kickCount, dashCount, turnCount, sayCount, turnNeckCount, catchCount, moveCount, changeViewCount);
        }
    }

    @Override
    public void infoCPTOwn(int unum, int type) {
        if (this.cptOwnInfo == null) {
            this.cptOwnInfo = new CPTInfo(unum, type);
        } else {
            this.setCPTInfo(this.cptOwnInfo, unum, type);
        }
    }

    @Override
    public void infoCPTOther(int unum) {
        if (this.cptOtherInfo == null) {
            this.cptOtherInfo = new CPTInfo(unum);
        } else {
            this.setCPTInfo(this.cptOtherInfo, unum);
        }
    }

    @Override
    public void infoPlayerType(int id, double playerSpeedMax, double staminaIncMax, double playerDecay, double inertiaMoment, double dashPowerRate, double playerSize, double kickableMargin, double kickRand, double extraStamina, double effortMax, double effortMin) {
        if (this.playerTypeInfo == null) {
            this.playerTypeInfo = new PlayerTypeInfo(id, playerSpeedMax, staminaIncMax, playerDecay, inertiaMoment, dashPowerRate, playerSize, kickableMargin, kickRand, extraStamina, effortMax, effortMin);
        } else {
            this.setPlayerTypeInfo(this.playerTypeInfo, id, playerSpeedMax, staminaIncMax, playerDecay, inertiaMoment, dashPowerRate, playerSize, kickableMargin, kickRand, extraStamina, effortMax, effortMin);
        }
    }

    @Override
    public void infoPlayerParam(double allowMultDefaultType, double dashPowerRateDeltaMax, double dashPowerRateDeltaMin, double effortMaxDeltaFactor, double effortMinDeltaFactor, double extraStaminaDeltaMax, double extraStaminaDeltaMin, double inertiaMomentDeltaFactor, double kickRandDeltaFactor, double kickableMarginDeltaMax, double kickableMarginDeltaMin, double newDashPowerRateDeltaMax, double newDashPowerRateDeltaMin, double newStaminaIncMaxDeltaFactor, double playerDecayDeltaMax, double playerDecayDeltaMin, double playerTypes, double ptMax, double randomSeed, double staminaIncMaxDeltaFactor, double subsMax) {
        if (this.playerParamInfo == null) {
            this.playerParamInfo = new PlayerParamInfo(allowMultDefaultType, dashPowerRateDeltaMax, dashPowerRateDeltaMin, effortMaxDeltaFactor, effortMinDeltaFactor, extraStaminaDeltaMax, extraStaminaDeltaMin, inertiaMomentDeltaFactor, kickRandDeltaFactor, kickableMarginDeltaMax, kickableMarginDeltaMin, newDashPowerRateDeltaMax, newDashPowerRateDeltaMin, newStaminaIncMaxDeltaFactor, playerDecayDeltaMax, playerDecayDeltaMin, playerTypes, ptMax, randomSeed, staminaIncMaxDeltaFactor, subsMax);
        } else {
            this.setPlayerParamInfo(this.playerParamInfo, allowMultDefaultType, dashPowerRateDeltaMax, dashPowerRateDeltaMin, effortMaxDeltaFactor, effortMinDeltaFactor, extraStaminaDeltaMax, extraStaminaDeltaMin, inertiaMomentDeltaFactor, kickRandDeltaFactor, kickableMarginDeltaMax, kickableMarginDeltaMin, newDashPowerRateDeltaMax, newDashPowerRateDeltaMin, newStaminaIncMaxDeltaFactor, playerDecayDeltaMax, playerDecayDeltaMin, playerTypes, ptMax, randomSeed, staminaIncMaxDeltaFactor, subsMax);
        }
    }

    @Override
    public void infoServerParam(HashMap<ServerParams, Object> info) {
        this.serverParam = info;
    }
    
    public void setFlagInfo(FlagInfo flagInfo, Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        flagInfo.setFlag(flag);
        flagInfo.setDistance(distance);
        flagInfo.setDirection(direction);
        flagInfo.setDistChange(distChange);
        flagInfo.setDirChange(dirChange);
        flagInfo.setBodyFacingDirection(bodyFacingDirection);
        flagInfo.setHeadFacingDirection(headFacingDirection);
    }
    
    public void setLineInfo(LineInfo lineInfo, Line line, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        lineInfo.setLine(line);
        lineInfo.setDistance(distance);
        lineInfo.setDirection(direction);
        lineInfo.setDistChange(distChange);
        lineInfo.setDirChange(dirChange);
        lineInfo.setBodyFacingDirection(bodyFacingDirection);
        lineInfo.setHeadFacingDirection(headFacingDirection);
    }
    
    public void setPlayerInfo(PlayerInfo playerInfo, int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        playerInfo.setNumber(number);
        playerInfo.setGoalie(goalie);
        playerInfo.setDistance(distance);
        playerInfo.setDirection(direction);
        playerInfo.setDistChange(distChange);
        playerInfo.setDirChange(dirChange);
        playerInfo.setBodyFacingDirection(bodyFacingDirection);
        playerInfo.setHeadFacingDirection(headFacingDirection);
    }
    
    public void setBallInfo(BallInfo ballInfo, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        ballInfo.setDistance(distance);
        ballInfo.setDirection(direction);
        ballInfo.setDistChange(distChange);
        ballInfo.setDirChange(dirChange);
        ballInfo.setBodyFacingDirection(bodyFacingDirection);
        ballInfo.setHeadFacingDirection(headFacingDirection);
    }
    
    public void setHearPlayerInfo(HearPlayerInfo hearPlayerInfo, double direction, String message) {
        hearPlayerInfo.setDirection(direction);
        hearPlayerInfo.setMessage(message);
    }
    
    public void setSenseBodyInfo(SenseBodyInfo senseBodyInfo, ViewQuality viewQuality, ViewAngle viewAngle, double stamina, double unknown, double effort, double speedAmount, double speedDirection, double headAngle, int kickCount, int dashCount, int turnCount, int sayCount, int turnNeckCount, int catchCount, int moveCount, int changeViewCount) {
        senseBodyInfo.setViewQuality(viewQuality);
        senseBodyInfo.setViewAngle(viewAngle);
        senseBodyInfo.setStamina(stamina);
        senseBodyInfo.setUnknown(unknown);
        senseBodyInfo.setEffort(effort);
        senseBodyInfo.setSpeedAmount(speedAmount);
        senseBodyInfo.setSpeedDirection(speedDirection);
        senseBodyInfo.setHeadAngle(headAngle);
        senseBodyInfo.setKickCount(kickCount);
        senseBodyInfo.setDashCount(dashCount);
        senseBodyInfo.setTurnCount(turnCount);
        senseBodyInfo.setSayCount(sayCount);
        senseBodyInfo.setTurnNeckCount(turnNeckCount);
        senseBodyInfo.setCatchCount(catchCount);
        senseBodyInfo.setMoveCount(moveCount);
        senseBodyInfo.setChangeViewCount(changeViewCount);
    }
    
    public void setCPTInfo(CPTInfo cptOwnInfo, int unum, int type) {
        cptOtherInfo.setType(type);
        cptOtherInfo.setUnum(unum);
    }
    
    public void setCPTInfo(CPTInfo cptOwnInfo, int unum) {
        cptOtherInfo.setUnum(unum);
    }
    
    private void setPlayerTypeInfo(PlayerTypeInfo playerTypeInfo, int id, double playerSpeedMax, double staminaIncMax, double playerDecay, double inertiaMoment, double dashPowerRate, double playerSize, double kickableMargin, double kickRand, double extraStamina, double effortMax, double effortMin) {
        playerTypeInfo.setId(id);
        playerTypeInfo.setPlayerSpeedMax(playerSpeedMax);
        playerTypeInfo.setStaminaIncMax(staminaIncMax);
        playerTypeInfo.setPlayerDecay(playerDecay);
        playerTypeInfo.setInertiaMoment(inertiaMoment);
        playerTypeInfo.setDashPowerRate(dashPowerRate);
        playerTypeInfo.setPlayerSize(playerSize);
        playerTypeInfo.setKickableMargin(kickableMargin);
        playerTypeInfo.setKickRand(kickRand);
        playerTypeInfo.setExtraStamina(extraStamina);
        playerTypeInfo.setEffortMax(effortMax);
        playerTypeInfo.setEffortMin(effortMin);
    }
    
    private void setPlayerParamInfo(PlayerParamInfo playerParamInfo, double allowMultDefaultType, double dashPowerRateDeltaMax, double dashPowerRateDeltaMin, double effortMaxDeltaFactor, double effortMinDeltaFactor, double extraStaminaDeltaMax, double extraStaminaDeltaMin, double inertiaMomentDeltaFactor, double kickRandDeltaFactor, double kickableMarginDeltaMax, double kickableMarginDeltaMin, double newDashPowerRateDeltaMax, double newDashPowerRateDeltaMin, double newStaminaIncMaxDeltaFactor, double playerDecayDeltaMax, double playerDecayDeltaMin, double playerTypes, double ptMax, double randomSeed, double staminaIncMaxDeltaFactor, double subsMax) {
        playerParamInfo.setAllowMultDefaultType(allowMultDefaultType);
        playerParamInfo.setDashPowerRateDeltaMax(dashPowerRateDeltaMax);
        playerParamInfo.setDashPowerRateDeltaMin(dashPowerRateDeltaMin);
        playerParamInfo.setEffortMaxDeltaFactor(effortMaxDeltaFactor);
        playerParamInfo.setEffortMinDeltaFactor(effortMinDeltaFactor);
        playerParamInfo.setExtraStaminaDeltaMax(extraStaminaDeltaMax);
        playerParamInfo.setExtraStaminaDeltaMin(extraStaminaDeltaMin);
        playerParamInfo.setInertiaMomentDeltaFactor(inertiaMomentDeltaFactor);
        playerParamInfo.setKickRandDeltaFactor(kickRandDeltaFactor);
        playerParamInfo.setKickableMarginDeltaMax(kickableMarginDeltaMax);
        playerParamInfo.setKickableMarginDeltaMin(kickableMarginDeltaMin);
        playerParamInfo.setNewDashPowerRateDeltaMax(newDashPowerRateDeltaMax);
        playerParamInfo.setNewDashPowerRateDeltaMin(newDashPowerRateDeltaMin);
        playerParamInfo.setNewStaminaIncMaxDeltaFactor(newStaminaIncMaxDeltaFactor);
    }

    public Bayes2dGameSituations getGameSituation() {
        return gameSituation;
    }

    public void setGameSituation(Bayes2dGameSituations gameSituation) {
        this.gameSituation = gameSituation;
    }

    public Bayes2dPlayerRole getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(Bayes2dPlayerRole playerRole) {
        this.playerRole = playerRole;
    }

    public FlagInfo getFlagRight() {
        return flagRight;
    }

    public void setFlagRight(FlagInfo flagRight) {
        this.flagRight = flagRight;
    }

    public FlagInfo getFlagLeft() {
        return flagLeft;
    }

    public void setFlagLeft(FlagInfo flagLeft) {
        this.flagLeft = flagLeft;
    }

    public FlagInfo getFlagOwn() {
        return flagOwn;
    }

    public void setFlagOwn(FlagInfo flagOwn) {
        this.flagOwn = flagOwn;
    }

    public FlagInfo getFlagOther() {
        return flagOther;
    }

    public void setFlagOther(FlagInfo flagOther) {
        this.flagOther = flagOther;
    }

    public FlagInfo getFlagCenter() {
        return flagCenter;
    }

    public void setFlagCenter(FlagInfo flagCenter) {
        this.flagCenter = flagCenter;
    }

    public FlagInfo getFlagCornerOwn() {
        return flagCornerOwn;
    }

    public void setFlagCornerOwn(FlagInfo flagCornerOwn) {
        this.flagCornerOwn = flagCornerOwn;
    }

    public FlagInfo getFlagCornerOther() {
        return flagCornerOther;
    }

    public void setFlagCornerOther(FlagInfo flagCornerOther) {
        this.flagCornerOther = flagCornerOther;
    }

    public FlagInfo getFlagPenaltyOwn() {
        return flagPenaltyOwn;
    }

    public void setFlagPenaltyOwn(FlagInfo flagPenaltyOwn) {
        this.flagPenaltyOwn = flagPenaltyOwn;
    }

    public FlagInfo getFlagPenaltyOther() {
        return flagPenaltyOther;
    }

    public void setFlagPenaltyOther(FlagInfo flagPenaltyOther) {
        this.flagPenaltyOther = flagPenaltyOther;
    }

    public FlagInfo getFlagGoalOwn() {
        return flagGoalOwn;
    }

    public void setFlagGoalOwn(FlagInfo flagGoalOwn) {
        this.flagGoalOwn = flagGoalOwn;
    }

    public FlagInfo getFlagGoalOther() {
        return flagGoalOther;
    }

    public void setFlagGoalOther(FlagInfo flagGoalOther) {
        this.flagGoalOther = flagGoalOther;
    }

    public LineInfo getLineInfo() {
        return lineInfo;
    }

    public void setLineInfo(LineInfo lineInfo) {
        this.lineInfo = lineInfo;
    }

    public PlayerInfo getPlayerOtherInfo() {
        return playerOtherInfo;
    }

    public void setPlayerOtherInfo(PlayerInfo playerOtherInfo) {
        this.playerOtherInfo = playerOtherInfo;
    }

    public PlayerInfo getPlayerOwnInfo() {
        return playerOwnInfo;
    }

    public void setPlayerOwnInfo(PlayerInfo playerOwnInfo) {
        this.playerOwnInfo = playerOwnInfo;
    }

    public BallInfo getBallInfo() {
        return ballInfo;
    }

    public void setBallInfo(BallInfo ballInfo) {
        this.ballInfo = ballInfo;
    }

    public RefereeMessage getRefereeMessage() {
        return refereeMessage;
    }

    public void setRefereeMessage(RefereeMessage refereeMessage) {
        this.refereeMessage = refereeMessage;
    }

    public PlayMode getPlayMode() {
        return playMode;
    }

    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public HearPlayerInfo getHearPlayerInfo() {
        return hearPlayerInfo;
    }

    public void setHearPlayerInfo(HearPlayerInfo hearPlayerInfo) {
        this.hearPlayerInfo = hearPlayerInfo;
    }

    public Errors getHearErrorInfo() {
        return hearErrorInfo;
    }

    public void setHearErrorInfo(Errors hearErrorInfo) {
        this.hearErrorInfo = hearErrorInfo;
    }

    public Ok getHearOkInfo() {
        return hearOkInfo;
    }

    public void setHearOkInfo(Ok hearOkInfo) {
        this.hearOkInfo = hearOkInfo;
    }

    public Warning getHearWarningInfo() {
        return hearWarningInfo;
    }

    public void setHearWarningInfo(Warning hearWarningInfo) {
        this.hearWarningInfo = hearWarningInfo;
    }

    public SenseBodyInfo getSenseBodyInfo() {
        return senseBodyInfo;
    }

    public void setSenseBodyInfo(SenseBodyInfo senseBodyInfo) {
        this.senseBodyInfo = senseBodyInfo;
    }

    public CPTInfo getCptOwnInfo() {
        return cptOwnInfo;
    }

    public void setCptOwnInfo(CPTInfo cptOwnInfo) {
        this.cptOwnInfo = cptOwnInfo;
    }

    public CPTInfo getCptOtherInfo() {
        return cptOtherInfo;
    }

    public void setCptOtherInfo(CPTInfo cptOtherInfo) {
        this.cptOtherInfo = cptOtherInfo;
    }

    public PlayerTypeInfo getPlayerTypeInfo() {
        return playerTypeInfo;
    }

    public void setPlayerTypeInfo(PlayerTypeInfo playerTypeInfo) {
        this.playerTypeInfo = playerTypeInfo;
    }

    public PlayerParamInfo getPlayerParamInfo() {
        return playerParamInfo;
    }

    public void setPlayerParamInfo(PlayerParamInfo playerParamInfo) {
        this.playerParamInfo = playerParamInfo;
    }

    public HashMap<ServerParams, Object> getServerParam() {
        return serverParam;
    }

    public void setServerParam(HashMap<ServerParams, Object> serverParam) {
        this.serverParam = serverParam;
    }
    
}
