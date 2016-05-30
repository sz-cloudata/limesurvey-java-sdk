/**
 * File name: ListSurveysRequest Author: Dorsey Q F TANG Date: 5/30/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * The request sent to list all surveys being created by the {@link ListSurveysRequest#surveyCreator}.
 * <p>
 * Author: DORSEy
 */
public class ListSurveysRequest extends ConnRequest {
    /**
     * The creator of the surveys.
     */
    private String surveyCreator = null;

    /**
     * Empty constructor of {@link ListSurveysRequest}.
     */
    public ListSurveysRequest() {
    }

    /**
     * Constructor of {@link ListSurveysRequest}, with session key specified.
     *
     * @param sessionKey the session key.
     */
    public ListSurveysRequest(final String sessionKey) {
        super(sessionKey);
    }

    /**
     * Constructor of {@link ListSurveysRequest}, with session key and creator specified.
     *
     * @param sessionKey    the session key.
     * @param surveyCreator the owner of the surveys being listed.
     */
    public ListSurveysRequest(final String sessionKey, final String surveyCreator) {
        this(sessionKey);
        this.surveyCreator = surveyCreator;
    }

    public String getSurveyCreator() {
        return surveyCreator;
    }

    public void setSurveyCreator(String surveyCreator) {
        this.surveyCreator = surveyCreator;
    }

    @Override
    public String toString() {
        return "\"" + LSurveyConstants.SERIALIZED_SESSION_KEY + "\": \"" + sessionKey + "\"" +
                ((surveyCreator == null || surveyCreator.isEmpty()) ? "" : ", \"" + LSurveyConstants.SERIALIZED_SURVEY_CREATOR + "\": \"" +
                        this.surveyCreator + "\"");
    }
}
