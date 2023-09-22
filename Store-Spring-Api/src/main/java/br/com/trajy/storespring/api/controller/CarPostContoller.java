package br.com.trajy.storespring.api.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import br.com.trajy.storespring.api.model.dto.CarPostDto;
import br.com.trajy.storespring.api.service.CarPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarPostContoller {

    private final CarPostService service;

    @GetMapping
    public ResponseEntity<List<CarPostDto>> getCarForSale() {
        return ok(service.getCarsForSale());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCarForSale(@RequestBody CarPostDto car, @PathVariable Long id) {
        service.changeCarForSale(car, id);
        return noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarForSale(@PathVariable Long id) {
        service.deleteCarForSale(id);
        return noContent().build();
    }

}
