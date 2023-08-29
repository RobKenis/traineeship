# Monitoring

Will will go over 3 concepts in this section: auditing of the account, monitoring of infrastructure, monitoring of
the application.

## CloudTrail

[AWS CloudTrail](https://aws.amazon.com/cloudtrail/) is a service that keeps track of all events that happen in the
account. This includes actions taken by users, roles, and services. It is a good idea to have this enabled in all
accounts.

## CloudWatch

[AWS CloudWatch](https://aws.amazon.com/cloudwatch/) is a service that allows you to monitor your infrastructure and
applications. It can be used to monitor metrics, logs, and events.

### CloudWatch with ECS

ECS metrics integrate seamlessly with CloudWatch. You can
enable [Container Insights](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/ContainerInsights.html)
on your ECS Cluster
in [ClusterSettings](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-ecs-cluster-clustersettings.html).

After enabling Container Insights, you can view the metrics in the CloudWatch Console.

To export application metrics to CloudWatch, you can use
the [Prometheus Exporter](https://github.com/prometheus/cloudwatch_exporter)
when you have an existing prometheus metrics endpoint. Another alternative is using the AWS SDK to send metrics directly
to CloudWatch. Most frameworks like Spring Boot and Micronaut have support for this.

## Prometheus with Grafana

One downside of CloudWatch is that it's rather pricey. Another way to monitor your infrastructure and applications is
using Managed Prometheus and Grafana

```yaml
--8<-- "docs/content/aws/monitoring/prometheus-with-grafana.yaml"
```

> If you want to play around with Prometheus and Grafana, go ahead, but there are sessions that dive deeper into this.
