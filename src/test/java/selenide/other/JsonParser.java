package selenide.other;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode parse(String json) throws Exception{
        return objectMapper.readTree(json);
    }

}
