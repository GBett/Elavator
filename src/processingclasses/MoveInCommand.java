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
public class MoveInCommand implements Command {

    private ElevatorReceiver elevatorReceiver;
    private int noOfPeople;

    public MoveInCommand(ElevatorReceiver elevatorReceiver, int noOfPeople) {
        this.elevatorReceiver = elevatorReceiver;
        this.noOfPeople = noOfPeople;
    }

    @Override
    public void execute() throws Exception {
        elevatorReceiver.peopleMoveIn(noOfPeople);
    }
}
