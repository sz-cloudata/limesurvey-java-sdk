/**
 * File name: SurveyResponseDetails
 * Author: Dorsey Q F TANG
 * Date: 5/30/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The survey details.
 * <p>
 * Author: DORSEy
 */
public class SurveyResponseDetails implements Resp {
    /**
     * The survey ID.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_LIST_SURVEY_ID)
    private String surveyId;

    /**
     * The survey title.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_LIST_SURVEY_TITLE)
    private String surveyTitle;

    /**
     * The start date of this survey.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_START_DATE)
    private String startDate;

    /**
     * The date when this survey expired.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_EXPIRES)
    private String expires;

    /**
     * Indicates whether the survey is activated or not. Y for yes, N for no.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_ACTIVATE)
    private String activate;

    /**
     * Empty constructor of {@link SurveyResponseDetails}.
     */
    public SurveyResponseDetails() {
    }

    public String getActivate() {
        return activate;
    }

    public void setActivate(String activate) {
        this.activate = activate;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "surveyId: " + surveyId + ", surveyTitle: " +
                surveyTitle + ", startDate: " + startDate + ", expires: " + expires + ", activate: " + activate;
    }
}
