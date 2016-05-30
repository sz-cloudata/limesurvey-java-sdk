/**
 * File name: DeleteSurveyRequest
 * Author: Dorsey Q F TANG
 * Date: 5/28/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 *
 * Author: DORSEy
 */
public class DeleteSurveyRequest extends ConnRequest {
    /**
     * The id of survey to be removed.
     */
    private long surveyId;

    /**
     * Empty constructor of {@link DeleteSurveyRequest}.
     */
    public DeleteSurveyRequest() {}

    /**
     * Constructor of {@link DeleteSurveyRequest}, with session key and survey id specified.
     * @param sessionKey the session key.
     * @param surveyId the survey id.
     */
    public DeleteSurveyRequest(final String sessionKey, final long surveyId) {
        super(sessionKey);
        this.surveyId = surveyId;
    }

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
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
        return "\"" + LSurveyConstants.SERIALIZED_SESSION_KEY + "\": \"" + sessionKey + "\", "
                + "\"" + LSurveyConstants.SERIALIZED_WISHED_SURVEY_ID + "\": " + surveyId;
    }
}
