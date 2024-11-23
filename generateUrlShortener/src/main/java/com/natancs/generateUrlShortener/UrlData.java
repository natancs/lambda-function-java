package com.natancs.generateUrlShortener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UrlData {
  private String originalUrl;
  private long expirationTime;
}
