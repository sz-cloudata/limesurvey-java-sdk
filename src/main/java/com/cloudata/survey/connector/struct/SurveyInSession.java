/**
 * File name: SurveyInSession Author: Dorsey Q F TANG Date: 5/31/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * A comprised key, the <code>sessionKey</code> and <code>surveyId</code>.
 *
 * Author: DORSEy
 */
public class SurveyInSession extends ConnRequest {
    /**
     * The survey ID.
     */
    protected int surveyId = 0;

    /**
     * Empty constructor of {@link SurveyInSession}.
     */
    public SurveyInSession() {}

    /**
     * Constructor of {@link SurveyInSession}, with session key and survey id specified.
     *
     * @param sessionKey the session key.
     * @param surveyId the survey id.
     */
    public SurveyInSession(final String sessionKey, final int surveyId) {
        super(sessionKey);
        this.surveyId = surveyId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    /**
     * Returns a Json like representation. Please note the order:
     * <strong>
     *     "sSessionKey": "$sessionKey", "iSurveyID": 123
     * </strong>
     *
     * @return a Json like representation.
     */
    public String toString() {
        return "\"" + LSurveyConstants.SERIALIZED_SESSION_KEY + "\": \"" + sessionKey + "\"" +
                ((surveyId <= 0) ? "" : ", \"" + LSurveyConstants.SERIALIZED_WISHED_SURVEY_ID + "\": " + surveyId);
    }
}
