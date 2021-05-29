package com.carros;

import com.carros.domain.Carro;
import com.carros.domain.CarroService;
import com.carros.domain.dto.CarroDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class CarrosApplicationTests {

    @Autowired
    private CarroService carroService;

	@Test
	public void test1() {

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
