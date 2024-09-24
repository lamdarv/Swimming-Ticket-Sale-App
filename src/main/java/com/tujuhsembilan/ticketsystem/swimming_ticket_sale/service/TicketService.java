package com.tujuhsembilan.ticketsystem.swimming_ticket_sale.service;

import com.tujuhsembilan.ticketsystem.swimming_ticket_sale.dto.TicketDTO;
import com.tujuhsembilan.ticketsystem.swimming_ticket_sale.model.Ticket;
import com.tujuhsembilan.ticketsystem.swimming_ticket_sale.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket(ticketDTO.getCustomerName(), ticketDTO.getBookingDate(),
                ticketDTO.getQuantity(), ticketDTO.getPrice());
        ticket = ticketRepository.save(ticket);
        return ticketDTO;
    }

    public List<TicketDTO> getAllTickets() {
        return ticketRepository.findAll().stream().map(ticket -> {
            TicketDTO dto = new TicketDTO();
            dto.setCustomerName(ticket.getCustomerName());
            dto.setBookingDate(ticket.getBookingDate());
            dto.setQuantity(ticket.getQuantity());
            dto.setPrice(ticket.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    // Get Ticket by ID
    public TicketDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        TicketDTO dto = new TicketDTO();
        dto.setCustomerName(ticket.getCustomerName());
        dto.setBookingDate(ticket.getBookingDate());
        dto.setQuantity(ticket.getQuantity());
        dto.setPrice(ticket.getPrice());
        return dto;
    }

    // Update Ticket
    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setCustomerName(ticketDTO.getCustomerName());
        ticket.setBookingDate(ticketDTO.getBookingDate());
        ticket.setQuantity(ticketDTO.getQuantity());
        ticket.setPrice(ticketDTO.getPrice());
        ticketRepository.save(ticket);
        return ticketDTO;
    }

    // Delete Ticket by ID
    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketRepository.delete(ticket);
    }
}
