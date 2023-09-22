package br.com.trajy.storespring.api.service;

import static java.util.stream.Collectors.toList;

import br.com.trajy.storespring.api.model.dto.CarPostDto;
import br.com.trajy.storespring.api.model.entity.CarPostEntity;
import br.com.trajy.storespring.api.repository.CarPostRepository;
import br.com.trajy.storespring.api.repository.OwnerPostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarPostService {

    private final ModelMapper mapper;

    private final CarPostRepository repository;

    private final OwnerPostRepository ownerPostRepository;

    public void newPost(CarPostDto car) {
        ownerPostRepository.findById(car.getOwnerId()).ifPresentOrElse(
                ownerEntity -> {
                    CarPostEntity entity = mapper.map(car, CarPostEntity.class);
                    entity.setOwner(ownerEntity);
                    repository.save(entity);
                },
                () -> {
                    throw new NoSuchElementException("Owner id not found");
                }
        );
    }

    public List<CarPostDto> getCarsForSale() {
        return repository.findAll().stream().map(entity -> mapper.map(entity, CarPostDto.class)).collect(toList());
    }

    public void changeCarForSale(CarPostDto car, Long id) {
        repository.findById(id).ifPresentOrElse(
                entity -> {
                    mapper.map(car, entity);
                    repository.save(entity);
                },
                () -> {
                    throw new NoSuchElementException("Car id not found");
                }
        );
    }

    public void deleteCarForSale(Long id) {
        repository.deleteById(id);
    }

}
