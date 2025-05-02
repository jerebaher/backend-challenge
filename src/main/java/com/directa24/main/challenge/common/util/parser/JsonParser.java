package com.directa24.main.challenge.common.util.parser;

import com.fasterxml.jackson.core.type.TypeReference;

public interface JsonParser {
    <T> T parseObject(String json, TypeReference<T> typeRef);
}
