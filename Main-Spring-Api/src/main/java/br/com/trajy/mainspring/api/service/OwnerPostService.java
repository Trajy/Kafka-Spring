package br.com.trajy.mainspring.api.service;

import br.com.trajy.mainspring.api.client.CarPostStoreClient;
import br.com.trajy.mainspring.api.model.dto.OwnerPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerPostService {

    private final CarPostStoreClient carClient;

    public void createOwner(OwnerPostDto owner) {
        carClient.ownerPost(owner);
    }

}
