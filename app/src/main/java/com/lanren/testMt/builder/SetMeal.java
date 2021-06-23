package com.lanren.testMt.builder;

/**
 * 套餐
 */
public class SetMeal {
    private int kele;
    private int hanbao;
    private int mifan;
    private int jichi;
    private int bingqiling;

    public int getKele() {
        return kele;
    }

    public void setKele(int kele) {
        this.kele = kele;
    }

    public int getHanbao() {
        return hanbao;
    }

    public void setHanbao(int hanbao) {
        this.hanbao = hanbao;
    }

    public int getMifan() {
        return mifan;
    }

    public void setMifan(int mifan) {
        this.mifan = mifan;
    }

    public int getJichi() {
        return jichi;
    }

    public void setJichi(int jichi) {
        this.jichi = jichi;
    }

    public int getBingqiling() {
        return bingqiling;
    }

    public void setBingqiling(int bingqiling) {
        this.bingqiling = bingqiling;
    }

    @Override
    public String toString() {
        return "SetMeal{" +
                "kele=" + kele +
                ", hanbao=" + hanbao +
                ", mifan=" + mifan +
                ", jichi=" + jichi +
                ", bingqiling=" + bingqiling +
                '}';
    }

    private SetMeal(Builder builder){
        this.bingqiling = builder.bingqiling;
        this.hanbao = builder.hanbao;
        this.jichi = builder.jichi;
        this.mifan = builder.mifan;
        this.kele = builder.kele;
    }

    public static class Builder{
        int kele;
        int hanbao;
        int mifan;
        int jichi;
        int bingqiling;

        public Builder kele(int kele){
            this.kele = kele;
            return this;
        }

        public Builder hanbao(int hanbao){
            this.hanbao = hanbao;
            return this;
        }

        public Builder mifan(int mifan){
            this.mifan = mifan;
            return this;
        }

        public Builder jichi(int jichi){
            this.jichi = jichi;
            return this;
        }

        public Builder bingqiling(int bingqiling){
            this.bingqiling = bingqiling;
            return this;
        }

        public SetMeal build(){
            return new SetMeal(this);
        }
    }
}
