/**
 * File name: StringUtils Author: Dorsey Q F TANG Date: 6/2/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.utils;

import com.cloudata.survey.connector.LSurveyConstants;

import java.util.StringTokenizer;

/**
 * A utility class, which contains a bunch of utility methods.
 *
 * Author: DORSEy
 */
public class StringUtils {
    /**
     * Returns an array of sub-strings. The substrings are splitted by the comma symbol. Returns
     * an empty array if the <code>arg</code> specified is <code>null</code> or an empty string.
     *
     * @param arg the string.
     * @return an array of sub-strings.
     */
    public static String[] tokenizedString(final String arg) {
        if (arg == null || arg.isEmpty()) {
            return new String[0];
        }

        StringTokenizer tokenizer = new StringTokenizer(arg, LSurveyConstants.LS_COMMA);
        int countTokens = tokenizer.countTokens();
        String[] result = new String[countTokens];
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            result[index++] = tokenizer.nextToken();
        }

        return result;
    }
}
