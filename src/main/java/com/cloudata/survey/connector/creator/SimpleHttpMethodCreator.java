/**
 * File name: SimpleHttpMethodCreator
 * Author: Dorsey Q F TANG
 * Date: 5/27/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.creator;

import com.cloudata.survey.connector.LSurveyConstants;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

/**
 * The simple implementation of {@link HttpMethodCreator}.
 *
 * Author: DORSEy
 */
public class SimpleHttpMethodCreator implements HttpMethodCreator {

    /**
     * Return an instance of {@link HttpPost}, with its Content-type as application/json in header
     * and the entity specified.
     *
     * @param uri the uri.
     * @param entity the entity.
     * @return an instance of {@link HttpPost}.
     */
    public HttpPost createHttpPost(final String uri, final StringEntity entity) {
        HttpPost post =  new HttpPost(uri);
        post.setHeader(LSurveyConstants.HTTP_HEADER_CONTENT_TYPE, LSurveyConstants.HTTP_HEADER_CONTENT_TYPE_JSON);
        post.setHeader(LSurveyConstants.HTTP_HEADER_CONNECTION, LSurveyConstants.HTTP_HEADER_CONNECTION_KEEP_ALIVE);
        post.setEntity(entity);

        return post;
    }
}
