/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendtechelevator;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import database.DBFunctions;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import model.Elevator;
import model.ElevatorMovementRepository;
import model.Task;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import processingclasses.ElevatorScheduleService;

/**
 *
 * @author Gbett
 */
public class RequestHandler implements HttpHandler {

    String requestType = "";

    public RequestHandler(String request) {
        requestType = request;
        System.out.println("Creating Handle thread ");
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        try {
            switch (requestType) {
                case "SAVE_NEW_STATE":
                    String jsonString = IOUtils.toString(t.getRequestBody(), "UTF-8");
                    JSONObject obj = new JSONObject(jsonString);
                    Iterator<String> keys = obj.keys();
                    HashMap<String, String> dbRecord = new HashMap();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        dbRecord.put(key, obj.get(key) == null ? "" : obj.get(key).toString());
                    }
                    String response = String.valueOf(new DBFunctions().SaveTransactionData(dbRecord));
                    String fNo = obj.has("floorNo") ? obj.getString("floorNo") : "0";
                    String toFloorNo = obj.has("toFloorNo") ? obj.getString("toFloorNo") : "0";
                    String noOfOccupants = obj.has("noOfPeople") ? obj.getString("noOfPeople") : "0";

                    int flrNo = Integer.parseInt(fNo);
                    int toFNo = Integer.parseInt(toFloorNo);
                    int noOfOcc = Integer.parseInt(noOfOccupants);
                    JSONObject status_response = generateNewState(flrNo, toFNo, noOfOcc);
                    status_response.put("saving_details", response);
                    t.sendResponseHeaders(200, 0);
                    t.getResponseBody().write(status_response.toString().getBytes());
                    t.close();
                    break;
                case "GET_CURRENT_POSITION":
                    jsonString = IOUtils.toString(t.getRequestBody(), "UTF-8");
                    obj = new JSONObject(jsonString);
                    keys = obj.keys();
                    dbRecord = new HashMap();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        dbRecord.put(key, obj.get(key) == null ? "" : obj.get(key).toString());
                    }
                    String elevator_no = obj.has("elevator_no") ? obj.getString("elevator_no") : "0";
                    ElevatorMovementRepository movementRep = new ElevatorMovementRepository();
                    response = movementRep.findByElevatorID(elevator_no);
                    t.sendResponseHeaders(200, 0);
                    t.getResponseBody().write(response.getBytes());
                    t.close();
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject generateNewState(int floorNo, int toFloorNo, int noOfPeople) {

        JSONObject response = new JSONObject();
        try {
            Task task = new Task();
            task.setFromFloorNo(floorNo);
            task.setToFloorNo(toFloorNo);
            task.setNoOfOccupant(noOfPeople);

            if (!new FloorValidityChecker().isValidRequest(task)) {
                response.put("error_code", "0");

                response.put("error_code", "Invalid task, can't operate at that point");
            }
            Elevator elevator = new ElevatorScheduleService().scheduleElevator(task);
            if (elevator == null) {
                response.put("error_code", "0");
                response.put("error_code", "Missing elevator");
            }
            response.put("error_code", "1");
            response.put("error_code", "Action successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
