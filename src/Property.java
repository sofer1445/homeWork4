public class Property {

    private Address address;
    private int numberRooms;
    private float price;
    private String typeProperty;
    private boolean forSale;
    private int houseNumber;
    private int floorNumber;
    private User user;

    public Property(User user, Address address, String typeProperty, int numberRooms , float price , boolean forSale, int houseNumber , int floorNumber){
        this.address = address;
        this.numberRooms = numberRooms;
        this.price = price;
        this.typeProperty = typeProperty;
        this.forSale = forSale;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.user = user;

    }

    public Address getAddress() {
        return address;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public float getPrice() {
        return price;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public boolean isForSale() {
        return forSale;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public User getUser() {
        return user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return   this.typeProperty + "- for Sale: " + this.forSale + " Number Rooms: " + this.numberRooms  + ", Floor Number :" + this.floorNumber + ".\n"+
                "Price: " + this.price + "$.\n" + address.toString()+ "\n"+
                "Contact info: " + user.toString()  + "\n" +
                '}' + "\n" ;
    }
}
