package ra.run;

import ra.bussines.Book;

import java.util.Scanner;

public class BookService {
    public static void updateById(Scanner scanner, Book[] arrBook, int currentIndex) {
        System.out.println("Nhập ID sách bạn cần update thông tin:");
        int id = inputId(scanner);
        if(!isEixstedId(id,arrBook,currentIndex)){
            System.out.println("ID sách không tồn tại.");
        }else{
            Book book = new Book();
            book.setBookId(id);
            book.inputDataUpdate(scanner, arrBook, currentIndex);
            for (int i = 0; i <= currentIndex; i++) {
                if (arrBook[i].getBookId() == id) {
                    arrBook[i]= book;
                }
            }
            Book.arrBook = arrBook;
            System.out.println("Thông tin sách đã được update !");
            showAllBook(scanner, Book.arrBook, Book.currentIndex);
        }
    }

    public static void searchByNameDes(Scanner scanner, Book[] arrBook, int currentIndex) {
        System.out.println("Nhập từ khoá muốn tìm kiếm theo tên hoặc mô tả");
        String key = scanner.nextLine();
        Book[] result = new Book[100];
        int indexResult = -1;
        for (int i = 0; i <= currentIndex; i++) {
            if (arrBook[i].getBookName().toLowerCase().contains(key.toLowerCase())) {
                indexResult++;
                result[indexResult] = arrBook[i];
            }
        }
        for (int i = 0; i <= currentIndex; i++) {
            if (arrBook[i].getDescriptions().toLowerCase().contains(key.toLowerCase())) {
                if(!isExistedResult(i,result,indexResult, Book.arrBook)){
                    indexResult++;
                    result[indexResult] = arrBook[i];
                }

            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-10s | %-10s | %-20s | %-12s | %-12s | %-12s | %-6s |\n","ID","Name","Author","Descriptions","Import Price" ,"Export Price","Interest","Status");
        for (int i = 0; i <= indexResult; i++) {
            result[i].displayData();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    private static boolean isExistedResult(int i, Book[] result, int indexResult, Book[] arrBook) {
        if(indexResult == -1)
            return false;
        else {
            for (int j = 0; j <= indexResult; j++) {
                if (arrBook[i].getBookId() == result[j].getBookId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void deleteById(Scanner scanner, Book[] arrBook, int currentIndex) {
        System.out.println("Nhập ID sách bạn muốn xoá:");
        int id = inputId(scanner);
        if(!isEixstedId(id,arrBook,currentIndex)){
            System.out.println("ID bạn muốn xoá không tồn tại:");
        }else{
            for (int i = 0; i <= Book.currentIndex; i++) {
                if(arrBook[i].getBookId() == id){
                    for(int j = i; j <= Book.currentIndex; j++) {
                        Book.arrBook[i] = Book.arrBook[i + 1];
                    }
                    Book.currentIndex--;
                }
            }
            System.out.println("Xoá thành công !");
            showAllBook(scanner, Book.arrBook, Book.currentIndex);
        }
    }

    public static int inputId(Scanner scanner) {
        do {
            try{
                return Integer.parseInt(scanner.nextLine());
            }
            catch(Exception e) {
                System.err.println("ID phải là số nguyên dương. Vui lòng nhập lại !");
            }
        }while(true);
    }

    public static boolean isEixstedId(int id, Book[] arrBook, int currentIndex) {
        if(currentIndex == -1)
            return false;
        else {
            for(int i = 0; i <= currentIndex; i++) {
                if(arrBook[i].getBookId() == id){
                    return true;
                }
            }
        }
        return false;
    }

    public static void sortByInterest(Scanner scanner, Book[] arrBook, int currentIndex) {
        for (int i = 0; i <= currentIndex; i++) {
            for (int j = i+1; j <= currentIndex; j++) {
                if(arrBook[i].getInterest() > arrBook[j].getInterest()) {
                    Book temp = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = temp;
                }
            }
        }
        showAllBook(scanner, arrBook, currentIndex);
    }

    public static void showAllBook(Scanner scanner, Book[] arrBook, int currentIndex) {
        if (currentIndex == -1) {
            System.out.println("Danh sách sách trống !");
            return;
        }else {
            System.out.println("Danh sách sách hiện có :");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-10s | %-10s | %-20s | %-12s | %-12s | %-12s | %-6s |\n","ID","Name","Author","Descriptions","Import Price" ,"Export Price","Interest","Status");
            for (int i = 0; i <= currentIndex; i++) {
                arrBook[i].displayData();
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------");
        }
    }

    public static void addNewBook(Scanner scanner, Book[] arrBook, int currentIndex) {
        int number = inputNumberAdd(scanner);
        for (int i = 1; i <= number; i++) {
            Book book = new Book();
            book.inputData(scanner, arrBook, currentIndex);
            arrBook[currentIndex + 1] = book;
            currentIndex ++;
            Book.arrBook = arrBook;
            Book.currentIndex = currentIndex;
        }
    }

    public static int inputNumberAdd(Scanner scanner) {
        System.out.println("Nhập số sách bạn muốn thêm: ");
        do {
            try{
                int number = Integer.parseInt(scanner.nextLine());
                if (number < 1) {
                    System.out.println("Số sách cần thêm phải là số nguyên dương: ");
                } else
                    return number;
            }
            catch(Exception e){
                System.err.println("Số sách cần thêm phải là số nguyên dương: ");
            }
        }while (true);
    }

    public static int inputChoice(Scanner scanner) {
        System.out.println("Nhập lựa chọn:");
        do {
            try{
                return Integer.parseInt(scanner.nextLine());
            }
            catch(Exception e) {
                System.out.println("Lựa chọn phải là số nguyên dương. Vui lòng nhập lại ");
            }
        }while(true);
    }
}
