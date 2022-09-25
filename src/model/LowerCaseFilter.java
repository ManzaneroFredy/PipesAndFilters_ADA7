package model;

public class LowerCaseFilter extends Filter {

    @Override
    protected Object process(Object inputData) {
        String phrase = (String) inputData;
        return phrase.toLowerCase();
    }
    
}
