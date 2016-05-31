/**
 * File name: DeleteSurveyRequest
 * Author: Dorsey Q F TANG
 * Date: 5/28/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

/**
 * A request is being sent to delete the survey identified by {@link DeleteSurveyRequest#surveyInSession}.
 *
 * Author: DORSEy
 */
public class DeleteSurveyRequest implements ReqParams {
    /**
     * The survey in session, with session key and survey ID specified.
     */
    private SurveyInSession surveyInSession;

    /**
     * Empty constructor of {@link DeleteSurveyRequest}.
     */
    public DeleteSurveyRequest() {}

    /**
     * Constructor of {@link DeleteSurveyRequest}, with session key and survey id specified.
     * @param sessionKey the session key.
     * @param surveyId the survey id.
     */
    public DeleteSurveyRequest(final String sessionKey, final int surveyId) {
        setSurveyInSession(new SurveyInSession(sessionKey, surveyId));
    }

    public void setSurveyInSession(final SurveyInSession surveyInSession) {
        this.surveyInSession = surveyInSession;
    }

    public SurveyInSession getSurveyInSession() {
        return surveyInSession;
    }

    /**
     * Returns a Json like representation. Please note the order.
     * <strong>
     *     "sSessionKey": "$sessionKey", "iSurveyID": $surveyID
     * </strong>
     *
     * @return
     */
    public String toString() {
        return (this.surveyInSession == null ? null : this.surveyInSession.toString());
    }
}
