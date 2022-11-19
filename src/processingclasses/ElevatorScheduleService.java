/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingclasses;

import model.Elevator;
import model.ElevatorServiceScheduler;
import model.Movement;
import model.Task;

/**
 *
 * @author Gbett
 */
public class ElevatorScheduleService implements ElevatorServiceScheduler{

    ElevatorAllocateService elevatorAllocateService;
    AsyncCallService asyncService;

    @Override
    public Elevator scheduleElevator(Task task) {
        Elevator elevator = elevatorAllocateService.requestElevator(task);
		if(elevator == null) {
			return null;
		}
		asyncService.schedule(task, elevator);
		return elevator;
    }
    
}
