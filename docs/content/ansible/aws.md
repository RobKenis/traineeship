## Getting started with Ansible on AWS

Create following structure

```text
ansible
├── ansible.cfg
├── application.yaml
├── hosts
│   ├── ec2.ini
│   └── ec2.py
└── requirements.txt
```

Download [ec2.py](hosts/ec2.py) and [ec2.ini](hosts/ec2.ini)

### Setting up Python

```shell
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt
```

<details>
  <summary>requirements.txt</summary>

  ```text
  --8<-- "docs/content/ansible/requirements.txt"
  ```
</details>

### Setting AWS credentials

```bash
export AWS_ACCESS_KEY_ID='<AWS_ACCESS_ID>'
export AWS_SECRET_ACCESS_KEY='<AWS_SECRET_KEY>'
```

### Setting up Ansible config

```toml
--8<-- "docs/content/ansible/ansible.cfg"
```

### Testing connection

```bash
ansible all -m ping
```

[Ansible: dynamic hosts](https://docs.ansible.com/ansible/latest/user_guide/intro_dynamic_inventory.html)

### Deploying an application

```shell
ansible-playbook application.yaml
```

<details>
  <summary>application.yaml</summary>

  ```yaml
  --8<-- "docs/content/ansible/application.yaml"
  ```
</details>