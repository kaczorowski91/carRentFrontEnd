package pl.kaczorowski.carrentfrontend;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import pl.kaczorowski.carrentfrontend.client.CurrencyClient;
import pl.kaczorowski.carrentfrontend.menu.AssignmentMenu;
import pl.kaczorowski.carrentfrontend.menu.CurrencyMenu;
import pl.kaczorowski.carrentfrontend.menu.UsersMenu;
import pl.kaczorowski.carrentfrontend.menu.VehicleMenu;

@Route
public class MainView extends AppLayout {
    private UsersMenu userMenu = new UsersMenu(this);
    private VehicleMenu vehicleMenu = new VehicleMenu(this);
    private AssignmentMenu assignmentMenu = new AssignmentMenu(this);
    private CurrencyMenu currencyMenu = new CurrencyMenu(this);

    private HorizontalLayout firstPanel = new HorizontalLayout();
    private HorizontalLayout secondPanel = new HorizontalLayout();
    private Accordion accordion = new Accordion();
    private Label menuLabel = new Label("CAR RENTAL APP");

    public MainView() {
        firstPanel.add(menuLabel);
        firstPanel.add(setAccordion());
        setContent(new HorizontalLayout(firstPanel, secondPanel));
    }

    public Accordion getAccordion() {
        return accordion;
    }

    private Accordion setAccordion() {
        accordion.add("Users", userMenu.getUserLayout());
        accordion.add("Vehicle", (vehicleMenu.getVehicleLayout()));
        accordion.add("Assignment", (assignmentMenu.getAssignmentLayout()));
        accordion.add("Currency",(currencyMenu.getCurrencyLayout()));
        accordion.addOpenedChangeListener(event -> secondPanel.removeAll());
        accordion.close();
        return accordion;
    }

    public HorizontalLayout getSecondPanel() {
        return secondPanel;
    }
}
