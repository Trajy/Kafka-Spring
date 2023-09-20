package br.com.trajy.mainspring.api.message;

import br.com.trajy.mainspring.api.model.dto.CarPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducerMessage {

    private static final String KAFKA_CAR_TOPIC = "car-post-topic";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(CarPostDto car) {
        kafkaTemplate.send(KAFKA_CAR_TOPIC, car);
    }

}
