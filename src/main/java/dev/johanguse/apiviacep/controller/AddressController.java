package dev.johanguse.apiviacep.controller;

import dev.johanguse.apiviacep.dto.AddressDTO;
import dev.johanguse.apiviacep.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService addressService;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable String cep) {

        AddressDTO addressDTO = addressService.getAddressByCEP(cep);

        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }
}
