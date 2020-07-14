package pl.kaczorowski.carrentfrontend.workingarea.assignment;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import lombok.Setter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.grid.AssignmentGridGetAssignment;

import static com.helger.commons.string.StringParser.isLong;

@Getter
@Setter
public class GetAssignment {

    private VerticalLayout getAssignmentLayout = new VerticalLayout();
    private MainView mainView;
    private TextField id = new TextField("Id:");
    private Button getAssignment = new Button("Get Assignment");
    private Button cancel = new Button("Cancel");
    private AssignmentGridGetAssignment assignmentGridGetAssignment;

    public GetAssignment(MainView mainView) {
        this.mainView = mainView;
        getAssignmentLayout.add(id, getAssignment, cancel);
        mainView.getSecondPanel().add(getAssignmentLayout);
        returnAssignment();
        cancelGetAssignment();
    }


    private void returnAssignment() {
        getAssignment.addClickListener(event -> {
            if (isLong(id.getValue())) {
                assignmentGridGetAssignment = new AssignmentGridGetAssignment();
                assignmentGridGetAssignment.getAssignmentDtoListGrid().setVisible(true);
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(assignmentGridGetAssignment.getAssignmentDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                assignmentGridGetAssignment.fillDataAssignment(Long.parseLong(id.getValue()));

            } else {
                id.clear();
                Notification.show("Assignment not found");
            }
        });

    }

    private void cancelGetAssignment() {
        cancel.addClickListener(event -> {
            id.clear();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }


}
