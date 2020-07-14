package pl.kaczorowski.carrentfrontend.workingarea.vehicle;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.client.VehicleClient;
import pl.kaczorowski.carrentfrontend.grid.VehicleGridGetVehicles;
import pl.kaczorowski.carrentfrontend.menu.VehicleMenu;

import static com.helger.commons.string.StringParser.isLong;

@Getter
public class DeleteVehicle {
    private VerticalLayout deleteVehicleLayout = new VerticalLayout();
    private MainView mainView;
    private TextField id = new TextField("Id:");
    private Button deleteVehicle = new Button("Delete Vehicle");
    private Button cancel = new Button("Cancel");
    private VehicleClient vehicleClient = new VehicleClient();
    VehicleMenu vehicleMenu = new VehicleMenu(mainView);
    VehicleGridGetVehicles vehicleGridGetVehicles = new VehicleGridGetVehicles();


    public DeleteVehicle(MainView mainView) {
        this.mainView = mainView;
        deleteVehicleLayout.add(id,deleteVehicle,cancel);
        mainView.getSecondPanel().add(deleteVehicleLayout);
        deleteVehicle();
        cancelDeleteVehicle();
    }

    public void deleteVehicle() {
        deleteVehicle.addClickListener(event -> {
            if (isLong(id.getValue())) {
                vehicleClient.deleteVehicle(Long.parseLong(id.getValue()));
                id.clear();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(vehicleGridGetVehicles.getVehicleDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                vehicleGridGetVehicles.fillDataVehicles();
            } else {
                Notification.show("Vehicle not found");
            }
        });

    }

    private void cancelDeleteVehicle() {
        cancel.addClickListener(event -> {
            id.clear();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

}
