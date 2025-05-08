package day5.텍스트분석시스템;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 핵심 키워드 추출
// -> 빈도수가 가장 높은 단어 추출
public class KeywordExtractionAnalysis implements TextAnalysisStrategy {

    private String keyword;

    @Override
    public void textAnalysis(String context) {
        // 조사 리스트
        Set<String> engStopwords = Set.of(
                "a", "an", "the", "in", "on", "at", "to", "by", "for", "with", "of", "and", "but", "or",
                "so", "because", "if", "although", "I", "you", "he", "she", "it", "we", "they",
                "is", "are", "was", "were", "be", "have", "has", "had", "do", "does", "did", "can", "will", "just"
        );

        Set<String> korStopwords = Set.of("은", "는", "이", "가", "을", "를", "에", "에서", "도", "만", "으로", "까지", "부터");

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

        Map<String, Integer> contextMap = new HashMap<>();
        for(String word : noStopWord) {
            contextMap.put(word, contextMap.getOrDefault(word, 0) + 1);
        }


        int max = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : contextMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(value > max) {
                max = value;
                keyword = key;
            }
        }
        System.out.println(keyword);
    }
}
