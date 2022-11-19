/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingclasses;

import model.Elevator;
import model.ServiceElevatorAllocator;
import model.Statuses;
import model.Task;

/**
 *
 * @author Gbett
 */
public class ElevatorAllocateService implements ServiceElevatorAllocator {

    ElevatorRepository repository;

    @Override
    public Elevator requestElevator(Task task) {
        if (task == null) {
            return null;
        }

        Elevator optionalElevator = null;
        for (Elevator elevator : repository.getElevators()) {

            if (elevator.getStatus() == Statuses.IDLE) {
                if (optionalElevator == null) {
                    optionalElevator = elevator;
                } else {
                    if (Math.abs(elevator.getCurrentFloorNo() - task.getFromFloorNo()) < Math.abs(optionalElevator.getCurrentFloorNo() - task.getFromFloorNo())) {
                        optionalElevator = elevator;
                    }
                }
            }
        }
        if (optionalElevator != null) {
            optionalElevator.startTask();
        }

        return optionalElevator;
    }

}
