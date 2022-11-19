/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Gbett
 */
public class ElevatorMovementRepository {

    public void save(Movement movement) {
        //Save status to the database
    }

    public String findByElevatorID(String elevatorID) {
        JSONObject res = new JSONObject();
        try {
            int currentFloorNo = 4;
            int toFloorNo = 9;
            int noOfPeople = 3;
            String status = "Moving up";

            res.put("currentFloorNo", currentFloorNo);
            res.put("toFloorNo", toFloorNo);
            res.put("noOfPeople", noOfPeople);
            res.put("status", status);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res.toString();
    }

}
