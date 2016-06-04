/**
 * File name: ListGroupsResponse Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 * Author: DORSEy
 */
public class ListGroupsResponse implements Resp {
    /**
     * A list of groups
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private List<GroupResponseDetails> groupDetails;

    public List<GroupResponseDetails> getGroupDetails() {
        return groupDetails;
    }

    public void setGroupDetails(final List<GroupResponseDetails> groupDetails) {
        this.groupDetails = groupDetails;
    }

    @Override
    public String toString() {
        return "groupDetails: " + groupDetails;
    }
}
