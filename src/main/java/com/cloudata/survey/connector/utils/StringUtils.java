/**
 * File name: StringUtils Author: Dorsey Q F TANG Date: 6/2/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.utils;

import com.cloudata.survey.connector.LSurveyConstants;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

    /**
     * Returns a string representation, with all its sub-strings contained in specific list <code>src</code> are double quoted.
     *
     * @param src the list.
     * @return a string representation with all its sub-strings are double quoted.
     */
    public static String doubleQuoteStringIn(final List<String> src) {
        if (src == null || src.isEmpty()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        int size = src.size();
        builder.append("[");
        for (int index = 0; index < size; index++) {
            builder.append("\"").append(src.get(index)).append("\"");
            if (index < size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }

    /**
     * Returns a string representation, with all its sub entries contained in specific map are double quoted.
     *
     * @param src the map.
     * @return a string representation.
     */
    public static String doubleQuoteEntriesIn(final Map<String, Object> src) {
        if (src == null || src.isEmpty()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        Iterator<Map.Entry<String, Object>> iter = src.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> entry = iter.next();
            String key = entry.getKey();
            Object value = entry.getValue();

            builder.append("\"").append(key).append("\": ");
            boolean shouldDoubleQuoteValue = !(value instanceof Number);
            builder.append(shouldDoubleQuoteValue ? "\"" : "").append(value);
            builder.append(shouldDoubleQuoteValue ? "\"" : "");

            if (iter.hasNext()) {
                builder.append(", ");
            }
        }

        builder.append("}");

        return builder.toString();
    }
}
