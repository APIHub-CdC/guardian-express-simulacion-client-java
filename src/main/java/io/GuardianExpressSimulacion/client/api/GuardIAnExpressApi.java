package io.GuardianExpressSimulacion.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import io.GuardianExpressSimulacion.client.ApiCallback;
import io.GuardianExpressSimulacion.client.ApiClient;
import io.GuardianExpressSimulacion.client.ApiException;
import io.GuardianExpressSimulacion.client.ApiResponse;
import io.GuardianExpressSimulacion.client.Configuration;
import io.GuardianExpressSimulacion.client.Pair;
import io.GuardianExpressSimulacion.client.ProgressRequestBody;
import io.GuardianExpressSimulacion.client.ProgressResponseBody;
import io.GuardianExpressSimulacion.client.model.RequestDatosGenerales;
import io.GuardianExpressSimulacion.client.model.ResponseGuardianDG;

public class GuardIAnExpressApi {
    private ApiClient apiClient;
    public GuardIAnExpressApi() {
        this(Configuration.getDefaultApiClient());
    }
    public GuardIAnExpressApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call creditreportCall(String xApiKey, RequestDatosGenerales body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = "/datos-generales";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
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
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private okhttp3.Call creditreportValidateBeforeCall(String xApiKey, RequestDatosGenerales body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling creditreport(Async)");
        }
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling creditreport(Async)");
        }
        
        okhttp3.Call call = creditreportCall(xApiKey, body, progressListener, progressRequestListener);
        return call;
    }
    
    public ResponseGuardianDG creditreport(String xApiKey, RequestDatosGenerales body) throws ApiException {
        ApiResponse<ResponseGuardianDG> resp = creditreportWithHttpInfo(xApiKey, body);
        return resp.getData();
    }
    
    public ApiResponse<ResponseGuardianDG> creditreportWithHttpInfo(String xApiKey, RequestDatosGenerales body) throws ApiException {
        okhttp3.Call call = creditreportValidateBeforeCall(xApiKey, body, null, null);
        Type localVarReturnType = new TypeToken<ResponseGuardianDG>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    

}
