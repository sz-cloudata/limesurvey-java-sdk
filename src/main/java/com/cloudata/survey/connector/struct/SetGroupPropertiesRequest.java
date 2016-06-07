/**
 * File name: SetGroupPropertiesRequest Author: Dorsey Q F TANG Date: 6/8/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.utils.StringUtils;

import java.util.Map;

/**
 * The request parameters should be sent accordingly if {@link LSurveyConstants#CMD_SET_GROUP_PROPERTIES} should
 * be performed on server side.
 *
 * Author: DORSEy
 */
public class SetGroupPropertiesRequest implements ReqParams {
    /**
     * Contains the session key and group id.
     */
    private GroupInSession groupInSession;

    /**
     * The key-value settings.
     */
    private Map<String, Object> properties;

    /**
     * Empty constructor of {@link SetGroupPropertiesRequest}
     */
    public SetGroupPropertiesRequest() {}

    /**
     * Constructor of {@link SetGroupPropertiesRequest}, with session key, group ID and properties specified.
     *
     * @param sessionKey the session key.
     * @param groupId the group ID.
     * @param properties the key-value properties.
     */
    public SetGroupPropertiesRequest(final String sessionKey, final int groupId, final Map<String, Object> properties) {
        setGroupInSession(sessionKey, groupId);
        this.properties = properties;
    }

    public void setGroupInSession(final String sessionKey, final int groupId) {
        this.groupInSession = new GroupInSession(sessionKey, groupId);
    }

    public GroupInSession getGroupInSession() {
        return groupInSession;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(final Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return groupInSession.toString() + ", \"" + LSurveyConstants.SERIALIZED_ARR_GROUP_DATA +
                "\": " + StringUtils.doubleQuoteEntriesIn(properties);
    }
}
