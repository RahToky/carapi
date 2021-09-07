package mg.rmahatoky.carapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mg.rmahatoky.carapi.CarApiApplicationTest;
import mg.rmahatoky.carapi.model.entity.Car;
import mg.rmahatoky.carapi.repository.ICarRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CarApiApplicationTest.class)

@AutoConfigureMockMvc
public class CarControllerTest {

    Logger logger = LogManager.getLogger(CarControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveCarSuccess() throws Exception{

        Car car = new Car();
        car.setBrand("HYUNDAI");
        car.setModel("Getz");
        car.setPhoto("photo/getz.png");

        String carJson = objectMapper.writeValueAsString(car);

        // Insert CAR into H2 DB
        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(carJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void getCarsSuccess() throws Exception{
        MvcResult result = mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn();
        String content = result.getResponse().getContentAsString();
        logger.info("result = {}",content);
    }
}
