package com.tujuhsembilan.ticketsystem.swimming_ticket_sale.repository;

import com.tujuhsembilan.ticketsystem.swimming_ticket_sale.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
