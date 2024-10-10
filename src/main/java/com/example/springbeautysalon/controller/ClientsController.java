package com.example.springbeautysalon.controller;

import com.example.springbeautysalon.dto.ClientDTO;
import com.example.springbeautysalon.service.Impl.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients/admin")
public class ClientsController {

    private final ClientServiceImpl clientService;

    public ClientsController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<ClientDTO>> getClients() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(clientService.createOrUpdateClient(clientDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable int id){
       return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK) ;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateClient(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(clientService.createOrUpdateClient(clientDTO), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<?> findById(@RequestBody int id){
        return new ResponseEntity<>(clientService.findById((long) id), HttpStatus.OK);
    }
}
