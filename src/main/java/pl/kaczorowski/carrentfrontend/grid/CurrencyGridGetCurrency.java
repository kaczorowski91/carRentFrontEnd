package pl.kaczorowski.carrentfrontend.grid;

import com.vaadin.flow.component.grid.Grid;
import lombok.Getter;
import pl.kaczorowski.carrentfrontend.client.CurrencyClient;
import pl.kaczorowski.carrentfrontend.domain.CurrencyDto;

@Getter
public class CurrencyGridGetCurrency {
    private CurrencyClient currencyClient = new CurrencyClient();
    private Grid<CurrencyDto> currencyDtoGrid =new Grid<>(CurrencyDto.class);

    public CurrencyGridGetCurrency() {currencyDtoGrid.setColumns("rates");
    }
    public void fillDataCurrency(){currencyDtoGrid.setItems(currencyClient.getCommercialRates());}
}
