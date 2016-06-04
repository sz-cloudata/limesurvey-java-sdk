/**
 * File name: GetSurveyPropertiesResponse Author: Dorsey Q F TANG Date: 6/2/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when {@link com.cloudata.survey.connector.LSurveyConstants#CMD_GET_SURVEY_PROPERTIES} command
 * is being sent.
 *
 * Author: DORSEy
 */
public class GetSurveyPropertiesResponse implements Resp {
    /**
     * The survey properties.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private SurveyProperties surveyProperties;

    public SurveyProperties getSurveyProperties() {
        return surveyProperties;
    }

    public void setSurveyProperties(final SurveyProperties surveyProperties) {
        this.surveyProperties = surveyProperties;
    }

    @Override
    public String toString() {
        return "properties: {" + surveyProperties + "}";
    }
}
