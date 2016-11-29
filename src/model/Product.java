package model;

public class Product {
    private String title;
    private String author;
    private String publishing;
    private String year;
    private String price;

    public Product(String title, String author, String publishing, String year, String price) {
        this.title = title;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
        this.price = price;
    }

    @Override
    public String toString() {
        return title + ";" + author + ";" + publishing + ";"+ year + " - " + price+" RUR";
    }

    public Double getPrice() {
        return Double.valueOf(price);
    }
}
