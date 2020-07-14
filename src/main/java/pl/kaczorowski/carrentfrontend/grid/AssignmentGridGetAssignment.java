package pl.kaczorowski.carrentfrontend.grid;

import com.vaadin.flow.component.grid.Grid;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.client.AssignmentClient;
import pl.kaczorowski.carrentfrontend.domain.assignment.AssignmentDto;

@Getter
public class AssignmentGridGetAssignment {
    private AssignmentClient assignmentClient = new AssignmentClient();
    private Grid<AssignmentDto> assignmentDtoListGrid = new Grid<>(AssignmentDto.class);

    public AssignmentGridGetAssignment() {
        assignmentDtoListGrid.setColumns("id", "begin", "appointedEnd", "realEnd", "userId", "vehicleId", "plannedCostPLN",
                "realCostPLN", "plannedCostEUR", "realCostEUR", "plannedCostDOL", "realCostDOL");
        int amountOfColumns = assignmentDtoListGrid.getColumns().size();
        for (int i = 0; i < amountOfColumns; i++) {
            assignmentDtoListGrid.getColumns().get(i).setWidth("200px");
        }

    }

    public void fillDataAssignment(Long id) {
        assignmentDtoListGrid.setItems(assignmentClient.getAssignment(id));
    }


}
