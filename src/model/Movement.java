/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Gbett
 */
public class Movement {

    private Integer id;

    private Date time = new Date();
    private String elevatorID;
    private int currentFloorNo;
    private int toFloorNo;
    private int noOfPeople;
    private Statuses status;

    public Movement(String number) {
       
    }

    public Movement() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getElevatorID() {
        return elevatorID;
    }

    public void setElevatorID(String elevatorID) {
        this.elevatorID = elevatorID;
    }

    public int getCurrentFloorNo() {
        return currentFloorNo;
    }

    public void setCurrentFloorNo(int currentFloorNo) {
        this.currentFloorNo = currentFloorNo;
    }

    public int getToFloorNo() {
        return toFloorNo;
    }

    public void setToFloorNo(int toFloorNo) {
        this.toFloorNo = toFloorNo;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

}
