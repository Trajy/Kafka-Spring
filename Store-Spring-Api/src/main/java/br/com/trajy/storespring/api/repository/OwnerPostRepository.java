package br.com.trajy.storespring.api.repository;

import br.com.trajy.storespring.api.model.entity.OwnerPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {

}
