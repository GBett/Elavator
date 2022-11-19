/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingclasses;

import model.Command;

/**
 *
 * @author Gbett
 */
public class MoveCommand implements Command {

    private ElevatorReceiver elevatorReceiver;
    private int toFloor;

    public MoveCommand(ElevatorReceiver elevatorReceiver, int toFloor) {
        this.elevatorReceiver = elevatorReceiver;
        this.toFloor = toFloor;
    }

    @Override
    public void execute() throws Exception {
        elevatorReceiver.moveElevator(toFloor);
    }
}
