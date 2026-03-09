package com.debora.inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {
    
    ObservableList<Item> items = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Item> table;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, Double> priceColumn;
    @FXML
    private TableColumn<Item, Integer> quantityColumn;
    @FXML
    private TableColumn<Item, Double> totalValueColumn;
    @FXML
    private TableColumn<Item,Void> addColumn;
    @FXML
    private TableColumn<Item,Void> removeColumn;
    @FXML
    private TableColumn<Item,Void> deleteColumn;
    
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;

    @FXML
    private Label totalValueLabel;
    @FXML
    private Label totalItemsLabel;

    @FXML
    public void initialize() {

        //Set up the table columns to display the item properties
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        table.setItems(items);

        //Set up the total value column to calculate the total value of each item (price * quantity)
        totalValueColumn.setCellValueFactory(cellData -> {
            Item item = cellData.getValue();
            double totalValue = item.getPrice() * item.getQuantity();
            return new javafx.beans.property.SimpleDoubleProperty(totalValue).asObject();
        });

        //A column with buttons to add or remove quantity of an item, and a column with a button to delete the item from the inventory
        //ADD
        addColumn.setCellFactory(column -> new TableCell<Item, Void>() {
            private final Button button = new Button("+");
            {
                button.setOnAction(event -> {
                    Item item = getTableView().getItems().get(getIndex());
                    item.setQuantity(item.getQuantity()+1);
                    table.refresh();
                    updateTotalValue();
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });

        //REMOVE
        removeColumn.setCellFactory(column -> new TableCell<Item, Void>() {
            private final Button button = new Button("-");
            {
                button.setOnAction(event -> {
                    Item item = getTableView().getItems().get(getIndex());
                    item.setQuantity(item.getQuantity() == 0 ? 0 : item.getQuantity() - 1);
                    table.refresh();
                    updateTotalValue();
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });

        //DELETE
        deleteColumn.setCellFactory(column -> new TableCell<Item, Void>() {
            private final Button button = new Button("Delete");
            {
                button.setOnAction(event -> {
                    Item item = getTableView().getItems().get(getIndex());
                    items.remove(item);
                    table.refresh();
                    updateTotalValue();
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });
    }

    @FXML
    private void updateTotalValue() {
        double totalValue = items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
        totalValueLabel.setText(String.format("Total Inventory Value: $%.2f", totalValue));
        totalItemsLabel.setText(String.format("Total Items: %d", items.stream().mapToInt(item -> item.getQuantity()).sum()));
    }
    
    //Method to add a new item to the inventory when the "Add Item" button is clicked
    @FXML
    private void addItem() {
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        Item newItem = new Item(name, price, quantity);

        items.add(newItem);

        updateTotalValue();

        nameField.clear();
        quantityField.clear();
        priceField.clear();
    }
}
