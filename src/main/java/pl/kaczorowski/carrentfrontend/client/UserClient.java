package pl.kaczorowski.carrentfrontend.client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.kaczorowski.carrentfrontend.domain.user.CreateUserDto;
import pl.kaczorowski.carrentfrontend.domain.user.UpdateUserDto;
import pl.kaczorowski.carrentfrontend.domain.user.UserDto;
import pl.kaczorowski.carrentfrontend.domain.user.UserDtoList;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class UserClient {

    private RestTemplate restTemplate = new RestTemplate();

    public void createUser(final CreateUserDto createUserDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/user")
                .queryParam("First Name", createUserDto.getFirstName())
                .queryParam("Last Name", createUserDto.getLastName())
                .queryParam("Pesel", createUserDto.getPesel())
                .build().encode().toUri();
        restTemplate.postForObject(url, createUserDto, UserDto.class);
    }

    public List<UserDtoList> getUsers() {
        try {
            UserDtoList[] usersResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/user", UserDtoList[].class);
            return Arrays.asList(ofNullable(usersResponse).orElse(new UserDtoList[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public UserDto getUser(final Long id) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/user/")
                .path(id.toString()).build().encode().toUri();
        return restTemplate.getForObject(url, UserDto.class);

    }

    public void deleteUser(final Long id) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/user/")
                .path(id.toString()).build().encode().toUri();
        restTemplate.delete(url);
    }


    public void updateUser(final UpdateUserDto updateUserDto){
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/user")
                .queryParam("Id", updateUserDto.getId())
                .queryParam("First Name", updateUserDto.getFirstName())
                .queryParam("Last Name", updateUserDto.getLastName())
                .queryParam("Pesel", updateUserDto.getPesel())
                .build().encode().toUri();
        restTemplate.postForObject(url, updateUserDto, UserDto.class);
    }
}
