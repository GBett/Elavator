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
public class MoveOutCommand implements Command {

    private ElevatorReceiver elevatorReceiver;

    public MoveOutCommand(ElevatorReceiver elevatorReceiver) {
        this.elevatorReceiver = elevatorReceiver;
    }

    @Override
    public void execute() throws Exception {
        elevatorReceiver.peopleMoveOut();
    }

}
