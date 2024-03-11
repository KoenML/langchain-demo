package be.kuun.documentService;

import dev.langchain4j.data.document.Document;

public interface DocumentService {
    Document getDocument(String path);
}
