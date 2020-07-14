package pl.kaczorowski.carrentfrontend.workingarea.user;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.client.UserClient;
import pl.kaczorowski.carrentfrontend.grid.UserGridGetUsers;
import pl.kaczorowski.carrentfrontend.menu.UsersMenu;

import static com.helger.commons.string.StringParser.isLong;

@Getter
public class DeleteUser {
    private VerticalLayout deleteUserLayout = new VerticalLayout();
    private MainView mainView;
    private TextField id = new TextField("Id:");
    private Button deleteUser = new Button("Delete User");
    private Button cancel = new Button("Cancel");
    private UserClient userClient = new UserClient();
    UsersMenu usersMenu = new UsersMenu(mainView);
    UserGridGetUsers userGridGetUsers = new UserGridGetUsers();

    public DeleteUser(MainView mainView) {
        this.mainView = mainView;
        deleteUserLayout.add(id, deleteUser, cancel);
        mainView.getSecondPanel().add(deleteUserLayout);
        deleteUser();
        cancelDeleteUser();
    }

    private void deleteUser() {
        deleteUser.addClickListener(event -> {
            if (isLong(id.getValue())) {
                userClient.deleteUser(Long.parseLong(id.getValue()));
                id.clear();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(userGridGetUsers.getUserDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                userGridGetUsers.fillDataUsers();
            } else {
                Notification.show("User not found");
            }
        });
    }


    private void cancelDeleteUser() {
        cancel.addClickListener(event -> {
            id.clear();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }


}
