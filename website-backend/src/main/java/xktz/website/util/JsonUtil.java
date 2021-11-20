package xktz.website.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

/**
 * Util for json
 */
@Slf4j
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> String toString(T obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public static <T> T toObject(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

    public static <T> T toObject(String json, TypeReference<T> tp) throws JsonProcessingException {
        return mapper.readValue(json, tp);
    }

    public static <T> T toObject(InputStream stream, Class<T> clazz) throws IOException {
        return mapper.readValue(stream, clazz);
    }

    public static <T> T toObject(InputStream stream, TypeReference<T> tp) throws IOException {
        return mapper.readValue(stream, tp);
    }
}
