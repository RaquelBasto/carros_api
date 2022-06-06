package com.carros.api.carros;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarroDTO carroDTO = (CarroDTO) o;
        return Objects.equals(getNome(), carroDTO.getNome()) &&
                Objects.equals(getTipo(), carroDTO.getTipo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getTipo());
    }
}
