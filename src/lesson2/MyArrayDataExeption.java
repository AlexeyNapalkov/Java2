package lesson2;

class MyArrayDataExeption extends NumberFormatException{
    private String coordinates;
    public String getCoordinates(){return coordinates;}
    public MyArrayDataExeption(String message, int i, int j){
        super(message);
        coordinates = "(" + i +"; "+ j +")";
    }
}
