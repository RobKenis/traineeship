# Build something

Here's something to integrate the services you've learnt about. _This might have been genrated by ChatGPT_.

### **Exercise Overview: "File Processing and Notification System"**

#### **Objective**
Build a system where files uploaded to an S3 bucket trigger a series of AWS services to:
1. Process the file using a Lambda function.
2. Store metadata in DynamoDB.
3. Send notifications via SNS.
4. Use SQS for error handling.

#### **Key Services and Roles**
- **S3**: Store the uploaded files.
- **Lambda**: Triggered by file uploads to process files and extract metadata.
- **DynamoDB**: Store metadata about the files (file name, size, upload timestamp).
- **SNS**: Send notifications about file processing results (success/failure).
- **SQS**: Collect and handle error messages if file processing fails.
- **ECS**: Run a simple web application that allows users to upload files and view processed results from DynamoDB.

### **Step-by-Step Breakdown**

#### **1. S3 Setup**
- Create an S3 bucket where users can upload files.
- Ensure the bucket has a proper policy to allow Lambda and other services to access it.
- <https://docs.aws.amazon.com/lambda/latest/dg/with-s3-example.html>

#### **2. Lambda Setup**
- Create a Lambda function that is triggered by S3 events (i.e., when a file is uploaded).
- The Lambda function should:
  1. Extract metadata from the file (e.g., file name, size, upload timestamp). [S3 GetObject Documentation](https://docs.aws.amazon.com/AmazonS3/latest/API/API_GetObject.html)
  2. Store this metadata in a DynamoDB table.
  3. Publish a notification to an SNS topic (on success or failure).
  4. Send error messages to an SQS queue if there’s an issue processing the file.
  
**Lambda Function Sample Workflow:**
```python
def lambda_handler(event, context):
    # Extract file info from the S3 event
    s3_bucket = event['Records'][0]['s3']['bucket']['name']
    file_key = event['Records'][0]['s3']['object']['key']
    
    try:
        # Get file metadata
        file_size = get_s3_file_size(s3_bucket, file_key)
        
        # Store metadata in DynamoDB
        dynamodb.put_item(TableName="FileMetadata", Item={
            'FileName': {'S': file_key},
            'FileSize': {'N': str(file_size)},
            'UploadTime': {'S': current_time()}})

        # Send success notification to SNS
        sns.publish(TopicArn='SNS_TOPIC_ARN', 
                    Message=f"File {file_key} processed successfully!")
    
    except Exception as e:
        # Send error message to SQS
        sqs.send_message(QueueUrl='SQS_QUEUE_URL', 
                         MessageBody=f"Error processing file {file_key}: {str(e)}")
        raise e
```

#### **3. DynamoDB Setup**
- Create a DynamoDB table (e.g., `FileMetadata`) with the following attributes:
  - `FileName` (Partition Key)
  - `FileSize`
  - `UploadTime`

#### **4. SNS Setup**
- Create an SNS topic for notifications about file processing.
- Subscribe to the SNS topic using email, so users can see notifications in real time.
- The Lambda function will publish a success or failure notification after processing.

#### **5. SQS Setup**
- Create an SQS queue to collect error messages from the Lambda function if file processing fails.
- Users can periodically check the queue for any error messages and understand how the system handles failures.

#### **6. ECS Setup (Optional if Time Allows)**
- Deploy a simple web application on ECS that provides:
  - A UI for users to upload files to the S3 bucket.
  - A list of processed files and their metadata fetched from DynamoDB.
  
The web application could be a simple Node.js or Python Flask application that interacts with S3 for uploads and DynamoDB to display results.

### **Task Breakdown for Participants**

- **Setup S3 Bucket**: 
   - Create an S3 bucket.
   - Define permissions for Lambda to access it.

- **Create Lambda Function**:
   - Write and deploy a Lambda function.
   - Configure the S3 trigger to invoke the Lambda function when a file is uploaded.

- **Set Up DynamoDB Table**:
   - Create a DynamoDB table for storing file metadata.

- **Configure SNS**:
   - Set up an SNS topic and subscribe an email or SMS endpoint to receive notifications.
   - Update the Lambda function to send notifications.

- **Create SQS Queue**:
   - Set up an SQS queue to handle errors from Lambda.

- **Deploy Web Application on ECS** (Optional):
   - Deploy a simple web app for file uploads and view the processed file metadata.

### **Stretch Goals (Optional)**
- Implement file versioning in the S3 bucket.
- Use CloudWatch to monitor the Lambda function and set up alarms for failed invocations.
- Add a retry mechanism using SQS Dead-Letter Queue (DLQ).

### **Expected Outcome**
By the end of the exercise, users will have a working system where:
- Files uploaded to S3 trigger a Lambda function.
- Metadata is stored in DynamoDB.
- Success or failure notifications are sent via SNS.
- Errors are handled via SQS.
- (Optional) A simple web interface on ECS allows file uploads and metadata viewing.