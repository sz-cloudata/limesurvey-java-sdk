/**
 * File name: ListQuestionsResponse Author: Dorsey Q F TANG Date: 6/10/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The response generated when {@link LSurveyConstants#CMD_LIST_QUESTIONS} was performed on the server side.
 *
 * Author: DORSEy
 */
public class ListQuestionsResponse implements Resp {
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private List<QuestionResponseDetails> details;

    public List<QuestionResponseDetails> getDetails() {
        return details;
    }

    public void setDetails(List<QuestionResponseDetails> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "details: " + details;
    }
}
