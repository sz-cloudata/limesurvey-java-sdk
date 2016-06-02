/**
 * File name: GetSiteSettingsResponse Author: Dorsey Q F TANG Date: 6/2/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

/**
 * A response generated when {@link com.cloudata.survey.connector.LSurveyConstants#CMD_GET_SITE_SETTINGS} command
 * is sent.
 *
 * Author: DORSEy
 */
public class GetSiteSettingsResponse implements Resp {
    /**
     * The setting value.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_RESULT)
    private String settingVal;

    /**
     * Empty constructor of {@link GetSiteSettingsResponse}.
     */
    public GetSiteSettingsResponse() {}

    public String[] getSettingVal() {
        return StringUtils.tokenizedString(settingVal);
    }

    public void setSettingVal(final String settingVal) {
        this.settingVal = settingVal;
    }

    @Override
    public String toString() {
        return "settingValue: " + settingVal;
    }
}
