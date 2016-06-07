/**
 * File name: GetGroupPropertiesRequest Author: Dorsey Q F TANG Date: 6/7/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.utils.StringUtils;

import java.util.List;

/**
 * The request parameters should be sent accordingly if {@link LSurveyConstants#CMD_GET_GROUP_PROPERTIES} should be
 * performed on server side.
 *
 * Author: DORSEy
 */
public class GetGroupPropertiesRequest implements ReqParams {
    /**
     * The instance which contains session key and group ID.
     */
    private GroupInSession groupInSession;

    /**
     * The group settings.
     * <p>
     *     The settings should be retrieved from the table schema.
     * </p>
     */
    private List<String> groupSettings;

    /**
     * Empty constructor of {@link GetGroupPropertiesRequest}.
     */
    public GetGroupPropertiesRequest() {}

    /**
     * Constructor of {@link GetGroupPropertiesRequest}, with session key, group id and group settings specified.
     *
     * @param sessionKey the session key.
     * @param groupId the group ID.
     * @param groupSettings the group settings.
     */
    public GetGroupPropertiesRequest(final String sessionKey, final int groupId, final List<String> groupSettings) {
        setGroupInSession(sessionKey, groupId);
        this.groupSettings = groupSettings;
    }

    public void setGroupInSession(final String sessionKey, final int groupId) {
        this.groupInSession = new GroupInSession(sessionKey, groupId);
    }

    public GroupInSession getGroupInSession() {
        return groupInSession;
    }

    public List<String> getGroupSettings() {
        return groupSettings;
    }

    public void setGroupSettings(final List<String> groupSettings) {
        this.groupSettings = groupSettings;
    }

    @Override
    public String toString() {
        return this.groupInSession.toString() + ", \"" + LSurveyConstants.SERIALIZED_ARR_GROUP_SETTINGS +
                "\": " + StringUtils.doubleQuoteStringIn(groupSettings);
    }
}
