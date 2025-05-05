package day2.자습.팩토리.팩토리메서드;

public class PdfDocument implements Document {

    private final String filePath;
    private final DocumentStatus status;

    public PdfDocument(String filePath, DocumentStatus status) {
        this.filePath = filePath;
        this.status = status;
    }

    @Override
    public void print() {
        System.out.println("pdf file");
    }

    @Override
    public DocumentStatus getDocumentStatus() {
        return status;
    }
}
