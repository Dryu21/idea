package mytest;
import mylibrary.*;
/**
 *Testクラス
 * @author Anzai
 * @version 1.0
 */
public class Test{
  /**
  * mainメソッド
  * @param args 使用しない
  */
  public static void main(String[] args) {
    Book book_a = new Book("3333333333333", "title_a", "publisher_a", 1, "author_a", "返却");
    Magazine magazine_b = new Magazine("4444444444444", "title_b", 7, 8, "publisher_b", 1998, "返却");
    //ファイル名を入力すると図書館の情報として読み込む(発展拡張D)
    Library library = new Library("lib.csv");

    /**
    * タイトル入力からISBN番号を見つけるメソッド(発展拡張C)
    */
    library.findISBN();
    /**
    * 貸出状態入力を選択した後にISBN番号を代入して貸し出しを行うメソッド(発展拡張B)
    */
    library.publicationControl();

  }
}
