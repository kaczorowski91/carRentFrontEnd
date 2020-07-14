package pl.kaczorowski.carrentfrontend.menu;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import lombok.Setter;
import pl.kaczorowski.carrentfrontend.MainView;
import pl.kaczorowski.carrentfrontend.grid.CurrencyGridGetCurrency;

@Getter
@Setter
public class CurrencyMenu {
    private Button showCurrency = new Button("Show Currency");
    private VerticalLayout currencyLayout = new VerticalLayout();
    private CurrencyGridGetCurrency currencyGridGetCurrency;

    private MainView mainView;


    public CurrencyMenu(MainView mainView) {
        this.mainView = mainView;

        showCurrency.addClickListener(event -> {
            currencyGridGetCurrency = new CurrencyGridGetCurrency();
            currencyGridGetCurrency.getCurrencyDtoGrid().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().setVisible(true);
            mainView.getSecondPanel().addComponentAsFirst(currencyGridGetCurrency.getCurrencyDtoGrid());
            mainView.getSecondPanel().setSizeFull();
            currencyGridGetCurrency.fillDataCurrency();

        });
        currencyLayout.add(showCurrency);
    }


    public VerticalLayout getCurrencyLayout(){
        return currencyLayout;
    }

}
