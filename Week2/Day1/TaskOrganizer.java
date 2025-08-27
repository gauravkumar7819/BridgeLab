Algorithm TaskManager:
    Initialize taskMap as LinkedHashMap<Integer, String>
    Initialize taskIdCounter = 1
    
    Function addTask(description):
        IF description not empty THEN
            taskMap.put(taskIdCounter, description)
            INCREMENT taskIdCounter
            RETURN true
        RETURN false
    
    Function removeTask(taskId):
        IF taskMap.containsKey(taskId) THEN
            taskMap.remove(taskId)
            RETURN true
        RETURN false
    
    Function displayTasks():
        FOR each entry in taskMap
            PRINT taskId + ": " + description