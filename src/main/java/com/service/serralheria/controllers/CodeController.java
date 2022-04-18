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

    //Set One ID
    @PostMapping("/SetByOne/{token}/{id}")
    public ResponseEntity setSingleId(@PathVariable("id") Long id, @PathVariable("token") String token){

        if(token.equals("NU5-&qRqt0XJPTI")) {

            code.setIdSingleCliente(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    //--------------------------------------------------------------

    //Get Page By Id
    @GetMapping("/GetPage/{token}")
    public ResponseEntity<?> getSingleId(@PathVariable("token") String token){
        if(token.equals("yPfqEaJRa3Gn0Oy")) {
            Optional<Cliente> c = clienteRepository.findById(code.getIdSingleCliente());

            if (c.isPresent()) {
                ResponseEntity<Cliente> en = ResponseEntity.of(c);
                Cliente cliente = en.getBody();
                return ResponseEntity.ok(cliente);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    //---------------------------------------------------------------
}
