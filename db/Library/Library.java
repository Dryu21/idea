/**
 *Libraryを操作するクラス
 * @author Anzai
 * @version 1.0
 */
package mylibrary;
import java.util.*;
import java.io.*;
public class Library {
  /**
  *デフォルトコンストラクタ
  *プログラム開始時(libraryインスタンス生成時)にlib.csvファイルから読み込み、蔵書に追加
  *プログラム終了時に図書館が所蔵するすべての本、雑誌の情報をlib.csvに書き込みする
  * @param file ファイル名(発展拡張D)
  */
  public Library(String file){
    read(file);
    Thread hook = new Thread(){
    public void run() {
      print();
    }
    };
    Runtime.getRuntime().addShutdownHook(hook);
  }

  Map<String, MagazineBook> list =new HashMap<String, MagazineBook>();
  ArrayList<String> arr = new ArrayList<String>();
  Scanner scanner = new Scanner(System.in);

  /**
  *蔵書の追加
  * @param numberISBN ISBN番号
  * @param detail 書籍
  */
  public void addPublish(String numberISBN, MagazineBook detail){
    if (numberISBN.length()==13 && list.get(numberISBN)==null) {
      list.put(numberISBN,detail);
      System.out.println("ISBN番号:"+numberISBN+"を追加しました");
    }else{
      System.out.println("すでに蔵書していないか、ISBN・出版年が間違っていないかを確認してください。");
    }
  }
  /**
  *ファイルから読み込み、蔵書に追加
  * @param file ファイル名
  */
  public void read(String file){
    try{
      BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
      String line;
      while ((line = reader.readLine()) != null) {
        // 1行をデータのカンマごとの要素に分割
        StringTokenizer st = new StringTokenizer(line, ",");
        while (st.hasMoreTokens()){
          arr.add(st.nextToken());
        }
        if(arr.get(0).equals("mylibrary.Magazine")){
          Magazine magazine = new Magazine(arr.get(1), arr.get(2), Integer.parseInt(arr.get(3)), Integer.parseInt(arr.get(4)), arr.get(5), Integer.parseInt(arr.get(6)), arr.get(7));
          this.addPublish(arr.get(1),magazine);
        }else{
          Book book = new Book(arr.get(1), arr.get(2), arr.get(3), Integer.parseInt(arr.get(4)), arr.get(5), arr.get(6));
          this.addPublish(arr.get(1),book);
        }
        arr.clear();
      }
      reader.close();
    }
    catch(FileNotFoundException e){
      System.out.println("ファイルが見つかりませんでした");
    }catch(IOException e){
      System.out.println("入出力にエラーが生じました");
    }
  }
    /**
    *図書館が所蔵するすべての本、雑誌の情報をlib.csvに書き込みをする
    */
  public void print(){
    try{
      PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("lib.csv"),"UTF-8")));
      for(Map.Entry<String, MagazineBook> entry : list.entrySet()){
        writer.println(entry.getValue().getClass().getName() + "," + entry.getKey() + "," + entry.getValue().toString());
      }
      writer.close();
    }
    catch(FileNotFoundException e){
      System.out.println("ファイルが見つかりませんでした");
    }catch(IOException e){
      System.out.println("入出力にエラーが生じました");
    }
  }

  /**
  *蔵書の一覧
  */
  public void show(){
    for(Map.Entry<String, MagazineBook> entry : list.entrySet()){
      System.out.println(entry.getValue().getClass().getName() + "," + entry.getKey() + "," + entry.getValue().toString());
    }
  }

  /**
  *ISBN番号の出版物を蔵書しているかを調べる
  * @param num ISBN番号
  */
  public void findPubliucation(String num){
    if(num.length()==13){
      if(list.containsKey(num)){
        System.out.println("ISBN番号"+num+"は所蔵しています");
      }else{
        System.out.println("ISBN番号"+num+"は所蔵していません");
      }
    }
    else{
        System.out.println("ISBNが間違っています");
    }
  }

  /**
  *ISBN番号の出版物の貸し出し
  * @param num ISBN番号
  */
    public void checkout(String num){
      if(list.containsKey(num)){
        list.get(num).lent();
      }else{
        System.out.println("貸し出しに失敗しました");
      }
    }
    /**
    *ISBN番号の出版物の返却
    * @param num ISBN番号
    */
    public void returnPublication(String num){
      if(list.containsKey(num)){
        list.get(num).returned();
      }else{
        System.out.println("返却に失敗しました。ISBN番号が間違っていないかご確認ください");
      }
    }
    /**
    *ISBN番号を指定して貸出返却をできるようにする(発展拡張B)
    *標準入力で貸出状態入力を選択した後にISBN番号を代入して貸し出しを行う
    */
    public void publicationControl(){
         System.out.print("貸出・返却を指定してください: ");
         String inputA = scanner.nextLine();
       if (inputA.equals("返却")){
         System.out.print("ISBN番号を入力してください: ");
         String inputB = scanner.nextLine();
         this.returnPublication(inputB);
       }else if(inputA.equals("貸出")){
         System.out.print("ISBN番号を入力してください: ");
         String inputB = scanner.nextLine();
         this.checkout(inputB);
       }else{
         System.out.println("貸出・返却どちらかを指定してください");
       }
    }
    /**
    *タイトルからISBN番号を取得(発展拡張B)
    *標準入力で題名を入力すると一致するISBN番号を出力する
    */
    public void findISBN(){
      System.out.println("題名を入力してください: ");
      String inputTitle = scanner.nextLine();
      for(Map.Entry<String, MagazineBook> entry : list.entrySet()){
        if (entry.getValue().getTitle().equals(inputTitle)){
          arr.add(entry.getKey());
          System.out.println("ISBN番号: "+entry.getKey());
        }
      }
      if (arr.size()==0){
        System.out.println("そのようなタイトルは存在しませんでした");
      }
      arr.clear();
    }
}
