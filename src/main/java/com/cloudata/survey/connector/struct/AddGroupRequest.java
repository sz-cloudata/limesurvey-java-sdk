/**
 * File name: AddGroupRequest Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * The requested parameters sent accordingly when {@link com.cloudata.survey.connector.LSurveyConstants#CMD_ADD_GROUP} should
 * be performed on the server side.
 *
 * Author: DORSEy
 */
public class AddGroupRequest implements ReqParams {
    /**
     * The survey in session.
     */
    private SurveyInSession surveyInSession;

    /**
     * The group title.
     */
    private String groupTitle;

    /**
     * The group description.
     */
    private String groupDescription;

    /**
     * Empty constructor of {@link AddGroupRequest}.
     */
    public AddGroupRequest() {}

    public AddGroupRequest(final String sessionKey, final int surveyId, final String groupTitle, final String groupDescription) {
        setSurveyInSession(sessionKey, surveyId);
        this.groupTitle = groupTitle;
        this.groupDescription = groupDescription;
    }

    public void setSurveyInSession(final String sessionKey, final int surveyId) {
        this.surveyInSession = new SurveyInSession(sessionKey, surveyId);
    }

    public SurveyInSession getSurveyInSession() {
        return surveyInSession;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(final String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(final String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"").append(LSurveyConstants.SERIALIZED_SESSION_KEY).append("\": ");
        builder.append("\"").append(surveyInSession.getSessionKey()).append("\", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_WISHED_SURVEY_ID).append("\": ");
        builder.append(surveyInSession.getSurveyId()).append(", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_GROUP_TITLE).append("\": ");
        builder.append("\"").append(groupTitle).append("\", ");
        builder.append("\"").append(LSurveyConstants.SERIALIZED_GROUP_DESCRIPTION).append("\": ");
        builder.append("\"").append(groupDescription).append("\"");

        return builder.toString();
    }
}
