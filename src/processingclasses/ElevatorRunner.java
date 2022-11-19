/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingclasses;

import model.Elevator;
import model.ElevatorMovementRepository;
import model.Movement;
import model.Task;

/**
 *
 * @author Gbett
 */
public class ElevatorRunner implements Runnable {

    ElevatorMovementRepository elevatorRecordRepository;
    private Task task;
    private Elevator elevator;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        try {
            persistElevatorMovement(elevator);

            moveElevator(task.getFromFloorNo());

            persistElevatorMovement(elevator);

            peopleMoveIn(task.getNoOfOccupant());

            persistElevatorMovement(elevator);

            moveElevator(task.getToFloorNo());

            persistElevatorMovement(elevator);

            peopleMoveOut();

            persistElevatorMovement(elevator);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void moveElevator(int toFloorNo) throws Exception {
        MoveCommand moveCommand = new MoveCommand(elevator, toFloorNo);
        moveCommand.execute();
    }

    private void peopleMoveIn(int noOfpeople) throws Exception {
        MoveInCommand moveInCommand = new MoveInCommand(elevator, noOfpeople);
        moveInCommand.execute();
    }

    private void peopleMoveOut() throws Exception {
        MoveOutCommand moveOutCommand = new MoveOutCommand(elevator);
        moveOutCommand.execute();
    }

}
