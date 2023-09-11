package dev.robkenis.axxes.todo.repository;

import dev.robkenis.axxes.todo.model.Todo;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;

public class DynamodbRepository implements TodoRepository {

    private final DynamoDbClient dynamoDbClient;

    public DynamodbRepository() {
        this.dynamoDbClient = DynamoDbClient.builder().region(Region.EU_WEST_1).build();
    }

    @Override
    public List<Todo> getAll() {
        // TODO: Retrieve all TODOs from DynamoDB (using Scan operation)
        return null;
    }

    @Override
    public void create(Todo todo) {
        // TODO: Save item in DynamoDB (using PutItem operation)
    }
}
