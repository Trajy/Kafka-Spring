package br.com.trajy.storespring.api.repository;

import br.com.trajy.storespring.api.model.entity.CarModelPriceAnalyticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CarModelPriceRepository extends JpaRepository<CarModelPriceAnalyticEntity, Long> {

    Optional<CarModelPriceAnalyticEntity> findByModel(String model);

}
