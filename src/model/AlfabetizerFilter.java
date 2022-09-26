package model;

import java.util.Arrays;

public class AlfabetizerFilter extends Filter {

    @Override
    protected Object process(Object inputData) {
       
        if(inputData instanceof String){
            String[] phraseDataReturn = new String[1];
            phraseDataReturn[0] = (String) inputData;
            return phraseDataReturn;
        }else{

            String[] phrasesOrdered = (String[]) inputData;
            Arrays.sort(phrasesOrdered, String.CASE_INSENSITIVE_ORDER);
            return phrasesOrdered;
        }
       
    }
    
}
