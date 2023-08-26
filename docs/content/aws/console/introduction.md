# AWS Console

## Logging in

Axxes accounts are managed through Active Directory. In the top left corner in Outlook, there should be a button with
**AWS SSO**. A menu should show up with all available accounts, pick **traineeship-2023**
https://axxes.awsapps.com/start#/

## Picking a region

In the top right corner in the AWS console, there's a dropdown with available regions. For this session, we will use
**eu-west-1**. More information on regions and availability zones can be
found [here](https://aws.amazon.com/about-aws/global-infrastructure/regions_az/).

## Service overview

In the top left corner, open **services** to get a look at all available services in AWS.

## AWS CLI

### Installation

Official docs [here](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2-linux.html).

```shell
sudo apt update
sudo apt install awscli
```

### Getting credentials

On the SSO overview, use the *Command line or programmatic access* button to get the credentials for the CLI. Validate
credentials using the following command. If the command succeeds, it returns the information of the assumed user.

```shell
aws sts get-caller-identity
```