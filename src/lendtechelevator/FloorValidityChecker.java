/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendtechelevator;

import model.Task;

/**
 *
 * @author Gbett
 */
public class FloorValidityChecker {

    private static final int maxNoOfPeople = 5;
    private static final int minFloorNo = 0;
    private static final int maxFloorNo = 12;

    public boolean isValidRequest(Task task) {
        if (task == null) {
            return false;
        }
        if (task.getNoOfOccupant() < 1 || task.getNoOfOccupant() > maxNoOfPeople) {
            return false;
        }
        if (task.getToFloorNo() < minFloorNo || task.getToFloorNo() > maxFloorNo) {
            return false;
        }

        if (task.getFromFloorNo() < minFloorNo || task.getFromFloorNo() > maxFloorNo) {
            return false;
        }

        if (task.getFromFloorNo() == task.getToFloorNo()) {
            return false;
        }
        return true;
    }
}
