

package generator.panels;
//import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import generator.extenders.RandomiserPanel;
//import generator.extenders.IGeneratorPanel;
import generator.extenders.RandomiserInstance;


public class PanelListItemsSequencer  extends RandomiserPanel
{
    
    Logger logger = LogManager.getLogger(PanelListItemsSequencer.class);
    /** Creates new form PanelDoubleGenerator */
    
    
    /** Creates new form PanelListItemGenerator */
    public PanelListItemsSequencer()
    {
        initComponents();
        radFile.setSelected(true);        
        newModel.addColumn("Item");
        
        tblItems.setModel(newModel);
        enableList(false);
        loadButtonImages();
    }
    
    private void loadButtonImages() {
        URL urlAdd = this.getClass().getClassLoader().getResource("generator/images/list-add-small.png");
        URL urlRemSelect = this.getClass().getClassLoader().getResource("generator/images/list-remove-small.png");
        URL urlBrowse = this.getClass().getClassLoader().getResource("generator/images/document-open-small.png");
        
        btnAddItem.setIcon(new ImageIcon(urlAdd));
        btnRemove.setIcon(new ImageIcon(urlRemSelect));
        btnBrowse.setIcon(new ImageIcon(urlBrowse));
    }
   
    public boolean isFormValid()
    {
        String name;
        String fname, temp;
        int percent, ival;
        Integer intValue;
        
        
        name = txtName.getText().trim();

        //run checks
        if(name.length()==0)
        {
            JOptionPane.showMessageDialog(this,"Please provide a value for the name.","Required field",JOptionPane.ERROR_MESSAGE); 
            return false;
        }        
        
        if(radFile.isSelected())
        {
            fname = txtFilename.getText().trim();
            if(fname.length()==0)
            {
                JOptionPane.showMessageDialog(this,"Please provide a value for the filename.","Required field",JOptionPane.ERROR_MESSAGE); 
                return false;
            }                    
        }
        if(radList.isSelected())
        {
            int listCount = newModel.getRowCount();
            if(listCount<1)
            {
                JOptionPane.showMessageDialog(this,"Please provide at least two items.","Required fields",JOptionPane.ERROR_MESSAGE); 
                return false;
            }                    
        }

        return true;
    }
    
    public RandomiserInstance getRandomiserInstance()
    {
        LinkedHashMap hashmap = new LinkedHashMap();
        RandomiserInstance ri = new RandomiserInstance();
        int rowCount;
        String name, description, fname, item;
        
        //get field values
        name = txtName.getText().trim();
        description = txtDescription.getText().trim();
        ri.setName(name);
        ri.setDescription(description);
        ri.setRandomiserType("ListitemsSequencer");
        
        if(radFile.isSelected())
        {
            fname = txtFilename.getText().trim();
            hashmap.put("inputSource","file");
            hashmap.put("inputFile", fname);
        }
        else
        {
            hashmap.put("inputSource","list");
            rowCount = tblItems.getRowCount();
            hashmap.put("rangesNum",""+rowCount);            

            for(int i = 0; i<rowCount; i++)
            {
                try
                {
                    item      = (String)newModel.getValueAt(i,0);
                    hashmap.put("itemField"+i,""+ item );
                }
                catch(Exception e)
                {
                    logger.error("Problem retrieving table values",e);
                }
            }//for
        }
        hashmap.put("nullField",""+spinNull.getValue());
        ri.setProperties(hashmap);                                
        return ri;        
    }
    
    public void initialise(RandomiserInstance ri)
    {
        HashMap hashmap;
        String inputSource, sFilename, sMax, sIntValue, sItem, sNull;
        int    iMax;
        Integer intValue;
        Object  data[];
        
        txtName.setText(ri.getName());
        txtDescription.setText(ri.getDescription());
        
        hashmap     = ri.getProperties();
        inputSource = (String)hashmap.get("inputSource");
        if( inputSource.equalsIgnoreCase("file") )
        {
            sFilename = (String)hashmap.get("inputFile");
            txtFilename.setText(sFilename);
            enableList(false);
        }
        else
        {
            enableList(true);
            data = new Object[2];
            radList.setSelected(true);
            sMax = (String)hashmap.get("rangesNum");
            try
            {
                iMax = Integer.parseInt(sMax);
                for(int i=0; i<iMax; i++)
                {
                    sItem =(String)hashmap.get("itemField"+i);
                    sIntValue =(String)hashmap.get("percentField"+i);
                    intValue  = Integer.valueOf(sIntValue);                    
                    data[0] = sItem;
                    if(intValue.intValue()==-1)
                        data[1] = "";
                    else
                        data[1] = intValue;
                    newModel.addRow(data);
                }
                sNull  = (String) hashmap.get("nullField");
                spinNull.setValue(Integer.parseInt(sNull));
            }
            catch(Exception e)
            {
                logger.error("Error while setting properties:",e);
            }        
        }
    }
    
    
    private void enableList(boolean status)
    {
        tblItems.setEnabled(status);
        btnRemove.setEnabled(status);
        btnAddItem.setEnabled(status);
        txtItem.setEnabled(status);
        
        txtFilename.setEnabled(!status);
        btnBrowse.setEnabled(!status);
    }    
    
    private DefaultTableModel newModel = new DefaultTableModel();  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFilename = new javax.swing.JTextField();
        radFile = new javax.swing.JRadioButton();
        radList = new javax.swing.JRadioButton();
        btnBrowse = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spinNull = new javax.swing.JSpinner();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Case description"));

        jLabel4.setText("Name:");

        jLabel5.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
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
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
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

        jLabel1.setText("List data:");

        radFile.setText("Use file");
        radFile.setMargin(new java.awt.Insets(0, 0, 0, 0));
        radFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFileActionPerformed(evt);
            }
        });

        radList.setText("Use list");
        radList.setMargin(new java.awt.Insets(0, 0, 0, 0));
        radList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radListActionPerformed(evt);
            }
        });

        btnBrowse.setText("Browse...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jLabel6.setText("New Item:");

        btnAddItem.setText("Add item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblItems);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtItem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(btnAddItem)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnRemove))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtItem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAddItem)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnRemove)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Null:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(radFile)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtFilename, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                    .add(radList))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnBrowse))
            .add(jPanel1Layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(spinNull, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(radFile)
                    .add(txtFilename, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnBrowse))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(radList)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(spinNull, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(3, 3, 3)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveActionPerformed
    {//GEN-HEADEREND:event_btnRemoveActionPerformed
        int row = tblItems.getSelectedRow();
        if(row==-1)
            return;
        newModel.removeRow(row);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddItemActionPerformed
    {//GEN-HEADEREND:event_btnAddItemActionPerformed
        Object  data[];
        String  sItem, sPercent;

        int error=0;
        
        sItem    = txtItem.getText();
        
        data = new Object[1];
        data[0] = sItem;
        
        newModel.addRow(data);
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBrowseActionPerformed
    {//GEN-HEADEREND:event_btnBrowseActionPerformed
        String inputFile;
        
        JFileChooser chooser = new JFileChooser();
        ListFilter filter = new ListFilter();
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            inputFile = chooser.getSelectedFile().getPath();
            txtFilename.setText(inputFile);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void radListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radListActionPerformed
    {//GEN-HEADEREND:event_radListActionPerformed
        enableList(true);
    }//GEN-LAST:event_radListActionPerformed

    private void radFileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_radFileActionPerformed
    {//GEN-HEADEREND:event_radFileActionPerformed
        enableList(false);
    }//GEN-LAST:event_radFileActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radFile;
    private javax.swing.JRadioButton radList;
    private javax.swing.JSpinner spinNull;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtFilename;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
    
}
