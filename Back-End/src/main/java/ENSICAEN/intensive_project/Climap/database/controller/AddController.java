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

        String existingJsonFilePath = "src/main/java/ENSICAEN/intensive_project/Climap/database/resource/Device.json";
        String newJsonFilePath = "src/main/java/ENSICAEN/intensive_project/Climap/database/resource/output.json";

        ObjectMapper mapper = new ObjectMapper();

        var node1 = mapper.readTree(new File(existingJsonFilePath));
        var node2 = mapper.readerForUpdating(node1).readTree(file);

        mapper.writeValue(new File(existingJsonFilePath), node2);

        return "Fichier reçu avec succès";
    }
}
