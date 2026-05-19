public class Cars {
  private String marca;
  private String model;
  private int price;
  private int id = -1;

  // Constructor to ArrayList
  public Cars(String marca, String model, int price, int id) {
    this.marca = marca;
    this.model = model;
    this.price = price;
    this.id = id;
  }

  // Constructor to HashMap
  public Cars(String marca, String model, int price) {
    this.marca = marca;
    this.model = model;
    this.price = price;
  }

  public String getMarca() {
    return this.marca;
  }

  public String getModel() {
    return this.model;
  }

  public int getPrice() {
    return this.price;
  }

  public int getId() {
    return this.id;
  }




}
