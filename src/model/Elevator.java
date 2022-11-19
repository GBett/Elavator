/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import processingclasses.ElevatorReceiver;

/**
 *
 * @author Gbett
 */
public class Elevator implements ElevatorReceiver {

    ElevatorMovementRepository elevatorRecordRepository;
    private static int ELEVATOR_ACTION_TIME = 5000;
    private static int DEFAULT_NO_OF_PEOPLE = 0;
    private static int DEFAULT_TO_FLOOR_NO = 0;

    private String id;

    private int currentFloorNo;

    public static int getELEVATOR_ACTION_TIME() {
        return ELEVATOR_ACTION_TIME;
    }

    public static void setELEVATOR_ACTION_TIME(int ELEVATOR_ACTION_TIME) {
        Elevator.ELEVATOR_ACTION_TIME = ELEVATOR_ACTION_TIME;
    }

    public static int getDEFAULT_NO_OF_PEOPLE() {
        return DEFAULT_NO_OF_PEOPLE;
    }

    public static void setDEFAULT_NO_OF_PEOPLE(int DEFAULT_NO_OF_PEOPLE) {
        Elevator.DEFAULT_NO_OF_PEOPLE = DEFAULT_NO_OF_PEOPLE;
    }

    public static int getDEFAULT_TO_FLOOR_NO() {
        return DEFAULT_TO_FLOOR_NO;
    }

    public static void setDEFAULT_TO_FLOOR_NO(int DEFAULT_TO_FLOOR_NO) {
        Elevator.DEFAULT_TO_FLOOR_NO = DEFAULT_TO_FLOOR_NO;
    }

    public Elevator(String number) {
        this.id = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    private int toFloorNo;

    private int noOfPeople;

    private Statuses status;

    @Override
    public void moveElevator(int toFloor) throws Exception {
        this.toFloorNo = toFloorNo;
        if (currentFloorNo < toFloorNo) {
            this.status = Statuses.MOVE_UP;
        } else if (currentFloorNo > toFloorNo) {
            this.status = Statuses.MOVE_DOWN;
        } else {
            this.status = Statuses.STAY;
        }

        elevatorInAction();

        this.currentFloorNo = toFloorNo;
    }

    /**
     *
     * @param noOfPeople
     * @throws Exception
     */
    @Override
    public void peopleMoveIn(int noOfPeople) throws Exception {
        this.status = Statuses.STAY;

        elevatorInAction();

        this.noOfPeople = noOfPeople;
    }

    @Override
    public void peopleMoveOut() throws Exception {
        this.status = Statuses.STAY;
        this.toFloorNo = DEFAULT_TO_FLOOR_NO;
        elevatorInAction();
        this.noOfPeople = DEFAULT_NO_OF_PEOPLE;
        this.status = Statuses.IDLE;
    }

    private void persistElevatorMovement(Elevator elevator) {
        Movement movement = new Movement();
        movement.setElevatorID(elevator.getId());
        movement.setCurrentFloorNo(elevator.getCurrentFloorNo());
        movement.setToFloorNo(elevator.getToFloorNo());
        movement.setNoOfPeople(elevator.getNoOfPeople());
        movement.setStatus(elevator.getStatus());
        elevatorRecordRepository.save(movement);
    }

    /**
     * synchronized service to start task
     */
    public synchronized void startTask() {
        this.status = Statuses.TASK_STARTED;
        this.noOfPeople = DEFAULT_NO_OF_PEOPLE;
        this.toFloorNo = DEFAULT_TO_FLOOR_NO;
    }

    private void elevatorInAction() throws Exception {
        try {
            Thread.sleep(ELEVATOR_ACTION_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
