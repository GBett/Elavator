/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import model.Elevator;
import model.Movement;
import model.Statuses;

/**
 *
 * @author Gbett
 */
public class ElevatorRepository {

    private List<Elevator> elevators = new ArrayList<Elevator>();

    @PostConstruct
    public void init() {
        Arrays.asList("A", "B", "C", "D").forEach(number -> {
            Elevator elevator = new Elevator(number);
            elevator.setStatus(Statuses.IDLE);
            elevator.setCurrentFloorNo(1);
            elevators.add(elevator);
        });
    }

    public List<Elevator> getElevators() {
        return elevators;
    }
}
