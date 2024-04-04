package Model;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.xml.crypto.Data;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author poojithairosha
 */
public class JasperReportTest {

    public static void main(String[] args) {

        try {

            String filePath = "src//reports//grn.jasper";

            HashMap parameters = new HashMap();
            parameters.put("Parameter1", "Poojitha Irosha"); // Supplier Name
            parameters.put("Parameter2", "0762873649"); // Supplier Contact No
            parameters.put("Parameter3", "Kandy"); // Branch
            parameters.put("Parameter4", "+96768907654"); // Branch Contact No
            parameters.put("Parameter5", "1000"); // Payment
            parameters.put("Parameter6", "0.00"); // Balance
            parameters.put("Parameter7", "1000"); // Grand Total
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy hh:mm:ss");
            parameters.put("Parameter8", sdf.format(d)); // Date Time

//            JREmptyDataSource dataSource = new JREmptyDataSource();

            GRNBean g1 = new GRNBean(1, "Beverage", "Nestle", "Milo", 10, 60.00, 600.00);
            
            Vector v = new Vector();
            v.add(g1);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(v);
            JasperPrint jp = JasperFillManager.fillReport(filePath, parameters, dataSource);

            JasperViewer.viewReport(jp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
