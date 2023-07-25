/*
 * dgMaster: A versatile, open source data generator.
 *(c) 2007 M. Michalakopoulos, mmichalak@gmail.com
 */

package generator.panels;
import generator.extenders.RandomiserInstance;
import generator.extenders.RandomiserPanel;
import java.net.URL;
import java.sql.Date;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class PanelSQLDateRandomiser extends RandomiserPanel
{
    Logger logger = LogManager.getLogger(PanelSQLDateRandomiser.class);
    JCheckBox[] chkDays = new JCheckBox[7];
    
    /** Creates new form PanelDateRandomiser */
    public PanelSQLDateRandomiser()
    {
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        initComponents();
        newModel.addColumn("From");
        newModel.addColumn("To");
        newModel.addColumn("Percentage");
        
        tblRanges.setModel(newModel);
        
        //create the days checkboxes
        for(int i=0; i<7; i++)
        {
            chkDays[i] = new JCheckBox(days[i]);
            pnlDays.add(chkDays[i]);
        }
        loadButtonImages();
    }
    
    private void loadButtonImages()
    {
        URL urlAdd = this.getClass().getClassLoader().getResource("generator/images/list-add-small.png");
        URL urlRemSelect = this.getClass().getClassLoader().getResource("generator/images/list-remove-small.png");
        
        btnAdd.setIcon(new ImageIcon(urlAdd));
        btnRemove.setIcon(new ImageIcon(urlRemSelect));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        txtPercent = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        pnlDays = new javax.swing.JPanel();
        spinNull = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRanges = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Case description"));
        jLabel4.setText("Name:");

        jLabel5.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 11));
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Percentages of generated values"));

        btnAdd.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\list-add-small.png"));
        btnAdd.setText("Add range");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\list-remove-small.png"));
        btnRemove.setText("Remove Selected");
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        pnlDays.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Null:");

        jLabel7.setText("Percentage:");

        jLabel1.setText("From:");

        jLabel3.setText("To:");

        jLabel8.setText("Excluding days:");

        jScrollPane2.setViewportView(tblRanges);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(26, 26, 26)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel1)
                                    .add(jLabel3)
                                    .add(jLabel7)
                                    .add(jLabel6)))
                            .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jLabel8)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(spinNull, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(btnAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtFrom)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtTo)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtPercent))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                            .add(pnlDays, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(354, Short.MAX_VALUE)
                        .add(btnRemove)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(txtFrom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(txtTo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel3))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(txtPercent, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAdd))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnRemove)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel8)
                    .add(pnlDays, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(spinNull, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String sFrom, sTo, sPercent,sPattern;
        Date iValues[] = new Date[2];
        Integer intValue;
        int    error=0;
        Object obj[] = new Object[3];
        
        
        sFrom   = txtFrom.getText();
        sTo     = txtTo.getText();
        sPercent= txtPercent.getText();
        
        try
        {
            iValues[0] = Date.valueOf(sFrom);}
        catch(Exception e)
        {
            error=1;}
        
        try
        {
            iValues[1] = Date.valueOf(sTo);}
        catch(Exception e)
        {
            error=2;}
        
        if(error>0)
        {
            JOptionPane.showMessageDialog(this,"Values for the fields From, To should conform to the format yyyy-mm-dd.","Invalid field",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(iValues[0].getTime()>iValues[1].getTime())
        {
            JOptionPane.showMessageDialog(this,"From value should be lower than to value.","Invalid field",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try
        {
            intValue = Integer.parseInt(sPercent);}
        catch(Exception e)
        {
            error=3; intValue = Integer.parseInt("-1");}
        
        
        if(error>0 || intValue.intValue()<=0)
        {
            JOptionPane.showMessageDialog(this,"Percentage field should be a positive integer.","Invalid field",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        obj[0] = iValues[0];
        obj[1] = iValues[1];
        obj[2] = intValue;
        newModel.addRow(obj);
    }//GEN-LAST:event_btnAddActionPerformed
    
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = tblRanges.getSelectedRow();
        if(row==-1)
            return;
        newModel.removeRow(row);
    }//GEN-LAST:event_btnRemoveActionPerformed
    
    public boolean isFormValid()
    {
        String  name,sDateFrom, sDateTo, sPercent;
        Object  objValues[] = new Object[3];
        int     temp,percent;
        Date    dateFrom, dateTo;
        
        //get field values
        name = txtName.getText().trim();
        
        //run checks, empty strings, no data in the table
        if(name.length()==0)
        {
            JOptionPane.showMessageDialog(this,"Please provide a value for the name.","Required field",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(newModel.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(this,"Please add at least one range in the ranges table.","Required field",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //retrieve the values from the table and make sure they are numbers
        //make sure that percentages add up to 100
        percent   = 0;
        for(int i = 0; i<newModel.getRowCount(); i++)
        {
            try
            {
                objValues[0] = (Object) newModel.getValueAt(i,0);
                objValues[1] = (Object) newModel.getValueAt(i,1);
                objValues[2] = (Object) newModel.getValueAt(i,2);
                sDateFrom = objValues[0].toString();
                sDateTo   = objValues[1].toString();
                sPercent  = objValues[2].toString();
                dateFrom  = Date.valueOf(sDateFrom);
                dateTo    = Date.valueOf(sDateTo);
                
                if( dateFrom.getTime() > dateTo.getTime())
                {
                    JOptionPane.showMessageDialog(this,"From date has a higher value than To date.","Invalid field",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                temp = Integer.valueOf(sPercent);
                percent+=temp;
            }
            catch(Exception e)
            {
                logger.warn("Error retrieving data from table",e);
                JOptionPane.showMessageDialog(this,"Values in the table should be dates (from,to) or numerical (percent.).","Invalid field",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if(percent!=100)
        {
            JOptionPane.showMessageDialog(this,"Percentages in the table should add up to 100.","Invalid field",JOptionPane.ERROR_MESSAGE);
            return false;
        }
               
        return true;
    }
    
    public RandomiserInstance getRandomiserInstance()
    {
        RandomiserInstance ri = new RandomiserInstance();
        LinkedHashMap hashmap = new LinkedHashMap();
        String  name,sDateFrom, sDateTo, sPercent, sDays;
        Date    dateFrom, dateTo;
        Object objValues[] = new Object[3];
        int rowCount, error, percent;
        
        ri.setName(txtName.getText());
        ri.setDescription(txtDescription.getText());
        ri.setRandomiserType("SQLDateRandomiser");
        
        error = 0;
        rowCount = tblRanges.getRowCount();
        hashmap.put("rangesNum",""+rowCount);
        for(int i = 0; i<rowCount; i++)
        {
            try
            {
                objValues[0] = (Object) newModel.getValueAt(i,0);
                objValues[1] = (Object) newModel.getValueAt(i,1);
                objValues[2] = (Object) newModel.getValueAt(i,2);
                sDateFrom = objValues[0].toString();
                sDateTo   = objValues[1].toString();
                sPercent  = objValues[2].toString();
                dateFrom  = Date.valueOf(sDateFrom);
                dateTo    = Date.valueOf(sDateTo);
                if( dateFrom.getTime() > dateTo.getTime())
                {
                    logger.warn("Problem retrieving table values, From date is higher than To date");
                    error = i;
                    return null;
                }
                percent = Integer.valueOf(sPercent);
                hashmap.put("fromField"+i, sDateFrom );
                hashmap.put("toField"+i, sDateTo );
                hashmap.put("percentField"+i,""+ percent );
            }
            catch(Exception e)
            {
                logger.warn("Problem retrieving table values",e);
                error = i;
            }
        }
        
        //check the days which may be excluded
        sDays="";
        for(int i=0; i<7; i++)
        {
            if(chkDays[i].isSelected())
                sDays=sDays+"1";
            else
                sDays=sDays+"0";
        }
        if(error>0)
        {
            JOptionPane.showMessageDialog(this,"There is a problem with the data in the table, check log files.","Unresolved problem",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        hashmap.put("nullField",""+spinNull.getValue());
        hashmap.put("selectedDays",sDays);
        ri.setProperties(hashmap);
        return ri;
    }
    
    
    public void initialise(RandomiserInstance ri)
    {
        LinkedHashMap hashmap;
        String sMax, sFromDate, sDateTo, sPercent, sNull, sSelectedDays;
        int    iMax;
        Object objValues[] = new Object[3];
        
        txtName.setText(ri.getName());
        txtDescription.setText(ri.getDescription());
        
        hashmap = ri.getProperties();
        sMax = (String)hashmap.get("rangesNum");
        try
        {
            iMax = Integer.parseInt(sMax);
            for(int i=0; i<iMax; i++)
            {
                sFromDate =(String)hashmap.get("fromField"+i);
                objValues[0] = Date.valueOf(sFromDate);
                sDateTo =(String)hashmap.get("toField"+i);
                objValues[1] = Date.valueOf(sDateTo);
                sPercent =(String)hashmap.get("percentField"+i);
                objValues[2] = Integer.valueOf(sPercent);
                
                newModel.addRow(objValues);
            }
            sNull  = (String) hashmap.get("nullField");
            spinNull.setValue(Integer.parseInt(sNull));
        }
        catch(Exception e)
        {
            logger.warn("Error while setting properties:",e);
        }
        sSelectedDays = (String)hashmap.get("selectedDays");
        try
        {
            for(int i=0; i<7; i++)
            {
                if(sSelectedDays.charAt(i)=='0')
                    chkDays[i].setSelected(false);
                else
                    chkDays[i].setSelected(true);
            }
        }
        catch(Exception e)
        {
            logger.warn("Error retrieving selected days", e);
        }        
    }
    
    private DefaultTableModel newModel = new DefaultTableModel();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlDays;
    private javax.swing.JSpinner spinNull;
    private javax.swing.JTable tblRanges;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPercent;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
    
}
