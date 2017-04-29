package com.mycompany.ajax.calculator;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.google.code.mathparser.MathParser;
import com.google.code.mathparser.MathParserFactory;
import com.google.code.mathparser.parser.calculation.Result;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import java.util.HashMap;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {
//	private static final long serialVersionUID = 1L;
	Form<Void> form =null;

	public HomePage(final PageParameters parameters) {
		form= new Form<Void>("form");
		 
        final Model<String> model = new Model<String>() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private String location ="";
             public String getObject() {
                return location;
            }
 
             public void setObject(String location) {
                 this.location=location;
             }
 
            };
 
         final TextField <String> expression = new TextField<>("expression",new Model<String>(""));
 
            form.add(expression);
 
            final Label label = new Label("result", model);
            label.setOutputMarkupId(true);
            form.add(label);
 
     AjaxButton ab=new AjaxButton("calculate") {
        /**
		 * 
		 */
//		private static final long serialVersionUID = 1L;

		protected void onSubmit(AjaxRequestTarget target, Form form) {
 
            if (target!=null)
            {
 
            String cyexpression=form.getRequest().getRequestParameters().getParameterValue("expression").toString();
 
            model.setObject(calculate(cyexpression));
            System.out.println("cyexpression " + cyexpression); 
            
            target.add(label);
            }
 
        }
 
    };
 
       form.add(ab);
       add(form);
 
    }
 
    private String calculate(String cyexpression)
    {
 
    	MathParser mathParser = MathParserFactory.create();
        Result result = mathParser.calculate(cyexpression);
        String resultStr = result.doubleValue().toString();
        return resultStr;
    }
}
