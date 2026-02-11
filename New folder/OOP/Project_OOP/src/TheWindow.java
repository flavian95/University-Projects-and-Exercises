import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Formatter;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class TheWindow extends Frame implements ActionListener {
	private Button load = new Button("Load");
    private Button delete = new Button("Delete");
    private Button exit = new Button("Exit");

	private List deviceList = new List(10);
    private List tvList = new List(10);

    private List refrigeratorList = new List(10);

    private Panel mainButtonPanel = new Panel();
    private Panel listPanel = new Panel();
    private Panel addPanel = new Panel();

    private CheckboxGroup addCheckboxGroup = new CheckboxGroup();
    private Checkbox addTv = new Checkbox("Add TV", addCheckboxGroup, true);
    private Checkbox addRefrigerator = new Checkbox("Add Refrigerator", addCheckboxGroup, false);

    private Label brandLabel = new Label("Index to delete:");
    private TextField brandTextField = new TextField();

    private Button deleteItem = new Button("Delete given item");
    private Button cancel = new Button("Cancel");
    
    private Label errorLabel = new Label("");
    
    public TheWindow(String title) {
		super(title);
	
		setLayout(new BorderLayout());
		
		mainButtonPanel.setLayout(new FlowLayout());
		mainButtonPanel.add(load);
		mainButtonPanel.add(delete);
		mainButtonPanel.add(exit);
		
		listPanel.setLayout(new FlowLayout());
		listPanel.add(new Label("All Devices:"));
		listPanel.add(deviceList);
		
		addPanel.setLayout(new GridLayout(0, 2));
		addPanel.add(addTv);
		addPanel.add(addRefrigerator);
		addPanel.add(brandLabel);
		addPanel.add(brandTextField);
		addPanel.add(deleteItem);
		addPanel.add(cancel);
		
		mainButtonPanel.add(errorLabel);
	
		add(listPanel, BorderLayout.NORTH);
		add(mainButtonPanel, BorderLayout.CENTER);
	
		load.addActionListener(this);
		delete.addActionListener(this);
		exit.addActionListener(this);
		deleteItem.addActionListener(this);
		cancel.addActionListener(this);

	}	
    
    private static HiperMarket[] TvCollection = new HiperMarket[50];
    private static SuperMarket[] RefrigeratorCollection = new SuperMarket[50];

    private static int tvCounter;
    private static int refrigeratorCounter;

    private static void loadDevicesFile() {
		Scanner deviceFile = null;
		
		try {
			deviceFile = new Scanner(new File("Shop.txt"));
			
			while (deviceFile.hasNextLine()) {
				String line = deviceFile.nextLine();
				String[] parts = line.split(":");
				String type =
						parts[0].trim();
				String[] attributes = parts[1].trim().split(" ");

				if (type.equals("HiperMarket")) {
					TvCollection[tvCounter++] = new HiperMarket(attributes[0], Integer.parseInt(attributes[1]), attributes[2], Integer.parseInt(attributes[3]));
				}
				else if (type.equals("SuperMarket")) {
					RefrigeratorCollection[refrigeratorCounter++] = new SuperMarket(attributes[0], Integer.parseInt(attributes[1]), attributes[2], Integer.parseInt(attributes[3]));
				}
			}
		}
		catch (Exception e) {
			System.err.println("Error opening file: " + e);
			System.exit(1);
		}
		finally {
			if (deviceFile != null) {
				deviceFile.close();
			}
		}
	}


	private static void saveDevicesFile() {
		Formatter deviceFile = null;
		
		try {
			deviceFile = new Formatter("Devices.txt");
			
			for (int i = 0; i < tvCounter; i++) {
				HiperMarket tv = TvCollection[i];
				deviceFile.format("HiperMarket: %s %d %s %d\r\n", tv.getName(), tv.getStartYear(), tv.getAddress(), tv.getNrOfEmployees());
			}
			
			for (int i = 0; i < refrigeratorCounter; i++) {
				SuperMarket refrigerator = RefrigeratorCollection[i];
				deviceFile.format("SuperMarket: %s %d %s %d\r\n", refrigerator.getName(), refrigerator.getStartYear(), refrigerator.getAddress(), refrigerator.getSalesVolume());
			}
		}
		
		catch (Exception e) {
			System.err.println("Error modifying file: " + e);
		}
		
		finally {
			if (deviceFile != null) {
				deviceFile.close();
			}
		}
	}
	
	public void displayInList() {
	    deviceList.removeAll();
	    
	    for (int i = 0; i < tvCounter; i++) {
	        String tvItem = TvCollection[i].toString();
	        deviceList.add(tvItem);
	        System.out.println(tvItem);
	    }
	    
	    for (int i = 0; i < refrigeratorCounter; i++) {
	        String fridgeItem = RefrigeratorCollection[i].toString();
	        deviceList.add(fridgeItem);
	        System.out.println(fridgeItem);
	    }
	}

  
  
  public void clearLists() {
	    tvList.removeAll();
	    refrigeratorList.removeAll();
  }
  
  public void clearAdd() {	    
	    addPanel.setVisible(false);
}
  
//	public boolean validateInput() {
//		TextField[] textFields = new TextField[4];
//		textFields[0] = brandTextField;
//		textFields[1] = priceTextField;
//		textFields[2] = thirdTextField;
//		textFields[3] = forthTextField;
//
//		for (TextField textField : textFields) {
//			if (textField.getText().equals("Field required")) {
//				return false;
//			}
//		} 
//			
//		return true;
//	}
// 
//	public void displayErrorMessage(String errorMessage) {
//		
//		Dialog errorDialog = new Dialog(this, "Error", true);
//		errorDialog.setLayout(new BorderLayout());
//		Label errorLabel = new Label(errorMessage);
//		Button closeButton = new Button("Close");
//		
//		closeButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				errorDialog.dispose();
//			}
//		});
//		
//		errorDialog.add(errorLabel, BorderLayout.CENTER);
//		errorDialog.add(closeButton, BorderLayout.SOUTH);
//		errorDialog.pack();
//		errorDialog.setVisible(true);
//	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exit) {
			System.exit(0);
		}
		
		
		else if (e.getSource() == cancel) {
			remove(addPanel);
			pack(); 
		}
		
		else if (e.getSource() == load) {
			loadDevicesFile();
			displayInList();
//			pack(); 
		}
		
		else if (e.getSource() == deleteItem) {
			 saveDevicesFile(); 
		}

		
		else if (e.getSource() == delete) {
			int selectedIndex = deviceList.getSelectedIndex();
			
			if (selectedIndex == -1) {
				System.out.println("Select an item to delete");
			}
			else {
				confirmAndDelete(selectedIndex);
			}
		}
	}
	
	private void deleteGiveItem() {
//		TextField[] textFields = {brandTextField, priceTextField, thirdTextField, forthTextField};
//		
//		for (TextField textField : textFields) {
//			if (textField.getText().isEmpty()) {
//				textField.setText("Field required");
//				return; 
//			}
//		}
//	
//		String type = addTv.getState() ? "TV" : "Refrigerator";
//		String brand = brandTextField.getText();
//		String price = priceTextField.getText();
//		String third = thirdTextField.getText();
//		String forth = forthTextField.getText();
//	
//		String validationMessage = type.equals("TV") ? validateTvInput(brand, price, third, forth) : validateRefrigeratorInput(brand, price, third, forth);
//	
//		if (!validationMessage.isEmpty()) {
//			displayErrorMessage(validationMessage);
//			return;
//		}
//	
//		int selectedIndex = deviceList.getSelectedIndex();
//		if (lastButtonModify && selectedIndex != -1) {
//			
//			if (type.equals("TV")) {
//				TV tv = (TV) (selectedIndex < tvCounter ? TvCollection[selectedIndex] : null);
//				if (tv != null) {
//					tv.setBrand(brand);
//					tv.setPrice(Integer.parseInt(price));
//					tv.setSize(Integer.parseInt(third));
//					tv.setColour(forth);
//				}
//			}
//			
//			else {				
//				Refrigerator refrigerator = (Refrigerator) (selectedIndex >= tvCounter ? RefrigeratorCollection[selectedIndex - tvCounter] : null);				
//				if (refrigerator != null) {
//					refrigerator.setBrand(brand);
//					refrigerator.setPrice(Integer.parseInt(price));
//					refrigerator.setCapacity(Integer.parseInt(third));
//					refrigerator.setEnergeticClass(forth);
//				}
//			}
//		}
//		
//		else if (lastButtonAdd) {
//			if (type.equals("TV")) {
//				TvCollection[tvCounter++] = new TV(brand, Integer.parseInt(price), Integer.parseInt(third), forth);
//			}
//			else {
//				RefrigeratorCollection[refrigeratorCounter++] = new Refrigerator(brand, Integer.parseInt(price), Integer.parseInt(third), forth);
//			}
//		}
//	
//		saveDevicesFile(); 
//		displayInList();
//		clearAdd();
//		addPanel.setVisible(false);
//		pack();
	}


	
	private void confirmAndDelete(int index) {
		Dialog deleteConfirmationDialog = new Dialog(this, "Delete Confirmation", true);
		deleteConfirmationDialog.setLayout(new BorderLayout());
		Label confirmationLabel = new Label("Are you sure you want to delete?");
		Panel buttonPanel = new Panel();
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
	
		yesButton.addActionListener(ae -> {
			deleteSelectedItem(index);
			deleteConfirmationDialog.dispose();
		});
	
		noButton.addActionListener(ae -> deleteConfirmationDialog.dispose());
	
		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		deleteConfirmationDialog.add(confirmationLabel, BorderLayout.CENTER);
		deleteConfirmationDialog.add(buttonPanel, BorderLayout.SOUTH);
		deleteConfirmationDialog.pack();
		deleteConfirmationDialog.setVisible(true);
	}
	
	private void deleteSelectedItem(int index) {
		if (index < tvCounter) { 
			rearrangeTvCollection(index);
		}
		else { 
			rearrangeRefrigeratorCollection(index - tvCounter);
		}
		
		saveDevicesFile();
		displayInList();
	}

	
	private void rearrangeTvCollection(int index) {
		for (int i = index; i < tvCounter - 1; i++) {
			TvCollection[i] = TvCollection[i + 1];
		}
		
		TvCollection[tvCounter - 1] = null;
		tvCounter--;
	}
	
	private void rearrangeRefrigeratorCollection(int index) {
		for (int i = index; i < refrigeratorCounter - 1; i++) {
			RefrigeratorCollection[i] = RefrigeratorCollection[i + 1];
		}
		RefrigeratorCollection[refrigeratorCounter - 1] = null;
		refrigeratorCounter--;
	}
	
 

    public static void main(String[] args) {
//        loadDevicesFile();

        TheWindow main = new TheWindow("Program");

        main.displayInList();
        main.pack();
        main.setVisible(true); 
  }
 }




























//public class TheWindow extends Frame implements ActionListener {
//private Button load = new Button("Load");
//private Button delete = new Button("Delete");
//private Button exit = new Button("Exit");
//
//private List deviceList = new List(10);
//private List tvList = new List(10);
//
//private List refrigeratorList = new List(10);
//
//private Panel mainButtonPanel = new Panel();
//private Panel listPanel = new Panel();
//private Panel addPanel = new Panel();
//
//private Label brandLabel = new Label("Index to delete:");
//private TextField brandTextField = new TextField();
//
//private Button deleteItem = new Button("Delete given item");
//private Button cancel = new Button("Cancel");
//
//private Label errorLabel = new Label("");
//
//public TheWindow(String title) {
//	super(title);
//
//	setLayout(new BorderLayout());
//	
//	mainButtonPanel.setLayout(new FlowLayout());
//	mainButtonPanel.add(load);
//	mainButtonPanel.add(delete);
//	mainButtonPanel.add(exit);
//	
//	listPanel.setLayout(new FlowLayout());
//	listPanel.add(new Label("All Devices:"));
//	listPanel.add(deviceList);
//	
//	addPanel.setLayout(new GridLayout(0, 2));
//	addPanel.add(brandLabel);
//	addPanel.add(brandTextField);
//	addPanel.add(deleteItem);
//	addPanel.add(cancel);
//	
//	mainButtonPanel.add(errorLabel);
//
//	add(listPanel, BorderLayout.NORTH);
//	add(mainButtonPanel, BorderLayout.CENTER);
//
//	load.addActionListener(this);
//	delete.addActionListener(this);
//	exit.addActionListener(this);
//	deleteItem.addActionListener(this);
//	cancel.addActionListener(this);
//}	
//
//private static HiperMarket[] TvCollection = new HiperMarket[50];
//private static SuperMarket[] RefrigeratorCollection = new SuperMarket[50];
//
//private static int tvCounter;
//private static int refrigeratorCounter;
//
//private static void loadDevicesFile() {
//	Scanner deviceFile = null;
//	
//	try {
//		deviceFile = new Scanner(new File("Shop.txt"));
//		
//		while (deviceFile.hasNextLine()) {
//			String line = deviceFile.nextLine();
//			String[] parts = line.split(":");
//			String type =
//					parts[0].trim();
//			String[] attributes = parts[1].trim().split(" ");
//
//			if (type.equals("HiperMarket")) {
//				TvCollection[tvCounter++] = new HiperMarket(attributes[0], Integer.parseInt(attributes[1]), attributes[2], Integer.parseInt(attributes[3]));
//			}
//			else if (type.equals("SuperMarket")) {
//				RefrigeratorCollection[refrigeratorCounter++] = new SuperMarket(attributes[0], Integer.parseInt(attributes[1]), attributes[2], Integer.parseInt(attributes[3]));
//			}
//		}
//	}
//	catch (Exception e) {
//		System.err.println("Error opening file: " + e);
//		System.exit(1);
//	}
//	finally {
//		if (deviceFile != null) {
//			deviceFile.close();
//		}
//	}
//}
//
//
//private static void saveDevicesFile() {
//	Formatter deviceFile = null;
//	
//	try {
//		deviceFile = new Formatter("Devices.txt");
//		
//		for (int i = 0; i < tvCounter; i++) {
//			HiperMarket tv = TvCollection[i];
//			deviceFile.format("HiperMarket: %s %d %s %d\r\n", tv.getName(), tv.getStartYear(), tv.getAddress(), tv.getNrOfEmployees());
//		}
//		
//		for (int i = 0; i < refrigeratorCounter; i++) {
//			SuperMarket refrigerator = RefrigeratorCollection[i];
//			deviceFile.format("SuperMarket: %s %d %s %d\r\n", refrigerator.getName(), refrigerator.getStartYear(), refrigerator.getAddress(), refrigerator.getSalesVolume());
//		}
//	}
//	
//	catch (Exception e) {
//		System.err.println("Error modifying file: " + e);
//	}
//	
//	finally {
//		if (deviceFile != null) {
//			deviceFile.close();
//		}
//	}
//}
//
//public void displayInList() {
//    deviceList.removeAll();
//    
//    for (int i = 0; i < tvCounter; i++) {
//        String tvItem = TvCollection[i].toString();
//        deviceList.add(tvItem);
//        System.out.println(tvItem);
//    }
//    
//    for (int i = 0; i < refrigeratorCounter; i++) {
//        String fridgeItem = RefrigeratorCollection[i].toString();
//        deviceList.add(fridgeItem);
//        System.out.println(fridgeItem);
//    }
//}
//
//
//
//public void clearLists() {
//    tvList.removeAll();
//    refrigeratorList.removeAll();
//}
//
//public void clearAdd() {	    
//    addPanel.setVisible(false);
//}
//
////public boolean validateInput() {
////	TextField[] textFields = new TextField[4];
////	textFields[0] = brandTextField;
////	textFields[1] = priceTextField;
////	textFields[2] = thirdTextField;
////	textFields[3] = forthTextField;
////
////	for (TextField textField : textFields) {
////		if (textField.getText().equals("Field required")) {
////			return false;
////		}
////	} 
////		
////	return true;
////}
////
////public void displayErrorMessage(String errorMessage) {
////	
////	Dialog errorDialog = new Dialog(this, "Error", true);
////	errorDialog.setLayout(new BorderLayout());
////	Label errorLabel = new Label(errorMessage);
////	Button closeButton = new Button("Close");
////	
////	closeButton.addActionListener(new ActionListener() {
////		public void actionPerformed(ActionEvent e) {
////			errorDialog.dispose();
////		}
////	});
////	
////	errorDialog.add(errorLabel, BorderLayout.CENTER);
////	errorDialog.add(closeButton, BorderLayout.SOUTH);
////	errorDialog.pack();
////	errorDialog.setVisible(true);
////}
//
//public void actionPerformed(ActionEvent e) {
//	
//	if (e.getSource() == exit) {
//		System.exit(0);
//	}
//	
//	
//	else if (e.getSource() == cancel) {
//		remove(addPanel);
//		pack(); 
//	}
//	
//	else if (e.getSource() == load) {
//		loadDevicesFile();
//		displayInList();
//		
//		pack(); 
//	}
//	
//	else if (e.getSource() == deleteItem) {
//		
//	}
//
//	
//	else if (e.getSource() == delete) {
//		add(addPanel, BorderLayout.SOUTH);          
//		addPanel.setVisible(true);
//		pack();
//	}
//}
//
//private void deleteGiveItem() {
////	TextField[] textFields = {brandTextField, priceTextField, thirdTextField, forthTextField};
////	
////	for (TextField textField : textFields) {
////		if (textField.getText().isEmpty()) {
////			textField.setText("Field required");
////			return; 
////		}
////	}
////
////	String type = addTv.getState() ? "TV" : "Refrigerator";
////	String brand = brandTextField.getText();
////	String price = priceTextField.getText();
////	String third = thirdTextField.getText();
////	String forth = forthTextField.getText();
////
////	String validationMessage = type.equals("TV") ? validateTvInput(brand, price, third, forth) : validateRefrigeratorInput(brand, price, third, forth);
////
////	if (!validationMessage.isEmpty()) {
////		displayErrorMessage(validationMessage);
////		return;
////	}
////
////	int selectedIndex = deviceList.getSelectedIndex();
////	if (lastButtonModify && selectedIndex != -1) {
////		
////		if (type.equals("TV")) {
////			TV tv = (TV) (selectedIndex < tvCounter ? TvCollection[selectedIndex] : null);
////			if (tv != null) {
////				tv.setBrand(brand);
////				tv.setPrice(Integer.parseInt(price));
////				tv.setSize(Integer.parseInt(third));
////				tv.setColour(forth);
////			}
////		}
////		
////		else {				
////			Refrigerator refrigerator = (Refrigerator) (selectedIndex >= tvCounter ? RefrigeratorCollection[selectedIndex - tvCounter] : null);				
////			if (refrigerator != null) {
////				refrigerator.setBrand(brand);
////				refrigerator.setPrice(Integer.parseInt(price));
////				refrigerator.setCapacity(Integer.parseInt(third));
////				refrigerator.setEnergeticClass(forth);
////			}
////		}
////	}
////	
////	else if (lastButtonAdd) {
////		if (type.equals("TV")) {
////			TvCollection[tvCounter++] = new TV(brand, Integer.parseInt(price), Integer.parseInt(third), forth);
////		}
////		else {
////			RefrigeratorCollection[refrigeratorCounter++] = new Refrigerator(brand, Integer.parseInt(price), Integer.parseInt(third), forth);
////		}
////	}
////
////	saveDevicesFile(); 
////	displayInList();
////	clearAdd();
////	addPanel.setVisible(false);
////	pack();
//}
//
//
//
//private void confirmAndDelete(int index) {
//	Dialog deleteConfirmationDialog = new Dialog(this, "Delete Confirmation", true);
//	deleteConfirmationDialog.setLayout(new BorderLayout());
//	Label confirmationLabel = new Label("Are you sure you want to delete?");
//	Panel buttonPanel = new Panel();
//	Button yesButton = new Button("Yes");
//	Button noButton = new Button("No");
//
//	yesButton.addActionListener(ae -> {
//		deleteSelectedItem(index);
//		deleteConfirmationDialog.dispose();
//	});
//
//	noButton.addActionListener(ae -> deleteConfirmationDialog.dispose());
//
//	buttonPanel.add(yesButton);
//	buttonPanel.add(noButton);
//	deleteConfirmationDialog.add(confirmationLabel, BorderLayout.CENTER);
//	deleteConfirmationDialog.add(buttonPanel, BorderLayout.SOUTH);
//	deleteConfirmationDialog.pack();
//	deleteConfirmationDialog.setVisible(true);
//}
//
//private void deleteSelectedItem(int index) {
//	if (index < tvCounter) { 
//		rearrangeTvCollection(index);
//	}
//	else { 
//		rearrangeRefrigeratorCollection(index - tvCounter);
//	}
//	
//	saveDevicesFile();
//	displayInList();
//}
//
//
//private void rearrangeTvCollection(int index) {
//	for (int i = index; i < tvCounter - 1; i++) {
//		TvCollection[i] = TvCollection[i + 1];
//	}
//	
//	TvCollection[tvCounter - 1] = null;
//	tvCounter--;
//}
//
//private void rearrangeRefrigeratorCollection(int index) {
//	for (int i = index; i < refrigeratorCounter - 1; i++) {
//		RefrigeratorCollection[i] = RefrigeratorCollection[i + 1];
//	}
//	RefrigeratorCollection[refrigeratorCounter - 1] = null;
//	refrigeratorCounter--;
//}
//
//
//
//public static void main(String[] args) {
////    loadDevicesFile();
//
//    TheWindow main = new TheWindow("Program");
//
//    main.displayInList();
//    main.pack();
//    main.setVisible(true); 
//}
//}

















// public class TheWindow extends Frame implements ActionListener {
//    private Button add = new Button("Add");
//    private Button modify = new Button("Modify");
//    private Button delete = new Button("Delete");
//    private Button exit = new Button("Exit");
//
//	private List deviceList = new List(10);
//    private List tvList = new List(10);
//
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
//		super(title);
//	
//		setLayout(new BorderLayout());
//		
//		mainButtonPanel.setLayout(new FlowLayout());
//		mainButtonPanel.add(add);
//		mainButtonPanel.add(modify);
//		mainButtonPanel.add(delete);
//		mainButtonPanel.add(exit);
//		
//		listPanel.setLayout(new FlowLayout());
//		listPanel.add(new Label("All Devices:"));
//		listPanel.add(deviceList);
//		
//		addPanel.setLayout(new GridLayout(0, 2));
//		addPanel.add(addTv);
//		addPanel.add(addRefrigerator);
//		addPanel.add(brandLabel);
//		addPanel.add(brandTextField);
//		addPanel.add(priceLabel);
//		addPanel.add(priceTextField);
//		addPanel.add(thirdLabel);
//		addPanel.add(thirdTextField);
//		addPanel.add(forthLabel);
//		addPanel.add(forthTextField);
//		addPanel.add(save);
//		addPanel.add(cancel);
//		
//		mainButtonPanel.add(errorLabel);
//	
//		add(listPanel, BorderLayout.NORTH);
//		add(mainButtonPanel, BorderLayout.CENTER);
//	
//		add.addActionListener(this);
//		modify.addActionListener(this);
//		delete.addActionListener(this);
//		exit.addActionListener(this);
//		save.addActionListener(this);
//		cancel.addActionListener(this);
//	
//		addTv.addItemListener(e -> {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				thirdLabel.setText("Size:");
//				forthLabel.setText("Colour:");
//			}
//		});
//	
//		addRefrigerator.addItemListener(e -> {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				thirdLabel.setText("Capacity:");
//				forthLabel.setText("Energetic Class:");
//			}
//		});
//	}	
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
//    private static void loadDevicesFile() {
//		Scanner deviceFile = null;
//		
//		try {
//			deviceFile = new Scanner(new File("Devices.txt"));
//			
//			while (deviceFile.hasNextLine()) {
//				String line = deviceFile.nextLine();
//				String[] parts = line.split(":");
//				String type =
//						parts[0].trim();
//				String[] attributes = parts[1].trim().split(" ");
//
//				if (type.equals("TV")) {
//					TvCollection[tvCounter++] = new TV(attributes[0], Integer.parseInt(attributes[1]), Integer.parseInt(attributes[2]), attributes[3]);
//				}
//				else if (type.equals("Refrigerator")) {
//					RefrigeratorCollection[refrigeratorCounter++] = new Refrigerator(attributes[0], Integer.parseInt(attributes[1]), Integer.parseInt(attributes[2]), attributes[3]);
//				}
//			}
//		}
//		catch (Exception e) {
//			System.err.println("Error opening file: " + e);
//			System.exit(1);
//		}
//		finally {
//			if (deviceFile != null) {
//				deviceFile.close();
//			}
//		}
//	}
//
//	private static void saveDevicesFile() {
//		Formatter deviceFile = null;
//		
//		try {
//			deviceFile = new Formatter("Devices.txt");
//			
//			for (int i = 0; i < tvCounter; i++) {
//				TV tv = TvCollection[i];
//				deviceFile.format("TV: %s %d %d %s\r\n", tv.getBrand(), tv.getPrice(), tv.getSize(), tv.getColour());
//			}
//			
//			for (int i = 0; i < refrigeratorCounter; i++) {
//				Refrigerator refrigerator = RefrigeratorCollection[i];
//				deviceFile.format("Refrigerator: %s %d %d %s\r\n", refrigerator.getBrand(), refrigerator.getPrice(), refrigerator.getCapacity(), refrigerator.getEnergeticClass());
//			}
//		}
//		
//		catch (Exception e) {
//			System.err.println("Error modifying file: " + e);
//		}
//		
//		finally {
//			if (deviceFile != null) {
//				deviceFile.close();
//			}
//		}
//	}	
//
//
//    public void displayInList() {
//		deviceList.removeAll();
//		
//		for (int i = 0; i < tvCounter; i++) {
//			deviceList.add(TvCollection[i].toString());
//		}
//		
//		for (int i = 0; i < refrigeratorCounter; i++) {
//			deviceList.add(RefrigeratorCollection[i].toString());
//		}
//	}	
//  
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
//	public boolean validateInput() {
//		TextField[] textFields = new TextField[4];
//		textFields[0] = brandTextField;
//		textFields[1] = priceTextField;
//		textFields[2] = thirdTextField;
//		textFields[3] = forthTextField;
//
//		for (TextField textField : textFields) {
//			if (textField.getText().equals("Field required")) {
//				return false;
//			}
//		} 
//			
//		return true;
//	}
//  
//	public String validateTvInput(String brand, String price, String size, String colour) {
//		
//		for (int i = 0; i < tvCounter; i++) {
//				TV existingTVs = TvCollection[i];
//				if (existingTVs.getBrand().equals(brand) && existingTVs.getPrice() == Integer.parseInt(price) && existingTVs.getSize() == Integer.parseInt(size) && existingTVs.getColour().equals(colour)) {
//					return "TV with identical details already exists.";
//				}
//			}
//
//			String[] allowedTvBrands = { "Samsung", "LG", "Sony", "Panasonic", "Philips", "Vizio", "TCL",
//					"Hisense", "Sharp", "Toshiba", "Sanyo", "RCA", "Haier", "Skyworth",
//					"Hitachi", "JVC", "Element", "Westinghouse", "Grundig", "Polaroid" };
//			
//			boolean TVbrandAllowed = false;			
//			for (String allowedTvBrand : allowedTvBrands) {
//				if (brand.equalsIgnoreCase(allowedTvBrand)) {
//					TVbrandAllowed = true;
//					break;
//				}
//			}
//			
//			if (!TVbrandAllowed) {
//				return "Enter a valid TV brand.";
//			}
//
//			int priceValue = Integer.parseInt(price);
//			if (priceValue < 100 || priceValue > 100000) {
//				return "Price value must be between 100$ and 100,000$";
//			}
//
//			int sizeValue = Integer.parseInt(size);
//			if (sizeValue < 50 || sizeValue > 200) {
//				return "Enter a valid TV size (must be between 50 and 200)";
//			}
//
//			String[] allowedColors = { "Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "White", "Black", "Gray", "Purple",
//					"Orange", "Brown", "Pink", "Turquoise", "Lavender", "Maroon", "Olive", "Teal", "Beige", "Navy",
//					"Indigo", "Charcoal", "Coral", "Gold", "Silver" };
//			
//			boolean colorAllowed = false;
//			for (String allowedColor : allowedColors) {
//				if (colour.equalsIgnoreCase(allowedColor)) {
//					colorAllowed = true;
//					break;
//				}
//			}
//			
//			if (!colorAllowed) {
//				return "Enter a valid colour.";
//			}
//
//			return "";
//	}
//
//	public String validateRefrigeratorInput(String brand, String price, String capacity, String energeticClass) {
//			
//			for (int i = 0; i < refrigeratorCounter; i++) {
//				Refrigerator existingRefrigerators = RefrigeratorCollection[i];
//				if (existingRefrigerators.getBrand().equals(brand) && existingRefrigerators.getPrice() == Integer.parseInt(price) && existingRefrigerators.getCapacity() == Integer.parseInt(capacity) && existingRefrigerators.getEnergeticClass().equals(energeticClass)) {
//					return "Refrigerator with identical details already exists.";
//				}
//			}
//
//			String[] allowedRefrigeratorBrands = { "Samsung", "LG", "Whirlpool", "GE Appliances", "KitchenAid", "Frigidaire", "Bosch", 
//					"Electrolux", "Haier", "Panasonic", "Hisense", "Miele", "Viking", "Sub-Zero", 
//					"Thermador", "Kenmore", "Maytag", "Amana", "Danby", "Fisher & Paykel", "Liebherr" };
//	
//			boolean RefrigeratorbrandAllowed = false;
//			for (String allowedRefrigeratorBrand : allowedRefrigeratorBrands) {
//				if (brand.equalsIgnoreCase(allowedRefrigeratorBrand)) {
//					RefrigeratorbrandAllowed = true;
//					break;
//				}
//			}
//			
//			if (!RefrigeratorbrandAllowed) {
//				return "Enter a valid Refrigerator brand.";
//			}
//
//			int priceValue = Integer.parseInt(price);
//			if (priceValue < 100 || priceValue > 100000) {
//				return "Price value must be between 100$ and 100,000$";
//			}
//
//			int capacityValue = Integer.parseInt(capacity);
//			if (capacityValue < 100 || capacityValue > 1000) {
//				return "Enter a valid Refrigerator Capacity (must be between 100 and 1000 liters)";
//			}
//
//			String[] allowedEnergeticClasses = {"A", "B", "C", "D", "E", "F", "G"};
//			
//			boolean energeticClassAllowed = false;
//			for (String allowedEnergeticClass : allowedEnergeticClasses) {
//				if (energeticClass.equalsIgnoreCase(allowedEnergeticClass)) {
//					energeticClassAllowed = true;
//					break;
//				}
//			}
//			
//			if (!energeticClassAllowed) {
//				return "Enter a valid Energetic class (must be between A-G).";
//			}
//
//			return "";
//	}
// 
//	public void displayErrorMessage(String errorMessage) {
//		
//		Dialog errorDialog = new Dialog(this, "Error", true);
//		errorDialog.setLayout(new BorderLayout());
//		Label errorLabel = new Label(errorMessage);
//		Button closeButton = new Button("Close");
//		
//		closeButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				errorDialog.dispose();
//			}
//		});
//		
//		errorDialog.add(errorLabel, BorderLayout.CENTER);
//		errorDialog.add(closeButton, BorderLayout.SOUTH);
//		errorDialog.pack();
//		errorDialog.setVisible(true);
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		
//		if (e.getSource() == exit) {
//			System.exit(0);
//		}
//		
//		else if (e.getSource() == add) {
//			lastButtonAdd = true;
//			lastButtonModify = false;
//			add(addPanel, BorderLayout.SOUTH);
//			addTv.setVisible(true);
//			addRefrigerator.setVisible(true);           
//			addPanel.setVisible(true);
//			pack();
//		}
//		
//		else if (e.getSource() == cancel) {
//			remove(addPanel);
//			pack(); 
//		}
//		
//		else if (e.getSource() == save) {
//			if (validateInput()) {
//				saveDevice();
//			}
//		}
//		
//		else if (e.getSource() == modify) {
//			int selectedIndex = deviceList.getSelectedIndex();
//			
//			if (selectedIndex == -1) {
//				System.out.println("Select an item to modify");
//			}
//			else {
//				prepareModification(selectedIndex);
//			}
//		}
//		
//		else if (e.getSource() == delete) {
//			int selectedIndex = deviceList.getSelectedIndex();
//			
//			if (selectedIndex == -1) {
//				System.out.println("Select an item to delete");
//			}
//			else {
//				confirmAndDelete(selectedIndex);
//			}
//		}
//	}
//	
//	private void saveDevice() {
//		TextField[] textFields = {brandTextField, priceTextField, thirdTextField, forthTextField};
//		
//		for (TextField textField : textFields) {
//			if (textField.getText().isEmpty()) {
//				textField.setText("Field required");
//				return; 
//			}
//		}
//	
//		String type = addTv.getState() ? "TV" : "Refrigerator";
//		String brand = brandTextField.getText();
//		String price = priceTextField.getText();
//		String third = thirdTextField.getText();
//		String forth = forthTextField.getText();
//	
//		String validationMessage = type.equals("TV") ? validateTvInput(brand, price, third, forth) : validateRefrigeratorInput(brand, price, third, forth);
//	
//		if (!validationMessage.isEmpty()) {
//			displayErrorMessage(validationMessage);
//			return;
//		}
//	
//		int selectedIndex = deviceList.getSelectedIndex();
//		if (lastButtonModify && selectedIndex != -1) {
//			
//			if (type.equals("TV")) {
//				TV tv = (TV) (selectedIndex < tvCounter ? TvCollection[selectedIndex] : null);
//				if (tv != null) {
//					tv.setBrand(brand);
//					tv.setPrice(Integer.parseInt(price));
//					tv.setSize(Integer.parseInt(third));
//					tv.setColour(forth);
//				}
//			}
//			
//			else {				
//				Refrigerator refrigerator = (Refrigerator) (selectedIndex >= tvCounter ? RefrigeratorCollection[selectedIndex - tvCounter] : null);				
//				if (refrigerator != null) {
//					refrigerator.setBrand(brand);
//					refrigerator.setPrice(Integer.parseInt(price));
//					refrigerator.setCapacity(Integer.parseInt(third));
//					refrigerator.setEnergeticClass(forth);
//				}
//			}
//		}
//		
//		else if (lastButtonAdd) {
//			if (type.equals("TV")) {
//				TvCollection[tvCounter++] = new TV(brand, Integer.parseInt(price), Integer.parseInt(third), forth);
//			}
//			else {
//				RefrigeratorCollection[refrigeratorCounter++] = new Refrigerator(brand, Integer.parseInt(price), Integer.parseInt(third), forth);
//			}
//		}
//	
//		saveDevicesFile(); 
//		displayInList();
//		clearAdd();
//		addPanel.setVisible(false);
//		pack();
//	}
//
//	private void prepareModification(int index) {
//		String selectedItem = deviceList.getItem(index);
//		
//		if (selectedItem == null || !selectedItem.contains(":")) {
//			System.out.println("Invalid item selected.");
//			return; 
//		}
//
//		String type = selectedItem.split(":", 2)[0].trim();
//		String details = selectedItem.substring(selectedItem.indexOf(':') + 1).trim();
//
//		Pattern pattern = Pattern.compile("Brand:\\s*(\\S+)\\s+Price:\\s*(\\d+)\\$\\s+(Size|Capacity):\\s*(\\d+)\\s+(Colour|EnergeticClass):\\s*(\\S+)");
//		Matcher matcher = pattern.matcher(details);
//		
//		if (!matcher.matches()) {
//			System.out.println("Unable to parse item details.");
//			return; 
//		}
//
//		brandTextField.setText(matcher.group(1));
//		priceTextField.setText(matcher.group(2));
//		thirdTextField.setText(matcher.group(4));
//		forthTextField.setText(matcher.group(6));
//
//		boolean isTv = type.equalsIgnoreCase("TV");
//		addTv.setState(isTv);
//		addRefrigerator.setState(!isTv);
//		thirdLabel.setText(isTv ? "Size:" : "Capacity:");
//		forthLabel.setText(isTv ? "Colour:" : "Energetic Class:");
//		lastButtonAdd = false;
//		lastButtonModify = true;
//
//		add(addPanel, BorderLayout.SOUTH);
//		addPanel.setVisible(true);
//		validate();
//		pack(); 
//	}
//
//
//	
//	private void confirmAndDelete(int index) {
//		Dialog deleteConfirmationDialog = new Dialog(this, "Delete Confirmation", true);
//		deleteConfirmationDialog.setLayout(new BorderLayout());
//		Label confirmationLabel = new Label("Are you sure you want to delete?");
//		Panel buttonPanel = new Panel();
//		Button yesButton = new Button("Yes");
//		Button noButton = new Button("No");
//	
//		yesButton.addActionListener(ae -> {
//			deleteSelectedItem(index);
//			deleteConfirmationDialog.dispose();
//		});
//	
//		noButton.addActionListener(ae -> deleteConfirmationDialog.dispose());
//	
//		buttonPanel.add(yesButton);
//		buttonPanel.add(noButton);
//		deleteConfirmationDialog.add(confirmationLabel, BorderLayout.CENTER);
//		deleteConfirmationDialog.add(buttonPanel, BorderLayout.SOUTH);
//		deleteConfirmationDialog.pack();
//		deleteConfirmationDialog.setVisible(true);
//	}
//	
//	private void deleteSelectedItem(int index) {
//		if (index < tvCounter) { 
//			rearrangeTvCollection(index);
//		}
//		else { 
//			rearrangeRefrigeratorCollection(index - tvCounter);
//		}
//		
//		saveDevicesFile();
//		displayInList();
//	}
//	
//	private void rearrangeTvCollection(int index) {
//		for (int i = index; i < tvCounter - 1; i++) {
//			TvCollection[i] = TvCollection[i + 1];
//		}
//		
//		TvCollection[tvCounter - 1] = null;
//		tvCounter--;
//	}
//	
//	private void rearrangeRefrigeratorCollection(int index) {
//		for (int i = index; i < refrigeratorCounter - 1; i++) {
//			RefrigeratorCollection[i] = RefrigeratorCollection[i + 1];
//		}
//		RefrigeratorCollection[refrigeratorCounter - 1] = null;
//		refrigeratorCounter--;
//	}
//	
// 
//
//    public static void main(String[] args) {
//        loadDevicesFile();
//
//        TheWindow main = new TheWindow("Program");
//
//        main.displayInList();
//        main.pack();
//        main.setVisible(true); 
//  }
// }