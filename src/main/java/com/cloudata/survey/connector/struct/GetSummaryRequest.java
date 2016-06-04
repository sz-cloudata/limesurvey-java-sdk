/**
 * File name: GetSummaryRequest Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * The requested parameters should be sent accordingly if command {@link LSurveyConstants#CMD_GET_SUMMARY} should
 * be performed on server side.
 *
 * Author: DORSEy
 */
public class GetSummaryRequest implements ReqParams {
    /**
     * The survey in session.
     */
    private SurveyInSession surveyInSession;

    /**
     * The stat name.
     */
    private SurveyStatName statName;

    /**
     * Empty constructor of {@link GetSummaryRequest}.
     */
    public GetSummaryRequest() {}

    public GetSummaryRequest(final String sessionKey, final int surveyId, final SurveyStatName statName) {
        setSurveyInSession(sessionKey, surveyId);
        this.statName = statName;
    }

    public void setSurveyInSession(final String sessionKey, final int surveyId) {
        this.surveyInSession = new SurveyInSession(sessionKey, surveyId);
    }

    public SurveyInSession getSurveyInSession() {
        return surveyInSession;
    }

    public SurveyStatName getStatName() {
        return statName;
    }

    public void setStatName(final SurveyStatName statName) {
        this.statName = statName;
    }

    /**
     * The requested parameters used to get all summaries.
     *
     * @param sessionKey the session key.
     * @param surveyId the survey id.
     * @return the request parameters used to get all survey summaries.
     */
    public static GetSummaryRequest getAllSummariesRequest(final String sessionKey, final int surveyId) {
        return new GetSummaryRequest(sessionKey, surveyId, SurveyStatName.ALL);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"").append(LSurveyConstants.SERIALIZED_SESSION_KEY).append("\": ");
        builder.append("\"").append(surveyInSession.getSessionKey()).append("\", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_WISHED_SURVEY_ID).append("\": ");
        builder.append(surveyInSession.getSurveyId()).append(", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_STAT_NAME).append("\": ");
        builder.append("\"").append(statName.getVal()).append("\"");

        return builder.toString();
    }
}
