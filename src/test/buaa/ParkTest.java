package test.buaa;

import com.buaa.Car;
import com.buaa.Park;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class ParkTest {

    Park park=new Park();

    @Test               // 入库
    public void addCar(){
        System.out.println("####################测试入库开始####################");
        Car car = new Car("1","京A00001") ;
        park.addCar(car);
        Assert.assertEquals(park.getNowCarPork(),1);
        car = new Car("2","京A00002") ;
        park.addCar(car);
        Assert.assertEquals(park.getNowCarPork(),2);
        car = new Car("3","京A00003") ;
        park.addCar(car);
        Assert.assertEquals(park.getNowCarPork(),3);
        car = new Car("4","京A00004") ;
        park.addCar(car);
        Assert.assertEquals(park.getNowCarPork(),4);
        car = new Car("5","京A00005") ;
        park.addCar(car);
        car = new Car("4","京A00006") ;
        park.addCar(car);
        Assert.assertEquals(park.getNowCarPork(),4);
        System.out.println("####################测试入库结束####################");
     }

    @Test              //出库
    public void subCar(){
        System.out.println("====================测试出库开始=============================");
        Car icar = new Car("1","京A00001") ;
        park.addCar(icar);
        icar = new Car("2","京A00002") ;
        park.addCar(icar);
        icar = new Car("3","京A00003") ;
        park.addCar(icar);
        icar = new Car("4","京A00004") ;
        park.addCar(icar);
        System.out.println("-----入库完毕--开始出库-----");
        Car car = new Car("1","京A00001");
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),3);
        car = new Car("2","京A00002");
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),2);
        car = new Car("3","京A00003");
        park.subCar(car);
        car = new Car("4","京A00005");
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),1);
        car = new Car("4","京A00004");
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),0);
        System.out.println("====================测试出库结束=============================");
     }

    @Test               //进进出出
    public void jjcc(){
        System.out.println("********************测试出库开始******************************");
        // 入库
        Car icar = new Car("1","京A00001") ;
        park.addCar(icar);
        // 入库
        icar = new Car("2","京A00002") ;
        park.addCar(icar);
        // 入库
        icar = new Car("3","京A00003") ;
        park.addCar(icar);
        // 出库
        Car car = new Car("1","京A00001");
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),2);
         // 出库
        car = new Car("3","京A00003");
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),1);
        // 入库
        icar = new Car("4","京A00004") ;
        park.addCar(icar);
        Assert.assertEquals(park.getNowCarPork(),2);
        // 出库
        car = new Car("4","京A00004");
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),1);


        //====入库=====
        car = new Car("5","京A00005") ;
        park.addCar(car);
        Assert.assertEquals(park.getNowCarPork(),2);

        // 出库
        car = new Car("4","京A00005");  //没有这库，无法出库
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),2);
        car = new Car("4","京A00004");
        park.subCar(car);
        Assert.assertEquals(park.getNowCarPork(),2);
        System.out.println("********************测试出库结束******************************");
    }
}
