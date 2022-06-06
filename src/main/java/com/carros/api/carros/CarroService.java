package com.carros.api.carros;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    public CarroRepository rep;

    public List<CarroDTO> getCarros() {

        return rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
        //com lambda
        // find all retorna uma lista de carros, o metodo stream mapeia a lista, percorre carro por carro
        // e cria um carroDTO e depois, na collect, gera uma nova lista de carroDTO
    }

    public CarroDTO getCarroById(Long id) {
        return rep.findById(id).map(CarroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
        //sintaxe resumida com lambda
    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {

        return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public CarroDTO insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        return CarroDTO.create(rep.save(carro));
        //retorna o objeto
    }

    public CarroDTO updateCarro(Long id, Carro carro) {
        Assert.notNull(id, "Não foi possível localizar o registro");

        //busca o carro no banco de dados
        Optional<Carro> retorno = rep.findById(id);
        if (retorno.isPresent()) {
            //preciso fazer um get porque é opcional
            Carro db = retorno.get();
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());

            System.out.println("Carro id " + db.getId());
            //salvo o objeto db atualizado no banco
            rep.save(db);

            return CarroDTO.create(db);
        } else {
            //throw new RuntimeException("Não foi possível atualizar o registro");
            return null;
        }
        //TODO trocar para lambada
    }

    public void deleteCarro(Long id) {
        Assert.notNull(id, "Não foi possível localizar o registro");
/*
        //busca o carro no banco de dados
        Optional<CarroDTO> retorno = getCarroById(id);
        if(retorno.isPresent()) {
            CarroDTO db = retorno.get();
            //preciso fazer um get porque é opcional
            rep.deleteById(id);
            return db;
        }else{
            throw new RuntimeException("Não foi possível atualizar o registro");
        }


 */
            rep.deleteById(id);
    }
}

