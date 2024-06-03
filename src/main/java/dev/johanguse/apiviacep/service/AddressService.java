package dev.johanguse.apiviacep.service;

import dev.johanguse.apiviacep.dto.AddressDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@Service
public class AddressService {

    private RestTemplate restTemplate;

    public AddressDTO getAddressByCEP(String cep) {

        String url = UriComponentsBuilder.fromHttpUrl("https://viacep.com.br/ws/{cep}/json/")
                .buildAndExpand(cep).toUriString();

        return restTemplate.getForObject(url, AddressDTO.class);
    }
}
