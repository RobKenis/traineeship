# Build something

## Input

An SQS queue is available with shop events. Each event is a JSON object with the following structure:

```json
{
  "timestamp": "2023-01-01T16:00:00Z",
  "items": [
    {
      "name": "Cheese",
      "price": 1.99
    },
    {
      "name": "Milk",
      "price": 0.99
    },
    {
      "name": "Bread",
      "price": 2.99
    }
  ]
}
```

The items represent a shopping cart that is checked out at Colruyt.

## Things to do

- Build and deploy an application that consumes the items from SQS and stores them in S3.
- Create a Glue Crawler that crawls the data in S3 and creates a table in the Glue Data Catalog.
- Create a query in Athena to find the most bought item