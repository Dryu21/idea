/**
 *MagazineとBookの親クラス
 * @author Anzai
 * @version 1.0
 */
package mylibrary;
public abstract class MagazineBook {
  /**
   *題名を表します
   */
  protected String title;
  /**
   *出版社を表します
   */
  protected String publisher;
  /**
   *出版年を表します
   */
  protected int publicationYear;
  /**
   *ISBN番号を表します
   */
  protected String numberISBN;

  /**
  *デフォルトコンストラクタ
  *出版年＞０のときのみインスタンスが生成できる
  */
  MagazineBook(String title, String publisher, int publicationYear, String numberISBN) {
    if (publicationYear>0){
      this.title = title;
      this.publisher = publisher;
      this.publicationYear=publicationYear;
      this.numberISBN=numberISBN;
    }
    else{
      this.title = "error";
      this.publisher = "error";
      this.publicationYear=404;
      this.numberISBN="error";
    }
  }
  /**
   *タイトルを取得
   *  @return 題名
   */
  public String getTitle() {
    return title;
  }
  /**
   *出版社を取得
   *  @return 出版社
   */
  public String getPublisher() {
    return publisher;
  }
  /**
   *ISBN番号を取得
   *  @return ISBN番号
   */
  public String getISBN(){
    return numberISBN;
  }
  /**
   *出版年を取得
   *  @return 出版年
   */
  public int getPublicationYear(){
    return publicationYear;
  }

  /**
   *書籍の貸し出し
   *  @return 成功した場合はtrue
   */
  abstract public boolean lent();
  /**
   *書籍の返却
   *  @return 成功した場合はtrue
   */
  abstract public boolean returned();
  /**
   *書籍の文字列を出力する
   * @return 書籍の文字列
   */
  abstract public String toString();
}
