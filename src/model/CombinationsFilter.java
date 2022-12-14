package model;

import java.util.ArrayList;

public class CombinationsFilter extends Filter {

    //Listado de listado de palabras
    private ArrayList<ArrayList<String>> WordsCombination = new ArrayList<ArrayList<String>>();


    //Listado de frases
    private String[] phraseCombinations;

    @Override
    protected Object process(Object inputData) {
        
        ArrayList<String> phraseWords = new ArrayList<String>();

        //Si combinaciones se ejecuta primero, entonces va a recibir un String
        if(inputData instanceof String){
            for (String phraseWord : splitPhrase((String) inputData)) {
                phraseWords.add(phraseWord);
            }
        }else{
            //Si combinaciones se ejecuta despues de algun otro filtro, va a recibir String[]
            //Como estamos manejando todo en String[], debemos obtener el unico elemento String[0] que pueden devolver los otros filtros.
            String[] tempInputData = (String[]) inputData;
            for (String phraseWord : splitPhrase(tempInputData[0])) {
                phraseWords.add(phraseWord);
            }
        }
       
        
         // Creamos una copia del array original para modificarla
         ArrayList<String> modificablePhraseWords = (ArrayList<String>) phraseWords.clone();
         for (int i = 0; i <phraseWords.size(); i++) {
             // Antes de realizar el primer intercambio, guardamos la frase en el array de
             // combinaciones
             if (i == 0) {
                 WordsCombination.add(modificablePhraseWords);
             }
             // Intercambiamos el orden del primer elemento en el array
             modificablePhraseWords.add(modificablePhraseWords.get(0));
             modificablePhraseWords.remove(0);
             // Comparamos si el array modificado es igual al array con las
             // palabrasOriginales
             if (phraseWords.equals(modificablePhraseWords)) {
                 // System.out.println("Frases identicas");
                 // Si durante la comparacion se encuentran coincidencias, el ciclo se rompe
                 break;
             } else {
                 // Inserta la combinacion al array de combinaciones
                 WordsCombination.add((ArrayList<String>) modificablePhraseWords.clone());
             }
         }
         
         
         String[] tempCombinations = appendPhraseCombinations();
         
         
         //Vaciamos los arrays para evitar que se guarde basura
         phraseCombinations = null;
         WordsCombination.clear();

         //retornamos el array de combinaciones
         return tempCombinations;
    }


    private String[] splitPhrase(String phrase){
        return phrase.split(" ");
    }


    private String[] appendPhraseCombinations(){
        phraseCombinations = new String[WordsCombination.size()];
        for(int i = 0 ; i < WordsCombination.size();i++){
            phraseCombinations[i] = appendPhrases(WordsCombination.get(i));
        }
        return phraseCombinations;
    }


    private String appendPhrases(ArrayList<String> phraseWords){
        StringBuilder stringBuilder = new StringBuilder();
        for (String phraseWord : phraseWords) {
            stringBuilder.append(phraseWord + " ");
        }
        return stringBuilder.toString();
    }
    
}
