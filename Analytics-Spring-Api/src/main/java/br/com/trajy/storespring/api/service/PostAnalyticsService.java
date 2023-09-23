package br.com.trajy.storespring.api.service;

import br.com.trajy.storespring.api.model.dto.CarPostDto;
import br.com.trajy.storespring.api.model.entity.BrandAnalyticEntity;
import br.com.trajy.storespring.api.model.entity.CarModelPriceAnalyticEntity;
import br.com.trajy.storespring.api.repository.BrandAnalyticRepository;
import br.com.trajy.storespring.api.repository.CarModelPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PostAnalyticsService {

    private final CarModelPriceRepository carModelPriceRepository;

    private final BrandAnalyticRepository brandAnalyticRepository;

    public void saveDataAnalytics(CarPostDto car) {
        this.saveBrandAnalytics(car.getBrand());
        this.saveModelAnalytics(car.getModel(), car.getPrice());
    }

    private void saveBrandAnalytics(String brand) {
        this.brandAnalyticRepository.findByBrand(brand).ifPresentOrElse(
                brandAnalyticEntity -> {
                    brandAnalyticEntity.setPosts(brandAnalyticEntity.getPosts() + 1);
                    this.brandAnalyticRepository.save(brandAnalyticEntity);
                },
                () -> {
                    this.brandAnalyticRepository.save(
                        BrandAnalyticEntity.builder()
                                .brand(brand)
                                .id(1L)
                                .build()
                    );
                }
        );
    }

    private void saveModelAnalytics(String model, BigDecimal price) {
        this.carModelPriceRepository.findByModel(model).ifPresentOrElse(
                carModelPriceAnalyticEntity -> {
                    carModelPriceAnalyticEntity.setPrice(carModelPriceAnalyticEntity.getPrice().add(price));
                    this.carModelPriceRepository.save(carModelPriceAnalyticEntity);
                },
                () -> {
                    carModelPriceRepository.save(
                        CarModelPriceAnalyticEntity.builder()
                                .model(model)
                                .price(price)
                                .build()
                    );
                }
        );
    }

}
