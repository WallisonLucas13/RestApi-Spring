package com.service.serralheria.controllers;

import com.service.serralheria.models.Cliente;
import com.service.serralheria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ClienteController {

    @Autowired
    private ClienteRepository clientes;

    //Add New
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid Cliente cliente){
        Date data = new Date();
        String date = new SimpleDateFormat("dd/MM/yyyy").format(data);
        cliente.setData(date);
        clientes.save(cliente);
        return ResponseEntity.ok().build();
    }
    //---------------------------------------------------------------------------

    //List
    @GetMapping
    public List<Cliente> listar(){
        return clientes.findAll();
    }
    //--------------------------------------------------------------

    //Delete
    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id){
        Optional<Cliente> c = clientes.findById(id);

            if (c.isPresent() == false) {
                return ResponseEntity.notFound().build();
            }
            clientes.deleteById(id);
            return ResponseEntity.ok().build();
    }
    //-----------------------------------------------------------------

 }
