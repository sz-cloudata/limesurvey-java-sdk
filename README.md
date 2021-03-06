# limesurvey-java-sdk
Limesurvey remotecontrol2 java sdk.


# Remotecontrol JSON-RPC


```

activate_survey
/**
* RPC Routine that launches a newly created survey.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID The id of the survey to be activated
* @return array The result of the activation
*/
activate_tokens
/**
* RPC routine to to initialise the survey's collection of tokens where new participant tokens may be later added.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param integer $iSurveyID ID of the survey where a token table will be created for
* @param array $aAttributeFields An array of integer describing any additional attribute fields
* @return array Status=>OK when successfull, otherwise the error description
*/
add_group
/**
* RPC Routine to add an empty group with minimum details.
* Used as a placeholder for importing questions.
* Returns the groupid of the created group.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Dd of the Survey to add the group
* @param string $sGroupTitle Name of the group
* @param string $sGroupDescription Optional description of the group
* @return array|int The id of the new group - Or status
*/
add_language
/**
* RPC Routine to add a survey language.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param integer $iSurveyID ID of the survey where a token table will be created for
* @param string $sLanguage A valid language shortcut to add to the current survey. If the language already exists no error will be given.
* @return array Status=>OK when successfull, otherwise the error description
*/
add_participants
/**
* RPC Routine to add participants to the tokens collection of the survey.
* Returns the inserted data including additional new information like the Token entry ID and the token string.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey
* @param struct $aParticipantData Data of the participants to be added
* @param bool Optional - Defaults to true and determins if the access token automatically created
* @return array The values added
*/
add_response
/**
* RPC Routine to add a response to the survey responses collection.
* Returns the id of the inserted survey response
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey to insert responses
* @param struct $aResponseData The actual response
* @return int The response ID
*/
add_survey
/**
* RPC Routine to add an empty survey with minimum details.
* Used as a placeholder for importing groups and/or questions.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID The wish id of the Survey to add
* @param string $sSurveyTitle Title of the new Survey
* @param string $sSurveyLanguage Default language of the Survey
* @param string $sformat Question appearance format
* @return array|string|int
*/
cpd_importParticipants
/**
* This function import a participant to the LimeSurvey cpd. It stores attributes as well, if they are registered before within ui
*
* Call the function with $response = $myJSONRPCClient->cpd_importParticipants( $sessionKey, $aParticipants);
*
* @param int $sSessionKey
* @param array $aParticipants
* [[0] => ["email"=>"dummy-02222@limesurvey.com","firstname"=>"max","lastname"=>"mustermann"]]
* @return array with status
*/
delete_group
/**
* RPC Routine to delete a group of a survey .
* Returns the id of the deleted group.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the survey that the group belongs
* @param int $iGroupID Id of the group to delete
* @return array|int The id of the deleted group or status
*/
delete_language
/**
* RPC Routine to delete a survey language.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param integer $iSurveyID ID of the survey where a token table will be created for
* @param string $sLanguage A valid language shortcut to delete from the current survey. If the language does not exist in that survey no error will be given.
* @return array Status=>OK when successfull, otherwise the error description
*/
delete_participants
/**
* RPC Routine to delete multiple participants of a Survey.
* Returns the id of the deleted token
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey that the participants belong to
* @param array $aTokenIDs Id of the tokens/participants to delete
* @return array Result of deletion
*/
delete_question
/**
* RPC Routine to delete a question of a survey .
* Returns the id of the deleted question.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int iQuestionID Id of the question to delete
* @return array|int Id of the deleted Question or status
*/
delete_survey
/**
* RPC Routine to delete a survey.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID The id of the Survey to be deleted
* @return array Returns Status
*/
export_responses
/**
* RPC Routine to export responses.
* Returns the requested file as base64 encoded string
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey
* @param string $sDocumentType pdf,csv,xls,doc,json
* @param string $sLanguageCode The language to be used
* @param string $sCompletionStatus Optional 'complete','incomplete' or 'all' - defaults to 'all'
* @param string $sHeadingType 'code','full' or 'abbreviated' Optional defaults to 'code'
* @param string $sResponseType 'short' or 'long' Optional defaults to 'short'
* @param integer $iFromResponseID Optional
* @param integer $iToResponseID Optional
* @param array $aFields Optional Selected fields
* @return array|string On success: Requested file as base 64-encoded string. On failure array with error information
* */
export_responses_by_token
/**
* RPC Routine to export token response in a survey.
* Returns the requested file as base64 encoded string
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey
* @param string $sDocumentType pdf,csv,xls,doc,json
* @param string $sToken The token for which responses needed
* @param string $sLanguageCode The language to be used
* @param string $sCompletionStatus Optional 'complete','incomplete' or 'all' - defaults to 'all'
* @param string $sHeadingType 'code','full' or 'abbreviated' Optional defaults to 'code'
* @param string $sResponseType 'short' or 'long' Optional defaults to 'short'
* @param array $aFields Optional Selected fields
* @return array|string On success: Requested file as base 64-encoded string. On failure array with error information
*
*/
export_statistics
/**
* RPC routine to export statistics of a survey to a user.
* Returns string - base64 encoding of the statistics.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey
* @param string $docType Type of documents the exported statistics should be
* @param string $sLanguage Optional language of the survey to use
* @param string $graph Create graph option
* @param int|array $groupIDs An OPTIONAL array (ot a single int) containing the groups we choose to generate statistics from
* @return string Base64 encoded string with the statistics file
*/
export_timeline
/**
* RPC Routine to export submission timeline.
* Returns an array of values (count and period)
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey
* @param string $sType (day|hour)
* @param string $dStart
* @param string $dEnd
* @return array On success: The timeline. On failure array with error information
* */
get_group_properties
/**
* RPC Routine to return properties of a group of a survey .
* Returns array of properties
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iGroupID Id of the group to get properties
* @param array $aGroupSettings The properties to get
* @return array The requested values
*/
get_language_properties
/**
* RPC Routine to get survey language properties.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Dd of the Survey
* @param array $aSurveyLocaleSettings Properties to get
* @param string $sLang Language to use
* @return array The requested values
*/
get_participant_properties
/**
* RPC Routine to return settings of a token/participant of a survey .
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey to get token properties
* @param int $iTokenID Id of the participant to check
* @param array $aTokenProperties The properties to get
* @return array The requested values
*/
get_question_properties
/**
* RPC Routine to return properties of a question of a survey.
* Returns string
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iQuestionID Id of the question to get properties
* @param array $aQuestionSettings The properties to get
* @param string $sLanguage Optional parameter language for multilingual questions
* @return array The requested values
*/
get_response_ids
/**
* RPC Routine to find response IDs given a survey ID and a token.
* @param string $sSessionKey
* @param int $iSurveyID
* @param string $sToken
*/
get_session_key
/**
* RPC routine to create a session key.
* Using this function you can create a new XML/JSON-RPC session key.
* This is mandatory for all following LSRC2 function calls.
* @access public
* @param string $username
* @param string $password
* @return string
*/
get_site_settings
/**
* RPC Routine to get settings.
*
* @access public
* @param string $sSessionKey Auth Credentials
* @param string $sSetttingName Name of the setting to get
* @return string The requested value
*/
get_summary
/**
* RPC routine to get survey summary, regarding token usage and survey participation.
* Returns the requested value as string.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey to get summary
* @param string $sStatName Name of the summary option - valid values are 'token_count', 'token_invalid', 'token_sent', 'token_opted_out', 'token_completed', 'completed_responses', 'incomplete_responses', 'full_responses' or 'all'
* @return string The requested value or an array of all values when $sStatName = 'all'
*/
get_survey_properties
/**
* RPC Routine to get survey properties.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID The id of the Survey to be checked
* @param array $aSurveySettings The properties to get
* @return array
*/
import_group
/**
* RPC Routine to import a group - imports lsg,csv
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID The id of the survey that the group will belong
* @param string $sImportData String containing the BASE 64 encoded data of a lsg,csv
* @param string $sImportDataType lsg,csv
* @param string $sNewGroupName Optional new name for the group
* @param string $sNewGroupDescription Optional new description for the group
* @return array|integer iGroupID - ID of the new group or status
*/
import_question
/**
* RPC Routine to import a question - imports lsq,csv.
*
* @access public
* @param string $sSessionKey
* @param int $iSurveyID The id of the survey that the question will belong
* @param int $iGroupID The id of the group that the question will belong
* @param string $sImportData String containing the BASE 64 encoded data of a lsg,csv
* @param string $sImportDataType lsq,csv
* @param string $sMandatory Optional Mandatory question option (default to No)
* @param string $sNewQuestionTitle Optional new title for the question
* @param string $sNewqQuestion An optional new question
* @param string $sNewQuestionHelp An optional new question help text
* @return array|integer iQuestionID - ID of the new question - Or status
*/
import_survey
/**
* RPC Routine to import a survey - imports lss,csv,xls or survey zip archive.
*
* @access public
* @param string $sSessionKey Auth Credentials
* @param string $sImportData String containing the BASE 64 encoded data of a lss,csv,xls or survey zip archive
* @param string $sImportDataType lss,csv,txt or zip
* @param string $sNewSurveyName The optional new name of the survey
* @param integer $DestSurveyID This is the new ID of the survey - if already used a random one will be taken instead
* @return array|integer iSurveyID - ID of the new survey
*/
invite_participants
/**
* RPC Routine to invite participants in a survey
* Returns array of results of sending
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID ID of the survey that participants belong
* @return array Result of the action
*/
list_groups
/**
* RPC Routine to return the ids and info of groups belonging to survey .
* Returns array of ids and info.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey containing the groups
* @return array The list of groups
*/
list_participants
/**
* RPC Routine to return the ids and info of token/participants of a survey.
* if $bUnused is true, user will get the list of not completed tokens (token_return functionality).
* Parameters iStart and ilimit are used to limit the number of results of this call.
* Parameter aAttributes is an optional array containing more attribute that may be requested
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the survey to list participants
* @param int $iStart Start id of the token list
* @param int $iLimit Number of participants to return
* @param bool $bUnused If you want unused tokens, set true
* @param bool|array $aAttributes The extented attributes that we want
* @param array|struct $aConditions Optional conditions to limit the list, e.g. with array('email' => 'info@example.com')
* @return array The list of tokens
*/
list_questions
/**
* RPC Routine to return the ids and info of (sub-)questions of a survey/group.
* Returns array of ids and info.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the survey to list questions
* @param int $iGroupID Optional id of the group to list questions
* @param string $sLanguage Optional parameter language for multilingual questions
* @return array The list of questions
*/
list_surveys
/**
* RPC Routine to list the ids and info of surveys belonging to a user.
* Returns array of ids and info.
* If user is admin he can get surveys of every user (parameter sUser) or all surveys (sUser=null)
* Else only the syrveys belonging to the user requesting will be shown.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param string $sUser Optional username to get list of surveys
* @return array The list of surveys
*/
list_users
/**
* RPC Routine to list the ids and info of users.
* Returns array of ids and info.
* @param string $sSessionKey Auth credentials
* @return array The list of users
*/
mail_registered_participants
/**
* RPC Routine to send register mails to participants in a survey
* Returns array of results of sending
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID ID of the survey that participants belong
* @param array $overrideAllConditions replace the default conditions, like this:
* $overrideAllConditions = Array();
* $overrideAllConditions[] = 'tid = 2';
* $response = $myJSONRPCClient->mail_registered_participants( $sessionKey, $survey_id, $overrideAllConditions );
* @return array Result of the action
*/
release_session_key
/**
* Closes the RPC session
*
* @access public
* @param string $sSessionKey
* @return string
*/
remind_participants
/**
* RPC Routine to send reminder for participants in a survey
* Returns array of results of sending
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID ID of the survey that participants belong
* @param int $iMinDaysBetween Optional parameter days from last reminder
* @param int $iMaxReminders Optional parameter Maximum reminders count
* @return array Result of the action
*/
set_group_properties
/**
* RPC Routine to set group properties.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param integer $iGroupID - ID of the survey
* @param array|struct $aGroupData - An array with the particular fieldnames as keys and their values to set on that particular survey
* @return array Of succeeded and failed modifications according to internal validation.
*/
set_language_properties
/**
* RPC Routine to set survey language properties.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param integer $iSurveyID - ID of the survey
* @param array|struct $aSurveyLocaleData - An array with the particular fieldnames as keys and their values to set on that particular survey
* @param string $sLanguage - Optional - Language to update - if not give the base language of the particular survey is used
* @return array Status=>OK, when save successful otherwise error text.
*/
set_participant_properties
/**
* RPC Routine to set properties of a survey participant/token.
* Returns array
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the survey that participants belong
* @param int $iTokenID Id of the participant to alter
* @param array|struct $aTokenData Data to change
* @return array Result of the change action
*/
set_question_properties
/**
* RPC Routine to set question properties.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param integer $iQuestionID - ID of the question
* @param array|struct $aQuestionData - An array with the particular fieldnames as keys and their values to set on that particular question
* @param string $sLanguage Optional parameter language for multilingual questions
* @return array Of succeeded and failed modifications according to internal validation.
*/
set_survey_properties
/**
* RPC Routine to set survey properties.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param integer $iSurveyID - ID of the survey
* @param array|struct $aSurveyData - An array with the particular fieldnames as keys and their values to set on that particular survey
* @return array Of succeeded and failed nodifications according to internal validation.
*/
update_response
/**
* RPC Routine to update a response in a given survey.
* Routine supports only single response updates.
* Response to update will be identified either by the response id, or the token if response id is missing.
* Routine is only applicable for active surveys with alloweditaftercompletion = Y.
*
* @access public
* @param string $sSessionKey Auth credentials
* @param int $iSurveyID Id of the Survey to update response
* @param struct $aResponseData The actual response
* @return mixed TRUE(bool) on success. errormessage on error
*/
Clouddata Survey

```
