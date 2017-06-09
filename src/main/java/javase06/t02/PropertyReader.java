package javase06.t02;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
 * Физическое чтение файла должно происходить только один раз.
 * Результаты чтения храните в коллекции типа Map.
 * Ответьте на вопрос: как ведет себя map-коллекция если в нее добавить элемент с ключом, который уже присутствует?
 */

class PropertyReader {
    private Map<String, Properties> map = new HashMap<>();

    /**
     * Reads only ones from property file and stores {@code key} & {@code value} in HashMap
     *
     * @throws PropertyFileNotFoundException If {@code propFileName} is not found
     * @param propFileName is the name of properties file
     * @param key is the key in properties file
     * @return value by {@code key}  or  {@code null} if such key not found
     */
    String getValueByKey(String propFileName, String key) {
        return map.computeIfAbsent(propFileName, (file) -> {
            try (InputStream in = getClass().getResourceAsStream(file)) {
                if (in == null) {
                    throw new PropertyFileNotFoundException("File Not found: " + file);
                }
                Properties prop = new Properties();
                prop.load(in);
                return prop;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).getProperty(key);
    }
}

class PropertyFileNotFoundException extends RuntimeException {
    PropertyFileNotFoundException(String message) {
        super(message);
    }
}

// Как ведет себя map-коллекция если в нее добавить элемент с ключом, который уже присутствует?
// Значение по этому ключу заменяется новым элементом