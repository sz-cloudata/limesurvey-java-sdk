/**
 * File name: ConnectorSerivceImpl Author: Dorsey Q F TANG Date: 5/28/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.service;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.creator.LSurveyRequestCreator;
import com.cloudata.survey.connector.utils.LimeSurveyManager;
import com.cloudata.survey.connector.view.*;

/**
 * The implementation of {@link ConnectorService}.
 *
 * Author: DORSEy
 */
// TODO please add exception handling code
public class ConnectorSerivceImpl implements ConnectorService {

    /**
     * The manager of LimeSurvey.
     */
    private LimeSurveyManager manager;

    public InitConnResponse getConnection(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, InitConnResponse.class);
    }

    public boolean releaseConnection(LSurveyRequestCreator requestCreator) {
        ReleaseConnResponse response = manager.execute(requestCreator, ReleaseConnResponse.class);
        boolean succeed = (response != null && LSurveyConstants.LS_OK.equalsIgnoreCase(response.getStatus())) ? true : false;

        return succeed;
    }

    public SurveyResponse addSurvey(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, SurveyResponse.class);
    }

    public boolean deleteSurvey(LSurveyRequestCreator requestCreator) {
        DeleteSurveyResponse response = manager.execute(requestCreator, DeleteSurveyResponse.class);
        boolean succeed = false;
        RespStatus responseStatus = null;
        if (response != null && (responseStatus = response.getStatus()) != null) {
            succeed = (LSurveyConstants.LS_OK.equalsIgnoreCase(responseStatus.getStatus())) ? true : false;
        }

        return succeed;
    }

    public ListSurveysResponse listSurveys(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, ListSurveysResponse.class);
    }

    public boolean activateSurvey(LSurveyRequestCreator requestCreator) {
        ActivateSurveyResponse response = manager.execute(requestCreator, ActivateSurveyResponse.class);
        boolean succeed = false;
        RespStatus respStatus = null;
        if (response != null && (respStatus = response.getRespStatus()) != null) {
            succeed = (LSurveyConstants.LS_OK.equalsIgnoreCase(respStatus.getStatus())) ? true : false;
        }

        return succeed;
    }

    public GetSiteSettingsResponse getSurveyProperties(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, GetSiteSettingsResponse.class);
    }

    public GetSiteSettingsResponse getSiteSettings(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, GetSiteSettingsResponse.class);
    }

    public void setManager(LimeSurveyManager manager) {
        this.manager = manager;
    }
}
