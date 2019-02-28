/**
 *Magazineを操作するクラス
 * @author Anzai
 * @version 1.0
 */
package mylibrary;
public class Magazine extends MagazineBook{
  /**
   *巻を表します
   */
  private int roll;
  /**
   *号を表します
   */
  private int issue;
  /**
   *貸出状態を表します
   */
  private String lendState="返却";
  /**
   *デフォルトコンストラクタ
   *@param number_ISBN_magazine ISBN番号
   *@param title_magazine 題名
   *@param roll 巻
   *@param issue 号
   *@param publisher_magazine 出版社
   *@param publicationYear_magazine 出版年
   *@param lendState 貸出状態
   */
  public Magazine(String number_ISBN_magazine, String title_magazine, int roll, int issue, String publisher_magazine, int publicationYear_magazine,String lendState){
    super(title_magazine, publisher_magazine, publicationYear_magazine, number_ISBN_magazine);
    this.lendState=lendState;
    this.roll=roll;
    this.issue=issue;
  }
  /**
   *巻を取得する
   *  @return 巻
   */
  public int getRoll(){
    return roll;
  }
  /**
   *号を取得する
   *  @return 号
   */
  public int getIssue(){
    return issue;
  }
  /**
   *Magazineの文字列を出力する
   *  @return "title,roll,issue,publisher,publicationYear,lendState"
   */
  public String toString() {
    return  title + "," + roll + "," + issue + "," + publisher + ","+ publicationYear+"," + lendState;
  }

  /**
   *Magazineの貸し出し
   *貸出状態が"返却"&&巻<=10のとき貸出できる
   *  @return 成功した場合はtrue
   */
  public boolean lent(){
    if(lendState.equals("返却") && roll<=10){
      System.out.println("出版物を貸し出します");
      lendState="貸出";
      return true;
    }
    else if(lendState.equals("返却") && roll>10){
      System.out.println("貸し出せません");
      return false;
    }
    else{
      System.out.println("現在貸出中です");
      return false;
    }
  }
  /**
   *Magazineの返却
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
