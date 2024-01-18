package ENSICAEN.intensive_project.Climap.database.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/add")
public class AddController {

    @PostMapping
    public String recevoirFichier(@RequestBody String file) throws IOException {
        // Traitement du fichier ici
        System.out.println(file);

        String existingJsonFilePath = "src/main/java/ENSICAEN/intensive_project/Climap/database/resource/Device.json";
        String newJsonFilePath = "src/main/java/ENSICAEN/intensive_project/Climap/database/resource/output.json";

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Read the existing JSON file
            JsonNode existingJson = mapper.readTree(new File(existingJsonFilePath));

            System.out.println("existingJson");
            System.out.println(existingJson);

            // Read the new JSON file
            //JsonNode newJson = mapper.readTree(new File(newJsonFilePath));
            JsonNode newJson = mapper.readTree(file);

            System.out.println("newJson");
            System.out.println(newJson);

            // Check if the existing JSON is an array
            if (existingJson.isArray()) {
                // If it's an array, add the new JSON to it
                ArrayNode existingArray = (ArrayNode) existingJson;
                existingArray.add(newJson);
            } else {
                // If it's not an array, create a new array and add both JSON objects
                ArrayNode newArray = mapper.createArrayNode();
                newArray.add(existingJson);
                newArray.add(newJson);
                existingJson = newArray;
            }

            System.out.println("existingJson");
            System.out.println(existingJson);

            // Write the combined JSON back to the existing file
            mapper.writeValue(new File(existingJsonFilePath), existingJson);

            System.out.println("JSON data combined and updated in Device.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Fichier reçu avec succès";
    }
}
