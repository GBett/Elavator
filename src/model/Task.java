/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gbett
 */
public class Task {

    private int noOfOccupant;

    public int getNoOfOccupant() {
        return noOfOccupant;
    }

    public void setNoOfOccupant(int noOfOccupant) {
        this.noOfOccupant = noOfOccupant;
    }

    public int getFromFloorNo() {
        return fromFloorNo;
    }

    public void setFromFloorNo(int fromFloorNo) {
        this.fromFloorNo = fromFloorNo;
    }

    public int getToFloorNo() {
        return toFloorNo;
    }

    public void setToFloorNo(int toFloorNo) {
        this.toFloorNo = toFloorNo;
    }
    private int fromFloorNo;
    private int toFloorNo;
}
