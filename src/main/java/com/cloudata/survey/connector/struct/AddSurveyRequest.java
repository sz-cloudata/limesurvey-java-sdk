/**
 * File name: AddSurveyRequest
 * Author: Dorsey Q F TANG
 * Date: 5/28/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * The request for adding survey.
 *
 * Author: DORSEy
 */
public class AddSurveyRequest extends ConnRequest {
    /**
     * The survey title.
     */
    private String surveyTitle;

    /**
     * The wished survey id. default being 0;
     */
    private int wishedSurveyId = 0;

    /**
     * The survey language.
     */
    private String surveyLanguage;

    /**
     * The survey format, three permitted ("A", "G", "S")
     */
    private String surveyFormat;

    /**
     * Empty constructor of {@link AddSurveyRequest}.
     */
    public AddSurveyRequest() {}

    /**
     * Constructor of {@link AddSurveyRequest}, with title, wished survey id, language and format specified.
     *
     * @param sessionKey the session key.
     * @param surveyTitle the survey title.
     * @param surveyLanguage the survey language, it can't be modified once its determined.
     * @param surveyFormat the format.
     */
    public AddSurveyRequest(final String sessionKey, final String surveyTitle, final String surveyLanguage, final SurveyFormat surveyFormat) {
        super(sessionKey);
        this.surveyTitle = surveyTitle;
        this.surveyLanguage = surveyLanguage;
        this.surveyFormat = surveyFormat.getVal();
    }

    public int getWishedSurveyId() {
        return wishedSurveyId;
    }

    public String getSurveyFormat() {
        return surveyFormat;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public String getSurveyLanguage() {
        return surveyLanguage;
    }

    public void setSurveyFormat(final String surveyFormat) {
        this.surveyFormat = surveyFormat;
    }

    public void setSurveyTitle(final String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public void setSurveyLanguage(final String surveyLanguage) {
        this.surveyLanguage = surveyLanguage;
    }

    public void setWishedSurveyId(final int wishedSurveyId) {
        this.wishedSurveyId = wishedSurveyId;
    }

    /**
     * Returns a Json like representation. Please note the order should be complied.
     * <strong>
     *     "sSessionKey":"$sessionKey", "iSurveyID": 1, "sSurveyTitle": "$surveyTitle", "sSurveyLanguage": "$surveyLanguage",
     *     "sformat": "$sFormat"
     * </strong>
     *
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"").append(LSurveyConstants.SERIALIZED_SESSION_KEY).append("\": \"").append(this.sessionKey);
        builder.append("\", \"").append(LSurveyConstants.SERIALIZED_WISHED_SURVEY_ID).append("\": ");
        builder.append((this.wishedSurveyId <= 0) ? null : this.wishedSurveyId).append(", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_SURVEY_TITLE).append("\": \"").append(this.surveyTitle);
        builder.append("\", \"").append(LSurveyConstants.SERIALIZED_SURVEY_LANGUAGE).append("\": \"").append(this.surveyLanguage);
        builder.append("\", \"").append(LSurveyConstants.SERIALIZED_SURVEY_FORMAT).append("\": \"").append(this.surveyFormat);
        builder.append("\"");

        return builder.toString();
    }
}
