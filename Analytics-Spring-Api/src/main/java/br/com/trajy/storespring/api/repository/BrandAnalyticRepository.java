package br.com.trajy.storespring.api.repository;

import br.com.trajy.storespring.api.model.entity.BrandAnalyticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BrandAnalyticRepository extends JpaRepository<BrandAnalyticEntity, Long> {

    Optional<BrandAnalyticEntity> findByBrand(String brand);

}
