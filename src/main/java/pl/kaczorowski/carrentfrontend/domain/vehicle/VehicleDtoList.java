package pl.kaczorowski.carrentfrontend.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDtoList {
    private Long id;
    private String name;
    private String vehicleIdentifier;
    private String category;
    private double costPerDay;
}
