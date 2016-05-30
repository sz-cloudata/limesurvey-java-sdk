/**
 * File name: HttpMethodCreator
 * Author: Dorsey Q F TANG
 * Date: 5/27/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.creator;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

/**
 * The interface used to create an instance of Http method, such as Http Post.
 *
 * Author: DORSEy
 */
public interface HttpMethodCreator {

    /**
     * Returns an instance of {@link HttpPost}, with uri and request parameters specified.
     *
     * @param uri the uri.
     * @param entity the entity.
     * @return an instance of HttpPost.
     */
    public HttpPost createHttpPost(final String uri, final StringEntity entity);
}
