package com.kayra.tilmac.docread;

import java.util.List;

import com.kayra.tilmac.model.Word;

public interface DocumentReader {
	List<Word> extractFromDoc();
}
