/**
 * File name: SurveyProperties Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Represents the properties of the survey being searched.
 * <p>
 *     The details should be checked at the prefix_surveys table.
 * </p>
 *
 * Author: DORSEy
 */
public class SurveyProperties implements Serializable {
    /**
     * The survey ID.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_LIST_SURVEY_ID)
    private int surveyId;

    /**
     * The owner ID.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_OWNER_ID)
    private int ownerId;

    /**
     * The administrator.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_ADMIN)
    private String admin;

    /**
     * status of survey, active or not.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_ACTIVATE)
    private String active;

    /**
     * The date time of expiry.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_EXPIRES)
    private String expires;

    /**
     * The start date of survey.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_START_DATE)
    private String startDate;

    /**
     * The email of admin.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_ADMIN_EMAIL)
    private String adminEmail;

    /**
     * anonymized or not.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_ANONYMIZED)
    private String anonymized;

    /**
     * The person fax to.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_FAX_TO)
    private String faxTo;

    /**
     * The format.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_FORMAT)
    private String format;

    /**
     * The template.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_SURVEY_TEMPLATE)
    private String template;

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(final int surveyId) {
        this.surveyId = surveyId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final int ownerId) {
        this.ownerId = ownerId;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(final String admin) {
        this.admin = admin;
    }

    public String getActive() {
        return active;
    }

    public void setActive(final String active) {
        this.active = active;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(final String expires) {
        this.expires = expires;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(final String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAnonymized() {
        return anonymized;
    }

    public void setAnonymized(final String anonymized) {
        this.anonymized = anonymized;
    }

    public String getFaxTo() {
        return faxTo;
    }

    public void setFaxTo(final String faxTo) {
        this.faxTo = faxTo;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(final String format) {
        this.format = format;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(final String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(LSurveyConstants.SERIALIZED_LIST_SURVEY_ID).append(": ").append(this.surveyId);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_OWNER_ID).append(": " + this.ownerId);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_ADMIN).append(": " + admin);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_ACTIVATE).append(": " + active);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_EXPIRES).append(": " + expires);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_START_DATE).append(": " + startDate);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_ADMIN_EMAIL).append(": " + adminEmail);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_ANONYMIZED).append(": " + anonymized);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_FAX_TO).append(": " + faxTo);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_FORMAT).append(": " + format);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_SURVEY_TEMPLATE).append(": " + template);

        return builder.toString();
    }
}
