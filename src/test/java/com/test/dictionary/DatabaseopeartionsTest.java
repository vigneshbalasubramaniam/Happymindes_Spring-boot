package com.test.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.dictionary.DatabaseOperations;
public class DatabaseopeartionsTest {

	@Test
	public void dictionarySearchTest() {
		
		assertEquals(0, DatabaseOperations.searchItems("sentence"),"found in the dictionary");
		assertEquals(0, DatabaseOperations.createItems("test sentence"),"uploaded successfully");
	}
}