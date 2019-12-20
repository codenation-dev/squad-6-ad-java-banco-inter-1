package br.com.codenation.aceleradev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

public abstract class AbstractTest {

    protected <T> T mapFromJson(String json, Class<T> clazz) {
        return new GsonBuilder().create().fromJson(json, clazz);
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
