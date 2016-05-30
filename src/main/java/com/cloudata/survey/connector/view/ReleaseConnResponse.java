/**
 * File name: ReleaseConnResponse Author: Dorsey Q F TANG Date: 5/29/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response used to represent whether the release operation is succeed.
 *
 * Author: DORSEy
 */
public class ReleaseConnResponse implements Resp {
    /**
     * The status of result. OK represents fine, otherwise false.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private String status;

    /**
     * Empty constructor of {@link ReleaseConnResponse}.
     */
    public ReleaseConnResponse() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "status: " + status;
    }
}
