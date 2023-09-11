# Messaging

We are going to talk about 2 important services regarding messaging in AWS: queues and topics.

## Amazon Simple Queue Service (SQS)

[Amazon Simple Queue Service (SQS)](https://aws.amazon.com/sqs/) is a fully managed message queuing service. Messages
are put on the queue using the `sqs:SendMessage` action. Messages are retrieved from the queue using
the `sqs:ReceiveMessage`. After the client has processed the message, it is responsible for deleting it from the queue.
SQS guarantees that messages will be processed at least once. If a message is not deleted from the queue, it will be
re-delivered after a certain period of time.

??? example "Now build it"
    Create an SQS queue using [CloudFormation](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-sqs-queue.html).
    None of the properties are mandatory, but you should at least set the `QueueName` property. In your Java application,
    use the AWS SDK for publishing and retrieving messages from your queue.

## Amazon Simple Notification Service (SNS)

[Amazon Simple Notification Service (SNS)](https://aws.amazon.com/sns/) is a fully managed pub/sub messaging service.
Messages are published to topics using the `sns:Publish` action. Subscribers can subscribe to topics and receive
notifications using the `sns:Subscribe` action. SNS supports several different protocols for delivering notifications,
including HTTP, HTTPS, Email, Email-JSON, Amazon SQS, Application, Lambda, and SMS messages.

??? example "Now build it"
    Create an SNS topic using [CloudFormation](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-sns-topic.html)
    or manually. Subscribe your queue to the topic. Change your Java code, so it publishes messages to the topic instead
    of the queue. You should now see the messages appear in your queue.