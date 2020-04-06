package day06;

public class MyThread extends Thread {

  public MyThread(){};

  public MyThread(String name){
    super(name);
  }
    @Override
    //用run方法封装要多线程执行的代码
    public void run() {
        for (int i = 0; i < 3; i++) {
          //用getname得到是哪一个线程执行的
            System.out.println(getName()+i);

            //输出一次就可以让线程休眠10毫秒
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
