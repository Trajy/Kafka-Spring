package br.com.trajy.mainspring.api.service;

import br.com.trajy.mainspring.api.client.CarPostStoreClient;
import br.com.trajy.mainspring.api.message.KafkaProducerMessage;
import br.com.trajy.mainspring.api.model.dto.CarPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarPostStoreService {

    private final CarPostStoreClient carClient;

    private final KafkaProducerMessage kafkaProducerMessage;

    public List<CarPostDto> getCarsForSale(){
        return carClient.carsForSale();
    }

    public void changeCarForSale(CarPostDto car, String id){
        carClient.changeCarForSale(car, id);
    }

    public void deleteCarForSale(String id){
        carClient.deleteCarForSale(id);
    }

    public void createCarForSale(CarPostDto car) {
        kafkaProducerMessage.send(car);
    }

}
