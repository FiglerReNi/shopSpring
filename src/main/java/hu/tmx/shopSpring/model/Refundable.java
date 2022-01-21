package hu.tmx.shopSpring.model;

import java.time.LocalDate;

public interface Refundable {

    double getPriceOfRefunds(LocalDate sellDate);
}
