<h1 align="center">URL Shortener</h1>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg??style=for-the-badge&logo=openjdk&logoColor=white)]()
[![AWS](https://img.shields.io/badge/AWS-%2523FF9900.svg)]()

</div>

---

<p align="center"> URL shortening project using the concept of Lambda functions.
    <br>
</p>

## 📝 Table of Contents

- [📝 Table of Contents](#-table-of-contents)
- [💭 How it works ](#-how-it-works-)
- [🎈 Usage ](#-usage-)
- [🏁 Getting Started ](#-getting-started-)
  - [Prerequisites](#prerequisites)
- [⛏️ Built Using ](#️-built-using-)
- [Dependency ](#dependency-)
- [🎉 Acknowledgements ](#-acknowledgements-)

## 💭 How it works <a name = "working"></a>

The GeneralShortener function in informing a JSON with Originurn and Expiratime and returns an ID.

The RedirecturlShortener function receives the ID, validated to expiration and redirects to the original URL.

## 🎈 Usage <a name = "usage"></a>

To use it depends on your lambda function configuration.

The GeneralShortener function
```sh
https://i1c86sb7gl.execute-api.us-east-1.amazonaws.com/
Content-Type: application/json

{
  "originalUrl": "url",
  "expirationTime": "1564654"
}

Return
{
  "code": "4654asd"
}
```

The RedirectShortener function
```sh
https://i1c86sb7gl.execute-api.us-east-1.amazonaws.com/{code}

Return
Redirect to the original link
```

## 🏁 Getting Started <a name = "getting_started"></a>

You will need to build the functions and need to the lambda function of your favorite cloud platform.

### Prerequisites

Create the Lambda function and share the link, or the link of an API Gatway

## ⛏️ Built Using <a name = "built_using"></a>

- [JAVA 17](https://www.java.com/) - Language used
- [Maven 3.5.3](https://maven.apache.org/) - Java Project Manager used
- [Rest Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) - Extension used to perform Test in the VSCode
- [ASDF](https://asdf-vm.com/) - Manager used for Java and Maven packages

## Dependency <a name = "dependency"></a>

- lombok
- aws-lambda-java-core
- aws-lambda-java-log4j2
- jackson-databind


## 🎉 Acknowledgements <a name = "acknowledgement"></a>

Feito com carinho no curso gratuito de java na [Rocketseat](https://app.rocketseat.com.br/)
