/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.logica;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import quemquersermillonario.dto.Formulario;
import quemquersermillonario.dto.Pregunta;

/**
 *
 * @author alvaro
 */
public class LogicaFormularios {

    public static boolean generarFormulariosTest(Formulario f) {
        try {
            desordenarPreguntas(f);
            JasperReport jp;

            List<Formulario> list = new ArrayList<>();
            list.add(f);
            JRBeanCollectionDataSource bean = new JRBeanCollectionDataSource(list);
            Map parametros = new HashMap();
            parametros.put("formulario", f);

            File file = new File("src" + File.separator + "informes" + File.separator + "Formulario_Titulo.jasper");
            String path;
            if (file.exists()) {
                path = "src" + File.separator + "informes" + File.separator + "Formulario_Titulo.jasper";
            } else {
                path = ".." + File.separator + "src" + File.separator + "informes" + File.separator + "Formulario_Titulo.jasper";
            }

            JasperPrint print = JasperFillManager.fillReport(path, parametros, bean);
            JasperExportManager.exportReportToPdfFile(print, f.getNombre().trim() + ".pdf");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static Formulario desordenarPreguntas(Formulario f) {
        List<Pregunta> listAux = f.getListaPreguntas();
        f.setListaPreguntas(new ArrayList<Pregunta>());
        while (listAux.size() > 0) {
            int azar = (int) (Math.random() * listAux.size());
            Pregunta p = listAux.get(azar);
            PartidaJugando.desordenarRespuestas(p);
            f.aniadirPegunta(p);
            listAux.remove(azar);
        }
        return f;
    }

}
