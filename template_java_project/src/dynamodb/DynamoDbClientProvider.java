package dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDbClientProvider {
    public static AmazonDynamoDB REMOTE_CLIENT = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-2").build();
}
