package pl.kaczorowski.carrentfrontend.workingarea.user;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.client.UserClient;
import pl.kaczorowski.carrentfrontend.domain.user.CreateUserDto;
import pl.kaczorowski.carrentfrontend.grid.UserGridGetUsers;

@Getter
public class AddUser {
    private VerticalLayout addUserLayout = new VerticalLayout();
    private MainView mainView;
    private TextField firstName = new TextField("First Name:");
    private TextField lastName = new TextField("Last Name :");
    private TextField pesel = new TextField("Pesel:");
    private Button createUser = new Button("Create User");
    private Button cancel = new Button("Cancel");
    private UserClient userClient = new UserClient();
    private UserGridGetUsers userGridGetUsers= new UserGridGetUsers();

    public AddUser(MainView mainView) {
        this.mainView = mainView;
        addUserLayout.add(firstName, lastName, pesel, new HorizontalLayout(createUser, cancel));
        createNewUser();
        cancelCreateUser();
    }

    private void createNewUser() {
        createUser.addClickListener(event -> {
            CreateUserDto createUserDto = new CreateUserDto(
                    firstName.getValue(),
                    lastName.getValue(),
                    pesel.getValue()
            );
            try {
                userClient.createUser(createUserDto);
                clearFields();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(userGridGetUsers.getUserDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                userGridGetUsers.fillDataUsers();

            } catch (Exception e) {
                Notification.show("Error: Wrong data type:");
                System.out.println("Add user exception " + e);
            }
        });
    }

    private void cancelCreateUser() {
        cancel.addClickListener(event -> {
            clearFields();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        pesel.clear();
    }
}
