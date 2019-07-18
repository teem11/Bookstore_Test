package Ajouuniv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BookStore bookStore = new BookStore();
        Scanner scan = new Scanner(System.in);
       /** while(true) {
            System.out.println("--------------------도서 관리프로그램입니다------------------------");
            System.out.println("1.추가하기 2.수정하기 3.삭제하기 4.목록 조회하기 5.종료하기");
            int selectNo = scan.nextInt();
            scan.nextLine();

            if (selectNo == 1) {
                bookStore.addBook();
            }else if(selectNo ==2) {
                bookStore.modBook();
            }else if(selectNo ==3){
              bookStore.delBook();
            } else if (selectNo == 4) {
                bookStore.showBook();
            } else if (selectNo == 5){
                return;
            }
        }*/
    }
}
