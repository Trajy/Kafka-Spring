package br.com.trajy.mainspring.api.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import br.com.trajy.mainspring.api.model.dto.CarPostDto;
import br.com.trajy.mainspring.api.service.CarPostStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@RequiredArgsConstructor
public class CarPostController {

    private final CarPostStoreService service;

    @GetMapping
    public ResponseEntity<List<CarPostDto>> getCarsForSale() {
        return ok(service.getCarsForSale());
    }

    @PostMapping
    public ResponseEntity<Void> createCarForSale(@RequestBody CarPostDto car) {
        service.createCarForSale(car);
        return noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCarForSale(@RequestBody CarPostDto car, @PathVariable String id) {
        service.changeCarForSale(car, id);
        return noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCarForSale(@PathVariable String id) {
        service.deleteCarForSale(id);
        return noContent().build();
    }

}
