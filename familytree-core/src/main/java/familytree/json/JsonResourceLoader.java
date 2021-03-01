package familytree.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

public class JsonResourceLoader<T> {

    public T load(Class<T> klazz, String resourceName) {
        try (final InputStream json = asStream(resourceName);
             final Reader jsonReader = new InputStreamReader(json);) {
            return createGson().fromJson(jsonReader, klazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream asStream(String resourceName) throws JsonResourceNotFoundException {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new JsonResourceNotFoundException("Resource '" + resourceName + "' not found!");
        }
        return inputStream;
    }

    private static Gson createGson() {
        return new GsonBuilder().disableHtmlEscaping().serializeNulls().setPrettyPrinting().create();
    }

    public static class JsonResourceNotFoundException extends RuntimeException {
        public JsonResourceNotFoundException(String message) {
            super(message);
        }
    }
}
