package com.example.jpa_h2_demo.controller;

import com.example.jpa_h2_demo.model.Cliente;
import com.example.jpa_h2_demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        return ResponseEntity.ok(clienteRepository.findById(idClient).get());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient) {
        clienteRepository.deleteById(idClient);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        clienteRepository.findById(id).map(clienteExistente -> {
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setIdade(cliente.getIdade());
            clienteExistente.setTelefones(cliente.getTelefones());
            clienteExistente.setEnderecos(cliente.getEnderecos());
            return clienteRepository.save(clienteExistente);
        });
    }
}
