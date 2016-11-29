package com.zhang.structural.adapter;

/**
 * Created by zhangxiangdong on 2016/11/29.
 * <p>
 * This is an adapter.
 */
public class BattleCar implements BattleVehicle {

    private final Truck truck;

    public BattleCar() {
        this.truck = new Truck();
    }

    @Override
    public void move() {
        truck.run();
    }

    @Override
    public void attack() {
        truck.crash();
    }

}
