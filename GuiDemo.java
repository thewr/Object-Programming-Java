/*
 */
package MyDB_Grocery;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


public class GuiDemo extends JPanel implements ListSelectionListener{//ActionListener {
    
//   JTextArea output;
 //  JTable table;
    
    private JList listLeft;
    JList listRight;
    private DefaultListModel listModelLeft;
    DefaultListModel listModelRight; 
    
    
    private static final String addString = "ADD";
    private static final String dropString = "DROP";
    private JButton dropButton;
    private JTextField itemField;
    
    //protected JTextArea textArea;
    private final static String newline = "\n";
    
    public GuiDemo(){
        super(new BorderLayout());//GridBagLayout());
        
        listModelLeft = new DefaultListModel();
        listModelLeft.addElement("Cat Food");
        listModelLeft.addElement("Tomotoes");
        listModelLeft.addElement("Honey");
        listModelLeft.addElement("Lemonade");
        
        listModelRight = new DefaultListModel();
        listModelRight.addElement("Peanut Butter");
        
        
        //Create the listLeft and put in scroll pane
        listLeft = new JList(listModelLeft);
        listLeft.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listLeft.setSelectedIndex(0);
        listLeft.addListSelectionListener(this);
        listLeft.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(listLeft);
        
        //Create drop listLeft
        listRight = new JList(listModelRight);
        listRight.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listRight.setSelectedIndex(0);
        listRight.addListSelectionListener(this);
        listRight.setVisibleRowCount(5);
        JScrollPane listScrollPaneDrop = new JScrollPane(listRight);

        
        JButton addButton = new JButton(addString);
        AddListener addListener = new AddListener(addButton);
        addButton.setActionCommand(addString);
        addButton.addActionListener(addListener);
        addButton.setEnabled(true);
        addButton.setBackground(Color.green);
        addButton.setForeground(Color.white);
        
        dropButton = new JButton(dropString);
        dropButton.setActionCommand(dropString);
        dropButton.addActionListener(new DropListener());
        dropButton.setBackground(Color.red);
        dropButton.setForeground(Color.white);
              
        
        //create Field and add object ActionListener event
        itemField = new JTextField(10);
        itemField.addActionListener(addListener);

        
        //Create a panel that uses BoxLayout
        JLabel label1 = new JLabel("Shopping List");
        JLabel label2 = new JLabel("Database");
      
        Box hBox = Box.createHorizontalBox();
        //panel.setLayout(new BoxLayout(panel,BoxLayout.LINE_AXIS));        
        hBox.add(dropButton);
        hBox.add(Box.createHorizontalGlue());
        hBox.add(Box.createRigidArea(new Dimension(10,0)));
        hBox.add(itemField);
        hBox.add(Box.createRigidArea(new Dimension(10,0)));
        hBox.add(addButton);
        
        Box vBoxList = Box.createVerticalBox();
        label1.setAlignmentX(CENTER_ALIGNMENT);
        label1.setForeground(Color.BLUE);
        
        label2.setForeground(Color.BLUE);
        label2.setAlignmentX(CENTER_ALIGNMENT);
        vBoxList.add(label1);
       // vBoxList.add(Box.createVerticalGlue());
        vBoxList.add(listScrollPane);
        vBoxList.add(label2);
        vBoxList.add(listScrollPaneDrop);

        add(hBox,BorderLayout.SOUTH);
        add(vBoxList,BorderLayout.PAGE_START);
        

       
                 
    }
    
    class DropListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int indexLeft = listLeft.getSelectedIndex();
 
            listModelRight.addElement(listModelLeft.get(indexLeft));
            listModelLeft.remove(indexLeft);
            int size = listModelLeft.getSize();

            if (size == 0) { //Nobody's left, disable firing.
                dropButton.setEnabled(false);

            } else { //Select an indexLeft.
                if (indexLeft == listModelLeft.getSize()) {
                    //removed item in last position
                    indexLeft--;
                }

                listLeft.setSelectedIndex(indexLeft);
                listLeft.ensureIndexIsVisible(indexLeft);
           }
       }
    }
    
       //This listener is shared by the text field and the hire button.
    class AddListener implements ActionListener{ 
        private boolean alreadyEnabled = false;
        private JButton button;
 
        public AddListener(JButton button) {
            this.button = button;
        }
 
        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            String itemName = itemField.getText();
 
            //User didn't type in a unique name...
            if (alreadyInList(itemName)) {
                Toolkit.getDefaultToolkit().beep();
               // itemField.requestFocusInWindow();
               // itemField.selectAll();
                itemField.setText("");
                JOptionPane.showMessageDialog(button, "Error: item(" + itemName + ") is already in list!");
                return;
            }
 
            int indexLeft = listRight.getSelectedIndex(); //get selected indexLeft
            if (indexLeft == -1) { //no selection, so insert at beginning
                indexLeft = 0;
            } else {           //add after the selected item
                indexLeft--;
            }
            
            
            //insert using text_field
           if (!itemName.equals(""))
           {
               listModelLeft.addElement(itemField.getText());
           
              //Reset the text field.
              itemField.requestFocusInWindow();
              itemField.setText("");
           }
            else
           {         
            //insert element using right list
            listModelLeft.addElement(listModelRight.get(listRight.getSelectedIndex()));   
            listModelRight.remove(listRight.getSelectedIndex());
           }
            
           
            //Select the new item and make it visible.
           listLeft.setSelectedIndex(indexLeft);
           //listRight.setSelectedIndex(listRight.getSelectedIndex());
           listLeft.ensureIndexIsVisible(indexLeft);
        }
       //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return (listModelLeft.contains(name)||listModelRight.contains(name));
        }
        
            
               
    }
    
     //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
      //  ListSelectionModel lsm = (ListSelectionModel)e.getSource();
      //  int firstIndex = e.getFirstIndex();
      //  int lastIndex = e.getLastIndex();
        
        boolean isAdjusting = e.getValueIsAdjusting();
        if (!isAdjusting) { 
            if (listLeft.getSelectedIndex() == -1)
                dropButton.setEnabled(false);
            
            else 
                dropButton.setEnabled(true);
        }
    }
    
 /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Shopping List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new GuiDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    
    public static void main(String[] args)
    {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }); 
    }
}
