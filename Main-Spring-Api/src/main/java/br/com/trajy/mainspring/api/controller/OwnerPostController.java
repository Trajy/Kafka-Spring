package br.com.trajy.mainspring.api.controller;

import static org.springframework.http.ResponseEntity.noContent;

import br.com.trajy.mainspring.api.model.dto.OwnerPostDto;
import br.com.trajy.mainspring.api.service.CarPostStoreService;
import br.com.trajy.mainspring.api.service.OwnerPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/owners")
@RequiredArgsConstructor
public class OwnerPostController {

    private final OwnerPostService service;

    @PostMapping
    public ResponseEntity<Void> createOwner(@RequestBody OwnerPostDto owner) {
        service.createOwner(owner);
        return noContent().build();
    }

}
