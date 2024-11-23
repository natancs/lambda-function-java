package com.natancs.generateUrlShortener;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class Main implements RequestHandler<Map<String, Object>, Map<String, String>> {

  private final ObjectMapper _ObjectMapper = new ObjectMapper();
  private final S3Client _S3Client = S3Client.builder().build();

  @Override
  public Map<String, String> handleRequest(Map<String, Object> input, Context context) {
    String body = (String) input.get("body");

    Map<String, String> bodyMap;
    try {
      bodyMap = _ObjectMapper.readValue(body, Map.class);
    } catch (Exception exception) {
      throw new RuntimeException("Error parsing JSON body: " + exception.getMessage(), exception);
    }

    String originalUrl = bodyMap.get("originalUrl");
    String expirationTime = bodyMap.get("expirationTime");
    long expirationTimeInSeconds = Long.parseLong(expirationTime);

    String shortUrlCode = UUID.randomUUID().toString().substring(0, 8);

    UrlData urlData = new UrlData(originalUrl, expirationTimeInSeconds);

    try {
      String urlDataJson = _ObjectMapper.writeValueAsString(urlData);
      PutObjectRequest request = PutObjectRequest.builder()
          .bucket("url-shortener-storage-na")
          .key(shortUrlCode + ".json")
          .build();

      _S3Client.putObject(request, RequestBody.fromString(urlDataJson));
    } catch (Exception exception) {
      throw new RuntimeException("Error saving data to S3: " + exception.getMessage(), exception);
    }

    Map<String, String> response = new HashMap<>();
    response.put("code", shortUrlCode);

    return response;
  }
}
