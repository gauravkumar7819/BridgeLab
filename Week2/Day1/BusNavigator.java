Algorithm BusRoute:
    Initialize head = null
    
    Function addStop(stopName, afterStop):
        Create newStop
        IF afterStop is null THEN
            newStop.next = head
            head = newStop
        ELSE
            Find afterStop node
            newStop.next = afterStop.next
            afterStop.next = newStop
    
    Function removeStop(stopName):
        IF head is null THEN
            RETURN false
        IF head.stopName equals stopName THEN
            head = head.next
            RETURN true
        current = head
        WHILE current.next exists AND current.next.stopName not equals stopName
            current = current.next
        IF current.next exists THEN
            current.next = current.next.next
            RETURN true
        RETURN false