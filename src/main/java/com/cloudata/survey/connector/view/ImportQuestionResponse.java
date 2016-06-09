/**
 * File name: ImportQuestionResponse Author: Dorsey Q F TANG Date: 6/8/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated after {@link com.cloudata.survey.connector.LSurveyConstants#CMD_IMPORT_QUESTION} was
 * performed on server side.
 *
 * Author: DORSEy
 */
public class ImportQuestionResponse implements Resp {
    /**
     * The question ID.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private int questionId;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Question: {questionId: " + questionId + "}";
    }
}
