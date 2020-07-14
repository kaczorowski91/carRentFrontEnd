package pl.kaczorowski.carrentfrontend.workingarea.user;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.client.UserClient;
import pl.kaczorowski.carrentfrontend.domain.user.UpdateUserDto;
import pl.kaczorowski.carrentfrontend.grid.UserGridGetUsers;

@Getter
public class UpdateUser {
    private VerticalLayout updateUserLayout = new VerticalLayout();
    private final MainView mainView;
    private TextField id = new TextField("id");
    private TextField firstName = new TextField("First Name:");
    private TextField lastName = new TextField("Last Name :");
    private TextField pesel = new TextField("Pesel:");
    private Button updateUser = new Button("Update User");
    private Button cancel = new Button("Cancel");
    private UserClient userClient = new UserClient();
    private UserGridGetUsers userGridGetUsers = new UserGridGetUsers();

    public UpdateUser(MainView mainView) {
        this.mainView = mainView;
        updateUserLayout.add(id, firstName, lastName, pesel, new HorizontalLayout(updateUser, cancel));
        updateUser();
        cancelUpdate();
    }

    public void updateUser() {
        updateUser.addClickListener(event -> {
            UpdateUserDto updateUserDto = new UpdateUserDto(
                    Long.parseLong(id.getValue()),
                    firstName.getValue(),
                    lastName.getValue(),
                    pesel.getValue()
            );
            try {
                userClient.updateUser(updateUserDto);
                clearFields();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(userGridGetUsers.getUserDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                userGridGetUsers.fillDataUsers();

            } catch (Exception e) {
                Notification.show("Error: Wrong data type: Pesel is exists");
                System.out.println("Add user exception " + e);
            }
        });
    }

    private void cancelUpdate() {
        cancel.addClickListener(event -> {
            clearFields();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        id.clear();
        firstName.clear();
        lastName.clear();
        pesel.clear();
    }
}