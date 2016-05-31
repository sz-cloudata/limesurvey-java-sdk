/**
 * File name: ActivateSurveyRequest Author: Dorsey Q F TANG Date: 5/31/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

/**
 * A request is being sent to activate the survey specified.
 *
 * Author: DORSEy
 */
public class ActivateSurveyRequest implements ReqParams {
    /**
     * Contains the survey ID and the current session identified by session ID.
     */
    private SurveyInSession surveyInSession;

    /**
     * Empty constructor of {@link ActivateSurveyRequest}.
     */
    public ActivateSurveyRequest() {}

    /**
     * Constructor of {@link ActivateSurveyRequest}, with session key and survey ID specified.
     *
     * @param sessionKey the session key.
     * @param surveyId the survey ID.
     */
    public ActivateSurveyRequest(final String sessionKey, final int surveyId) {
        setSurveyInSession(new SurveyInSession(sessionKey, surveyId));
    }

    public void setSurveyInSession(final SurveyInSession surveyInSession) {
        this.surveyInSession = surveyInSession;
    }

    public SurveyInSession getSurveyInSession() {
        return surveyInSession;
    }

    @Override
    public String toString() {
        return (this.surveyInSession == null ? null : this.surveyInSession.toString());
    }
}
