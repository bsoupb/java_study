package day5.텍스트분석시스템;

/*
    텍스트 분석 시스템

    [필수구현요소]
    - TextAnalysisStrategy 인터페이스: 텍스트 분석 방법 정의
    - WordFrequencyAnalysis: 단어 빈도 분석
    - SentimentAnalysis: 감정분석 (긍정/부정)
    - KeywordExtractionAnalysis: 핵심 키워드 추출
    - TextAnalyzer 컨텍스트 클래스: 분석 전략을 사용하여 텍스트 처리

    [선택구현요소]
    - LanguageDetectionAnalysis: 추가 전략 클래스
    - 분석 결과의 시각화
    - 실제 자연어처리 라이브러리 활용
 */

public class TextAnalysisDemo {
    public static void main(String[] args) {
        // 감정분석
        TextAnalysisStrategy sentimentAnalysis = new SentimentAnalysis();   // 긍정 + 부정
        TextAnalysisStrategy sentimentAnalysisNegative = new SentimentAnalysis();   // 부정
        TextAnalysisStrategy sentimentAnalysisPositive = new SentimentAnalysis();   // 긍정

        sentimentAnalysis.textAnalysis(
                "그는 평소 성실하고 책임감 있는 모습으로 많은 사람들에게 신뢰를 주었다." +
                " 프로젝트에 임할 때는 늘 열정을 보이며, 동료들을 배려심 있게 대하는 태도 덕분에 팀 분위기도 좋았다. " +
                "하지만 최근 들어 그는 반복적인 실수와 무책임한 행동으로 주변의 우려를 샀다. " +
                "회의 중에는 무례하게 말을 끊거나, 모두가 집중하고 있을 때도 이기적으로 자신의 주장만을 고집하기도 했다. " +
                "그럼에도 불구하고 그는 어려움 속에서도 다시 일어날 수 있는 용기를 보여주었고, 작은 성공에도 감사하는 태도를 잃지 않았다. " +
                "비록 한때 불안과 우울에 휩싸였지만, 끝내 희망을 잃지 않고 조금씩 변화를 만들어 가고 있다. " +
                "그의 긍정적인 변화는 모두에게 행복과 기대를 안겨주고 있다.");

        sentimentAnalysisNegative.textAnalysis(
                "그는 반복적으로 지각하고 중요한 보고서도 제출하지 않는 등 매우 불성실한 태도를 보였다. " +
                        "팀 프로젝트에서도 협력보다는 자신의 이익만을 생각하는 이기적인 행동이 잦았고, " +
                        "맡은 역할조차 제대로 수행하지 못하는 무책임함으로 갈등을 유발했다. " +
                        "회의 중에도 상사나 동료에게 무례한 언행을 서슴지 않았으며, 일정이 조금만 밀려도 쉽게 포기해버리곤 했다. " +
                        "발표를 앞두고는 극도로 불안해하며 준비에 집중하지 못했고, 결국 성과가 좋지 않자 깊은 절망에 빠져버렸다. " +
                        "최근에는 표정도 어둡고 말수가 줄어들며 전반적으로 우울한 기운이 감돌았다. " +
                        "게다가 팀의 사기를 높여야 할 자리에서도 계속해서 부정적인 말만 하며 분위기를 가라앉혔다."
        );

        sentimentAnalysisPositive.textAnalysis(
                "그는 항상 성실하게 자신의 업무를 수행하며, 어려운 상황에서도 긍정적인 태도를 잃지 않았다. " +
                        "프로젝트 초반부터 강한 열정을 보였고, 동료들에게 배려심 있게 다가가 협업 분위기를 조성했다. " +
                        "고객을 대할 때에도 언제나 친절한 미소를 잊지 않았고, 맡은 일에 대한 책임감이 누구보다 강해 팀 내에서 신뢰를 받고 있다. " +
                        "예기치 못한 문제에도 그는 끈기 있게 해결 방안을 찾아냈으며, 작은 성과에도 행복을 느끼며 기뻐했다. " +
                        "실패 앞에서도 용기를 잃지 않고 다시 도전했으며, 주변 사람들에게도 늘 감사하는 마음을 표현했다. " +
                        "이런 태도 덕분에 모두가 함께 희망을 갖고 앞으로 나아갈 수 있었다."
        );

        TextAnalysisStrategy wordFrequencyAnalysis = new WordFrequencyAnalysis();
        wordFrequencyAnalysis.textAnalysis(
                "성실한 태도는 모든 일의 기본이다. 그는 매일 아침 성실하게 출근하고, 성실하게 업무를 수행한다. 성실함은 신뢰를 만든다. 긍정적인 태도 또한 중요하다. 긍정은 어려운 상황에서도 용기를 준다. 팀원들과의 협업에서도 긍정적인 말 한마디가 분위기를 바꾼다. 책임감 있는 행동은 조직의 성장을 이끈다. 책임감은 결과에 대한 집중을 높이고, 신뢰를 쌓는다."
        );
    }
}
