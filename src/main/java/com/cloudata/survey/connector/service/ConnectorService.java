/**
 * File name: ConnectorService Author: Dorsey Q F TANG Date: 5/28/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.service;

import com.cloudata.survey.connector.creator.LSurveyRequestCreator;
import com.cloudata.survey.connector.struct.LSurveyRequest;
import com.cloudata.survey.connector.view.*;

import java.util.Map;

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

    /**
     * Remove the group according to the request being created by request creator.
     * Returns true if and only if the specific group is removed, otherwise false.
     *
     * @param requestCreator the request creator.
     * @return true if and only if the specific group is removed, otherwise false.
     */
    boolean deleteGroup(final LSurveyRequestCreator requestCreator);

    /**
     * Retrieves all available groups according to the request being created by request creator.
     *
     * @param requestCreator the request creator.
     * @return a list of available groups.
     */
    ListGroupsResponse listGroups(final LSurveyRequestCreator requestCreator);

    /**
     * Retrieves the group properties according to the request being created by request creator.
     *
     * @param requestCreator the request creator.
     * @return the group properties requested with its value.
     */
    GetGroupPropertiesResponse getGroupProperties(final LSurveyRequestCreator requestCreator);

    /**
     * Update the group properties according to the request created by the given request creator.
     * Returns true if and only if the properties being updated are all succeed, otherwise false.
     *
     * @param requestCreator the request creator.
     * @return true if and only if the properties to be updated is updated, otherwise false.
     */
    boolean setGroupProperties(final LSurveyRequestCreator requestCreator);

    // ----------------------------------------------------------------------------------
    // bulk operations of question
    // ----------------------------------------------------------------------------------

    /**
     * Import the question to the specific group according to the request being sent to the server.
     * Returns the ID of the question if and only if the operation is succeed, otherwise an error phase
     * will be generated to indicates that the operation failed.
     *
     * @param requestCreator the request creator.
     * @return the response.
     */
    ImportQuestionResponse importQuestion(final LSurveyRequestCreator requestCreator);

    /**
     * Delete the question specified by the request being sent to the server.
     * Returns true if and only if the question specified is removed, otherwise false.
     *
     * @param requestCreator the request creator.
     * @return true if and only if the operation is succeed, otherwise false.
     */
    boolean deleteQuestion(final LSurveyRequestCreator requestCreator);

    /**
     * List all available questions according to the request being created by request creator.
     *
     * @param requestCreator the request creator.
     * @return a List.
     */
    ListQuestionsResponse listQuestions(final LSurveyRequestCreator requestCreator);

    /**
     * Set the question properties to the requested values according to the request being created by
     * request creator. Returns true if and only if the operation is succeed, otherwise false.
     *
     * @param requestCreator the request creator.
     * @return true if and only if the operation is succeed, otherwise false.
     */
    boolean setQuestionProperties(final LSurveyRequestCreator requestCreator);

    /**
     * Retrieves all requested values according to the request being created by request creator.
     * Returns an empty map if no corresponding value being retrieved.
     *
     * @param requestCreator the request creator.
     * @return a map of requested property and its associated value, or an empty map if no results found.
     */
    Map<String, String> getQuestionProperties(final LSurveyRequestCreator requestCreator);
}
