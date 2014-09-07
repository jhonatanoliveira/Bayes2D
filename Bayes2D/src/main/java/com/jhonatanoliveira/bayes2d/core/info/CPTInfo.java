/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.core.info;

/**
 *
 * @author jhonatanoliveira
 */
public class CPTInfo {
    
    int unum, type;

    public CPTInfo(int unum) {
        this.unum = unum;
    }

    public CPTInfo(int unum, int type) {
        this.unum = unum;
        this.type = type;
    }

    public int getUnum() {
        return unum;
    }

    public void setUnum(int unum) {
        this.unum = unum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
