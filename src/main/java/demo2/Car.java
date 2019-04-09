package demo2;

/**
 * 汽车
 */
public interface Car {

     /**
      * 汽车行为之一：启动
      */
     void start();

     /**
      * 汽车行为之一：左转
      */
     void turnLeft();

     /**
      * 汽车行为之一:直行
      * @param meter 米数
      */
     void goStraight(int meter);

     /**
      * 汽车行为之一：右转
      */
     void turnRight();

     /**
      * 汽车行为之一：熄火
      */
     void stop();
}
