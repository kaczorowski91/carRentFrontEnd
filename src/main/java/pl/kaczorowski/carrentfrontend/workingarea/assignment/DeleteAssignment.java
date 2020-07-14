package pl.kaczorowski.carrentfrontend.workingarea.assignment;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.client.AssignmentClient;
import pl.kaczorowski.carrentfrontend.grid.AssignmentGridGetAssignments;
import pl.kaczorowski.carrentfrontend.menu.AssignmentMenu;

import static com.helger.commons.string.StringParser.isLong;

@Getter
public class DeleteAssignment {
    private VerticalLayout deleteAssignmentLayout = new VerticalLayout();
    private MainView mainView;
    private TextField id = new TextField("Id:");
    private Button deleteAssignment = new Button("Delete Assignment");
    private Button cancel = new Button("Cancel");
    private AssignmentClient assignmentClient = new AssignmentClient();
    AssignmentMenu assignmentMenu = new AssignmentMenu(mainView);
    AssignmentGridGetAssignments assignmentGridGetAssignments = new AssignmentGridGetAssignments();

    public DeleteAssignment(MainView mainView) {
        this.mainView = mainView;
        deleteAssignmentLayout.add(id, deleteAssignment, cancel);
        mainView.getSecondPanel().add(deleteAssignmentLayout);
        deleteAssignment();
        cancelDeleteAssignemnt();
    }

    private void deleteAssignment() {
        deleteAssignment.addClickListener(event -> {
            if (isLong(id.getValue())) {
                assignmentClient.deleteAssignment(Long.parseLong(id.getValue()));
                id.clear();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(assignmentGridGetAssignments.getAssignmentDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                assignmentGridGetAssignments.fillDataAssignments();
            } else {
                Notification.show("User not found");
            }
        });
    }


    private void cancelDeleteAssignemnt() {
        cancel.addClickListener(event -> {
            id.clear();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

}
