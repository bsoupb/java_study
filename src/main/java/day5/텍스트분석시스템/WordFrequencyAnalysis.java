package day5.텍스트분석시스템;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyAnalysis implements TextAnalysisStrategy {

    private int count;
    private List<Integer> wordFrequencyList = new ArrayList<>();

    @Override
    public void textAnalysis(String context) {
        int contextWordLength = context.split(" ").length;
        String[] contextWordArray = context.split(" ");
        int[] isContextWordArray = new int[contextWordLength];
        for(int ok : isContextWordArray) {
            ok = 0;
        }

        Map<String, Integer> contextMap = new HashMap<>();
        for(String word : contextWordArray) {
            contextMap.put(word, contextMap.getOrDefault())
        }

        for(int i = 0; i < contextWordLength; i++) {
            count = 1;
            for(int j = i + 1; j < contextWordLength; j++) {
                if(contextWordArray[i].equals(contextWordArray[j])) {
                    isContextWordArray[j] = 1;
                    count += isContextWordArray[j];
                }
            }
        }
        System.out.println(count);
    }
}
