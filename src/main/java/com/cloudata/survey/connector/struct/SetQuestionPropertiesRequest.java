/**
 * File name: SetQuestionPropertiesRequest Author: Dorsey Q F TANG Date: 6/11/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.utils.StringUtils;

import java.util.Map;

/**
 * The requested parameters being sent accordingly if {@link LSurveyConstants#CMD_SET_QUESTION_PROPERTIES} should
 * be performed on server side.
 *
 * Author: DORSEy
 */
public class SetQuestionPropertiesRequest implements ReqParams {
    /**
     * Contains the session key and question ID.
     */
    private QuestionInSession questionInSession;

    /**
     * The map which contains the properties to be set and its associated values.
     */
    private Map<String, Object> questionData;

    /**
     * Empty constructor of {@link SetQuestionPropertiesRequest}.
     */
    public SetQuestionPropertiesRequest() {}

    /**
     * Constructor of {@link SetQuestionPropertiesRequest}, with session key, question ID and question data specified.
     *
     * @param sessionKey the session key.
     * @param questionId the question ID.
     * @param questionData the question data.
     */
    public SetQuestionPropertiesRequest(final String sessionKey, final int questionId, final Map<String, Object> questionData) {
        setQuestionInSession(sessionKey, questionId);
        this.questionData = questionData;
    }

    public void setQuestionInSession(final String sessionKey, final int questionId) {
        this.questionInSession = new QuestionInSession(sessionKey, questionId);
    }

    public QuestionInSession getQuestionInSession() {
        return questionInSession;
    }

    public Map<String, Object> getQuestionData() {
        return questionData;
    }

    public void setQuestionData(final Map<String, Object> questionData) {
        this.questionData = questionData;
    }

    @Override
    public String toString() {
        return questionInSession.toString() + ", \"" + LSurveyConstants.SERIALIZED_QUESTION_DATA + "\": " +
                StringUtils.doubleQuoteEntriesIn(questionData);
    }
}
