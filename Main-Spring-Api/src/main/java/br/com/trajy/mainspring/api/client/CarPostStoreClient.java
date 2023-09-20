package br.com.trajy.mainspring.api.client;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

import br.com.trajy.mainspring.api.model.dto.CarPostDto;
import br.com.trajy.mainspring.api.model.dto.OwnerPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CarPostStoreClient {

    private static final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";

    private static final String POST_STORE_SERVICE_URI = "http://localhost:8080/sales";

    private final RestTemplate restTemplate;

    public List<CarPostDto> carsForSale() {
        ResponseEntity<CarPostDto[]> response = restTemplate.getForEntity(POST_STORE_SERVICE_URI + "/cars", CarPostDto[].class);
        return asList(requireNonNull(response.getBody()));
    }

    public void ownerPost(OwnerPostDto owner) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, owner, OwnerPostDto.class);
    }

    public void changeCarForSale(CarPostDto car, String id) {
        restTemplate.put(POST_STORE_SERVICE_URI + "/car" + id, car, CarPostDto.class);
    }

    public void deleteCarForSale(String id) {
        restTemplate.delete(POST_STORE_SERVICE_URI + "/car" + id);
    }

}
