Algorithm Theatre:
    Initialize seatMap, movieSchedule
    
    Function bookTicket(movie, seat, customer):
        IF isSeatAvailable(seat, movie) THEN
            Create new Ticket
            Mark seat as booked
            RETURN ticket
        RETURN null
    
    Function cancelTicket(ticket):
        IF ticket.isValid() THEN
            Mark seat as available
            Refund payment
            RETURN true
        RETURN false

Algorithm Customer:
    Initialize bookingHistory
    
    Function bookMovie(theatre, movie, seat):
        ticket = theatre.bookTicket(movie, seat, this)
        IF ticket != null THEN
            Add to bookingHistory
            Process payment
            RETURN true
        RETURN false