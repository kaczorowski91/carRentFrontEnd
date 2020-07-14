package pl.kaczorowski.carrentfrontend.grid;

import com.vaadin.flow.component.grid.Grid;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.client.UserClient;
import pl.kaczorowski.carrentfrontend.domain.user.UserDtoList;

@Getter
public class UserGridGetUsers {
    private UserClient userClient = new UserClient();
    private Grid<UserDtoList> userDtoListGrid = new Grid<>(UserDtoList.class);


    public UserGridGetUsers() {
        userDtoListGrid.setColumns("id", "firstName", "lastName", "pesel");
    }

    public void fillDataUsers() {
        userDtoListGrid.setItems(userClient.getUsers());
    }


}
