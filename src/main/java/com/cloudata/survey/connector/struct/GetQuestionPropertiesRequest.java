/**
 * File name: GetQuestionPropertiesRequest Author: Dorsey Q F TANG Date: 6/11/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.utils.StringUtils;

import java.util.List;

/**
 * The requested parameters should be sent accordingly if {@link LSurveyConstants#CMD_GET_QUESTION_PROPERTIES} should
 * be performed on server side.
 *
 * Author: DORSEy
 */
public class GetQuestionPropertiesRequest implements ReqParams {
    /**
     * Contains the session key, and question ID.
     */
    private QuestionInSession questionInSession;

    /**
     * The properties.
     */
    private List<String> properties;

    /**
     * Empty constructor of {@link GetQuestionPropertiesRequest}.
     */
    public GetQuestionPropertiesRequest() {}

    public GetQuestionPropertiesRequest(final String sessionKey, final int questionId, final List<String> properties) {
        setQuestionInSession(sessionKey, questionId);
        this.properties = properties;
    }

    public void setQuestionInSession(final String sessionKey, final int questionId) {
        this.questionInSession = new QuestionInSession(sessionKey, questionId);
    }

    public QuestionInSession getQuestionInSession() {
        return questionInSession;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(final List<String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return questionInSession.toString() + ", \"" + LSurveyConstants.SERIALIZED_QUESTION_SETTINGS + "\": " +
                StringUtils.doubleQuoteStringIn(properties);
    }
}
