package pl.kaczorowski.carrentfrontend.menu;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import lombok.Setter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.grid.VehicleGridGetVehicles;
import pl.kaczorowski.carrentfrontend.workingarea.vehicle.AddVehicle;
import pl.kaczorowski.carrentfrontend.workingarea.vehicle.DeleteVehicle;
import pl.kaczorowski.carrentfrontend.workingarea.vehicle.GetVehicle;
import pl.kaczorowski.carrentfrontend.workingarea.vehicle.UpdateVehicle;

@Getter
@Setter
public class VehicleMenu {
    private Button createVehicle = new Button("Create Vehicle");
    private Button getVehicle = new Button("Get Vehicle");
    private Button showVehicle = new Button("Show Vehicle");
    private Button deleteVehicle = new Button("Delete Vehicle");
    private Button updateVehicle = new Button("Update Vehicle");
    private VerticalLayout vehicleLayout = new VerticalLayout();
    private VehicleGridGetVehicles vehicleGridGetVehicles;
    private MainView mainView;


    public VehicleMenu(MainView mainView) {

        createVehicle.addClickListener(event -> {
            AddVehicle addVehicle = new AddVehicle(mainView);
            addVehicle.getAddVehicleLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(addVehicle.getAddVehicleLayout());
        });

        showVehicle.addClickListener(event -> {
            vehicleGridGetVehicles = new VehicleGridGetVehicles();
            vehicleGridGetVehicles.getVehicleDtoListGrid().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().setVisible(true);
            mainView.getSecondPanel().addComponentAsFirst(vehicleGridGetVehicles.getVehicleDtoListGrid());
            mainView.getSecondPanel().setSizeFull();
            vehicleGridGetVehicles.fillDataVehicles();
        });

        getVehicle.addClickListener(event -> {
            GetVehicle getVehicle = new GetVehicle(mainView);
            getVehicle.getGetVehicle().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(getVehicle.getGetVehicleLayout());

        });

        deleteVehicle.addClickListener(event -> {
            DeleteVehicle deleteVehicle = new DeleteVehicle(mainView);
            deleteVehicle.getDeleteVehicleLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(deleteVehicle.getDeleteVehicleLayout());
        });

        updateVehicle.addClickListener(event -> {
            UpdateVehicle updateVehicle = new UpdateVehicle(mainView);
            updateVehicle.getUpdateVehicleLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(updateVehicle.getUpdateVehicleLayout());
        });

        vehicleLayout.add(createVehicle, getVehicle, showVehicle, deleteVehicle, updateVehicle);
    }

    public VerticalLayout getVehicleLayout() {
        return vehicleLayout;
    }
}
