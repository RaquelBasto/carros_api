package com.carros;

import com.carros.domain.Carro;
import com.carros.domain.CarroService;
import com.carros.domain.dto.CarroDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarrosApplicationTests {

    @Autowired
    private CarroService carroService;

	@Test
	public void test1() {

        Carro carro = new Carro();
        carro.setNome("Ferrari");
        carro.setTipo("Esportivo");

        CarroDTO carroSave = carroService.insert(carro);

        assertNotNull(carroSave);

        Long id = carro.getId();
        assertNotNull(id);

        //Buscar o objeto
        CarroDTO carroId= carroService.getCarroById(id);
        assertNotNull(carroId);

        assertEquals("Ferrari", carro.getNome());
        assertEquals("Esportivo", carro.getTipo());

/*        //deletar o carro
        carroService.deleteCarro(id);

        //verificar se deletou
        assertNull(carroService.getCarroById(id));*/
//TODO finalizar os testes
	}
/*
    @Test
    public void testeLista() {

        List<CarroDTO>
        Carro carro = new Carro();
        carro.setNome("Ferrari");
        carro.setTipo("Esportivo");

        CarroDTO carroDTO = carroService.save(carro);

        assertNotNull(carroDTO);

        Long id = carro.getId();
        assertNotNull(id);

        //Buscar o objeto
        CarroDTO op = carroService.getCarroById(id);
    }

 */
}
