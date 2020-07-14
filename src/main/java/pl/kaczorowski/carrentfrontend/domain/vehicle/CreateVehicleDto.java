package pl.kaczorowski.carrentfrontend.domain.vehicle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateVehicleDto {
    private String name;
    private String vehicleIdentifier;
    private String category;
    private double costPerDay;

    public CreateVehicleDto(String name, String vehicleIdentifier, String category, double costPerDay) {
        this.name = name;
        this.vehicleIdentifier = vehicleIdentifier;
        this.category = category;
        this.costPerDay = costPerDay;
    }
}
