package dev.robkenis.axxes.todo.repository;

import dev.robkenis.axxes.todo.model.Todo;
import jakarta.enterprise.context.ApplicationScoped;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// @ApplicationScoped
public class DynamodbRepository implements TodoRepository {

    private final DynamoDbClient dynamoDbClient;

    public DynamodbRepository() {
        this.dynamoDbClient = DynamoDbClient.builder().region(Region.EU_WEST_1).build();
    }

    @Override
    public List<Todo> getAll() {
        ScanResponse response = dynamoDbClient.scan(ScanRequest.builder().tableName("robs-table").build());
        return response.items()
                .stream()
                .map(item -> new Todo(item.get("title").s()))
                .collect(Collectors.toList());
    }

    @Override
    public void create(Todo todo) {
        dynamoDbClient.putItem(PutItemRequest.builder().tableName("robs-table").item(Map.of("title", AttributeValue.fromS(todo.title()))).build());
    }
}
