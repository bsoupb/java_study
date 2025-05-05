package day2.자습.팩토리.팩토리메서드;

public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument("app.pdf", DocumentStatus.SAVE);
    }
}
