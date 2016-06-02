/**
 * File name: LSurveyConfigs Author: Dorsey Q F TANG Date: 6/2/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector;

/**
 * Lists out all available config setting names.
 *
 * Author: DORSEy
 */
public interface LSurveyConfigs {
    /**
     * File types allowed to be uploaded in the template section.
     */
    String CONFIG_ALLOWED_TEMPLATE_UPLOADS = "allowedtemplateuploads";

    /**
     * File types allowed to be uploaded in the resource section, and with HTML editor.
     */
    String CONFIG_ALLOWED_RESOURCE_UPLOADS = "allowedresourcesuploads";

    /**
     * The maximum number of emails to send  in one go.
     */
    String CONFIG_MAX_EMAILS = "maxemails";
}
