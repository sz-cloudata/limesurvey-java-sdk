/**
 * File name: LimeSurveyManager
 * Author: Dorsey Q F TANG
 * Date: 5/27/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.utils;

import com.cloudata.survey.connector.callback.ProcessResultCallback;
import com.cloudata.survey.connector.context.JsonResultMapper;
import com.cloudata.survey.connector.creator.HttpClientCreator;
import com.cloudata.survey.connector.creator.HttpMethodCreator;
import com.cloudata.survey.connector.creator.LSurveyRequestCreator;
import com.cloudata.survey.connector.struct.LSurveyRequest;
import com.cloudata.survey.connector.view.Resp;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * The utility class which is used to interact with lime survey.
 * <p>
 * Author: DORSEy
 */
public class LimeSurveyManager {
    /**
     * The exception.
     */
    private Exception exception;

    /**
     * The client creator.
     */
    private HttpClientCreator clientCreator;

    /**
     * The method creator.
     */
    private HttpMethodCreator methodCreator;

    /**
     * The uri.
     */
    private String uri;

    /**
     * Execute the request created by the given request creator, and populate the result to the object with type as <code>expected</code>.
     *
     * @param requestCreator the request creator.
     * @param expected       the object with type as expected.
     * @param <T>            the type of the object be returned.
     * @return the object.
     */
    public <T extends Resp> T execute(final LSurveyRequestCreator requestCreator, final Class<T> expected) {
        if (requestCreator == null || expected == null) {
            throw new IllegalArgumentException("requestCreator | expected is null");
        }

        T resp = null;
        HttpClient client = clientCreator.createHttpClient();
        LSurveyRequest request = requestCreator.create();
        try {
            StringEntity entity = request.toEntity();
            HttpPost post = methodCreator.createHttpPost(uri, entity);
            HttpResponse response = client.execute(post);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                HttpEntity httpEntity = response.getEntity();
                String json = EntityUtils.toString(httpEntity);
                resp = JsonResultMapper.map(json, expected);
            }

        } catch (IOException e) {
            exception = e;
            resp = null;
        }

        return resp;
    }

    public <T> T execute(final LSurveyRequestCreator requestCreator, final ProcessResultCallback<T> callback) {
        if (requestCreator == null || callback == null) {
            throw new IllegalArgumentException("request creator | callback should not be null");
        }

        T resp = null;
        HttpClient client = clientCreator.createHttpClient();
        LSurveyRequest request = requestCreator.create();
        try {
            StringEntity entity = request.toEntity();
            HttpPost post = methodCreator.createHttpPost(uri, entity);
            HttpResponse response = client.execute(post);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                HttpEntity httpEntity = response.getEntity();
                String json = EntityUtils.toString(httpEntity);

                resp = callback.doWithResult(json);
            }
        } catch (IOException e) {
            exception = e;
            resp = null;
        }

        return resp;
    }

    public Exception getException() {
        return exception;
    }

    public void setClientCreator(HttpClientCreator clientCreator) {
        this.clientCreator = clientCreator;
    }

    public void setMethodCreator(HttpMethodCreator methodCreator) {
        this.methodCreator = methodCreator;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
