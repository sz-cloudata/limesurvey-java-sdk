/**
 * File name: ActivateSurveyResponse Author: Dorsey Q F TANG Date: 5/31/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when command {@link LSurveyConstants#CMD_ACTIVATE_SURVEY} is being executed.
 *
 * Author: DORSEy
 */
public class ActivateSurveyResponse implements Resp {
    /**
     * The response status.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private RespStatus respStatus;

    /**
     * Empty constructor of {@link ActivateSurveyResponse}.
     */
    public ActivateSurveyResponse() {}

    public void setRespStatus(RespStatus respStatus) {
        this.respStatus = respStatus;
    }

    public RespStatus getRespStatus() {
        return respStatus;
    }

    @Override
    public String toString() {
        return "respStatus: " + respStatus;
    }
}
