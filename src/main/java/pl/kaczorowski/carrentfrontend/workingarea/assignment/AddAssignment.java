package pl.kaczorowski.carrentfrontend.workingarea.assignment;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.client.AssignmentClient;
import pl.kaczorowski.carrentfrontend.domain.assignment.CreateAssignmentDto;
import pl.kaczorowski.carrentfrontend.grid.AssignmentGridGetAssignments;

import java.time.LocalDateTime;

@Getter
public class AddAssignment {
    private VerticalLayout addAssignmentLayout = new VerticalLayout();
    private MainView mainView;
    private TextField appointedEnd = new TextField("AppointedEnd:");
    private TextField userId = new TextField("userId:");
    private TextField vehicleId = new TextField("vehicleId:");
    private Button createAssignment = new Button("Create Assignment");
    private Button cancel = new Button("Cancel");
    private AssignmentClient assignmentClient = new AssignmentClient();
    private AssignmentGridGetAssignments assignmentGridGetAssignments = new AssignmentGridGetAssignments();

    public AddAssignment(MainView mainView) {
        this.mainView = mainView;
        addAssignmentLayout.add(appointedEnd, userId, vehicleId, new HorizontalLayout(createAssignment, cancel));
        createNewAssignment();
        cancelCreateAssignment();
    }

    private void createNewAssignment() {
        createAssignment.addClickListener(event -> {
            CreateAssignmentDto createAssignmentDto = new CreateAssignmentDto(
                    LocalDateTime.parse(appointedEnd.getValue()),
                    Long.parseLong(userId.getValue()),
                    Long.parseLong(vehicleId.getValue())

            );
            try {
                assignmentClient.createAssignment(createAssignmentDto);
                clearFields();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(assignmentGridGetAssignments.getAssignmentDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                assignmentGridGetAssignments.fillDataAssignments();

            } catch (Exception e) {
                Notification.show("Error: Wrong data type:");
                System.out.println("Add assignment exception " + e);
            }
        });
    }

    private void cancelCreateAssignment() {
        cancel.addClickListener(event -> {
            clearFields();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        appointedEnd.clear();
        userId.clear();
        vehicleId.clear();

    }

}
