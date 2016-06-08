/**
 * File name: ImportQuestionRequest Author: Dorsey Q F TANG Date: 6/8/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * The request parameters should be sent accordingly if {@link com.cloudata.survey.connector.LSurveyConstants#CMD_IMPORT_QUESTION}
 * should be performed.
 *
 * Author: DORSEy
 */
public class ImportQuestionRequest implements ReqParams {
    /**
     * Specifies the session key, survey ID and group ID.
     */
    private SurveyGroupInSession surveyGroupInSession;

    /**
     * The data of the question being imported to.
     */
    private String importData;

    /**
     * The data type allowed to import the question.
     */
    private AllowedQuestionImportDataType importDataType;

    /**
     * Whether this question is mandatory or not.
     */
    private boolean mandatory;

    /**
     * Empty constructor of {@link ImportQuestionRequest}.
     */
    public ImportQuestionRequest() {}

    /**
     * Constructor of {@link ImportQuestionRequest}, with session key, survey id, group id, import data,
     * import data type and mandatory specified.
     *
     * @param sessionKey the session key.
     * @param surveyId the survey id.
     * @param groupId the group id.
     * @param importData the import data.
     * @param importDataType the import data type.
     * @param mandatory mandatory.
     */
    public ImportQuestionRequest(final String sessionKey, final int surveyId, final int groupId, final String importData, final AllowedQuestionImportDataType
                                 importDataType, final boolean mandatory) {
        setSurveyGroupInSession(sessionKey, surveyId, groupId);
        this.importData = importData;
        this.importDataType = importDataType;
        this.mandatory = mandatory;
    }

    public void setSurveyGroupInSession(final String sessionKey, final int surveyId, final int groupId) {
        this.surveyGroupInSession = new SurveyGroupInSession(sessionKey, surveyId, groupId);
    }

    public SurveyGroupInSession getSurveyGroupInSession() {
        return surveyGroupInSession;
    }

    public String getImportData() {
        return importData;
    }

    public void setImportData(String importData) {
        this.importData = importData;
    }

    public AllowedQuestionImportDataType getImportDataType() {
        return importDataType;
    }

    public void setImportDataType(AllowedQuestionImportDataType importDataType) {
        this.importDataType = importDataType;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(surveyGroupInSession.toString()).append(", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_QUESTION_IMPORT_DATA).append("\": ");
        builder.append("\"").append(importData).append("\", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_QUESTION_IMPORT_DATA_TYPE).append("\": ");
        builder.append("\"").append(importDataType.getDataType()).append("\", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_MANDATORY).append("\": ");
        builder.append("\"").append((mandatory ? "Y" : "N")).append("\"");

        return builder.toString();
    }
}
