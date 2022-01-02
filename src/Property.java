public class Property {

    private Address address;
    private int numberRooms;
    private float price;
    private int typeProperty;
    private boolean forRent;
    private int houseNumber;
    private int floorNumber;
    private User user;

    public Property(User user,int typeProperty,int numberRooms , float price , boolean forRent , int houseNumber , int floorNumber){
       // this.address = address;
        this.numberRooms = numberRooms;
        this.price = price;
        this.typeProperty = typeProperty;
        this.forRent = forRent;
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

    public int getTypeProperty() {
        return typeProperty;
    }

    public boolean isForRent() {
        return forRent;
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

    public void setTypeProperty(int typeProperty) {
        this.typeProperty = typeProperty;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
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
        return "User Information : "  + "\n" + user.toString()  + "\n" +
                "Property {" + "\n" +
                "Type Property : " + this.typeProperty + "\n" +
                "for Rent : " + this.forRent +  "\n" +
                "House Number : " +this.houseNumber + "\n" +
                "Floor Number :" + this.floorNumber  + "\n" +
                "Number Rooms : " + this.numberRooms  + "\n" +
                "Price : " + this.price + "\n" +
                '}' + "\n" ;
    }
}
