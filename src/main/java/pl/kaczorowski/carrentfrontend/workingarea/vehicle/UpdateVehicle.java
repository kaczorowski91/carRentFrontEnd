package pl.kaczorowski.carrentfrontend.workingarea.vehicle;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.client.VehicleClient;
import pl.kaczorowski.carrentfrontend.domain.vehicle.UpdateVehicleDto;
import pl.kaczorowski.carrentfrontend.grid.VehicleGridGetVehicles;

@Getter
public class UpdateVehicle {
    private VerticalLayout updateVehicleLayout = new VerticalLayout();
    private MainView mainView;
    private TextField id = new TextField("Id:");
    private TextField name = new TextField("Name:");
    private TextField vehicleIdentifier = new TextField("Vehicle Identifier :");
    private TextField category = new TextField("Category");
    private TextField costPerDay = new TextField("CostPerDay");
    private Button updateVehicle = new Button("Update Vehicle ");
    private Button cancel = new Button("Cancel");
    private VehicleClient vehicleClient = new VehicleClient();
    private VehicleGridGetVehicles vehicleGridGetVehicles = new VehicleGridGetVehicles();


    public UpdateVehicle(MainView mainView) {
        this.mainView = mainView;
        updateVehicleLayout.add(id, name, vehicleIdentifier, category, costPerDay, new HorizontalLayout(updateVehicle, cancel));
        updateVehicle();
        cancelUpdate();
    }

    public void updateVehicle() {
        updateVehicle.addClickListener(event -> {
            UpdateVehicleDto updateVehicleDto = new UpdateVehicleDto(
                    Long.parseLong(id.getValue()),
                    name.getValue(),
                    vehicleIdentifier.getValue(),
                    category.getValue(),
                    Double.parseDouble(costPerDay.getValue())
            );
            try {
                vehicleClient.updateVehicle(updateVehicleDto);
                clearFields();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(vehicleGridGetVehicles.getVehicleDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                vehicleGridGetVehicles.fillDataVehicles();

            } catch (Exception e) {
                Notification.show("Error: Wrong data type:");
                System.out.println("Add user exception " + e);
            }
        });
    }

    private void cancelUpdate() {
        cancel.addClickListener(event -> {
            clearFields();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        id.clear();
        name.clear();
        vehicleIdentifier.clear();
        category.clear();
        costPerDay.clear();
    }
}
