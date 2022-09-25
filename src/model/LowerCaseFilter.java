package model;

public class LowerCaseFilter extends Filter {

    @Override
    protected Object process(Object inputData) {
       

        //Cuando la entrada es de tipo string, devuelve String[1] convertido  a minusculas
        if (inputData instanceof String) {
            String phrase = (String) inputData;
            String[] phraseDataReturn = new String[1];
            phraseDataReturn[0] = phraseToLowerCase(phrase);
            return phraseDataReturn;

        }
        // if(inputData instanceof String[])
        //Si no es de tipo String, entonces quiere decir que esta llegando un String[n], por lo que debe convertir cada elemento n en minusculas y devolverlo en otro String[n]
        else {
            String[] tempInputData = (String[]) inputData;
            String[] phrasesToLowerCase = new String[tempInputData.length];

            for (int i = 0; i< tempInputData.length;i++) {
                phrasesToLowerCase[i] = phraseToLowerCase(tempInputData[i]); 
            }
            return phrasesToLowerCase;
        }

    }

    public String phraseToLowerCase(String phrase) {
        return phrase.toLowerCase();
    }

}
