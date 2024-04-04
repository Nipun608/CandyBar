package Model;

import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nipun
 */
public class A {

    public static void main(String[] args) {

        try {
            String filePath = "src//reports//test.jrxml";

            JasperReport jr = JasperCompileManager.compileReport(filePath);

            HashMap parameters = new HashMap();
            parameters.put("Parameter1", "abc");
            parameters.put("Parameter2", "123");

             JREmptyDataSource dataSource = new JREmptyDataSource();
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, dataSource);

            JasperViewer.viewReport(jp);

        } catch (Exception e) {
        }

    }
}
