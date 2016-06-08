/**
 * File name: AllowedQuestionImportDataType Author: Dorsey Q F TANG Date: 6/8/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

/**
 * An enumeration which enumerates the allowed import data type for question.
 *
 * Author: DORSEy
 */
public enum AllowedQuestionImportDataType {
    QUESTION_LSQ("lsq"),
    QUESTION_CSV("csv");

    private String dataType;

    /**
     * Constructor of {@link AllowedQuestionImportDataType}, with data type specified.
     *
     * @param dataType the data type.
     */
    AllowedQuestionImportDataType(final String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
