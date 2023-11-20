# AWS Glue

AWS [Glue](https://aws.amazon.com/glue/) is a fully managed extract, transform, and load (ETL) service that makes it
easy for customers to prepare and load their data for analytics. You can create and run an ETL job with a few clicks in
the AWS Management Console. You simply point AWS Glue to your data stored on AWS, and AWS Glue discovers your data and
stores the associated metadata (e.g. table definition and schema) in the AWS Glue Data Catalog. Once cataloged, your
data is immediately searchable, queryable, and available for ETL. AWS Glue generates the code to execute your data
transformations and data loading processes. AWS Glue generates Python code that is entirely customizable, reusable, and
portable. Once your ETL job is ready, you can schedule it to run on AWS Glue's fully managed, scale-out Apache Spark
environment.

[https://aws.amazon.com/glue/getting-started/](https://aws.amazon.com/glue/getting-started/)

You can use the [us-500.csv](us-500.csv) dataset to create a table in the AWS Glue Data Catalog. Add the file under
a separate key in the S3 bucket, e.g. `glue/us-500.csv`.

## Create a Crawler

[Glue Console](https://eu-west-1.console.aws.amazon.com/glue/home?region=eu-west-1#/v2/data-catalog/crawlers)

## Query the data

After the crawler has finished, you can query the data in the Athena console.

```sql
SELECT * FROM rob."us-500" LIMIT 10;
```