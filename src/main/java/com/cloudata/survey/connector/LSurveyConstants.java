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
    String CMD_GET_SESSION_KEY = "get_session_key";

    /**
     * The command to release_session_id.
     */
    String CMD_RELEASE_SESSION_KEY = "release_session_key";

    /**
     * The command to add survey.
     */
    String CMD_ADD_SURVEY = "add_survey";

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

    /**
     * The command to set survey properties.
     */
    String CMD_SET_SURVEY_PROPERTIES = "set_survey_properties";

    /**
     * The command to get survey summary.
     */
    String CMD_GET_SUMMARY = "get_summary";

    /**
     * The command to add group.
     */
    String CMD_ADD_GROUP = "add_group";

    String CMD_DELETE_GROUP = "delete_group";

    /**
     * The command to list available groups.
     */
    String CMD_LIST_GROUPS = "list_groups";

    /**
     * The command to get group settings.
     */
    String CMD_GET_GROUP_PROPERTIES = "get_group_properties";

    // ---------------------------------------------------------------
    // bulk names for Http header.
    // ---------------------------------------------------------------
    /**
     * The content type in http header.
     */
    String HTTP_HEADER_CONTENT_TYPE = "content-type";

    /**
     * The Json response.
     */
    String HTTP_HEADER_CONTENT_TYPE_JSON = "application/json";

    /**
     * The connection in http header.
     */
    String HTTP_HEADER_CONNECTION = "connection";

    String HTTP_HEADER_CONNECTION_KEEP_ALIVE = "Keep-Alive";

    // ---------------------------------------------------------------
    // bulk names for Json elements.
    // ---------------------------------------------------------------
    /**
     * The name in Json element for session key.
     */
    String SERIALIZED_SESSION_KEY = "sSessionKey";

    /**
     * The wished survey id.
     */
    String SERIALIZED_WISHED_SURVEY_ID = "iSurveyID";

    /**
     * The survey title.
     */
    String SERIALIZED_SURVEY_TITLE = "sSurveyTitle";

    /**
     * The survey language.
     */
    String SERIALIZED_SURVEY_LANGUAGE = "sSurveyLanguage";

    /**
     * The survey format.
     */
    String SERIALIZED_SURVEY_FORMAT = "sformat";

    /**
     * The format in survey properties.
     */
    String SERIALIZED_FORMAT = "format";

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

    /**
     * The owner ID.
     */
    String SERIALIZED_OWNER_ID = "owner_id";

    /**
     * The template used.
     */
    String SERIALIZED_SURVEY_TEMPLATE = "template";

    /**
     * Fax to.
     */
    String SERIALIZED_FAX_TO = "faxto";

    /**
     * Anonymized.
     */
    String SERIALIZED_ANONYMIZED = "anonymized";

    /**
     * The admin email
     */
    String SERIALIZED_ADMIN_EMAIL = "adminemail";

    /**
     * The admin.
     */
    String SERIALIZED_ADMIN = "admin";

    /**
     * The array of survey settings.
     */
    String SERIALIZED_SURVEY_SETTINGS = "aSurveySettings";

    /**
     * array of survey data.
     */
    String SERIALIZED_ARR_SURVEY_DATA = "aSurveyData";

    /**
     * The stat name.
     */
    String SERIALIZED_STAT_NAME = "sStatName";

    String SERIALIZED_FULL_RESPONSES = "full_responses";

    String SERIALIZED_INCOMPLETED_RESPONSES = "incomplete_responses";
    String SERIALIZED_COMPLETED_RESPONSES = "completed_responses";
    String SERIALIZED_TOKEN_COMPLETED = "token_completed";

    String SERIALIZED_TOKEN_OPTED_OUT = "token_opted_out";
    String SERIALIZED_TOKEN_SENT = "token_sent";
    String SERIALIZED_TOKEN_INVALID = "token_invalid";
    String SERIALIZED_TOKEN_COUNT = "token_count";

    String SERIALIZED_GROUP_TITLE = "sGroupTitle";
    String SERIALIZED_GROUP_DESCRIPTION = "sGroupDescription";

    String SERIALIZED_GROUP_ID = "iGroupID";

    // bulk of names used to represent the status
    String LS_OK = "OK";

    /**
     * The comma symbol
     */
    String LS_COMMA = ",";

    String SERIALIZED_GROUP_RELEVANCE = "grelevance";
    String SERIALIZED_RANDOMIZED_GROUP = "randomization_group";
    String SERIALIZED_LANGUAGE = "language";
    String SERIALIZED_LIST_GROUP_DESC = "description";
    String SERIALIZED_GROUP_ORDER = "group_order";
    String SERIALIZED_GROUP_NAME = "group_name";
    String SERIALIZED_LIST_GROUP_ID = "gid";
    String SERIALIZED_ARR_GROUP_SETTINGS = "aGroupSettings";
}
