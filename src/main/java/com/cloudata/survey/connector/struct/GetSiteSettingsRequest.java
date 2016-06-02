/**
 * File name: GetSiteSettingsRequest Author: Dorsey Q F TANG Date: 6/2/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;

/**
 * The request parameters should be sent with when {@link com.cloudata.survey.connector.LSurveyConstants#CMD_GET_SITE_SETTINGS} command
 * should be performed on server side.
 *
 * Author: DORSEy
 */
public class GetSiteSettingsRequest extends ConnRequest {
    /**
     * The setting name, whose value should be retrieved.
     */
    private String settingName;

    /**
     * Empty constructor of {@link GetSiteSettingsRequest}.
     */
    public GetSiteSettingsRequest() {}

    /**
     * Constructor of {@link GetSiteSettingsRequest}, with session key and setting name specified.
     *
     * @param sessionKey the session key.
     * @param settingName the setting name.
     */
    public GetSiteSettingsRequest(final String sessionKey, final String settingName) {
        super(sessionKey);
        this.settingName = settingName;
    }

    public void setSettingName(final String settingName) {
        this.settingName = settingName;
    }

    public String getSettingName() {
        return settingName;
    }

    @Override
    public String toString() {
        return "\"" + LSurveyConstants.SERIALIZED_SESSION_KEY + "\": \"" + sessionKey + "\", \"" +
                LSurveyConstants.SERIALIZED_SETTING_NAME + "\": \"" + settingName + "\"";
    }
}
