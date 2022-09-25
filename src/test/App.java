package test;

import java.io.IOException;

import model.AlfabetizerFilter;
import model.CombinationsFilter;
import model.LowerCaseFilter;
import model.Pipe;
import model.RemoveSWFilter;

public class App {
    public static void main(String[] args) throws IOException {
        String phrase = "la casa AzUl graNde";
        System.out.println("Frase inicial: " + phrase);


        Pipe pipeTest = new Pipe();
       
        
       
        pipeTest.register(new LowerCaseFilter());
        
        pipeTest.register(new RemoveSWFilter());
        pipeTest.register(new CombinationsFilter());
        pipeTest.register(new AlfabetizerFilter());
        
        
        
        
        
        
        

        
        

        
        for (String string : (String[]) pipeTest.execute(phrase)) {
            System.out.println(string);
        }
     
    }

}
