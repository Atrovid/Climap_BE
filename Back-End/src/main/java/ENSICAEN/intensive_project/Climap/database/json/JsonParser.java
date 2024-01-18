package ENSICAEN.intensive_project.Climap.database.json;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonParser {
    public List<DeviceResponseJson> parseJson(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }
}
