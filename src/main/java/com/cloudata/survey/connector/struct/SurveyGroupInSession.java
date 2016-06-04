/**
 * File name: SurveyGroupInSession Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 *
 * Author: DORSEy
 */
public class SurveyGroupInSession extends SurveyInSession {
    /**
     * The group ID.
     */
    protected int groupId;

    /**
     * Empty constructor of {@link SurveyGroupInSession}.
     */
    public SurveyGroupInSession() { super();}

    /**
     * Constructor of {@link SurveyGroupInSession}, with session key, survey ID and group ID specified.
     *
     * @param sessionKey the session key.
     * @param surveyId the survey id.
     * @param groupId the group id.
     */
    public SurveyGroupInSession(final String sessionKey, final int surveyId, final int groupId) {
        super(sessionKey, surveyId);
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
        return super.toString() + ", \"" + LSurveyConstants.SERIALIZED_GROUP_ID + "\": " + groupId;
    }
}
