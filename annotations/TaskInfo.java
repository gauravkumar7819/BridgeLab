package annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TaskInfo {
    String priority() default "MEDIUM";
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "John")
    public void importantTask() {
        System.out.println("Executing important task");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TaskInfo annotation = TaskManager.class
            .getMethod("importantTask")
            .getAnnotation(TaskInfo.class);
            
        System.out.println("Priority: " + annotation.priority());
        System.out.println("Assigned To: " + annotation.assignedTo());
    }
}