package pl.kaczorowski.carrentfrontend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRatesDto {
    @JsonProperty("EUR")
    private double eur;
    @JsonProperty("USD")
    private double usd;

    private double showEur = Math.round(eur * 100);
    private double showUsd = Math.round(usd * 100);

    @Override
    public String toString() {
        return "Currency Rates \n" +
                "\n eur=" + usd +
                "\n usd=" + eur;
    }
}
