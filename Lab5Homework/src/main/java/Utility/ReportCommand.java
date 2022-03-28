package Utility;

import Exceptions.InvalidReportException;
import Model.Catalog;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;


public class ReportCommand implements Command {
    @Override
    public void command(Catalog catalog) throws InvalidReportException {
        try {
            Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "class,file");
            Velocity.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
            Velocity.setProperty("runtime.log.logsystem.log4j.logger", "VELLOGGER");
            Velocity.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            Velocity.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
            Velocity.init();
            Template template = Velocity.getTemplate("/HTMLdocument.vm");
            VelocityContext context = new VelocityContext();
            context.put("catalog", catalog.getItemList());

            Writer writer = new FileWriter("HTMLreport.html");
            template.merge(context, writer);
            writer.close();
            Desktop.getDesktop().open(new File("HTMLreport.html"));


        } catch (Exception e) {
            throw new InvalidReportException(e);
        }
    }
}

