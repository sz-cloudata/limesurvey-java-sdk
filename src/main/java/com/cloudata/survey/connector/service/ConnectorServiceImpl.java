/**
 * File name: ConnectorServiceImpl Author: Dorsey Q F TANG Date: 5/28/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.service;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.callback.ProcessResultCallback;
import com.cloudata.survey.connector.creator.LSurveyRequestCreator;
import com.cloudata.survey.connector.struct.GetGroupPropertiesRequest;
import com.cloudata.survey.connector.struct.GetSurveyPropertiesRequest;
import com.cloudata.survey.connector.struct.ReqParams;
import com.cloudata.survey.connector.utils.LimeSurveyManager;
import com.cloudata.survey.connector.view.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of {@link ConnectorService}.
 *
 * Author: DORSEy
 */
// TODO please add exception handling code
public class ConnectorServiceImpl implements ConnectorService {

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

    public GetSurveyPropertiesResponse getSurveyProperties(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, GetSurveyPropertiesResponse.class);
    }

    public boolean setSurveyProperties(LSurveyRequestCreator requestCreator) {
        //FIXME do the concrete implementation.
        return false;
    }

    public GetAllSummariesResponse getAllSummaries(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, GetAllSummariesResponse.class);
    }

    public GetSiteSettingsResponse getSiteSettings(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, GetSiteSettingsResponse.class);
    }

    public AddGroupResponse addGroup(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, AddGroupResponse.class);
    }

    public boolean deleteGroup(LSurveyRequestCreator requestCreator) {
        // the respond string is the group id removed already.
        AddGroupResponse response = manager.execute(requestCreator, AddGroupResponse.class);
        boolean succeed = false;
        if (response != null && response.getGroupId() > 0) {
            succeed = true;
        }

        return succeed;
    }

    public ListGroupsResponse listGroups(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, ListGroupsResponse.class);
    }

    public GetGroupPropertiesResponse getGroupProperties(final LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, GetGroupPropertiesResponse.class);
    }

    public void setManager(final LimeSurveyManager manager) {
        this.manager = manager;
    }
}
