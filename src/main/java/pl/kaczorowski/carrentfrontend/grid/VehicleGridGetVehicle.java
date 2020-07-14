package pl.kaczorowski.carrentfrontend.grid;

import com.vaadin.flow.component.grid.Grid;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.client.VehicleClient;
import pl.kaczorowski.carrentfrontend.domain.vehicle.VehicleDto;

@Getter
public class VehicleGridGetVehicle {
    VehicleClient vehicleClient = new VehicleClient();
    private Grid<VehicleDto> vehicleDtoGrid = new Grid<>(VehicleDto.class);

    public VehicleGridGetVehicle() {
        vehicleDtoGrid.setColumns("id", "name", "vehicleIdentifier", "category", "costPerDay");
    }

    public void fillDataVehicle(Long id) {
        vehicleDtoGrid.setItems(vehicleClient.getVehicle(id));
    }
}
