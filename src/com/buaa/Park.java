package com.buaa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
public class Park {

    public int totalCarPork =4;
    public int nowCarPork=0;
    public Map carMap = new HashMap();


    public boolean addCar(Car car){
        if(carMap.get(car.getTicket())!=null){
            System.out.println("错误的ticket，不能重复使用同一ticket！");
            return false;
        }
        if(nowCarPork+1>totalCarPork){
            System.out.println("车库已满，不能再进了！");
            return false;
        }
        nowCarPork = nowCarPork+1;
        carMap.put(car.getTicket(),car);
        System.out.println("进来一辆车ticket为["+car.getTicket()+"],carNumber为["+car.getCarNumber()+"],还有" + (totalCarPork - nowCarPork) + "个停车位。");
        return true;
    }

    public boolean subCar(Car car){
        if (nowCarPork==0) {
            System.out.println("车场空了！");
            return false;
        } else{
            if(carMap.containsKey(car.getTicket())){
                if(!(((Car)carMap.get(car.getTicket())).getCarNumber().equals(car.getCarNumber()))){  //判断Ticket是否合法
                    System.out.print("ticket为["+car.getTicket()+"],carNumber为["+car.getCarNumber()+"]");
                    System.out.println("禁止出库，ticket与carNumber不相同，该ticket只能驾驶["+((Car)carMap.get(car.getTicket())).getCarNumber()+"]车出库!");
                  return false;
                } else {
                carMap.remove(car.getTicket());
                nowCarPork = nowCarPork-1;
                System.out.println("出去一辆车ticket为["+car.getTicket()+"]carNumber为["+car.getCarNumber()+"],还有"+(totalCarPork-nowCarPork)+"个停车位。");
                return true;
                }
            } else {
                System.out.println("没有ticket为["+car.getTicket()+"],carNumber为["+car.getCarNumber()+"]这辆车，无法出库！");
                return false;
            }
         }
     }

    public int getNowCarPork() {
        return nowCarPork;
    }

    public void setNowCarPork(int nowCarPork) {
        this.nowCarPork = nowCarPork;
    }

    public int getTotalCarPork() {
        return totalCarPork;
    }

    public void setTotalCarPork(int totalCarPork) {
        this.totalCarPork = totalCarPork;
    }
}
