/**
 * File name: GetGroupPropertiesResponse Author: Dorsey Q F TANG Date: 6/7/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when {@link LSurveyConstants#CMD_GET_GROUP_PROPERTIES} is being sent.
 *
 * Author: DORSEy
 */
public class GetGroupPropertiesResponse implements Resp {
    /**
     * The group properties.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private GroupResponseDetails groupProperties;

    public GroupResponseDetails getGroupProperties() {
        return groupProperties;
    }

    public void setGroupProperties(final GroupResponseDetails groupProperties) {
        this.groupProperties = groupProperties;
    }

    @Override
    public String toString() {
        return "Group properties: " + groupProperties + "";
    }
}
