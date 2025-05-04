package day2.예제3;

public class DocumentService {
    public byte[] convertDocument(byte[] input, DocumentType sourceType, DocumentType targetType) {
        // sourceType: 기존타입 targetType: 변환타입
        ConverterFactory converterFactory = getConverterFactory(sourceType, targetType);
        return converterFactory.convertDocument(input);
    }

    private ConverterFactory getConverterFactory(DocumentType sourceType, DocumentType targetType) {
        if (sourceType == DocumentType.PDF && targetType == DocumentType.WORD) {
            return new PdfToWordConverterFactory();
        } else if (sourceType == DocumentType.WORD && targetType == DocumentType.PDF) {
            return new WordToPdfConverterFactory();
        }
        throw new IllegalArgumentException("unsupported conversion type");
    }
}
