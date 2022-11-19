/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingclasses;

/**
 *
 * @author Gbett
 */
public interface ElevatorReceiver {

    public void moveElevator(int toFloor) throws Exception;
    public void peopleMoveIn(int noOfPeople) throws Exception;
    public void peopleMoveOut() throws Exception;
}
