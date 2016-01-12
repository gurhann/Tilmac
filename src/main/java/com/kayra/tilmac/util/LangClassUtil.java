package com.kayra.tilmac.util;

import com.kayra.tilmac.enums.Languages;
import com.kayra.tilmac.model.EngWord;
import com.kayra.tilmac.model.TrWord;
import com.kayra.tilmac.model.Word;

public class LangClassUtil {
 public static Languages getLangClass(Class<? extends Word> class1) {
	 
	 if (class1.equals(EngWord.class)) {
		 return Languages.ENG;
	 } else if(class1.equals(TrWord.class)) {
		 return Languages.TR;
	 } else {
		 
	 }
	 return null;
 }


}
