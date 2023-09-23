package br.com.trajy.storespring.api.message;

import br.com.trajy.storespring.api.model.dto.CarPostDto;
import br.com.trajy.storespring.api.service.PostAnalyticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AnalyticsKafkaListener {

    private final PostAnalyticsService service;

    @KafkaListener(topics = "car-post-topic", groupId = "api-analytics-group")
    public void listener(CarPostDto car) {
        log.info("Analycis Data Received: {}", car);
        service.saveDataAnalytics(car);
    }
}
