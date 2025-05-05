package day2.자습.팩토리.팩토리메서드;

public abstract class DocumentFactory {
    public abstract Document createDocument();

    public static DocumentFactory getFactory(DocumentType type) {
        return switch (type) {
            case WORD -> new WordDocumentFactory();
            case PDF -> new PdfDocumentFactory();
            default -> throw new IllegalArgumentException("Unsupported document type");
        };
    }
}
