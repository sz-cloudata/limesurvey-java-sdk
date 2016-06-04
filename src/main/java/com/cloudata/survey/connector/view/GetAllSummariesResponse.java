/**
 * File name: GetAllSummariesResponse Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when {@link com.cloudata.survey.connector.LSurveyConstants#CMD_GET_SUMMARY} is being sent.
 *
 * Author: DORSEy
 */
public class GetAllSummariesResponse implements Resp {
    /**
     * The survey statistics.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private SurveySummaries statistics;

    public SurveySummaries getStatistics() {
        return statistics;
    }

    public void setStatistics(SurveySummaries statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "statistics: {" + statistics + "}";
    }
}
