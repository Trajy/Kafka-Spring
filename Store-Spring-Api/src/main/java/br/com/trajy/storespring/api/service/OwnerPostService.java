package br.com.trajy.storespring.api.service;

import br.com.trajy.storespring.api.model.dto.OwnerPostDto;
import br.com.trajy.storespring.api.model.entity.OwnerPostEntity;
import br.com.trajy.storespring.api.repository.OwnerPostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerPostService {

    private final ModelMapper mapper;

    private final OwnerPostRepository repository;

    public void createOwner(OwnerPostDto owner) {
        repository.save(mapper.map(owner, OwnerPostEntity.class));
    }

}
