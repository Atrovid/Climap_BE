package ENSICAEN.intensive_project.Climap.database.controller;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/add")
public class AddController {

    @PostMapping
    public void receiveFileFromDevice(@RequestBody String file) throws IOException {

        String existingJsonFilePath = "src/main/java/ENSICAEN/intensive_project/Climap/database/resource/Device.json";

        ObjectMapper mapper = new ObjectMapper();

        var node1 = mapper.readTree(new File(existingJsonFilePath));
        var node2 = mapper.readerForUpdating(node1).readTree(file);

        mapper.writeValue(new File(existingJsonFilePath), node2);
    }
}
