/**
 * File name: StringUtilsTest Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * A test for {@link StringUtils}.
 *
 * Author: DORSEy
 */
public class StringUtilsTest {
    @Test
    public void testDoubleQuotedEntriesIn() {
        Map<String, Object> src = new HashMap<String, Object>();
        src.put("str1", "hello");
        src.put("int1", new Integer(12));

        String result = StringUtils.doubleQuoteEntriesIn(src);
        Assert.assertNotNull(result);
        System.out.println(result);
    }
}
