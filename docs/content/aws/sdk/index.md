# AWS SDK

## Permission Management

[AWS IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) is used to manage permissions for AWS
resources.

### IAM Users

They are created and managed in the [AWS IAM Console](https://console.aws.amazon.com/iam/home) and can be used to
execute actions on AWS resources. A long-living set of credentials is often created to gain access to the user.

### IAM Roles

IAM Roles can be assumed by resources and services on AWS. They do not use long-living credentials, but instead use
short-living tokens.

### IAM Policies

An IAM Policy describes which actions a User or a Role is allowed to execute. It contains a list of statements, a
statement has 3 important parts:

- **Effect**: Allow or Deny
- **Action**: The action that is to be executed
- **Resource**: The resource on which the action is to be executed

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "QueryDynamoDB",
      "Effect": "Allow",
      "Action": [
        "dynamodb:Query",
        "dynamodb:Scan",
        "dynamodb:GetItem"
      ],
      "Resource": "*"
    }
  ]
}
```

Only actions that match the 3 criteria are allowed to be executed.

## Java SDK

The Java SDK is used to interact with AWS services from Java code. It is available on Maven Central and can be added to
a project using the following dependency (each service requires a separate dependency):

```xml

<dependency>
    <groupId>software.amazon.awssdk</groupId>
    <artifactId>dynamodb</artifactId>
    <version>2.15.0</version>
</dependency>
```

### Credentials

The SDK uses
the [Default Credential Provider Chain](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html).
This means that the SDK will try to find credentials in the following order: first look for environment variables,
then look for a profile in the `~/.aws/credentials` file, then look for an IAM role on the EC2 instance. This means
you don't need to provide credentials in your code, but instead can use the default credential provider chain.

```java
DynamoDbClient dynamoDbClient=DynamoDbClient.builder()
        .region(Region.EU_CENTRAL_1)
        .build();
```

## Python SDK

The Python SDK is used to interact with AWS services from Python code. It is available on PyPi and can be added to a
project using the following dependency:

```bash
pip install boto3
```

### S3

Following [documentation](https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/s3.html) describes
how to use the Python SDK to interact with S3.

```python
import boto3

client = boto3.client('s3')

# List all buckets
response = client.list_buckets()
```