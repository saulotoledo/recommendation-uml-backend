package br.edu.ufcg.splab.reuml.feature.sequenceprofile;

import br.edu.ufcg.splab.reuml.feature.Measurable;

import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by Thaciana Cerqueira 24/11/2015.
 */
public class PCoACF implements Measurable {

    public static final String NAME = "Presence of combined fragments of the conditional type (\"opt\" e \"alt\")";
    private static final String XPATH_QUERY = "count(//fragment[@*=\"uml:CombinedFragment\"][@interactionOperator=\"alt\"])";

    public PCoACF() {
    }

    public double measureMetric(Document document) {
        double count = 0;

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        try {
            XPathExpression expression = xpath.compile(XPATH_QUERY);
            count = (Double) expression.evaluate(document, XPathConstants.NUMBER);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return count;

        //Para retornar so 0 ou 1 usar o seguinte:
        //return (count > 0.0) ? 1.0 : 0.0;
    }
}
