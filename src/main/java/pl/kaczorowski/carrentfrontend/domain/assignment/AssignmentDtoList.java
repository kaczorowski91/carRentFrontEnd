package pl.kaczorowski.carrentfrontend.domain.assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDtoList {
    private Long id;
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
}
