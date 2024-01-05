package finaltest;
//java final的学习
public class Main {
//    public int addone(final int i){
//        return ++i;
//    }
    /*
    * 引用对象不再发生改变，但是其属性值可以发生变化；
    * */
    public int addone(final other o){
        return o.i++;
    }

    public static void main(String[] args) {
        Main main = new Main();
        other other = new other();
        System.out.println(main.addone(other));
        System.out.println(main.addone(other));
        //System.out.println(main.addone(1));
    }
}
class other{
    public int i;
}
