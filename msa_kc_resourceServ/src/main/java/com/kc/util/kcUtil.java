/*
 * package com.kc.util;
 * 
 * import java.util.Date; import java.util.HashMap; import java.util.Map; import
 * java.util.function.Function;
 * 
 * import org.keycloak.representations.AccessTokenResponse; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.stereotype.Service; import
 * org.springframework.util.LinkedMultiValueMap; import
 * org.springframework.util.MultiValueMap; import
 * org.springframework.web.client.ResourceAccessException; import
 * org.springframework.web.client.RestTemplate;
 * 
 * @Service public class kcUtil{
 * 
 * 
 * private RestTemplate restTemplate;
 * 
 * public AccessTokenResponse login(String username, String password) { try {
 * MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
 * requestParams.add("client_id", ""); requestParams.add("username", username);
 * requestParams.add("password", password); requestParams.add("grant_type",
 * "password"); // requestParams.add("client_secret",
 * keyCloakConnectionProvider.getClientSecret()); requestParams.add("scope",
 * "openid");
 * 
 * AccessTokenResponse keycloakAccessToken =
 * queryKeycloakByParams(requestParams);
 * 
 * return keycloakAccessToken; } catch (Exception e) {
 * //log.info(e.getMessage(), e); throw e; } }
 * 
 * public AccessTokenResponse refresh(String refreshToken) { try {
 * MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
 * requestParams.add("client_id", ""); requestParams.add("grant_type",
 * "refresh_token"); //requestParams.add("client_secret",
 * keyCloakConnectionProvider.getClientSecret());
 * requestParams.add("refresh_token", refreshToken);
 * 
 * AccessTokenResponse keycloakAccessToken =
 * queryKeycloakByParams(requestParams);
 * 
 * return keycloakAccessToken; } catch (Exception e) {
 * //log.info(e.getMessage(), e); throw e; } }
 * 
 * 
 * private AccessTokenResponse queryKeycloakByParams(MultiValueMap<String,
 * String> requestParams) { HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
 * 
 * HttpEntity<MultiValueMap<String, String>> request = new
 * HttpEntity<>(requestParams, headers);
 * 
 * String url = "";
 * 
 * AccessTokenResponse keycloakAccessToken = getAccessTokenResponse(request,
 * url);
 * 
 * return keycloakAccessToken; }
 * 
 * private AccessTokenResponse
 * getAccessTokenResponse(HttpEntity<MultiValueMap<String, String>> request,
 * String url) { try { ResponseEntity<AccessTokenResponse> response =
 * restTemplate.postForEntity(url, request, AccessTokenResponse.class); return
 * response.getBody(); } catch (ResourceAccessException e) {
 * //log.error("KeyCloak getAccessTokenResponse: " + e.getMessage()); try {
 * ResponseEntity<AccessTokenResponse> response =
 * restTemplate.postForEntity(url, request, AccessTokenResponse.class); return
 * response.getBody(); } catch (Exception ex) { throw ex; } } catch (Exception
 * e) { throw e; } }
 * 
 * 
 * }
 */