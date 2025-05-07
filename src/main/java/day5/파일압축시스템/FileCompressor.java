package day5.파일압축시스템;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class FileCompressor {
    private CompressionStrategy compressionStrategy;

    public void setCompressionStrategy(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }
    
    // 핵심 부분
    public void compressFiles(List<File> files, String destination) {
        compressionStrategy.compressFiles(files, destination);
    }
}
