package br.com.trajy.storespring.api.repository;

import br.com.trajy.storespring.api.model.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {

}
