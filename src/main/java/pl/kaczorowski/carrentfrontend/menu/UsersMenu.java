package pl.kaczorowski.carrentfrontend.menu;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import lombok.Setter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.grid.UserGridGetUsers;
import pl.kaczorowski.carrentfrontend.workingarea.user.AddUser;
import pl.kaczorowski.carrentfrontend.workingarea.user.DeleteUser;
import pl.kaczorowski.carrentfrontend.workingarea.user.GetUser;
import pl.kaczorowski.carrentfrontend.workingarea.user.UpdateUser;

@Getter
@Setter
public class UsersMenu {
    private Button createUser = new Button("Create user");
    private Button getUser = new Button("Get User");
    private Button showUsers = new Button("Show users");
    private Button deleteUser = new Button("Delete User");
    private Button updateUser = new Button("Update User");
    private VerticalLayout userLayout = new VerticalLayout();
    private UserGridGetUsers userGridGetUsers;
    private MainView mainView;

    public UsersMenu(MainView mainView) {

        createUser.addClickListener(event -> {
            AddUser addUser = new AddUser(mainView);
            addUser.getAddUserLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(addUser.getAddUserLayout());
        });

        showUsers.addClickListener(event -> {
            userGridGetUsers = new UserGridGetUsers();
            userGridGetUsers.getUserDtoListGrid().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().setVisible(true);
            mainView.getSecondPanel().addComponentAsFirst(userGridGetUsers.getUserDtoListGrid());
            mainView.getSecondPanel().setSizeFull();
            userGridGetUsers.fillDataUsers();
        });

        getUser.addClickListener(event -> {
            GetUser getUser = new GetUser(mainView);
            getUser.getGetUserLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(getUser.getGetUserLayout());

        });

        deleteUser.addClickListener(event -> {
            DeleteUser deleteUser = new DeleteUser(mainView);
            deleteUser.getDeleteUserLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(deleteUser.getDeleteUserLayout());
        });

        updateUser.addClickListener(event -> {
            UpdateUser updateUser = new UpdateUser(mainView);
            updateUser.getUpdateUserLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(updateUser.getUpdateUserLayout());
        });


        userLayout.add(createUser, getUser, showUsers, deleteUser, updateUser);

    }

    public VerticalLayout getUserLayout() {
        return userLayout;
    }

}


