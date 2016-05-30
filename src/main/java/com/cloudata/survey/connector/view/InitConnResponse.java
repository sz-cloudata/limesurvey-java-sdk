/**
 * File name: InitConnResponse
 * Author: Dorsey Q F TANG
 * Date: 5/27/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response responded when initialize connction between client and server.
 *
 * Author: DORSEy
 */
public class InitConnResponse implements Resp {
    /**
     * The session key generated.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private String sessionKey;

    /**
     * Empty constructor of {@link InitConnResponse}.
     */
    public InitConnResponse() {}

    /**
     * Constructor of {@link InitConnResponse}, with session key specified.
     *
     * @param sessionKey the session key.
     */
    public InitConnResponse(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

}
