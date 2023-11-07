package Atividade4ListaDuplaEncad;

public class LDENodeTask {
    private LDENodeTask nextAdressNode;



    private LDENodeTask previosAdressNode;
    private final int priorityTask;
    private final String descriptionTask;

    public LDENodeTask(String descriptionTask, int priorityTask) {
        this.descriptionTask = descriptionTask;
        this.priorityTask = priorityTask;
    }

    public LDENodeTask getNextAdressNode() {
        return nextAdressNode;
    }

    public LDENodeTask getPreviosAdressNode() {
        return previosAdressNode;
    }

    public int getPriorityTask() {
        return priorityTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setNextAdressNode(LDENodeTask nextAdressNode) {
        this.nextAdressNode = nextAdressNode;
    }

    public void setPreviosAdressNode(LDENodeTask previosAdressNode) {
        this.previosAdressNode = previosAdressNode;
    }

    public boolean equalsTasks(LDENodeTask otherTask) {
        return getDescriptionTask().equals(otherTask.getDescriptionTask());
    }

    public int comparePriorityTasks(LDENodeTask otherTask) {
        if(getPriorityTask() > otherTask.getPriorityTask()){
            return 1;
        }
        else if (getPriorityTask() < otherTask.getPriorityTask()) {
            return -1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Task data:\n" +
                "Task Description: " + descriptionTask + '\n' +
                "priority: " + priorityTask + "\n";
    }
}
