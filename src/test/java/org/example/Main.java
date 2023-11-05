package org.example;
import java.util.Scanner;

public class Main {
    static Tree tree = new Tree();
    public static void main(String[] args) {
       boolean go = true;

        CreateTree();

        while (go){
            System.out.println("Выберите действие:" + "\n" + "1.Распечатать дерево" + "\n" + "2.Вставить ноду" + "\n" + "3.Удалить ноду" + "\n" + "4.Найти узел по значению"
                    + "\n" + "5.API");

            Scanner sc = new Scanner(System.in);
            int doIt = Integer.parseInt(sc.next());

            if (doIt == 1) {
                tree.printTree();
            }
            if (doIt == 2) {
                System.out.println("Введите ноду для вставки");
                int NodeForInsert = Integer.parseInt(sc.next());
                tree.insertNode(NodeForInsert);
            }
            if (doIt == 3) {
                System.out.println("Введите ноду для удаления");
                int NodeForDelete = Integer.parseInt(sc.next());
                tree.deleteNode(NodeForDelete);
            }
            if (doIt == 4) {
                System.out.println("Введите значение для поиска ноды WARNING НАХОДИТСЯ В РАЗРАБОТКЕ");
                int NodeToFind = Integer.parseInt(sc.next());
                tree.findNodeByValue(NodeToFind);
            }
            if (doIt == 5) {
                System.out.println("Выберите действие: 1 - Получение пути, 2 - Добавление пути, 3 - Удаление пути");
                int doPath = Integer.parseInt(sc.next());
                if(doPath == 1){
                    Apicall.getRequest();
                }
                if(doPath == 2) {
                    System.out.println("Какой путь сохранить?");
                    String pathNumber = sc.next();
                    Apicall.updateRequest(pathNumber);
                }
                if(doPath == 3) {
                    Apicall.deleteRequest();
                }
                if(doPath == 4) {

                }
            }
            if (doIt == 6) {
                go = false;
            }
        }
    }

    public static void CreateTree(){
        tree.insertNode(10);
        tree.insertNode(5);
        tree.insertNode(15);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(14);
        tree.insertNode(20);

    }
}
