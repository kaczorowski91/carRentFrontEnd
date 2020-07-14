package pl.kaczorowski.carrentfrontend.client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.kaczorowski.carrentfrontend.domain.assignment.AssignmentDto;
import pl.kaczorowski.carrentfrontend.domain.assignment.AssignmentDtoList;
import pl.kaczorowski.carrentfrontend.domain.assignment.CreateAssignmentDto;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class AssignmentClient {

    private RestTemplate restTemplate = new RestTemplate();

    public void createAssignment(final CreateAssignmentDto createAssignmentDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/assignment")
                .queryParam("appointedEnd", createAssignmentDto.getAppointedEnd())
                .queryParam("userId", createAssignmentDto.getUserId())
                .queryParam("vehicleId", createAssignmentDto.getVehicleId())
                .build().encode().toUri();
        restTemplate.postForObject(url, createAssignmentDto, CreateAssignmentDto.class);
    }


    public List<AssignmentDtoList> getAssignments() {
        try {
            AssignmentDtoList[] assignmentResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/assignment", AssignmentDtoList[].class);
            return Arrays.asList(ofNullable(assignmentResponse).orElse(new AssignmentDtoList[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public AssignmentDto getAssignment(final Long id) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/assignment/")
                .path(id.toString()).build().encode().toUri();
        return restTemplate.getForObject(url, AssignmentDto.class);

    }

    public void deleteAssignment(final Long id) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/assignment/")
                .path(id.toString()).build().encode().toUri();
        restTemplate.delete(url);
    }

}
