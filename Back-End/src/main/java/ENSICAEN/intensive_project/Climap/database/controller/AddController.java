package ENSICAEN.intensive_project.Climap.database.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/add")
public class AddController {

    @PostMapping
    public String recevoirFichier(@RequestParam("file") MultipartFile file) {
        // Traitement du fichier ici
        try {
            System.out.println(file.getBytes().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Fichier reçu avec succès";
    }
}