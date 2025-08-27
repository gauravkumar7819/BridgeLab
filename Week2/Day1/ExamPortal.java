Algorithm User:
    Initialize username, password
    
    Function login(username, password)
        IF checkCredentials(username, password) THEN
            RETURN true
        RETURN false

Algorithm Student EXTENDS User:
    Initialize enrolledCourses List
    
    Function login(username, password)
        IF super.login(username, password) AND checkEnrollment() THEN
            RETURN true
        RETURN false
    
    Function takeExam()
        IF isEnrolled AND examAvailable THEN
            Display exam questions
            Record answers

Algorithm Admin EXTENDS User:
    Initialize adminPrivileges
    
    Function login(username, password)
        IF super.login(username, password) AND verifyAdminRights() THEN
            RETURN true
        RETURN false
    
    Function createExam()
        Add questions
        Set time limit
        Assign to courses