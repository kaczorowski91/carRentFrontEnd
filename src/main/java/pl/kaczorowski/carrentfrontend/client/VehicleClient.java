package pl.kaczorowski.carrentfrontend.client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.kaczorowski.carrentfrontend.domain.vehicle.CreateVehicleDto;
import pl.kaczorowski.carrentfrontend.domain.vehicle.UpdateVehicleDto;
import pl.kaczorowski.carrentfrontend.domain.vehicle.VehicleDto;
import pl.kaczorowski.carrentfrontend.domain.vehicle.VehicleDtoList;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class VehicleClient {

    private RestTemplate restTemplate = new RestTemplate();

    public void createVehicle(final CreateVehicleDto createVehicleDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/vehicle")
                .queryParam("name", createVehicleDto.getName())
                .queryParam("vehicleIdentifier", createVehicleDto.getVehicleIdentifier())
                .queryParam("category", createVehicleDto.getCategory())
                .queryParam("costPerDay", createVehicleDto.getCostPerDay())
                .build().encode().toUri();
        restTemplate.postForObject(url, createVehicleDto, VehicleDto.class);
    }


    public List<VehicleDtoList> getVehicles() {
        try {
            VehicleDtoList[] vehiclesResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/vehicle", VehicleDtoList[].class);
            return Arrays.asList(ofNullable(vehiclesResponse).orElse(new VehicleDtoList[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public VehicleDto getVehicle(final Long id) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/vehicle/")
                .path(id.toString()).build().encode().toUri();
        return restTemplate.getForObject(url, VehicleDto.class);
    }

    public void deleteVehicle(final Long id) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/vehicle/")
                .path(id.toString()).build().encode().toUri();
        restTemplate.delete(url);
    }

    public void updateVehicle(final UpdateVehicleDto updateVehicleDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/vehicle")
                .queryParam("id", updateVehicleDto.getId())
                .queryParam("name", updateVehicleDto.getName())
                .queryParam("vehicleIdentifier", updateVehicleDto.getVehicleIdentifier())
                .queryParam("category", updateVehicleDto.getCategory())
                .queryParam("costPerDay", updateVehicleDto.getCostPerDay())
                .build().encode().toUri();
        restTemplate.postForObject(url, updateVehicleDto, VehicleDto.class);
    }

}
