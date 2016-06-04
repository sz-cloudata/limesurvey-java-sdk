/**
 * File name: GetSurveyPropertiesRequest Author: Dorsey Q F TANG Date: 6/2/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.utils.StringUtils;

import java.util.List;

/**
 * The request parameters that associated with when {@link com.cloudata.survey.connector.LSurveyConstants#CMD_GET_SURVEY_PROPERTIES} is sent.
 *
 * Author: DORSEy
 */
public class GetSurveyPropertiesRequest implements ReqParams {
    /**
     * The survey in session.
     */
    private SurveyInSession surveyInSession;

    /**
     * The survey settings.
     */
    private List<String> surveySettings;

    /**
     * Empty constructor of {@link GetSurveyPropertiesRequest}.
     */
    public GetSurveyPropertiesRequest() {}

    /**
     * Constructor of {@link GetSurveyPropertiesRequest}, with session key, survey id and survey settings specified.
     *
     * @param sessionKey the session key.
     * @param surveyId the survey id.
     * @param surveySettings the survey settings.
     */
    public GetSurveyPropertiesRequest(final String sessionKey, final int surveyId, final List<String> surveySettings) {
        setSurveyInSession(sessionKey, surveyId);
        this.surveySettings = surveySettings;
    }

    public void setSurveyInSession(final String sessionKey, final int surveyId) {
        this.surveyInSession = new SurveyInSession(sessionKey, surveyId);
    }

    public SurveyInSession getSurveyInSession() {
        return surveyInSession;
    }

    public List<String> getSurveySettings() {
        return surveySettings;
    }

    public void setSurveySettings(final List<String> surveySettings) {
        this.surveySettings = surveySettings;
    }

    @Override
    public String toString() {
        return "\"" + LSurveyConstants.SERIALIZED_SESSION_KEY + "\": \"" + surveyInSession.getSessionKey() + "\"" +
                ", \"" + LSurveyConstants.SERIALIZED_WISHED_SURVEY_ID + "\": " + surveyInSession.getSurveyId() +
                ", \"" + LSurveyConstants.SERIALIZED_SURVEY_SETTINGS + "\": " + StringUtils.doubleQuoteStringIn(getSurveySettings());
    }
}
