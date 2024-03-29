/*
 * DBTableGenField.java
 *
 * Created on 10 June 2007, 02:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package generator.db;

//import generator.db.DBField;
//import generator.db.DBTable;

/**
 *
 * @author Michael
 */
public class DBFieldGenerator extends DBField
{
    private String generator;
    private int generatorType;
    //may need to add a hashtable for generators defined on the fly
    // (aka, randomiser instances that do not exist and are defined in DBTableGenerator)
    
    /** Creates a new instance of DBTableGenField */
    public DBFieldGenerator( String dbFieldName,
                            String dbType,
                            int dbSize,
                            short sqlType,
                            boolean isKey,
                            String generator,
                            int generatorType)
    {
        super(dbFieldName,dbType,dbSize,sqlType,isKey);
        this.generator = generator;
        this.generatorType = generatorType;
    }
    
    public DBFieldGenerator( DBField dbField, String generator, int generatorType)
    {
        super(dbField.getField(),dbField.getType(),dbField.getSize(),dbField.getSql_type(),dbField.isKey());
        this.generator = generator;
        this.generatorType = generatorType;
    }

    
    public void setGenerator(String generator)
    {
        this.generator = generator;
    }
    
    public String getGenerator()
    {
        return generator;
    }
    
    public void setGeneratorType(int generatorType)
    {
        this.generatorType = generatorType;
    }
    
    public int getGeneratorType()
    {
        return generatorType;
    }
    
    public String outputFieldGenerator() {
    	String output = "";
    	
    	output = output + "\t\t\t\t\tField Name:\t" + super.getField() + "\n";
    	output = output + "\t\t\t\t\tField Type:\t" + super.getType() + "\n";
    	output = output + "\t\t\t\t\tField Size:\t" + String.valueOf(super.getSize()) + "\n";
    	output = output + "\t\t\t\t\tIs Key?:\t" + String.valueOf(super.isKey()) + "\n";
    	output = output + "\t\t\t\t\tSQL Type:\t" + String.valueOf(super.getSql_type()) + "\n";
    	output = output + "\t\t\t\t\tGenerator:\t" + generator + "\n";
    	output = output + "\t\t\t\t\tGenerator Type:\t" + String.valueOf(generatorType) + "\n";
    	
    	return output;
    }
}
