package day5.텍스트분석시스템;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TextAnalysisProcessor {
    private TextAnalysisStrategy textAnalysisStrategy;

    public void setTextAnalysisStrategy(TextAnalysisStrategy textAnalysisStrategy) {
        this.textAnalysisStrategy = textAnalysisStrategy;
    }

    public void textAnalysis(String context) {
        textAnalysisStrategy.textAnalysis(context);
    }
}
