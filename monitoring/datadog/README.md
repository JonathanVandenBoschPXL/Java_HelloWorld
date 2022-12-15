### Info
- APP Key: 541c29229d0e7d4f68fe58c39cf249ca89dbea1c
- API Key: 1d6b2575ac80ca5ac21bedbbd62e26e0

### Steps
1. Install Datadog Agent
    - helm install dd-agent -f .\monitoring\datadog\dd-agent-values.yaml --set datadog.site='datadoghq.com' --set datadog.apiKey=1d6b2575ac80ca5ac21bedbbd62e26e0 datadog/datadog

    
