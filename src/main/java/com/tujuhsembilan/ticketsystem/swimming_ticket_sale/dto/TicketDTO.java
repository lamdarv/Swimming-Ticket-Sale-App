package com.tujuhsembilan.ticketsystem.swimming_ticket_sale.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TicketDTO {
    private String customerName;
    private LocalDate bookingDate;
    private int quantity;
    private double price;
}
