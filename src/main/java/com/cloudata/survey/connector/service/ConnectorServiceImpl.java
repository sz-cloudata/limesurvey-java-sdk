/**
 * File name: ConnectorServiceImpl Author: Dorsey Q F TANG Date: 5/28/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.service;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.callback.ProcessResultCallback;
import com.cloudata.survey.connector.creator.LSurveyRequestCreator;
import com.cloudata.survey.connector.struct.*;
import com.cloudata.survey.connector.utils.LimeSurveyManager;
import com.cloudata.survey.connector.view.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public boolean setSurveyProperties(final LSurveyRequestCreator requestCreator) {
        SetSurveyPropertiesRequest reqParams = (SetSurveyPropertiesRequest) requestCreator.create().getReqParams();
        Map<String, Object> surveyData = reqParams.getSurveyData();
        final Set<String> keys = surveyData.keySet();

        return manager.execute(requestCreator, new BooleanValueCheckerCallback(keys));
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

    public boolean setGroupProperties(final LSurveyRequestCreator requestCreator) {
        SetGroupPropertiesRequest reqParams = (SetGroupPropertiesRequest) requestCreator.create().getReqParams();
        Map<String, Object> groupSettings = reqParams.getProperties();
        final Set<String> keys = groupSettings.keySet();

        return manager.execute(requestCreator, new BooleanValueCheckerCallback(keys));
    }

    public ImportQuestionResponse importQuestion(LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, ImportQuestionResponse.class);
    }

    public boolean deleteQuestion(LSurveyRequestCreator requestCreator) {
        ImportQuestionResponse response = manager.execute(requestCreator, ImportQuestionResponse.class);
        QuestionInSession reqParams = (QuestionInSession) requestCreator.create().getReqParams();
        if (response.getQuestionId() == reqParams.getQuestionId()) {
            return true;
        }

        return false;
    }

    public ListQuestionsResponse listQuestions(final LSurveyRequestCreator requestCreator) {
        return manager.execute(requestCreator, ListQuestionsResponse.class);
    }

    public boolean setQuestionProperties(final LSurveyRequestCreator requestCreator) {
        SetQuestionPropertiesRequest reqParams = (SetQuestionPropertiesRequest) requestCreator.create().getReqParams();
        Map<String, Object> properties = reqParams.getQuestionData();
        final Set<String> keys = properties.keySet();

        return manager.execute(requestCreator, new BooleanValueCheckerCallback(keys));
    }

    public Map<String, String> getQuestionProperties(final LSurveyRequestCreator requestCreator) {
        GetQuestionPropertiesRequest reqParams = (GetQuestionPropertiesRequest) requestCreator.create().getReqParams();
        final List<String> properties = reqParams.getProperties();

        return manager.execute(requestCreator, new ValuesReflectedCallback(properties));
    }

    public void setManager(final LimeSurveyManager manager) {
        this.manager = manager;
    }

    private static JsonObject getRootElement(final String json) {
        JsonElement jsonElement = (new JsonParser()).parse(json);
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        JsonElement rootElement = jsonObj.get(LSurveyConstants.SERIALIZED_RESULT);

        return rootElement.getAsJsonObject();
    }

    private static class BooleanValueCheckerCallback implements ProcessResultCallback<Boolean> {
        private final Set<String> properties;

        BooleanValueCheckerCallback(final Set<String> properties) {
            this.properties = properties;
        }

        public Boolean doWithResult(final Object result) {
            JsonObject root = getRootElement((String) result);

            for (String property : properties) {
                boolean isOk = root.get(property).getAsBoolean();
                if (!isOk) {
                    return false;
                }
            }

            return true;
        }
    }

    private static class ValuesReflectedCallback implements ProcessResultCallback<Map<String, String>> {
        private final List<String> properties;

        ValuesReflectedCallback(final List<String> properties) {
            this.properties = properties;
        }

        public Map<String, String> doWithResult(Object result) {
            Map<String, String> response = new HashMap<String, String>();
            JsonObject root = getRootElement((String) result);

            for (String property : properties) {
                String value = root.get(property).getAsString();
                response.put(property, value);
            }

            return response;
        }
    }
}
