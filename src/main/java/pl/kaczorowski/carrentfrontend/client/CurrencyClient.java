package pl.kaczorowski.carrentfrontend.client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.kaczorowski.carrentfrontend.domain.CurrencyDto;

import static java.util.Optional.ofNullable;

public class CurrencyClient {

    private RestTemplate restTemplate = new RestTemplate();

    public CurrencyDto getCommercialRates() {
        try {
            CurrencyDto response = restTemplate.getForObject("http://localhost:8080/v1/currency", CurrencyDto.class);
            return ofNullable(response).orElseGet(CurrencyDto::new);
        } catch (RestClientException e) {
            return new CurrencyDto();
        }
    }

}
