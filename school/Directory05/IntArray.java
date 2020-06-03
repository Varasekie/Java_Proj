package Directory05;

public class IntArray {

    //如果转化成浮点数，然后给整数赋值，就会丢掉最后的那个小数啊
    public int[] getInt(String[] s){
        if (s == null || s.length ==0){
            return null;
        }
        int x[] = new int[s.length],n=0,i=0;
        while (i< s.length){
            try {
                x[n] = Integer.parseInt(s[i]);
                n++;
            }catch (NumberFormatException e){
//                System.out.println(s[i] +"不能转换");
                try {
                    x[n] = (int) Float.parseFloat(s[i]);
                }catch (NumberFormatException ex) {
                    System.out.println(s[i] + "不能转换成浮点数或整数");
                }
            }finally {
                i++;
            }
        }
        if (n == x.length){
            return x;
        }
        //当x数组不满的时候，重新复制
        int y[]=new int[n];
        System.arraycopy(x,0,y,0,n);
        return y;

    }
}
