/**
 * File name: ConnRequest
 * Author: Dorsey Q F TANG
 * Date: 5/28/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * Container which contains only the session key for closing or performing certain actions with the connection.
 *
 * Author: DORSEy
 */
public class ConnRequest implements ReqParams {

    /**
     * The session key.
     */
    protected String sessionKey;

    /**
     * Empty constructor of {@link ConnRequest}.
     */
    public ConnRequest() {}

    public ConnRequest(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * Returns a Json like representation. Please note the order.
     *
     * <strong>
     *     "sSessionKey": "$sessionKey"
     * </strong>
     *
     */
    public String toString() {
        return "\"" + LSurveyConstants.SERIALIZED_SESSION_KEY + "\": \"" + this.sessionKey + "\"";
    }
}
