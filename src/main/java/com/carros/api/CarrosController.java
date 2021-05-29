package com.carros.api;

import com.carros.domain.Carro;
import com.carros.domain.CarroService;
import com.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> get() {
        return ResponseEntity.ok(service.getCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarrosById(@PathVariable("id") Long id) {
        //return new ResponseEntity<>(service.getCarroById(id),HttpStatus.OK); // como está passando o objeto no OK ja chama o build
        CarroDTO carro = service.getCarroById(id);
        return ResponseEntity.ok(carro);
/*
        if (carro.isPresent()){
            return ResponseEntity.ok(carro.get()); // como está passando o objeto no OK ja chama o build
        }else{
            return ResponseEntity.notFound().build();
        }
 */
/*
        //if ternario
        return carro.isPresent() ?
                ResponseEntity.ok(carro.get()) :
                ResponseEntity.notFound().build();

        //lambda
        return carro //vai ser chamado apenas se existir o objeto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // se não existir o registro
 */
    }

    //iterable porque é lista
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {
        List<CarroDTO> carros = service.getCarrosByTipo(tipo);

        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Carro carro) {
        CarroDTO c = service.save(carro);

        URI location = getUri(c.getId());
        return ResponseEntity.created(null).build();
    }
    //TODO retornar bad request. Video 41

    private URI getUri(Long id){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {

        CarroDTO c = service.updateCarro(id, carro);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        service.deleteCarro(id);
/*
        return ok ?
                ResponseEntity.ok(id) :
                ResponseEntity.notFound().build();
 */
        return ResponseEntity.ok(id);
    }

}