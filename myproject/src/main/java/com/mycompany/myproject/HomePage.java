package com.mycompany.myproject;

import com.google.code.mathparser.MathParser;
import com.google.code.mathparser.MathParserFactory;
import com.google.code.mathparser.parser.calculation.Result;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.StringValue;
import org.apache.wicket.validation.CompoundValidator;
import org.apache.wicket.validation.validator.StringValidator;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(PageParameters parameters) {
//	public HomePage(final PageParameters parameters) {
//            super(parameters);

//            add(new Label("version", getApplication().getFrameworkSettings()
//                    .getVersion()));
//            add(new Label("hi", "Sasha"));
            final TextField<String> expressionField = new TextField<>("expression",
                    Model.of(""));
            expressionField.setRequired(true);
//            
//            Label errorMessages = new Label("errorMessages", "zsffwdg");
//            errorMessages.info("sdfadgfadfsgs");
            
            Form<?> form = new Form<Void>("expressionForm") {

                @Override
                protected void onSubmit() {

                    final String expressionValue 
                            = expressionField.getModelObject();
                    MathParser mathParser = MathParserFactory.create();
                    Result result = mathParser.calculate(expressionValue);
                    String resultStr = result.doubleValue().toString();

//                    PageParameters parameters = new PageParameters();
                    parameters.add("result", resultStr);
                    setResponsePage(HomePage.class, parameters);
//                    setResponsePage(ResultPage.class, parameters);

                }

            };

            add(form);
            form.add(expressionField);
            Label result = new Label("result", parameters.get("result"));
            form.add(result);
//            add(errorMessages);
//
//            StringValue resultValue = parameters.get("expressionField");
//            final Label result = new Label("result", 
//                    null == resultValue ? "" : resultValue);
//            add(result);

    }
}
