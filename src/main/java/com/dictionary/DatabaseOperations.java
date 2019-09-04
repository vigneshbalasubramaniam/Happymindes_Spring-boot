package com.dictionary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DatabaseOperations {
	
	static BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAYAGFXRY5HWNJ5BO4", "VzUiJojcPiDJamsSRs/d9k6+CkjJXiaAd/+aMNpR");
    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    static DynamoDB dynamoDB = new DynamoDB(client);

    static String tableName = "Dictionary";
    
    public static String createItems(String Sentence) {

        Table table = dynamoDB.getTable(tableName);
		try {
			String[] word_split = Sentence.trim().split(" ");
			Item retriveItem = null;
			Item insertItem = null;
			for(int i=0;i<word_split.length && (word_split[i]!= null && !word_split[i].isEmpty());i++) {
				retriveItem = table.getItem("words", word_split[i].toLowerCase());
				if (null == retriveItem) {
					insertItem = new Item().withString("words", word_split[i].toLowerCase());
					table.putItem(insertItem);
				}
			}
		}
        catch (Exception e) {
            System.err.println("Create and list items failed.");
            System.err.println(e.getMessage());

        }
		return "uploaded successfully";
    }
    
	public static String searchItems(String searchWord) {
		Table table = dynamoDB.getTable(tableName);
		try {
			Item retriveItem = table.getItem("words", searchWord);
			if (null == retriveItem)
				return "not found in the dictionary";
		} catch (Exception e) {
			System.err.println("Create and list items failed.");
			System.err.println(e.getMessage());
		}
		return "found in the dictionary";
	}
}

