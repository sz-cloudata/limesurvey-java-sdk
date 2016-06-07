/**
 * File name: GroupInSession Author: Dorsey Q F TANG Date: 6/7/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * Container, which contains only session key and group ID as its elements for request parameters.
 *
 * Author: DORSEy
 */
public class GroupInSession extends ConnRequest {
    /**
     * The group ID.
     */
    protected int groupId;

    /**
     * Empty constructor of {@link GroupInSession}.
     */
    public GroupInSession() {}

    /**
     * Constructor of {@link GroupInSession}, with session key, and group ID specified.
     *
     * @param sessionKey the session key.
     * @param groupId the group id.
     */
    public GroupInSession(final String sessionKey, final int groupId) {
        super(sessionKey);
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "\"" + LSurveyConstants.SERIALIZED_SESSION_KEY + "\": \"" + this.getSessionKey() + "\", \"" +
                LSurveyConstants.SERIALIZED_GROUP_ID + "\": " + groupId;
    }
}
