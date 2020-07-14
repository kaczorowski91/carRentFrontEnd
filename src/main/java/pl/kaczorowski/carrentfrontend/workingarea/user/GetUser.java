package pl.kaczorowski.carrentfrontend.workingarea.user;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import lombok.Setter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.grid.UserGridGetUser;

import static com.helger.commons.string.StringParser.isLong;

@Getter
@Setter
public class GetUser {
    private VerticalLayout getUserLayout = new VerticalLayout();
    private MainView mainView;
    private TextField id = new TextField("Id:");
    private Button getUser = new Button("Get User");
    private Button cancel = new Button("Cancel");
    private UserGridGetUser userGridGetUser;

    public GetUser(MainView mainView) {
        this.mainView = mainView;
        getUserLayout.add(id, getUser, cancel);
        mainView.getSecondPanel().add(getUserLayout);
        returnUser();
        cancelGetUser();
    }

    private void returnUser() {
        getUser.addClickListener(event -> {
            if (isLong(id.getValue())) {
                userGridGetUser = new UserGridGetUser();
                userGridGetUser.getUserDtoListGrid().setVisible(true);
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(userGridGetUser.getUserDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                userGridGetUser.fillDataUser(Long.parseLong(id.getValue()));

            } else {
                id.clear();
                Notification.show("User not found");
            }
        });

    }

    private void cancelGetUser() {
        cancel.addClickListener(event -> {
            id.clear();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }
}
