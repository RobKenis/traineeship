package dev.robkenis.axxes.todo.service;

import dev.robkenis.axxes.todo.model.Todo;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@ApplicationScoped
public class TodoCreatedListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoCreatedListener.class);

    private final SqsClient sqsClient;

    public TodoCreatedListener() {
        this.sqsClient = SqsClient.builder().region(Region.EU_WEST_1).build();
    }

    public void sendMessage(Todo todo) {
        LOGGER.info("Created: {}", todo);
        // TODO: Send message to SQS queue
    }

}
