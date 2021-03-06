package com.zhang.behavioral.visitor;

/**
 * Created by Zhang on 12/9/2016 11:10 PM.
 */
public class Necessity extends Product {

    public Necessity(double price) {
        super(price);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
