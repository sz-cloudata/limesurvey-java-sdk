/**
 * File name: ConnectorService Author: Dorsey Q F TANG Date: 5/28/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.service;

import com.cloudata.survey.connector.creator.LSurveyRequestCreator;
import com.cloudata.survey.connector.struct.LSurveyRequest;
import com.cloudata.survey.connector.view.*;

/**
 * The service, which served the client with survey manipulation.
 * <p>
 * Author: DORSEy
 */
public interface ConnectorService {
    /**
     * Execute the request being created by the given request creator. Returns the session key to identify the connection being established.
     *
     * @param requestCreator the request creator.
     * @return the object which represents the connection.
     */
    InitConnResponse getConnection(final LSurveyRequestCreator requestCreator);

    /**
     * Execute the request being created by the given request creator. Returns true if and only if the connection, which specified by session key, is disconnected.
     *
     * @param requestCreator the request creator.
     * @return true if the connection is disconnected, otherwise false.
     */
    boolean releaseConnection(final LSurveyRequestCreator requestCreator);

    /**
     * Execute the request being created by the given request creator.
     * It returns the survey id which contained in <code>SurveyResponse</code> to identify which survey is being created.
     *
     * @param requestCreator the request creator.
     * @return the response with survey ID.
     */
    SurveyResponse addSurvey(final LSurveyRequestCreator requestCreator);

    /**
     * Execute the request being created by the given request creator.
     * Returns true if and only if the survey specified is removed, false otherwise.
     *
     * @param requestCreator the request creator.
     * @return true if and only if the survey specified is removed, otherwise false.
     */
    boolean deleteSurvey(final LSurveyRequestCreator requestCreator);

    /**
     * Execute the request being created by the given request creator.
     * Returns an object which contains the detail informations of the survey existed.
     *
     * @param requestCreator the request creator.
     * @return an object.
     */
    ListSurveysResponse listSurveys(final LSurveyRequestCreator requestCreator);

    /**
     * Execute the request being created by the given request creator.
     * Returns true if and only if the survey specified is being activated, otherwise false.
     *
     * @param requestCreator the request creator.
     * @return true if and only if the specific survey is activated, otherwise false.
     */
    boolean activateSurvey(final LSurveyRequestCreator requestCreator);

    /**
     * Execute the request being created by the given request creator.
     * Returns the response being executed on the server side.
     *
     * @param requestCreator the request creator.
     * @return the response.
     */
    GetSurveyPropertiesResponse getSurveyProperties(final LSurveyRequestCreator requestCreator);

    /**
     * Executes the request being created by the given request creator.
     * Returns true if and only if the survey specified is updated according to the request, otherwise false.
     *
     * @param requestCreator the request creator.
     * @return true if and only if the survey specified is updated, otherwise false.
     */
    boolean setSurveyProperties(final LSurveyRequestCreator requestCreator);

    /**
     * Executes the request being created by the given request creator.
     * Returns the response generated after specific command is finished.
     *
     * @param requestCreator the request creator.
     * @return the response generated.
     */
    GetAllSummariesResponse getAllSummaries(final LSurveyRequestCreator requestCreator);

    /**
     * Execute the request being created by the given request creator.
     * Returns the response being executed on the server side.
     *
     * @param requestCreator the request creator.
     * @return the response
     */
    GetSiteSettingsResponse getSiteSettings(final LSurveyRequestCreator requestCreator);

    // ----------------------------------------------------------------------------------
    // bulk operations of group
    // ----------------------------------------------------------------------------------

    AddGroupResponse addGroup(final LSurveyRequestCreator requestCreator);

    boolean deleteGroup(final LSurveyRequestCreator requestCreator);

    ListGroupsResponse listGroups(final LSurveyRequestCreator requestCreator);
}
