//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Checkbox;
//import java.awt.CheckboxGroup;
//import java.awt.Component;
//import java.awt.Container;
//import java.awt.Dialog;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.Label;
//import java.awt.List;
//import java.awt.Panel;
//import java.awt.TextField;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.io.File;
//import java.util.Formatter;
//import java.util.Scanner;
//
//public class TheWindow extends Frame implements ActionListener {
//    private Button add = new Button("Add");
//    private Button modify = new Button("Modify");
//    private Button delete = new Button("Delete");
//    private Button exit = new Button("Exit");
//
//    private Label tvListLabel = new Label("");
//    private List tvList = new List(10);
//
//    private Label refrigeratorListLabel = new Label("");
//    private List refrigeratorList = new List(10);
//
//    private Panel mainButtonPanel = new Panel();
//    private Panel listPanel = new Panel();
//    private Panel addPanel = new Panel();
//
//    private CheckboxGroup addCheckboxGroup = new CheckboxGroup();
//    private Checkbox addTv = new Checkbox("Add TV", addCheckboxGroup, true);
//    private Checkbox addRefrigerator = new Checkbox("Add Refrigerator", addCheckboxGroup, false);
//
//    private Label brandLabel = new Label("Brand:");
//    private TextField brandTextField = new TextField();
//
//    private Label priceLabel = new Label("Price:");
//    private TextField priceTextField = new TextField();
//
//    private Label thirdLabel = new Label("Size:");
//    private TextField thirdTextField = new TextField();
//
//    private Label forthLabel = new Label("Colour:");
//    private TextField forthTextField = new TextField();
//
//    private Button save = new Button("Save");
//    private Button cancel = new Button("Cancel");
//    
//    private Label errorLabel = new Label("");
//    
//    public TheWindow(String title) {
//        super(title);
//
//        setLayout(new BorderLayout());
//
//        mainButtonPanel.setLayout(new FlowLayout());
//        mainButtonPanel.add(add);
//        mainButtonPanel.add(modify);
//        mainButtonPanel.add(delete);
//        mainButtonPanel.add(exit);
//
//        listPanel.setLayout(new FlowLayout());
//        listPanel.add(tvListLabel);
//        listPanel.add(tvList);
//        listPanel.add(refrigeratorListLabel);
//        listPanel.add(refrigeratorList);
//
//        addPanel.setLayout(new GridLayout(0, 2));
//        addPanel.add(addTv);
//        addPanel.add(addRefrigerator);
//        addPanel.add(brandLabel);
//        addPanel.add(brandTextField);
//        addPanel.add(priceLabel);
//        addPanel.add(priceTextField);
//        addPanel.add(thirdLabel);
//        addPanel.add(thirdTextField);
//        addPanel.add(forthLabel);
//        addPanel.add(forthTextField);
//        addPanel.add(save);
//        addPanel.add(cancel);
//        
//        mainButtonPanel.add(errorLabel);
//
//        add(listPanel, BorderLayout.NORTH);
//        add(mainButtonPanel, BorderLayout.CENTER);
//        
//        add.addActionListener(this);
//        modify.addActionListener(this);
//        delete.addActionListener(this);
//        exit.addActionListener(this);
//        save.addActionListener(this);
//        cancel.addActionListener(this);
//        
//        addTv.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                	thirdLabel.setText("Size:");
//                    forthLabel.setText("Colour:");
//                }
//            }
//        });
//
//        addRefrigerator.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                	thirdLabel.setText("Capacity:");
//                    forthLabel.setText("Energetic Class:");
//                }
//            }
//        });
//    }
//    
//    private static TV[] TvCollection = new TV[50];
//    private static Refrigerator[] RefrigeratorCollection = new Refrigerator[50];
//
//    private static int tvCounter;
//    private static int refrigeratorCounter;
//    
//    private boolean lastButtonAdd = false;
//    private boolean lastButtonModify = false;
//
//    private static void loadTvFile() {
//        Scanner tvFile = null;
//        String tvFilePath;
//        String[] tvData;
//
//        try {
//            tvFile = new Scanner(new File("TV.txt"));
//        } catch (Exception e) {
//            System.err.println("Error opening files");
//            System.exit(1);
//        }
//
//        while (tvFile.hasNext()) {
//            tvFilePath = tvFile.nextLine();
//            tvData = tvFilePath.split(" ");
//            TvCollection[tvCounter++] = new TV(tvData[0], Integer.parseInt(tvData[1]), Integer.parseInt(tvData[2]), tvData[3]);
//        }
//
//        tvFile.close();
//    }
//
//    private static void loadRefrigeratorFile() {
//        Scanner refrigeratorFile = null;
//
//        String refrigeratorPath;
//        String[] refrigeratorData;
//
//        try {
//            refrigeratorFile = new Scanner(new File("Refrigerator.txt"));
//        } catch (Exception e) {
//            System.err.println("Error opening files");
//            System.exit(1);
//        }
//
//        while (refrigeratorFile.hasNext()) {
//            refrigeratorPath = refrigeratorFile.nextLine();
//            refrigeratorData = refrigeratorPath.split(" ");
//            RefrigeratorCollection[refrigeratorCounter++] = new Refrigerator(refrigeratorData[0], Integer.parseInt(refrigeratorData[1]), Integer.parseInt(refrigeratorData[2]), refrigeratorData[3]);
//        }
//
//        refrigeratorFile.close();
//    }
//
//    public void displayInList() {
//        for (int i = 0; i < tvCounter; i++) {
//            tvList.add(TvCollection[i].toString());
//        }
//
//        for (int i = 0; i < refrigeratorCounter; i++) {
//            refrigeratorList.add(RefrigeratorCollection[i].toString());
//        }
//    }
//    
//    private static void saveTvFile() {
//        Formatter tvFile;
//
//        try {
//            tvFile = new Formatter("TV.txt");
//            for (int i = 0; i < tvCounter; i++) {
//                TV tv = TvCollection[i];
//                tvFile.format("%s %d %d %s\r\n",
//                        tv.getBrand(), tv.getPrice(), tv.getSize(), tv.getColour());
//            }
//            tvFile.close();
//        } catch (Exception e) {
//            System.err.println("Error creating tv file");
//            System.exit(1);
//        }
//    }
//
//
//  
//  private static void saveRefrigeratorFile(){
//	  Formatter refrigeratorFile;
//
//      try {
//    	  refrigeratorFile = new Formatter("Refrigerator.txt");
//          for (int i = 0; i < refrigeratorCounter; i++) {
//        	  Refrigerator Refrigerator = RefrigeratorCollection[i];
//              refrigeratorFile.format("%s %d %d %s\r\n",
//            		  Refrigerator.getBrand(), Refrigerator.getPrice(), Refrigerator.getCapacity(), Refrigerator.getEnergeticClass());
//          }
//          refrigeratorFile.close();
//      } catch (Exception e) {
//          System.err.println("Error creating tv file");
//          System.exit(1);
//      }
//}
//  
//  public void clearLists() {
//	    tvList.removeAll();
//	    refrigeratorList.removeAll();
//  }
//  
//  public void clearAdd() {	    
//	    addPanel.setVisible(false);
//}
//  
//  public boolean validateInput() {
//	TextField[] textFields = new TextField[4];
//  	textFields[0] = brandTextField;
//  	textFields[1] = priceTextField;
//  	textFields[2] = thirdTextField;
//  	textFields[3] = forthTextField;
//
//  	for (TextField textField : textFields) {
//  	    if (textField.getText().equals("Field required")) {
//  	    	return false;
//  	    }
//  	} 
//  	 	
//  	return true;
//}
//  
//  private void rearrangeTvCollection(int deletedTVIndex) {
//	    for (int i = deletedTVIndex; i < tvCounter - 1; i++) {
//	        TvCollection[i] = TvCollection[i + 1];
//	    }
//	    TvCollection[tvCounter - 1] = null;
//	    tvCounter--;
//}
//  
//  private void rearrangeRefrigeratorCollection(int deletedRefrigeratorIndex) {
//	    for (int i = deletedRefrigeratorIndex; i < refrigeratorCounter - 1; i++) {
//	    	RefrigeratorCollection[i] = RefrigeratorCollection[i + 1];
//	    }
//	    
//	    RefrigeratorCollection[refrigeratorCounter - 1] = null;
//	    refrigeratorCounter--;
//}
//  
//  private boolean isPanelAdded(Component panel) {
//	    Container parent = panel.getParent();
//	    return parent != null;
//}
//  
//  public String validateTvInput(String brand, String price, String size, String colour) {
//	  
//	  for (int i = 0; i < tvCounter; i++) {
//	        TV existingTVs = TvCollection[i];
//	        if (existingTVs.getBrand().equals(brand) && existingTVs.getPrice() == Integer.parseInt(price) && existingTVs.getSize() == Integer.parseInt(size) && existingTVs.getColour().equals(colour)) {
//	            return "TV with identical details already exists.";
//	        }
//	    }
//
//	    String[] allowedTvBrands = { "Samsung", "LG", "Sony", "Panasonic", "Philips", "Vizio", "TCL",
//	            "Hisense", "Sharp", "Toshiba", "Sanyo", "RCA", "Haier", "Skyworth",
//	            "Hitachi", "JVC", "Element", "Westinghouse", "Grundig", "Polaroid" };
//	    
//	    boolean TVbrandAllowed = false;
//	    for (String allowedTvBrand : allowedTvBrands) {
//	        if (brand.equalsIgnoreCase(allowedTvBrand)) {
//	            TVbrandAllowed = true;
//	            break;
//	        }
//	    }
//	    
//	    if (!TVbrandAllowed) {
//	        return "Enter a valid TV brand.";
//	    }
//
//	    int priceValue = Integer.parseInt(price);
//	    if (priceValue < 100 || priceValue > 100000) {
//	        return "Price value must be between 100$ and 100,000$";
//	    }
//
//	    int sizeValue = Integer.parseInt(size);
//	    if (sizeValue < 50 || sizeValue > 200) {
//	        return "Enter a valid TV size (must be between 50 and 200)";
//	    }
//
//	    String[] allowedColors = { "Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "White", "Black", "Gray", "Purple",
//	            "Orange", "Brown", "Pink", "Turquoise", "Lavender", "Maroon", "Olive", "Teal", "Beige", "Navy",
//	            "Indigo", "Charcoal", "Coral", "Gold", "Silver" };
//	    
//	    boolean colorAllowed = false;
//	    for (String allowedColor : allowedColors) {
//	        if (colour.equalsIgnoreCase(allowedColor)) {
//	            colorAllowed = true;
//	            break;
//	        }
//	    }
//	    
//	    if (!colorAllowed) {
//	        return "Enter a valid colour.";
//	    }
//
//	    return "";
//}
//
//  public String validateRefrigeratorInput(String brand, String price, String capacity, String energeticClass) {
//	    
//	    for (int i = 0; i < refrigeratorCounter; i++) {
//            Refrigerator existingRefrigerators = RefrigeratorCollection[i];
//            if (existingRefrigerators.getBrand().equals(brand) && existingRefrigerators.getPrice() == Integer.parseInt(price) && existingRefrigerators.getCapacity() == Integer.parseInt(capacity) && existingRefrigerators.getEnergeticClass().equals(energeticClass)) {
//                return "Refrigerator with identical details already exists.";
//            }
//        }
//
//	    String[] allowedRefrigeratorBrands = { "Samsung", "LG", "Whirlpool", "GE Appliances", "KitchenAid", "Frigidaire", "Bosch", 
//                "Electrolux", "Haier", "Panasonic", "Hisense", "Miele", "Viking", "Sub-Zero", 
//                "Thermador", "Kenmore", "Maytag", "Amana", "Danby", "Fisher & Paykel", "Liebherr" };
//   
//	    boolean RefrigeratorbrandAllowed = false;
//	    for (String allowedRefrigeratorBrand : allowedRefrigeratorBrands) {
//	        if (brand.equalsIgnoreCase(allowedRefrigeratorBrand)) {
//	        	RefrigeratorbrandAllowed = true;
//	            break;
//	        }
//	    }
//	    
//	    if (!RefrigeratorbrandAllowed) {
//	        return "Enter a valid Refrigerator brand.";
//	    }
//
//	    int priceValue = Integer.parseInt(price);
//	    if (priceValue < 100 || priceValue > 100000) {
//	        return "Price value must be between 100$ and 100,000$";
//	    }
//
//	    int capacityValue = Integer.parseInt(capacity);
//	    if (capacityValue < 100 || capacityValue > 1000) {
//	        return "Enter a valid Refrigerator Capacity (must be between 100 and 1000)";
//	    }
//
//	    String[] allowedEnergeticClasses = {"A", "B", "C", "D", "E", "F", "G"};
//	    
//	    boolean energeticClassAllowed = false;
//	    for (String allowedEnergeticClass : allowedEnergeticClasses) {
//	        if (energeticClass.equalsIgnoreCase(allowedEnergeticClass)) {
//	        	energeticClassAllowed = true;
//	            break;
//	        }
//	    }
//	    
//	    if (!energeticClassAllowed) {
//	        return "Enter a valid Energetic class (must be between A-G).";
//	    }
//
//	    return "";
//}
// 
//	    public void displayErrorMessage(String errorMessage) {
//	    	
//	        Dialog errorDialog = new Dialog(this, "Error", true);
//	        errorDialog.setLayout(new BorderLayout());
//	        Label errorLabel = new Label(errorMessage);
//	        Button closeButton = new Button("Close");
//	        
//	        closeButton.addActionListener(new ActionListener() {
//	            public void actionPerformed(ActionEvent e) {
//	                errorDialog.dispose();
//	            }
//	        });
//	        
//	        errorDialog.add(errorLabel, BorderLayout.CENTER);
//	        errorDialog.add(closeButton, BorderLayout.SOUTH);
//	        errorDialog.pack();
//	        errorDialog.setVisible(true);
//	    }
//
//  
//  public void actionPerformed(ActionEvent e) {      	
//	    if (e.getSource() == exit) {
//	        System.exit(0);
//	    }
//
//	    if (e.getSource() == add) {
//	        lastButtonAdd = true;
//	        lastButtonModify = false;
//	        add(addPanel, BorderLayout.SOUTH);
//	        
//	        addTv.setVisible(true);
//	        addRefrigerator.setVisible(true);           
//	        addPanel.setVisible(true);
//	        
//	        pack();
//	    }
//	    
//	    if (e.getSource() == cancel) {
//	        remove(addPanel);
//	        pack(); 
//	    }
//	            
//	    else if ((e.getSource() == save) && (validateInput())) {        	      	
//	        if (lastButtonAdd) {
//	            addTv.setVisible(true); 
//	            addRefrigerator.setVisible(true);  
//	            
//	            TextField[] textFields = new TextField[4];
//	            textFields[0] = brandTextField;
//	            textFields[1] = priceTextField;
//	            textFields[2] = thirdTextField;
//	            textFields[3] = forthTextField;
//
//	            for (TextField textField : textFields) {
//	                if (textField.getText().isEmpty()) {
//	                    textField.setText("Field required");
//	                }
//	            }
//	            	            
//	            if (addTv.getState()) {
//	                String brand = brandTextField.getText();
//	                String price = priceTextField.getText();
//	                String size = thirdTextField.getText();
//	                String colour = forthTextField.getText();
//
//	                String validationMessage = validateTvInput(brand, price, size, colour);
//	                
//	                if (validationMessage.isEmpty()) {
//	                    
//	                    TvCollection[tvCounter++] = new TV(brand, Integer.parseInt(price), Integer.parseInt(size), colour);
//	                    saveTvFile();
//	                    clearLists();
//	                    displayInList();
//	                    clearAdd();
//	                } 
//	                else {
//	                	displayErrorMessage(validationMessage);
//	                }
//	            }
//
//
//	            else if (addRefrigerator.getState()){
//	                String brand, price, capacity, energeticClass;
//	                        
//	                brand= brandTextField.getText();
//	                price= priceTextField.getText();
//	                capacity= thirdTextField.getText();
//	                
//	                energeticClass= forthTextField.getText();
//	                
//                    String validationMessage = validateRefrigeratorInput(brand, price, capacity, energeticClass);
//	                
//	                if (validationMessage.isEmpty()) {
//	              
//	                RefrigeratorCollection[refrigeratorCounter++] = new Refrigerator(brand, Integer.parseInt(price), Integer.parseInt(capacity), energeticClass);
//	                
//	                saveRefrigeratorFile();               
//	                clearLists();
//	                displayInList();
//	                clearAdd();
//	                }
//	                else {
//	                	displayErrorMessage(validationMessage);
//	                }
//	            }
//	        }
//	                
//	        else if (lastButtonModify) {
//	            
//	            TextField[] textFields = new TextField[4];
//	            textFields[0] = brandTextField;
//	            textFields[1] = priceTextField;
//	            textFields[2] = thirdTextField;
//	            textFields[3] = forthTextField;
//
//	            for (TextField textField : textFields) {
//	                if (textField.getText().isEmpty()) {
//	                    textField.setText("Field required");
//	                    return;
//	                }
//	            }
//
//	            int selectedTVIndex = tvList.getSelectedIndex();
//	            int selectedRefrigeratorIndex = refrigeratorList.getSelectedIndex();
//
//	            if (selectedTVIndex != -1 || selectedRefrigeratorIndex != -1) {
//	            	if (selectedTVIndex != -1) {
//	            	    String brand = brandTextField.getText();
//	            	    String price = priceTextField.getText();
//	            	    String size = thirdTextField.getText();
//	            	    String colour = forthTextField.getText();
//
//	            	    String TVvalidationMessage = validateTvInput(brand, price, size, colour);
//
//	            	    if (TVvalidationMessage.isEmpty()) {
//	            	        TV selectedTV = TvCollection[selectedTVIndex];
//	            	        selectedTV.setBrand(brand);
//	            	        selectedTV.setPrice(Integer.parseInt(price));
//	            	        selectedTV.setSize(Integer.parseInt(size));
//	            	        selectedTV.setColour(colour);
//
//	            	        clearLists();
//	            	        displayInList();
//	            	    } else {
//	            	    	displayErrorMessage(TVvalidationMessage);
//	            	    }
//	            	}
//	                }
//	            
//	            if (selectedRefrigeratorIndex != -1) {
//            	    String brand = brandTextField.getText();
//            	    String price = priceTextField.getText();
//            	    String capacity = thirdTextField.getText();
//            	    String energeticClass = forthTextField.getText();
//
//            	    String RefrigeratorvalidationMessage = validateRefrigeratorInput(brand, price, capacity, energeticClass);
//
//            	    if (RefrigeratorvalidationMessage.isEmpty()) {
//            	    	Refrigerator selectedRefrigerator = RefrigeratorCollection[selectedRefrigeratorIndex];
//
//            	    	selectedRefrigerator.setBrand(brand);
//            	    	selectedRefrigerator.setPrice(Integer.parseInt(price));
//            	    	selectedRefrigerator.setCapacity(Integer.parseInt(capacity));
//            	    	selectedRefrigerator.setEnergeticClass(energeticClass);
//
//            	        clearLists();
//            	        displayInList();
//            	    }
//            	    else {
//            	    	displayErrorMessage(RefrigeratorvalidationMessage);
//            	    }
//            	}
//	        }
//	            else {
//	                System.out.println("Select an item to modify");
//	            }
//
//	            pack();
//	        }
//	        
//
//	    if (e.getSource() == delete) {		
//	        int selectedTVIndex = tvList.getSelectedIndex();
//	        int selectedRefrigeratorIndex = refrigeratorList.getSelectedIndex();
//	        
//	        if (selectedTVIndex != -1 || selectedRefrigeratorIndex != -1) {
//	            
//	            Dialog deleteConfirmationDialog = new Dialog(this, "Delete Confirmation", true);
//	            deleteConfirmationDialog.setLayout(new BorderLayout());
//	            Label confirmationLabel = new Label("Are you sure you want to delete?");
//	            Panel buttonPanel = new Panel();
//	            Button yesButton = new Button("Yes");
//	            Button noButton = new Button("No");
//	            
//	            yesButton.addActionListener(new ActionListener() {
//	                public void actionPerformed(ActionEvent e) {
//	                    
//	                    if (selectedTVIndex != -1) {
//	                        
//	                        TvCollection[selectedTVIndex] = null;
//	                        rearrangeTvCollection(selectedTVIndex);
//	                        saveTvFile();
//	                    } 
//	                    
//	                    else if (selectedRefrigeratorIndex != -1) {
//	                        
//	                        RefrigeratorCollection[selectedRefrigeratorIndex] = null;
//	                        rearrangeRefrigeratorCollection(selectedRefrigeratorIndex);
//	                        saveRefrigeratorFile();
//	                    }
//	                    
//	                    clearLists();
//	                    displayInList();
//	                    deleteConfirmationDialog.dispose();
//	                }
//	            });
//	            
//	            noButton.addActionListener(new ActionListener() {
//	                public void actionPerformed(ActionEvent e) {
//	                    deleteConfirmationDialog.dispose();
//	                }
//	            });
//
//	            buttonPanel.add(yesButton);
//	            buttonPanel.add(noButton);
//	            deleteConfirmationDialog.add(confirmationLabel, BorderLayout.CENTER);
//	            deleteConfirmationDialog.add(buttonPanel, BorderLayout.SOUTH);
//	            deleteConfirmationDialog.pack();
//	            deleteConfirmationDialog.setVisible(true);
//	        }
//	        
//	        else {
//	            System.out.println("Select an item to delete");         
//	        }
//	    }
//	    
//
//	    if (e.getSource() == modify) {
//	        lastButtonAdd = false;
//	        lastButtonModify = true;
//	        
//	        addTv.setVisible(false);
//	        addRefrigerator.setVisible(false);
//	        
//	        int selectedTVIndex = tvList.getSelectedIndex();
//	        int selectedRefrigeratorIndex = refrigeratorList.getSelectedIndex();
//	        addPanel.setVisible(true);
//
//	        if (selectedTVIndex != -1 || selectedRefrigeratorIndex != -1) {
//	            if ((addPanel != null) && (!isPanelAdded(addPanel))) {
//	                add(addPanel, BorderLayout.SOUTH);
//	            }
//
//	            if (selectedTVIndex != -1) {
//	                TV selectedTV = TvCollection[selectedTVIndex];
//	                
//	                brandTextField.setText(selectedTV.getBrand());
//	                priceTextField.setText(String.valueOf(selectedTV.getPrice()));
//	                thirdTextField.setText(String.valueOf(selectedTV.getSize()));
//	                forthTextField.setText(selectedTV.getColour());
//	            }
//	            else if (selectedRefrigeratorIndex != -1) {
//	                Refrigerator selectedRefrigerator = RefrigeratorCollection[selectedRefrigeratorIndex];
//	                
//	                brandTextField.setText(selectedRefrigerator.getBrand());
//	                priceTextField.setText(String.valueOf(selectedRefrigerator.getPrice()));
//	                thirdTextField.setText(String.valueOf(selectedRefrigerator.getCapacity()));
//	                forthTextField.setText(selectedRefrigerator.getEnergeticClass());
//	            }
//
//	            pack();
//	        }
//	        else {
//	            System.out.println("Select an item to modify");
//	        }
//	    }
//	}
//
//    public static void main(String[] args) {
//        loadTvFile();
//        loadRefrigeratorFile();
//
//        TheWindow main = new TheWindow("Program");
//
//        main.displayInList();
//        main.pack();
//        main.setVisible(true); 
//  }
// }
