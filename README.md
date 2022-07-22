# Prometheus
Prometheus is an open-source monitoring and alerting toolkit
Prometheus collects and stores its metrics as time series data, i.e. metrics information is stored with the timestamp at which it was recorded, alongside optional key-value pairs called labels.

**Architecture**

![image](https://user-images.githubusercontent.com/42235943/180463119-2802481f-6c06-414a-82d9-c8d9d5b76393.png)

**Pushgateway**

- It is an intermediary service which allows you to push metrics to Pushgateway.
- The Prometheus Pushgateway then exposes these metrics to Prometheus.

**Libraries**

Prometheus client libraries have a feature to push the registered metrics to a Pushgateway.

**Official Client Libraries**
- [Go](https://github.com/prometheus/client_golang)
- [Java or Scala](https://github.com/prometheus/client_java)
- [Python](https://github.com/prometheus/client_python)
- [Ruby](https://github.com/prometheus/client_ruby)
- [Rust](https://github.com/prometheus/client_rust)

Reference - https://prometheus.io/docs/instrumenting/clientlibs/

**Usage**

The Pushgateway has to be configured as a target to scrape by Prometheus.

However, you should always set `honor_labels: true` in the scrape config

>sample scrape configs
```
scrape_configs:
- job_name: prometheus
  scrape_interval: 5s
  static_configs:
    - targets:
      - localhost:9090
- job_name: pushgateway
  honor_labels: true
  scrape_interval: 5s
  static_configs:
  - targets:
    - localhost:9091
```
    
