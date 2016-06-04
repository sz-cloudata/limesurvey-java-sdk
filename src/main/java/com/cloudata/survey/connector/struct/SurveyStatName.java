/**
 * File name: SurveyStatName Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

/**
 * An enumeration which enumerate all allowed stat name.
 *
 * Author: DORSEy
 */
public enum SurveyStatName {
    TOKEN_COUNT("token_count"),
    TOKEN_INVALID("token_invalid"),
    TOKEN_SENT("token_sent"),
    TOKEN_OPTED_OUT("token_opted_out"),
    TOKEN_COMPLETED("token_completed"),
    COMPLATED_RESPONSES("completed_responses"),
    INCOMPLETE_RESPONSES("incomplete_responses"),
    FULL_RESPONSES("full_responses"),
    ALL("all");

    private String val;

    SurveyStatName(final String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
