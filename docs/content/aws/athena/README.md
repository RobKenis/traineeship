# Amazon Athena

Amazon [Athena](https://aws.amazon.com/athena/) is an interactive query service that makes it easy to analyze data in
Amazon S3 using standard SQL. Athena is serverless, so there is no infrastructure to manage, and you pay only for the
queries that you run.

```sql
CREATE EXTERNAL TABLE IF NOT EXISTS simple (
  firstname STRING,
  lastname STRING,
  age STRING
  ) 
  ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
  LOCATION 's3://rob-s3-bucket-bb76uctj0d3s/simple/'
  TBLPROPERTIES ("skip.header.line.count"="1");
```