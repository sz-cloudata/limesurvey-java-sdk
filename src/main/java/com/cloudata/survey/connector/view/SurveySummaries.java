/**
 * File name: SurveySummaries Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The statistics of the survey.
 *
 * Author: DORSEy
 */
public class SurveySummaries implements Resp {
    /**
     * The token count.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_TOKEN_COUNT)
    private int tokenCount;

    /**
     * The invalid tokens.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_TOKEN_INVALID)
    private int invalidTokens;

    /**
     * The token sent.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_TOKEN_SENT)
    private int sentTokens;

    @SerializedName(LSurveyConstants.SERIALIZED_TOKEN_OPTED_OUT)
    private int optedOutTokens;

    /**
     * The completed tokens.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_TOKEN_COMPLETED)
    private int completedTokens;

    /**
     * The completed responses.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_COMPLETED_RESPONSES)
    private int completedResponses;

    /**
     * The in-completed responses.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_INCOMPLETED_RESPONSES)
    private int incompletedResponses;

    /**
     * The full responses.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_FULL_RESPONSES)
    private int fullResponses;

    public int getTokenCount() {
        return tokenCount;
    }

    public void setTokenCount(int tokenCount) {
        this.tokenCount = tokenCount;
    }

    public int getInvalidTokens() {
        return invalidTokens;
    }

    public void setInvalidTokens(int invalidTokens) {
        this.invalidTokens = invalidTokens;
    }

    public int getSentTokens() {
        return sentTokens;
    }

    public void setSentTokens(int sentTokens) {
        this.sentTokens = sentTokens;
    }

    public int getOptedOutTokens() {
        return optedOutTokens;
    }

    public void setOptedOutTokens(int optedOutTokens) {
        this.optedOutTokens = optedOutTokens;
    }

    public int getCompletedTokens() {
        return completedTokens;
    }

    public void setCompletedTokens(int completedTokens) {
        this.completedTokens = completedTokens;
    }

    public int getCompletedResponses() {
        return completedResponses;
    }

    public void setCompletedResponses(int completedResponses) {
        this.completedResponses = completedResponses;
    }

    public int getIncompletedResponses() {
        return incompletedResponses;
    }

    public void setIncompletedResponses(int incompletedResponses) {
        this.incompletedResponses = incompletedResponses;
    }

    public int getFullResponses() {
        return fullResponses;
    }

    public void setFullResponses(int fullResponses) {
        this.fullResponses = fullResponses;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("tokenCount: ").append(tokenCount + ", ");
        builder.append("tokenInvalid: ").append(invalidTokens + ", ");
        builder.append("tokenSent: ").append(sentTokens + ", ");
        builder.append("tokenOptedOut: ").append(optedOutTokens + ", ");
        builder.append("completedResponses: ").append(completedResponses + ", ");
        builder.append("incompletedResponses: ").append(incompletedResponses + ", ");
        builder.append("fullResponses: ").append(fullResponses);

        return builder.toString();
    }
}
