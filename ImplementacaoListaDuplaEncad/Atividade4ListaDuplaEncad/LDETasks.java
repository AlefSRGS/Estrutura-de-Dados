package ImplementacaoListaDuplaEncad.Atividade4ListaDuplaEncad;

public class LDETasks {
    private LDENodeTask firstNodeTask;
    private LDENodeTask lastNodeTask;

    public boolean isEmpty(){
        return firstNodeTask == null && lastNodeTask == null;
    }
    private void insertAfter(LDENodeTask auxNodeTask, LDENodeTask newTask){
        newTask.setNextAdressNode(auxNodeTask.getNextAdressNode());
        newTask.setPreviosAdressNode(auxNodeTask);
        auxNodeTask.getNextAdressNode().setPreviosAdressNode(newTask);
        auxNodeTask.setNextAdressNode(newTask);
    }
    private void insertBefore(LDENodeTask auxNodeTask, LDENodeTask newTask){
        newTask.setNextAdressNode(auxNodeTask);
        newTask.setPreviosAdressNode(auxNodeTask.getPreviosAdressNode());
        auxNodeTask.getPreviosAdressNode().setNextAdressNode(newTask);
        auxNodeTask.setPreviosAdressNode(newTask);
    }
    public void insertTask(String newTaskDescription, int newTaskPriority) {
        LDENodeTask newTask = new LDENodeTask(newTaskDescription, newTaskPriority);
        if (isEmpty()) {
            firstNodeTask = newTask;
            lastNodeTask = newTask;
            return;
        } else if (firstNodeTask.equalsTasks(newTask) || lastNodeTask.equalsTasks(newTask)) {
            System.out.println("Esta tarefa ja existe na lista, não pode ser inserida.");
            return;
        } else if (firstNodeTask.getNextAdressNode() == null && lastNodeTask == firstNodeTask) {
            if (newTask.comparePriorityTasks(firstNodeTask) >= 0) {
                newTask.setNextAdressNode(firstNodeTask);
                firstNodeTask.setPreviosAdressNode(newTask);
                firstNodeTask = newTask;
                return;
            }
            newTask.setPreviosAdressNode(firstNodeTask);
            firstNodeTask.setNextAdressNode(newTask);
            lastNodeTask = newTask;
            return;
        }
        LDENodeTask auxNodeTask = firstNodeTask.getNextAdressNode();
        while (auxNodeTask != null && !auxNodeTask.equalsTasks(newTask)) {
            if(auxNodeTask.getNextAdressNode() == null){
                newTask.setPreviosAdressNode(lastNodeTask);
                lastNodeTask.setNextAdressNode(newTask);
                lastNodeTask = newTask;
                return;
            }
            if (newTask.comparePriorityTasks(auxNodeTask) > 0) {
                insertBefore(auxNodeTask, newTask);
                return;
            } else if (newTask.comparePriorityTasks(auxNodeTask) < 0) {
                insertAfter(auxNodeTask, newTask);
                return;
            }
            auxNodeTask = auxNodeTask.getNextAdressNode();
        }
        System.out.println("Esta tarefa ja existe na lista, não pode ser inserida.");
    }
    public int searchAndCountTasks(String taskDescription) {
        if(isEmpty()){
            System.out.println("Lista de tarefas vazia.");
            return 0;
        }
        LDENodeTask auxNodeTask = firstNodeTask;
        int countTaskInList = 0;
        while(auxNodeTask != null){
            if(auxNodeTask.getDescriptionTask().equals(taskDescription)){
                return countTaskInList;
            }
            countTaskInList++;
            auxNodeTask = auxNodeTask.getNextAdressNode();
        }
        System.out.println("Tarefa não esta na lista");
        return 0;
    }
    public LDENodeTask executeTask(){
        LDENodeTask executedTask = firstNodeTask;
        if(isEmpty()){
            System.out.println("Lista vazia, nada a executar");
            return null;
        } else if(firstNodeTask.getNextAdressNode() == null){
            firstNodeTask = null;
            lastNodeTask = null;
            return executedTask;
        }
        firstNodeTask.getNextAdressNode().setPreviosAdressNode(null);
        firstNodeTask = firstNodeTask.getNextAdressNode();
        return executedTask;
    }
    public LDENodeTask cancelTask(String descriptionCancelledTask){
        LDENodeTask cancelledTask;
        if(isEmpty()){
            System.out.println("Lista vazia, nada a executar");
            return null;
        }if(lastNodeTask.getDescriptionTask().equals(descriptionCancelledTask)){
            cancelledTask = lastNodeTask;
            lastNodeTask = lastNodeTask.getPreviosAdressNode();
            lastNodeTask.setNextAdressNode(null);
            return cancelledTask;
        }
        LDENodeTask auxNodeTask = firstNodeTask;
        while(auxNodeTask!= null){
            if(auxNodeTask.getDescriptionTask().equals(descriptionCancelledTask)){
                if(auxNodeTask.getNextAdressNode() == null){
                    cancelledTask = firstNodeTask;
                    firstNodeTask = null;
                    lastNodeTask = null;
                    return cancelledTask;
                }
                cancelledTask = auxNodeTask;
                auxNodeTask.getNextAdressNode().setPreviosAdressNode(auxNodeTask.getPreviosAdressNode());
                auxNodeTask.getPreviosAdressNode().setNextAdressNode(auxNodeTask.getNextAdressNode());
                return cancelledTask;
            }
            auxNodeTask = auxNodeTask.getNextAdressNode();
        }
        System.out.println("Tarefa não esta na lista");
        return null;
    }
    public void printDescriptionTasksByPriority(int taskPriority){
        LDENodeTask auxNodeTask = firstNodeTask;
        int countTasks = 0;
        if(isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        System.out.println("Task List:");
        while(auxNodeTask!= null){
            if(auxNodeTask.getPriorityTask() == taskPriority){
                countTasks++;
                System.out.println("Description task: " + auxNodeTask.getDescriptionTask());
            }
            auxNodeTask = auxNodeTask.getNextAdressNode();
        }
        System.out.println("Quantidade de tarefas com prioridade "+taskPriority+ "encontradas: "+countTasks);
    }
    public void printAllTasks() {
        if (isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        LDENodeTask auxNodeTask = firstNodeTask;
        System.out.println("Lista de tarefas:");
        while(auxNodeTask!= null){
            System.out.print(auxNodeTask);
            auxNodeTask = auxNodeTask.getNextAdressNode();
        }
    }
    public void changePriorityTaskByDescription(String taskDescription, int newTaskPriority){
        if(isEmpty()){
            System.out.println("Lista vazia.");
            return;
        }
        cancelTask(taskDescription);
        insertTask(taskDescription, newTaskPriority);
        return;
    }
}



