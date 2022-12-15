# PRiSMA

The official repository for the PXL PRiSMA educational project.

## frontend
This folder will contain the application's frontend source code.

[![FRONTEND: : Test - Build - Dockerize](https://github.com/PXL-PRiSMA/PRiSMA/actions/workflows/dev-frontend.yml/badge.svg)](https://github.com/PXL-PRiSMA/PRiSMA/actions/workflows/dev-frontend.yml)

## backend
This folder will contain the application's backend source code.

[![BACKEND: prisma-service : Test - Build - Dockerize](https://github.com/PXL-PRiSMA/PRiSMA/actions/workflows/dev-backend-prisma-service.yml/badge.svg)](https://github.com/PXL-PRiSMA/PRiSMA/actions/workflows/dev-backend-prisma-service.yml)

[![BACKEND: identity-server : Test - Build - Dockerize](https://github.com/PXL-PRiSMA/PRiSMA/actions/workflows/dev-backend-identity-server.yml/badge.svg)](https://github.com/PXL-PRiSMA/PRiSMA/actions/workflows/dev-backend-identity-server.yml)


## e2e
Deze folder bevat de end-to-end testen die in de Selenium Dev workflow automatisch worden uitgevoerd van zodra er een run van de Frontend of Backend - Prisma-Service workflows klaar is.

[![SELENIUM](https://github.com/PXL-PRiSMA/PRiSMA/actions/workflows/dev-selenium.yml/badge.svg)](https://github.com/PXL-PRiSMA/PRiSMA/actions/workflows/dev-selenium.yml)

## infrastructure
This folder will contain the infrastructure-as-code definitions to set up the project.

## workflows
This folder will contain the GitHub Actions workflow definitions.


More info to be added later.


# Connecteren met de Environments
Tijdelijk staat een development environment online via docker compose. Deze kan je via je browser bekijken.

Wanneer je op het netwerk bent van PXL, dus ofwel op de Corda Campus of op de Elfde-linie Campus, kan je direct connecteren via onderstaande adressen.
Wanneer je dit thuis of vanuit een ander netwerk wilt bereiken, zal je eerst een VPN-connectie moeten maken met de VPN van PXL. Hoe je dit kan doen kan je lezen @ https://vpn.pxl.be

## Test Environment
- Frontend: http://test.pxl-prisma.tech
- Backend: http://test.pxl-prisma.tech:7000 (niet via browser beschikbaar, wel via  bijv. Postman)
- Keycloak: http://test.pxl-prisma.tech:8181

## Production Environment
- Frontend: http://prod.pxl-prisma.tech
- Backend: http://prod.pxl-prisma.tech:7001 (niet via browser beschikbaar, wel via  bijv. Postman)
- Keycloak: http://prod.pxl-prisma.tech:8181


# SonarQube UI
SonarQube UI: http://10.128.9.7:9000

- username: developer
- password: raad het maar hé




