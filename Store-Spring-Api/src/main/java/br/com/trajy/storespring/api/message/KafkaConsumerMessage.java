package br.com.trajy.storespring.api.message;

import br.com.trajy.storespring.api.model.dto.CarPostDto;
import br.com.trajy.storespring.api.service.CarPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerMessage {

    private final CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(Message<CarPostDto> message) {
        log.info("Received: {}", message.getPayload());
        carPostService.newPost(message.getPayload());
    }

}
