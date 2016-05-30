/**
 * File name: ListSurveysResponse Author: Dorsey Q F TANG Date: 5/30/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.struct.ListSurveysRequest;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The response generated when {@link ListSurveysRequest} is sent.
 *
 * Author: DORSEy
 */
public class ListSurveysResponse implements Resp {
    /**
     * The details of the surveys.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private List<SurveyResponseDetails> details;

    /**
     * Empty constructor of {@link ListSurveysResponse}.
     */
    public ListSurveysResponse() {}

    public List<SurveyResponseDetails> getDetails() {
        return details;
    }

    public void setDetails(List<SurveyResponseDetails> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "details: " + details;
    }
}
