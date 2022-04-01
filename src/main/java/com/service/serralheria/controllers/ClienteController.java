package com.service.serralheria.controllers;
import com.service.serralheria.models.Cliente;
import com.service.serralheria.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clientes;

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        cliente.setData(new Date());
        return clientes.save(cliente);
    }

    @GetMapping
    public List<Cliente> listar(){
        return clientes.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent() == false){
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<Cliente> clienteEntity = ResponseEntity.of(cliente);
        Cliente clienteObject = clienteEntity.getBody();
        return ResponseEntity.ok(clienteObject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long id, @RequestBody Cliente clienteBody){

        Optional<Cliente> clienteExistente = clientes.findById(id);
        ResponseEntity<Cliente> clienteEntity = ResponseEntity.of(clienteExistente);
        Cliente clienteObject = clienteEntity.getBody();

        if(clienteExistente.isPresent() == false){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(clienteBody, clienteObject, "id","data");

        clientes.save(clienteObject);

        return ResponseEntity.ok(clienteObject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Long id){
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent() == false){
            ResponseEntity.notFound().build();
        }

        ResponseEntity<Cliente> clienteEntity = ResponseEntity.of(cliente);
        Cliente clienteObject = clienteEntity.getBody();

        clientes.delete(clienteObject);
        return ResponseEntity.noContent().build();
    }
}
