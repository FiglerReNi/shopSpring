package hu.tmx.shop.model;

import hu.tmx.shop.service.Refundable;
import hu.tmx.shop.service.Sellable;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Shoe extends Product implements Sellable, Refundable {

    private final int smallShoePrice = 14000;
    private final int largeShoePrice = 15000;
    private final int refundDaysCount = 50;
    private final double baseSize = 40;

    private double size;
    private String type;
    private LocalDate sellDate;

    public Shoe(double size, String type) {
        super("Cipő");
        this.size = size;
        this.type = type;
    }

    @Override
    public int receivePrice() {
        return this.size > this.baseSize ? this.largeShoePrice : this.smallShoePrice;
    }

    @Override
    public void sell() {
        sellDate = LocalDate.now();
    }

    @Override
    public int receiveRefundablePrice() {
        if (null != sellDate) {
            long days = ChronoUnit.DAYS.between(sellDate, LocalDate.now());
            if (days == 0) {
                return receivePrice();
            } else if (days < this.refundDaysCount) {
                return receivePrice() / 2;
            } else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.size + " méretű " + this.getType() + " " + this.getName() + " - " + receivePrice();
    }
}
