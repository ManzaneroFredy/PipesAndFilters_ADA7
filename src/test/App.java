package test;
import java.io.IOException;

import model.CombinationsFilter;
import model.File;
import model.Kwic;
import model.LowerCaseFilter;
import model.Pipe;
import model.RemoveSWFilter;



public class App {
    public static void main(String[] args) throws IOException {
        String phrase = "La casa AzUl graNde"; 
        System.out.println("Frase inicial: " + phrase);
        //File file = new File();
       // Kwic kwic = new Kwic(phrase, file.getStopWords());
        Pipe pipeTest = new Pipe();
        pipeTest.register(new LowerCaseFilter());
        pipeTest.register(new RemoveSWFilter());
        pipeTest.register(new CombinationsFilter());
        
        
        

        for (String string : (String [])pipeTest.execute(phrase)) {
            System.out.println(string);
        }


        //kwic.process();
        //System.out.println("Combinaciones: ");
        //kwic.printOrderedPhraseCombinations();
    }

}
