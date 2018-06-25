

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.GetAccessTokenByRefreshTokenParams;
import io.swagger.client.model.GetAccessTokenByRefreshTokenResponse;
import io.swagger.client.model.GetAuthorizationUrlParams;
import io.swagger.client.model.GetAuthorizationUrlResponse;
import io.swagger.client.model.GetClientTokenParams;
import io.swagger.client.model.GetClientTokenResponse;
import io.swagger.client.model.GetLogoutUriParams;
import io.swagger.client.model.GetLogoutUriResponse;
import io.swagger.client.model.GetTokensByCodeParams;
import io.swagger.client.model.GetTokensByCodeResponse;
import io.swagger.client.model.GetUserInfoParams;
import io.swagger.client.model.GetUserInfoResponse;
import io.swagger.client.model.IntrospectAccessTokenParams;
import io.swagger.client.model.IntrospectAccessTokenReponse;
import io.swagger.client.model.IntrospectRptParams;
import io.swagger.client.model.IntrospectRptResponse;
import io.swagger.client.model.RegisterSiteParams;
import io.swagger.client.model.RegisterSiteResponse;
import io.swagger.client.model.RemoveSiteParams;
import io.swagger.client.model.SetupClientParams;
import io.swagger.client.model.SetupClientResponse;
import io.swagger.client.model.UmaRpGetClaimsGatheringUrlParams;
import io.swagger.client.model.UmaRpGetClaimsGatheringUrlResponse;
import io.swagger.client.model.UmaRpGetRptParams;
import io.swagger.client.model.UmaRpGetRptResponse;
import io.swagger.client.model.UmaRsCheckAccessParams;
import io.swagger.client.model.UmaRsCheckAccessResponse;
import io.swagger.client.model.UmaRsProtectParams;
import io.swagger.client.model.UpdateSiteParams;
import io.swagger.client.model.UpdateSiteResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevelopersApi {
    private ApiClient apiClient;

    public DevelopersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DevelopersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getAccessTokenByRefreshToken
     * @param authorization  (optional)
     * @param getAccessTokenByRefreshTokenParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAccessTokenByRefreshTokenCall(String authorization, GetAccessTokenByRefreshTokenParams getAccessTokenByRefreshTokenParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = getAccessTokenByRefreshTokenParams;

        // create path and map variables
        String localVarPath = "/get-access-token-by-refresh-token";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAccessTokenByRefreshTokenValidateBeforeCall(String authorization, GetAccessTokenByRefreshTokenParams getAccessTokenByRefreshTokenParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getAccessTokenByRefreshTokenCall(authorization, getAccessTokenByRefreshTokenParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Access Token By Refresh Token
     * Get Access Token By Refresh Token
     * @param authorization  (optional)
     * @param getAccessTokenByRefreshTokenParams  (optional)
     * @return GetAccessTokenByRefreshTokenResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetAccessTokenByRefreshTokenResponse getAccessTokenByRefreshToken(String authorization, GetAccessTokenByRefreshTokenParams getAccessTokenByRefreshTokenParams) throws ApiException {
        ApiResponse<GetAccessTokenByRefreshTokenResponse> resp = getAccessTokenByRefreshTokenWithHttpInfo(authorization, getAccessTokenByRefreshTokenParams);
        return resp.getData();
    }

    /**
     * Get Access Token By Refresh Token
     * Get Access Token By Refresh Token
     * @param authorization  (optional)
     * @param getAccessTokenByRefreshTokenParams  (optional)
     * @return ApiResponse&lt;GetAccessTokenByRefreshTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetAccessTokenByRefreshTokenResponse> getAccessTokenByRefreshTokenWithHttpInfo(String authorization, GetAccessTokenByRefreshTokenParams getAccessTokenByRefreshTokenParams) throws ApiException {
        com.squareup.okhttp.Call call = getAccessTokenByRefreshTokenValidateBeforeCall(authorization, getAccessTokenByRefreshTokenParams, null, null);
        Type localVarReturnType = new TypeToken<GetAccessTokenByRefreshTokenResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Access Token By Refresh Token (asynchronously)
     * Get Access Token By Refresh Token
     * @param authorization  (optional)
     * @param getAccessTokenByRefreshTokenParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAccessTokenByRefreshTokenAsync(String authorization, GetAccessTokenByRefreshTokenParams getAccessTokenByRefreshTokenParams, final ApiCallback<GetAccessTokenByRefreshTokenResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAccessTokenByRefreshTokenValidateBeforeCall(authorization, getAccessTokenByRefreshTokenParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetAccessTokenByRefreshTokenResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAuthorizationUrl
     * @param authorization  (optional)
     * @param getAuthorizationUrlParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAuthorizationUrlCall(String authorization, GetAuthorizationUrlParams getAuthorizationUrlParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = getAuthorizationUrlParams;

        // create path and map variables
        String localVarPath = "/get-authorization-url";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAuthorizationUrlValidateBeforeCall(String authorization, GetAuthorizationUrlParams getAuthorizationUrlParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getAuthorizationUrlCall(authorization, getAuthorizationUrlParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Authorization Url
     * Gets authorization url
     * @param authorization  (optional)
     * @param getAuthorizationUrlParams  (optional)
     * @return GetAuthorizationUrlResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetAuthorizationUrlResponse getAuthorizationUrl(String authorization, GetAuthorizationUrlParams getAuthorizationUrlParams) throws ApiException {
        ApiResponse<GetAuthorizationUrlResponse> resp = getAuthorizationUrlWithHttpInfo(authorization, getAuthorizationUrlParams);
        return resp.getData();
    }

    /**
     * Get Authorization Url
     * Gets authorization url
     * @param authorization  (optional)
     * @param getAuthorizationUrlParams  (optional)
     * @return ApiResponse&lt;GetAuthorizationUrlResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetAuthorizationUrlResponse> getAuthorizationUrlWithHttpInfo(String authorization, GetAuthorizationUrlParams getAuthorizationUrlParams) throws ApiException {
        com.squareup.okhttp.Call call = getAuthorizationUrlValidateBeforeCall(authorization, getAuthorizationUrlParams, null, null);
        Type localVarReturnType = new TypeToken<GetAuthorizationUrlResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Authorization Url (asynchronously)
     * Gets authorization url
     * @param authorization  (optional)
     * @param getAuthorizationUrlParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAuthorizationUrlAsync(String authorization, GetAuthorizationUrlParams getAuthorizationUrlParams, final ApiCallback<GetAuthorizationUrlResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAuthorizationUrlValidateBeforeCall(authorization, getAuthorizationUrlParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetAuthorizationUrlResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getClientToken
     * @param getClientTokenParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getClientTokenCall(GetClientTokenParams getClientTokenParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = getClientTokenParams;

        // create path and map variables
        String localVarPath = "/get-client-token";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getClientTokenValidateBeforeCall(GetClientTokenParams getClientTokenParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getClientTokenCall(getClientTokenParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Client Token
     * Gets Client Token
     * @param getClientTokenParams  (optional)
     * @return GetClientTokenResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetClientTokenResponse getClientToken(GetClientTokenParams getClientTokenParams) throws ApiException {
        ApiResponse<GetClientTokenResponse> resp = getClientTokenWithHttpInfo(getClientTokenParams);
        return resp.getData();
    }

    /**
     * Get Client Token
     * Gets Client Token
     * @param getClientTokenParams  (optional)
     * @return ApiResponse&lt;GetClientTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetClientTokenResponse> getClientTokenWithHttpInfo(GetClientTokenParams getClientTokenParams) throws ApiException {
        com.squareup.okhttp.Call call = getClientTokenValidateBeforeCall(getClientTokenParams, null, null);
        Type localVarReturnType = new TypeToken<GetClientTokenResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Client Token (asynchronously)
     * Gets Client Token
     * @param getClientTokenParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getClientTokenAsync(GetClientTokenParams getClientTokenParams, final ApiCallback<GetClientTokenResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getClientTokenValidateBeforeCall(getClientTokenParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetClientTokenResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getLogoutUri
     * @param authorization  (optional)
     * @param getLogoutUriParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getLogoutUriCall(String authorization, GetLogoutUriParams getLogoutUriParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = getLogoutUriParams;

        // create path and map variables
        String localVarPath = "/get-logout-uri";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getLogoutUriValidateBeforeCall(String authorization, GetLogoutUriParams getLogoutUriParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getLogoutUriCall(authorization, getLogoutUriParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Logout URL
     * Get Logout URL
     * @param authorization  (optional)
     * @param getLogoutUriParams  (optional)
     * @return GetLogoutUriResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetLogoutUriResponse getLogoutUri(String authorization, GetLogoutUriParams getLogoutUriParams) throws ApiException {
        ApiResponse<GetLogoutUriResponse> resp = getLogoutUriWithHttpInfo(authorization, getLogoutUriParams);
        return resp.getData();
    }

    /**
     * Get Logout URL
     * Get Logout URL
     * @param authorization  (optional)
     * @param getLogoutUriParams  (optional)
     * @return ApiResponse&lt;GetLogoutUriResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetLogoutUriResponse> getLogoutUriWithHttpInfo(String authorization, GetLogoutUriParams getLogoutUriParams) throws ApiException {
        com.squareup.okhttp.Call call = getLogoutUriValidateBeforeCall(authorization, getLogoutUriParams, null, null);
        Type localVarReturnType = new TypeToken<GetLogoutUriResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Logout URL (asynchronously)
     * Get Logout URL
     * @param authorization  (optional)
     * @param getLogoutUriParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getLogoutUriAsync(String authorization, GetLogoutUriParams getLogoutUriParams, final ApiCallback<GetLogoutUriResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getLogoutUriValidateBeforeCall(authorization, getLogoutUriParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetLogoutUriResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTokensByCode
     * @param authorization  (optional)
     * @param getTokensByCodeParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTokensByCodeCall(String authorization, GetTokensByCodeParams getTokensByCodeParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = getTokensByCodeParams;

        // create path and map variables
        String localVarPath = "/get-tokens-by-code";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTokensByCodeValidateBeforeCall(String authorization, GetTokensByCodeParams getTokensByCodeParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getTokensByCodeCall(authorization, getTokensByCodeParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Tokens By Code
     * Get tokens by code
     * @param authorization  (optional)
     * @param getTokensByCodeParams  (optional)
     * @return GetTokensByCodeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetTokensByCodeResponse getTokensByCode(String authorization, GetTokensByCodeParams getTokensByCodeParams) throws ApiException {
        ApiResponse<GetTokensByCodeResponse> resp = getTokensByCodeWithHttpInfo(authorization, getTokensByCodeParams);
        return resp.getData();
    }

    /**
     * Get Tokens By Code
     * Get tokens by code
     * @param authorization  (optional)
     * @param getTokensByCodeParams  (optional)
     * @return ApiResponse&lt;GetTokensByCodeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetTokensByCodeResponse> getTokensByCodeWithHttpInfo(String authorization, GetTokensByCodeParams getTokensByCodeParams) throws ApiException {
        com.squareup.okhttp.Call call = getTokensByCodeValidateBeforeCall(authorization, getTokensByCodeParams, null, null);
        Type localVarReturnType = new TypeToken<GetTokensByCodeResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Tokens By Code (asynchronously)
     * Get tokens by code
     * @param authorization  (optional)
     * @param getTokensByCodeParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTokensByCodeAsync(String authorization, GetTokensByCodeParams getTokensByCodeParams, final ApiCallback<GetTokensByCodeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTokensByCodeValidateBeforeCall(authorization, getTokensByCodeParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetTokensByCodeResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getUserInfo
     * @param authorization  (optional)
     * @param getUserInfoParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getUserInfoCall(String authorization, GetUserInfoParams getUserInfoParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = getUserInfoParams;

        // create path and map variables
        String localVarPath = "/get-user-info";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getUserInfoValidateBeforeCall(String authorization, GetUserInfoParams getUserInfoParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getUserInfoCall(authorization, getUserInfoParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get User Info
     * Get User Info
     * @param authorization  (optional)
     * @param getUserInfoParams  (optional)
     * @return GetUserInfoResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetUserInfoResponse getUserInfo(String authorization, GetUserInfoParams getUserInfoParams) throws ApiException {
        ApiResponse<GetUserInfoResponse> resp = getUserInfoWithHttpInfo(authorization, getUserInfoParams);
        return resp.getData();
    }

    /**
     * Get User Info
     * Get User Info
     * @param authorization  (optional)
     * @param getUserInfoParams  (optional)
     * @return ApiResponse&lt;GetUserInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetUserInfoResponse> getUserInfoWithHttpInfo(String authorization, GetUserInfoParams getUserInfoParams) throws ApiException {
        com.squareup.okhttp.Call call = getUserInfoValidateBeforeCall(authorization, getUserInfoParams, null, null);
        Type localVarReturnType = new TypeToken<GetUserInfoResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get User Info (asynchronously)
     * Get User Info
     * @param authorization  (optional)
     * @param getUserInfoParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserInfoAsync(String authorization, GetUserInfoParams getUserInfoParams, final ApiCallback<GetUserInfoResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getUserInfoValidateBeforeCall(authorization, getUserInfoParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetUserInfoResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for healthCheck
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call healthCheckCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/health-check";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call healthCheckValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = healthCheckCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * Health Check
     * Health Check endpoint for quick check whether oxd-server is alive.
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void healthCheck() throws ApiException {
        healthCheckWithHttpInfo();
    }

    /**
     * Health Check
     * Health Check endpoint for quick check whether oxd-server is alive.
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> healthCheckWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = healthCheckValidateBeforeCall(null, null);
        return apiClient.execute(call);
    }

    /**
     * Health Check (asynchronously)
     * Health Check endpoint for quick check whether oxd-server is alive.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call healthCheckAsync(final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = healthCheckValidateBeforeCall(progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for introspectAccessToken
     * @param authorization  (optional)
     * @param introspectAccessTokenParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call introspectAccessTokenCall(String authorization, IntrospectAccessTokenParams introspectAccessTokenParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = introspectAccessTokenParams;

        // create path and map variables
        String localVarPath = "/introspect-access-token";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call introspectAccessTokenValidateBeforeCall(String authorization, IntrospectAccessTokenParams introspectAccessTokenParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = introspectAccessTokenCall(authorization, introspectAccessTokenParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Introspect Access Token
     * Introspect Access Token
     * @param authorization  (optional)
     * @param introspectAccessTokenParams  (optional)
     * @return IntrospectAccessTokenReponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IntrospectAccessTokenReponse introspectAccessToken(String authorization, IntrospectAccessTokenParams introspectAccessTokenParams) throws ApiException {
        ApiResponse<IntrospectAccessTokenReponse> resp = introspectAccessTokenWithHttpInfo(authorization, introspectAccessTokenParams);
        return resp.getData();
    }

    /**
     * Introspect Access Token
     * Introspect Access Token
     * @param authorization  (optional)
     * @param introspectAccessTokenParams  (optional)
     * @return ApiResponse&lt;IntrospectAccessTokenReponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IntrospectAccessTokenReponse> introspectAccessTokenWithHttpInfo(String authorization, IntrospectAccessTokenParams introspectAccessTokenParams) throws ApiException {
        com.squareup.okhttp.Call call = introspectAccessTokenValidateBeforeCall(authorization, introspectAccessTokenParams, null, null);
        Type localVarReturnType = new TypeToken<IntrospectAccessTokenReponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Introspect Access Token (asynchronously)
     * Introspect Access Token
     * @param authorization  (optional)
     * @param introspectAccessTokenParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call introspectAccessTokenAsync(String authorization, IntrospectAccessTokenParams introspectAccessTokenParams, final ApiCallback<IntrospectAccessTokenReponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = introspectAccessTokenValidateBeforeCall(authorization, introspectAccessTokenParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IntrospectAccessTokenReponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for introspectRpt
     * @param authorization  (optional)
     * @param introspectRptParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call introspectRptCall(String authorization, IntrospectRptParams introspectRptParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = introspectRptParams;

        // create path and map variables
        String localVarPath = "/introspect-rpt";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call introspectRptValidateBeforeCall(String authorization, IntrospectRptParams introspectRptParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = introspectRptCall(authorization, introspectRptParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Introspect RPT
     * Introspect RPT
     * @param authorization  (optional)
     * @param introspectRptParams  (optional)
     * @return IntrospectRptResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IntrospectRptResponse introspectRpt(String authorization, IntrospectRptParams introspectRptParams) throws ApiException {
        ApiResponse<IntrospectRptResponse> resp = introspectRptWithHttpInfo(authorization, introspectRptParams);
        return resp.getData();
    }

    /**
     * Introspect RPT
     * Introspect RPT
     * @param authorization  (optional)
     * @param introspectRptParams  (optional)
     * @return ApiResponse&lt;IntrospectRptResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IntrospectRptResponse> introspectRptWithHttpInfo(String authorization, IntrospectRptParams introspectRptParams) throws ApiException {
        com.squareup.okhttp.Call call = introspectRptValidateBeforeCall(authorization, introspectRptParams, null, null);
        Type localVarReturnType = new TypeToken<IntrospectRptResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Introspect RPT (asynchronously)
     * Introspect RPT
     * @param authorization  (optional)
     * @param introspectRptParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call introspectRptAsync(String authorization, IntrospectRptParams introspectRptParams, final ApiCallback<IntrospectRptResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = introspectRptValidateBeforeCall(authorization, introspectRptParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IntrospectRptResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for registerSite
     * @param authorization  (optional)
     * @param registerSiteParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call registerSiteCall(String authorization, RegisterSiteParams registerSiteParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = registerSiteParams;

        // create path and map variables
        String localVarPath = "/register-site";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call registerSiteValidateBeforeCall(String authorization, RegisterSiteParams registerSiteParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = registerSiteCall(authorization, registerSiteParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Register Site
     * Registers site at oxd-server
     * @param authorization  (optional)
     * @param registerSiteParams  (optional)
     * @return RegisterSiteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RegisterSiteResponse registerSite(String authorization, RegisterSiteParams registerSiteParams) throws ApiException {
        ApiResponse<RegisterSiteResponse> resp = registerSiteWithHttpInfo(authorization, registerSiteParams);
        return resp.getData();
    }

    /**
     * Register Site
     * Registers site at oxd-server
     * @param authorization  (optional)
     * @param registerSiteParams  (optional)
     * @return ApiResponse&lt;RegisterSiteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<RegisterSiteResponse> registerSiteWithHttpInfo(String authorization, RegisterSiteParams registerSiteParams) throws ApiException {
        com.squareup.okhttp.Call call = registerSiteValidateBeforeCall(authorization, registerSiteParams, null, null);
        Type localVarReturnType = new TypeToken<RegisterSiteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Register Site (asynchronously)
     * Registers site at oxd-server
     * @param authorization  (optional)
     * @param registerSiteParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call registerSiteAsync(String authorization, RegisterSiteParams registerSiteParams, final ApiCallback<RegisterSiteResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = registerSiteValidateBeforeCall(authorization, registerSiteParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RegisterSiteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for removeSite
     * @param authorization  (optional)
     * @param removeSiteParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call removeSiteCall(String authorization, RemoveSiteParams removeSiteParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = removeSiteParams;

        // create path and map variables
        String localVarPath = "/remove-site";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call removeSiteValidateBeforeCall(String authorization, RemoveSiteParams removeSiteParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = removeSiteCall(authorization, removeSiteParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Remove Site
     * Removes site from oxd-server
     * @param authorization  (optional)
     * @param removeSiteParams  (optional)
     * @return UpdateSiteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateSiteResponse removeSite(String authorization, RemoveSiteParams removeSiteParams) throws ApiException {
        ApiResponse<UpdateSiteResponse> resp = removeSiteWithHttpInfo(authorization, removeSiteParams);
        return resp.getData();
    }

    /**
     * Remove Site
     * Removes site from oxd-server
     * @param authorization  (optional)
     * @param removeSiteParams  (optional)
     * @return ApiResponse&lt;UpdateSiteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UpdateSiteResponse> removeSiteWithHttpInfo(String authorization, RemoveSiteParams removeSiteParams) throws ApiException {
        com.squareup.okhttp.Call call = removeSiteValidateBeforeCall(authorization, removeSiteParams, null, null);
        Type localVarReturnType = new TypeToken<UpdateSiteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Remove Site (asynchronously)
     * Removes site from oxd-server
     * @param authorization  (optional)
     * @param removeSiteParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call removeSiteAsync(String authorization, RemoveSiteParams removeSiteParams, final ApiCallback<UpdateSiteResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = removeSiteValidateBeforeCall(authorization, removeSiteParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UpdateSiteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for setupClient
     * @param setupClientParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call setupClientCall(SetupClientParams setupClientParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = setupClientParams;

        // create path and map variables
        String localVarPath = "/setup-client";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call setupClientValidateBeforeCall(SetupClientParams setupClientParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = setupClientCall(setupClientParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Setup Client
     * Setups client for securing communication to oxd-server
     * @param setupClientParams  (optional)
     * @return SetupClientResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SetupClientResponse setupClient(SetupClientParams setupClientParams) throws ApiException {
        ApiResponse<SetupClientResponse> resp = setupClientWithHttpInfo(setupClientParams);
        return resp.getData();
    }

    /**
     * Setup Client
     * Setups client for securing communication to oxd-server
     * @param setupClientParams  (optional)
     * @return ApiResponse&lt;SetupClientResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SetupClientResponse> setupClientWithHttpInfo(SetupClientParams setupClientParams) throws ApiException {
        com.squareup.okhttp.Call call = setupClientValidateBeforeCall(setupClientParams, null, null);
        Type localVarReturnType = new TypeToken<SetupClientResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Setup Client (asynchronously)
     * Setups client for securing communication to oxd-server
     * @param setupClientParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call setupClientAsync(SetupClientParams setupClientParams, final ApiCallback<SetupClientResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = setupClientValidateBeforeCall(setupClientParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SetupClientResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for umaRpGetClaimsGatheringUrl
     * @param authorization  (optional)
     * @param umaRpGetClaimsGatheringUrlParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call umaRpGetClaimsGatheringUrlCall(String authorization, UmaRpGetClaimsGatheringUrlParams umaRpGetClaimsGatheringUrlParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = umaRpGetClaimsGatheringUrlParams;

        // create path and map variables
        String localVarPath = "/uma-rp-get-claims-gathering-url";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call umaRpGetClaimsGatheringUrlValidateBeforeCall(String authorization, UmaRpGetClaimsGatheringUrlParams umaRpGetClaimsGatheringUrlParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = umaRpGetClaimsGatheringUrlCall(authorization, umaRpGetClaimsGatheringUrlParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * UMA RP Get Claims Gathering URL
     * UMA RP Get Claims Gathering URL
     * @param authorization  (optional)
     * @param umaRpGetClaimsGatheringUrlParams  (optional)
     * @return UmaRpGetClaimsGatheringUrlResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UmaRpGetClaimsGatheringUrlResponse umaRpGetClaimsGatheringUrl(String authorization, UmaRpGetClaimsGatheringUrlParams umaRpGetClaimsGatheringUrlParams) throws ApiException {
        ApiResponse<UmaRpGetClaimsGatheringUrlResponse> resp = umaRpGetClaimsGatheringUrlWithHttpInfo(authorization, umaRpGetClaimsGatheringUrlParams);
        return resp.getData();
    }

    /**
     * UMA RP Get Claims Gathering URL
     * UMA RP Get Claims Gathering URL
     * @param authorization  (optional)
     * @param umaRpGetClaimsGatheringUrlParams  (optional)
     * @return ApiResponse&lt;UmaRpGetClaimsGatheringUrlResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UmaRpGetClaimsGatheringUrlResponse> umaRpGetClaimsGatheringUrlWithHttpInfo(String authorization, UmaRpGetClaimsGatheringUrlParams umaRpGetClaimsGatheringUrlParams) throws ApiException {
        com.squareup.okhttp.Call call = umaRpGetClaimsGatheringUrlValidateBeforeCall(authorization, umaRpGetClaimsGatheringUrlParams, null, null);
        Type localVarReturnType = new TypeToken<UmaRpGetClaimsGatheringUrlResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * UMA RP Get Claims Gathering URL (asynchronously)
     * UMA RP Get Claims Gathering URL
     * @param authorization  (optional)
     * @param umaRpGetClaimsGatheringUrlParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call umaRpGetClaimsGatheringUrlAsync(String authorization, UmaRpGetClaimsGatheringUrlParams umaRpGetClaimsGatheringUrlParams, final ApiCallback<UmaRpGetClaimsGatheringUrlResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = umaRpGetClaimsGatheringUrlValidateBeforeCall(authorization, umaRpGetClaimsGatheringUrlParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UmaRpGetClaimsGatheringUrlResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for umaRpGetRpt
     * @param authorization  (optional)
     * @param umaRpGetRptParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call umaRpGetRptCall(String authorization, UmaRpGetRptParams umaRpGetRptParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = umaRpGetRptParams;

        // create path and map variables
        String localVarPath = "/uma-rp-get-rpt";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call umaRpGetRptValidateBeforeCall(String authorization, UmaRpGetRptParams umaRpGetRptParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = umaRpGetRptCall(authorization, umaRpGetRptParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * UMA RP Get RPT
     * UMA RP Get RPT
     * @param authorization  (optional)
     * @param umaRpGetRptParams  (optional)
     * @return UmaRpGetRptResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UmaRpGetRptResponse umaRpGetRpt(String authorization, UmaRpGetRptParams umaRpGetRptParams) throws ApiException {
        ApiResponse<UmaRpGetRptResponse> resp = umaRpGetRptWithHttpInfo(authorization, umaRpGetRptParams);
        return resp.getData();
    }

    /**
     * UMA RP Get RPT
     * UMA RP Get RPT
     * @param authorization  (optional)
     * @param umaRpGetRptParams  (optional)
     * @return ApiResponse&lt;UmaRpGetRptResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UmaRpGetRptResponse> umaRpGetRptWithHttpInfo(String authorization, UmaRpGetRptParams umaRpGetRptParams) throws ApiException {
        com.squareup.okhttp.Call call = umaRpGetRptValidateBeforeCall(authorization, umaRpGetRptParams, null, null);
        Type localVarReturnType = new TypeToken<UmaRpGetRptResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * UMA RP Get RPT (asynchronously)
     * UMA RP Get RPT
     * @param authorization  (optional)
     * @param umaRpGetRptParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call umaRpGetRptAsync(String authorization, UmaRpGetRptParams umaRpGetRptParams, final ApiCallback<UmaRpGetRptResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = umaRpGetRptValidateBeforeCall(authorization, umaRpGetRptParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UmaRpGetRptResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for umaRsCheckAccess
     * @param authorization  (optional)
     * @param umaRsCheckAccessParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call umaRsCheckAccessCall(String authorization, UmaRsCheckAccessParams umaRsCheckAccessParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = umaRsCheckAccessParams;

        // create path and map variables
        String localVarPath = "/uma-rs-check-access";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call umaRsCheckAccessValidateBeforeCall(String authorization, UmaRsCheckAccessParams umaRsCheckAccessParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = umaRsCheckAccessCall(authorization, umaRsCheckAccessParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * UMA RS Check Access
     * UMA RS Check Access
     * @param authorization  (optional)
     * @param umaRsCheckAccessParams  (optional)
     * @return UmaRsCheckAccessResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UmaRsCheckAccessResponse umaRsCheckAccess(String authorization, UmaRsCheckAccessParams umaRsCheckAccessParams) throws ApiException {
        ApiResponse<UmaRsCheckAccessResponse> resp = umaRsCheckAccessWithHttpInfo(authorization, umaRsCheckAccessParams);
        return resp.getData();
    }

    /**
     * UMA RS Check Access
     * UMA RS Check Access
     * @param authorization  (optional)
     * @param umaRsCheckAccessParams  (optional)
     * @return ApiResponse&lt;UmaRsCheckAccessResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UmaRsCheckAccessResponse> umaRsCheckAccessWithHttpInfo(String authorization, UmaRsCheckAccessParams umaRsCheckAccessParams) throws ApiException {
        com.squareup.okhttp.Call call = umaRsCheckAccessValidateBeforeCall(authorization, umaRsCheckAccessParams, null, null);
        Type localVarReturnType = new TypeToken<UmaRsCheckAccessResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * UMA RS Check Access (asynchronously)
     * UMA RS Check Access
     * @param authorization  (optional)
     * @param umaRsCheckAccessParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call umaRsCheckAccessAsync(String authorization, UmaRsCheckAccessParams umaRsCheckAccessParams, final ApiCallback<UmaRsCheckAccessResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = umaRsCheckAccessValidateBeforeCall(authorization, umaRsCheckAccessParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UmaRsCheckAccessResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for umaRsProtect
     * @param authorization  (optional)
     * @param umaRsProtectParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call umaRsProtectCall(String authorization, UmaRsProtectParams umaRsProtectParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = umaRsProtectParams;

        // create path and map variables
        String localVarPath = "/uma-rs-protect";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call umaRsProtectValidateBeforeCall(String authorization, UmaRsProtectParams umaRsProtectParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = umaRsProtectCall(authorization, umaRsProtectParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * UMA RS Protect Resources
     * UMA RS Protect Resources. It&#39;s important to have a single HTTP method, mentioned only once within a given path in JSON, otherwise, the operation will fail.
     * @param authorization  (optional)
     * @param umaRsProtectParams  (optional)
     * @return UpdateSiteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateSiteResponse umaRsProtect(String authorization, UmaRsProtectParams umaRsProtectParams) throws ApiException {
        ApiResponse<UpdateSiteResponse> resp = umaRsProtectWithHttpInfo(authorization, umaRsProtectParams);
        return resp.getData();
    }

    /**
     * UMA RS Protect Resources
     * UMA RS Protect Resources. It&#39;s important to have a single HTTP method, mentioned only once within a given path in JSON, otherwise, the operation will fail.
     * @param authorization  (optional)
     * @param umaRsProtectParams  (optional)
     * @return ApiResponse&lt;UpdateSiteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UpdateSiteResponse> umaRsProtectWithHttpInfo(String authorization, UmaRsProtectParams umaRsProtectParams) throws ApiException {
        com.squareup.okhttp.Call call = umaRsProtectValidateBeforeCall(authorization, umaRsProtectParams, null, null);
        Type localVarReturnType = new TypeToken<UpdateSiteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * UMA RS Protect Resources (asynchronously)
     * UMA RS Protect Resources. It&#39;s important to have a single HTTP method, mentioned only once within a given path in JSON, otherwise, the operation will fail.
     * @param authorization  (optional)
     * @param umaRsProtectParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call umaRsProtectAsync(String authorization, UmaRsProtectParams umaRsProtectParams, final ApiCallback<UpdateSiteResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = umaRsProtectValidateBeforeCall(authorization, umaRsProtectParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UpdateSiteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateSite
     * @param authorization  (optional)
     * @param updateSiteParams  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateSiteCall(String authorization, UpdateSiteParams updateSiteParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = updateSiteParams;

        // create path and map variables
        String localVarPath = "/update-site";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateSiteValidateBeforeCall(String authorization, UpdateSiteParams updateSiteParams, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = updateSiteCall(authorization, updateSiteParams, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Update Site
     * Updates site at oxd-server
     * @param authorization  (optional)
     * @param updateSiteParams  (optional)
     * @return UpdateSiteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateSiteResponse updateSite(String authorization, UpdateSiteParams updateSiteParams) throws ApiException {
        ApiResponse<UpdateSiteResponse> resp = updateSiteWithHttpInfo(authorization, updateSiteParams);
        return resp.getData();
    }

    /**
     * Update Site
     * Updates site at oxd-server
     * @param authorization  (optional)
     * @param updateSiteParams  (optional)
     * @return ApiResponse&lt;UpdateSiteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UpdateSiteResponse> updateSiteWithHttpInfo(String authorization, UpdateSiteParams updateSiteParams) throws ApiException {
        com.squareup.okhttp.Call call = updateSiteValidateBeforeCall(authorization, updateSiteParams, null, null);
        Type localVarReturnType = new TypeToken<UpdateSiteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update Site (asynchronously)
     * Updates site at oxd-server
     * @param authorization  (optional)
     * @param updateSiteParams  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateSiteAsync(String authorization, UpdateSiteParams updateSiteParams, final ApiCallback<UpdateSiteResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateSiteValidateBeforeCall(authorization, updateSiteParams, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UpdateSiteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
