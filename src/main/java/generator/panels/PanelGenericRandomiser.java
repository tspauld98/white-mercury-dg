/*
 * GenericRandomiserPanel.java
 *
 * Created on 26 January 2008, 14:07
 */

package generator.panels;

import generator.extenders.RandomiserInstance;
import generator.extenders.RandomiserPanel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author  Administrator
 */
public class PanelGenericRandomiser extends RandomiserPanel
{
    Logger logger = LogManager.getLogger(PanelGenericRandomiser.class);
    
    /** Creates new form GenericRandomiserPanel */
    public PanelGenericRandomiser()
    {
        initComponents();
        newModel.addColumn("Attribute");
        newModel.addColumn("Value");
        tblAttributes.setModel(newModel);
    }
    
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
        jLabel1 = new javax.swing.JLabel();
        txtRandomiserClass = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAttributes = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtKey = new javax.swing.JTextField();
        txtValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Case description"));

        jLabel4.setText("Name:");

        jLabel5.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescription);

        jLabel1.setText("Randomiser:");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel4)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtRandomiserClass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 286, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)))
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
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtRandomiserClass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Attributes & Values"));

        tblAttributes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblAttributes);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Remove Selected");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setText("Key:");

        jLabel3.setText("Value:");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(480, Short.MAX_VALUE)
                .add(btnDelete))
            .add(jPanel3Layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(txtValue)
                        .add(txtKey, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                .addContainerGap(395, Short.MAX_VALUE))
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtKey, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAdd)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDelete))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteActionPerformed
    {//GEN-HEADEREND:event_btnDeleteActionPerformed
        int row = tblAttributes.getSelectedRow();
        if(row==-1)
            return;
        newModel.removeRow(row);        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        String sKey, sValue;
        
        //get field values
        sKey   = txtKey.getText().trim();
        sValue = txtValue.getText().trim();
        
        //run checks, empty strings, no data in the table
        if(sKey.length()==0)
        {
            JOptionPane.showMessageDialog(this,"Please provide a value for the key.","Required field",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(sValue.length()==0)
        {
            JOptionPane.showMessageDialog(this,"Please provide a value for the value.","Required field",JOptionPane.ERROR_MESSAGE);
            return;
        }        
        
        Object objValues[] = new Object[2];
        objValues[0] = sKey;
        objValues[1] = sValue;
        newModel.addRow(objValues);
    }//GEN-LAST:event_btnAddActionPerformed
    
    
    public void initialise(RandomiserInstance ri)
    {
        LinkedHashMap hashmap;
        Object objValues[] = new Object[2];
        
        txtName.setText(ri.getName());
        if( ri.getRandomiserType()!=null && ri.getRandomiserType().trim().length()>0)
        {
            txtRandomiserClass.setText( ri.getRandomiserType() );
        }
        txtDescription.setText(ri.getDescription());
        
        hashmap = ri.getProperties();
        Set<Object> keys = hashmap.keySet();
        Iterator iter = keys.iterator();
        
        try
        {
            while(iter.hasNext())
            {
                Object objKey = iter.next();
                Object objValue = hashmap.get(objKey);
                objValues[0] = objKey;
                objValues[1] = objValue;
                newModel.addRow(objValues);
            }
        }
        catch(Exception e)
        {
            logger.warn("Error while setting properties:",e);
        }
    }
    
    public boolean isFormValid()
    {
        Object objValues[] = new Object[2];
        String sKey, sValue;
        String name, randomiserClass;
        int emptyKeys, emptyValues, length;
        
        
        //get field values
        name = txtName.getText().trim();
        randomiserClass = txtRandomiserClass.getText().trim();
        
        //run checks, empty strings, no data in the table
        if(name.length()==0)
        {
            JOptionPane.showMessageDialog(this,"Please provide a value for the name.","Required field",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(randomiserClass.length()==0)
        {
            JOptionPane.showMessageDialog(this,"Please provide a value for the randomiser class.","Required field",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(newModel.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(this,"Please add at least one range in the ranges table.","Required field",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        length = newModel.getRowCount();
        emptyKeys = 0;
        emptyValues = 0;
        for(int i = 0; i<length; i++)
        {
            try
            {
                objValues[0] = (Object) newModel.getValueAt(i,0);
                objValues[1] = (Object) newModel.getValueAt(i,1);
                
                sKey   = objValues[0].toString();
                sValue = objValues[1].toString();
                
                if( sKey==null || sKey.trim().length()==0)
                {
                    emptyKeys++;
                }
                if( sValue==null || sValue.trim().length()==0)
                {
                    emptyValues++;
                }
            }
            catch(Exception e)
            {
                logger.warn("Error retrieving data from table",e);
                JOptionPane.showMessageDialog(this,"Error while retrieving data from the table","Invalid field",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if( emptyKeys>0 || emptyValues>0 || length==0)
        {
            JOptionPane.showMessageDialog(this,"Not enough data.","Invalid field",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public RandomiserInstance getRandomiserInstance()
    {
        RandomiserInstance ri = new RandomiserInstance();
        LinkedHashMap hashmap = new LinkedHashMap();
        Object objValues[] = new Object[2];
        
        ri.setName(txtName.getText());
        ri.setDescription(txtDescription.getText());
        
        ri.setRandomiserType(txtRandomiserClass.getText());
        int length = newModel.getRowCount();
        for(int i = 0; i<length; i++)
        {
            objValues[0] = (Object) newModel.getValueAt(i,0);
            objValues[1] = (Object) newModel.getValueAt(i,1);
            
            hashmap.put(objValues[0], objValues[1]);
        }
        ri.setProperties(hashmap);
        return ri;
    }
    
    private DefaultTableModel newModel = new DefaultTableModel();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAttributes;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRandomiserClass;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
    
}
