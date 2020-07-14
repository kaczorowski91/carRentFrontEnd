package pl.kaczorowski.carrentfrontend.workingarea.vehicle;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.client.VehicleClient;
import pl.kaczorowski.carrentfrontend.domain.vehicle.CreateVehicleDto;
import pl.kaczorowski.carrentfrontend.grid.VehicleGridGetVehicles;

@Getter
public class AddVehicle {
    private VerticalLayout addVehicleLayout = new VerticalLayout();
    private MainView mainView;
    private TextField name = new TextField("Name:");
    private TextField vehicleIdentifier = new TextField("Vehicle Identifier :");
    private TextField category = new TextField("Category");
    private TextField costPerDay = new TextField("CostPerDay");
    private Button createVehicle = new Button("Create Vehicle ");
    private Button cancel = new Button("Cancel");
    private VehicleClient vehicleClient = new VehicleClient();
    private VehicleGridGetVehicles vehicleGridGetVehicles = new VehicleGridGetVehicles();

    public AddVehicle(MainView mainView) {
        this.mainView = mainView;
        addVehicleLayout.add(name, vehicleIdentifier, category, costPerDay, new HorizontalLayout(createVehicle, cancel));
        createNewVehicle();
        cancelCreateVehicle();
    }

    public void createNewVehicle() {
        createVehicle.addClickListener(event -> {
            CreateVehicleDto createVehicleDto = new CreateVehicleDto(
                    name.getValue(),
                    vehicleIdentifier.getValue(),
                    category.getValue(),
                    Double.parseDouble(costPerDay.getValue())
            );
            try {
                vehicleClient.createVehicle(createVehicleDto);
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

    private void cancelCreateVehicle() {
        cancel.addClickListener(event -> {
            clearFields();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        name.clear();
        vehicleIdentifier.clear();
        category.clear();
        costPerDay.clear();
    }


}
