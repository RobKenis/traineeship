# DNS and Service Discovery

DNS is a critical component of any infrastructure. We will dive into 2 services for providing an easy name to an IP
address.

## Route53

AWS [Route53](https://aws.amazon.com/route53/) is the DNS service that promises a 100% uptime SLA. It is a managed
service that can be used to register domains, create DNS records, and even provide health checks for your services.

It starts by creating
a [Hosted Zone](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-route53-hostedzone.html)

```yaml
--8<-- "docs/content/aws/route53/hosted-zone.yaml"
```

After creating the hosted zone, you can add the DNS records you like. For Axxes account, a Hosted Zone is provisioned
by default for each created account, you can use this one.

## AWS CloudMap

AWS [CloudMap](https://aws.amazon.com/cloud-map/) is a service discovery service. It works seamlessly with ECS and EKS
to provide a way to discover services. It can be used to discover services in a VPC or across multiple VPCs.

It starts by creating
a [Namespace](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-servicediscovery-namespace.html)
The namespace is attached to a VPC which will allow instances in the VPC to register themselves and resolve DNS names.

```yaml
--8<-- "docs/content/aws/route53/cloudmap-namespace.yaml"
```

### Service Discovery on ECS

Modify your ECS Service so each task registers itself with
CloudMap. [This documentation](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-ecs-service.html#cfn-ecs-service-serviceregistries)
is a good starting point.