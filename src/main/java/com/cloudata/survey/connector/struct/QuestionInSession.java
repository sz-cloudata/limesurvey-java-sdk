/**
 * File name: QuestionInSession Author: Dorsey Q F TANG Date: 6/9/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 *
 * Author: DORSEy
 */
public class QuestionInSession extends ConnRequest {
    /**
     * The question id.
     */
    protected int questionId;

    /**
     * Empty constructor of {@link QuestionInSession}.
     */
    public QuestionInSession() {}

    /**
     * Constructor of {@link QuestionInSession}, with session key and question ID specified.
     *
     * @param sessionKey the session key.
     * @param questionId the question id.
     */
    public QuestionInSession(final String sessionKey, final int questionId) {
        super(sessionKey);
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return super.toString() + ", \"" + LSurveyConstants.SERIALIZED_QUESTION_ID + "\": " + questionId;
    }
}
