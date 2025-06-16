package test;

public class TransactionType {
    private int typeID;
    private String typeName;
    private String description;
    private double defaultCost;
    
    // Getters and Setters
    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDefaultCost() {
        return defaultCost;
    }

    public void setDefaultCost(double defaultCost) {
        this.defaultCost = defaultCost;
    }
    
    // Display transaction type details
    public void displayDetails() {
        System.out.println("Transaction Type: " + typeName);
        System.out.println("Description: " + description);
        System.out.println("Default Cost: " + defaultCost);
    }
}