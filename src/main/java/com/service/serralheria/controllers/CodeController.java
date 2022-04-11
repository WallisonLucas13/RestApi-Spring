package com.service.serralheria.controllers;

import com.service.serralheria.models.Cliente;
import com.service.serralheria.models.Code;
import com.service.serralheria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Code")
public class CodeController {


    @Autowired
    private ClienteRepository clienteRepository;
    Code code = new Code();

    //Get One ID
    @PostMapping("/{id}")
    public ResponseEntity setSingleId(@PathVariable("id") Long id){
        code.setIdSingleCliente(id);
        return ResponseEntity.ok().build();
    }
    //--------------------------------------------------------------

    //Get Page
    @GetMapping
    public ResponseEntity<?> getSingleId(){
        Optional<Cliente> c = clienteRepository.findById(code.getIdSingleCliente());

        if(c.isPresent()){
            ResponseEntity<Cliente> en = ResponseEntity.of(c);
            Cliente cliente = en.getBody();
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }
    //---------------------------------------------------------------
}
