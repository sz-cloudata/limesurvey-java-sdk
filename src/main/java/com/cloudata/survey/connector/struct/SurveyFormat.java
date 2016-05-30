/**
 * File name: SurveyFormat
 * Author: Dorsey Q F TANG
 * Date: 5/28/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

/**
 * An enumeration to enumerate permitted survey formats.
 *
 * Author: DORSEy
 */
public enum SurveyFormat {
    A_FORMAT("A"),
    G_FORMAT("G"),
    S_FORMAT("S");

    private String val;

    private SurveyFormat(final String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
