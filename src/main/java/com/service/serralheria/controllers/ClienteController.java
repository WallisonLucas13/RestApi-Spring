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
    @PostMapping("New/{token}")
    public ResponseEntity cadastrar(@RequestBody @Valid Cliente cliente, @PathVariable("token") String token){
        if(token.equals("######")) {

            Date data = new Date();
            String date = new SimpleDateFormat("dd/MM/yyyy").format(data);
            cliente.setData(date);
            clientes.save(cliente);
            return ResponseEntity.ok().build();

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    //---------------------------------------------------------------------------

    //List
    @GetMapping("GetAllCliente/{token}")
    public ResponseEntity<List<Cliente>> listar(@PathVariable("token") String token){
        if(token.equals("######")){
            return ResponseEntity.ok(clientes.findAll());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    //--------------------------------------------------------------

    //Delete
    @DeleteMapping("DeleteById/{token}/{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id, @PathVariable("token") String token){

        if(token.equals("#####")) {
            Optional<Cliente> c = clientes.findById(id);

            if (c.isPresent() == false) {
                return ResponseEntity.notFound().build();
            }
            clientes.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    //-----------------------------------------------------------------

 }
