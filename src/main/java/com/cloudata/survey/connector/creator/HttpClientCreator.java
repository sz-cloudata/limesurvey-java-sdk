/**
 * File name: HttpClientCreator
 * Author: Dorsey Q F TANG
 * Date: 5/27/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.creator;


import org.apache.http.client.HttpClient;

/**
 *
 * Author: DORSEy
 */
public interface HttpClientCreator {

    /**
     * Returns an instance of {@link HttpClient}.
     *
     * @return an instance of {@link HttpClient}.
     */
    public HttpClient createHttpClient();
}
