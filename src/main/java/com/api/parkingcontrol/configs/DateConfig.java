package com.api.parkingcontrol.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateConfig {
    //T separação entre data e hora, e o Z é o nosso UTC -3
    public static final String DATETIME_FORMAT = "yyy-MM-dd'T'HH:mm:ss'Z'";
    public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

    //Bean necessário para considerar a classe externa da nossa aplicação(ObjectMapper)
    @Bean
    //Primary por questões de prioridade caso seja gerado outros Beans para object mapper
    @Primary
    public ObjectMapper objectMapper(){
        //Java Time Module + Object Mapper -> Para que as datas assumam o nosso padrão definido
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
        return new ObjectMapper()
                .registerModule(module);
    }
}
