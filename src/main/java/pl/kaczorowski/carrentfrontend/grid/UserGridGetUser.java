package pl.kaczorowski.carrentfrontend.grid;

import com.vaadin.flow.component.grid.Grid;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.client.UserClient;
import pl.kaczorowski.carrentfrontend.domain.user.UserDto;

@Getter
public class UserGridGetUser {
    private UserClient userClient = new UserClient();
    private Grid<UserDto> userDtoListGrid = new Grid<>(UserDto.class);

    public UserGridGetUser() {
        userDtoListGrid.setColumns("id", "firstName", "lastName", "pesel");
    }

    public void fillDataUser(Long id){
        userDtoListGrid.setItems(userClient.getUser(id));
    }
}
