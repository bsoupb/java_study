package day2.자습.팩토리.팩토리메서드;

public class WordDocumentFactory extends DocumentFactory{



    @Override
    public Document createDocument() {
        return new WordDocument("app.word", DocumentStatus.NEW);
    }
}
