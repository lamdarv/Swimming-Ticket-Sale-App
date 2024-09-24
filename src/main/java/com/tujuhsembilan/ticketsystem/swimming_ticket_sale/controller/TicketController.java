package com.tujuhsembilan.ticketsystem.swimming_ticket_sale.controller;

import com.tujuhsembilan.ticketsystem.swimming_ticket_sale.dto.TicketDTO;
import com.tujuhsembilan.ticketsystem.swimming_ticket_sale.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createTicket(@RequestBody TicketDTO ticketDTO) {
        ticketService.createTicket(ticketDTO);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Ticket successfully created");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        List<TicketDTO> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        ticketService.updateTicket(id, ticketDTO);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Ticket successfully updated");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable Long id) {
        TicketDTO ticketDTO = ticketService.getTicketById(id);
        if (ticketDTO != null) {
            return ResponseEntity.ok(ticketDTO);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Ticket not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Ticket with id " + id + " successfully deleted");
        return ResponseEntity.ok(response);
    }
}
