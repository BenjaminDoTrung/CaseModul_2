package Condition;

public class Condition {    // condition : trạng 0
    private String name;
//    private String unanalyzed = "unanalyzed";  // chưa được phân tích
//    private String analyzed = "analyzed";   // Đang phân tích
//    private String doneAnalyzed = "doneAnalyzed";   //   Đã phân tích xong
    // áp dụng design pattern singaton
//    private static Condition condition = null;
//
//    private Condition() {
//    }
//    public static Condition createCondition(){
//        if (condition == null){
//            condition = new Condition();
//        }
//        return condition;
//    }
//

    public Condition(String name) {
        this.name = name;
    }
}
