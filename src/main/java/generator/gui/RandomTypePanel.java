/*
 * dgMaster: A versatile, open source data generator.
 *(c) 2007 M. Michalakopoulos, mmichalak@gmail.com
 */




/*
 * RandomTypePanel.java
 *
 * Created on 26 January 2007, 02:49
 */

package generator.gui;

import generator.misc.ApplicationContext;
import generator.misc.RandomInstanceSaver;
import generator.misc.RandomiserType;
import java.awt.BorderLayout;
import java.net.URL;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import generator.extenders.IGeneratorPanel;
import generator.extenders.RandomiserInstance;

/**
 *
 * @author  Michael
 */
public class RandomTypePanel extends javax.swing.JPanel
{
    private Vector<RandomiserInstance> vRandomInstances;
    private Logger logger = Logger.getLogger(RandomTypePanel.class);
    
    /** Creates new form RandomTypePanel */
    public RandomTypePanel()
    {
        initComponents();
        loadButtonImages();
        this.vRandomInstances = ApplicationContext.getInstance().getRandomiserInstances();
    }
    
    private void loadButtonImages()
    {
        URL urlSave = this.getClass().getClassLoader().getResource("generator/images/document-save-small.png");
        
        btnSave.setIcon(new ImageIcon(urlSave));
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnSave = new javax.swing.JButton();
        pnlUserPanelHolder = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSave.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\document-save-small.png"));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnlUserPanelHolderLayout = new org.jdesktop.layout.GroupLayout(pnlUserPanelHolder);
        pnlUserPanelHolder.setLayout(pnlUserPanelHolderLayout);
        pnlUserPanelHolderLayout.setHorizontalGroup(
            pnlUserPanelHolderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 575, Short.MAX_VALUE)
        );
        pnlUserPanelHolderLayout.setVerticalGroup(
            pnlUserPanelHolderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 422, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlUserPanelHolder, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(pnlUserPanelHolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btnSave)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveActionPerformed
    {//GEN-HEADEREND:event_btnSaveActionPerformed
        IGeneratorPanel     pnlValidator;
        RandomiserInstance riTest;
        int existPos, answer;
        
        pnlValidator = (IGeneratorPanel) pnlUserPanelHolder.getComponent(0);
        if(pnlValidator==null)
        {
            logger.warn("Panel validator is null, nothing is saved, will exit");
            return;
        }
        if( !pnlValidator.isFormValid() )
        {
            logger.warn("Panel validator found, but false validation, nothing is saved, will exit");
            return;
        }
        
        RandomiserInstance ri = pnlValidator.getRandomiserInstance();
        if(ri==null)
        {
            JOptionPane.showMessageDialog(this,"Data was not saved, please check the form","Invalid data",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //check that this randomiser instance exists
        existPos=-1; answer=0;
        for(int i=0; i<vRandomInstances.size(); i++)
        {
            riTest = vRandomInstances.elementAt(i);
            if(riTest.getName().equalsIgnoreCase(ri.getName()))
                existPos=i;
        }
        if(existPos!=-1)
        {
            answer = JOptionPane.showConfirmDialog(this,"This generator name already exists, overwrite it?","Confirmation",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
            logger.debug("Name exists and user's selction is (0=yes,1=no):"+answer);
            if(answer==1)
            {
                logger.debug("returning without saving");
                return;
            }
            vRandomInstances.setElementAt(ri,existPos);
            logger.debug("Overwritten existing element at position:"+existPos);
        }
        else
        {
            vRandomInstances.add(ri);
            logger.debug("Added one element...");
        }
        RandomInstanceSaver riSaver = new RandomInstanceSaver();
        riSaver.saveData(vRandomInstances);
        ApplicationContext.getInstance().setRandomiserInstances(vRandomInstances);
        JOptionPane.showMessageDialog(this,"User-defined generator saved...");
    }//GEN-LAST:event_btnSaveActionPerformed
    
    public void setUserPanel(JPanel pnlUser)
    {
        pnlUserPanelHolder.setLayout( new BorderLayout() );
        pnlUserPanelHolder.add(pnlUser, BorderLayout.CENTER);
        pnlUserPanelHolder.setVisible(true);
        this.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel pnlUserPanelHolder;
    // End of variables declaration//GEN-END:variables
    
}
