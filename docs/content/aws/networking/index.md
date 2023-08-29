# Networking on AWS

All virtual machines run in a virtual private cloud (VPC). The VPC is a virtual network that is logically isolated from
other virtual networks in the cloud. The VPC is a private network that is not accessible from the internet.

## VPC

```yaml
--8<-- "docs/content/aws/networking/vpc.yaml"
```

When EC2 instances or for example [RDS](https://aws.amazon.com/rds/) instances are launched within a VPC, they get
assigned an IP address on which they're reachable within the VPC. This IP address is not reachable from the internet.

## Internet Connectivity

To make EC2 instances reachable from the internet, they need to be assigned a public IP address. This can be done by
setting the `AssociatePublicIpAddress` property on one of the attached Network Interfaces to `true`. This will assign
a public IP address to the EC2 instance.

[More information on public IP addresses](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-instance-addressing.html#concepts-public-addresses)

## More Internet Connectivity

On the other hand, your compute workloads might needs access to the internet without exposing them to the internet.
The recommended way for this is using
an [Internet Gateway](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Internet_Gateway.html)

[More information on Internet Gateways](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-ec2-internetgateway.html)