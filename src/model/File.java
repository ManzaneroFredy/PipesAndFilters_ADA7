package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class File {

    private List<String> contentFile;
    private String path;

    public File(String path) {
        this.path = path;
        loadFile();
    }

    public void loadFile() {
        try {
            contentFile = Files.readAllLines(Paths.get(this.path));
        } catch (IOException e) {
            System.out.println("Ocurrió un error al cargar el archivo");
            e.printStackTrace();
        }
    }

    public List<String> getLines(){
        return contentFile;
    }

}
