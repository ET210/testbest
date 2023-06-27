package com.cyy;
//枚举类可以定义抽象方法，然后让各个具体的枚举实现，可以通过枚举实现不同的策略实现。
enum OperEnum {
    ADD(1, 2) {
        @Override
        public Integer operate() {
            return this.getA() + this.getB();
        }
    }, MULTIPY(1, 2) {
        @Override
        public Integer operate() {
            return this.getA() * this.getB();
        }
    };

    private Integer a;

    private Integer b;

    OperEnum(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public abstract Integer operate();

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}