/**
 * File name: RespStatus
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
public class RespStatus implements Resp {
    /**
     * The status to indicates whether it's ok or not.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_STATUS)
    private String status;

    /**
     * Empty constructor of {@link RespStatus}.
     */
    public RespStatus() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
