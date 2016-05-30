/**
 * File name: SimpleHttpClientCreator
 * Author: Dorsey Q F TANG
 * Date: 5/27/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.creator;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Simple implementation of {@link HttpClientCreator}.
 *
 * Author: DORSEy
 */
public class SimpleHttpClientCreator implements HttpClientCreator {

    /**
     * The simplest implementation of creating an instance of Http client.
     *
     * @return
     */
    public HttpClient createHttpClient() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        HttpClient client =  builder.build();

        return client;
    }
}
