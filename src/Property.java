public class Property {

    private String address;
    private int numberRooms;
    private int price;
    private int typeProperty;
    private boolean forRent;
    private int houseNumber;
    private int floorNumber;
    private String user;

    public Property(int numberRooms , int price , boolean forRent , int houseNumber , int floorNumber){
       // this.address = address;
        this.numberRooms = numberRooms;
        this.price = price;
       // this.typeProperty = typeProperty;
        this.forRent = forRent;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
       // this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public int getPrice() {
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

    public String getUser() {
        return user;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public void setPrice(int price) {
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

    public void setUser(String user) {
        this.user = user;
    }
}
