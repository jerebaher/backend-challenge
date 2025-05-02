package com.directa24.main.challenge.common.util.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserImpl implements JsonParser {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T parseObject(String json, TypeReference<T> typeRef) {
        try {
            return mapper.readValue(json, typeRef);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON: " + e.getMessage(), e);
        }
    }
}
