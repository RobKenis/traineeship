## Infrastructure as Code

[CloudFormation](https://aws.amazon.com/cloudformation/) is the AWS solution to do infrastructure as code. Instead of
manually configuring resources, you can define these in YAML or JSON format and apply these configurations in the
CloudFormation console.

<details>
  <summary>Template for an EC2 instance</summary>

  ```yaml
  --8<-- "docs/content/aws/cloudformation/ec2.yaml"
  ```
</details>