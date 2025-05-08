package day5.텍스트분석시스템;

import java.util.*;

public class WordFrequencyAnalysis implements TextAnalysisStrategy {

//    private int count;
//    private List<Integer> wordFrequencyList = new ArrayList<>();

    @Override
    public void textAnalysis(String context) {
        
        // 조사 리스트
        Set<String> engStopwords = Set.of(
                "a", "an", "the", "in", "on", "at", "to", "by", "for", "with", "of", "and", "but", "or",
                "so", "because", "if", "although", "I", "you", "he", "she", "it", "we", "they",
                "is", "are", "was", "were", "be", "have", "has", "had", "do", "does", "did", "can", "will", "just"
        );

        Set<String> korStopwords = Set.of("은", "는", "이", "가", "을", "를", "에", "에서", "도", "만", "으로", "까지", "부터");


        // 문단 -> 공백 기준으로 자른 단어 배열
        String[] contextWordArray = context.split(" ");

        String [] noStopWord = Arrays.stream(contextWordArray)
                .filter(contextWord -> !engStopwords.contains(contextWord.toLowerCase()))
                .map(contextWord -> {
                    for(String josa : korStopwords) {
                        if(contextWord.endsWith(josa)) {
                            contextWord = contextWord.substring(0, contextWord.length() - josa.length());
                        }
                    }
                    return contextWord;
                })
                .toArray(String[]::new);

        // 단어, 단어 빈도 수 map으로 표현
        Map<String, Integer> contextMap = new HashMap<>();
        for(String word : noStopWord) {
            contextMap.put(word, contextMap.getOrDefault(word, 0) + 1);
        }

        // 빈도 분석
        int max = Integer.MIN_VALUE;
        String maxWord = null;
        for(Map.Entry<String, Integer> entry : contextMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(value > max) {
                max = value;
                maxWord = key;
            }
        }
        System.out.println(maxWord);

        /*
            처음 시도: for문으로 단어와 연결지은 int 배열로 빈도 수 구하려고 했음


        int contextWordLength = context.split(" ").length;

        int[] isContextWordArray = new int[contextWordLength];
        for(int ok : isContextWordArray) {
            ok = 0;
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

         */
    }
}
