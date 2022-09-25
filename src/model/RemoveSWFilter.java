package model;

import java.util.ArrayList;
import java.util.List;

public class RemoveSWFilter extends Filter {
    private List<String> stopWords;
    private ArrayList<String> phraseWithoutStopWords = new ArrayList<String>();

    public RemoveSWFilter(){
         File file = new File();
         this.stopWords = file.getStopWords();
    }


    @Override
    protected Object process(Object inputData) {
        String[] phraseSplited = splitPhrase((String)inputData);


        for (String phraseWord : phraseSplited) {
            // Bandera para saber si la frase fue encontrada
            boolean phraseFound = false;
            // Compara cada palabra de la frase completa con el listado de palabras vacias
            for (String word : this.stopWords) {
                // System.out.println(word);
                // Si la palabra de la frase es igual a la palabra del listado, cambias bandera
                // a true y cortas el ciclo.
                if (phraseWord.equals(word)) {
                    // System.out.println("La palabra " + phraseWord + " se compara con " + word );
                    phraseFound = true;
                    break;
                }
            }
            // En dado caso que la palabra no haya sido encontrada, la agregas a un
            // arraylist el cual no contiene palabras vacias.
            if (!phraseFound) {
                this.phraseWithoutStopWords.add(phraseWord);
            }
        }

        return appendPhrasesWithoutSW();

    }

    private String[] splitPhrase(String phrase){
        return phrase.split(" ");
    }

    private String appendPhrasesWithoutSW(){
        StringBuilder stringBuilder = new StringBuilder();
        for (String phraseWord : phraseWithoutStopWords) {
            stringBuilder.append(phraseWord + " ");
        }
        return stringBuilder.toString();
    }

}
