package dev.robkenis.axxes.todo.service;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

// @ApplicationScoped
public class QueueConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueConsumer.class);

    private final String QUEUE_URL = "https://sqs.eu-west-1.amazonaws.com/167698347898/robs-queue";

    private final SqsClient sqsClient;

    public QueueConsumer() {
        this.sqsClient = SqsClient.builder().region(Region.EU_WEST_1).build();
    }

    // @Scheduled(every = "10s")
    public void consume() {
        ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(builder -> builder.queueUrl(QUEUE_URL));
        receiveMessageResponse.messages().forEach(message -> {
            LOGGER.info("Received message: {}", message.body());
            sqsClient.deleteMessage(builder -> builder.queueUrl(QUEUE_URL).receiptHandle(message.receiptHandle()));
        });
    }

}
