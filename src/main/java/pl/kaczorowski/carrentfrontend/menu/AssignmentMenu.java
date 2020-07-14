package pl.kaczorowski.carrentfrontend.menu;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import lombok.Setter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.grid.AssignmentGridGetAssignments;
import pl.kaczorowski.carrentfrontend.workingarea.assignment.AddAssignment;
import pl.kaczorowski.carrentfrontend.workingarea.assignment.DeleteAssignment;
import pl.kaczorowski.carrentfrontend.workingarea.assignment.GetAssignment;

@Getter
@Setter
public class AssignmentMenu {
    private Button createAssignment = new Button("Create Assignment");
    private Button getAssignment = new Button("Get Assignment");
    private Button showAssignment = new Button("Show Assignments");
    private Button deleteAssignment = new Button("Delete Assignment");
    private VerticalLayout assignmentLayout = new VerticalLayout();
    private AssignmentGridGetAssignments assignmentGridGetAssignments;
    private MainView mainView;


    public AssignmentMenu(MainView mainView) {

        createAssignment.addClickListener(event -> {
            AddAssignment addAssignment = new AddAssignment(mainView);
            addAssignment.getAddAssignmentLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(addAssignment.getAddAssignmentLayout());
        });

        showAssignment.addClickListener(event -> {
            assignmentGridGetAssignments = new AssignmentGridGetAssignments();
            assignmentGridGetAssignments.getAssignmentDtoListGrid().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().setVisible(true);
            mainView.getSecondPanel().addComponentAsFirst(assignmentGridGetAssignments.getAssignmentDtoListGrid());
            mainView.getSecondPanel().setSizeFull();
            assignmentGridGetAssignments.fillDataAssignments();
        });

        getAssignment.addClickListener(event -> {
            GetAssignment getAssignment = new GetAssignment(mainView);
            getAssignment.getGetAssignment().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(getAssignment.getGetAssignmentLayout());

        });

        deleteAssignment.addClickListener(event -> {
            DeleteAssignment deleteAssignment = new DeleteAssignment(mainView);
            deleteAssignment.getDeleteAssignmentLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(deleteAssignment.getDeleteAssignmentLayout());
        });




        assignmentLayout.add(createAssignment, getAssignment, showAssignment, deleteAssignment);
    }

    public VerticalLayout getAssignmentLayout() {
        return assignmentLayout;
    }
}
