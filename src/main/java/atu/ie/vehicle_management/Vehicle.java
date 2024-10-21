package atu.ie.vehicle_management;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @NotBlank(message = "must not be empty")
    private String vehicleName;
    @NotBlank(message = "must not be empty")
    @Pattern(regexp = "Car.+Truck.+Motorcycle.+Bus")
    private String vehicleType;
    @Pattern(regexp = " .+ ")
    private String registrationNumber;
    @PositiveOrZero
    private float price;
    @NotBlank(message = "between 1886 adn current year")
    private int yearOfManufacture;
    @PositiveOrZero(message = "Cannot be less than 0")
    private int mileage;
}
