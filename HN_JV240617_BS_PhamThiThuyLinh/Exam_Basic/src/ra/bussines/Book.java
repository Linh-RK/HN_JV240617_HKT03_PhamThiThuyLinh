package ra.bussines;

import java.util.Scanner;

public class Book {
    public static Book[] arrBook = new Book[100];
    public static int currentIndex = -1;

    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private Boolean bookStatus;

    public Book() {}

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner, Book[] arrBook, int currentIndex) {
        this.bookId = inputBookId(scanner, arrBook, currentIndex);
        System.out.println("Mời nhập tên sách:");
        this.bookName = inputString(scanner);
        System.out.println("Mời nhập tác giả:");
        this.author = inputString(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.interest = (float)(this.exportPrice - this.importPrice);
        this.bookStatus = true;
//        this.bookStatus = inputBookStatus(scanner, arrBook, currentIndex);

    }
    public void displayData(){
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5d | %-10s | %-10s | %-20s | %-12.2f | %-12.2f | %-12.2f | %-6s |\n",this.bookId,this.bookName,this.author,this.descriptions,this.importPrice ,this.exportPrice,this.interest,this.bookStatus);
    }


    private double inputExportPrice(Scanner scanner) {
        do{
            System.out.println("Mời nhập giá bán:");
            double exportPrice;
            try{
                exportPrice = Double.parseDouble(scanner.nextLine());
                if(exportPrice <= this.importPrice * 1.2)
                    System.out.println("Giá bán phải lớn hơn 1.2 lần giá nhập");
                else
                    return exportPrice;
            }
            catch(Exception e) {
                System.err.println("Giá bán phải là số thực lớn hơn 0");
            }
        }while (true);
    }

    private double inputImportPrice(Scanner scanner) {
        do{
            System.out.println("Mời nhập giá nhập:");
            double importPrice;
            try{
                importPrice = Double.parseDouble(scanner.nextLine());
                if(importPrice <= 0)
                    System.out.println("Giá nhập phải là số thực lớn hơn 0");
                else
                    return importPrice;
            }
            catch(Exception e) {
                System.err.println("Giá nhập phải là số thực lớn hơn 0");
            }
        }while (true);
    }

    private String inputDescriptions(Scanner scanner) {
        System.out.println("Mời nhập mô tả sách");
        do{
            String description = inputString(scanner);
            if(description.length() < 10)
                System.out.println("Mô tả tối thiểu 10 kí tự");
            else
                return description;
        }while(true);
    }

    private String inputString(Scanner scanner) {
        String string;
        do {
             string = scanner.nextLine();
            if(string.isEmpty()){
                System.out.println("Không được để trống dữ liệu, vui lòng nhập dữ liệu !");

            } else
                return string;
        }while(true);
    }

    private int inputBookId(Scanner scanner, Book[] arrBook, int currentIndex) {
        if(currentIndex == -1){
            return 1;
        }else
            for (int i = 0; i < currentIndex; i++) {
                for(int j = i+1; j <= currentIndex; j++) {
                    if(arrBook[i].getBookId() > arrBook[j].getBookId()){
                        Book temp = arrBook[i];
                        arrBook[i] = arrBook[j];
                        arrBook[j] = temp;
                    }
                }
            }
            return arrBook[currentIndex].getBookId() + 1;
    }

    public void inputDataUpdate(Scanner scanner, Book[] arrBook, int currentIndex) {
        System.out.println("Mời nhập tên sách:");
        this.bookName = inputString(scanner);
        System.out.println("Mời nhập tác giả:");
        this.author = inputString(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.interest = (float)(this.exportPrice - this.importPrice);
        this.bookStatus = inputBookStatus(scanner);
    }

    private Boolean inputBookStatus(Scanner scanner) {
        System.out.println("Nhập trạng thái sách (true hoặc false)");
        do {
            String status = scanner.nextLine();
            if((status.equals("true") || status.equals("false"))) {
                return Boolean.parseBoolean(status);
            } else
                System.out.println("Trạng thái sách cần nhập true hoặc false");
        }while(true);
    }

}
