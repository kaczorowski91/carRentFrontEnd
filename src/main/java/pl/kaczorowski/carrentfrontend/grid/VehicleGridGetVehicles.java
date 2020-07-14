package pl.kaczorowski.carrentfrontend.grid;

import com.vaadin.flow.component.grid.Grid;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.client.VehicleClient;
import pl.kaczorowski.carrentfrontend.domain.vehicle.VehicleDtoList;

@Getter
public class VehicleGridGetVehicles {
    VehicleClient vehicleClient = new VehicleClient();
    private Grid<VehicleDtoList> vehicleDtoListGrid = new Grid<>(VehicleDtoList.class);

    public VehicleGridGetVehicles() {
        vehicleDtoListGrid.setColumns("id", "name", "vehicleIdentifier", "category", "costPerDay");
    }

    public void fillDataVehicles() {
        vehicleDtoListGrid.setItems(vehicleClient.getVehicles());
    }

}
