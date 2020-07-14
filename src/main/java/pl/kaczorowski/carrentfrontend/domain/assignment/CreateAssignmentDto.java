package pl.kaczorowski.carrentfrontend.domain.assignment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateAssignmentDto {
    private LocalDateTime begin;
    private LocalDateTime appointedEnd;
    private LocalDateTime realEnd;
    private Long userId;
    private Long vehicleId;
    private double plannedCostPLN;
    private double realCostPLN;
    private double plannedCostEUR;
    private double realCostEUR;
    private double plannedCostDOL;
    private double realCostDOL;

    public CreateAssignmentDto(LocalDateTime appointedEnd, Long userId, Long vehicleId) {
        this.appointedEnd = appointedEnd;
        this.userId = userId;
        this.vehicleId = vehicleId;
    }
}
