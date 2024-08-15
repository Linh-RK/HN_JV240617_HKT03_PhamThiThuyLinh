package ra.run;

import ra.bussines.Book;

import java.util.Scanner;

import static ra.run.BookService.*;

public class BookManagement {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        int choice;
        do {
            System.out.println("****************************JAVA-HACKATHON-05-BASIC-MENU****************************");
            System.out.println("*       1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách        *");
            System.out.println("*       2. Hiển thị thông tin tất cả sách trong thư viện                           *");
            System.out.println("*       3. Sắp xếp sách theo lợi nhuận tăng dần                                    *");
            System.out.println("*       4. Xóa sách theo mã sách                                                   *");
            System.out.println("*       5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả                        *");
            System.out.println("*       6. Thay đổi thông tin sách theo mã sách                                    *");
            System.out.println("*       7.Thoát                                                                    *");
            System.out.println("************************************************************************************");
            choice = inputChoice(scanner);
            switch (choice) {
                case 1:
                    BookService.addNewBook(scanner, Book.arrBook, Book.currentIndex);
                    break;
                case 2:
                    BookService.showAllBook(scanner, Book.arrBook, Book.currentIndex);
                    break;
                case 3:
                    BookService.sortByInterest(scanner, Book.arrBook, Book.currentIndex);
                    break;
                case 4:
                    BookService.deleteById(scanner, Book.arrBook, Book.currentIndex);
                    break;
                case 5:
                    BookService.searchByNameDes(scanner, Book.arrBook, Book.currentIndex);
                    break;
                case 6:
                    BookService.updateById(scanner, Book.arrBook, Book.currentIndex);
                    break;
                case 7:
                    System.out.println("Hẹn gặp lại !");
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter a choice between 1 and 5: ");
            }
        }while(flag) ;
    }



}

