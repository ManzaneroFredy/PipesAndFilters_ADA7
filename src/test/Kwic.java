package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.AlfabetizerFilter;
import model.CombinationsFilter;
import model.File;
import model.LowerCaseFilter;
import model.Pipe;
import model.RemoveSWFilter;

public class Kwic {
    public static void main(String[] args) throws IOException {

        
        String rute = args[0];
        File file = new File(rute);
        List<String> phraseWords = new ArrayList<>();
        phraseWords = file.getLines();
        
        
       // System.out.println("Frase inicial: " + phrase);


        Pipe pipeTest = new Pipe();
        pipeTest.register(new LowerCaseFilter());
        pipeTest.register(new RemoveSWFilter(args[1]));
        pipeTest.register(new CombinationsFilter());
        pipeTest.register(new AlfabetizerFilter());



        for (String phrase : phraseWords) {
            for (String string : (String[]) pipeTest.execute(phrase)) {
                System.out.println(string);
            }    
            System.out.println("");
        }

        

    }

}