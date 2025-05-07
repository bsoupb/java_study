package day5.텍스트분석시스템;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

// 감정분석(긍정/부정)
@AllArgsConstructor
public class SentimentAnalysis implements TextAnalysisStrategy {

    private Map<String, String> positiveWords = new HashMap<>();
    private Map<String, String> negativeWords = new HashMap<>();

    // 긍정적인 단어 배열
    private String[] positiveWordArray = {
            "성실", "긍정", "열정", "배려심",
            "친절", "책임감", "끈기", "행복",
            "용기", "감사", "희망"
    };

    // 부정적인 단어 배열
    private String[] negativeWordArray = {
            "불성실", "이기적", "무책임", "무례",
            "포기", "불안", "절망", "우울",
            "부정"
    };

    // 긍정인 경우와 부정인 경우 각 단어에 대한 Map 생성
    public SentimentAnalysis() {
        for(String positive : positiveWordArray) {
            positiveWords.put(positive, "positive");
        }

        for(String negative : negativeWordArray) {
            negativeWords.put(negative, "negative");
        }
    }

    // 감정분석 계산
    /*
        @param sentiment            감정분석 결과
        @param sentimentProp        감정분석에 대한 확률 
        @param posCount             context 에서 pos 라는 단어에 대한 갯수
        @param negCount             context 에서 neg 라는 단어에 대한 갯수
        @param contextWordLength    context 문단에 포함된 단어 갯수
        @param positiveProp         pos 에 대한 확률
        @param negativeProp         neg 에 대한 확률
        @param totalPositiveProp    positive 단어가 포함된 확률
        @param totalNegativeProp    negative 단어가 포함된 확률
        
     */
    @Override
    public void textAnalysis(String context) {
        String sentiment;
        double sentimentProp;
        int posCount = 0;
        int negCount = 0;
        int contextWordLength = context.split(" ").length;

        double positiveProp = 0.0;
        double negativeProp = 0.0;

        double totalPositiveProp = 0.0;
        double totalNegativeProp = 0.0;

        // positive 단어에 대한 긍정 확률
        Set<String> positive = positiveWords.keySet();
        for(String pos : positive) {
            if(context.contains(pos)) {
                posCount++;
                positiveProp = posCount * (1.0 / contextWordLength);
                totalPositiveProp += positiveProp;
            }
        }

        // negative 단어에 대한 부정 확률
        Set<String> negative = negativeWords.keySet();
        for(String neg : negative) {
            if(context.contains(neg)) {
                negCount++;
                negativeProp = negCount * (1.0 / contextWordLength);
                totalNegativeProp += negativeProp;
            }
        }

        // 전체 확률에 대한 각 범위에 따른 감정분석 결과
        sentimentProp = totalPositiveProp - totalNegativeProp;

        if (sentimentProp >= -1.0 && sentimentProp < -0.5) {
            sentiment = "BAD";
        } else if (sentimentProp >= -0.5 && sentimentProp < 0.5) {
            sentiment = "SOSO";
        } else if (sentimentProp >= 0.5 && sentimentProp <= 1.0) {
            sentiment = "GOOD";
        } else {
            throw new IllegalArgumentException("unsupported sentiment type");
        }

        System.out.println(sentiment);
        System.out.println(sentimentProp);
    }
}

/*
    질문
    부정일 확률을 계산할 때 긍정에 있는 단어도 같이 count 해서 긍정일 확률이 나옴
    ex) 성실 vs 불성실
 */