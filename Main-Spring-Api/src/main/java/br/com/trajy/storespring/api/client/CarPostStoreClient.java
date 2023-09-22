package br.com.trajy.storespring.api.client;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

import br.com.trajy.storespring.api.model.dto.CarPostDto;
import br.com.trajy.storespring.api.model.dto.OwnerPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CarPostStoreClient {

    private static final String USER_STORE_SERVICE_URI = "http://localhost:8086/users/";

    private static final String POST_STORE_SERVICE_URI = "http://localhost:8086/cars/";

    private final RestTemplate restTemplate;

    public List<CarPostDto> carsForSale() {
        ResponseEntity<CarPostDto[]> response = restTemplate.getForEntity(POST_STORE_SERVICE_URI, CarPostDto[].class);
        return asList(requireNonNull(response.getBody()));
    }

    public void ownerPost(OwnerPostDto owner) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, owner, OwnerPostDto.class);
    }

    public void changeCarForSale(CarPostDto car, String id) {
        restTemplate.put(POST_STORE_SERVICE_URI  + id, car, CarPostDto.class);
    }

    public void deleteCarForSale(String id) {
        restTemplate.delete(POST_STORE_SERVICE_URI + id);
    }

}
