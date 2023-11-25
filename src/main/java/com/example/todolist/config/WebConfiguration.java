package com.example.todolist.config;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import io.hypersistence.utils.hibernate.type.json.JsonStringType;
import jakarta.persistence.AttributeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements AttributeConverter<String, JsonBinaryType> {



    @Override
    public JsonBinaryType convertToDatabaseColumn(String attribute) {
        return JsonBinaryType.INSTANCE;
    }

    @Override
    public String convertToEntityAttribute(JsonBinaryType dbData) {
        return null;
    }
}
