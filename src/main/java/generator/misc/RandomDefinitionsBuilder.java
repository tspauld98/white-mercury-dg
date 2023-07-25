/*
 * dgMaster: A versatile, open source data generator.
 *(c) 2007 M. Michalakopoulos, mmichalak@gmail.com
 */


package generator.misc;
//import generator.gui.Main;

//import java.io.File;
import java.util.Vector;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
//import org.xml.sax.*;
import javax.xml.parsers.SAXParserFactory;
// import javax.xml.parsers.ParserConfigurationException;
// import javax.xml.parsers.SAXParser;
// import org.xml.sax.helpers.DefaultHandler;

/**
 * Retrieves a Vector of data from an XML file. The user needs to provide a
 * SAXDataHandler which is actually responsible for parsing the XML file.
 * When parsing XMLData the following steps need to carried out:
 * 1. Extend the SAXDataHandler to provide the implementation for a specific parser.
 * 2. set the filename to be parsed - setFilename().
 * 3. set the SAXHandler to be used when parsing the file -setSAXHandler().
 * 4. call the getElements method; this causes the file to be parsed according to
 *    the specified SAXHandler.
 */

public class RandomDefinitionsBuilder
{   
    private String filename;
    private SAXDataHandler saxHandler;
    private Logger logger = LogManager.getLogger(RandomDefinitionsBuilder.class);

    //set the filename to be parsed
    public void setFilename(String filename)
    {
        this.filename = filename;
        logger.debug("Setting filename:"+filename);
    }
    
    
    /**
     * Sets the SAXHandler instance according to which the XML parsing will take place
     */
    public void setSAXHandler(SAXDataHandler saxHandler)
    {
        this.saxHandler = saxHandler;
        logger.debug("Setting SAXHandler:"+saxHandler);
    }
    

    /**
     * Parses the XML file which has been set using setFilename() and returns
     * the parsed data in a vector.
     */    
    public Vector getElements()
    {              
        SAXParserFactory factory = SAXParserFactory.newInstance();  
        Vector vData;
        
        logger.debug("About to parse xml file: " + filename);
        try
        {
            javax.xml.parsers.SAXParser saxParser;
            saxParser = factory.newSAXParser();
            saxParser.parse( this.getClass().getResourceAsStream("/" + filename), saxHandler );
        }
        catch (Throwable err)
        {
            logger.error("Error during parsing xml file",err);
        }
        
        vData = saxHandler.getData();
        logger.debug("Data retrieved:"+vData.size());
        return vData;
    }        
}

