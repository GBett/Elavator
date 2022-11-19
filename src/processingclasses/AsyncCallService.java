/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingclasses;

import model.Elevator;
import model.Task;

/**
 *
 * @author Gbett
 */
public class AsyncCallService {
    ElevatorRunner elevatorRunner;
    
    public void schedule(Task task, Elevator elevator) {
        
        elevatorRunner.setTask(task);
        elevatorRunner.setElevator(elevator);
        elevatorRunner.run();
    }
}
