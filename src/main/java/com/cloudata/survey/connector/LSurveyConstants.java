/**
 * File name: LSurveyConstants
 * Author: Dorsey Q F TANG
 * Date: 5/27/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector;

/**
 * It acts as a container, which contains the constants that used by LimeSurvey.
 *
 * Author: DORSEy
 */
public interface LSurveyConstants {
    // bulk names for commands.
    /**
     * The command to get_session_id.
     */
    public static final String CMD_GET_SESSION_KEY = "get_session_key";

    /**
     * The command to release_session_id.
     */
    public static final String CMD_RELEASE_SESSION_KEY = "release_session_key";

    /**
     * The command to add survey.
     */
    public static final String CMD_ADD_SURVEY = "add_survey";

    /**
     * The command to delete survey.
     */
    String CMD_DELETE_SURVEY = "delete_survey";

    /**
     * The command to list surveys.
     */
    String CMD_LIST_SURVEYS = "list_surveys";

    /**
     * The command to activate survey.
     */
    String CMD_ACTIVATE_SURVEY = "activate_survey";

    /**
     * The command to get survey properties.
     */
    String CMD_GET_SURVEY_PROPERTIES = "get_survey_properties";

    /**
     * The command to get site settings.
     */
    String CMD_GET_SITE_SETTINGS = "get_site_settings";

    // ---------------------------------------------------------------
    // bulk names for Http header.
    // ---------------------------------------------------------------
    /**
     * The content type in http header.
     */
    public static final String HTTP_HEADER_CONTENT_TYPE = "content-type";

    /**
     * The Json response.
     */
    public static final String HTTP_HEADER_CONTENT_TYPE_JSON = "application/json";

    /**
     * The connection in http header.
     */
    public static final String HTTP_HEADER_CONNECTION = "connection";

    public static final String HTTP_HEADER_CONNECTION_KEEP_ALIVE = "Keep-Alive";

    // ---------------------------------------------------------------
    // bulk names for Json elements.
    // ---------------------------------------------------------------
    /**
     * The name in Json element for session key.
     */
    public static final String SERIALIZED_SESSION_KEY = "sSessionKey";

    /**
     * The wished survey id.
     */
    public static final String SERIALIZED_WISHED_SURVEY_ID = "iSurveyID";

    /**
     * The survey title.
     */
    public static final String SERIALIZED_SURVEY_TITLE = "sSurveyTitle";

    /**
     * The survey language.
     */
    public static final String SERIALIZED_SURVEY_LANGUAGE = "sSurveyLanguage";

    /**
     * The survey format.
     */
    public static final String SERIALIZED_SURVEY_FORMAT = "sformat";

    /**
     * The method for action performed.
     */
    String SERIALIZED_METHOD = "method";

    /**
     * The parameters.
     */
    String SERIALIZED_PARAMS = "params";

    /**
     * The id.
     */
    String SERIALIZED_ID = "id";

    /**
     * The username.
     */
    String SERIALIZED_USER_NAME = "username";

    /**
     * The password.
     */
    String SERIALIZED_PASSWORD = "password";

    /**
     * The result.
     */
    String SERIALIZED_RESULT = "result";

    /**
     * The status.
     */
    String SERIALIZED_STATUS = "status";

    /**
     * The survey creator.
     */
    String SERIALIZED_SURVEY_CREATOR = "sUsername";

    /**
     * The survey id in a list.
     */
    String SERIALIZED_LIST_SURVEY_ID = "sid";

    /**
     * The survey title in a list.
     */
    String SERIALIZED_LIST_SURVEY_TITLE = "surveyls_title";

    /**
     * The start date.
     */
    String SERIALIZED_START_DATE = "startDate";

    /**
     * The expiry.
     */
    String SERIALIZED_EXPIRES = "expires";

    /**
     * The activate.
     */
    String SERIALIZED_ACTIVATE = "active";

    /**
     * The setting name.
     */
    String SERIALIZED_SETTING_NAME = "sSetttingName";

    // bulk of names used to represent the status
    String LS_OK = "OK";

    /**
     * The comma symbol
     */
    String LS_COMMA = ",";
}
