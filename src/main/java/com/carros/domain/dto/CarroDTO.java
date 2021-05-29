package com.carros.domain.dto;

import com.carros.domain.Carro;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data//unico argumento para getter, setter, constructor etc
public class CarroDTO {

    private Long id;
    private String nome;
    private String tipo;

    //gera o CArroDTO apartir do objeto carro
    public static CarroDTO create(Carro c){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(c, CarroDTO.class);
    }

}
