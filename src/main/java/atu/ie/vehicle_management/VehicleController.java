package atu.ie.vehicle_management;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private List<Vehicle> vehicleList = new ArrayList<>();
    private VehicleService vehicleService;



    @GetMapping("/get")
    public List <Vehicle> getVehicle() {
        return vehicleList;
    }

    @PostMapping("/add")
    public ResponseEntity<List>addVehicle(@Valid @RequestBody Vehicle vehicle){
        vehicleList = vehicleService.addvehicle(vehicle);
        return ResponseEntity.ok(vehicleList);
    }

    private Vehicle findVehicleByReg(int registrationNumber){
        for (Vehicle vehicle : vehicleList){
            if ((vehicle.hashCode()==registrationNumber)){
                return vehicle;
            }
        }
        return null;
    }


    @PutMapping("/updated/{id}")
    public ResponseEntity <Vehicle> updateVehicle(@PathVariable int id, @RequestBody Vehicle updatedVehicle){
        Vehicle existingVehicle = findVehicleByReg(id);

        if(existingVehicle != null ) {
            existingVehicle.setVehicleName(updatedVehicle);
            existingVehicle.setvehicleType(updatedVehicle);
            return ResponseEntity.ok(existingVehicle);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}























