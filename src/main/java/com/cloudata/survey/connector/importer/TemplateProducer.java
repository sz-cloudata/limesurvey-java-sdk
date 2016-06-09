/**
 * File name: TemplateProducer Author: Dorsey Q F TANG Date: 6/9/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.importer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * A utility class which is used to produce stuff according to the template specified.
 *
 * Author: DORSEy
 */
public final class TemplateProducer {

    /**
     * From which the data should be retrieved.
     */
    private static final String TEMPLATE_ROOT = "question";

    /**
     * Returns a string representation which represents the rendered template which specified by template name under
     * the specific template path.
     *
     * @param templatePath the template path.
     * @param templateName the template name.
     * @param question the data being rendered.
     * @return a string representation.
     * @throws IOException when I/O error or template exception detected.
     */
    public static String produce(final String templatePath, final String templateName, final LSurveyQuestion question) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_24);
        cfg.setClassForTemplateLoading(TemplateProducer.class, templatePath);

        String out = null;
        StringWriter writer = null;
        try {
            Map<String, LSurveyQuestion> dataModel = new HashMap<String, LSurveyQuestion>(1);
            dataModel.put(TEMPLATE_ROOT, question);
            Template template = cfg.getTemplate(templateName);

            writer = new StringWriter();
            template.process(dataModel, writer);
            out = writer.toString();
        } catch (TemplateException e) {
            //TODO log down the errors
            throw new IOException(e);
        } finally {
             if (null != writer) {
                 writer.close();
             }
        }

        return out;
    }
}
