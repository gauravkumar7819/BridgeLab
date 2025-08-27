Algorithm AttendanceSystem:
    Initialize attendance[][] // 2D array for students x days
    Initialize studentNames[]
    
    Function markAttendance(studentId, day, status):
        IF validStudent(studentId) AND validDay(day) THEN
            attendance[studentId][day] = status
            RETURN true
        RETURN false
    
    Function updateAttendance(studentId, day, newStatus):
        IF validStudent(studentId) AND validDay(day) THEN
            attendance[studentId][day] = newStatus
            RETURN true
        RETURN false
    
    Function generateMonthlyReport(studentId):
        IF validStudent(studentId) THEN
            presentCount = 0
            FOR each day in attendance[studentId]
                IF day equals 'P' THEN
                    INCREMENT presentCount
            RETURN presentCount
        RETURN -1