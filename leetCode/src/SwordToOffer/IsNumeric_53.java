package SwordToOffer;

/**
 * Created by LXY on 2017/9/29.
 */
public class IsNumeric_53 {

    //请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
    public boolean isNumeric(char[] str) {

        if(str == null || str.length == 0) return false;


        if(str[0] != '+' && str[0] != '-' && !Character.isDigit(str[0]) ){       //第一个数字不为+，-，或者数字直接返回false
            return false;
        }
        if(str.length==1){
            if(Character.isDigit(str[0])) return true;              //只有一位的情况下，第一位为数字才行哦
            return false;
        }
        //小数点最多只能出现一次，而且必须在e或者E之前；e或者E最多能有一个
        int indexDot = -2;
        int indexE = -1;
        int index = 1;
//        if(str.length>=2){
//            if(!Character.isDigit(str[0])){     //如果第一个是+/-，第二个必须为数字
//                if(!Character.isDigit(str[1])) return false;
//            }else{      //第一位数数字,
//                if(str[1]=='.') indexDot = 1;
//                if(str[1]=='e'||str[1]=='E') indexE = 1;
//            }
//            index = 2;
//        }

        while(index<str.length){
            if(Character.isDigit(str[index])) {
                index++;
                continue;
            }
            if(str[index]=='.'){
                if(index==str.length-1) return false;       //'.'不能为最后一个元素
                //要判断.是否第一个，是否在e前面
                if((indexDot==-2)){       //小数点要在e前面
                    if(indexE!=-1 && index>indexE) return false;
                    indexDot = index;
                    index++;
                    continue;
                }else
                    return false;
            }
            if(str[index]=='e'||str[index]=='E'){
                if(indexE==-1) {        //只能有一个e,遇到e之后对后面的进行判断，后面的只能第一位为符号位
                    index++;
                    if(index==str.length) return false;       //‘e’不能为最后一个元素
                    //对e后面的进行判断
                    if(str[index]=='+'||str[index]=='-'){
                        if(index==str.length-1) return false;
                    }else if(Character.isDigit(str[index])){
                        if(index==str.length-1) return true;        //最后一位，而且最后一位为数字
                    }else{
                        return false;
                    }
                    index++;
                    while(index<str.length){
                        if(!Character.isDigit(str[index])){      //e后面(第二位开始)的不为数字直接g
                            return false;
                        }
                        index++;
                    }
                    continue;
                }
              else return false;
            }
            return false;   //为其他数
        }
        if(index == str.length) return true;
//        //
        return false;
    }

    public static void main(String[] args){

        IsNumeric_53 a = new IsNumeric_53();
        char[] chars = "123.45e+6".toCharArray();
        System.out.println(a.isNumeric(chars));
    }
}
