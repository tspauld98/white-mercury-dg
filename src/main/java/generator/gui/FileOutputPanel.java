/*
 * dgMaster: A versatile, open source data generator.
 *(c) 2007 M. Michalakopoulos, mmichalak@gmail.com
 */


package generator.gui;

import generator.engine.ProgressUpdateObserver;
import generator.engine.file.Generator;
import generator.misc.ApplicationContext;
import generator.misc.Constants;
import generator.misc.DataFileDefinition;
import generator.misc.DataFileItem;
import generator.misc.FileOutDataSaver;
import generator.misc.RandomiserType;
//import generator.misc.Constants;
import generator.misc.Utils;
//import generator.gui.SwingWorker;
//import java.lang.reflect.InvocationTargetException;
import java.net.URL;
//import java.util.ArrayList;
import javax.swing.DefaultListModel;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import generator.extenders.RandomiserPanel;
import generator.extenders.RandomiserInstance;
import java.util.Vector;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class FileOutputPanel extends javax.swing.JPanel implements ProgressUpdateObserver
{
    private Logger logger = LogManager.getLogger(FileOutputPanel.class);
    private Vector<RandomiserType> vRandomiserTypes;
    private Vector<RandomiserInstance> vRandomiserInstances;
    private Vector<DataFileDefinition> vDFDs;
    
    private DefaultListModel modelOutData, modelRT, modelRI;
    private ViewPropertiesForm frmProperties;
    private MainForm frmMain;
    private ProgressForm frmProgress;
    
    
    /** Creates new form FileOutputPanel */
    public FileOutputPanel()
    {
        initComponents();
        loadButtonImages();

        ApplicationContext context = ApplicationContext.getInstance();
        this.vRandomiserTypes = context.getRandomiserTypes();
        this.vRandomiserInstances = context.getRandomiserInstances();
        this.vDFDs = context.getDFD();
        
        modelOutData = new DefaultListModel();
        modelRT = new DefaultListModel();
        modelRI = new DefaultListModel();
        
        populateRandomiserTypes();
        radLeft.setSelected(true);
        radComma.setSelected(true);
        
        lstOutData.setModel(modelOutData);
        lstRandomiserTypes.setModel(modelRT);
        lstRandomiserInstances.setModel(modelRI);
        lstRandomiserTypes.setSelectedIndex(0);
    }
    
    
    /**
     * Sets up the buttons.
     */
    private void loadButtonImages()
    {
        URL urlAdd = this.getClass().getClassLoader().getResource("generator/images/list-add-small.png");
        URL urlUp = this.getClass().getClassLoader().getResource("generator/images/go-up.png");
        URL urlDown = this.getClass().getClassLoader().getResource("generator/images/go-down.png");
        URL urlRemFormat = this.getClass().getClassLoader().getResource("generator/images/clear-format.gif");
        URL urlRemSelect = this.getClass().getClassLoader().getResource("generator/images/list-remove-small.png");
        URL urlBrowse = this.getClass().getClassLoader().getResource("generator/images/document-open-small.png");
        URL urlGenerate = this.getClass().getClassLoader().getResource("generator/images/generate-data-small.png");
        URL urlSave = this.getClass().getClassLoader().getResource("generator/images/document-save-small.png");
        
        btnAdd.setIcon(new ImageIcon(urlAdd));
        btnUp.setIcon(new ImageIcon(urlUp));
        btnDown.setIcon(new ImageIcon(urlDown));
        btnRemoveFormat.setIcon(new ImageIcon(urlRemFormat));
        btnRemove.setIcon(new ImageIcon(urlRemSelect));
        btnBrowseSave.setIcon(new ImageIcon(urlBrowse));
        btnGenerate.setIcon(new ImageIcon(urlGenerate));
        btnSave.setIcon(new ImageIcon(urlSave));
    }
    
    
    
    
    /**
     * Loads randomiser types in the RandmomiserTypes list box.
     * On the top of the list "All user defined types" appears.
     * When the user selects this, all randomiserInstances are shown,
     * in the listbox next to the RandomiserTypes listbox
     *
     * <p>Preconditions: a) vRT should not be null,
     *                   b) vRI should not be null,
     *                   c) vDFDs should not be null
     *
     * <p>Post-effects : the panel is constructed, and the listbox of
     *                   RandomiserTypes is filled with RandomiserTypes
     *
     */
    private void populateRandomiserTypes()
    {
        logger.debug("Loading list of randomiser types");
        RandomiserType ri;
        
        modelRT.addElement("All user defined cases");
        for(int i=0; i<vRandomiserTypes.size(); i++)
        {
            ri = vRandomiserTypes.elementAt(i);
            modelRT.addElement(ri.getName());
        }
        logger.debug("Loading list of randomiser types: Done");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lstRandomiserTypes = new javax.swing.JList();
        lstRandomiserInstances = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        radCenter = new javax.swing.JRadioButton();
        radLeft = new javax.swing.JRadioButton();
        radRight = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtWidth = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnViewRI = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtChar = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnRemoveFormat = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstOutData = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFilename = new javax.swing.JTextField();
        btnBrowseSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        radComma = new javax.swing.JRadioButton();
        radTab = new javax.swing.JRadioButton();
        radOther = new javax.swing.JRadioButton();
        txtDelim = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumOfRecs = new javax.swing.JTextField();
        txtNone = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtDefinition = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnGenerate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generated data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
        lstRandomiserTypes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstRandomiserTypes.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                lstRandomiserTypesPropertyChange(evt);
            }
        });
        lstRandomiserTypes.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                lstRandomiserTypesValueChanged(evt);
            }
        });

        lstRandomiserInstances.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstRandomiserInstances.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });

        jLabel9.setText("Optional formatting");

        radCenter.setText("Center");
        radCenter.setMargin(new java.awt.Insets(0, 0, 0, 0));

        radLeft.setText("Left");
        radLeft.setMargin(new java.awt.Insets(0, 0, 0, 0));

        radRight.setText("Right");
        radRight.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel6.setText("Width:");

        txtWidth.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtWidthActionPerformed(evt);
            }
        });

        jLabel7.setText("Alignment:");

        jLabel1.setText("Available types");

        jLabel2.setText("User defined types");

        btnAdd.setText("Add >>");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        btnViewRI.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\document-properties.png"));
        btnViewRI.setText("View type properties");
        btnViewRI.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnViewRIActionPerformed(evt);
            }
        });

        jLabel11.setText("Encl. char.:");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(lstRandomiserTypes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, btnViewRI, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lstRandomiserInstances, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel6)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel11)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel7))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(txtChar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(txtWidth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(radCenter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(radRight)
                                    .add(radLeft))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jLabel9)
                                .add(34, 34, 34)))
                        .add(10, 10, 10))
                    .add(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(7, 7, 7)
                                .add(txtWidth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(9, 9, 9)
                                .add(jLabel6)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel11)
                            .add(txtChar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(radLeft)
                            .add(jLabel7))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(radCenter)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(radRight)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAdd))
                    .add(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lstRandomiserInstances, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .add(lstRandomiserTypes, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnViewRI)
                .addContainerGap())
        );

        jLabel3.setText("Selected data for output");

        btnRemove.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\list-remove-small.png"));
        btnRemove.setText("Remove selected");
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        btnRemoveFormat.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\clear-format.gif"));
        btnRemoveFormat.setText("Remove formats");
        btnRemoveFormat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveFormatActionPerformed(evt);
            }
        });

        btnUp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpActionPerformed(evt);
            }
        });

        btnDown.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDownActionPerformed(evt);
            }
        });

        lstOutData.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstOutData);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnUp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnDown, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4Layout.createSequentialGroup()
                        .add(btnRemoveFormat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 157, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnRemove, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 162, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4Layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 207, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jLabel3)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(94, 94, 94)
                        .add(btnUp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnDown, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnRemoveFormat)
                    .add(btnRemove))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("File properties"));
        jLabel4.setText("Output file:");

        btnBrowseSave.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\document-open-small.png"));
        btnBrowseSave.setText("Browse...");
        btnBrowseSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBrowseSaveActionPerformed(evt);
            }
        });

        jLabel5.setText("Delimiters:");

        radComma.setText("Comma");
        radComma.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radComma.setMargin(new java.awt.Insets(0, 0, 0, 0));

        radTab.setText("Tab");
        radTab.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radTab.setMargin(new java.awt.Insets(0, 0, 0, 0));

        radOther.setText("Other:");
        radOther.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        radOther.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel8.setText("Number of recs.:");

        txtNone.setText("None");
        txtNone.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        txtNone.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(49, 49, 49)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel5)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(radComma)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(radTab)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(radOther)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtDelim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtNone))
                            .add(txtFilename))
                        .add(6, 6, 6)
                        .add(btnBrowseSave))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(25, 25, 25)
                        .add(jLabel8)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtNumOfRecs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(txtFilename, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnBrowseSave))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(radComma)
                    .add(radTab)
                    .add(radOther)
                    .add(txtDelim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtNone))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(txtNumOfRecs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Definition Properties"));
        jLabel10.setText("Name:");

        jLabel12.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane3.setViewportView(txtDescription);

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel12)
                    .add(jLabel10))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtDefinition, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(txtDefinition, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel12)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGenerate.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\generate-data-small.png"));
        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGenerateActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon("C:\\javaprojects\\GenGUI\\images\\document-save-small.png"));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(btnGenerate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSave)
                    .add(btnGenerate))
                .add(47, 47, 47))
        );
        jScrollPane1.setViewportView(jPanel1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveActionPerformed
    {//GEN-HEADEREND:event_btnSaveActionPerformed
        DataFileDefinition dataFile = new DataFileDefinition();
        DataFileItem dataFileItem;
        Vector vDataFileItems;
        String item, riName, options,encloseChar;
        String tokens[];
        int idx, align, width;
        long nRecs;
        String filename, name, numOfRecs, delimiter, description;
        
        //filename
        filename = txtFilename.getText();
        if(filename==null || filename.trim().length()==0)
        {
            JOptionPane.showMessageDialog(this,"Please enter a filename","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //delimiter
        if(radOther.isSelected())
        {
            delimiter = txtDelim.getText();
            if(delimiter==null || delimiter.trim().length()==0)
            {
                JOptionPane.showMessageDialog(this,"Please enter a value for the delimiter","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else if(radComma.isSelected())
            delimiter = ",";
        else
            delimiter = "\t";
        
        //number of records
        numOfRecs = txtNumOfRecs.getText();
        try
        {
            nRecs = Integer.parseInt(numOfRecs);
            if(nRecs<=0)
                nRecs=-1;
        }
        catch(Exception e)
        {
            nRecs = -1;
        }
        if(nRecs==-1)
        {
            JOptionPane.showMessageDialog(this,"Number of records should be an integer positive","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //name
        name = txtDefinition.getText();
        if(name==null || name.trim().length()==0)
        {
            JOptionPane.showMessageDialog(this,"Please enter a name for the saved data","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        description = txtDescription.getText();
        if(description==null)
            description="";
        
        //data items
        vDataFileItems = new Vector();
        for(int i=0; i<modelOutData.size(); i++)
        {
            item = (String)modelOutData.elementAt(i);
            idx = item.indexOf(Constants.LEFT_MARK);
            riName = item.substring(0,idx);
            options= item.substring(idx+1, item.length()-1 ); //xx,yy,zz
            
            //do the parsing of the options substring
            tokens = options.split(",");
            if(tokens[0].equalsIgnoreCase("default"))
                width = Constants.DEFAULT_WIDTH;
            else
            {
                try
                {
                    width = Integer.parseInt(tokens[0]);
                }
                catch(Exception e)
                {
                    logger.error("Problem converting string to integer: " +tokens[0]);
                    width=-1;
                }
            }
            
            if(tokens[1]==null || tokens[1].length()==0 || tokens[1].equalsIgnoreCase("none"))
                encloseChar="";
            else
                encloseChar=tokens[1].substring(0,1);
            
            if(tokens[2].equalsIgnoreCase("left"))
                align = Constants.ALIGN_LEFT;
            else if(tokens[2].equalsIgnoreCase("center"))
                align = Constants.ALIGN_CENTER;
            else
                align = Constants.ALIGN_RIGHT;
            
            dataFileItem = new DataFileItem();
            dataFileItem.setRandomiserInstanceName(riName);
            dataFileItem.setWidth(width);
            dataFileItem.setEncloseChar(encloseChar);
            dataFileItem.setAlignment(align);
            
            vDataFileItems.add(dataFileItem);
        }
        dataFile.setName(name);
        dataFile.setDescription(description);
        dataFile.setDelimiter(delimiter);
        dataFile.setNumOfRecs(nRecs);
        dataFile.setOutFilename(txtFilename.getText());
        dataFile.setOutDataItems(vDataFileItems);
        
        //this either:
        // a) adds the dataFile to the vector,
        // b) replaces an existing dataFile
        // c) does not add anything
        
        boolean toSave = updateDFDVector(vDFDs,dataFile);
        if(!toSave)
            return;
        try
        {
            //data file definition
            FileOutDataSaver fileOutSaver = new FileOutDataSaver();
            fileOutSaver.saveData(vDFDs);
            frmMain.refreshTree();
            ApplicationContext.getInstance().setDFD(vDFDs);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"There was an error while saving the data/refreshing the tree.","Error",JOptionPane.ERROR_MESSAGE);
            logger.error("Text data not saved", e);
            return;
        }
        JOptionPane.showMessageDialog(this,"File definition saved.","Message",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGenerateActionPerformed
    {//GEN-HEADEREND:event_btnGenerateActionPerformed
        final Generator generator = new Generator();
        final ProgressUpdateObserver observer = this;
        final JPanel pnl = this;
        
        SwingWorker worker = new SwingWorker()
        {
            public Object construct()
            {
                boolean found;
                generator.registerObserver(observer);
                generator.setEngineData(vRandomiserTypes,vRandomiserInstances,vDFDs);
                found = generator.setFileDefinitionOutput(txtDefinition.getText());
                if(!found)
                {
                    JOptionPane.showMessageDialog(pnl,"File definition name not found, will do nothing.","Error",JOptionPane.ERROR_MESSAGE);
                    return null;
                }
                generator.generate();
                return null;
            }
        };
        worker.start();
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnBrowseSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBrowseSaveActionPerformed
    {//GEN-HEADEREND:event_btnBrowseSaveActionPerformed
        String inputFile;
        
        JFileChooser chooser = new JFileChooser();
        
        int returnVal = chooser.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            inputFile = chooser.getSelectedFile().getAbsolutePath();
            txtFilename.setText(inputFile);
        }
    }//GEN-LAST:event_btnBrowseSaveActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDownActionPerformed
    {//GEN-HEADEREND:event_btnDownActionPerformed
        int idx = lstOutData.getSelectedIndex();
        if(idx==-1 || idx==modelOutData.getSize()-1)
            return;
        String current = (String) modelOutData.getElementAt(idx);
        String next = (String) modelOutData.getElementAt(idx+1);
        
        modelOutData.setElementAt(current, idx+1);
        modelOutData.setElementAt(next, idx);
        lstOutData.setSelectedIndex(idx+1);
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUpActionPerformed
    {//GEN-HEADEREND:event_btnUpActionPerformed
        int idx = lstOutData.getSelectedIndex();
        if(idx==-1 || idx==0)
            return;
        String current = (String) modelOutData.getElementAt(idx);
        String previous= (String) modelOutData.getElementAt(idx-1);
        
        modelOutData.setElementAt(current, idx-1);
        modelOutData.setElementAt(previous, idx);
        lstOutData.setSelectedIndex(idx-1);
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnRemoveFormatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveFormatActionPerformed
    {//GEN-HEADEREND:event_btnRemoveFormatActionPerformed
        int row = lstOutData.getSelectedIndex();
        if(row==-1)
            return;
        
        String selItem = (String)modelOutData.get(row);
        int idxLeft = selItem.indexOf(Constants.LEFT_MARK);
        String genInstance = selItem.substring(0,idxLeft);
        genInstance = genInstance + "(Default,None,Left)";
        modelOutData.set(row,genInstance);
    }//GEN-LAST:event_btnRemoveFormatActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveActionPerformed
    {//GEN-HEADEREND:event_btnRemoveActionPerformed
        int row = lstOutData.getSelectedIndex();
        if(row==-1)
            return;
        modelOutData.remove(row);
        if(row<modelOutData.size())
            lstOutData.setSelectedIndex(row);
        else if(modelOutData.size()>0)
            lstOutData.setSelectedIndex(modelOutData.size()-1);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnViewRIActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnViewRIActionPerformed
    {//GEN-HEADEREND:event_btnViewRIActionPerformed
        RandomiserType rt=null;
        RandomiserInstance ri=null;
        String className, type;
        RandomiserPanel pnlRandomTypeUserPanel;
        Utils utils = new Utils();
        
        //check that something is selected
        int row = lstRandomiserInstances.getSelectedIndex();
        if(row==-1)
            return;
        
        String selRI = (String)modelRI.getElementAt(row);
        boolean found =false;
        int i=0;
        
        while( i<vRandomiserInstances.size() && !found)
        {
            ri   = vRandomiserInstances.elementAt(i);
            type = ri.getRandomiserType();
            if(ri.getName().equalsIgnoreCase(selRI))
            {
                for(int k=0; k<vRandomiserTypes.size(); k++)
                {
                    rt = vRandomiserTypes.elementAt(k);
                    if(rt.getName().equalsIgnoreCase(type))
                    {
                        className =rt.getGenerator();
                        found = true;
                        break;
                    }
                }
            }
            i++;
        }
        
        
        logger.debug("Panel found:" + found);
        if(found)
        {
            className = rt.getPanel();
            pnlRandomTypeUserPanel = (RandomiserPanel) utils.createObject(className);
            if(pnlRandomTypeUserPanel==null)
            {
                logger.warn("error loading panel:"+className);
                return;
            }
            pnlRandomTypeUserPanel.initialise(ri);
            //create the hosting panel and pass the vector of existing data
            frmProperties = new ViewPropertiesForm();
            frmProperties.setTitle("View properties: "+selRI);
            frmProperties.setPropertiesPanel(pnlRandomTypeUserPanel);
            frmProperties.setVisible(true);
            frmProperties.pack();
        }
    }//GEN-LAST:event_btnViewRIActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        int width;
        String sWidth = txtWidth.getText();
        String enclosingChar = txtChar.getText();
        
        width = 0;
        if(sWidth.trim().length()!=0)
        {
            try
            {
                width = Integer.parseInt(sWidth);
                if(width<=0)
                    width=-1;
            }
            catch(Exception e)
            {
                width=-1;
            }
            if(width==-1)
            {
                JOptionPane.showMessageDialog(this,"Width should be numerical greater than 0","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        int idx = lstRandomiserInstances.getSelectedIndex();
        if(idx==-1)
        {
            JOptionPane.showMessageDialog(this,"Please select a generator first!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String name = (String)modelRI.getElementAt(idx);
        String align;
        if(radLeft.isSelected())
            align=",Left";
        else if(radCenter.isSelected())
            align=",Center";
        else
            align=",Right";
        
        if(width==0)
            sWidth = "Default";
        else
            sWidth = "" + width;
        if(enclosingChar==null || enclosingChar.trim().length()==0)
            enclosingChar = ",None";
        else
            enclosingChar = "," + enclosingChar.substring(0,1);
        
        
        String toAdd = name + Constants.LEFT_MARK + sWidth + enclosingChar+ align + Constants.RIGHT_MARK;
        modelOutData.addElement(toAdd);
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtWidthActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtWidthActionPerformed
    {//GEN-HEADEREND:event_txtWidthActionPerformed
        
    }//GEN-LAST:event_txtWidthActionPerformed

    private void lstRandomiserTypesValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_lstRandomiserTypesValueChanged
    {//GEN-HEADEREND:event_lstRandomiserTypesValueChanged
        if(evt.getValueIsAdjusting() )
            return;
        
        int idx = lstRandomiserTypes.getSelectedIndex();
        if(idx==-1)
            return;
        populateRandomiserInstances( idx );
        if(lstRandomiserInstances.getModel().getSize()>0)
            lstRandomiserInstances.setSelectedIndex(0);
    }//GEN-LAST:event_lstRandomiserTypesValueChanged

    private void lstRandomiserTypesPropertyChange(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_lstRandomiserTypesPropertyChange
    {//GEN-HEADEREND:event_lstRandomiserTypesPropertyChange
        
    }//GEN-LAST:event_lstRandomiserTypesPropertyChange
    
    /**
     * Starts the data genereation process, according to the data file definition name
     * that is currently populated in the txtDefinition field.
     * Uses a SwingWorker thread. The generator class displays a form
     * with a progress bar. Notice, that there is a pending bug here,
     * it would be good if the rest of the GUI was aware of such a possibly
     * lengthy process; currently, it is not!. At least this method should not
     * be re-entrant. This remains to be fixed [*].
     */    
    
    
    
    public void dataGenStarted()
    {
        frmProgress = new ProgressForm();
        
        int width, height, posX, posY;
        
        width  = this.getWidth();
        height = this.getHeight();
        
        frmProgress.setTitle("Progress...");       
        
        posX = this.getX() + (width-frmProgress.getWidth())/2;
        posY = this.getY() + (height-frmProgress.getHeight())/3;
        
        frmProgress.setLocation(posX,posY);
        
        frmProgress.setResizable(false);
        frmProgress.setVisible(true);
        
    }
    
    public void dataGenMaxProgressValue(int maxProgress)
    {
        frmProgress.setProgressMaxValue(maxProgress);
    }
    
    public boolean dataGenProgressContinue(String msg, int progress)
    {
        final int v=progress;
        final String s = msg;
        
        SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
                if(frmProgress!=null)
                {
                    frmProgress.setProgressValue(v);
                    frmProgress.setLabelMessage(s);
                }
            }
        });
        return frmProgress.isInterrupted();
    }
    
    public void dataGenEnd()
    {
        frmProgress.setVisible(false);
        
        if(frmProgress.isInterrupted())
            JOptionPane.showMessageDialog(this,"Data generation process was interrupted by user.","Warning",JOptionPane.WARNING_MESSAGE);
        else
            JOptionPane.showMessageDialog(this,"Data generation done.","Information",JOptionPane.INFORMATION_MESSAGE);
        frmProgress=null;
    }
    
    public void datageGenError(String msg)
    {
        frmProgress.setVisible(false);
        frmProgress=null;
        JOptionPane.showMessageDialog(this,msg,"Information",JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    
    /**
     * Loads the file definition populating the various
     * components.
     *
     * <p>Preconditions: vDFDs should not be null.
     *
     * <p>Post-effects : fields are loaded to the various components.
     *
     * @param fileDefinition - the file definition name to load.
     */
    public void loadExistingDefinition(String fileDefinition)
    {
        logger.debug("Loading existing definition: " +fileDefinition);
        DataFileDefinition dfd;
        Vector<DataFileItem> vDataItems;
        String align, width, encloseChar;
        
        for(int i=0; i<vDFDs.size(); i++)
        {
            dfd = vDFDs.elementAt(i);
            if(dfd.getName().equalsIgnoreCase(fileDefinition))
            {
                vDataItems = dfd.getOutDataItems();
                for(int j=0; j<vDataItems.size(); j++)
                {
                    DataFileItem dataItem = vDataItems.elementAt(j);
                    
                    if(dataItem.getWidth()==Constants.DEFAULT_WIDTH)
                        width = "Default";
                    else
                        width = ""+dataItem.getWidth();
                    if(dataItem.getAlignment()==Constants.ALIGN_LEFT)
                        align = "Left";
                    else if(dataItem.getAlignment()==Constants.ALIGN_CENTER)
                        align = "Center";
                    else
                        align="Right";
                    
                    if(dataItem.getEncloseChar()==null || dataItem.getEncloseChar().length()==0)
                        encloseChar="None";
                    else
                        encloseChar = dataItem.getEncloseChar();
                    modelOutData.addElement(dataItem.getRandomiserInstanceName() + Constants.LEFT_MARK +
                            width + ","+
                            encloseChar + ","+
                            align +
                            Constants.RIGHT_MARK);
                }//for
                txtDefinition.setText( dfd.getName() );
                txtDescription.setText(dfd.getDescription());
                txtFilename.setText(dfd.getOutFilename());
                txtNumOfRecs.setText(""+dfd.getNumOfRecs());
                break;
            }
        }
        logger.debug("Loading existing definition: Done");
    }
    
    
    /**
     * Saves the existing data definition.
     * This means parsing the items in the output fields list,
     * and storing everything in xml.
     *
     */    
    
    /*
     * Checks the vector of the data file definitions, so as to see if the
     * data file definition currently on the panel already exists in the vDFDs
     * vector.
     *
     */
    public boolean updateDFDVector(Vector<DataFileDefinition> vDataFileDefinitions, DataFileDefinition dfdToAdd)
    {
        int existPos, answer;
        DataFileDefinition dfd;
        
        
        //check that this randomiser instance exists
        existPos=-1; answer=0;
        for(int i=0; i<vDataFileDefinitions.size(); i++)
        {
            dfd = vDataFileDefinitions.elementAt(i);
            if(dfd.getName().equalsIgnoreCase(dfdToAdd.getName()))
                existPos=i;
        }
        
        if(existPos!=-1)
        {
            answer = JOptionPane.showConfirmDialog(this,"This file definition already exists, overwrite it?","Confirmation",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
            logger.debug("Name exists and user's selction is (0=yes,1=no):"+answer);
            if(answer==1)
            {
                logger.debug("returning without saving");
                return false;
            }
            vDataFileDefinitions.setElementAt(dfdToAdd,existPos);
            logger.debug("Overwritten existing element at position:"+existPos);
        }
        else
        {
            vDataFileDefinitions.add(dfdToAdd);
            logger.debug("Added one element...");
        }
        return true;
    }
    
    
    //displays a FileChooser dialog for selecting a directory, where the output
    //file will be saved.    
    
    //displays a form where the currently selected randomiser instance,
    // is displayed. This allows the user to check what are the properties
    // of an existing randomiser instance.    
    
    
    //removes the selected data file item from the listbox of the fields
    // that will be in the output of the text files.    
    
    //removes the format of the selected data file item from the listbox of the fields
    // that will be in the output of the text files.
    // (This is the rightmost panel)
    // The format is made up of the following info:
    //     width, enclosing character alignment    
    
    //moves the selected data file output item downwards in the list
    // (This is the rightmost panel)    
    
    //moves the selected data file output item upwards in the list
    // (This is the rightmost panel)    
    
    //adds a randomiser instance(2nd list box) to the
    // data file output items (3rd box from the left - rightmost panel)    
            
    
    //for every randomiser type that is clicked (1st panel on the left)
    // load the randomiser instances that belong to it (2nd panel)    
    
    //populates the 2nd list box with the randomiser instances
    // idx defines which randomiser type to load
    // notice that idx=0 points to the item "All user-defined cases"
    //
    private void populateRandomiserInstances(int idx)
    {
        String randTypeName;
        RandomiserInstance ri;
        RandomiserType rt;
        
        modelRI.removeAllElements();
        if(idx==0)
        {
            for(int i=0; i<vRandomiserInstances.size(); i++)
            {
                ri = vRandomiserInstances.elementAt(i);
                modelRI.addElement( ri.getName() );
            }
        }
        else
        {
            rt=vRandomiserTypes.elementAt(idx-1);
            for(int i=0; i<vRandomiserInstances.size(); i++)
            {
                ri = vRandomiserInstances.elementAt(i);
                if(ri.getRandomiserType().equalsIgnoreCase(rt.getName()))
                {
                    modelRI.addElement( ri.getName() );
                }
            }
        }
    }
    
    void setMainForm(MainForm mainForm)
    {
        this.frmMain = mainForm;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowseSave;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRemoveFormat;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton btnViewRI;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lstOutData;
    private javax.swing.JList lstRandomiserInstances;
    private javax.swing.JList lstRandomiserTypes;
    private javax.swing.JRadioButton radCenter;
    private javax.swing.JRadioButton radComma;
    private javax.swing.JRadioButton radLeft;
    private javax.swing.JRadioButton radOther;
    private javax.swing.JRadioButton radRight;
    private javax.swing.JRadioButton radTab;
    private javax.swing.JTextField txtChar;
    private javax.swing.JTextField txtDefinition;
    private javax.swing.JTextField txtDelim;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtFilename;
    private javax.swing.JRadioButton txtNone;
    private javax.swing.JTextField txtNumOfRecs;
    private javax.swing.JTextField txtWidth;
    // End of variables declaration//GEN-END:variables
    
}
