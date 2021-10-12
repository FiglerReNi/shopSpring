package hu.tmx.shop.model;

import hu.tmx.shop.service.Maintainable;
import hu.tmx.shop.service.Sellable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
public class Flower extends Product implements Sellable, Maintainable {

    private final int basePrice = 1000;
    private final String maintainType = "Öntözés";
    private final int maintainYearsCount = 3;
    private final int monthWeeksRate = 4;
    private final int weekInYear = 52;

    private int age;
    private LocalDate maintainDate;
    private LocalDate sellDate;

    public Flower(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public int receivePrice() {
        return this.basePrice + this.age * 2;
    }

    @Override
    public void sell() {
        sellDate = LocalDate.now();
    }

    @Override
    public boolean isMaintained() {
        if (null == this.maintainDate && this.age > weekInYear * maintainYearsCount) {
            return true;
        }
        if (null != this.maintainDate) {
            int dateDiffForOtherMaintain = Period.between(this.maintainDate, LocalDate.now()).getYears();
            return (dateDiffForOtherMaintain >= this.maintainYearsCount);
        }
        return false;
    }

    @Override
    public String maintain() {
        if(isMaintained()){
            maintainDate = LocalDate.now();
            return this.maintainType;
        }
        return null;
    }

    @Override
    public String toString() {
        String ageString = "";
        if (this.age < this.monthWeeksRate) {
            ageString = this.age + " hetes";
        } else if (this.age % this.monthWeeksRate == 0) {
            ageString = this.age / this.monthWeeksRate + " hónapos";
        } else {
            ageString = this.age / this.monthWeeksRate + " hónapos és " + this.age % this.monthWeeksRate + " hetes";
        }
        return ageString + " " + this.getName() + " - " + receivePrice();
    }
}
