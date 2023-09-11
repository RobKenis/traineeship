# Build something

First of all, make sure your project is deployed to ECS and exposed through a load balancer with a custom DNS record.

## Extra

### Backend

Create a Java application with following endpoints:

- GET `/images` - returns a list of all image urls
    - Either store the URL in DynamoDB or use the S3 SDK to list all objects in the bucket
- POST `/images` - uploads an image to S3 and returns its url

??? info "Use the S3 SDK to upload a file to S3"
    https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-s3.html

Deploy the backend using AWS ECS and expose it through a load balancer with a custom DNS record.

### Frontend

Create a UI in your favorite webframework that uses the endpoints above to display the images and upload new ones.
Upload the UI to S3 and make it available through a CloudFront distribution.

### Lambda

Create a Lambda function that is triggered by a new image in the S3 bucket and sends a notification to a Slack channel.