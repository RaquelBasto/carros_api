package com.carros.domain;

import com.carros.domain.dto.CarroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByTipo(String tipo);
    //como o tipo é um atributo da classe carro, o spring consegue fazer automaticamente.
}
