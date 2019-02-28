/**
 *Bookを操作するクラス
 * @author Anzai
 * @version 1.0
 */
package mylibrary;
public class Book extends MagazineBook{
   /**
    *著者を表します
    */
    private String author;
    /**
     *返却状態を表します
     */
    private String lendState="返却";
    /**
     *デフォルトコンストラクタ
     *@param number_ISBN_book ISBN番号
     *@param title_book 題名
     *@param publisher_book 出版社
     *@param publicationYear_book 出版年
     *@param author 著者
     *@param lendState 貸出状態
     */
    public Book(String number_ISBN_book, String title_book, String publisher_book, int publicationYear_book, String author,String lendState){
      super(title_book, publisher_book, publicationYear_book, number_ISBN_book);
      this.lendState = lendState;
      this.author = author;
    }
    /**
     *著者を取得する
     *  @return 著者
     */
    public String getAuthor() {
      return author;
    }
    /**
     *Bookの文字列を出力する
     *  @return "title,publisher,publicationYear,author,lendState"
     */
    public String toString() {
      return title + ","+ publisher + ","+ publicationYear + "," + author + ","+ lendState;
    }
    /**
     *Bookの貸し出し
     *貸出状態が"返却"のとき貸出できる
     *  @return 成功した場合はtrue
     */
    public boolean lent(){
      if(lendState.equals("返却")){
        System.out.println("出版物を貸し出します");
        lendState="貸出";
        return true;
      }
      else{
        System.out.println("現在貸出中です");
        return false;
      }
    }
    /**
     *Bookの返却
     *貸出状態が"貸出"のとき返却できる
     *  @return 成功した場合はtrue
     */
    public boolean returned(){
        if (lendState.equals("貸出")) {
          System.out.println("ご返却ありがとうございます");
          lendState="返却";
          return true;
        }
        else{
          System.out.println("貸し出されていません");
          return false;
        }
    }
}
