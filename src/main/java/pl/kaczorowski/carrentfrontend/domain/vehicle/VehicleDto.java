package pl.kaczorowski.carrentfrontend.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long id;
    private String name;
    private String vehicleIdentifier;
    private String category;
    private double costPerDay;
}
