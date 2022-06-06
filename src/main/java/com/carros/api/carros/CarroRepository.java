package com.carros.api.carros;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByTipo(String tipo);
    //como o tipo é um atributo da classe carro, o spring consegue fazer automaticamente.
}
