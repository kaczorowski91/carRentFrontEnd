package pl.kaczorowski.carrentfrontend.workingarea.vehicle;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import lombok.Setter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.grid.VehicleGridGetVehicle;

import static com.helger.commons.string.StringParser.isLong;

@Getter
@Setter
public class GetVehicle {
    private VerticalLayout getVehicleLayout = new VerticalLayout();
    private MainView mainView;
    private TextField id = new TextField("Id:");
    private Button getVehicle = new Button("Get Vehicle");
    private Button cancel = new Button("Cancel");
    private VehicleGridGetVehicle vehicleGridGetVehicle;


    public GetVehicle(MainView mainView) {
        this.mainView = mainView;
        getVehicleLayout.add(id, getVehicle, cancel);
        mainView.getSecondPanel().add(getVehicleLayout);
        returnVehicle();
        cancelGetVehicle();
    }

    private void returnVehicle() {
        getVehicle.addClickListener(event -> {
            if (isLong(id.getValue())) {
                vehicleGridGetVehicle = new VehicleGridGetVehicle();
                vehicleGridGetVehicle.getVehicleDtoGrid().setVisible(true);
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(vehicleGridGetVehicle.getVehicleDtoGrid());
                mainView.getSecondPanel().setSizeFull();
                vehicleGridGetVehicle.fillDataVehicle(Long.parseLong(id.getValue()));

            } else {
                id.clear();
                Notification.show("Vehicle not found");
            }
        });
    }

    private void cancelGetVehicle() {
        cancel.addClickListener(event -> {
            id.clear();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }
}
