/**
 * File name: AddGroupResponse Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when {@link LSurveyConstants#CMD_ADD_GROUP} is executed.
 *
 * Author: DORSEy
 */
public class AddGroupResponse implements Resp {
    /**
     * The group ID.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private int groupId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "group ID: " + groupId;
    }
}
