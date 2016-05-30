/**
 * File name: DeleteSurveyResponse
 * Author: Dorsey Q F TANG
 * Date: 5/28/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 *
 * Author: DORSEy
 */
public class DeleteSurveyResponse implements Resp {
    /**
     * The response status
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private RespStatus status;

    /**
     * Empty constructor of {@link DeleteSurveyResponse}
     */
    public DeleteSurveyResponse() {}

    public RespStatus getStatus() {
        return status;
    }

    public void setStatus(RespStatus status) {
        this.status = status;
    }
}
