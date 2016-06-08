/**
 * File name: SetSurveyPropertiesRequest Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.utils.StringUtils;

import java.util.Map;

/**
 * The request parameters being sent to set the survey properties when {@link com.cloudata.survey.connector.LSurveyConstants#CMD_SET_SURVEY_PROPERTIES}
 * is expected to be executed on server side.
 *
 * Author: DORSEy
 */
public class SetSurveyPropertiesRequest implements ReqParams {
    /**
     * The survey in session.
     */
    private SurveyInSession surveyInSession;

    /**
     * The survey data should be updated.
     */
    private Map<String, Object> surveyData;

    /**
     * Empty constructor of {@link SetSurveyPropertiesRequest}.
     */
    public SetSurveyPropertiesRequest() {}

    /**
     * Constructor of {@link SetSurveyPropertiesRequest}, with session key and survey ID specified.
     *
     * @param sessionKey the session key.
     * @param surveyId the survey ID.
     */
    public SetSurveyPropertiesRequest(final String sessionKey, final int surveyId) {
        this(sessionKey, surveyId, null);
    }

    /**
     * Constructor of {@link SetSurveyPropertiesRequest}, with session key, survey id and survey data specified.
     *
     * @param sessionKey the session key.
     * @param surveyId the survey id.
     * @param surveyData the survey data.
     */
    public SetSurveyPropertiesRequest(final String sessionKey, final int surveyId, final Map<String, Object> surveyData) {
        setSurveyInSession(sessionKey, surveyId);
        this.surveyData = surveyData;
    }

    public void setSurveyInSession(final String sessionKey, final int surveyId) {
        this.surveyInSession = new SurveyInSession(sessionKey, surveyId);
    }

    public SurveyInSession getSurveyInSession() {
        return surveyInSession;
    }

    public Map<String, Object> getSurveyData() {
        return surveyData;
    }

    public void setSurveyData(final Map<String, Object> surveyData) {
        this.surveyData = surveyData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"").append(LSurveyConstants.SERIALIZED_SESSION_KEY).append("\": \"");
        builder.append(surveyInSession.getSessionKey()).append("\", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_WISHED_SURVEY_ID).append("\": ");
        builder.append(surveyInSession.getSurveyId()).append(", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_ARR_SURVEY_DATA).append("\": ");
        builder.append(StringUtils.doubleQuoteEntriesIn(getSurveyData()));

        return builder.toString();
    }
}
