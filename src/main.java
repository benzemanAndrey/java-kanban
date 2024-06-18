import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        System.out.println("***test system***");
        //Create Task
        Task task1 = new Task("Заплатить за интернет.", "Не забыть заплатить за интернет.");
        Task task2 = new Task("Сходить в магазин.", "Ходить в магазин нужно каждый день.");
        taskManager.createNewTask(task1);
        taskManager.createNewTask(task2);

        //Create Epic
        Epic epic3 = new Epic("Переехать в другой город.", "Поискать место , куда переехать.");
        Epic epic4 = new Epic("Купить новую квартиру.", "Мало место, нужна квартира побольше.");
        taskManager.createNewEpic(epic3);
        taskManager.createNewEpic(epic4);

        //Create Subtask
        Subtask subtask5 = new Subtask("Зайти на сайты городов", "Поискать лучшее место", 3);
        Subtask subtask6 = new Subtask("Попросить знакомых", "Надо что бы помогли с переездом", 3);
        Subtask subtask7 = new Subtask("Взять ипотеку", "Рассчитать стоимость ипотеки для новой квартиры", 4);
        taskManager.createNewSubtask(subtask5);
        taskManager.createNewSubtask(subtask6);
        taskManager.createNewSubtask(subtask7);

        //Create id subtask for epic
        ArrayList<Integer> subtaskIdsForEpic3 = epic3.getSubtaskIds();
        subtaskIdsForEpic3.add(subtask5.getId());
        subtaskIdsForEpic3.add(subtask6.getId());
        ArrayList<Integer> subtaskIdsForEpic4 = epic4.getSubtaskIds();
        subtaskIdsForEpic4.add(subtask7.getId());

        //see Task,Subtask,epic
        taskManager.getListOfTasks();
        taskManager.getListOfEpics();
        taskManager.getListOfSubtasks();

        //Look by ID
        taskManager.getTaskById(task1.getId());
        taskManager.getEpicById(epic4.getId());
        taskManager.getSubtaskById(subtask7.getId());

        //Look by ID epic for subtask
        System.out.println(taskManager.getListOfSubtasksByOneEpic(epic3.getId()));

        //Update task name and status
        Task updateTask3 = new Task("Task", "432", task1.getId(), "IN_PROGRESS");
        taskManager.updateTheTask(updateTask3, task1.getId());

        //Update epic
        Epic updateEpic3 = new Epic("Epic", "12513", epic3.getId(), epic3.getStatus(), epic3.getSubtaskIds());
        taskManager.updateTheEpic(updateEpic3, epic3.getId());

        //Update subtask
        Subtask updateSubtask5 = new Subtask("Subtask",
                "1123523", subtask5.getId(),"IN_PROGRESS", 3);
        taskManager.updateTheSubtask(updateSubtask5, subtask5.getId());

        //Deleting by task ID, subtask, epic***");
        taskManager.removeTaskById(task1.getId());
        taskManager.removeEpicById(epic4.getId());
        taskManager.removeSubtaskById(subtask6.getId());

        //Deleting all
        taskManager.removeAllTasks();
        taskManager.removeAllSubtasks();
        taskManager.removeAllEpics();
    }
}
