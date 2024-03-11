package be.kuun.documentService.impl;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import be.kuun.documentService.DocumentService;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;

public class PdfDocumentService implements DocumentService{

    @Override
    public Document getDocument(String path) {
        Path filePath = toPath(path);
        return FileSystemDocumentLoader.loadDocument(filePath, new ApachePdfBoxDocumentParser());
    }

    private Path toPath(String fileName) {
        try {
            URL fileUrl = PdfDocumentService.class.getResource(fileName);
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}

