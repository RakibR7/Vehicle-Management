package atu.ie.vehicle_management;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private VehicleRepo vehicleRepo;
    private List<Vehicle> vehicleList = new ArrayList<>();

    public VehicleService(VehicleRepo vehicleRepo){
    }

    public List <Vehicle> addvehicle(Vehicle vehicle){
        vehicleRepo.save(vehicle);
        return vehicleRepo.findAll();
    }

    private Vehicle findVehicleByReg(int registrationNumber){
        for (Vehicle vehicle : vehicleList){
            if ((vehicle.hashCode()==registrationNumber)){
                return vehicle;
            }
        }
        return null;
    }

    public List <Vehicle> updatevehicle(Vehicle vehicle){
        vehicleRepo.save(vehicle);
        return vehicleRepo.findVehicleById();
    }

}
