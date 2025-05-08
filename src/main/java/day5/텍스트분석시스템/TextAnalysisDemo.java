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

        // 긍정 + 부정
        sentimentAnalysis.textAnalysis(
                "그는 평소 성실하고 책임감 있는 모습으로 많은 사람들에게 신뢰를 주었다." +
                " 프로젝트에 임할 때는 늘 열정을 보이며, 동료들을 배려심 있게 대하는 태도 덕분에 팀 분위기도 좋았다. " +
                "하지만 최근 들어 그는 반복적인 실수와 무책임한 행동으로 주변의 우려를 샀다. " +
                "회의 중에는 무례하게 말을 끊거나, 모두가 집중하고 있을 때도 이기적으로 자신의 주장만을 고집하기도 했다. " +
                "그럼에도 불구하고 그는 어려움 속에서도 다시 일어날 수 있는 용기를 보여주었고, 작은 성공에도 감사하는 태도를 잃지 않았다. " +
                "비록 한때 불안과 우울에 휩싸였지만, 끝내 희망을 잃지 않고 조금씩 변화를 만들어 가고 있다. " +
                "그의 긍정적인 변화는 모두에게 행복과 기대를 안겨주고 있다.");

        // 부정
        sentimentAnalysisNegative.textAnalysis(
                "그는 반복적으로 지각하고 중요한 보고서도 제출하지 않는 등 매우 불성실한 태도를 보였다. " +
                        "팀 프로젝트에서도 협력보다는 자신의 이익만을 생각하는 이기적인 행동이 잦았고, " +
                        "맡은 역할조차 제대로 수행하지 못하는 무책임함으로 갈등을 유발했다. " +
                        "회의 중에도 상사나 동료에게 무례한 언행을 서슴지 않았으며, 일정이 조금만 밀려도 쉽게 포기해버리곤 했다. " +
                        "발표를 앞두고는 극도로 불안해하며 준비에 집중하지 못했고, 결국 성과가 좋지 않자 깊은 절망에 빠져버렸다. " +
                        "최근에는 표정도 어둡고 말수가 줄어들며 전반적으로 우울한 기운이 감돌았다. " +
                        "게다가 팀의 사기를 높여야 할 자리에서도 계속해서 부정적인 말만 하며 분위기를 가라앉혔다."
        );

        // 긍정
        sentimentAnalysisPositive.textAnalysis(
                "그는 항상 성실하게 자신의 업무를 수행하며, 어려운 상황에서도 긍정적인 태도를 잃지 않았다. " +
                        "프로젝트 초반부터 강한 열정을 보였고, 동료들에게 배려심 있게 다가가 협업 분위기를 조성했다. " +
                        "고객을 대할 때에도 언제나 친절한 미소를 잊지 않았고, 맡은 일에 대한 책임감이 누구보다 강해 팀 내에서 신뢰를 받고 있다. " +
                        "예기치 못한 문제에도 그는 끈기 있게 해결 방안을 찾아냈으며, 작은 성과에도 행복을 느끼며 기뻐했다. " +
                        "실패 앞에서도 용기를 잃지 않고 다시 도전했으며, 주변 사람들에게도 늘 감사하는 마음을 표현했다. " +
                        "이런 태도 덕분에 모두가 함께 희망을 갖고 앞으로 나아갈 수 있었다."
        );

        // 단어 빈도 분석 kor.ver
        TextAnalysisStrategy wordFrequencyAnalysis1 = new WordFrequencyAnalysis();
        wordFrequencyAnalysis1.textAnalysis(
                "오늘은 평소보다 날씨가 더 맑고 산뜻했다. " +
                        "산책을 하며 자연을 바라보는 시간이 정말 소중하게 느껴졌다. " +
                        "바람은 가볍게 불고, 햇살은 따뜻했다. 마음이 한결 편안해지고, 생각도 맑아졌다. " +
                        "이런 순간들이 소중하다는 걸 다시 느꼈다. 산책을 통해 얻는 평온함은 하루의 기분을 결정짓기도 한다. " +
                        "그래서 나는 자주 산책을 하며 편안한 시간을 보내려 한다."
        );

        // 단어 빈도 분석 eng.ver
        TextAnalysisStrategy wordFrequencyAnalysis2 = new WordFrequencyAnalysis();
        wordFrequencyAnalysis2.textAnalysis(
                "Success is not just about hard work. " +
                        "Success comes from dedication, persistence, and a clear goal. " +
                        "People who pursue success with passion and focus are more likely to achieve it. " +
                        "Success does not come overnight, but with consistent effort. " +
                        "Hard work, dedication, and focus — these are the keys to real success. " +
                        "Everyone wants success, but few are willing to work for it."
        );

        // 키워드 추출 분석 kor.ver
        TextAnalysisStrategy keywordExtractionAnalysis1 = new KeywordExtractionAnalysis();
        keywordExtractionAnalysis1.textAnalysis(
                "최근 인공지능 기술이 빠르게 발전하면서 다양한 산업 분야에서 혁신이 이루어지고 있다. " +
                        "특히 생성형 인공지능은 텍스트 생성, 이미지 생성, 자연어 처리 등의 영역에서 큰 주목을 받고 있다. " +
                        "인공지능 기반 챗봇은 고객 상담 자동화에 활용되며, 효율적인 고객 경험을 제공한다. " +
                        "또한 인공지능 기술은 의료, 금융, 교육 등에서 데이터 분석과 예측 모델에 활용되어 의사결정의 정확성을 높이고 있다. " +
                        "이러한 변화는 인공지능 알고리즘과 데이터 처리 능력의 향상 덕분에 가능해졌다."
        );

        // 키워드 추출 분석 eng.ver
        TextAnalysisStrategy keywordExtractionAnalysis2 = new KeywordExtractionAnalysis();
        keywordExtractionAnalysis2.textAnalysis(
                "In the modern digital world, technology plays a crucial role in communication, education, and business. " +
                        "The rapid advancement of technology has transformed the way people interact, learn, and work. " +
                        "Mobile devices, cloud computing, and artificial intelligence are just a few examples of how technology shapes our daily lives. " +
                        "Understanding the impact of technology on society is essential for growth, innovation, and future development."
        );




    }
}
