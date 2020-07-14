package pl.kaczorowski.carrentfrontend.domain.vehicle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateVehicleDto {
    private Long id;
    private String name;
    private String vehicleIdentifier;
    private String category;
    private double costPerDay;

    public UpdateVehicleDto(Long id, String name, String vehicleIdentifier, String category, double costPerDay) {
        this.id = id;
        this.name = name;
        this.vehicleIdentifier = vehicleIdentifier;
        this.category = category;
        this.costPerDay = costPerDay;
    }
}
