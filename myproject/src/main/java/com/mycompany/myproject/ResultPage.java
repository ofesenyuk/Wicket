
package com.mycompany.myproject;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.StringValue;
/**
 *
 * @author sf
 */
public class ResultPage extends WebPage {

    public ResultPage(PageParameters parameters) {
        super(parameters);
        Label result = new Label("result", parameters.get("result"));
        add(result);
    }
    
}
